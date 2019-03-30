package com.mmd.mmdshop.controller.show;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.result.show.ShowTalkResult;
import com.mmd.mmdshop.services.ShowTalkService;

@RestController
public class ShowTalkController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowTalkService service;
	
	/**
	 * 获取最新show讨论
	 * @param code 小程序code
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/provider/getShowTalk")
	public List<ShowTalkResult> getShowTalk(@RequestBody Integer showId) throws Exception {
		return service.getShowTalkById(showId);
	}
}
