package com.mmd.mmdshop.impls;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mmd.mmdshop.mapper.show.ShowTalkMapper;
import com.mmd.mmdshop.result.show.ShowTalkMemberResult;
import com.mmd.mmdshop.result.show.ShowTalkResult;
import com.mmd.mmdshop.services.ShowTalkService;

@Transactional(timeout=10)
@Service
public class ShowTalkServiceImpl implements ShowTalkService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowTalkMapper mapper;

	@Override
	public List<ShowTalkResult> getShowTalkById(Integer showId) {
		return mapper.selectShowTalkById(showId);
	}

	@Override
	public boolean addNewShowTalk(ShowTalkMemberResult result) {
		return mapper.insertShowTalk(result);
	}
}
