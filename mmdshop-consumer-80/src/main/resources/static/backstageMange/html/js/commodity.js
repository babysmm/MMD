function commButt(that, name) {
	$(".comm-header button").css("background-color", "#09c");
	$(that).css("background-color", "#0099FF");

	$(".data-analysis").css("display", 'none');

	if (name == 'dataShow') {
		$("#data-analysis").css("display", 'block');
	} else if (name == 'commShow') {
		$("#comm-show").css("display", 'block');
	} else if (name == 'commBrandShow') {
		$("#commBrand-show").css("display", 'block');
	} else if (name == 'commTypeShow') {
		$("#commTypeShowDiv").css("display", 'block');
	} else if (name == 'shopShow') {
		$("#shopshowDiv").css("display", 'block');
	} else {

	}
}
var changeImg;
$(".comm-img").click(
		function(event) {
			var src = event.target.src;

			if (src.indexOf("/images/addImg.png") != -1) {
				// 没有图片
				changeImg = event.target;
				$("#commImgInput").click();
			} else {
				// 有图片

				changeImg = event.target;

				$(".comm-header").css("display", "none");
				$(".comm-section").css("display", "none");
				$("#dialog_large_image").css("display", "block");

				var large_image = '<img src= ' + $(this).attr("src")
						+ '></img>';
				$('#dialog_large_image').html($(large_image).animate({
					width : '70%'
				}, 500));
				$('#dialog_large_image').append(
						"<button name='changeThisImg'>修改</button>"
								+ "<button name='closeBigImg'>关闭</button>");
			}
		});

$("#commImgInput").change(function() {
	$(changeImg).attr("src", URL.createObjectURL($(this)[0].files[0]));
});
/**
 * 大图关闭或者修改
 */
$('#dialog_large_image').on("click", 'button', function() {
	
	// 设置相关元素隐藏
	$("#dialog_large_image").css("display", "none");
	$(".comm-header").css("display", "block");
	$(".comm-section").css("display", "block");
	// 处理图片修改事件
	if (this.name == 'changeThisImg') {
		// 调用图片选择器
		$("#commImgInput").click();
	}
	
});

function commodity(that, name) {
	switch (name) {
	case 'search':
		searchCommodity();
	}
}

function searchCommodity() {
	var name = $("input[name=commoditySearchInput]").val();
	$.post("/consumer/findCommodityRough", {
		'name' : name
	}, function(result) {
		if (result != null && result.length != 0) {
			
			//console.log(result)
			
			$.setTable(result, new Array("commodityDO.name",
										"commodityDO.barCode", "shopDO.name",
										"commodityBrandDO.name", "commodityDO.registerTime"),
										"#searchCommodity", true, true,"commodityTR");
		} else {
			$.myAlert("警告", "没有搜索到哦", "red", 2000);
		}
	});
}

/**
 * 点击表格某一列查询全部信息
 * @returns
 */
$("#searchCommodity").on("click","tr",function() {
	var id = $(this).attr("commodityId");
	
	if(id != undefined){
		$.post("/consumer/findCommodityAll", {
			'commodityId' : id
		}, function(result) {
			if (result != null && result.length != 0) {
				console.log(result)
				$('#commodity')[0].reset();
				$("#commodity").setObjectForm(result);
			} else {
				$.myAlert("警告", "没有搜索到哦", "red", 2000);
			}
		});
	}
});

//upfile($(this)[0].files[0],"111","UTGwEARIYS8loLRm63rrKdt9-ifdaNLJ2vEGdOHH:" +
//		"JA1hyFr7pDgdbh3m0kwGKUqn30Q=:eyJlbmRVc2VyIjoidWlkIiwic2NvcGUiOiJtbWRfc2hvcDoxMTEiLCJkZWFkbGluZSI6MTU1MTUxMDA4OH0=");
function upfile(file,key,token) {
	var config = {
		useCdnDomain: false,//cdn 加速域名
		region: qiniu.region.z2//在哪个区
	};
	
	var putExtra = {
		fname: "123.img",
		params: {},
		mimeType: [] || null
	};
	
	var observer = {
		next(res){
			console.log(res)
		},
		error(err){
			console.log(res)
		}, 
		complete(res){
			console.log(res)
		}
	}
	var observable = qiniu.upload(file, key, token, putExtra, config);
	var subscription = observable.subscribe(observer); // 上传开始
	//subscription.unsubscribe(); // 上传取消
}

