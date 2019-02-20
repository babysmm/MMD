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
 * 会员(member)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class MemberDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3700454521941628573L;
    
    /** 会员ID */
    private String memberId;
    
    /** 微信openid */
    private Integer openId;
    
    /** 用户类型(普通用户,商户，快递员) */
    private Byte[] type;
    
    /** 微信名字 */
    private String wxName;
    
    /** 会员头像图片 */
    private String headImg;
    
    /** 变更id */
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
     * 获取会员ID
     * 
     * @return 会员ID
     */
    public String getMemberId() {
        return this.memberId;
    }
     
    /**
     * 设置会员ID
     * 
     * @param memberId
     *          会员ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    /**
     * 获取微信openid
     * 
     * @return 微信openid
     */
    public Integer getOpenId() {
        return this.openId;
    }
     
    /**
     * 设置微信openid
     * 
     * @param openId
     *          微信openid
     */
    public void setOpenId(Integer openId) {
        this.openId = openId;
    }
    
    /**
     * 获取用户类型(普通用户,商户，快递员)
     * 
     * @return 用户类型(普通用户,商户
     */
    public Byte[] getType() {
        return this.type;
    }
     
    /**
     * 设置用户类型(普通用户,商户，快递员)
     * 
     * @param type
     *          用户类型(普通用户,商户，快递员)
     */
    public void setType(Byte[] type) {
        this.type = type;
    }
    
    /**
     * 获取微信名字
     * 
     * @return 微信名字
     */
    public String getWxName() {
        return this.wxName;
    }
     
    /**
     * 设置微信名字
     * 
     * @param wxName
     *          微信名字
     */
    public void setWxName(String wxName) {
        this.wxName = wxName;
    }
    
    /**
     * 获取会员头像图片
     * 
     * @return 会员头像图片
     */
    public String getHeadImg() {
        return this.headImg;
    }
     
    /**
     * 设置会员头像图片
     * 
     * @param headImg
     *          会员头像图片
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
    
    /**
     * 获取变更id
     * 
     * @return 变更id
     */
    public Integer getChangeId() {
        return this.changeId;
    }
     
    /**
     * 设置变更id
     * 
     * @param changeId
     *          变更id
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