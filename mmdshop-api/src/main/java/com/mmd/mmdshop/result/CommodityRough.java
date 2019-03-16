package com.mmd.mmdshop.result;

import com.mmd.mmdshop.dbdo.CommodityBrandDO;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.ShopDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 后台搜索商品
 * @author QJH
 * @version 1.0.0 2019-02-20
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
public class CommodityRough {
	
	private CommodityDO commodityDO;
	
	private CommodityBrandDO commodityBrandDO;
	
	private ShopDO shopDO;
	
}
