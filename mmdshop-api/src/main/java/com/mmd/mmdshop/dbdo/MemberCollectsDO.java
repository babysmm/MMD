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
 * (member_collects)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class MemberCollectsDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 8152727827142892867L;
    
    /** 会员ID */
    private Integer memberId;
    
    /** 收藏商品ID */
    private Integer collectCommodityId;
    
    /** 评价商品ID */
    private Integer evaluateCommodityId;
    
    /**  */
    private Integer recordCommodityId;
    
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
     * 获取会员ID
     * 
     * @return 会员ID
     */
    public Integer getMemberId() {
        return this.memberId;
    }
     
    /**
     * 设置会员ID
     * 
     * @param memberId
     *          会员ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    
    /**
     * 获取收藏商品ID
     * 
     * @return 收藏商品ID
     */
    public Integer getCollectCommodityId() {
        return this.collectCommodityId;
    }
     
    /**
     * 设置收藏商品ID
     * 
     * @param collectCommodityId
     *          收藏商品ID
     */
    public void setCollectCommodityId(Integer collectCommodityId) {
        this.collectCommodityId = collectCommodityId;
    }
    
    /**
     * 获取评价商品ID
     * 
     * @return 评价商品ID
     */
    public Integer getEvaluateCommodityId() {
        return this.evaluateCommodityId;
    }
     
    /**
     * 设置评价商品ID
     * 
     * @param evaluateCommodityId
     *          评价商品ID
     */
    public void setEvaluateCommodityId(Integer evaluateCommodityId) {
        this.evaluateCommodityId = evaluateCommodityId;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Integer getRecordCommodityId() {
        return this.recordCommodityId;
    }
     
    /**
     * 设置
     * 
     * @param recordCommodityId
     *          
     */
    public void setRecordCommodityId(Integer recordCommodityId) {
        this.recordCommodityId = recordCommodityId;
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