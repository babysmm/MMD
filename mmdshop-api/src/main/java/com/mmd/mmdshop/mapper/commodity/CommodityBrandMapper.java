package com.mmd.mmdshop.mapper.commodity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.CommodityBrandDO;

@Mapper
public interface CommodityBrandMapper extends BaseMapper<CommodityBrandDO>{
	void setLastIpAndTimeById(@Param("lastIp") String lastIp, @Param("comm_type_id") Integer id);
	
	/**
	 * 增加品牌
	 * @param commodityBrandDO
	 * @return
	 */
	boolean inserCommodityBrand(CommodityBrandDO commodityBrandDO);
	
	/**
	 * 更新品牌
	 * @param commodityBrandDO
	 * @return
	 */
	boolean upCommodityBrand(CommodityBrandDO commodityBrandDO);
	
	/**
	 * 删除品牌
	 * @param commodityBrandDO
	 * @return
	 */
	boolean deleteCommodityBrand(@Param("brandId")Long brandId,@Param("shopId")Long shopId);
	
}
