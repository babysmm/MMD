

package com.mmd.mmdshop.dbdo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
<<<<<<< HEAD
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
=======
import com.baomidou.mybatisplus.annotation.TableName;
>>>>>>> d7e69f43594d178de4114880955737a167083d98

/**
 * 变更(change_type)
 * 
 * @author QJH
 * @version 1.0.0 2019-02-19
 */
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
=======
>>>>>>> d7e69f43594d178de4114880955737a167083d98
@TableName("change_type")
public class ChangeTypeDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2049950392095083621L;
    
    /** 变更ID */
    @TableId(value="change_id",type=IdType.AUTO)
    private Integer changeId;
    
    /** 变更名字 */
    private String name;
    
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