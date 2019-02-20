/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:4.1.2
 */

package com.mmd.mmdshop.dbdo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * (pay_log)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class PayLogDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5631441591588129601L;
    
    /** 支付日志id */
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
    
    /**
     * 获取支付日志id
     * 
     * @return 支付日志id
     */
    public Integer getPayLogId() {
        return this.payLogId;
    }
     
    /**
     * 设置支付日志id
     * 
     * @param payLogId
     *          支付日志id
     */
    public void setPayLogId(Integer payLogId) {
        this.payLogId = payLogId;
    }
    
    /**
     * 获取订单ID
     * 
     * @return 订单ID
     */
    public Integer getOrderId() {
        return this.orderId;
    }
     
    /**
     * 设置订单ID
     * 
     * @param orderId
     *          订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    /**
     * 获取支付时间
     * 
     * @return 支付时间
     */
    public Date getTime() {
        return this.time;
    }
     
    /**
     * 设置支付时间
     * 
     * @param time
     *          支付时间
     */
    public void setTime(Date time) {
        this.time = time;
    }
    
    /**
     * 获取支付IP地址
     * 
     * @return 支付IP地址
     */
    public String getIp() {
        return this.ip;
    }
     
    /**
     * 设置支付IP地址
     * 
     * @param ip
     *          支付IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    /**
     * 获取支付金额
     * 
     * @return 支付金额
     */
    public BigDecimal getPay() {
        return this.pay;
    }
     
    /**
     * 设置支付金额
     * 
     * @param pay
     *          支付金额
     */
    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }
    
    /**
     * 获取商品总数
     * 
     * @return 商品总数
     */
    public Integer getCommSum() {
        return this.commSum;
    }
     
    /**
     * 设置商品总数
     * 
     * @param commSum
     *          商品总数
     */
    public void setCommSum(Integer commSum) {
        this.commSum = commSum;
    }
}