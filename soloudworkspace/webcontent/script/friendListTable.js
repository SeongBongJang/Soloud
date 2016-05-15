
var friendId;
var searchIdName;

var modifyFriendId;
var mofidyGoupName;
$(document).ready(function(){
	$("#group_modify_dialog").dialog({
		autoOpen : false,
		modal : true,
		width : 400,
		height : 200,
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
				mofidyGoupName = $("#group_list").val();
				modifyGroup();
				$(this).dialog("close");
			},
			"취소" : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
		}
	});
	$("#delete_check_dialog").dialog({
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
				deleteFriend();
				$(this).dialog("close");
			},
			"취소" : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
		}
	});
	$(".friend_search_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/search.png");
	});
	$(".friend_search_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/search2.png");
	});	
	$(".friend_search_button").click(function(){
		searchIdName="";
		searchIdName = $("#name_field").val();

		searchMyFriend();
	});	
	$(".friend_cut_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/cut_button.png");
	});
	$(".friend_cut_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/cut_button2.png");
	});
	$(".modify_group_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/modify_group.png");
	});
	$(".modify_group_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/modify_group2.png");
	});
	$(".list_tr").hover(function(event){
		friendId = $(this).attr("id");
	});
	$(".friend_cut_button").click(function(){
		$("#delete_check_dialog").dialog("open");
	});
	$(".modify_group_button").click(function(){	
		modifyFriendId = friendId; 
		$("#group_modify_dialog").dialog("open");
	});
	$("#name_field").keydown(function(event){
		if (event.keyCode == 13) {
			searchIdName = "";
			searchIdName = $("#name_field").val();
			searchMyFriend();
         }
	});	
});

function modifyGroup(){
	$.ajax({
		type: "post",
		url: "modifyGroup.do",			
		data : {friendId : modifyFriendId ,mofidyGroup : mofidyGoupName},	
		dataType: "json",					
		success: function (data) {		
		},
		error:function(){
		}
	});
}

function searchMyFriend(){
	$.ajax({
		type: "post",
		url: "searchFriend.do",			
		data : {searchInfo : searchIdName,type:"myFriend"},	
		dataType: "json",					
		success: function (data) {	
			$("#friends_table > tbody").children("tr:not(:first)").remove();
			addRowTr(data);
		},
		error:function(){
			alert("search fail..");
		}
	});
}


function addRowTr(data){

	
	var table = document.getElementById("friends_table");
	var peopleImg = [];
	var friend_cut_button = [];
	modify_group_button = [];
	for(var i = 0; i< data.length; i++)
	{	
		peopleImg[i] = document.createElement("img");
		friend_cut_button[i] = document.createElement("img");
		modify_group_button[i] = document.createElement("img");
	}

	for(var i = 0; i<data.length; i++){

		var emptyRow = table.insertRow(i+1);
		emptyRow.id = data[i].id;	

		var td1 = emptyRow.insertCell(0);
		td1.width = '210';
		peopleImg[i].src="/Soloud/image/icon/people21.png";
		peopleImg[i].width="80";

		td1.appendChild(peopleImg[i]);

		var td2 = emptyRow.insertCell(1);
		td2.innerHTML = data[i].name + "<br>(" + data[i].id + ")";
		td2.style.textAlign = 'left';
		td2.width = '243';

		var td3 = emptyRow.insertCell(2);
		td3.style.textAlign = 'center';
		
		friend_cut_button[i].src = "/Soloud/image/friends/cut_button2.png";
		friend_cut_button[i].width="100";
		friend_cut_button[i].height="30";
		friend_cut_button[i].className = "friend_cut_button";
		friend_cut_button[i].id=data[i].id;
		friend_cut_button[i].onmouseover = function(){
			this.src = "/Soloud/image/friends/cut_button.png";};
			friend_cut_button[i].onmouseout = function(){
				this.src = "/Soloud/image/friends/cut_button2.png";};
				friend_cut_button[i].onclick = function(){
					friendId = $(this).attr("id");
				
					deleteSearchFriend();
				};
			
				
		modify_group_button[i].src = "/Soloud/image/friends/modify_group2.png";
		modify_group_button[i].width="100";
		modify_group_button[i].height="30";
		modify_group_button[i].className = "friend_cut_button";
		modify_group_button[i].id=data[i].id;
		modify_group_button[i].onmouseover = function(){
			this.src = "/Soloud/image/friends/modify_group.png";};
			modify_group_button[i].onmouseout = function(){
			this.src = "/Soloud/image/friends/modify_group2.png";};
			modify_group_button[i].onclick = function(){
				modifyFriendId = $(this).attr("id"); 
				$("#group_modify_dialog").dialog("open");
				};
		td3.appendChild(friend_cut_button[i]);	
		td3.appendChild(modify_group_button[i]);	

	}


}

function deleteFriend(){
	$.ajax({
		type: "post",
		url: "dropRelationShip.do",			
		data : {friendMemberId : friendId},	
		dataType: "json",					
		success: function (data) {		
			if(data.isSuccess == true){
				deleteFriendRow();
			}
		},
		error:function(){
			alert("delete fail..");
		}
	});
}

function deleteFriendRow(){
	$(".friends_table > tbody").children("tr").each(function() {
		if((friendId) == $(this).attr('id')) {
			$(this).remove();
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

