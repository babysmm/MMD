package com.mmd.mmdshop.controller.commodity;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.commodity.CommodityBasic;

/**
 * 
 * @ClassName CommodityController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class CommodityController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
	/**
	 * 补货
	 * @param marketResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/replenishmentCommodityNumber")
	public List<CommodityDO> replenishmentCommodityNumber() {
		Integer shopId = 1;
		return template.postForObject(ADMINUSERPROVIDER_URL+"/replenishmentCommodityNumber", shopId, List.class);
	}
	
	
	/**
	 * 增加商品
	 * 
	 * @param commodityDO
	 * @return
	 */
	@PostMapping("/consumer/addCommodity")
	public QiNiuResult addCommodityDO(@RequestBody CommodityDO commodityDO) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/addCommodity", commodityDO, QiNiuResult.class);
	}
	
	/**
	 * 通过商品条形码搜索单个商品
	 * 
	 * @param commodityIdentity
	 * @return
	 */
	@PostMapping("/consumer/searchCommodityDOByBarCode")
	public CommodityBasic searchCommodityDOByBarCode(Integer commodityIdentity) {
		
		System.out.println(commodityIdentity);
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/searchCommodityDOByBarCode", commodityIdentity, CommodityBasic.class);
	}
	
	/**
	 * 通过商品名称搜索单个商品
	 * 
	 * @param commodityIdentity
	 * @return
	 */
	@PostMapping("/consumer/searchCommodityDOByName")
	public CommodityBasic searchCommodityDOByName(String commodityIdentity) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/searchCommodityDOByName", commodityIdentity, CommodityBasic.class);
	}
	
	/**
	 * 通过商品Id搜索单个商品
	 * 
	 * @param commodityIdentity
	 * @return
	 */
	@PostMapping("/consumer/searchCommodityDOById")
	public CommodityBasic searchCommodityDOById(Integer commodityIdentity) {
		
		System.out.println(commodityIdentity);
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/searchCommodityDOById", commodityIdentity, CommodityBasic.class);
	}
	
	@PostMapping("/consumer/modifyCommodity")
	public QiNiuResult modifyCommodity() {
		return null;
	}
}
