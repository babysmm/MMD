package com.mmd.mmdshop.controller.market;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.ShopMarketDO;
import com.mmd.mmdshop.result.MarketResult;
import com.mmd.mmdshop.service.market.shopMarketService;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName ShopMarketController.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@RestController
public class ShopMarketController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private shopMarketService service;
	
	/**
	 * 新建订单
	 * @param marketResult
	 * @return
	 */
	@PostMapping("/provider/newCommodityOrder")
	public Long newCommodityOrder(@RequestBody MarketResult marketResult) {
		return service.addCommodityOrder(marketResult);
	}
	
	/**
	 * 修改状态(欠账,完成)
	 * @param marketOrderId
	 * @return
	 */
	@PostMapping("/provider/changeState")
	public boolean changeState(@RequestBody Long marketOrderId) {
		return service.modifyState(marketOrderId);
	}
	
	/**
	 * 通过模式搜索定单
	 * @param mode
	 * @return
	 */
	@PostMapping("/provider/findShopMarket")
	public List<ShopMarketDO> findShopMarket(@RequestBody int mode) {
		return service.findShopMarket(mode);
	}
	
	/**
	 * 通过时间段搜索定单
	 * @param mode
	 * @return
	 */
	@PostMapping("/provider/findTimeShopMarket")
	public List<ShopMarketDO> findTimeShopMarket(JSONObject json) {
		return service.findTimeShopMarket(json.getString("start"), json.getString("end"));
	}
}
