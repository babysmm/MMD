package com.mmd.mmdshop.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.ChangeTypeDO;
import com.mmd.mmdshop.mapper.ChangeTypeMapper;
import com.mmd.mmdshop.service.ChangeTypeService;

/**
 * 
 * @ClassName ChangeTypeServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout=10)
@Service
public class ChangeTypeServiceImpl implements ChangeTypeService{

	@Autowired
	private ChangeTypeMapper mapper;
	
	@Override
	public List<ChangeTypeDO> find() {
		QueryWrapper<ChangeTypeDO> wrapper = new QueryWrapper<ChangeTypeDO>();
		wrapper.select("change_id","name");
		return mapper.selectList(wrapper);
	}

	@Override
	public List<ChangeTypeDO> findAll() {
		QueryWrapper<ChangeTypeDO> wrapper = new QueryWrapper<ChangeTypeDO>();
		return mapper.selectList(wrapper);
	}

	@Override
	public int modifyChangeType(ChangeTypeDO changeTypeDO) {
		return mapper.upDataChangeType(changeTypeDO);
	}
}
