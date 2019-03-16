package com.mmd.mmdshop.result;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.CommodityTypeDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author QJH
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class CommodityStaffRrsult {
	
	private CommodityDO commodityDO;
	
	private CommodityTypeDO commodityTypeDO;
	
}
