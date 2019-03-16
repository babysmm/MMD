

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
 * 商户商品类型(shop_comm_type)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("shop_comm_type")
public class ShopCommTypeDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 755392530766876608L;
    
    /** 商家商品类型 */
    @TableId(value="shop_comm_type_id",type=IdType.AUTO)
    private Integer shopCommTypeId;
    
    /** 商户ID */
    private Integer shopId;
    
    /** 名字 */
    private String name;
    
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