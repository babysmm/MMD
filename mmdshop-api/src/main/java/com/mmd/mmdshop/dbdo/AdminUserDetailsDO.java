

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
 * 后端用户详情表\r\n主要用于展示用户详情(admin_user_details)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("admin_user_details")
public class AdminUserDetailsDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1780367464486273050L;
    
    /** 用户ID */
    @TableId(value="user_id",type=IdType.AUTO)
    private Integer userId;
    
    /** 电子邮箱 */
    private String email;
    
    /** 身份证 */
    private String cardId;
    
    /** 全名 */
    private String fullName;
    
    /** 性别 */
    private int sex;
    
    /** 生日 */
    private Date birthday;
    
    /** 注册时间 */
    private Date registerTime;
    
    /** 最后一次登录IP */
    private String lastIp;
    
    /** 最后一次登录时间 */
    private Date lastTime;
    
    /**  */
    private String changeId;
    
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