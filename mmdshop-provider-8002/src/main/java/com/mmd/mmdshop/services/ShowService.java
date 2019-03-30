package com.mmd.mmdshop.services;

import java.util.List;
import com.mmd.mmdshop.result.show.ShowResult;

import net.sf.json.JSONObject;

public interface ShowService {
	/**
	 * 查询新的show
	 * @return
	 */
	List<ShowResult> findNewShow(Integer memberId);
	
	/**
	 * 给shop点赞
	 * @param showId
	 * @return
	 */
	boolean addShowGood(JSONObject json);
}
