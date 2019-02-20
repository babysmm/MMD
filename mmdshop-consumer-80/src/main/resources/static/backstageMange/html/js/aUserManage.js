/**
 	* 获取sessionStorage中存储的changeType，给class为chang的select复选框进行加选项
*/
window.onload = function() {
	var changeType = sessionStorage.getItem('changeType');
	ct = JSON.parse(changeType);
	//console.log(ct); // => tom
	$.each(ct, function(i, item){ 
		$(".chang").append($("<option/>").text(item.name).attr("value",item.changeId));
	}); 
}

$("#search").click(function(){
	//用户搜索
	$.post("/consumer/findAdminUserAll",{'username':$("#usernameInput").val()},function(result){
		if(result != null && result.length != 0){
			console.log(JSON.stringify(result));
			$("#userFrom").setForm(result.adminUserDO);
			$("#userDetFrom").setForm(result.adminUserDetailsDO);
			$("#userJurFrom").setForm(result.adminUserJurisdictionDO);
			$("#passwordInput").attr("disabled",'disabled');
		}else{
			alert("错误");
		}
	});
});

$("#newUser").click(function(){
	//新增用户
	$('#userFrom')[0].reset();
	$('#userDetFrom')[0].reset();
	$('#userJurFrom')[0].reset();
	$("#passwordInput").removeAttr("disabled");
});

$("#delUser").click(function(){
	//删除用户
  alert(3)
});

$("#udUser").click(function(){
	//更新用户
	
	var backData = {'auser':$("#userFrom").serializeJson(),'auserdet':$("#userDetFrom").serializeJson(),'auserjurisdiction':$("#userJurFrom").serializeJson()}
	
	console.log(JSON.stringify(backData))
	
	$.post("/con/addAUserALL",JSON.stringify(backData),function(result){
		if(result != null && result.length != 0){
			
		}else{
			alert("错误");
		}
	});
	
});

$("#newPassword").click(function(){
	$("#passwordInput").removeAttr("disabled");
});
