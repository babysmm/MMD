var commodityMode = 1;//0:新增模式 1:保存模式

/**
 * 保存商品
 * @returns
 */
$("#searchCommodity").click(function() {
	
})

/**
 * 新建商品
 * @returns
 */
$("#newCommodity").click(function() {
	//清除表单
	clearCommodityFrom();
	//设置现在模式为新增模式
	commodityMode = 0;
	
})

/**
 * 保存商品
 * @returns
 */
$("#saveCommodity").click(function() {
	if(commodityMode == 0){		//新增商品
		getCommodityFrom();
		commodityMode = 1;
	}else{						//保存商品
		
	}
})

/**
 * 删除商品
 * @returns
 */
$("#delCommodity").click(function() {
	
})

/**
 * 清空商品所有表单和设置图片为初始状态
 * @returns
 */
function clearCommodityFrom() {
	//清空表单
	$("#commodityFrom")[0].reset();
	$("#commodityDefFrom")[0].reset();
	$("#commodityStateFrom")[0].reset();
	$("#commodityPriceFrom")[0].reset();
	$("#commodityGoodFrom")[0].reset();
	//设置图片为加好图片
	$(".comm-img").attr("src","../backstageMange/images/addImg.png");
}


/**
 * 获取表单数据封装成对象
 * @returns
 */
function getCommodityFrom(){
	//数据校验
	var s = $.isNotNull("#commodityFrom",new Array("commodityDO.barCode","commodityDO.name","commodityTypeDO.type","commodityDO.keywords","commodityBrandDO.name","commodityBrandDO.address"))
	
	//获取数据
	var obj = $.getObjFrom(new Array("#commodityFrom","#commodityDefFrom","#commodityStateFrom","#commodityPriceFrom","#commodityGoodFrom"));
	
	//获取图片有几张
	var imgLength = 0;
	for(var o in img){  
        if(img[o] != null){
        	imgLength++;
        }
	}  
	//通过设置商品ID来设置图片数量
	obj["commodityDO"]["commodityId"] = imgLength;
	
	//提交后台
	$.postData("/consumer/addCommodity", obj["commodityDO"],function(result) {
		if (result != null && result.length != 0) {
			console.log(result)
			
			for(var i=0;i<6;i++){
				if(result.key[i] != null || result.token[i] != null){
					var s = i+1;
					
					$.qiniuUp(img['img'+s],"123.img",result["key"][i],result["token"][i]);
				}
			}
		} else {

		}
	}, null);
}

function send(){
	
}