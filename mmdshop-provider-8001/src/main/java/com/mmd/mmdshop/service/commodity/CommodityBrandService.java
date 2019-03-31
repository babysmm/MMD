package com.mmd.mmdshop.service.commodity;

import java.util.List;

import com.mmd.mmdshop.dbdo.CommodityBrandDO;

public interface CommodityBrandService {
	
	/**
	 * 查询多个商品品牌
	 * @param shopId
	 * @return
	 */
	List<CommodityBrandDO> findCommodityBrandDOList(Integer shopId);
	
	/**
	 * 新增商品品牌
	 * @param commodityBrandDO
	 * @return
	 */
	boolean addCommodityBrand(CommodityBrandDO commodityBrandDO);
	
	/**
	 * 修改商品品牌
	 * @param commodityBrandDO
	 * @return
	 */
	boolean modityCommodityBrand(CommodityBrandDO commodityBrandDO);
	
	/**
	 * 删除品牌
	 * @param brandId
	 * @param shopId
	 * @return
	 */
	boolean removeCommodityBrand(Integer brandId,Integer shopId);
}
