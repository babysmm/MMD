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
public class WXUserInfo {
	
	private String memberId;
	
	private String avatarUrl;
	
	private String city;
	
	private String country;
	
	private Integer gender;
	
	private String language;
	
	private String nickName;
	
	private String province;
	
	private String code;
}
