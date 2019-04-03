package com.mmd.mmdshop.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.mapper.commodity.CommodityMappper;
import com.mmd.mmdshop.mapper.shop.ShopMapper;
import com.mmd.mmdshop.result.shop.ShopInitResult;
import com.mmd.mmdshop.result.shop.ShopResult;
import com.mmd.mmdshop.services.ShopService;

@Transactional(timeout=10)
@Service
public class ShopServiceImpl implements ShopService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopMapper mapper;
	
	@Autowired
	private CommodityMappper commodityMapper;

	@Override
	public ShopResult memberShopInit(ShopInitResult receive) {
		ShopResult result = mapper.selectShopMe(receive);
		QueryWrapper<CommodityDO> commWrapper = new QueryWrapper<CommodityDO>();
		commWrapper.select("commodity_id","keywords","thumb","name","is_new","is_good","is_hot","is_on_sale","trade_price","month_sales")
			.eq("comm_type_id", receive.getTypeId()).eq("shop_id", receive.getShopId());
		
		result.setCommodity(commodityMapper.selectList(commWrapper));
		
		return result;
	}

	@Override
	public List<CommodityDO> memberChooseType(ShopInitResult result) {
		QueryWrapper<CommodityDO> commWrapper = new QueryWrapper<CommodityDO>();
		commWrapper.select("commodity_id","keywords","thumb","name","is_new","is_good","is_hot","is_on_sale","trade_price","month_sales")
			.eq("comm_type_id", result.getTypeId()).eq("shop_id", result.getShopId());
		return commodityMapper.selectList(commWrapper);
	}

}
