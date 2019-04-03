package com.mmd.mmdshop.controller.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.shop.ShopTalkResult;

@RestController
public class ShopTalkController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8002/provider";
	
	@Autowired
	private RestTemplate template; 
	
	/**
	 * 获取商店评论
	 * @param code 小程序code
	 * @return
	 */
	@PostMapping("/consumer/findShopTalk")
	public ShopTalkResult findShopTalk(@RequestBody Integer shopId) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/findShopTalk", shopId, ShopTalkResult.class);
	}
}
