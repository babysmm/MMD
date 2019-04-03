package com.mmd.mmdshop.controller.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.result.shop.ShopTalkResult;
import com.mmd.mmdshop.services.ShopTalkService;

@RestController
public class ShopTalkController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopTalkService service;
	
	/**
	 * 获取商店评论
	 * @param code 小程序code
	 * @return
	 */
	@PostMapping("/provider/findShopTalk")
	public ShopTalkResult findShopTalk(@RequestBody Integer shopId) {
		return service.findShopTalk(shopId);
	}
}
