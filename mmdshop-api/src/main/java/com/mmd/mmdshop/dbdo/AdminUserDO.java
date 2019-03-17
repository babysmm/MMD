
package com.mmd.mmdshop.dbdo;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 后端用户表\r\n主要用于登录验证(admin_user)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("admin_user")
public class AdminUserDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7301519340808205137L;
    
    /** 用户ID */
    @TableId(value="user_id",type=IdType.AUTO)
    private int userId;
    
    /** 用户名 */
    private Integer username;
    
    /** 密码 */
    private String password;
    
    /** 变更ID */
    private int changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /** 变更用户ID */
    private int changeUserId;
    
    /**  */
    private String data1;
    
    /**  */
    private String data2;
    
    /**  */
    private String data3;
    
    /**  */
    private String data4;
    
    /**  */
    private String data5;
    
   
}