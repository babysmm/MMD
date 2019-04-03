package com.mmd.mmdshop.controller.commodity;

import java.util.List;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.dbdo.CommodityTypeDO;

/**
 * 
 * @ClassName CommodityController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class CommodityTypeController_Consumer {
protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
	/**
	 * 商家获取商品类型
	 * @param marketResult
	 * @return
	 */
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/getCommodityType")
	public List<CommodityTypeDO> getCommodityType(HttpServletRequest httpServletRequest) {
		Integer shopId = Integer.parseInt(httpServletRequest.getSession().getAttribute("shopId").toString());
		return template.postForObject(ADMINUSERPROVIDER_URL+"/getCommodityType", shopId, List.class);
	}
	
	/**
	 * 会员获取商品类型
	 * @param marketResult
	 * @return
	 */
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/membergetCommodityType")
	public List<CommodityTypeDO> membergetCommodityType(Integer shopId) {
		return template.postForObject(ADMINUSERPROVIDER_URL+"/getCommodityType", shopId, List.class);
	}
}
