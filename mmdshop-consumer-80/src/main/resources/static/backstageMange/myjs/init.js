/**
 * 初始化
 */
$.post("/con/AInit",function(result){
	if(result != null && result.length != 0){
		console.log(JSON.stringify(result))
	}else{
			alert("错误");
	}
});



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