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
 * 商户商品类型(shop_comm_type)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class ShopCommTypeDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 755392530766876608L;
    
    /** 商家商品类型 */
    private Integer shopCommTypeId;
    
    /** 商户ID */
    private Integer shopId;
    
    /** 名字 */
    private String name;
    
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
    
    /**
     * 获取商家商品类型
     * 
     * @return 商家商品类型
     */
    public Integer getShopCommTypeId() {
        return this.shopCommTypeId;
    }
     
    /**
     * 设置商家商品类型
     * 
     * @param shopCommTypeId
     *          商家商品类型
     */
    public void setShopCommTypeId(Integer shopCommTypeId) {
        this.shopCommTypeId = shopCommTypeId;
    }
    
    /**
     * 获取商户ID
     * 
     * @return 商户ID
     */
    public Integer getShopId() {
        return this.shopId;
    }
     
    /**
     * 设置商户ID
     * 
     * @param shopId
     *          商户ID
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 获取名字
     * 
     * @return 名字
     */
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置名字
     * 
     * @param name
     *          名字
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取变更ID
     * 
     * @return 变更ID
     */
    public Integer getChangeId() {
        return this.changeId;
    }
     
    /**
     * 设置变更ID
     * 
     * @param changeId
     *          变更ID
     */
    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }
    
    /**
     * 获取变更时间
     * 
     * @return 变更时间
     */
    public Date getChangeTime() {
        return this.changeTime;
    }
     
    /**
     * 设置变更时间
     * 
     * @param changeTime
     *          变更时间
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
    
    /**
     * 获取变更用户ID
     * 
     * @return 变更用户ID
     */
    public Integer getChangeUserId() {
        return this.changeUserId;
    }
     
    /**
     * 设置变更用户ID
     * 
     * @param changeUserId
     *          变更用户ID
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