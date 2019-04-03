package com.mmd.mmdshop.result.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class ShopTalkResult {
	
	/** 会员评分 */
    private Integer grade;
    
    /** 内容 */
    private String context;
    
    /** 商家回复 */
    private String shopReply;
    
    /** 微信名字 */
    private String wxName;
    
    /** 会员头像图片 */
    private String headImg;
}
