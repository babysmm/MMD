package com.mmd.mmdshop.mapper.market;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.MarketOrderCommDO;

@Mapper
public interface MarketOrderCommMappper extends BaseMapper<MarketOrderCommDO>{
	/**
	 * 增加订单商品
	 * @param marketOrderComm
	 * @return
	 */
	boolean insertMarketOrderComm(@Param("list")List<MarketOrderCommDO> marketOrderComm,@Param("id")Long orderId);
	
	/**
	 * 通过订单ID更改是不是欠账
	 * @param marketOrderId
	 * @return
	 */
	boolean updateState(@Param("id")Long marketOrderId);
}
