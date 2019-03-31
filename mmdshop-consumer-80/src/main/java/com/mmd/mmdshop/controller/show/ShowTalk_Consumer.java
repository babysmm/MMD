package com.mmd.mmdshop.controller.show;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.show.ShowTalkMemberResult;
import com.mmd.mmdshop.result.show.ShowTalkResult;
import net.sf.json.JSONObject;

/**
 * 
 * @author MM
 *
 */
@RestController
public class ShowTalk_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8002/provider";
	
	@Autowired
	private RestTemplate template;

	/**
	 * 获取最新show的评论
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/getShowTalk")
	public List<ShowTalkResult> getShowTalk(@RequestBody String memberId) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/getShowTalk",Integer.parseInt(JSONObject.fromObject(memberId).get("memberId").toString()) , List.class);
	}
	
	@PostMapping("/consumer/addNewShowTalk")
	public boolean addNewShowTalk(@RequestBody ShowTalkMemberResult result,HttpServletRequest request) {
		result.setMemberId(Integer.parseInt(request.getSession().getAttribute("memberID").toString()));
		return template.postForObject(ADMINUSERPROVIDER_URL+"/addNewShowTalk",result, boolean.class);
	}
}
