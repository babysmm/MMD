/**
 	* 获取changeType存在sessionStorage中
*/
window.onload = function() {
	var changeType = sessionStorage.getItem('fullName');
	ct = JSON.parse(changeType);
	
	//alert(ct)
	$("#fullName").text("欢迎您\xa0\xa0\xa0"+ct+"\xa0\xa0\xa0MMD提醒你:代码千万条,规范第一条,代码不规范,亲人两行泪"); 
	
	$.post("/consumer/findAllChangeType",function(result){
		if(result != null && result.length != 0){
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
	switch(button){
		case 1 : showiframe.src = url + 'adminUserManage.html'; break;
		case 3 : showiframe.src = url + 'commodity.html'; break;
	}
	
}