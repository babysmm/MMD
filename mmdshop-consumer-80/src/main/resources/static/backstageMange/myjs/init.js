/**
 	* 获取changeType存在sessionStorage中
*/
window.onload = function() {
	var changeType = sessionStorage.getItem('fullName');
	ct = JSON.parse(changeType);
	
	//alert(ct)
<<<<<<< HEAD
	$("#fullName").text("欢迎您\xa0\xa0\xa0"+ct+"\xa0\xa0\xa0MMD提醒你:代码千万条,规范第一条,代码不规范,后人两行泪"); 
	
	$.post("/consumer/findChangeType",function(result){
		if(result != null && result.length != 0){
			//console.log(result)
=======
	$("#fullName").text("欢迎您\xa0\xa0\xa0"+ct+"\xa0\xa0\xa0MMD提醒你:代码千万条,规范第一条,代码不规范,亲人两行泪"); 
	
	$.post("/consumer/findAllChangeType",function(result){
		if(result != null && result.length != 0){
>>>>>>> d7e69f43594d178de4114880955737a167083d98
			sessionStorage.setItem('changeType', JSON.stringify(result));
		}else{
				alert("错误");
		}
	});
}

var url = "./html/";
var box = document.getElementsByClassName("nav-item nav-profile");

var pageSwitch = function(button,t) {
	for (var i = box.length - 1; i >= 0; i--) {
		box[i].style.background = 'white';
	}
	t.style.background = '#E1FFFF';
	$(".showsiframe").css("display","none");
	switch(button){
		case 1 : $("#adminUserManage").css("display","block");break
		case 3 : $("#commodity").css("display","block");; break;
		case 8 : $("#member").css("display","block");; break;
		case 5 : $("#deliveryman").css("display","block");; break;
	}
	
}