package com.mmd.mmdshop.controller.commodity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mmd.mmdshop.dbdo.CommodityBrandDO;

/**
 * 
 * @ClassName CommodityBrandController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class CommodityBrandController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
	/**
	 * 获取很多品牌信息
	 * @param httpServletRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/findCommodityBrandDOList")
	public List<CommodityBrandDO> findCommodityBrandDOList(HttpServletRequest httpServletRequest) {
		//获取shopID
		Long shopId = (Long) httpServletRequest.getSession().getAttribute("shopId");
		return template.postForObject(ADMINUSERPROVIDER_URL + "/findCommodityBrandDOList", shopId, List.class);
	}
	
	@PostMapping("/consumer/addCommodityBrand")
	public boolean addCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/addCommodityBrand", commodityBrandDO, boolean.class);
	}

	@PostMapping("/consumer/modityCommodityBrand")
	public boolean modityCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/modityCommodityBrand", commodityBrandDO, boolean.class);
	}

	@PostMapping("/consumer/removeCommodityBrand")
	public boolean removeCommodityBrand(CommodityBrandDO commodityBrandDO,HttpServletRequest httpServletRequest) {
		//获取shopID
		Long shopId = (Long) httpServletRequest.getSession().getAttribute("shopId");
		commodityBrandDO.setShopId(shopId);
		return template.postForObject(ADMINUSERPROVIDER_URL + "/removeCommodityBrand", commodityBrandDO, boolean.class);
	}
}
