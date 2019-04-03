package com.mmd.mmdshop.controller.shop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.result.shop.ShopInitResult;
import com.mmd.mmdshop.result.shop.ShopResult;
import com.mmd.mmdshop.services.ShopService;

@RestController
public class ShopController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopService service;
	
	/**
	 * 商店页面初始化
	 * @param code 小程序code
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/provider/memberShopInit")
	public ShopResult memberShopInit(@RequestBody ShopInitResult result) throws Exception {
		return service.memberShopInit(result);
	}
	
	/**
	 * 会员选择类型
	 * @param result
	 * @return
	 */
	@PostMapping("/provider/memberChooseType")
	public List<CommodityDO> memberChooseType(@RequestBody ShopInitResult result) {
		return service.memberChooseType(result);
	}
}
