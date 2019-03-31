var qiniuyunURL = "http://mm.xknow.net/";
//var qiniuyunURL = "pojrz1xjh.bkt.clouddn.com/";
var commodityMode = 1;//0:新增模式 1:保存模式

/**
 * 搜索商品
 * @returns
 */
$("#searchCommodity").click(function() {
	var val = $("#searchCommodityInput").val();
	
	var url = null;
	
	if(isNaN(val)){		//是商品名称
		url = "/consumer/searchCommodityDOByName";
	}else{				//是商品条形码
		url = "/consumer/searchCommodityDOByBarCode";
	}
	
	if(url == null){
		return;
	}
	
	$.post(url, {
		'commodityIdentity' : val
	}, function(result) {
		console.log(result);
		if (result != null && result.length != 0) {
			$('#commodityFrom')[0].reset();
			$('#commodityDefFrom')[0].reset();
			$('#commodityStateFrom')[0].reset();
			$('#commodityPriceFrom')[0].reset();
			$('#commodityGoodFrom')[0].reset();
			
			
			
			$("#commodityFrom").setObjectForm(result);
			$("#commodityDefFrom").setObjectForm(result);
			$("#commodityStateFrom").setObjectForm(result);
			$("#commodityPriceFrom").setObjectForm(result);
			$("#commodityGoodFrom").setObjectForm(result);
			
			//设置缩略图
			var thumb = qiniuyunURL+result.commodityDO.thumb;
		
			
			if(validateImage(thumb) == true){
				$("#img-c").attr("src",thumb);
			}
			
			//设置图片
			for(var i=1;i<6;i++){
				var img = result.commodityImgDO["img"+i];
				
				if(img!=null){
					var imgurl = qiniuyunURL+img;
					//判断是否404
					if(validateImage(imgurl) == true){
						$("#img"+i).attr("src",imgurl);
					}
				}
			}
			
		} else {
			$.myAlert("警告", "没有搜索到哦", "red", 2000);
		}
	});
	
})

function validateImage(url)
{    
        var xmlHttp ;
        if (window.ActiveXObject)
         {
          xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
         }
         else if (window.XMLHttpRequest)
         {
          xmlHttp = new XMLHttpRequest();
         } 
        xmlHttp.open("Get",url,false);
        xmlHttp.send();
        if(xmlHttp.status==404)
        return false;
        else
        return true;
}


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
		getCommodityFrom("/consumer/addCommodity");
		commodityMode = 1;
	}else{						//保存商品
		getCommodityFrom("/consumer/modifyCommodity");
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
function getCommodityFrom(url){
	//数据校验
	var s = $.isNotNull("#commodityFrom",new Array("commodityDO.barCode","commodityDO.name","commodityDO.keywords","commodityBrandDO.address"));
	var c = $.isNotNull("#commodityDefFrom",new Array("commodityDO.weight",
														"commodityDO.number",
														"commodityDO.integral",
														"commodityDO.note",
														"commodityDO.address"));
	
	var w = $.isNotNull("#commodityPriceFrom",new Array("commodityDO.marketPrice",
														"commodityDO.primeCost",
														"commodityDO.lowPrice",
														"commodityDO.retailPrice",
														"commodityDO.tradePrice",
														"commodityDO.maxNumber",
														"commodityDO.minNumber"));
	var a = $.isNotNull("#commodityPriceFrom",new Array("commodityDO.evaluate"));
	
	//获取数据
	var obj = $.getObjFrom(new Array("#commodityFrom","#commodityDefFrom","#commodityStateFrom","#commodityPriceFrom","#commodityGoodFrom"));
	
	console.log(obj)
	
	
	//提交后台
	$.postData(url, obj["commodityDO"],function(result) {
		if (result != null && result.length != 0) {
			
			console.log(result)
			
			for(var i=0;i<6;i++){
				if(img['img'+(i+1)] != null ){
					$.qiniuUp(img['img'+(i+1)],"123.img",result["key"][i],result["token"][i]);
				}
			}
			
		} else {
			
		}
	}, null);
}

var brandLength = 0;

//打开品牌
$("#commodityBrand").click(function(){
	//加载全部品牌信息
	brandInit();
})

$("#allCommodityBrand").click(function(){
	//删除表格
	$('#CommodityType tr td').remove();
	brandInit();
})

$("#addCommodityBrand").click(function() {
	addCommoditBrand(null,(brandLength+1),"","add");
	brandLength++;
})

//删除
$(function(){				
	$('body').on('click' , '.delBrand' , function() {
		var dom = this;
		$.post('/consumer/removeCommodityBrand', {
			'brandId' : $(this).attr("brandId"),
		}, function(result) {
			if (result != null && result.length != 0) {
				if(result == true){
					$(dom).parent().parent().remove()
				}
			} else {
				
			}
		});
		
	})
});

//保存
$(function(){				
	$('body').on('click' , '.upDataBrand' , function() {
		var dom = this;
		var type = $(dom).attr("types");
		var val = $(dom).parent().parent().find("input").val();
		
		console.log(val.length)
		if(val.length>15 || val.length<1){
			$.myAlert("警告", "品牌长度不对", "red", 2000);
		}
		
		if(type == 'add'){		//新增
			upLoadCommodityBrand("/consumer/addCommodityBrand",null,val);
		}else{					//保存
			upLoadCommodityBrand("/consumer/modityCommodityBrand",$(dom).attr("brandId"),val);
		}
		
	})
});

function upLoadCommodityBrand(url,id,name){
	$.postData(url, {
		"brandId":id,
		"name":name
	},function(result) {
		if (result != null && result.length != 0) {
			if(result == true){
				brandInit();
			}else{
				
			}
		} else {
			
		}
	}, null);
}

function brandInit(){
	$("#CommodityType tr:gt(0)").empty();
	$.postData("/consumer/searchCommodityBrand", null,function(result) {
		if (result != null && result.length != 0) {
			
			for(var i=0;i<result.length;i++){
				addCommoditBrand(result[i].brandId,(i+1),result[i].name,null);
			}
			
			brandLength = result.length;
		} else {
			
		}
	}, null);
}

function addCommoditBrand(id,item,name,type){
	var addHtml = "<tr><td>"+item+"</td><td><input type='text' value='"+name+"'></td>"+
	"<td>"+
		"<button brandId='"+id+"' class='upDataBrand' types='"+type+"'>保存</button>"+
		"<button brandId='"+id+"' class='delBrand'>删除</button>"+
	"</td></tr>";
	$("#CommodityType").append(addHtml);
}