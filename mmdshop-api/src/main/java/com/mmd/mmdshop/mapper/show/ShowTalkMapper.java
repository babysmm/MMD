package com.mmd.mmdshop.mapper.show;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.show.ShowTalkMemberResult;
import com.mmd.mmdshop.result.show.ShowTalkResult;

@Mapper
public interface ShowTalkMapper extends BaseMapper<ShowTalkDO>{
	/**
	 * 查询show的讨论
	 * @return
	 */
	List<ShowTalkResult> selectShowTalkById(@Param("showId")Integer showId);
	
	/**
	 * 增加show评论
	 * @param result
	 * @return
	 */
	boolean insertShowTalk(ShowTalkMemberResult result);
}
