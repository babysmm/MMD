package com.mmd.mmdshop.controller.show;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.result.QiNiuResult;
import com.mmd.mmdshop.result.show.ShowResult;
import com.mmd.mmdshop.services.ShowService;
import net.sf.json.JSONObject;

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
	public List<ShowResult> getNewShowMessage(@RequestBody Integer memberId) throws Exception {
		return service.findNewShow(memberId);
	}
	
	/**
	 * 秀点赞
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/provider/showGood")
	public boolean showGood(@RequestBody JSONObject jsonObject) throws Exception {
		return service.addShowGood(jsonObject);
	}
	
	/**
	 * 增加show
	 * @param 
	 * @return
	 */
	@PostMapping("/provider/addNewShow")
	public QiNiuResult addNewShow(@RequestBody ShowResult result) {
		return service.addNewShow(result);
	}
}
