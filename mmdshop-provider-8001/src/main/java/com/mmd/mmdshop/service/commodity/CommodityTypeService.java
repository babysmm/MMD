package com.mmd.mmdshop.service.commodity;

import java.util.List;

import com.mmd.mmdshop.dbdo.CommodityTypeDO;

public interface CommodityTypeService {

	/**
	 * 查询商品类型
	 * 
	 * @param name
	 *            商品名字
	 * @return 商品粗略信息的集合
	 */
	List<CommodityTypeDO> findCommodityTypeAll(Integer shopId);
}
