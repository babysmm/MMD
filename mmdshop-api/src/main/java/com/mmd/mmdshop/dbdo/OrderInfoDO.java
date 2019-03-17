

package com.mmd.mmdshop.dbdo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单(order_info)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
public class OrderInfoDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3222869880928124416L;
    
    /** 订单ID */
    private Integer orderId;
    
    /** 用户id */
    private Integer userId;
    
    /** 订单状态(未支付,配送,完成，退款) */
    private Byte[] status;
    
    /** 评价状态 */
    private Byte[] evaStatus;
    
    /** 创建时间 */
    private Date newTime;
    
    /** 支付时间 */
    private Date payTime;
    
    /** 订单确认时间 */
    private Date confirmTime;
    
    /** 订单配送时间 */
    private Date shippingTime;
    
    /** 商户ID */
    private Integer shopId;
    
    /** 地址ID */
    private Integer addressId;
    
    /** 订单原价总金额 */
    private BigDecimal yAmount;
    
    /** 优惠后的总金额 */
    private BigDecimal hAmount;
    
    /** 优惠金额 */
    private BigDecimal hPay;
    
    /** 配送费用 */
    private BigDecimal distributionPay;
    
    /** 包装费用 */
    private BigDecimal packPay;
    
    /** 商品总数 */
    private Integer commSum;
    
    /** IP变更 */
    private String changeIp;
    
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
     * 获取订单ID
     * 
     * @return 订单ID
     */
    public Integer getOrderId() {
        return this.orderId;
    }
     
    /**
     * 设置订单ID
     * 
     * @param orderId
     *          订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    /**
     * 获取用户id
     * 
     * @return 用户id
     */
    public Integer getUserId() {
        return this.userId;
    }
     
    /**
     * 设置用户id
     * 
     * @param userId
     *          用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * 获取订单状态(未支付,配送,完成，退款)
     * 
     * @return 订单状态(未支付,配送,完成
     */
    public Byte[] getStatus() {
        return this.status;
    }
     
    /**
     * 设置订单状态(未支付,配送,完成，退款)
     * 
     * @param status
     *          订单状态(未支付,配送,完成，退款)
     */
    public void setStatus(Byte[] status) {
        this.status = status;
    }
    
    /**
     * 获取评价状态
     * 
     * @return 评价状态
     */
    public Byte[] getEvaStatus() {
        return this.evaStatus;
    }
     
    /**
     * 设置评价状态
     * 
     * @param evaStatus
     *          评价状态
     */
    public void setEvaStatus(Byte[] evaStatus) {
        this.evaStatus = evaStatus;
    }
    
    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getNewTime() {
        return this.newTime;
    }
     
    /**
     * 设置创建时间
     * 
     * @param newTime
     *          创建时间
     */
    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }
    
    /**
     * 获取支付时间
     * 
     * @return 支付时间
     */
    public Date getPayTime() {
        return this.payTime;
    }
     
    /**
     * 设置支付时间
     * 
     * @param payTime
     *          支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    
    /**
     * 获取订单确认时间
     * 
     * @return 订单确认时间
     */
    public Date getConfirmTime() {
        return this.confirmTime;
    }
     
    /**
     * 设置订单确认时间
     * 
     * @param confirmTime
     *          订单确认时间
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }
    
    /**
     * 获取订单配送时间
     * 
     * @return 订单配送时间
     */
    public Date getShippingTime() {
        return this.shippingTime;
    }
     
    /**
     * 设置订单配送时间
     * 
     * @param shippingTime
     *          订单配送时间
     */
    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
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
     * 获取地址ID
     * 
     * @return 地址ID
     */
    public Integer getAddressId() {
        return this.addressId;
    }
     
    /**
     * 设置地址ID
     * 
     * @param addressId
     *          地址ID
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    
    /**
     * 获取订单原价总金额
     * 
     * @return 订单原价总金额
     */
    public BigDecimal getYAmount() {
        return this.yAmount;
    }
     
    /**
     * 设置订单原价总金额
     * 
     * @param yAmount
     *          订单原价总金额
     */
    public void setYAmount(BigDecimal yAmount) {
        this.yAmount = yAmount;
    }
    
    /**
     * 获取优惠后的总金额
     * 
     * @return 优惠后的总金额
     */
    public BigDecimal getHAmount() {
        return this.hAmount;
    }
     
    /**
     * 设置优惠后的总金额
     * 
     * @param hAmount
     *          优惠后的总金额
     */
    public void setHAmount(BigDecimal hAmount) {
        this.hAmount = hAmount;
    }
    
    /**
     * 获取优惠金额
     * 
     * @return 优惠金额
     */
    public BigDecimal getHPay() {
        return this.hPay;
    }
     
    /**
     * 设置优惠金额
     * 
     * @param hPay
     *          优惠金额
     */
    public void setHPay(BigDecimal hPay) {
        this.hPay = hPay;
    }
    
    /**
     * 获取配送费用
     * 
     * @return 配送费用
     */
    public BigDecimal getDistributionPay() {
        return this.distributionPay;
    }
     
    /**
     * 设置配送费用
     * 
     * @param distributionPay
     *          配送费用
     */
    public void setDistributionPay(BigDecimal distributionPay) {
        this.distributionPay = distributionPay;
    }
    
    /**
     * 获取包装费用
     * 
     * @return 包装费用
     */
    public BigDecimal getPackPay() {
        return this.packPay;
    }
     
    /**
     * 设置包装费用
     * 
     * @param packPay
     *          包装费用
     */
    public void setPackPay(BigDecimal packPay) {
        this.packPay = packPay;
    }
    
    /**
     * 获取商品总数
     * 
     * @return 商品总数
     */
    public Integer getCommSum() {
        return this.commSum;
    }
     
    /**
     * 设置商品总数
     * 
     * @param commSum
     *          商品总数
     */
    public void setCommSum(Integer commSum) {
        this.commSum = commSum;
    }
    
    /**
     * 获取IP变更
     * 
     * @return IP变更
     */
    public String getChangeIp() {
        return this.changeIp;
    }
     
    /**
     * 设置IP变更
     * 
     * @param changeIp
     *          IP变更
     */
    public void setChangeIp(String changeIp) {
        this.changeIp = changeIp;
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