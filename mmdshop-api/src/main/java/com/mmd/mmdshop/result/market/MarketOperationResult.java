package com.mmd.mmdshop.result.market;

import com.mmd.mmdshop.dbdo.ShopMarketDO;
import com.mmd.mmdshop.dbdo.ShopStaffDO;

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
public class MarketOperationResult {
	
	private ShopStaffDO shopStaffDO;
	
	private Integer code;
}
