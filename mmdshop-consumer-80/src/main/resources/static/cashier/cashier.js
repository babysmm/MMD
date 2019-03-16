var isPrice = false;//判断是否在售卖，来控制模式选择

var modes = 0;

var totalPrices = 0;

var commodity = new Array();

var isTotalPrice = false;

$(".commodity-input-header").css("display", "none");

//关闭控制台
$.safe();

function arrearsShows() {
	var arrearsShow = $(".arrearsShow");

	if(arrearsShow.css("display") == 'none'){
		arrearsShow.css("display","block");
	}else{
		arrearsShow.css("display","none");
	}
}



function modeType(that,mode){
	if(isPrice == true) return;
	
	if(commodity.length != 0 || commArrayIsNull(commodity) != true){
		$.myAlert("警告","已在计价模式不能改","red",2000);	
		$.speechSynthesis("已在计价模式不能改",$("#audis"));
		return;
	}
	
	//清空表格
	$(".commodity-buy-show tr:not(:first)").empty("");
	//清除结算区数据
	$("#totalPrice").html("&nbsp;&nbsp;");
	$("#removeDecimal").val("");
	$("#priceMemory").val("");
	$("#giveChange").html("&nbsp;&nbsp;");
	
	totalPrices = 0;
	//if(modes != 0) return;

	$(".mode button").css("background","buttonface");
	$(that).css("background","#00BFFF");
	
	if(mode == 'retail'){
		modes = 1;
		//语音合成读出模式
		$.speechSynthesis("零售模式",$("#audis"));
	}else if(mode == 'wholesale'){
		modes = 2;
		//语音合成读出模式
		$.speechSynthesis("批发模式",$("#audis"));
	}else{
		$.myAlert("警告", "模式错误", "red", 2000);
	}
	$(".commodity-input-header").css("display", "block");
}

/*
 * 条形码输入
 */
$("input[name=barCode]").keydown(function(event){
	var val = $.inputSafe($(this).val());
	
	var commdoityNumber = $("input[name=commdoityNumber]");
	//按下enter检测
	if(event.keyCode == 13){
		//长度限制
		if(val.length == 0 || val.length > 15){
			$.myAlert("警告", "条形码长度错误", "red", 2000);
			return;
		}
		
		//输入内容是否正确
		if(isNaN(val)){
			$.myAlert("警告", "条形码错误", "red", 2000);
			return;
	    }
		
		
		//设置焦点
　		commdoityNumber.focus();
　		commdoityNumber.select();
　	}
	//结算
	if(val == '='){
		totalPrice();
	}
});


/**
 * 商品个数输入
 * @param event
 * @returns
 */
$("input[name=commdoityNumber]").on("input  propertychange",function(){
	var val = $.inputSafe($(this).val());
	
	var commdoityNumber = $("input[name=commodityPrice]");

	if(val.indexOf("&nbsp;") != -1){
		//长度限制
		if(commdoityNumber.length == 0 || commdoityNumber.length > 15){
			$.myAlert("警告", "商品个数长度错误", "red", 2000);
			return;
		}
		
		val = val.split("个").join("");
    	val = val.split("&nbsp;").join("");
		
		//输入转换
		var ival = parseInt(val);
		
		//alert(val)
		
	    if(isNaN(ival)){
	    	try{
	    		$("input[name=commdoityNumber]").val($.ChineseToNumber(val));
	    	}catch(error){
	    		$.myAlert("警告", "输入错误八 ", "red", 2000);
	    	}
	    }else{
	    	$("input[name=commdoityNumber]").val(val);
	    }
	    
	    console.log($("input[name=commdoityNumber]"));
	    
	    if($("input[name=commdoityNumber]").val() <= 0){
	    	$.myAlert("警告", "数量小于0 ", "red", 2000);
	    	$("input[name=commdoityNumber]").val("");
	    	return;
	    }
		
		//让价格输入框获得焦点
　		commdoityNumber.focus();
　		commdoityNumber.select();
	}
	//结算
	if(val == '='){
		totalPrice();
	}
});

