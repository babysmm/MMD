package com.mmd.mmdshop.controller.member;


import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mmd.mmdshop.result.member.WXUserInfo;

import net.sf.json.JSONObject;

/**
 * 
 * @author MM
 *
 */
@RestController
public class WXMemberLoginController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8002/provider";
	
	@Autowired
	private RestTemplate template;

	
	/**
	 * 会员小程序登录
	 * @param code 小程序code
	 * @return
	 */
	@PostMapping("/consumer/memberLogin")
	public String memberLogin(@RequestBody String code,HttpServletRequest request) {
		if(code == null)return null;
		
		JSONObject result = this.getSessionKeyOrOpenId(code, template);
		
		JSONObject backresult = template.postForObject(ADMINUSERPROVIDER_URL+"/memberLogin", result, JSONObject.class);
		
		String mySessionkey = (String) backresult.get("mySessionkey");
		
		if(result == null) {
			return null;
		}
		
		request.getSession().setAttribute("openID", result.get("openid"));
		request.getSession().setAttribute("memberID", backresult.get("memberID"));
		
		return mySessionkey;
	}
	
	/**
	 * 会员提交信息
	 * @param userInfo
	 * @param request
	 * @return
	 */
	@PostMapping("/consumer/memberUserInfo")
	public boolean memberUserInfo(@RequestBody WXUserInfo userInfo,HttpServletRequest request) {
		//设置id
		userInfo.setMemberId((String) request.getSession().getAttribute("memberID"));
		return template.postForObject(ADMINUSERPROVIDER_URL+"/memberUserInfo", userInfo, boolean.class);
	}
	
	/**
	 * 获取用户openID和sessionKey
	 * @param code 客户端发来的code
	 * @param template RestTemplate对象
	 * @return 腾讯服务器返回对象
	 */
	private JSONObject getSessionKeyOrOpenId(String code,RestTemplate template){
	    String appid = "wx36e5740b8e4b9fc5";
	    String secret = "25c1228ee64b62fd006784f661520e50";
	    code = JSONObject.fromObject(code).getString("code");
	    
	    String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
	    
	    return JSONObject.fromObject(template.getForObject(url, String.class));
	}
}
