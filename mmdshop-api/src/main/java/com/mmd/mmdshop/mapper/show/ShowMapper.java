package com.mmd.mmdshop.mapper.show;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;

@Mapper
public interface ShowMapper extends BaseMapper<ShowDDO>{
	List<ShowDDO> selectShowByMinForList(@Param("item")Integer item);
}