/**
 * 商品单价输入单价
 * @returns
 */

$("input[name=commodityPrice]").on("input  propertychange",function(){
	var val = $.inputSafe($(this).val());
	var barCode = $("input[name=barCode]");

	if(val.indexOf("&nbsp;") != -1){
		//长度限制
		if(val.length == 0 || val.length > 15){
			$.myAlert("警告", "商品单价输入长度错误", "red", 2000);
			return;
		}
		
		ival = parseInt(val);
		
		//数据处理
		searchCommodity($.inputSafe($("input[name=barCode]").val()),$.inputSafe($("input[name=commdoityNumber]").val()),parseInt($.inputSafe($("input[name=commodityPrice]").val())));
		
		//让价格输入框获得焦点
　		barCode.focus();
　		barCode.select();
	}
	//结算
	if(val == '='){
		totalPrice();
	}
});

/**
 * 商品单价设置输入条形码
 * @param event
 * @returns
 */
$("input[name=commodityPrice]").keydown(function(event){
	
	var val = $.inputSafe($(this).val());
	var commdoityNumber = $("input[name=commdoityNumber]");
	
	if(event.keyCode == 13){	//按下回车检测(输入的是商品条形码)
		//长度限制
		if(val.length == 0 || val.length > 15){
			$.myAlert("警告", "商品单价输入长度错误", "red", 2000);
			return;
		}
		
		
		//数据处理
		searchCommodity($.inputSafe($("input[name=barCode]").val()),$.inputSafe($("input[name=commdoityNumber]").val()),null);
		
		//设置条形码
		$("input[name=barCode]").val(val);
		
		//让数量输入框获得焦点
　		commdoityNumber.focus();
　		commdoityNumber.select();	
　	}
	//结算
	if(val == '='){
		totalPrice();
	}
});


//结算
$("#closeAnAccount").click(function(){
	totalPrice();
})

//输入付款金额
$("#priceMemory").keydown(function(event){
	var val = $.inputSafe($(this).val());
	
	if(event.keyCode == 13){	//按下回车检测
		//长度限制
		if(val.length == 0 || val.length > 10){
			$.myAlert("警告", "付款金额输入长度错误", "red", 2000);
			return;
		}
		if(isNaN(val)){
			$.myAlert("警告", "输入付款金额错误", "red", 2000);
			return;
	    }
		
		var overPrice = $.inputSafe($("#removeDecimal").val());
		
		console.log(overPrice + "  " + val)
		
		if((val-overPrice) < 0){
			$.myAlert("警告", "输入付款金额错误", "red", 2000);
			return;
		}
		
		var giveChange = val - overPrice;
		$("#giveChange").html(giveChange);
		
		//语音合成读出付款
		$.speechSynthesis("总价"+overPrice+"元-付款"+val+"元-找零钱"+giveChange+"元",$("#audis"));
		
		//发送数据给后台
		postForCommodity(modes,2,countNum(),giveChange,totalPrices,commodity,overPrice);
　	}
});

//全局按钮事件
$(document).keydown(function(event){
	if(event.keyCode == 187){
		totalPrice();
		$("#priceMemory").val("");
	} 
	//L按下
	if(event.keyCode == 76){
		modeType($("#modeL"),'retail');
	} 
	//P按下
	if(event.keyCode == 80){
		modeType($("#modeP"),'wholesale');
	} 
});

$(document).on("click",".delect-commodity",function () {
	if(isTotalPrice == true){
		//结算模式禁止修改商品
		return;
	}
	//alert(1)
	//删除商品
	var time = $(this).attr("time");
	//删除存储数据
	commodity[time] = null;
	
	var td = $(this).parent().parent();
	//删除表格数据
	td.remove();
	
	//语音合成删除
	$.speechSynthesis("删除商品",$("#audis"));
})

$("#priceMemory").on("input  propertychange",function(){
	var val = $.inputSafe($(this).val());
	if(val.indexOf("=") != -1){
		$("#priceMemory").val("");
	}
});

