package com.mmd.mmdshop.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.member.MemberIndexInitResult;

@RestController
public class WXMemberIndexController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8002/provider";
	
	@Autowired
	private RestTemplate template;

	
	/**
	 * 首页初始化数据
	 * @param code 小程序code
	 * @return
	 */
	@PostMapping("/consumer/memberIndexInit")
	public MemberIndexInitResult memberIndexInit() {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/memberIndexInit", null, MemberIndexInitResult.class);
	}
}
