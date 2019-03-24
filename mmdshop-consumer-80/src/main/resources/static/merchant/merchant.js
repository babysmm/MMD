var length = {
	"searchStaff" : [ 3, 10, 'number', "用户名" ],
	"emailcode" : [ 5, 6, 'number', "邮箱验证码" ],
	"username" : [2 ,10,'number','显示用户名'],
	"commodityDO.name" : [2 ,10,'text','条形码'],
}

var img = {
	img1:null,
	img2:null,
	img3:null,
	img4:null,
	img5:null,
	img6:null,
}

var upDataimgName = {
		
}



// 初始化是否已经清空表单，未清空0,已清空1
// 初始化是否已经获取验证码，未获取0,已获取1
var status = "0";
var emailstatus = '0';
hideEmail(status); // 是否隐藏Email
var shopStaffStatus = '0';// 是否显示表单 0：不显示 1：显示
hideshopStaff(shopStaffStatus);
$(".menuHeader").click(function() {
	var div = $(this).parent().attr('class');
	var section = $("." + div + ">section");

	if (section.css("display") == 'none') {
		$(this).css("border-left", "4px solid red");
		section.css("display", "block");
	} else {
		$(this).css("border-left", "");
		section.css("display", "none");
	}
});

$("#searchStaff").click(function() {
	status = "0";
	hideEmail(status);
	emailstatus = '0';
	var val = $.valM(".searchInput");
	$.post('/consumer/findShopStaffByusername', {
		'username' : val
	}, function(result) {
		if (result != null && result.length != 0) {
			if (result != null) {
				console.log(result);
				shopStaffStatus = '1';
				hideshopStaff(shopStaffStatus);
				//设置验证码显示
				$("#email").show();
				// 表单赋值
				$("#shopStaffDate").setForm(result);
				$('.passwordTr').css("visibility", "hidden");
			}
		} else {
			shopStaffStatus = '0';
			hideshopStaff(shopStaffStatus);
			$.myAlert("警告", "没有搜索到哦", "red", 2000);
		}
	});
});
// 新增模式清空店员表单
$("#clearStaff").click(function() {
	if (status == '0') {
		$('#shopStaffDate')[0].reset();
		$('.passwordTr').css("visibility", "visible");
		status = "1";
		hideEmail(status);
		shopStaffStatus = '1';
		hideshopStaff(shopStaffStatus);
		//设置username输入框可以被修改
		//$('.staffUsername').removeAttr('disabled');
		$(".staffUsername").attr("readOnly",false);
	}
});

/**
 * 新增和保存
 * @returns
 */
$("#saveStaff").click(function() {
	
	var data = getStaffData();
	
	var url = null;
	var success = null;
	
	if (status == '1') { // 新增模式
		url = "/consumer/addShopStaff";
		success = function(result) {
			if (result != null && result.length != 0) {
				if (result == true) {
					$('.passwordTr').css("visibility", "hidden");
					$.myAlert("提醒", "新增完成", "green", 2000);
					remStaffFrom();
				} else {
					$.myAlert("提醒", "新增失败", "green", 2000);
				}
			}
		}
	} else { // 保存模式
		url = "/consumer/modifyShopStaff";
		success = function(result) {
			if (result != null && result.length != 0) {
				if (result == true) {
					$('.passwordTr').css("visibility", "hidden");
					$.myAlert("提醒", "修改完成", "green", 2000);
					remStaffFrom();
				} else {
					$.myAlert("提醒", "修改失败", "green", 2000);
				}
			}
		}
	}
	
	if(url == null || success == null){
		return;
	}
	
	$.postData(url, data, success, null);
	
});

/**
 * 删除店员
 * @returns
 */
$("#delStaff").click(function() {
	
	var data = getStaffData();
	
	$.postData("/consumer/removeShopStaff", data, function(result) {
		if (result != null && result.length != 0) {
			if (result == true) {
				$.myAlert("提醒", "删除完成", "green", 2000);
				remStaffFrom();
			} else {
				$.myAlert("提醒", "删除失败", "green", 2000);
			}
		}
	}, null);
})

// 验证码按钮显示
$("#sendemail").click(function() {
	emailstatus = '1';
	var code = $("#sendemail");
	code.attr("disabled", "disabled");
	setTimeout(function() {
		code.css("opacity", "0.8");
	}, 1000)
	var time = 60;
	var set = setInterval(function() {
		code.val("(" + --time + ")秒后重新获取");
	}, 1000);
	setTimeout(function() {
		code.attr("disabled", false).val("重新获取验证码");
		clearInterval(set);
	}, 60000);
	$.postData("/consumer/sendEmailCode", null, function(result) {
		if (result != null && result.length != 0) {
			if(result == true){
				$.myAlert("提醒", "验证码已发送", "green", 2000);
			}else{
				$.myAlert("提醒", "已经发送了，不能再获取了", "green", 2000);
			}
		}
	}, function() {
		$.myAlert("警告", "服务器错误喵喵喵", "red", 2000);
	});
});

