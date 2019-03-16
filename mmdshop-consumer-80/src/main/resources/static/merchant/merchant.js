var length = {
	"searchStaff":[3,10,'number',"用户名"]
}

$(".menuHeader").click(function() {
	var div = $(this).parent().attr('class');
	var section = $("."+div+">section");

	if(section.css("display") == 'none'){
		$(this).css("border-left","4px solid red");
		section.css("display","block");
	}else{
		$(this).css("border-left","");
		section.css("display","none");
	}
});

$("#searchStaff").click(function() {
	var val = $.valM(".searchInput");
	$.post('findShopStaffByusername', {
		'username':val
		}, function(result) {
				if (result != null && result.length != 0) {
					
				} else {
					$.myAlert("警告", "没有搜索到哦", "red", 2000);
				}
			});
});



function orientationChange() {
/*
	if(window.orientation != 0){
		$("html").css("display","none");
		alert("请竖屏显示");
	}else{
		$("html").css("display","block");
	}
*/	
};

addEventListener('load', function(){
    orientationChange();
    window.onorientationchange = orientationChange;
});