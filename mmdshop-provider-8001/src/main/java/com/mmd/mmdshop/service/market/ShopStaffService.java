package com.mmd.mmdshop.service.market;

import com.mmd.mmdshop.dbdo.ShopStaffDO;
import com.mmd.mmdshop.result.CommodityStaffRrsult;

/**
 * 
 * 
 * @author MM
 * @ClassName ShopStaffService.java
 * @version 1.0
 * @date 2019/2/18
 */
public interface ShopStaffService {
	/**
	 * 商店销售人员登录
	 * @param shopStaffDO
	 * @return
	 */
	ShopStaffDO doLogin(ShopStaffDO shopStaffDO);
	
	/**
	 * 通过商品条形码搜索商品
	 * @param barCode 条形码
	 * @return
	 */
	CommodityStaffRrsult findCommodity(Long barCode);
	
	/**
	 * 通过全名查询店员
	 * @param fullName
	 * @return
	 */
	ShopStaffDO findShopStaffByfullName(String fullName);
	
	/**
	 * 通过用户名查询店员
	 * @param fullName
	 * @return
	 */
	ShopStaffDO findShopStaffByusername(String username);
	
	/**
	 * 新增店员
	 * @param shopStaffDO
	 * @return
	 */
	boolean addShopStaff(ShopStaffDO shopStaffDO);
	
	/**
	 * 修改店员
	 * @param shopStaffDO
	 * @return
	 */
	boolean modifyShopStaff(ShopStaffDO shopStaffDO);
	
	/**
	 * 删除店员
	 * @param shopStaffDO
	 * @return
	 */
	boolean removeShopStaff(ShopStaffDO shopStaffDO);
	
	/**
	 * 发送验证码
	 * @return
	 */
	Integer sendEmailCode(int userId);
}
