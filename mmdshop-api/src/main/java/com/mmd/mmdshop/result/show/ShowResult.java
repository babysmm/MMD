package com.mmd.mmdshop.result.show;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
public class ShowResult {
	/** 社会秀ID */
    private Integer showId;
    
    /** 用户ID */
    private Integer userId;
    
    private String torUrl;
    
    /** 发出时间 */
    private Date addTime;
    
    /** 内容 */
    private String content;
    
    /** 点赞数 */
    private Integer good;
    
    /** 评论数 */
    private Integer talk;
    
    private Integer look;
    
    /** 转发数 */
    private Integer transpond;
    
    /** 图片1 */
    private String img1;
    
    /** 图片2 */
    private String img2;
    
    /** 图片3 */
    private String img3;
    
    /** 是否点赞 */
    private Integer isGood;
    
    private String grade;
    
    private String member;
}
