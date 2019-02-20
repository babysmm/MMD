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
 * 会员地址(member_address)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class MemberAddressDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3295047800846056545L;
    
    /**  */
    private String addressId;
    
    /** 收货人名字 */
    private Integer userId;
    
    /** 收货人 */
    private String consignee;
    
    /** 国家 */
    private Integer country;
    
    /** 城市 */
    private Integer city;
    
    /** 地区 */
    private Integer district;
    
    /** 详细地址 */
    private String address;
    
    /** 电话号码 */
    private Integer phoneNumber;
    
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
     * 获取
     * 
     * @return 
     */
    public String getAddressId() {
        return this.addressId;
    }
     
    /**
     * 设置
     * 
     * @param addressId
     *          
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    
    /**
     * 获取收货人名字
     * 
     * @return 收货人名字
     */
    public Integer getUserId() {
        return this.userId;
    }
     
    /**
     * 设置收货人名字
     * 
     * @param userId
     *          收货人名字
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * 获取收货人
     * 
     * @return 收货人
     */
    public String getConsignee() {
        return this.consignee;
    }
     
    /**
     * 设置收货人
     * 
     * @param consignee
     *          收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    
    /**
     * 获取国家
     * 
     * @return 国家
     */
    public Integer getCountry() {
        return this.country;
    }
     
    /**
     * 设置国家
     * 
     * @param country
     *          国家
     */
    public void setCountry(Integer country) {
        this.country = country;
    }
    
    /**
     * 获取城市
     * 
     * @return 城市
     */
    public Integer getCity() {
        return this.city;
    }
     
    /**
     * 设置城市
     * 
     * @param city
     *          城市
     */
    public void setCity(Integer city) {
        this.city = city;
    }
    
    /**
     * 获取地区
     * 
     * @return 地区
     */
    public Integer getDistrict() {
        return this.district;
    }
     
    /**
     * 设置地区
     * 
     * @param district
     *          地区
     */
    public void setDistrict(Integer district) {
        this.district = district;
    }
    
    /**
     * 获取详细地址
     * 
     * @return 详细地址
     */
    public String getAddress() {
        return this.address;
    }
     
    /**
     * 设置详细地址
     * 
     * @param address
     *          详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * 获取电话号码
     * 
     * @return 电话号码
     */
    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }
     
    /**
     * 设置电话号码
     * 
     * @param phoneNumber
     *          电话号码
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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