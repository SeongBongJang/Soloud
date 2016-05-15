$(document).ready(function(){
	
	$(".accept3_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friendRecommend/approval2.png");
	});
	$(".accept3_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friendRecommend/approval1.png");
	});
	$(".refuse3_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friendRecommend/refuse2.png");
	});
	$(".refuse3_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friendRecommend/refuse1.png");
	});
});






