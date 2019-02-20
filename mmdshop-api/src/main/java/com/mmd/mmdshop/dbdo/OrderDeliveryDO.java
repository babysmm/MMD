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

import java.util.Date;

/**
 * (order_delivery)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class OrderDeliveryDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2990273759674019382L;
    
    /** 订单ID */
    private Integer orderId;
    
    /** 开始时间 */
    private Date startTime;
    
    /** 关闭时间 */
    private Date endTime;
    
    /** 配送用户ID */
    private Integer deliveryUserId;
    
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
     * 获取开始时间
     * 
     * @return 开始时间
     */
    public Date getStartTime() {
        return this.startTime;
    }
     
    /**
     * 设置开始时间
     * 
     * @param startTime
     *          开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    /**
     * 获取关闭时间
     * 
     * @return 关闭时间
     */
    public Date getEndTime() {
        return this.endTime;
    }
     
    /**
     * 设置关闭时间
     * 
     * @param endTime
     *          关闭时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    /**
     * 获取配送用户ID
     * 
     * @return 配送用户ID
     */
    public Integer getDeliveryUserId() {
        return this.deliveryUserId;
    }
     
    /**
     * 设置配送用户ID
     * 
     * @param deliveryUserId
     *          配送用户ID
     */
    public void setDeliveryUserId(Integer deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }
}