package com.mmd.mmdshop.services;

import java.util.List;

import com.mmd.mmdshop.result.show.ShowTalkMemberResult;
import com.mmd.mmdshop.result.show.ShowTalkResult;

public interface ShowTalkService {
	
	/**
	 * 通过showId获得
	 * @return
	 */
	List<ShowTalkResult> getShowTalkById(Integer showId);
	
	boolean addNewShowTalk(ShowTalkMemberResult result);
}
