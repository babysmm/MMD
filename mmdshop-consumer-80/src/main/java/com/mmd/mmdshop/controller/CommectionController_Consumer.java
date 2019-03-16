package com.mmd.mmdshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mmd.mmdshop.result.CommodityAll;
import com.mmd.mmdshop.result.CommodityRough;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @ClassName CommectionController_Consumer.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@RestController
public class CommectionController_Consumer {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String ADMINUSERPROVIDER_URL = "http://localhost:8001/provider";
	
	@Autowired
	private RestTemplate template;
	
    
	
	@SuppressWarnings("unchecked")
	@PostMapping("/consumer/findCommodityRough")
	public List<CommodityRough> findCommodityRough(String name,HttpServletResponse response) throws IOException {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/findCommodityRough", name,List.class);
	}
	 
	@PostMapping("/consumer/findCommodityAll")
	public CommodityAll findCommodityAll(Integer commodityId)  throws  IOException {
		return template.postForObject(ADMINUSERPROVIDER_URL + "/findCommodityAll", commodityId, CommodityAll.class);
	}

}
