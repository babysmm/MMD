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
 * 订单商品(order_commodity)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class OrderCommodityDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -5876700778522054530L;
    
    /** 订单商品ID */
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
    
    /**
     * 获取订单商品ID
     * 
     * @return 订单商品ID
     */
    public Integer getOrderCommodityId() {
        return this.orderCommodityId;
    }
     
    /**
     * 设置订单商品ID
     * 
     * @param orderCommodityId
     *          订单商品ID
     */
    public void setOrderCommodityId(Integer orderCommodityId) {
        this.orderCommodityId = orderCommodityId;
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
     * 获取
     * 
     * @return 
     */
    public BigDecimal getCommodityPrice() {
        return this.commodityPrice;
    }
     
    /**
     * 设置
     * 
     * @param commodityPrice
     *          
     */
    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }
    
    /**
     * 获取商品ID
     * 
     * @return 商品ID
     */
    public Integer getCommodityId() {
        return this.commodityId;
    }
     
    /**
     * 设置商品ID
     * 
     * @param commodityId
     *          商品ID
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
    
    /**
     * 获取商品数量
     * 
     * @return 商品数量
     */
    public Integer getNumber() {
        return this.number;
    }
     
    /**
     * 设置商品数量
     * 
     * @param number
     *          商品数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Integer getChangeId() {
        return this.changeId;
    }
     
    /**
     * 设置
     * 
     * @param changeId
     *          
     */
    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Date getChangeTime() {
        return this.changeTime;
    }
     
    /**
     * 设置
     * 
     * @param changeTime
     *          
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Integer getChangeUserId() {
        return this.changeUserId;
    }
     
    /**
     * 设置
     * 
     * @param changeUserId
     *          
     */
    public void setChangeUserId(Integer changeUserId) {
        this.changeUserId = changeUserId;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getDate1() {
        return this.date1;
    }
     
    /**
     * 设置
     * 
     * @param date1
     *          
     */
    public void setDate1(String date1) {
        this.date1 = date1;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getDate2() {
        return this.date2;
    }
     
    /**
     * 设置
     * 
     * @param date2
     *          
     */
    public void setDate2(String date2) {
        this.date2 = date2;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getDate3() {
        return this.date3;
    }
     
    /**
     * 设置
     * 
     * @param date3
     *          
     */
    public void setDate3(String date3) {
        this.date3 = date3;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getDate4() {
        return this.date4;
    }
     
    /**
     * 设置
     * 
     * @param date4
     *          
     */
    public void setDate4(String date4) {
        this.date4 = date4;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getDate5() {
        return this.date5;
    }
     
    /**
     * 设置
     * 
     * @param date5
     *          
     */
    public void setDate5(String date5) {
        this.date5 = date5;
    }
}