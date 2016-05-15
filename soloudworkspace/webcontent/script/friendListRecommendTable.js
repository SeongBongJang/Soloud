//recommend_search_field
var friendProposalId;			
var acceptId;					
var friendName;					
var realId;						
var realName;					
var searchIdName;			
$(document).ready(function(){
	$("#recommend_dialog").dialog({
		autoOpen : false,
		modal : true,
		width : 400,
		height : 220,
		show: {
			effect: "blind",
			duration: 200
		},
		hide: {
			effect: "explode",
			duration: 200
		},
		buttons : {
			"확인" : function() {
				acceptProposal();
				$(this).dialog("close");
			},
			"취소" : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
		}
	});
	
	$(".friend_search_button2").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/search.png");
	});
	$(".friend_search_button2").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/search2.png");
	});	
	
	$(".friend_search_button2").click(function(){
		searchIdName = "";
		searchIdName = $("#recommend_search_field").val();
		searchRecommendMember();
	});	
	$(".accept2_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/accept.png");
	});
	$(".accept2_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/accept2.png");
	});
	$(".refuse2_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/refuse.png");
	});
	$(".refuse2_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/refuse2.png");
	});
	//hover
	$(".proposallist_tr").hover(function(event){
		friendProposalId = $(this).attr("id");
		friendName = $(this).children().attr("id");
	});
	//
	$(".refuse2_button").click(function(){
		refuseProposal();
	});
	$(".accept2_button").click(function() {
		realId = friendProposalId;
		realName = friendName;
		$("#friendIdInfo").text(realId);
		$("#friendNameInfo").text(realName);
		$("#recommend_dialog").dialog("open");
	}); 
	$("#recommend_search_field").keydown(function(event){
		if (event.keyCode == 13) {
			searchIdName = "";
			searchIdName = $("#recommend_search_field").val();
			searchRecommendMember();
         }
	});	
});

function searchRecommendMember(){
	$.ajax({
		type: "post",
		url: "searchProposalFriend.do",			
		data : {searchInfo : searchIdName,type:"recommendMember"},	
		dataType: "json",					
		success: function (data) {		
			$("#friend_recommend_table > tbody").children("tr:not(:first)").remove();
			addSearchRowTr(data);
		},
		error:function(){
			alert("search fail..");
		}
	});
}

function addSearchRowTr(data){
	var table = document.getElementById("friend_recommend_table");
	var peopleImg = [];
	var accept2_button= [];
	var refuse2_button = [];
	
	for(var i = 0; i< data.length; i++)
	{	
		peopleImg[i] = document.createElement("img");
		accept2_button[i] = document.createElement("img");
		refuse2_button[i] = document.createElement("img");
	}
	for(var i = 0; i<data.length; i++){
		
		var emptyRow = table.insertRow(i+1);
		emptyRow.id = data[i].id;	
	
		var td1 = emptyRow.insertCell(0);
		td1.width = '200';
		peopleImg[i].src="/Soloud/image/icon/people22.png";
		peopleImg[i].width="80";
	
		td1.appendChild(peopleImg[i]);
		
	
		var td2 = emptyRow.insertCell(1);
		td2.innerHTML = data[i].name + "<br>(" + data[i].id + ")";
		td2.style.textAlign = 'left';
		td2.width = '243';

		var td3 = emptyRow.insertCell(2);
		td3.style.textAlign = 'center';
		
		accept2_button[i].src = "/Soloud/image/friends/accept2.png";
		accept2_button[i].width="60";
		accept2_button[i].height="30";
		accept2_button[i].margin="10";
		accept2_button[i].className = "accept2_button";
		accept2_button[i].id=i;
		accept2_button[i].onmouseover = function(){
			this.src = "/Soloud/image/friends/accept.png";};
			accept2_button[i].onmouseout = function(){
			this.src = "/Soloud/image/friends/accept2.png";};
			accept2_button[i].onclick = function(){
				//alert(data[$(this).attr("id")].id);
				//alert(data[$(this).attr("id")].name);
				//realId = $(this).attr("id");
				realId = data[$(this).attr("id")].id;
				realName =data[$(this).attr("id")].name;
				$("#friendIdInfo").text(realId);
				$("#friendNameInfo").text(realName);
				$("#recommend_dialog").dialog("open");		
		};
		refuse2_button[i].src = "/Soloud/image/friends/refuse2.png";
		refuse2_button[i].width="60";
		refuse2_button[i].height="30";
		refuse2_button[i].className = "refuse2_button";
		refuse2_button[i].id=data[i].id;
		refuse2_button[i].onmouseover = function(){
			this.src = "/Soloud/image/friends/refuse.png";};
			refuse2_button[i].onmouseout = function(){
			this.src = "/Soloud/image/friends/refuse2.png";};
			refuse2_button[i].onclick = function(){
				//alert($(this).attr("id"));
				friendProposalId = $(this).attr("id");
				refuseProposal();			
		};
		td3.appendChild(accept2_button[i]);
		td3.appendChild(refuse2_button[i]);
		}
};








function acceptProposal(){

	$.ajax({
		type: "post",
		url: "acceptProposal.do",			
		data : {friendMemberId : realId,friendMemberName:realName},	
		dataType: "json",				
		success: function (data) {		
			if(data.isSuccess == true){
				alert("accept sucess!!");
				deleteAcceptRow();
			}
		},
		error:function(){
			alert("refuse fail..");
		}
	});
};


function refuseProposal(){
	$.ajax({
		type: "post",
		url: "refuseProposal.do",			
		data : {friendMemberId : friendProposalId},	
		dataType: "json",				
		success: function (data) {		
			if(data.isSuccess == true){
				alert("refuse sucess!!");
				deleteProposalRow();
			}
		},
		error:function(){
			alert("refuse fail..");
		}
	});
};



function deleteProposalRow(){
	$(".friend_recommend_table > tbody").children("tr").each(function() {
		if((friendProposalId) == $(this).attr('id')) {
			$(this).remove();

			return false;
		}
	});
}


function deleteAcceptRow(){
	$(".friend_recommend_table > tbody").children("tr").each(function() {
		if((realId) == $(this).attr('id')) {
			$(this).remove();
			alert(1);
			return false;
		}
	});
}



function deleteSearchFriend(){
	$.ajax({
		type: "post",
		url: "dropRelationShip.do",			
		data : {friendMemberId : friendId},	
		dataType: "json",					
		success: function (data) {		
			if(data.isSuccess == true){
				alert("delete sucess!!");
				deleteFriendRow();
			}
		},
		error:function(){
			alert("delete fail..");
		}
	});
}
