package com.mmd.mmdshop.mapper.shop;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.shop.ShopInitResult;
import com.mmd.mmdshop.result.shop.ShopResult;

@Mapper
public interface ShopMapper extends BaseMapper<ShopDO>{
	
	/**
	 * 
	 * @param result
	 * @return
	 */
	ShopResult selectShopMe(ShopInitResult result);
	
}
