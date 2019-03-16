package com.mmd.mmdshop.impl.market;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmd.mmdshop.dbdo.ShopStaffDO;
import com.mmd.mmdshop.mapper.market.ShopStaffMappper;
import com.mmd.mmdshop.result.CommodityStaffRrsult;
import com.mmd.mmdshop.service.market.ShopStaffService;
import com.mmd.mmdshop.utils.QQMail;


/**
 * 
 * @ClassName ShopStaffServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout=10)
@Service
public class ShopStaffServiceImpl implements ShopStaffService{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShopStaffMappper mapper;
	
	@Autowired
	private QQMail qqMail;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public ShopStaffDO doLogin(ShopStaffDO shopStaffDO) {
		QueryWrapper<ShopStaffDO> shopStaffDOWrapper = new QueryWrapper<ShopStaffDO>();
		shopStaffDOWrapper.select("password", "shop_staff_id","full_name").eq("username", shopStaffDO.getUsername());
		
		ShopStaffDO shopStaffDOResult = mapper.selectOne(shopStaffDOWrapper);
		
		//判断密码是否正确
		if (shopStaffDOResult != null && shopStaffDOResult.getPassword().equals(shopStaffDO.getPassword())) {
			// 获取用户Id
			Integer userId = shopStaffDOResult.getShopStaffId();
			//更新lastIP和时间
			mapper.setLastIpAndTimeById(shopStaffDO.getLastIp(), userId);
			
			return shopStaffDOResult;
		}else {
			return null;
		}
	}
	
	@Override
	public CommodityStaffRrsult findCommodity(Long barCode) {
		return mapper.getCommodityByBarCode(barCode);
	}
	
	@Override
	public ShopStaffDO findShopStaffByfullName(String fullName) {
		QueryWrapper<ShopStaffDO> shopStaffDOWrapper = new QueryWrapper<ShopStaffDO>();
		shopStaffDOWrapper.select("username", "full_name", "email").eq("full_name", fullName);
		return mapper.selectOne(shopStaffDOWrapper);
	}

	@Override
	public ShopStaffDO findShopStaffByusername(String username) {
		QueryWrapper<ShopStaffDO> shopStaffDOWrapper = new QueryWrapper<ShopStaffDO>();
		shopStaffDOWrapper.select("username", "full_name", "email").eq("username", username);
		return mapper.selectOne(shopStaffDOWrapper);
	}

	@Override
	public boolean addShopStaff(ShopStaffDO shopStaffDO) {
		return mapper.insertShopStaff(shopStaffDO);
	}

	@Override
	public boolean modifyShopStaff(ShopStaffDO shopStaffDO) {
		return mapper.upDataShopStaff(shopStaffDO);
	}

	@Override
	public int removeShopStaff(ShopStaffDO shopStaffDO) {
		return mapper.deleteById(shopStaffDO);
	}

	@Override
	public Integer sendEmailCode(int userId) {
		
		int code = (int)(1+Math.random()*1000000);
		
		if(qqMail.sendTextMail(mapper.findEmail(userId), "收银系统店主验证码", "验证码:"+code, javaMailSender) == true) {
			return code;
		}else {
			return null;
		}
	}

}
