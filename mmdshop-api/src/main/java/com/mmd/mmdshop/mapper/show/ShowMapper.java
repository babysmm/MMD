package com.mmd.mmdshop.mapper.show;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.show.ShowResult;

@Mapper
public interface ShowMapper extends BaseMapper<ShowDDO>{
	List<ShowResult> selectShowByMinForList(@Param("item")Integer item,@Param("memberId")Integer memberId);
	
	Integer selectIsGood(@Param("showId")Integer showId,@Param("memberId")Integer memberId);
	
	boolean insertGood(@Param("showId")Integer showId,@Param("memberId")Integer memberId);
}
