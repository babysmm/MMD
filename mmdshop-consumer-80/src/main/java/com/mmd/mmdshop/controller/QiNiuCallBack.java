package com.mmd.mmdshop.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.cms.CMSException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @ClassName QiNiuCallBack.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class QiNiuCallBack {

	
	/**
	 * 七牛上传回调
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/common/qiniu/upload/callback",method=RequestMethod.POST)
	public void qiNiuCallback1(HttpServletRequest request, HttpServletResponse response) throws CMSException {
		try { 
		// 接收七牛回调过来的内容
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		System.out.println(sb);
			 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
}
