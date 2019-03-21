

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
 * 商品图片(commodity_img)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("commodity_img")
public class CommodityImgDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3023308244918821349L;
    
    /** 商品图片ID */
    @TableId(value="comm_img_id",type=IdType.INPUT)
    private Integer commImgId;
    
    /** 商家ID */
    private Integer shopId;
    
    /** 图片1 */
    private String img1;
    
    /** 图片2 */
    private String img2;
    
    /** 图片3 */
    private String img3;
    
    /** 图片4 */
    private String img4;
    
    /** 图片5 */
    private String img5;
    
    /**  */
    private String date1;
    
    /** 变更ID */
    private Integer changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /** 变更用户ID */
    private Integer changeUserId;
    
    /**  */
    private String date2;
    
    /**  */
    private String date3;
    
    /**  */
    private String date4;
    
    /**  */
    private String date5;
    
}