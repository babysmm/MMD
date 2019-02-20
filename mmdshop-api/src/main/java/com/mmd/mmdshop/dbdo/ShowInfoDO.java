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
 * 社会秀(show_info)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class ShowInfoDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5367265322828189763L;
    
    /** 社会秀ID */
    private Integer showId;
    
    /** 用户ID */
    private Integer userId;
    
    /** 发出时间 */
    private Date addTime;
    
    /** 内容 */
    private String content;
    
    /** 点赞数 */
    private Integer good;
    
    /** 评论数 */
    private Integer talk;
    
    /** 转发数 */
    private Integer transpond;
    
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
     * 获取社会秀ID
     * 
     * @return 社会秀ID
     */
    public Integer getShowId() {
        return this.showId;
    }
     
    /**
     * 设置社会秀ID
     * 
     * @param showId
     *          社会秀ID
     */
    public void setShowId(Integer showId) {
        this.showId = showId;
    }
    
    /**
     * 获取用户ID
     * 
     * @return 用户ID
     */
    public Integer getUserId() {
        return this.userId;
    }
     
    /**
     * 设置用户ID
     * 
     * @param userId
     *          用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * 获取发出时间
     * 
     * @return 发出时间
     */
    public Date getAddTime() {
        return this.addTime;
    }
     
    /**
     * 设置发出时间
     * 
     * @param addTime
     *          发出时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    
    /**
     * 获取内容
     * 
     * @return 内容
     */
    public String getContent() {
        return this.content;
    }
     
    /**
     * 设置内容
     * 
     * @param content
     *          内容
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * 获取点赞数
     * 
     * @return 点赞数
     */
    public Integer getGood() {
        return this.good;
    }
     
    /**
     * 设置点赞数
     * 
     * @param good
     *          点赞数
     */
    public void setGood(Integer good) {
        this.good = good;
    }
    
    /**
     * 获取评论数
     * 
     * @return 评论数
     */
    public Integer getTalk() {
        return this.talk;
    }
     
    /**
     * 设置评论数
     * 
     * @param talk
     *          评论数
     */
    public void setTalk(Integer talk) {
        this.talk = talk;
    }
    
    /**
     * 获取转发数
     * 
     * @return 转发数
     */
    public Integer getTranspond() {
        return this.transpond;
    }
     
    /**
     * 设置转发数
     * 
     * @param transpond
     *          转发数
     */
    public void setTranspond(Integer transpond) {
        this.transpond = transpond;
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