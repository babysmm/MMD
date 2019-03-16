

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
 * (order_delivery)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("order_delivery")
public class OrderDeliveryDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2990273759674019382L;
    
    /** 订单ID */
    @TableId(value="order_id",type=IdType.AUTO)
    private Integer orderId;
    
    /** 开始时间 */
    private Date startTime;
    
    /** 关闭时间 */
    private Date endTime;
    
    /** 配送用户ID */
    private Integer deliveryUserId;
}