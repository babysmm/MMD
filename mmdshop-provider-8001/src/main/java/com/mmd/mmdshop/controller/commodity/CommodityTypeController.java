package com.mmd.mmdshop.controller.commodity;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.CommodityTypeDO;
import com.mmd.mmdshop.service.commodity.CommodityTypeService;

/**
 * 
 * @ClassName CommodityController.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@RestController
public class CommodityTypeController<T>{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommodityTypeService service;
	
	@PostMapping("/provider/getCommodityType")
	public List<CommodityTypeDO> findCommodityTypeAll() {
		return service.findCommodityTypeAll();
	}
}
