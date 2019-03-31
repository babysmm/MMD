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
public class ShowTalkMemberResult {
	
	/** 会员Id */
	private Integer memberId;
	
	/** 评论内容 */
	private String context;
	
	/** showId */
	private Long showId;
}
