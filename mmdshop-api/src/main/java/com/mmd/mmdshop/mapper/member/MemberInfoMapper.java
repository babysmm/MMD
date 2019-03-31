package com.mmd.mmdshop.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;

@Mapper
public interface MemberInfoMapper extends BaseMapper<MemberInfoDO>{
	Boolean insertMemberInfo(@Param("memberId")Integer memberId);
}
