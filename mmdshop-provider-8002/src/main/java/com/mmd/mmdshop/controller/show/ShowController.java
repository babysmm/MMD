package com.mmd.mmdshop.controller.show;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.ShowDDO;
import com.mmd.mmdshop.services.ShowService;

@RestController
public class ShowController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowService service;
	
	/**
	 * 获取最新show
	 * @param code 小程序code
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/provider/getNewShowMessage")
	public List<ShowDDO> getNewShowMessage() throws Exception {
		return service.findNewShow();
	}
}
