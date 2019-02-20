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
 * 会员信息(member_info)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class MemberInfoDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -8738974395733187864L;
    
    /**  */
    private Integer memberId;
    
    /** 电话号码 */
    private String phoneNumber;
    
    /** 收货地址 */
    private Integer addressId;
    
    /** 用户等级 */
    private Integer grade;
    
    /** 最大消费 */
    private BigDecimal creditLine;
    
    /** 会员类型 */
    private Byte[] mberType;
    
    /** 注册时间 */
    private Date registerTime;
    
    /** 最后登录IP */
    private String lastIp;
    
    /** 最后登陆时间 */
    private Date lastTime;
    
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
    public Integer getMemberId() {
        return this.memberId;
    }
     
    /**
     * 设置
     * 
     * @param memberId
     *          
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    
    /**
     * 获取电话号码
     * 
     * @return 电话号码
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
     
    /**
     * 设置电话号码
     * 
     * @param phoneNumber
     *          电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * 获取收货地址
     * 
     * @return 收货地址
     */
    public Integer getAddressId() {
        return this.addressId;
    }
     
    /**
     * 设置收货地址
     * 
     * @param addressId
     *          收货地址
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    
    /**
     * 获取用户等级
     * 
     * @return 用户等级
     */
    public Integer getGrade() {
        return this.grade;
    }
     
    /**
     * 设置用户等级
     * 
     * @param grade
     *          用户等级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
    /**
     * 获取最大消费
     * 
     * @return 最大消费
     */
    public BigDecimal getCreditLine() {
        return this.creditLine;
    }
     
    /**
     * 设置最大消费
     * 
     * @param creditLine
     *          最大消费
     */
    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }
    
    /**
     * 获取会员类型
     * 
     * @return 会员类型
     */
    public Byte[] getMberType() {
        return this.mberType;
    }
     
    /**
     * 设置会员类型
     * 
     * @param mberType
     *          会员类型
     */
    public void setMberType(Byte[] mberType) {
        this.mberType = mberType;
    }
    
    /**
     * 获取注册时间
     * 
     * @return 注册时间
     */
    public Date getRegisterTime() {
        return this.registerTime;
    }
     
    /**
     * 设置注册时间
     * 
     * @param registerTime
     *          注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    
    /**
     * 获取最后登录IP
     * 
     * @return 最后登录IP
     */
    public String getLastIp() {
        return this.lastIp;
    }
     
    /**
     * 设置最后登录IP
     * 
     * @param lastIp
     *          最后登录IP
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }
    
    /**
     * 获取最后登陆时间
     * 
     * @return 最后登陆时间
     */
    public Date getLastTime() {
        return this.lastTime;
    }
     
    /**
     * 设置最后登陆时间
     * 
     * @param lastTime
     *          最后登陆时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
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