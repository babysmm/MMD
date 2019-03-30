

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
 * 社会秀评论(show_talk)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("show_talk")
public class ShowTalkDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3566621497005743930L;
    
    /** 社会秀评论ID */
    @TableId(value="show_talk_id",type=IdType.AUTO)
    private Integer showTalkId;
    
    /** 社会秀ID */
    private Integer showId;
    
    /**  */
    private Integer userHId;
    
    /** 评论内容 */
    private String content;
    
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