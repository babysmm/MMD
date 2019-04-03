package com.mmd.mmdshop.services;

import com.mmd.mmdshop.result.shop.ShopTalkResult;

public interface ShopTalkService {
	/**
	 * 获取商店评论
	 * @param result
	 * @return
	 */
	ShopTalkResult findShopTalk(Integer shopId);
}
