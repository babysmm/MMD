package com.mmd.mmdshop.impls;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.MemberDO;
import com.mmd.mmdshop.mapper.member.MemberMapper;
import com.mmd.mmdshop.services.MemberService;
import com.mmd.mmdshop.utils.MD5Utils;
import net.sf.json.JSONObject;

@Transactional(timeout=10)
@Service
public class MemberServiceImpl implements MemberService{
	private final String sessionKeyPassword = "wedsf$&$(%*)^%^*((()xz9i5q4r(%8%98$%%#@&(*%*$#$320p9oxr#]";
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MemberMapper mapper;

	@Override
	public String memberLogin(JSONObject result) {
		
		String openId = (String) result.get("openid");
		String sessionKey = (String) result.get("session_key");
		
		//生成mySessionKey
		String mySessionKey = null;
		try {
			mySessionKey = MD5Utils.md5(result.getString("session_key"), sessionKeyPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//查询数据库里是否有这个会员
		QueryWrapper<MemberDO> queryWrapper = new QueryWrapper<MemberDO>();
		queryWrapper.select("member_id").eq("open_id", openId);
		MemberDO dbMember = mapper.selectOne(queryWrapper);
		
		System.out.println(dbMember == null);
		
		//存储openID,sessionKey,mySessionKey
		if(dbMember == null) {
			//新会员,新增会员
			mapper.insertMember(openId, sessionKey, mySessionKey);
		}
		
		//返回mySessionKey
		return mySessionKey;
	}
}
