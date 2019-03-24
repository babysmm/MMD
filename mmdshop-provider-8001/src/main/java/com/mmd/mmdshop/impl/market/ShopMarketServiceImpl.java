package com.mmd.mmdshop.impl.market;

import java.math.BigDecimal;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmd.mmdshop.dbdo.CommodityDO;
import com.mmd.mmdshop.dbdo.MarketOrderCommDO;
import com.mmd.mmdshop.dbdo.ShopMarketDO;
import com.mmd.mmdshop.mapper.market.*;
import com.mmd.mmdshop.result.MarketResult;
import com.mmd.mmdshop.service.market.shopMarketService;
import com.mmd.mmdshop.utils.WebUtils;

/**
 * 
 * @ClassName ShopMarketServiceImpl.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@Transactional(timeout = 10)
@Service
public class ShopMarketServiceImpl implements shopMarketService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShopMarketMapper mapper;

	@Autowired
	private MarketOrderCommMappper commMappper;

	@Autowired
	private ShopStaffMappper staffMappper;

	@Override
	public Long addCommodityOrder(MarketResult marketResult) {
		ShopMarketDO shopMarketDO = marketResult.getShopMarketDO();
		List<MarketOrderCommDO> array = marketResult.getMarketOrderCommDO();

		int modeType = marketResult.getShopMarketDO().getModeType();

		System.out.println(array.size());
		
		// 判断模式是否正确
		if (array.size() < 10) { // 零售模式
			if (commodityListPriceValidation(array, modeType) == false) {
				return null;
			}
		} else if (array.size() > 10) { // 批发模式
			if (commodityListPriceValidation(array, modeType) == false) {
				return null;
			}
		}

		// 设置修改类型
		shopMarketDO.setChangeType(4);

		System.out.println("最终结果:" + array);
		
		//设置详情表创建时间
		shopMarketDO.setCreationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		// 新增一个商店订单详情表
		mapper.insert(shopMarketDO);
		// 获取新增id
		Long marketOrderId = shopMarketDO.getMarketOrderId();

		// 新增订单商品表
		commMappper.insertMarketOrderComm(array, marketOrderId);

		return marketOrderId;
	}

	@Override
	public boolean modifyState(Long marketOrderId) {
		return commMappper.updateState(marketOrderId);
	}

	/**
	 * 商品收银数据校验List
	 * 
	 * @param array
	 *            前台传入数据
	 * @param mode
	 *            后台搜索到的数据
	 * @return true 数据符合规范 false 数据不符合规范
	 */
	private boolean commodityListPriceValidation(List<MarketOrderCommDO> array, int mode) {
		for (int i = 0; i < array.size(); i++) {
			MarketOrderCommDO result = array.get(i);
			CommodityDO db = staffMappper.getCommodityByBarCode(result.getBarCode()).getCommodityDO();

			if (this.commodityPriceValidation(result, db, mode) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 商品收银数据校验
	 * 
	 * @param result
	 *            前台传入数据
	 * @param db
	 *            后台搜索到的数据
	 * @param mode
	 *            模式
	 * @return true 数据符合规范 false 数据不符合规范
	 */
	private boolean commodityPriceValidation(MarketOrderCommDO result, CommodityDO db, int mode) {
		// 是否查询到
		if (db == null) {
			return false;
		}

		BigDecimal priceAway = null;

		//模式校验
		if (mode == 1) {
			priceAway = db.getRetailPrice().subtract(result.getPriceShow()).abs();
		} else if (mode == 2) {
			priceAway = db.getTradePrice().subtract(result.getPriceShow()).abs();
		} else {
			return false;
		}

		// 判断输入的价格是否超过预期
		if (priceAway.compareTo(new BigDecimal(3)) == 1) {
			return false;
		}
		
		//设置商品ID
		result.setCommodityId(db.getCommodityId());

		return true;
	}

	@Override
	public List<ShopMarketDO> findShopMarket(int mode) {
		switch(mode) {
			case 1:return mapper.getTodayShopMarketList();
			case 2:return mapper.getSevenDayShopMarketList();
			case 3:return mapper.getMouthShopMarketList();
			default:return null;		
		}
	}

	@Override
	public List<ShopMarketDO> findTimeShopMarket(String start, String end) {
		if(WebUtils.isValidDate(start) == false || WebUtils.isValidDate(end)) {
			return null;
		}else {
			return mapper.getShopMarketList(start, end);
		}
	}

}
