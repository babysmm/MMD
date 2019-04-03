package com.mmd.mmdshop.controller.shop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.result.shop.ShopInitResult;
import com.mmd.mmdshop.result.shop.ShopResult;

@RestController
public class ShopController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8002/provider";
	
	@Autowired
	private RestTemplate template; 
	
	/**
	 * 商店页面初始化
	 * @param code 小程序code
	 * @return
	 */
	@PostMapping("/consumer/memberShopInit")
	public ShopResult memberShopInit(@RequestBody ShopInitResult result) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/memberShopInit", result, ShopResult.class);
	}
	
	/**
	 * 会员选择类型
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/memberChooseType")
	public List<CommodityDO> memberChooseType(@RequestBody ShopInitResult result) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/memberChooseType", result, List.class);
	}
}
