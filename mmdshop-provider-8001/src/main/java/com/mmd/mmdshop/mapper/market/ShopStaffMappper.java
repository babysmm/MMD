package com.mmd.mmdshop.mapper.market;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.ShopStaffDO;
import com.mmd.mmdshop.result.CommodityStaffRrsult;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopStaffMappper extends BaseMapper<ShopStaffDO>{
	
	void setLastIpAndTimeById(@Param("lastIp")String lastIp,@Param("id")Integer id);
	
	CommodityStaffRrsult getCommodityByBarCode(@Param("barCode")Long integer);
	
	boolean insertShopStaff(ShopStaffDO shopStaffDO);
	
	boolean upDataShopStaff(ShopStaffDO shopStaffDO);
	
	String findEmail(@Param("userId")Integer userId);
}
