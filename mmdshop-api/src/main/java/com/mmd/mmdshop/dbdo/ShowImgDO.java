
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
 * 社会秀图片(show_img)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("show_img")
public class ShowImgDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1656525308128067853L;
    
    /** 社会秀图片ID */
    @TableId(value="show_img_id",type=IdType.AUTO)
    private Integer showImgId;
    
    /** 社会秀ID */
    private Integer showId;
    
    /** 图片1 */
    private String img1;
    
    /** 图片2 */
    private String img2;
    
    /** 图片3 */
    private String img3;
    
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