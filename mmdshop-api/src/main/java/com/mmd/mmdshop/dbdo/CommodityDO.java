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
 * 商品(commodity)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class CommodityDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 333078981054144442L;
    
    /** 商品ID */
    private Integer commId;
    
    /** 商家id */
    private Integer shopId;
    
    /** 商品类型 */
    private Integer commTypeId;
    
    /** 商品图片URL */
    private String commImgId;
    
    /** 商家商品类型 */
    private Integer shopCommTypeId;
    
    /** 商品缩略图 */
    private String thumb;
    
    /** 商品关键字 */
    private String keywords;
    
    /** 商品名称 */
    private String name;
    
    /** 商品重量 */
    private Integer weight;
    
    /** 商品数量 */
    private Integer number;
    
    /** 购买商品所得积分 */
    private Integer integral;
    
    /** 是否开始销售 */
    private Byte[] isOnSale;
    
    /** 是否有货 */
    private Byte[] inOutStock;
    
    /** 是否是新品 */
    private Byte[] isNew;
    
    /** 是否精品 */
    private Integer isGood;
    
    /** 是否热销 */
    private Byte[] isHot;
    
    /** 商品备注 */
    private String note;
    
    /** 商品生产地 */
    private String address;
    
    /** 商品评价百分比 */
    private Integer evaluate;
    
    /** 市场价 */
    private BigDecimal marketPrice;
    
    /** 好评数 */
    private Integer goodNum;
    
    /** 月销 */
    private String monthSales;
    
    /** 品牌id */
    private Integer brandId;
    
    /** 最低价 */
    private BigDecimal lowPrice;
    
    /** 供应商名称 */
    private String suppliersName;
    
    /** 供货商电话 */
    private Integer suppliersNumber;
    
    /** 变更ID */
    private Integer changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /** 变更用户id */
    private Byte[] changeUserId;
    
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
     * 获取商品ID
     * 
     * @return 商品ID
     */
    public Integer getCommId() {
        return this.commId;
    }
     
    /**
     * 设置商品ID
     * 
     * @param commId
     *          商品ID
     */
    public void setCommId(Integer commId) {
        this.commId = commId;
    }
    
    /**
     * 获取商家id
     * 
     * @return 商家id
     */
    public Integer getShopId() {
        return this.shopId;
    }
     
    /**
     * 设置商家id
     * 
     * @param shopId
     *          商家id
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    /**
     * 获取商品类型
     * 
     * @return 商品类型
     */
    public Integer getCommTypeId() {
        return this.commTypeId;
    }
     
    /**
     * 设置商品类型
     * 
     * @param commTypeId
     *          商品类型
     */
    public void setCommTypeId(Integer commTypeId) {
        this.commTypeId = commTypeId;
    }
    
    /**
     * 获取商品图片URL
     * 
     * @return 商品图片URL
     */
    public String getCommImgId() {
        return this.commImgId;
    }
     
    /**
     * 设置商品图片URL
     * 
     * @param commImgId
     *          商品图片URL
     */
    public void setCommImgId(String commImgId) {
        this.commImgId = commImgId;
    }
    
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
     * 获取商品缩略图
     * 
     * @return 商品缩略图
     */
    public String getThumb() {
        return this.thumb;
    }
     
    /**
     * 设置商品缩略图
     * 
     * @param thumb
     *          商品缩略图
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    
    /**
     * 获取商品关键字
     * 
     * @return 商品关键字
     */
    public String getKeywords() {
        return this.keywords;
    }
     
    /**
     * 设置商品关键字
     * 
     * @param keywords
     *          商品关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    /**
     * 获取商品名称
     * 
     * @return 商品名称
     */
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置商品名称
     * 
     * @param name
     *          商品名称
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取商品重量
     * 
     * @return 商品重量
     */
    public Integer getWeight() {
        return this.weight;
    }
     
    /**
     * 设置商品重量
     * 
     * @param weight
     *          商品重量
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    
    /**
     * 获取商品数量
     * 
     * @return 商品数量
     */
    public Integer getNumber() {
        return this.number;
    }
     
    /**
     * 设置商品数量
     * 
     * @param number
     *          商品数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    /**
     * 获取购买商品所得积分
     * 
     * @return 购买商品所得积分
     */
    public Integer getIntegral() {
        return this.integral;
    }
     
    /**
     * 设置购买商品所得积分
     * 
     * @param integral
     *          购买商品所得积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
    
    /**
     * 获取是否开始销售
     * 
     * @return 是否开始销售
     */
    public Byte[] getIsOnSale() {
        return this.isOnSale;
    }
     
    /**
     * 设置是否开始销售
     * 
     * @param isOnSale
     *          是否开始销售
     */
    public void setIsOnSale(Byte[] isOnSale) {
        this.isOnSale = isOnSale;
    }
    
    /**
     * 获取是否有货
     * 
     * @return 是否有货
     */
    public Byte[] getInOutStock() {
        return this.inOutStock;
    }
     
    /**
     * 设置是否有货
     * 
     * @param inOutStock
     *          是否有货
     */
    public void setInOutStock(Byte[] inOutStock) {
        this.inOutStock = inOutStock;
    }
    
    /**
     * 获取是否是新品
     * 
     * @return 是否是新品
     */
    public Byte[] getIsNew() {
        return this.isNew;
    }
     
    /**
     * 设置是否是新品
     * 
     * @param isNew
     *          是否是新品
     */
    public void setIsNew(Byte[] isNew) {
        this.isNew = isNew;
    }
    
    /**
     * 获取是否精品
     * 
     * @return 是否精品
     */
    public Integer getIsGood() {
        return this.isGood;
    }
     
    /**
     * 设置是否精品
     * 
     * @param isGood
     *          是否精品
     */
    public void setIsGood(Integer isGood) {
        this.isGood = isGood;
    }
    
    /**
     * 获取是否热销
     * 
     * @return 是否热销
     */
    public Byte[] getIsHot() {
        return this.isHot;
    }
     
    /**
     * 设置是否热销
     * 
     * @param isHot
     *          是否热销
     */
    public void setIsHot(Byte[] isHot) {
        this.isHot = isHot;
    }
    
    /**
     * 获取商品备注
     * 
     * @return 商品备注
     */
    public String getNote() {
        return this.note;
    }
     
    /**
     * 设置商品备注
     * 
     * @param note
     *          商品备注
     */
    public void setNote(String note) {
        this.note = note;
    }
    
    /**
     * 获取商品生产地
     * 
     * @return 商品生产地
     */
    public String getAddress() {
        return this.address;
    }
     
    /**
     * 设置商品生产地
     * 
     * @param address
     *          商品生产地
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * 获取商品评价百分比
     * 
     * @return 商品评价百分比
     */
    public Integer getEvaluate() {
        return this.evaluate;
    }
     
    /**
     * 设置商品评价百分比
     * 
     * @param evaluate
     *          商品评价百分比
     */
    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }
    
    /**
     * 获取市场价
     * 
     * @return 市场价
     */
    public BigDecimal getMarketPrice() {
        return this.marketPrice;
    }
     
    /**
     * 设置市场价
     * 
     * @param marketPrice
     *          市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }
    
    /**
     * 获取好评数
     * 
     * @return 好评数
     */
    public Integer getGoodNum() {
        return this.goodNum;
    }
     
    /**
     * 设置好评数
     * 
     * @param goodNum
     *          好评数
     */
    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }
    
    /**
     * 获取月销
     * 
     * @return 月销
     */
    public String getMonthSales() {
        return this.monthSales;
    }
     
    /**
     * 设置月销
     * 
     * @param monthSales
     *          月销
     */
    public void setMonthSales(String monthSales) {
        this.monthSales = monthSales;
    }
    
    /**
     * 获取品牌id
     * 
     * @return 品牌id
     */
    public Integer getBrandId() {
        return this.brandId;
    }
     
    /**
     * 设置品牌id
     * 
     * @param brandId
     *          品牌id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
    
    /**
     * 获取最低价
     * 
     * @return 最低价
     */
    public BigDecimal getLowPrice() {
        return this.lowPrice;
    }
     
    /**
     * 设置最低价
     * 
     * @param lowPrice
     *          最低价
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }
    
    /**
     * 获取供应商名称
     * 
     * @return 供应商名称
     */
    public String getSuppliersName() {
        return this.suppliersName;
    }
     
    /**
     * 设置供应商名称
     * 
     * @param suppliersName
     *          供应商名称
     */
    public void setSuppliersName(String suppliersName) {
        this.suppliersName = suppliersName;
    }
    
    /**
     * 获取供货商电话
     * 
     * @return 供货商电话
     */
    public Integer getSuppliersNumber() {
        return this.suppliersNumber;
    }
     
    /**
     * 设置供货商电话
     * 
     * @param suppliersNumber
     *          供货商电话
     */
    public void setSuppliersNumber(Integer suppliersNumber) {
        this.suppliersNumber = suppliersNumber;
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
     * 获取变更用户id
     * 
     * @return 变更用户id
     */
    public Byte[] getChangeUserId() {
        return this.changeUserId;
    }
     
    /**
     * 设置变更用户id
     * 
     * @param changeUserId
     *          变更用户id
     */
    public void setChangeUserId(Byte[] changeUserId) {
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