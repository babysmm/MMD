package com.mmd.mmdshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.result.member.MemberIndexInitResult;
import com.mmd.mmdshop.services.MemberService;

@RestController
public class WXMemberIndexController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberService service;
	
	/**
	 * 首页初始化数据
	 * @param code 小程序code
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/provider/memberIndexInit")
	public MemberIndexInitResult memberIndexInit() throws Exception {
		return service.findMemberIndexInitResult();
	}
}
