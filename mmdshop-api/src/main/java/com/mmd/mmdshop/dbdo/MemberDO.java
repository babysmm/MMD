

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
 * 会员(member)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("member")
public class MemberDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3700454521941628573L;
    
    /** 会员ID */
    @TableId(value="member_id",type=IdType.AUTO)
    private String memberId;
    
    /** 微信openid */
    private Integer openId;
    
    /** 用户类型(普通用户,商户，快递员) */
    private int type;
    
    /** 微信名字 */
    private String wxName;
    
    /** 会员头像图片 */
    private String headImg;
    
    /** 变更id */
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