package com.mmd.mmdshop.controller.commodity;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.result.CommodityAll;
import com.mmd.mmdshop.result.CommodityRough;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.commodity.CommodityBasic;
import com.mmd.mmdshop.service.commodity.CommodityService;

/**
 * 
 * @ClassName CommodityController.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@RestController
public class CommodityController<T>{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommodityService service;
	
	@PostMapping("/provider/findCommodityRough")
	public List<CommodityRough> findCommodityRough(@RequestBody String name) {
		//System.out.println(name);
		return service.findCommodityRoughByName(name);
	}
	
	@PostMapping("/provider/findCommodityAll")
	public CommodityAll findCommodityAll(@RequestBody Integer id) {
		return service.findCommodityAllById(id);
	}
	
	/**
	 * 补货
	 * @param mode
	 * @return
	 */
	@PostMapping("/provider/replenishmentCommodityNumber")
	public List<CommodityDO> replenishmentCommodityNumber(@RequestBody Integer shopId) {
		return service.replenishmentCommodityNumber(shopId);
	}
	
	/**
	 * 增加商品
	 * 
	 * @param commodityBasic
	 * @return
	 */
	@PostMapping("/provider/addCommodity")
	public QiNiuResult addCommodityDO(@RequestBody CommodityDO commodityDO) {
		return service.addCommodityBasic(commodityDO);
	}
	
	/**
	 * 通过商品条形码搜索单个商品
	 * 
	 * @param commodityIdentity
	 * @return
	 */
	@PostMapping("/provider/searchCommodityDOByBarCode")
	public CommodityBasic searchCommodityDOByBarCode(@RequestBody Integer commodityIdentity) {
		return service.findCommodityByBarCode(commodityIdentity);
	}
	
	/**
	 * 通过商品名称搜索单个商品
	 * 
	 * @param commodityIdentity
	 * @return
	 */
	@PostMapping("/provider/searchCommodityDOByName")
	public CommodityBasic searchCommodityDOByName(@RequestBody String commodityIdentity) {
		return service.findCommodityByName(commodityIdentity);
	}
	
	/**
	 * 通过商品Id搜索单个商品
	 * 
	 * @param commodityIdentity
	 * @return
	 */
	@PostMapping("/provider/searchCommodityDOById")
	public CommodityDO searchCommodityDOById(@RequestBody Integer commodityIdentity) {
		
		System.out.println(commodityIdentity);
		
		return null;
	}
}
