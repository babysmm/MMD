/**
 	* 获取sessionStorage中存储的changeType，给class为chang的select复选框进行加选项

*/
window.onload = function() {
	var changeType = sessionStorage.getItem('changeType');
	ct = JSON.parse(changeType);
	//console.log(ct); // => tom
	if(ct == null){
		
	}else{
		$.each(ct, function(i, item){ 
			$(".chang").append($("<option/>").text(item.name).attr("value",item.changeId));
		}); 
	}
}
/**
 * 搜索用户
 * @returns
 */
$("#search").click(function(){
	$.post("/consumer/findAdminUserAll",{'username':$("#usernameInput").val()},function(result){
		if(result != null && result.length != 0){
			console.log(JSON.stringify(result));
			$('#userFrom')[0].reset();
			$('#userDetFrom')[0].reset();
			$('#userJurFrom')[0].reset();
			
			$("#userFrom").setForm(result.adminUserDO);
			$("#userDetFrom").setForm(result.adminUserDetailsDO);
			$("#userJurFrom").setForm(result.adminUserJurisdictionDO);
			$("#passwordInput").attr("disabled",'disabled');
			
			$("tr[name='changeTimeTR']").css("visibility",'visible');
			$("tr[name='changeTypeTR']").css("visibility",'visible');
			$("tr[name='registerTimeTR']").css("visibility",'visible');
			$("tr[name='lastTR']").css("visibility",'visible');
		}else{
			myAlert("警告","没有搜索到哦","red",2000);	
		}
	});
});
/**
 * 新增用户模式
 * 	
 * @returns
 */
$("#newUserBefore").click(function(){
	/**
	 * 1.清除表单打开password
	 */
	$('#userFrom')[0].reset();
	$('#userDetFrom')[0].reset();
	$('#userJurFrom')[0].reset();
	$("#passwordInput").removeAttr("disabled");
	/**
	 * 2.设置隐藏值
	 */
	$("tr[name='changeTimeTR']").css("visibility",'hidden');
	$("tr[name='changeTypeTR']").css("visibility",'hidden');
	$("tr[name='registerTimeTR']").css("visibility",'hidden');
	$("tr[name='lastTR']").css("visibility",'hidden');
	
	
})
/**
 * 新增用户
 * @returns
 */
$("#newUser").click(function(){
	//判断是否是新增用户模式
	if($("#passwordInput").attr("disabled") == 'disabled'){
		myAlert("警告","新增用户前请点击<新增用户模式>","red",1000);
		return;
	}
	var user = $.isNotNull("#userFrom",new Array("username","password"));
	var det = $.isNotNull("#userDetFrom",new Array("fullName","email","cardId","birthday"));
	var jur = $.isNotNull("#userJurFrom",new Array("jurType"));
	
	if(user.length != 0){
		myAlert("警告","用户基本信息里面的 \xa0\xa0\xa0"+$("input[name='"+user[0]+"']").attr("usename")+"\xa0\xa0\xa0"+user[1],"red",2000);
	}else if(det.length != 0){
		myAlert("警告","用户详细信息里面的 \xa0\xa0\xa0"+$("input[name='"+det[0]+"']").attr("usename")+"\xa0\xa0\xa0"+det[1],"red",2000);
	}else if(jur.length != 0){
		myAlert("警告","用户权限信息里面的 \xa0\xa0\xa0"+$("input[name='"+jur[0]+"']").attr("usename")+"\xa0\xa0\xa0"+jur[1],"red",2000);
	}else{
		sendUser("/consumer/newAdminUser")
	}
});
/**
 * 删除用户
 * @returns/provider/removeAdminUserAll
 */
$("#delUser").click(function(){
	if($("input[name = username]").val() == ''){
		myAlert("警告","请搜索一个用户,然后在删除","red",2000);
		return null;
	}
	
	$.postData("/consumer/removeAdminUserAll",{'username':$("input[name = username]").val()},function(result){
		if(result != null && result.length != 0){
			if(result === true){
				$('#userFrom')[0].reset();
				$('#userDetFrom')[0].reset();
				$('#userJurFrom')[0].reset();
				myAlert("信息","数据库操作成功","green",2000);
			}else{
				myAlert("警告","数据库操作失败","red",2000);
			}
		}
	},function(){
		myAlert("警告","服务器错误喵喵喵","red",2000);	
	})
});
/**
 * 更新用户数据
 * @returns
 */
