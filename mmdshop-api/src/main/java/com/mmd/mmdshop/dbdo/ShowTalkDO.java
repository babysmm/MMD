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
 * 社会秀评论(show_talk)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class ShowTalkDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3566621497005743930L;
    
    /** 社会秀评论ID */
    private Integer showTalkId;
    
    /** 社会秀ID */
    private Integer showId;
    
    /**  */
    private Integer userHId;
    
    /** 评论内容 */
    private String content;
    
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
     * 获取社会秀评论ID
     * 
     * @return 社会秀评论ID
     */
    public Integer getShowTalkId() {
        return this.showTalkId;
    }
     
    /**
     * 设置社会秀评论ID
     * 
     * @param showTalkId
     *          社会秀评论ID
     */
    public void setShowTalkId(Integer showTalkId) {
        this.showTalkId = showTalkId;
    }
    
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
     * 获取
     * 
     * @return 
     */
    public Integer getUserHId() {
        return this.userHId;
    }
     
    /**
     * 设置
     * 
     * @param userHId
     *          
     */
    public void setUserHId(Integer userHId) {
        this.userHId = userHId;
    }
    
    /**
     * 获取评论内容
     * 
     * @return 评论内容
     */
    public String getContent() {
        return this.content;
    }
     
    /**
     * 设置评论内容
     * 
     * @param content
     *          评论内容
     */
    public void setContent(String content) {
        this.content = content;
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