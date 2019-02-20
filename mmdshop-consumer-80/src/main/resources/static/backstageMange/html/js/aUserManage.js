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

$.fn.setForm = function(jsonValue) {
    var obj=this;
    $.each(jsonValue, function (name, ival) {
    	//alert("[name='"+name+"']")
    	
    	
    	var myDOM0 = $("[name='"+name+"']")[0];
    	
    	if(myDOM0 == undefined) return true;
    	
    	var tagName = myDOM0.tagName;
    	
    	if(tagName == 'INPUT'){
    		inputSet(name,ival,obj);
    	}else if(tagName == 'SELECT'){
    		obj.find("[name="+name+"]").val(ival); 
    	}else{
    		
    	}
    });
};

Date.prototype.Format = function(fmt)   
{ //author: meizz
  var o = {   
    "M+" : this.getMonth()+1,                 //月份
    "d+" : this.getDate(),                    //日
    "h+" : this.getHours(),                   //小时
    "m+" : this.getMinutes(),                 //分
    "s+" : this.getSeconds(),                 //秒
    "q+" : Math.floor((this.getMonth()+3)/3), //季度
    "S"  : this.getMilliseconds()             //毫秒
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
};

$.fn.serializeJson = function () {
    var serializeObj = {};
    $(this.serializeArray()).each(function () {
        serializeObj[this.name] = this.value;
    });
    return serializeObj;
};


function inputSet(name,ival,obj) {
	var $oinput = obj.find('input[name="'+name+'"]');
	
	if ($oinput.attr("type")== "radio" || $oinput.attr("type")== "checkbox"){
		 $oinput.each(function(){
             if(Object.prototype.toString.apply(ival) == '[object Array]'){//是复选框，并且是数组
                  for(var i=0;i<ival.length;i++){
                      if($(this).val()==ival[i])
                         $(this).attr("checked", "checked");
                  }
	 		 }else{
                 if($(this).val()==ival)
                    $(this).attr("checked", "checked");
             }
         });
	}else if($oinput.attr("type")== "date"){
		obj.find("[name="+name+"]").val(new Date(ival).Format("yyyy-MM-dd")); 
	}else if($oinput.attr("type")== "datetime-local"){
		obj.find("[name="+name+"]").val(new Date(ival).Format("yyyy-MM-ddThh:mm:ss")); 
	}else if($oinput.attr("type")== "textarea"){//多行文本框
		obj.find("[name="+name+"]").html(ival);
	}else{
        obj.find("[name="+name+"]").val(ival); 
    }
}
