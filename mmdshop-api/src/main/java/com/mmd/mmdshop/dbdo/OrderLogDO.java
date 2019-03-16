

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
 * 订单记录(order_log)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("order_log")
public class OrderLogDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1710302191920567031L;
    
    /** 操作订单id */
    @TableId(value="order_id",type=IdType.AUTO)
    private Integer orderId;
    
    /** 操作IP */
    private String ip;
    
    /** 操作时间 */
    private Date date;
    
    /** 操作类型 */
    private int type;
    
    /** 操作内容 */
    private String context;
}