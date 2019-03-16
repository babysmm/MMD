

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
 * 订单(order_t)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("order_t")
public class OrderTDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2947246732658234790L;
    
    /** 订单ID */
    @TableId(value="order_id",type=IdType.AUTO)
    private Integer orderId;
    
    /** 用户id */
    private Integer userId;
    
    /** 订单状态(未支付,配送,完成，退款) */
    private int status;
    
    /** 评价状态 */
    private int evaStatus;
    
    /** 创建时间 */
    private Date newTime;
    
    /** 支付时间 */
    private Date payTime;
    
    /** 订单确认时间 */
    private Date confirmTime;
    
    /** 订单配送时间 */
    private Date shippingTime;
    
    /** 商户ID */
    private Integer shopId;
    
    /** 地址ID */
    private Integer addressId;
    
    /** 订单原价总金额 */
    private BigDecimal yAmount;
    
    /** 优惠后的总金额 */
    private BigDecimal hAmount;
    
    /** 优惠金额 */
    private BigDecimal hPay;
    
    /** 配送费用 */
    private BigDecimal distributionPay;
    
    /** 包装费用 */
    private BigDecimal packPay;
    
    /** 商品总数 */
    private Integer commSum;
    
    /** IP变更 */
    private String changeIp;
    
    /** 变更ID */
    private Integer changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /** 变更用户ID */
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