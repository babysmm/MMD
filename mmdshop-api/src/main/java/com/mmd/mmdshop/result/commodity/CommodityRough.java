package com.mmd.mmdshop.result.commodity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商品粗略信息
 * @author computer
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class CommodityRough {
	/** 商品缩略图 */
    private String thumb;
    
    /** 商品名称 */
    private String name;
    
    /** 市场价 */
    private BigDecimal marketPrice;
    
    /** 批发价 */
    private BigDecimal tradePrice;
}
