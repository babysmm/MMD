
package com.mmd.mmdshop.dbdo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * (market_order_comm)
 * 
 * @author QJH
 * @version 1.0.0 2019-03-06
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("market_order_comm")
public class MarketOrderCommDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2758535839938816477L;
    
    @TableId(value="market_comm_id",type=IdType.AUTO)
    private Long marketCommId;
    
    /** 线下电商交易商品id */
    private Long marketOrderCommId;
    
    /** 商品条形码 */
    private Long barCode;
    
    /** 商品数量 */
    private Integer number;
    
    /** 商品单价 */
    private BigDecimal priceShow;
    
    /**  */
    private BigDecimal totalPrices;
    
    /**  */
    private Integer commodityId;
    
    /**  */
    private String data3;
    
    /**  */
    private String data4;
    
    /**  */
    private String data5;
    
}