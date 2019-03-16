package com.mmd.mmdshop.service;

import java.util.List;

import com.mmd.mmdshop.dbdo.*;

public interface ChangeTypeService {
	/**
	 * 获取ChangeType的名字
	 * @return
	 */
	List<ChangeTypeDO> find();
	
	/**
	 * 获取所有ChangeType
	 * @return
	 */
	List<ChangeTypeDO> findAll();
	
	int modifyChangeType(ChangeTypeDO changeTypeDO);
}
