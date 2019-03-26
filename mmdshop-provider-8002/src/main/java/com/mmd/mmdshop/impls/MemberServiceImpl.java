package com.mmd.mmdshop.impls;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.MemberDO;
import com.mmd.mmdshop.mapper.member.MemberMapper;
import com.mmd.mmdshop.result.member.MemberIndexInitResult;
import com.mmd.mmdshop.services.MemberService;
import com.mmd.mmdshop.utils.MD5Utils;
import com.mmd.mmdshop.utils.RedisUtil;
import com.mmd.mmdshop.utils.SerializeUtil;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

@Transactional(timeout=10)
@Service
public class MemberServiceImpl implements MemberService{
	private final String sessionKeyPassword = "wedsf$&$(%*)^%^*((()xz9i5q4r(%8%98$%%#@&(*%*$#$320p9oxr#]";
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	//初始化设置redis
    MemberServiceImpl() throws Exception {
    	Jedis jedis = redisUtil.getJedis();
    	//加入上部滑动图片
    	
    	String [] topImgUrls = new String[3];
    	topImgUrls[0] = "http://mm.xknow.net/1.jpg";
    	topImgUrls[0] = "http://mm.xknow.net/2.jpg";
    	topImgUrls[0] = "http://mm.xknow.net/3.jpg";
    	jedis.set("topImgUrls", SerializeUtil.serializeToString(topImgUrls));
    	
    	String [] topHostMessage = new String[3];
    	topHostMessage[0] = "喵喵喵1";
    	topHostMessage[0] = "喵喵喵2";
    	topHostMessage[0] = "喵喵喵3";
    	jedis.set("topHostMessage", SerializeUtil.serializeToString(topHostMessage));
    	
    	jedis.close();
    }

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

	@Override
	public MemberIndexInitResult findMemberIndexInitResult() throws Exception {
		Jedis jedis = redisUtil.getJedis();
		
		MemberIndexInitResult result = new MemberIndexInitResult();
		
		//顶部滑动图片设置
		result.setTopImgUrls((String[]) SerializeUtil.deserializeToObject(jedis.get("topImgUrls")));
		//设置头部热门消息
		result.setTopHostMessage((String[]) SerializeUtil.deserializeToObject(jedis.get("topHostMessage")));
		//设置热搜
		result.setHostSearch((String[]) SerializeUtil.deserializeToObject(jedis.get("hostSearch")));
		//特价图片
		result.setDiscounts((String[]) SerializeUtil.deserializeToObject(jedis.get("discounts")));
		//商品
		
		
		return null;
	}
}
