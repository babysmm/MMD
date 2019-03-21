package com.mmd.mmdshop.dbdo;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商品(commodity)
 * 
 * @author MM
 * @version 1.0.0 2019-02-19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@ToString
@TableName("commodity")
public class CommodityDO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 333078981054144442L;
    
    /** 商品ID */
    @TableId(value="commodity_id",type=IdType.INPUT)
    private Integer commodityId;
    
    /** 商家id */
    private Integer shopId;
    
    /** 商品类型 */
    private Integer commTypeId;
    
    /** 商品图片URL */
    private Integer commImgId;
    
    /** 商家商品类型 */
    private Integer shopCommTypeId;
    
    /** 商品缩略图 */
    private String thumb;
    
    /** 商品关键字 */
    private String keywords;
    
    /** 商品名称 */
    private String name;
    
    /** 商品重量 */
    private Integer weight;
    
    /** 商品数量 */
    private Integer number;
    
    /** 购买商品所得积分 */
    private Integer integral;
    
    /** 是否开始销售 */
    private int isOnSale;
    
    /** 是否有货 */
    private int inOutStock;
    
    /** 是否是新品 */
    private int isNew;
    
    /** 是否精品 */
    private Integer isGood;
    
    /** 是否热销 */
    private int isHot;
    
    /** 商品备注 */
    private String note;
    
    /** 商品生产地 */
    private String address;
    
    /** 商品评价百分比 */
    private Integer evaluate;
    
    /** 市场价 */
    private BigDecimal marketPrice;
    
    /** 好评数 */
    private Integer goodNum;
    
    /** 月销 */
    private String monthSales;
    
    /** 品牌id */
    private Integer brandId;
    
    /** 最低价 */
    private BigDecimal lowPrice;
    
    /** 供应商名称 */
    private String suppliersName;
    
    /** 供货商电话 */
    private Integer suppliersNumber;
    
    /** 变更ID */
    private Integer changeId;
    
    /** 变更时间 */
    private Date changeTime;
    
    /** 变更用户id */
    private Integer changeUserId;
    
    /** 创建时间 */
    private Date registerTime;
    
    /** 商品条形码 */
    private Long barCode;
    
    /** 进货价 */
    private BigDecimal primeCost;
    
    /** 零售价 */
    private BigDecimal retailPrice;
    
    /** 批发价 */
    private BigDecimal tradePrice;
    
    /** 最大供货数量 */
    private Integer maxNumber;
    
    /** 最小供货数量 */
    private Integer minNumber;
    
}