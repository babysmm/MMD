package com.mmd.mmdshop.result.commodity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 商品粗略信息
 * @author computer
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
@JsonSerialize
public class CommodityRough implements Serializable{
	
	/** 商品条形码  */
	private Long id;
	
	/** 商品缩略图 */
    private String img;
    
    /** 商品名称 */
    private String commName;
    
    /** 市场价 */
    private BigDecimal price;
    
    /** 批发价 */
    private BigDecimal costpeo;
}
