function commButt(that,name) {
	$(".member-header button").css("background-color","#09c");
	$(that).css("background-color","#0099FF");

	$(".data-analysis").css("display",'none');

	if(name == 'memberDataShow'){
		$("#memberDataShow").css("display",'block');
	}else if(name == 'memberMessageShow'){
		$("#memberMessageShow").css("display",'block');
	}else if(name == 'memberOrderShow'){
		$("#memberOrderShow").css("display",'block');
	}else if(name == 'memberShowShow'){
		$("#memberShowShow").css("display",'block');
	}else{
		
	}
}