

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
 * 商品类型(commodity_type)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("commodity_type")
public class CommodityTypeDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 4319113383328396153L;
    
    /** 商品类型编号 */
    @TableId(value="comm_type_id",type=IdType.AUTO)
    private Integer commTypeId;
    
    /** 类型 */
    private String type;
    
    /** 变更ID */
    private Integer changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /**  */
    private Integer changeUserId;
    
    /**  */
    private Integer shopId;
    
    /**  */
    private String date2;
    
    /**  */
    private String date3;
    
    /**  */
    private String date4;
    
    /**  */
    private String date5;
    
}