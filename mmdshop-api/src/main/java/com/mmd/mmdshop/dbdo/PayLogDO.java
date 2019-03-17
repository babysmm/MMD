

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
 * (pay_log)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("pay_log")
public class PayLogDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5631441591588129601L;
    
    /** 支付日志id */
    @TableId(value="pay_log_id",type=IdType.AUTO)
    private Integer payLogId;
    
    /** 订单ID */
    private Integer orderId;
    
    /** 支付时间 */
    private Date time;
    
    /** 支付IP地址 */
    private String ip;
    
    /** 支付金额 */
    private BigDecimal pay;
    
    /** 商品总数 */
    private Integer commSum;
}