

package com.mmd.mmdshop.dbdo;

import java.math.BigDecimal;
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
 * 会员信息(member_info)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("member_info")
public class MemberInfoDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -8738974395733187864L;
    
    /**  */
    @TableId(value="member_id",type=IdType.AUTO)
    private Integer memberId;
    
    /** 电话号码 */
    private String phoneNumber;
    
    /** 收货地址 */
    private Integer addressId;
    
    /** 用户等级 */
    private Integer grade;
    
    /** 最大消费 */
    private BigDecimal creditLine;
    
    /** 会员类型 */
    private Byte[] mberType;
    
    /** 注册时间 */
    private Date registerTime;
    
    /** 最后登录IP */
    private String lastIp;
    
    /** 最后登陆时间 */
    private Date lastTime;
    
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