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
	
	boolean insertShow(ShowResult result);
	
	boolean insertShowImg(@Param("showId")Integer showId,@Param("img1")String img1,@Param("img2")String img2,@Param("img3")String img3);
}
