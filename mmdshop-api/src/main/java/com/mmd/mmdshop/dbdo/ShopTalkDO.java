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

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * (shop_talk)
 * 
 * @author QJH
 * @version 1.0.0 2019-04-03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("shop_talk")
public class ShopTalkDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5825526766759987045L;
    
    /**  */
    @TableId(value="shop_talk_id",type=IdType.AUTO)
    private Integer shopTalkId;
    
    /** 商店Id */
    private String shopId;
    
    /** 评论会员Id */
    private String memberId;
    
    /** 创建时间 */
    private Date creationTime;
    
    /** 会员评分 */
    private Integer grade;
    
    /** 内容 */
    private String context;
    
    /** 商家回复 */
    private String shopReply;
}