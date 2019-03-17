

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
 * 会员地址(member_address)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("member_address")
public class MemberAddressDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3295047800846056545L;
    
    /**  */
    @TableId(value="address_id",type=IdType.AUTO)
    private String addressId;
    
    /** 收货人名字 */
    private Integer userId;
    
    /** 收货人 */
    private String consignee;
    
    /** 国家 */
    private Integer country;
    
    /** 城市 */
    private Integer city;
    
    /** 地区 */
    private Integer district;
    
    /** 详细地址 */
    private String address;
    
    /** 电话号码 */
    private Integer phoneNumber;
    
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