var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);



$.fn.setForm = function(jsonValue) {
    var obj=this;
    $.each(jsonValue, function (name, ival) {
    	// alert("[name='"+name+"']")
    	
    	
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
    // console.log(obj)
    // inputObjectSet(this,jsonValue);
};
$.fn.setObjectForm = function(jsonValue) {
	var obj=this;
	
	$.each(jsonValue, function (names, vals) {
		$.each(vals, function (name, val) {
			var key = "'"+names+"."+name+"'";
			inputSet(key,val,obj);
	    });
    });
};

Date.prototype.Format = function(fmt)   
{ // author: meizz
  var o = {   
    "M+" : this.getMonth()+1,                 // 月份
    "d+" : this.getDate(),                    // 日
    "h+" : this.getHours(),                   // 小时
    "m+" : this.getMinutes(),                 // 分
    "s+" : this.getSeconds(),                 // 秒
    "q+" : Math.floor((this.getMonth()+3)/3), // 季度
    "S"  : this.getMilliseconds()             // 毫秒
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

$.postData = function(url,data,Mysuccess,Myerror) {
	$.ajax({
        type: "post",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        success: function(e) {
        	Mysuccess(e)
		},
        error: function(e) {
        	Myerror(e)
		}
    });
}
$.isNotNull = function(table,array) {
	if(table == null) return;
	
	var tableData = $(table).serializeJson();
	
	var result = new Array();
	try{
		array.forEach(function(value,i){
			if(tableData[value].length == 0){
				result[0] = value;
				result[1] = "是空的 没有填";
				throw new Error("EndIterative");
			}else if(value.indexOf("cardId") != -1){
				if(tableData[value].length != 18){
					result[0] = value;
					result[1] = "不符合要求";
					throw new Error("EndIterative");
				}
			}
			
			// 长度判断
			var minLength,maxLength;
			minLength = $("input[name = '"+value+"']").attr("minLength");
			maxLength = $("input[name = '"+value+"']").attr("maxLength");
			
			if($("input[name = '"+value+"']").val().length <= minLength || $("input[name = '"+value+"']").val().length >= maxLength){
				result[0] = value;
				result[1] = "长度不对,不能小于"+minLength+"或者大于"+maxLength;
				throw new Error("EndIterative");
			}
			
			// 类型判断
			if($("input[name = '"+value+"']").attr("type") == 'number'){
				if(isNaN($("input[name = '"+value+"']").val()) == true){
					result[0] = value;
					result[1] = "不是数字";
					throw new Error("EndIterative");
				}
			}
			
		})
	}catch(e){
		
	}
	return result;
}

$.getScrollTop = function() {
	var scrollTop=0;  
    if(document.documentElement&&document.documentElement.scrollTop){  
        scrollTop=document.documentElement.scrollTop;  
    }else if(document.body){  
        scrollTop=document.body.scrollTop;  
    }  
    return scrollTop;  
}

$.getScrollLeft = function() {
	var scrollLeft=0;  
    if(document.documentElement&&document.documentElement.scrollLeft){  
        scrollLeft=document.documentElement.scrollLeft;  
    }else if(document.body){  
        scrollLeft=document.body.scrollLeft;  
    }  
    return scrollLeft; 
}

$.setScroll = function(dom,x,y) {
	$(dom).scrollTop(y);
	$(dom).scrollLeft(x);
}

/**
 * 右下角提示框(标题,内容,颜色,关闭时间)
 */
$.myAlert = function(t,c,color,time){
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

$.foreach = function(length,myFunctyion){
	for(var i = 0;i < length;i++){
		myFunctyion(i);
	}
}

/**
 * 表格赋值
 * 
 * @param data
 *            后端值
 * @param param
 *            要填的表格数据(可以使用xx.xx格式)输入的顺序就是表格顺序，请注意顺序
 * @param tableDom
 *            表格名字 使用 .xx 或者 #xx 格式
 * @param orderNumber
 *            是否加入序号
 * @param clearTable
 *            是否清空表格
 * @param trclass名称
 * 
 * @returns
 */
$.setTable = function(data,param,tableName,orderNumber,clearTable,className){
	// 存放解析后的数据
	var paramArray = new Array();
	// 获取表格长度
	var tableLength = $(tableName+" tbody tr").length;
	var context = '';
	var addHtml = '';
	
	if(clearTable == true){
		$(tableName+" tr:not(:first)").empty("");
	}

	$.foreach(data.length,function(z){
		context = '';
		
		if(orderNumber == true){
			var num = z+1;
			// 加入序号
			context += "<td>"+num+"</td>";
		}
		$.foreach(param.length,function(i){
			// 判断字符串里面是否含有点
			if(param[i].indexOf(".") != -1 ){
				// 字符串分割
				var result = param[i].split(".");
				var sData = data[z][result[0]][result[1]];
				
				// 时间转换
				if(result[1].indexOf("Time") != -1 ){
					sData = new Date(sData).Format("yyyy-MM-ddThh:mm:ss");
				}
				context += "<td>"+sData+"</td>";
			}else{
				context += "<td>"+data[z][param[i]]+"</td>";
			}
		});
		// 生成最后的<tr>标签
		addHtml = "<tr commodityId='"+data[z]["commodityDO"]["commodityId"]+"' class='"+className+"'>"+context+"</tr>";
		// 往表格里面加
		alert(addHtml);
		$(tableName).append(addHtml);
	});
}

$.setFromTR = function(data,param,time,tableName){
	var tr = '';
	for(var i=0;i<param.length;i++){
		tr += '<td>'+param[i]+'</td>'
	}
	tr += "<td style='text-align: center'><button time='"+time+"' class='delect-commodity'></button></td>";
	$(tableName).append("<tr>"+tr+"</tr>");
}

$.safe = function(){
	document.oncontextmenu = function () { return false; };
	    document.onkeydown = function () {
	            if (window.event && window.event.keyCode == 123) {
	                event.keyCode = 0;
	                event.returnValue = false;
	                return false;
	            }
	 };
	//禁用右键（防止右键查看源代码） 
    window.oncontextmenu=function(){return false;} 
}

$.inputSafe = function(str){
	       var s = "";
	       if(str.length == 0) return "";
	       s = str.replace(/&/g,"&amp;");
	       s = s.replace(/</g,"&lt;");
	       s = s.replace(/>/g,"&gt;");
	       s = s.replace(/ /g,"&nbsp;");
	      s = s.replace(/\'/g,"&#39;");
	      s = s.replace(/\"/g,"&quot;");
	      return s;  
}



var chnNumChar = {
        零:0,
        一:1,
        二:2,
        三:3,
        四:4,
        五:5,
        六:6,
        七:7,
        八:8,
        九:9
};

var chnNameValue = {
   十:{value:10, secUnit:false},
   百:{value:100, secUnit:false},
   千:{value:1000, secUnit:false},
   万:{value:10000, secUnit:true},
   亿:{value:100000000, secUnit:true}
}

$.ChineseToNumber = function(chnStr){
        var rtn = 0;
        var section = 0;
        var number = 0;
        var secUnit = false;
        //alert(chnStr)
        var str = chnStr.split('');

        for(var i = 0; i < str.length; i++){
            var num = chnNumChar[str[i]];
            if(typeof num !== 'undefined'){
                number = num;
                if(i === str.length - 1){
                    section += number;
                }
            }else{
                var unit = chnNameValue[str[i]].value;
                secUnit = chnNameValue[str[i]].secUnit;
                if(secUnit){
                    section = (section + number) * unit;
                    rtn += section;
                    section = 0;
                }else{
                    section += (number * unit);
                }
                number = 0;
            }
        }
        return rtn + section;
}
/**
 * 语音合成
 * @param 文字
 * @param video
 */
$.speechSynthesis = function incc(val,dom){
	$.post("/consumer/getWordToSpeech", {
		'context' : val
	}, function(result) {
		if (result != null && result.length != 0) {
			dom.attr("src","data:audio/mp3;base64,"+result);
			dom[0].play();
		} else {
			$.myAlert("警告", "语音合成错误", "red", 2000);
		}
	});
}

$.fn.safeInputValue = function(){
	var obj=this;
} 

function filtration(str){
	//简单过滤
	if(containSpecial.test(str) == true){
		return false;
	}	
}
//alert(filtration('&#97;&#108;&#101;&#114;&#116;&#40;&#49;&#41;'))
var emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
/**
 * 长度类型判断
 * @param name
 * @returns 1:不是数字
 */
function lengthVerify(name,val){
	var min = length[name][0];
	var max = length[name][1];
	var type = length[name][2];
	var cname = length[name][3];
	
	var lengths = val.length;
	if(lengths >= min && max >= lengths){
		switch(type){
			case 'number':if(isNaN(val)){alert("不是数字")}return 0;
			case 'email':if(!emailReg.test(val)){alert("不是邮件")}return 0;
		}
	}else{
		$.myAlert("警告", cname+"错误", "red", 2000);
	}
}

$.valM = function(a){
	
	var val = $(a).val();
	var name = $(a).attr("name");
	
	val = $.inputSafe(val);
	
	var result = lengthVerify(name,val);
	
	if(result != 0){
		return null;
	}
	
	return val;
}

/**
 * 表单赋值
 * 
 * @param name
 * @param ival
 * @param obj
 * @returns
 */
function inputSet(name,ival,obj) {
	var $oinput = obj.find('input[name="'+name+'"]');
	
	if ($oinput.attr("type")== "radio" || $oinput.attr("type")== "checkbox"){
		 $oinput.each(function(){
             if(Object.prototype.toString.apply(ival) == '[object Array]'){// 是复选框，并且是数组
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
		if(ival != null){
			obj.find("[name="+name+"]").val(new Date(ival).Format("yyyy-MM-ddThh:mm:ss")); 
		}
	}else if($oinput.attr("type")== "textarea"){// 多行文本框
		obj.find("[name="+name+"]").html(ival);
	}else{
        obj.find("[name="+name+"]").val(ival); 
    }
}