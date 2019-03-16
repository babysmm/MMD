

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
 * 订单商品(order_commodity)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("order_commodity")
public class OrderCommodityDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -5876700778522054530L;
    
    /** 订单商品ID */
    @TableId(value="order_commodity_id",type=IdType.AUTO)
    private Integer orderCommodityId;
    
    /** 订单ID */
    private Integer orderId;
    
    /**  */
    private BigDecimal commodityPrice;
    
    /** 商品ID */
    private Integer commodityId;
    
    /** 商品数量 */
    private Integer number;
    
    /**  */
    private Integer changeId;
    
    /**  */
    private Date changeTime;
    
    /**  */
    private Integer changeUserId;
    
    /**  */
    private String date1;
    
    /**  */
    private String date2;
    
    /**  */
    private String date3;
    
    /**  */
    private String date4;
    
    /**  */
    private String date5;
    
}