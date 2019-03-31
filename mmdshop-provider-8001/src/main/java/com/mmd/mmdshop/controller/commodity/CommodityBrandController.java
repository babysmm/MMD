package com.mmd.mmdshop.controller.commodity;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.CommodityBrandDO;
import com.mmd.mmdshop.service.commodity.CommodityBrandService;

/**
 * 
 * @ClassName CommodityBrandController.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@RestController
public class CommodityBrandController<T>{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @param shopId
	 * @return
	 */
	@Autowired
	private CommodityBrandService service;
	
	/**
	 * 获取很多品牌信息
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("/provider/findCommodityBrandDOList")
	public List<CommodityBrandDO> findCommodityBrandDOList(@RequestBody Integer shopId) {
		return service.findCommodityBrandDOList(shopId);
	}
	
	@PostMapping("/provider/addCommodityBrand")
	public boolean addCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return service.addCommodityBrand(commodityBrandDO);
	}

	@PostMapping("/provider/modityCommodityBrand")
	public boolean modityCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return service.modityCommodityBrand(commodityBrandDO);
	}

	@PostMapping("/provider/removeCommodityBrand")
	public boolean removeCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return service.removeCommodityBrand(commodityBrandDO.getBrandId(), commodityBrandDO.getShopId());
	}
}
