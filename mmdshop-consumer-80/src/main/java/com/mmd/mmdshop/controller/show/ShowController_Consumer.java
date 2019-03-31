package com.mmd.mmdshop.controller.show;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.show.ShowResult;
import net.sf.json.JSONObject;

/**
 * 
 * @author MM
 *
 */
@RestController
public class ShowController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8002/provider";
	
	@Autowired
	private RestTemplate template;

	/**
	 * 获取最新秀
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/getNewShowMessage")
	public List<ShowResult> getNewShowMessage(HttpServletRequest request) {
		
		Integer memberID = Integer.parseInt(request.getSession().getAttribute("memberID").toString());
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/getNewShowMessage", memberID, List.class);
	}
	
	/**
	 * 秀点赞
	 * @param 
	 * @return
	 */
	@PostMapping("/consumer/showGood")
	public boolean showGood(@RequestBody String result,HttpServletRequest request) {
		JSONObject re = new JSONObject();
		
		re.put("showId", JSONObject.fromObject(result).getInt("showId"));
		re.put("memberId", Integer.parseInt((String)request.getSession().getAttribute("memberID")));

		return template.postForObject(ADMINUSERPROVIDER_URL+"/showGood", re, boolean.class);
	}
	
	/**
	 * 增加show
	 * @param 
	 * @return
	 */
	@PostMapping("/consumer/addNewShow")
	public QiNiuResult addNewShow(@RequestBody ShowResult result,HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		result.setUserId(Integer.parseInt(session.getAttribute("memberID").toString()));
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/addNewShow", result, QiNiuResult.class);
	}
}
