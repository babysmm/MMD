package com.mmd.mmdshop.result;

import com.mmd.mmdshop.dbdo.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
public class CommodityAll {
	
	private CommodityDO commodityDO;
	
	private CommodityBrandDO commodityBrandDO;
	
	private CommodityImgDO commodityImgDO;
	
	private CommodityTypeDO commodityTypeDO;
	
	private ShopDO shopDO;
}
