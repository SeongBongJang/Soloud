$(document).ready(function(){
	$("#friend_search_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/search.png");
	});
	$("#friend_search_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/search2.png");
	});	
});