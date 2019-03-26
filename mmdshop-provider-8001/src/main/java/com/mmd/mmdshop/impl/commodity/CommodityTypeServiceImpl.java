package com.mmd.mmdshop.impl.commodity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.CommodityTypeDO;
import com.mmd.mmdshop.mapper.commodity.CommodityTypeMappper;
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
public class CommodityTypeServiceImpl implements CommodityTypeService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommodityTypeMappper mapper;

	@Override
	public List<CommodityTypeDO> findCommodityTypeAll() {
		QueryWrapper<CommodityTypeDO> queryWrapper = new QueryWrapper<CommodityTypeDO>();
		queryWrapper.select("comm_type_id","type");
		return mapper.selectList(queryWrapper);
	}
}
