package com.mmd.mmdshop.result.shop;

import java.util.List;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.ShopDO;
import com.mmd.mmdshop.dbdo.ShopDefDO;
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
public class ShopResult {
	
	private ShopDO shop;
	
	private ShopDefDO shopDef;
	
	private List<CommodityDO> commodity;
}
