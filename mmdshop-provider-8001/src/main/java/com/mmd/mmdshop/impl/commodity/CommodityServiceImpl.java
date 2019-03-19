package com.mmd.mmdshop.impl.commodity;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.mapper.commodity.CommodityImgMapper;
import com.mmd.mmdshop.mapper.commodity.CommodityMappper;
import com.mmd.mmdshop.result.CommodityAll;
import com.mmd.mmdshop.result.CommodityRough;
import com.mmd.mmdshop.result.commodity.CommodityBasic;
import com.mmd.mmdshop.service.commodity.CommodityService;
import com.mmd.mmdshop.utils.QiNiuYunUtils;

/**
 * 
 * @ClassName CommodityServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout=10)
@Service
public class CommodityServiceImpl implements CommodityService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CommodityMappper mapper;
	
	@Autowired
	private QiNiuYunUtils qiniu;
	
	@Override
	public List<CommodityRough> findCommodityRoughByName(String name) {
		return mapper.selectCommodityRoughByName(name);
	}
	
	@Override
	public CommodityAll findCommodityAllById(Integer id) {
		return mapper.selectCommodityAllById(id);
	}

	@Override
	public List<CommodityDO> replenishmentCommodityNumber(Integer shopId) {
		QueryWrapper<CommodityDO> commWrapper = new QueryWrapper<CommodityDO>();
		commWrapper.select("name","number","max_number","min_number").eq("shop_id", shopId);
		
		List<CommodityDO> db = mapper.selectList(commWrapper);
		List<CommodityDO> result = new ArrayList<CommodityDO>();
		
		for(int i=0;i<db.size();i++) {
			CommodityDO commodityDO = db.get(i);
			int minNumber = commodityDO.getMinNumber();
			int maxNumber = commodityDO.getMaxNumber();
			int number = commodityDO.getNumber();
			
			if(number < minNumber) {
				commodityDO.setNumber(maxNumber-number);
				result.add(commodityDO);
			}
		}
		
		System.out.println(result);
		
		return result;
	}

	@Override
	public String addCommodityBasic(CommodityDO commodityDO) {
		
		System.out.println(commodityDO);
		
		Integer commodity = mapper.insert(commodityDO);
		
		
		//生成上传码
		String token = qiniu.jsUploadToken("mmdshop", "123456", 3600);
		
		System.out.println(token);
		
		return token;
	}

}
