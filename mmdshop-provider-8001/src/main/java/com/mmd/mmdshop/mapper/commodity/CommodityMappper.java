package com.mmd.mmdshop.mapper.commodity;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.*;

/**
 * 
 * @author QJH
 *
 */
@Mapper
public interface CommodityMappper extends BaseMapper<CommodityDO> {

	/**
	 * 通过商品名字查询商品粗略信息
	 * 
	 * @param name
	 *            商品名字
	 * @return
	 */
	List<CommodityRough> selectCommodityRoughByName(@Param("name") String name);

	/**
	 * 通过商品Id查询商品全部信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return
	 */
	CommodityAll selectCommodityAllById(@Param("commodityId") Integer commodityId);
}
