package com.mmd.mmdshop.services;

import java.util.List;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.result.shop.ShopInitResult;
import com.mmd.mmdshop.result.shop.ShopResult;

public interface ShopService {
	/**
	 * 点击商品后展示商店页面
	 * @param result
	 * @return
	 */
	ShopResult memberShopInit(ShopInitResult result);
	
	/**
	 * 点击商品后展示商店页面
	 * @param result
	 * @return
	 */
	List<CommodityDO> memberChooseType(ShopInitResult result);
}
