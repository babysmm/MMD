

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
 * 商户(shop)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("shop")
public class ShopDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 6182546400598905226L;
    
    /** 商户ID */
    @TableId(value="shop_id",type=IdType.AUTO)
    private Integer shopId;
    
    /** 商户名字 */
    private String name;
    
    /** 商户图片 */
    private String img;
    
    /** 变更ID */
    private Integer changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /** 变更用户ID */
    private Integer changeUserId;
    
    /**  */
    private String img1;
    
    /**  */
    private String img2;
    
    /**  */
    private String img3;
    
    /**  */
    private String img4;
    
    /**  */
    private String img5;
    
}