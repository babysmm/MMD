package com.mmd.mmdshop.impl.commodity;

import java.util.ArrayList;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.CommodityImgDO;
import com.mmd.mmdshop.mapper.commodity.CommodityImgMapper;
import com.mmd.mmdshop.mapper.commodity.CommodityMappper;
import com.mmd.mmdshop.result.CommodityAll;
import com.mmd.mmdshop.result.CommodityRough;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.commodity.CommodityBasic;
import com.mmd.mmdshop.service.commodity.CommodityService;
import com.mmd.mmdshop.utils.QiNiuYunUtils;
import com.mmd.mmdshop.utils.RedisUtil;
import com.mmd.mmdshop.utils.SnowflakeIdWorker;

/**
 * 
 * @ClassName CommodityServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout=10)
@Service
public class CommodityServiceImpl implements CommodityService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CommodityMappper mapper;
	
	@Autowired
	private CommodityImgMapper imgMapper;
	
	@Autowired
	private QiNiuYunUtils qiniu;
	
	@Autowired
	private SnowflakeIdWorker idWorker;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public List<CommodityRough> findCommodityRoughByName(String name) {
		return mapper.selectCommodityRoughByName(name);
	}
	
	@Override
	public CommodityAll findCommodityAllById(Integer id) {
		return mapper.selectCommodityAllById(id);
	}

	@Override
	public List<CommodityDO> replenishmentCommodityNumber(Integer shopId) {
		QueryWrapper<CommodityDO> commWrapper = new QueryWrapper<CommodityDO>();
		commWrapper.select("name","number","max_number","min_number").eq("shop_id", shopId);
		
		List<CommodityDO> db = mapper.selectList(commWrapper);
		List<CommodityDO> result = new ArrayList<CommodityDO>();
		
		for(int i=0;i<db.size();i++) {
			CommodityDO commodityDO = db.get(i);
			int minNumber = commodityDO.getMinNumber();
			int maxNumber = commodityDO.getMaxNumber();
			int number = commodityDO.getNumber();
			
			if(number < minNumber) {
				commodityDO.setNumber(maxNumber-number);
				result.add(commodityDO);
			}
		}
		
		System.out.println(result);
		
		return result;
	}

	@Override
	public QiNiuResult addCommodityBasic(CommodityDO commodityDO) {
		
		if(commodityDO.getCommodityId() == null || commodityDO.getCommodityId() > 6 || commodityDO.getCommodityId() < 1) {
			return null;
		}
		
		QiNiuResult q =  new QiNiuResult();
		
		String [] keya = new String[6];
		String [] token = new String[6];
		CommodityImgDO img = new CommodityImgDO();
		
		for(int i=0;i<commodityDO.getCommodityId();i++) {
			keya[i] = idWorker.nextId() + ".png";
			token[i] = qiniu.jsUploadToken("mmdshop", keya[i], 360000);
			
			//设置图片
			switch(i) {
				case 1:	img.setImg1(keya[i]);break;
				case 2:	img.setImg2(keya[i]);break;
				case 3:	img.setImg3(keya[i]);break;
				case 4:	img.setImg4(keya[i]);break;
				case 5:	img.setImg5(keya[i]);break;
			}
			
			System.out.println(keya[i]);
			System.out.println(token[i]);
			
		}
		
		q.setKey(keya);
		q.setToken(token);
		
		//设置缩略图
		commodityDO.setThumb(keya[0]);
		
		//清除commodityID
		commodityDO.setCommodityId(null);
		
		//存储商品图片
		Integer imgs = imgMapper.insert(img);
		
		//设置图片id
		commodityDO.setCommImgId(img.getCommImgId());
		
		//存储商品信息
		Integer commodity = mapper.insert(commodityDO);
		
		
		return q;
	}

	@Override
	public CommodityBasic findCommodityByBarCode(Integer barcode) {
		QueryWrapper<CommodityDO> commWrapper = new QueryWrapper<CommodityDO>();
		commWrapper.select().eq("bar_code", barcode);
		
		return this.getCommodityBasic(commWrapper);
	}
	
	@Override
	public CommodityBasic findCommodityByName(String name) {
		QueryWrapper<CommodityDO> commWrapper = new QueryWrapper<CommodityDO>();
		commWrapper.select().eq("name", name);
		return this.getCommodityBasic(commWrapper);
	}
	
	/**
	 * 通过不同的wrapper获取商品信息和图片
	 * @param commWrapper
	 * @return
	 */
	private CommodityBasic getCommodityBasic(QueryWrapper<CommodityDO> commWrapper) {
		
		CommodityBasic basic = new CommodityBasic();
		CommodityDO commodityDO = mapper.selectOne(commWrapper);
		basic.setCommodityDO(commodityDO);
		basic.setCommodityImgDO(imgMapper.selectById(commodityDO.getCommImgId()));
		
		return basic;
	}
	
}
