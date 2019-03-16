

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
 * 社会秀(show_info)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("show_info")
public class ShowInfoDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5367265322828189763L;
    
    /** 社会秀ID */
    @TableId(value="show_id",type=IdType.AUTO)
    private Integer showId;
    
    /** 用户ID */
    private Integer userId;
    
    /** 发出时间 */
    private Date addTime;
    
    /** 内容 */
    private String content;
    
    /** 点赞数 */
    private Integer good;
    
    /** 评论数 */
    private Integer talk;
    
    /** 转发数 */
    private Integer transpond;
    
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