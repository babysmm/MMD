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
 * 商户详细信息(shop_def)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class ShopDefDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7781631333678874420L;
    
    /** 商户ID */
    private Integer shopId;
    
    /** 商户地址 */
    private String address;
    
    /** 电话 */
    private Integer phone;
    
    /** 商品数量 */
    private Integer commNum;
    
    /** 商户服务 */
    private String service;
    
    /** 告示 */
    private String notice;
    
    /** 证书id */
    private Integer credentialId;
    
    /** 好评百分比 */
    private Integer goodNum;
    
    /** 营业时间 */
    private String businessHours;
    
    /** 商户商品类型ID */
    private Integer shopCommTypeId;
    
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
     * 获取商户地址
     * 
     * @return 商户地址
     */
    public String getAddress() {
        return this.address;
    }
     
    /**
     * 设置商户地址
     * 
     * @param address
     *          商户地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * 获取电话
     * 
     * @return 电话
     */
    public Integer getPhone() {
        return this.phone;
    }
     
    /**
     * 设置电话
     * 
     * @param phone
     *          电话
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    
    /**
     * 获取商品数量
     * 
     * @return 商品数量
     */
    public Integer getCommNum() {
        return this.commNum;
    }
     
    /**
     * 设置商品数量
     * 
     * @param commNum
     *          商品数量
     */
    public void setCommNum(Integer commNum) {
        this.commNum = commNum;
    }
    
    /**
     * 获取商户服务
     * 
     * @return 商户服务
     */
    public String getService() {
        return this.service;
    }
     
    /**
     * 设置商户服务
     * 
     * @param service
     *          商户服务
     */
    public void setService(String service) {
        this.service = service;
    }
    
    /**
     * 获取告示
     * 
     * @return 告示
     */
    public String getNotice() {
        return this.notice;
    }
     
    /**
     * 设置告示
     * 
     * @param notice
     *          告示
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }
    
    /**
     * 获取证书id
     * 
     * @return 证书id
     */
    public Integer getCredentialId() {
        return this.credentialId;
    }
     
    /**
     * 设置证书id
     * 
     * @param credentialId
     *          证书id
     */
    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }
    
    /**
     * 获取好评百分比
     * 
     * @return 好评百分比
     */
    public Integer getGoodNum() {
        return this.goodNum;
    }
     
    /**
     * 设置好评百分比
     * 
     * @param goodNum
     *          好评百分比
     */
    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }
    
    /**
     * 获取营业时间
     * 
     * @return 营业时间
     */
    public String getBusinessHours() {
        return this.businessHours;
    }
     
    /**
     * 设置营业时间
     * 
     * @param businessHours
     *          营业时间
     */
    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }
    
    /**
     * 获取商户商品类型ID
     * 
     * @return 商户商品类型ID
     */
    public Integer getShopCommTypeId() {
        return this.shopCommTypeId;
    }
     
    /**
     * 设置商户商品类型ID
     * 
     * @param shopCommTypeId
     *          商户商品类型ID
     */
    public void setShopCommTypeId(Integer shopCommTypeId) {
        this.shopCommTypeId = shopCommTypeId;
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