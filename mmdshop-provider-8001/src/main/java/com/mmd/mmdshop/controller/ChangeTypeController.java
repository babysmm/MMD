package com.mmd.mmdshop.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.ChangeTypeDO;
import com.mmd.mmdshop.service.ChangeTypeService;

/**
 * 
 * @ClassName ChangeTypeController.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@RestController
public class ChangeTypeController{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ChangeTypeService service;
	
	@PostMapping("/provider/findChangeType")
	public List<ChangeTypeDO> findChangeType() {
		return service.find();
	}
	
	@PostMapping("/provider/findChangeTypeAll")
	public List<ChangeTypeDO> findChangeTypeAll() {
		return service.findAll();
	}
	
	@PostMapping("/provider/modifyChangeType")
	public int modifyChangeType(@RequestBody ChangeTypeDO changeTypeDO) {
		return service.modifyChangeType(changeTypeDO);
	}
}
