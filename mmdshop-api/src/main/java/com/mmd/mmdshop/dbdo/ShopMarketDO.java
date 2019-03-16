
package com.mmd.mmdshop.dbdo;

import java.math.BigDecimal;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商家线下销售订单(shop_market)
 * 
 * @author QJH
 * @version 1.0.0 2019-03-04
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("shop_market")
public class ShopMarketDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 45309216529153356L;
    
    /**  */
    @TableId(value="market_order_id",type=IdType.AUTO)
    private Long marketOrderId;
    
    /** 订单创建时间 */
    private String creationTime;
    
    /** 订单模式 */
    private int modeType;
    
    /** 订单状态 */
    private String state;
    
    /** 商品总个数 */
    private Integer commNumber;
    
    /** 结算金额 */
    private BigDecimal allPrice;
    
    /** 最后金额 */
    private BigDecimal lastPrice;
    
    /** 完成订单金额 */
    private BigDecimal overPrice;
    
    /** 订单欠账备注 */
    private String debtNote;
    
    /**  */
    private String data1;
    
    /**  */
    private String data2;
    
    /**  */
    private String data3;
    
    /**  */
    private String data4;
    
    /**  */
    private String data5;
    
    /**  */
    private Date changeTime;
    
    /**  */
    private Integer changeType;
    
    /**  */
    private Integer changeUserId;
    
}