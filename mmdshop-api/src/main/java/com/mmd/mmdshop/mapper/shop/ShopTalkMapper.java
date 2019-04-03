package com.mmd.mmdshop.mapper.shop;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.shop.ShopTalkResult;

@Mapper
public interface ShopTalkMapper extends BaseMapper<ShopTalkDO>{
	ShopTalkResult selectShopTalk(@Param("shopId")Integer shopId);
}
