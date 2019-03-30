package com.mmd.mmdshop.result.show;

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
public class ShowTalkResult {
    
    /** 社会秀ID */
    private Integer showId;
    
    /** 评论内容 */
    private String content;
    
    /** 微信名字 */
    private String wxName;
    
    /** 会员头像图片 */
    private String headImg; 
    
    /** 用户等级 */
    private Integer grade;
    
    /** 会员类型 */
    private String mberType;
}
