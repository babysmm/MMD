package com.mmd.mmdshop.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mmd.mmdshop.mapper.show.ShowMapper;
import com.mmd.mmdshop.result.show.ShowResult;
import com.mmd.mmdshop.services.ShowService;

import net.sf.json.JSONObject;

@Transactional(timeout=10)
@Service
public class ShowServiceImpl implements ShowService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowMapper mapper;

	@Override
	public List<ShowResult> findNewShow(Integer memberId) {
		return mapper.selectShowByMinForList(10,memberId);
	}

	@Override
	public boolean addShowGood(JSONObject json) {
		Integer showId = (Integer)json.getInt("showId");
		Integer memberId = mapper.selectIsGood(showId, json.getInt("memberId"));
		
		//没有点赞记录
		if(memberId == null) {
			mapper.insertGood(showId, json.getInt("memberId"));
			return true;
		}
		return false;
	}
}
