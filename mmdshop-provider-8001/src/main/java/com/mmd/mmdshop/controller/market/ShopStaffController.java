package com.mmd.mmdshop.controller.market;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mmd.mmdshop.dbdo.ShopStaffDO;
import com.mmd.mmdshop.result.CommodityStaffRrsult;
import com.mmd.mmdshop.service.market.ShopStaffService;

/**
 * 
 * @ClassName ShopStaffController.java
 * @author MM
 * @version 1.0
 * @date 2019/2/18
 */
@RestController
public class ShopStaffController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShopStaffService service;
	
	/**
	 * 收银员登录
	 * @param shopStaffDO
	 * @return
	 */
	@PostMapping("/provider/staffUserLogin")
	public ShopStaffDO staffUserLogin(@RequestBody ShopStaffDO shopStaffDO) {
		return service.doLogin(shopStaffDO);
	}
	
	/**
	 * 通过条形码搜索商品
	 * @param barCode
	 * @return
	 */
	@PostMapping("/provider/searchCommodity")
	public CommodityStaffRrsult searchCommodity(@RequestBody Long barCode) {
		return service.findCommodity(barCode);
	}
	
	/**
	 * 通过用户全名查询店员
	 * @param fullName 全名
	 * @return
	 */
	@PostMapping("/provider/findShopStaffByfullName")
	public ShopStaffDO findShopStaffByfullName(@RequestBody String fullName) {
		return service.findShopStaffByfullName(fullName);
	}
	
	/**
	 * 通过用户名查询店员
	 * @param username 用户名
	 * @return
	 */
	@PostMapping("/provider/findShopStaffByusername")
	public ShopStaffDO findShopStaffByusername(@RequestBody String username) {
		return service.findShopStaffByusername(username);
	}
	
	/**
	 * 增加店员
	 * @param shopStaffDO
	 * @return
	 */
	@PostMapping("/provider/addShopStaff")
	public boolean addShopStaff(@RequestBody ShopStaffDO shopStaffDO) {
		return service.addShopStaff(shopStaffDO);
	}
	
	/**
	 * 修改店员
	 * @param shopStaffDO
	 * @return
	 */
	@PostMapping("/provider/modifyShopStaff")
	public boolean modifyShopStaff(@RequestBody ShopStaffDO shopStaffDO) {
		return service.modifyShopStaff(shopStaffDO);
	}
	
	/**
	 * 删除店员
	 * @param shopStaffDO 
	 * @return
	 */
	@PostMapping("/provider/removeShopStaff")
	public int removeShopStaff(@RequestBody ShopStaffDO shopStaffDO) {
		return service.removeShopStaff(shopStaffDO);
	}
	
	
	/**
	 * 获取邮箱验证码
	 * @return
	 */
	@PostMapping("/provider/sendEmailCode")
	public Integer sendEmailCode(@RequestBody Integer userId) {
		System.out.println(userId);
		return service.sendEmailCode(userId);
	}
}