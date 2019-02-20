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
 * 订单记录(order_log)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class OrderLogDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1710302191920567031L;
    
    /** 操作订单id */
    private Integer orderId;
    
    /** 操作IP */
    private String ip;
    
    /** 操作时间 */
    private Date date;
    
    /** 操作类型 */
    private Byte[] type;
    
    /** 操作内容 */
    private String context;
    
    /**
     * 获取操作订单id
     * 
     * @return 操作订单id
     */
    public Integer getOrderId() {
        return this.orderId;
    }
     
    /**
     * 设置操作订单id
     * 
     * @param orderId
     *          操作订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    /**
     * 获取操作IP
     * 
     * @return 操作IP
     */
    public String getIp() {
        return this.ip;
    }
     
    /**
     * 设置操作IP
     * 
     * @param ip
     *          操作IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    /**
     * 获取操作时间
     * 
     * @return 操作时间
     */
    public Date getDate() {
        return this.date;
    }
     
    /**
     * 设置操作时间
     * 
     * @param date
     *          操作时间
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * 获取操作类型
     * 
     * @return 操作类型
     */
    public Byte[] getType() {
        return this.type;
    }
     
    /**
     * 设置操作类型
     * 
     * @param type
     *          操作类型
     */
    public void setType(Byte[] type) {
        this.type = type;
    }
    
    /**
     * 获取操作内容
     * 
     * @return 操作内容
     */
    public String getContext() {
        return this.context;
    }
     
    /**
     * 设置操作内容
     * 
     * @param context
     *          操作内容
     */
    public void setContext(String context) {
        this.context = context;
    }
}