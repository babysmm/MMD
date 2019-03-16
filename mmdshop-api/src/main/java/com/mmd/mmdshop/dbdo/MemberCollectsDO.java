

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
 * (member_collects)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("member_collects")
public class MemberCollectsDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 8152727827142892867L;
    
    /** 会员ID */
    @TableId(value="member_id",type=IdType.AUTO)
    private Integer memberId;
    
    /** 收藏商品ID */
    private Integer collectCommodityId;
    
    /** 评价商品ID */
    private Integer evaluateCommodityId;
    
    /**  */
    private Integer recordCommodityId;
    
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