//欠账按钮
$("#billsDue").click(function() {
	//发送数据给后台
	var postResult = postForCommodity(modes,1,countNum(),null,totalPrices,commodity,null);
	
	if(postResult == null){
		return null;
	}
	
	//清空表格
	$(".commodity-buy-show tr:not(:first)").empty("");
	//清除结算区数据
	$("#totalPrice").html("&nbsp;&nbsp;");
	$("#removeDecimal").val("");
	$("#priceMemory").val("");
	$("#giveChange").html("&nbsp;&nbsp;");
	$(".mode button").css("background","buttonface");
	//alert(totalPrices)
	
	totalPrices = 0;
});

//欠账还款
$(document).on("click",".arrears-over",function () {
	var that = this;
	var marketOrderId = $(this).attr("orderid");
	//alert(marketOrderId)
	
	//alert(1)
	$.post("/consumer/changeState", {
		'marketOrderId' : marketOrderId
	}, function(result) {
		if (result != null && result.length != 0) {
			if(result == true){
				//清除欠账orderid
				$(that).parent().parent().remove();
				
				//修改成功提示
				$.myAlert("信息","欠款完成","green",2000);
			}
		} else {
			$.myAlert("警告", "欠款错误", "red", 2000);
		}
	});
})


//结算函数
function totalPrice(){
	
	$("input[name=barCode]").val("");
	$("input[name=commdoityNumber]").val("");
	$("input[name=commodityPrice]").val("");
	
	if(commodity.length == 0 || commArrayIsNull(commodity) == true){
		$.myAlert("警告","没有商品","red",2000);	
		//语音合成删除
		$.speechSynthesis("没有商品",$("#audis"));
		return;
	}
	
	//语音合成读出结算
	$.speechSynthesis("结算",$("#audis"));
	
	isTotalPrice = true;
	//设置数据输入框隐藏
	$(".commodity-input-header").css("display", "none");
	//设置欠账按钮显示
	$("#billsDue").css("display", "block");
	
	//console.log(commodity)
	var totalPrice = 0;
	
	for(var i=0;i<commodity.length;i++){
		if(commodity[i] == null){
			continue;
		}
		totalPrice += commodity[i]["totalPrices"];
	}
	
	totalPrices = totalPrice;
	
	$("#totalPrice").html(totalPrice);
	
	var removeDecimal = Math.floor(totalPrice)
	
	$("#removeDecimal").val(removeDecimal);
	
	var priceMemory = $("#priceMemory");
	
	$("#removeDecimal").removeAttr("readOnly");
	$("#priceMemory").removeAttr("readOnly");
	
	priceMemory.focus();
	priceMemory.select();
	
	
	$("#priceMemory").val("");
	
	//结算区显示
	$(".price-show").css("display", "block");
}

var commodityNum = 0;

function searchCommodity(barCode,number,price){
	console.log("barCode:"+barCode)
	//输入内容是否正确
	if(isNaN(barCode)){
		$.myAlert("警告", "条形码错误", "red", 2000);
		return;
    }
	console.log("number"+number)
	if(isNaN(number)){
		$.myAlert("警告", "数量错误", "red", 2000);
		return;
    }
	console.log("price"+price)
	if(isNaN(price)){
		$.myAlert("警告", "金额错误", "red", 2000);
		return;
    }
	
	$.post("/consumer/searchCommodity", {
		'barCode' : barCode
	}, function(result) {
		if (result != null && result.length != 0) {
			
			console.log()
			
			//如果没有输入价格设置数据库返回价格
			if(isNaN(price) == true || price == null){
				if(modes == 1){		//零售
					price = result.commodityDO.retailPrice;
					console.log("retailPrice=:"+result.commodityDO.retailPrice)
				}else if(modes == 2){	//批发
					price = result.commodityDO.tradePrice;
					console.log("tradePrice=:"+result.commodityDO.tradePrice)
				}else{
					
				}
			}

			//算出商品总价
			var totalPrices = price * number;
			
			console.log(totalPrices+" = "+price+" * "+number)
			
			$.setFromTR(result, new Array(result.commodityDO.barCode,
					result.commodityDO.name, number,
					result.commodityTypeDO.type, result.commodityDO.number),
					commodityNum,".commodity-buy-show");
			
			//语音合成读出商品
			$.speechSynthesis(result.commodityDO.name+number+"个",$("#audis"));
			
			commodityNum++;
			
			var comm = {
					'barCode' : barCode,
					'number' : parseInt(number),
					'priceShow': price,
					'totalPrices':totalPrices,
					'commodityId':result.commodityDO.commodityId
			}
			
			commodity[commodity.length] = comm;
		} else {
			$.myAlert("警告", "没有搜索到商品", "red", 2000);
		}
	});
	
	$("input[name=barCode]").val("");
	$("input[name=commdoityNumber]").val("");
	$("input[name=commodityPrice]").val("");
}

