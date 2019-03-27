package com.mmd.mmdshop.impls;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mmd.mmdshop.dbdo.ShowDDO;
import com.mmd.mmdshop.mapper.show.ShowMapper;
import com.mmd.mmdshop.services.ShowService;

@Transactional(timeout=10)
@Service
public class ShowServiceImpl implements ShowService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowMapper mapper;

	@Override
	public List<ShowDDO> findNewShow() {
		return mapper.selectShowByMinForList(10);
	}
}
