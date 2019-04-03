package com.mmd.mmdshop.controller.market;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.CommodityStaffRrsult;
import com.mmd.mmdshop.result.market.MarketOperationResult;
import com.mmd.mmdshop.utils.NoRepeatSubmit;
import com.mmd.mmdshop.utils.ParamValidation;

/**
 * 
 * @ClassName ShopStaffController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class ShopStaffController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ParamValidation pv;
	
	/**
	 * 收银员登录
	 * @throws JSONException 
	 */
	@PostMapping("/consumer/staffUserLogin")
	@NoRepeatSubmit
	public String staffUserLogin(ShopStaffDO shopStaffDO,HttpServletRequest httpServletRequest) throws IOException, JSONException {
		
		//账号密码null判断
		if (pv.isNotNull(shopStaffDO, "username", "password") == false) {
			return null;		
		}
		
		//设置IP地址
		shopStaffDO.setLastIpS(httpServletRequest);
		
		ShopStaffDO staffDO = template.postForObject(ADMINUSERPROVIDER_URL+"/staffUserLogin", shopStaffDO, ShopStaffDO.class);
		
		if(staffDO == null) return null;
		
		this.setLoginSession(staffDO, httpServletRequest);
					
		return staffDO.getFullName();
	}
	
	/**
	 * 收银店长登录
	 * @throws JSONException 
	 */
	@PostMapping("/consumer/staffUserTLogin")
	@NoRepeatSubmit
	public String staffUserTLogin(ShopStaffDO shopStaffDO,HttpServletRequest httpServletRequest) throws IOException, JSONException {
		
		//账号密码null判断
		if (pv.isNotNull(shopStaffDO, "username", "password") == false) {
			return null;		
		}
		
		//设置IP地址
		shopStaffDO.setLastIpS(httpServletRequest);
		
		ShopStaffDO staffDO = template.postForObject(ADMINUSERPROVIDER_URL+"/staffUserLogin", shopStaffDO, ShopStaffDO.class);
		
		if(staffDO == null) return null;
		
		if(staffDO.getType() == 2) return null;
		
		this.setLoginSession(staffDO, httpServletRequest);
		
		//设置shopId
		httpServletRequest.getSession().setAttribute("shopId", staffDO.getShopId());
					
		return staffDO.getFullName();
	}
	
	/**
	 * 查询条形码
	 * @param barCode
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/consumer/searchCommodity")
	@NoRepeatSubmit
	public CommodityStaffRrsult searchCommodity(@NotNull Long barCode) throws IOException {
		System.out.println(barCode);
		return template.postForObject(ADMINUSERPROVIDER_URL+"/searchCommodity", barCode, CommodityStaffRrsult.class);
	}
	
	/**
	 * 通过用户全名查询店员
	 * @param fullName 全名
	 * @return
	 */
	@PostMapping("/consumer/findShopStaffByfullName")
	public ShopStaffDO findShopStaffByfullName(String fullName) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/findShopStaffByfullName", fullName, ShopStaffDO.class);
	}
	
	/**
	 * 通过用户名查询店员
	 * @param username 用户名
	 * @return
	 */
	@PostMapping("/consumer/findShopStaffByusername")
	public ShopStaffDO findShopStaffByusername(String username) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/findShopStaffByusername", username, ShopStaffDO.class);
	}
	
	/**
	 * 增加店员
	 * @param shopStaffDO
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/consumer/addShopStaff")
	public boolean addShopStaff(@RequestBody MarketOperationResult result,HttpServletRequest httpServletRequest) throws IOException {
		
		ShopStaffDO shopStaffDO = result.getShopStaffDO();
		Integer code = result.getCode();
		
		//邮箱验证码验证
		if(this.emailCodeVerify(code, httpServletRequest) == false) {
			return false;
		}
		
		//设置IP
		shopStaffDO.setLastIpS(httpServletRequest);
		
		//设置shop_id
		shopStaffDO.setShopId((Integer)(httpServletRequest.getSession().getAttribute("shopId")));
		
		System.out.println(result);
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/addShopStaff", shopStaffDO, boolean.class);
	}
	
	/**
	 * 修改店员
	 * @param shopStaffDO
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/consumer/modifyShopStaff")
	public boolean modifyShopStaff(@RequestBody MarketOperationResult result,HttpServletRequest httpServletRequest) throws IOException {
		ShopStaffDO shopStaffDO = result.getShopStaffDO();
		Integer code = result.getCode();
		
		//邮箱验证码验证
		if(this.emailCodeVerify(code, httpServletRequest) == false) {
			return false;
		}
		
		System.out.println(shopStaffDO);
		
		//设置IP
		shopStaffDO.setLastIpS(httpServletRequest);
		return template.postForObject(ADMINUSERPROVIDER_URL+"/modifyShopStaff", shopStaffDO, boolean.class);
	}
	
	/**
	 * 删除店员
	 * @param shopStaffDO 
	 * @return
	 */
	@PostMapping("/consumer/removeShopStaff")
	public boolean removeShopStaff(@RequestBody MarketOperationResult result,HttpServletRequest httpServletRequest) {
		ShopStaffDO shopStaffDO = result.getShopStaffDO();
		Integer code = result.getCode();
		
		//邮箱验证码验证
		if(this.emailCodeVerify(code, httpServletRequest) == false) {
			return false;
		}
		
		System.out.println(shopStaffDO);
		
		//设置shopId
		shopStaffDO.setShopId((Integer) httpServletRequest.getSession().getAttribute("shopId"));
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/removeShopStaff", shopStaffDO, boolean.class);
	}
	
	/**
	 * 获取邮箱验证码
	 * @return
	 */
	@PostMapping("/consumer/sendEmailCode")
	public boolean getEmailCode(HttpServletRequest httpServletRequest) {
		
		Integer sessionEmilCode = (Integer) httpServletRequest.getSession().getAttribute("emailCode");
		
		//判断是否被按过了
		if(sessionEmilCode != null) {
			return false;
		}
		
		Integer code = template.postForObject(ADMINUSERPROVIDER_URL+"/sendEmailCode", httpServletRequest.getSession().getAttribute("userId"),Integer.class);
		
		if(code == null) {
			return false;
		}else {
			httpServletRequest.getSession().setAttribute("emailCode", code);
			return true;
		}
		
	}
	
	/**
	 * 邮箱验证码验证
	 * @param code 用户输入代码
	 * @param httpServletRequest session存储的emailCode
	 * @return 
	 */
	public boolean emailCodeVerify(Integer code,HttpServletRequest httpServletRequest) {
		
		Integer ecode = (Integer)httpServletRequest.getSession().getAttribute("emailCode");
		
		if(ecode != null || code.equals(ecode) == true) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 登录设置session
	 */
	private void setLoginSession(ShopStaffDO shopStaffDO,HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		
		//设置session的userId
		session.setAttribute("userId", shopStaffDO.getShopStaffId());
		//设置session的shopId
		session.setAttribute("shopId", shopStaffDO.getShopId());
		//设置session的type
		session.setAttribute("shopStaffType", shopStaffDO.getType());
	}
}
