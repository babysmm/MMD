

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
 * 商品评论(commodity_talk)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("commodity_talk")
public class CommodityTalkDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2369909553513079161L;
    
    /** 商品ID */
    @TableId(value="commodity_id",type=IdType.AUTO)
    private Integer commodityId;
    
    /** 用户ID */
    private Integer userId;
    
    /** 内容 */
    private String notice;
    
    /** 评论用户头像 */
    private Integer userHId;
    
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