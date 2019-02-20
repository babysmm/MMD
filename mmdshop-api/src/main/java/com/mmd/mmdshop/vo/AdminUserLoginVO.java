package com.mmd.mmdshop.vo;

import java.io.IOException;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.mmd.mmdshop.utils.WebUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * 后台管理登录业务层数据传输类
 * @author QJH
 * @version 1.0.0 2019-02-20
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
public class AdminUserLoginVO {
	
	/**
	 * 用户名
	 */
	private int username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * IP地址
	 */
	private String lastIp;
	
	/**
	 * 通过httpServletRequest获取IP地址
	 * @param httpRequest
	 * @throws IOException
	 */
	public void setLastIP(HttpServletRequest httpRequest) throws IOException {
		this.lastIp = WebUtils.getIpAddress(httpRequest);
	}
}
