package com.mmd.mmdshop.controller.show;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.dbdo.ShowDDO;
import com.mmd.mmdshop.result.member.MemberIndexInitResult;

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
	public List<ShowDDO> getNewShowMessage() {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/getNewShowMessage", null, List.class);
	}
	
}
