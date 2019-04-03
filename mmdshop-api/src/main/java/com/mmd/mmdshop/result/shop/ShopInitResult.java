package com.mmd.mmdshop.result.shop;

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
public class ShopInitResult {
	
	private Integer shopId;
	
	private Integer commodityId;
	
	private Integer typeId;
}
