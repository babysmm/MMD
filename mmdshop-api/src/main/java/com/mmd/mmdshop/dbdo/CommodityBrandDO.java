

package com.mmd.mmdshop.dbdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商品品牌(commodity_brand)
 * 
 * @author MM
 * @version 1.0.0 2019-02-26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("commodity_brand")
public class CommodityBrandDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 536807829965402670L;
    
    /** 品牌ID */
    @TableId(value="brand_id",type=IdType.AUTO)
    private Integer brandId;
    
    /** 品牌名字 */
    private String name;
    
    /** 品牌地址 */
    private String address;
    
    /**  */
    private int state;
    
    /**  */
    private Integer shopId;
    
    /**  */
    private String date3;
    
    /**  */
    private String date4;
    
    /**  */
    private String date5;
    
}