$("#udUser").click(function(){
	//获取username值判断是否查询过
	if($("input[name = username]").val() != ''){
		var user = $.isNotNull("#userFrom",new Array("username"));
		var det = $.isNotNull("#userDetFrom",new Array("fullName","email","cardId","birthday"));
		var jur = $.isNotNull("#userJurFrom",new Array("jurType"));
		
		if(user.length != 0){
			myAlert("警告","用户基本信息里面的 \xa0\xa0\xa0"+$("input[name='"+user[0]+"']").attr("usename")+"\xa0\xa0\xa0"+user[1],"red",2000);
		}else if(det.length != 0){
			myAlert("警告","用户详细信息里面的 \xa0\xa0\xa0"+$("input[name='"+det[0]+"']").attr("usename")+"\xa0\xa0\xa0"+det[1],"red",2000);
		}else if(jur.length != 0){
			myAlert("警告","用户权限信息里面的 \xa0\xa0\xa0"+$("input[name='"+jur[0]+"']").attr("usename")+"\xa0\xa0\xa0"+jur[1],"red",2000);
		}else{
			sendUser("/consumer/modifyAdminUserAll");
		}
	}else{
		myAlert("警告","请搜索一个用户,然后在更新数据","red",2000);
	}
});

$("#findChangeTypeButton").click(function(){
	$.postData("/consumer/findChangeTypeAll",null,function(result){
		$('.changeTypeTable tr:gt(0)').remove();
		if(result != null && result.length != 0){
			//console.log(result)
			for(var i = 0;i < result.length;i++){
				var id = result[i].changeId;
				var name = result[i].name;
				var changedate = new Date(result[i].changeTime).Format("yyyy-MM-ddThh:mm:ss"); 
				
				$(".changeTypeTable").append("<tr>"+
											 "<td><input type='text' " +
											 "name='changeTypeName' minLength='2' maxLength='10' placeholder='权限名字' usename='权限名字' value='"+name+"'></td>"+
											 "<td><input type='datetime-local' disabled='true' value='"+changedate+"'></td>" +
											 "<td  onclick='modifyChangeType("+id+",this)'><button>修改</button></td>"+
											 ""+
											 "</tr>");
			}
			
		}
	},function(){
		myAlert("警告","服务器错误喵喵喵","red",2000);	
	})
})


var changeTypeVo = {
	changeId:null,
	changeTime:null,
	changeUserId:null,
	date1:null,
	date2:null,
	date3:null,
	date4:null,
	date5:null,
	name:null
}

/**
 * 修改ChangeType
 * @param id
 * @returns
 */
function modifyChangeType(id,that){
	var name = that.parentNode.firstChild.firstChild.value;
	
	changeTypeVo.changeId = id;
	changeTypeVo.name = name;
	
	$.postData("/consumer/modifyChangeType",changeTypeVo,function(result){
		if(result != null && result.length != 0){
			alert(result)
			if(result == 1){
				myAlert("信息","数据库操作成功","green",2000);
			}else{
				myAlert("警告","数据库操作失败","red",2000);
			}
		}
	},function(){
		myAlert("警告","服务器错误喵喵喵","red",2000);	
	})
}

/**
 * 用户信息数据发送
 * @returns   /consumer/newAdminUser
 */
function sendUser(url) {
	var backData = {'adminUserDO':$("#userFrom").serializeJson(),
			'adminUserDetailsDO':$("#userDetFrom").serializeJson(),
			'adminUserJurisdictionDO':$("#userJurFrom").serializeJson()
			}

	console.log(JSON.stringify(backData))
	
	$.postData(url,backData,function(result){
		if(result != null && result.length != 0){
			alert(result)
			if(result === true){
				myAlert("信息","数据库操作成功","green",2000);
			}else{
				myAlert("警告","数据库操作失败","red",2000);
			}
		}
	},function(){
		myAlert("警告","服务器错误喵喵喵","red",2000);	
	})
}

function myAlert(t,c,color,time){
	new jBox('Notice', {
	    attributes: {
	      x: 'right',
	      y: 'bottom'
	    },
	    stack: false,
	    animation: {
	      open: 'tada',
	      close: 'zoomIn'
	    },
	    autoClose: time,
	    color: color,
	    title: t,
	    content: c,
	    delayOnHover: true,
	    showCountdown: true,
	    closeButton: true
	  });
}
