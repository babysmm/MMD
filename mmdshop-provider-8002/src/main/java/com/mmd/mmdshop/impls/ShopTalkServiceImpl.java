package com.mmd.mmdshop.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mmd.mmdshop.mapper.shop.ShopTalkMapper;
import com.mmd.mmdshop.result.shop.ShopTalkResult;
import com.mmd.mmdshop.services.ShopTalkService;

@Transactional(timeout=10)
@Service
public class ShopTalkServiceImpl implements ShopTalkService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopTalkMapper mapper;

	@Override
	public ShopTalkResult findShopTalk(Integer shopId) {
		return mapper.selectShopTalk(shopId);
	}

}
