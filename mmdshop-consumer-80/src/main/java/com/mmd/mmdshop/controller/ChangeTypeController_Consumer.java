package com.mmd.mmdshop.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.dbdo.ChangeTypeDO;
import com.mmd.mmdshop.utils.ParamValidation;

/**
 * 
 * @ClassName ChangeTypeController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class ChangeTypeController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";

	@Autowired
	private RestTemplate template;

	@Autowired
	private ParamValidation pv;

	/**
	 * 获取所有变更类型
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/findChangeType")
	public List<ChangeTypeDO> findChangeType() {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/findChangeType", null, List.class);
	}

	/**
	 * 获取变更类型所有信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/findChangeTypeAll")
	public List<ChangeTypeDO> findChangeTypeAll() {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/findChangeTypeAll", null, List.class);
	}

	/**
	 * 变更类型修改
	 * 
	 * @param changeTypeDO
	 *            要修改的变更类型对象
	 * @param request
	 * @return
	 */
	@PostMapping("/consumer/modifyChangeType")
	public int modifyChangeType(@RequestBody ChangeTypeDO changeTypeDO, HttpServletRequest request) {
		// 获取session里面的userId,并且赋值给changeTypeDo对象
		changeTypeDO.setChangeUserId((Integer) request.getSession().getAttribute("userId"));

		// 对数据进行校验
		if (pv.isNotNull(changeTypeDO, "userId", "name") == false) {
			return 0;
		}

		// System.out.println(changeTypeDO);

		return template.postForObject(ADMINUSERPROVIDER_URL + "/modifyChangeType", changeTypeDO, int.class);
	}
}
