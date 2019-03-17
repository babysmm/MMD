package com.mmd.mmdshop.result;

import java.util.List;
import com.mmd.mmdshop.dbdo.MarketOrderCommDO;
import com.mmd.mmdshop.dbdo.ShopMarketDO;
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
public class MarketResult {
	
	private ShopMarketDO shopMarketDO;
	
	private List<MarketOrderCommDO> marketOrderCommDO;
	
}
