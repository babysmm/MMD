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
 * 商户图片(shop_img)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class ShopImgDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 650041958136609914L;
    
    /** 商户图片ID */
    private Integer shopImgId;
    
    /** 商户ID */
    private Integer shopId;
    
    /** 图片1 */
    private String img1;
    
    /** 图片2 */
    private String img2;
    
    /** 图片3 */
    private String img3;
    
    /** 图片4 */
    private String img4;
    
    /** 图片5 */
    private String img5;
    
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
     * 获取商户图片ID
     * 
     * @return 商户图片ID
     */
    public Integer getShopImgId() {
        return this.shopImgId;
    }
     
    /**
     * 设置商户图片ID
     * 
     * @param shopImgId
     *          商户图片ID
     */
    public void setShopImgId(Integer shopImgId) {
        this.shopImgId = shopImgId;
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
     * 获取图片1
     * 
     * @return 图片1
     */
    public String getImg1() {
        return this.img1;
    }
     
    /**
     * 设置图片1
     * 
     * @param img1
     *          图片1
     */
    public void setImg1(String img1) {
        this.img1 = img1;
    }
    
    /**
     * 获取图片2
     * 
     * @return 图片2
     */
    public String getImg2() {
        return this.img2;
    }
     
    /**
     * 设置图片2
     * 
     * @param img2
     *          图片2
     */
    public void setImg2(String img2) {
        this.img2 = img2;
    }
    
    /**
     * 获取图片3
     * 
     * @return 图片3
     */
    public String getImg3() {
        return this.img3;
    }
     
    /**
     * 设置图片3
     * 
     * @param img3
     *          图片3
     */
    public void setImg3(String img3) {
        this.img3 = img3;
    }
    
    /**
     * 获取图片4
     * 
     * @return 图片4
     */
    public String getImg4() {
        return this.img4;
    }
     
    /**
     * 设置图片4
     * 
     * @param img4
     *          图片4
     */
    public void setImg4(String img4) {
        this.img4 = img4;
    }
    
    /**
     * 获取图片5
     * 
     * @return 图片5
     */
    public String getImg5() {
        return this.img5;
    }
     
    /**
     * 设置图片5
     * 
     * @param img5
     *          图片5
     */
    public void setImg5(String img5) {
        this.img5 = img5;
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