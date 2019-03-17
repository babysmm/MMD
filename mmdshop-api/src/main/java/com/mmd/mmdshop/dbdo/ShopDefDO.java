

package com.mmd.mmdshop.dbdo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商户详细信息(shop_def)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("shop_def")
public class ShopDefDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7781631333678874420L;
    
    /** 商户ID */
    @TableId(value="shop_id",type=IdType.AUTO)
    private Integer shopId;
    
    /** 商户地址 */
    private String address;
    
    /** 电话 */
    private Integer phone;
    
    /** 商品数量 */
    private Integer commNum;
    
    /** 商户服务 */
    private String service;
    
    /** 告示 */
    private String notice;
    
    /** 证书id */
    private Integer credentialId;
    
    /** 好评百分比 */
    private Integer goodNum;
    
    /** 营业时间 */
    private String businessHours;
    
    /** 商户商品类型ID */
    private Integer shopCommTypeId;
    
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
    
}