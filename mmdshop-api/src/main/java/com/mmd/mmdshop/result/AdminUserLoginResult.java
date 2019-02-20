package com.mmd.mmdshop.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 后台管理登录表现层数据传输
 * @author QJH
 * @version 1.0.0 2019-02-20
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
public class AdminUserLoginResult {
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 用户全名
	 */
	private String fullName;
	
	/**
	 * 用户权限
	 */
	private int userjurisdiction;
}
