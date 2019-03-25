package com.mmd.mmdshop.result.member;

import com.mmd.mmdshop.result.commodity.CommodityRough;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class MemberIndexInitResult {
	
	/**
	 * 顶部滑动栏图片地址
	 */
	private String[] topImgUrls;
	
	/**
	 * 热搜
	 */
	private String[] hostSearch;
	
	/**
	 * 头部热门消息
	 */
	private String[] topHostMessage;
	
	/**
	 * 特价图片
	 */
	private String[] discounts;
	
	/**
	 * 商品
	 */
	private CommodityRough[] commodity;
}
