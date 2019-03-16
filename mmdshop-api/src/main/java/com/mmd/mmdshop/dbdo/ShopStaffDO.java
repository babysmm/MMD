

package com.mmd.mmdshop.dbdo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mmd.mmdshop.utils.WebUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * (shop_staff)
 * 
 * @author QJH
 * @version 1.0.0 2019-03-04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("shop_staff")
public class ShopStaffDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 4253539933128106592L;
    
    /**  */
    @TableId(value="shop_staff_id",type=IdType.AUTO)
    private Integer shopStaffId;
    
    /** 用户名  */
    private Integer username;
    
    /** 密码  */
    private String password;
    
    /** 全名  */
    private String fullName;
    
    /** 商店ID */
    private Integer shopId;
    
    /** 最后一次登录IP  */
    private String lastIp;
    
    /**  */
    private Date changeTime;
    
    /**  */
    private Integer changeType;
    
    /**  */
    private Integer changeId;
    
    /** 电子邮箱 */
    private String email;
    
    public void setLastIpS(HttpServletRequest httpServletRequest) throws IOException {
    	this.lastIp = WebUtils.getIpAddress(httpServletRequest);
    }
   
}