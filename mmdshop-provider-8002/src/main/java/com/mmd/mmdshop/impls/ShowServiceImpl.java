package com.mmd.mmdshop.impls;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mmd.mmdshop.mapper.member.MemberMapper;
import com.mmd.mmdshop.mapper.show.ShowMapper;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.member.WXUserResult;
import com.mmd.mmdshop.result.show.ShowResult;
import com.mmd.mmdshop.services.ShowService;
import com.mmd.mmdshop.utils.QiNiuYunUtils;
import com.mmd.mmdshop.utils.SnowflakeIdWorker;
import net.sf.json.JSONObject;

@Transactional(timeout=10)
@Service
public class ShowServiceImpl implements ShowService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowMapper mapper;
	@Autowired
	private MemberMapper mamberMapper;
	@Autowired
	private QiNiuYunUtils qiniu;
	
	@Autowired
	private SnowflakeIdWorker idWorker;

	@Override
	public List<ShowResult> findNewShow(Integer memberId) {
		return mapper.selectShowByMinForList(10,memberId);
	}

	@Override
	public boolean addShowGood(JSONObject json) {
		Integer showId = (Integer)json.getInt("showId");
		Integer memberId = mapper.selectIsGood(showId, json.getInt("memberId"));
		
		//没有点赞记录
		if(memberId == null) {
			mapper.insertGood(showId, json.getInt("memberId"));
			return true;
		}
		return false;
	}

	@Override
	public QiNiuResult addNewShow(ShowResult result) {
		
		WXUserResult user = mamberMapper.selectWXUserResult(result.getUserId());
		
		result.setTorUrl(user.getHeadImg());
		
		QiNiuResult q =  new QiNiuResult();
		
		String [] keya = new String[3];
		String [] token = new String[3];
		
		boolean isImg = false;
		
			if(result.getImg1() != null) {
				keya[0] = idWorker.nextId() + ".png";
				token[0] = qiniu.jsUploadToken("mmdshop", keya[0], 360000);
				isImg = true;
			}
			if(result.getImg2() != null) {
				keya[1] = idWorker.nextId() + ".png";
				token[1] = qiniu.jsUploadToken("mmdshop", keya[1], 360000);
				isImg = true;
			}
			if(result.getImg3() != null) {
				keya[2] = idWorker.nextId() + ".png";
				token[2] = qiniu.jsUploadToken("mmdshop", keya[2], 360000);
				isImg = true;
			}
			
		
		q.setKey(keya);
		q.setToken(token);
		
		//存储show
		mapper.insertShow(result);
		//存储图片
		if(isImg == true) {
			mapper.insertShowImg(result.getShowId(), keya[0], keya[1], keya[2]);
		}
		
		return q;
	}
}
