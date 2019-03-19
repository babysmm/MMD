package com.mmd.mmdshop.result.commodity;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.CommodityImgDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class CommodityBasic {
	
	private CommodityDO commodityDO;
	
	private CommodityImgDO commodityImgDO;
}
