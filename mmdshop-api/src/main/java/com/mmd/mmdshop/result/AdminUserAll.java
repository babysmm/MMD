package com.mmd.mmdshop.result;

import javax.validation.constraints.NotNull;
import com.mmd.mmdshop.dbdo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 搜索后台管理用户全部信息封装
 * 
 * @author MM
 * @version 1.0.0 2019-02-20
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class AdminUserAll {
	/**
	 * 后台管理用户表
	 */
	@NotNull
	private AdminUserDO adminUserDO;
	
	/**
	 * 后台管理详情用户表
	 */
	@NotNull
	private AdminUserDetailsDO adminUserDetailsDO;
	
	/**
	 * 后台管理权限表
	 */
	@NotNull
	private AdminUserJurisdictionDO adminUserJurisdictionDO;
	
	
}
