package com.mmd.mmdshop.service.market;

import java.util.List;
import com.mmd.mmdshop.dbdo.ShopMarketDO;
import com.mmd.mmdshop.result.MarketResult;

/**
 * 
 * 
 * @author MM
 * @ClassName shopMarketService.java
 * @version 1.0
 * @date 2019/2/18
 */
public interface shopMarketService {
	/**
	 * 新增加商店商品订单
	 * @param marketResult
	 * @return
	 */
	Long addCommodityOrder(MarketResult marketResult);
	
	/**
	 * 通过订单ID更改是不是欠账
	 * @param marketOrderId
	 * @return
	 */
	boolean modifyState(Long marketOrderId);
	
	/**
	 * 获取销售订单
	 * @param date 
	 * @return
	 */
	List<ShopMarketDO> findShopMarket(int mode);
	
	/**
	 * 获取时间段的销售订单
	 * @param date 
	 * @return
	 */
	List<ShopMarketDO> findTimeShopMarket(String start,String end);
	
	
}
