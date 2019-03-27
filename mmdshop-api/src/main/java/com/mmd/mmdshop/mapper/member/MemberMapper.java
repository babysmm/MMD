package com.mmd.mmdshop.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmd.mmdshop.dbdo.*;
import com.mmd.mmdshop.result.member.WXUserInfo;

@Mapper
public interface MemberMapper extends BaseMapper<MemberDO>{
	/**
	 * 插入新的会员
	 * @param openId
	 * @param sessionKey
	 * @param mySessionKey
	 * @return
	 */
	boolean insertMember(@Param("openId")String openId,@Param("sessionKey")String sessionKey,@Param("mySessionKey")String mySessionKey);
	
	/**
	 * 更新会员
	 * @param openId
	 * @param sessionKey
	 * @param mySessionKey
	 * @return
	 */
	boolean updataMember(@Param("memberId")String memberId,@Param("sessionKey")String sessionKey,@Param("mySessionKey")String mySessionKey);
	
	/**
	 * 更新用户微信名称
	 * @param info
	 * @return
	 */
	boolean updataMemberWXInfo(WXUserInfo info);
}