/**
 * 判断记录数据是否为空
 */
function commArrayIsNull(array){
	for(var i=0;i<array.length;i++){
		if(array[i] != null){
			return false;
		}
	}
	return true;
}

//alert(new Date())

/**
 * 商品提交数据
 * 
 * @param modeType
 * @param state
 * @param commNumber
 * @param lastPrice
 * @param overPrice
 * @param commodityArray 商品数组
 * @returns
 */
function postForCommodity(modeType,state,commNumber,lastPrice,overPrice,commodityArray,overPrices){
	var ShopMarketDO = {
		'creationTime':new Date().Format("yyyy-MM-ddThh:mm:ss"),	//创建时间
		'modeType':modeType,			//模式(零售,批发)
		'state':state,				//状态(完成,欠账)
		'commNumber':commNumber,		//商品总数
		'allPrice':overPrice,			//最后金额
		'lastPrice':lastPrice,		//最后付款
		'overPrice':overPrices,			//完成金额
		'changeTime':new Date().Format("yyyy-MM-ddThh:mm:ss")
	}
	
	var sellJson = {
		'shopMarketDO':ShopMarketDO,
		'marketOrderCommDO':commodityArray
	}
	
	$.postData("/consumer/newCommodityOrder",sellJson,function(result){
		if(result != null && result.length != 0){
			if(result == null || result == 0){
				$.myAlert("信息","订单失败","red",2000);
				return null;
			}
			
			
			//欠账就在欠账记录显示
			if(state == 1){
				var time;
				
				var date = new Date();
				time = date.toLocaleString();
								
				var addHtml = "<div orderid='"+result+"'><div>欠账时间:&nbsp;<input type='data' name='' value='"+time+"' readonly='readonly'></div>"+
				  "<div>欠账金额:&nbsp;<input type=''number' name='' value='"+overPrice+"' readonly='readonly'></div>"+
				  "<div><button class='arrears-over' orderid='"+result+"'>欠账已还</button></div></div>";

				$(".arrears-from").append(addHtml);
				
				$.myAlert("信息","已记录欠账","green",2000);
			}
			
			commodity = new Array();
			//设置欠账隐藏
			$("#billsDue").css("display", "none");
			//设置模式按钮为浅色
			$(".mode button").css("background","buttonface");
			$.myAlert("信息","订单完成","green",2000);
			
			//结算区影藏
			//$(".price-show").css("display", "none");
			//结算区不能操作
			$("#removeDecimal").attr("readOnly",true);
			$("#priceMemory").attr("readOnly",true);
		}
	},function(){
		$.myAlert("警告","服务器错误喵喵喵4001","red",2000);	
		return null;
	})
	
}

var alert = function(){}

function countNum(){
	var number = 0;
	console.log(commodity)
	for(var i = 0;i<commodity.length;i++){
		if(commodity[i] == null){
			continue;
		}else{
			number += commodity[i]["number"];
		}
	}
	alert(number)
	return number;
}


//设置用户名(显示)
window.onload = function() {
	var changeType = sessionStorage.getItem('name');
	ct = JSON.parse(changeType);
	
	$("#cashierName").text("欢迎您\xa0"+ct+"\xa0"); 
	//语音合成读出用户名
	$.speechSynthesis("欢迎您"+ct,$("#audis"));
}


