package com.mmd.mmdshop.result.member;

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
public class WXUserResult {
	
	private Integer memberId;
	
	private String headImg;
	
	private String country;
	
	private Integer gender;
	
	private String wxName;
}
