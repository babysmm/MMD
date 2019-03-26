package com.mmd.mmdshop.impl.commodity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.CommodityBrandDO;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.CommodityTypeDO;
import com.mmd.mmdshop.mapper.commodity.CommodityBrandMapper;
import com.mmd.mmdshop.mapper.commodity.CommodityTypeMappper;
import com.mmd.mmdshop.service.commodity.CommodityBrandService;
import com.mmd.mmdshop.service.commodity.CommodityTypeService;

/**
 * 
 * @ClassName CommodityServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout=10)
@Service
public class CommodityBrandServiceImpl implements CommodityBrandService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommodityBrandMapper mapper;

	@Override
	public List<CommodityBrandDO> findCommodityBrandDOList(Long shopId) {
		QueryWrapper<CommodityBrandDO> wrapper = new QueryWrapper<CommodityBrandDO>();
		wrapper.select("name","address").eq("shop_id", shopId).eq("state", 1);
		return mapper.selectList(wrapper);
	}

	@Override
	public boolean addCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return mapper.inserCommodityBrand(commodityBrandDO);
	}

	@Override
	public boolean modityCommodityBrand(CommodityBrandDO commodityBrandDO) {
		return mapper.upCommodityBrand(commodityBrandDO);
	}

	@Override
	public boolean removeCommodityBrand(Long brandId, Long shopId) {
		return mapper.deleteCommodityBrand(brandId,shopId);
	}

	
}