function hideEmail(status) {
	if (status == '0') {
		$("#email").hide();
		$("#password").hide();
	} else {
		$("#email").show();
		$("#password").show();
	}
}
function hideshopStaff(shopStaffStatus) {
	if (shopStaffStatus == '0') {
		$("#shopStaff").hide();
	} else {
		$("#shopStaff").show();
		//设置用户输入框不可改变
		$(".staffUsername").attr("readOnly",true);
	}
}
/**
 * 获取表单数据和验证码
 * @returns
 */
function getStaffData(){
	var data = {
			'shopStaffDO' : $("#shopStaffDate").serializeJson(),
			'code' : $.valM("#emailcode")
	}
	return data;
}

/**
 * 删除表单和隐藏输入栏
 * @returns
 */
function remStaffFrom(){
	$("#shopStaffDate")[0].reset();
	$("#email")[0].reset();
	
	hideshopStaff(0);
}

/**
 * 获取补货清单
 * 
 * @returns
 */
$(".getrReplenishmentData").click(
		function() {

			$.postData("/consumer/replenishmentCommodityNumber", null,
					function(result) {
						if (result != null && result.length != 0) {

							$(".replenishment tr:not(:first)").empty("");

							var tr = '';
							for (var i = 0; i < result.length; i++) {
								tr += '<tr>';
								tr += '<td>' + result[i].name + '</td>'
										+ '<td>' + result[i].number + '</td>'
										+ '<td><button>完成</button></td>';
								tr += '</tr>';
							}
							$(".replenishment").append(tr);

						} else {

						}
					}, function() {
						$.myAlert("警告", "服务器错误喵喵喵", "red", 2000);
					});
		})

function orientationChange() {
	/*
	 * if(window.orientation != 0){ $("html").css("display","none");
	 * alert("请竖屏显示"); }else{ $("html").css("display","block"); }
	 */
};

addEventListener('load', function() {
	orientationChange();
	window.onorientationchange = orientationChange;
});

/**
 * 获取图片
 */
var changeImg;
$(".comm-img").click(
		function(event) {
			var src = event.target.src;

			if (src.indexOf("/images/addImg.png") != -1) {
				// 没有图片
				changeImg = event.target;
				$("#commImgInput").click();
			} else {
				// 有图片 m
				changeImg = event.target;
				$("#commImgInput").click();
			}
		});

/**
 * 图片设置值
 * 
 * @returns
 */
$("#commImgInput").change(function() {
	
	var cname = $(changeImg).attr("cname");
	
	
	$(changeImg).attr("src", URL.createObjectURL($(this)[0].files[0]));
	
	img[cname] = $(this)[0].files[0];
});

/**
 * 商品属性标签点击事件
 * 
 * @param title
 * @returns
 */
function commodityTitle(title, that) {
	var dom = null;
	switch (title) {
	case 1:
		dom = $(".commodity-tr");
		break;
	case 2:
		dom = $(".commodityDef-tr");
		break;
	case 3:
		dom = $(".commodityImg-tr");
		break;
	case 4:
		dom = $(".commodityState-tr");
		break;
	case 5:
		dom = $(".commodityPrice-tr");
		break;
	case 6:
		dom = $(".commodityGood-tr");
		break;
	}
	if (dom.css("display") == 'none') {
		dom.css("display", "block");
		$(that).css("border-left", "4px solid blue");
	} else {
		dom.css("display", "none");
		$(that).css("border-left", "");
	}
}

/**
 * 条形码识别
 */
$(function() {
	$(".barCode").change(function() {
		var input = document.querySelector(".barCode");
		if (input.files && input.files.length) {
			Quagga.decodeSingle({
				inputStream : {
					size : 800
				// 这里指定图片的大小，需要自己测试一下
				},
				locator : {
					patchSize : "medium",
					halfSample : false
				},
				numOfWorkers : 1,
				decoder : {
					readers : [ {
						format : "ean_reader",// 这里指定ean条形码，就是国际13位的条形码
						config : {}
					} ]
				},
				locate : true,
				src : URL.createObjectURL(input.files[0])
			}, function(result) {
				alert("扫描成功" + result.codeResult.code);
				$(".inputbarCode").val(result.codeResult.code);
			});
		}
	});
});

/**
 * 生成图片
 */
$(function() {
	$(".dataToImg").click(
			function() {
				html2canvas($(".replenishment")).then(
						function(canvas) {
							var imgUri = canvas.toDataURL("image/png"); // 获取生成的图片的url

							var save_link = document.createElementNS(
									'http://www.w3.org/1999/xhtml', 'a');
							save_link.href = imgUri;
							save_link.download = '111.png';

							var event = document.createEvent('MouseEvents');
							event.initMouseEvent('click', true, false, window,
									0, 0, 0, 0, 0, false, false, false, false,
									0, null);
							save_link.dispatchEvent(event);

							window.location.href = imgUri; // 下载图片
						});
			});
});
