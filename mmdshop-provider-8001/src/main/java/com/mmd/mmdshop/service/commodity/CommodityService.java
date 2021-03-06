package com.mmd.mmdshop.service.commodity;

import java.util.List;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.result.CommodityAll;
import com.mmd.mmdshop.result.CommodityRough;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.commodity.CommodityBasic;

public interface CommodityService {

	/**
	 * 通过商品名字查询商品粗略信息集合
	 * 
	 * @param name
	 *            商品名字
	 * @return 商品粗略信息的集合
	 */
	List<CommodityRough> findCommodityRoughByName(String name);

	/**
	 * 欧通过商品ID查询商品全部信息
	 * 
	 * @param id 商品ID
	 * @return 商品所有信息封装类
	 */
	CommodityAll findCommodityAllById(Integer id);
	
	/**
	 * 补货
	 * @param shopId
	 * @return
	 */
	List<CommodityDO> replenishmentCommodityNumber(Integer shopId);
	
	/**
	 * 添加商品
	 * @param commodityAll
	 * @return
	 */
	QiNiuResult addCommodityBasic(CommodityDO commodityDO);
	
	/**
	 * 通过查询商品条形码查询商品
	 * @param barcode
	 * @return
	 */
	CommodityBasic findCommodityByBarCode(Integer barcode);
	
	/**
	 * 通过查询商品名称查询商品
	 * @param name
	 * @return
	 */
	CommodityBasic findCommodityByName(String name);
	
	/**
	 * 更新
	 * @param basic
	 * @return
	 */
	QiNiuResult modifyCommodityBasic(CommodityDO commodityDO);
}
