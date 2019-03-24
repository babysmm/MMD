package com.mmd.mmdshop.mapper.market;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.ShopMarketDO;

@Mapper
public interface ShopMarketMapper extends BaseMapper<ShopMarketDO>{
	
	/**
	 * 获取今日订单
	 * @param date 日期
	 * @return
	 */
	List<ShopMarketDO> getTodayShopMarketList();
	
	/**
	 * 获取近7天
	 * @return
	 */
	List<ShopMarketDO> getSevenDayShopMarketList();
	
	/**
	 * 获取月
	 * @return
	 */
	List<ShopMarketDO> getMouthShopMarketList();
	
	/**
	 * 查询指定时间段
	 * @param start
	 * @param end
	 * @return
	 */
	List<ShopMarketDO> getShopMarketList(@Param("start")String start,@Param("end")String end);
}
