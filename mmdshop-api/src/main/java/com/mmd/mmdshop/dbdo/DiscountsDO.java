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

/**
 * (discounts)
 * 
 * @author bianj
 * @version 1.0.0 2019-02-19
 */
public class DiscountsDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 8420688672415564253L;
    
    /**  */
    private Integer disId;
    
    /**
     * 获取
     * 
     * @return 
     */
    public Integer getDisId() {
        return this.disId;
    }
     
    /**
     * 设置
     * 
     * @param disId
     *          
     */
    public void setDisId(Integer disId) {
        this.disId = disId;
    }
}