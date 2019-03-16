package com.mmd.mmdshop.controller.market;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mmd.mmdshop.dbdo.MarketOrderCommDO;
import com.mmd.mmdshop.dbdo.ShopMarketDO;
import com.mmd.mmdshop.result.MarketResult;
import com.mmd.mmdshop.utils.BaiduSpeechSynthesis;
import com.mmd.mmdshop.utils.NoRepeatSubmit;
import com.mmd.mmdshop.utils.ParamValidation;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName ShopMarketController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class ShopMarketController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ParamValidation pv;
	
	@Autowired
	private BaiduSpeechSynthesis pss;
	
	/**
	 * 订单完成
	 * @param shopMarketDO
	 * @param commodityArray
	 * @return
	 */
	@PostMapping("/consumer/newCommodityOrder")
	@NoRepeatSubmit
	public Long newCommodityOrder(@RequestBody MarketResult marketResult,HttpServletRequest request) {
		//对商品数据进行判断
		List<MarketOrderCommDO> array = marketResult.getMarketOrderCommDO();
		
		//删除商品list中的null值
		array.removeAll(Collections.singleton(null));
		//是否有数据
		if(array.size() == 0) {
			return null;
		}
		
		//深入list校验是否有数据
		if(pv.isnotNull(array, "barCode", "number", "priceShow") == false) {
			return null;
		}
		
		//设置changeId
		marketResult.getShopMarketDO().setChangeUserId((Integer) request.getSession().getAttribute("userId"));
		
		return template.postForObject(ADMINUSERPROVIDER_URL+"/newCommodityOrder", marketResult, Long.class);
	}
	
	/**
	 * 欠账完成
	 * @param marketOrderId
	 * @return
	 */
	@PostMapping("/consumer/changeState")
	@NoRepeatSubmit
	public boolean changeState(Long marketOrderId) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/changeState", marketOrderId, boolean.class);
	}
	
	/**
	 * 语音合成接口
	 * @param context
	 * @return
	 * @throws JSONException
	 */
	@PostMapping("/consumer/getWordToSpeech")
	public String getWordToSpeech(String context) throws JSONException {
		return pss.synthesisToBase64(context);
	}
	
	/**
	 * 通过模式搜索定单
	 * @param mode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/findShopMarket")
	public List<ShopMarketDO> findShopMarket(@RequestBody int mode) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/findShopMarket", mode, List.class);
	}
	
	/**
	 * 通过时间段搜索定单
	 * @param mode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/findTimeShopMarket")
	public List<ShopMarketDO> findTimeShopMarket(JSONObject json) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/findTimeShopMarket", json, List.class);
	}
}
