
var RequestReceiverId;
var searchIdName;
$(document).ready(function(){
	$(".friend_search_button3").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/search.png");
	});
	$(".friend_search_button3").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/search2.png");
	});	
	$(".friend_search_button3").click(function(){		
		searchIdName = "";
		searchIdName = $("#request_search_field").val();
		searchRequestMember();
	});	
	$(".friend_requestCancel_button").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/rquestCancel.png");
	});
	$(".friend_requestCancel_button").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/rquestCancel2.png");
	});
	$(".Requestlist_tr").hover(function(event){
		RequestReceiverId = $(this).attr("id");
	});
	$(".friend_requestCancel_button").click(function(){
		RequestCancelProposal();
	});
	$("#request_search_field").keydown(function(event){
		if (event.keyCode == 13) {
			searchIdName = "";
			searchIdName = $("#request_search_field").val();
			searchRequestMember();
         }
	});	
});
//검색 함수
function searchRequestMember(){
	$.ajax({
		type: "post",
		url: "searchProposalFriend.do",			
		data : {searchInfo : searchIdName,type:"requestMember"},	
		dataType: "json",					
		success: function (data) {		
			$("#friend_request_table > tbody").children("tr:not(:first)").remove();
			addRequestSearchRowTr(data);
		},
		error:function(){
		}
	});
}

//행추가함수
function addRequestSearchRowTr(data){
	var table = document.getElementById("friend_request_table");
	var peopleImg = [];
	var friend_requestCancel_button = [];

	for(var i = 0; i< data.length; i++)
	{	
		peopleImg[i] = document.createElement("img");
		friend_requestCancel_button[i] = document.createElement("img");
	}
	for(var i = 0; i<data.length; i++){
		
		var emptyRow = table.insertRow(i+1);
		emptyRow.id = data[i].id;	
		
		var td1 = emptyRow.insertCell(0);
		peopleImg[i].src="/Soloud/image/icon/people21.png";
		peopleImg[i].width="80";
		td1.width = '210';
		td1.appendChild(peopleImg[i]);


		var td2 = emptyRow.insertCell(1);
		td2.innerHTML = data[i].name + "<br>(" + data[i].id + ")";
		td2.style.textAlign = 'left';
		td2.width = '243';
		

		var td3 = emptyRow.insertCell(2);
		td3.style.textAlign = 'center';
		friend_requestCancel_button[i].src = "/Soloud/image/friends/rquestCancel2.png";
		friend_requestCancel_button[i].width="100";
		friend_requestCancel_button[i].height="30";
		friend_requestCancel_button[i].margin="10";
		friend_requestCancel_button[i].className = "friend_requestCancel_button";
		friend_requestCancel_button[i].id=i;
		
		friend_requestCancel_button[i].onmouseover = function(){
			this.src = "/Soloud/image/friends/rquestCancel.png";};
		friend_requestCancel_button[i].onmouseout = function(){
			this.src = "/Soloud/image/friends/rquestCancel2.png";};
		friend_requestCancel_button[i].onclick = function(){
			//alert(data[$(this).attr("id")].id);
			//alert(data[$(this).attr("id")].name);
			//realName =data[$(this).attr("id")].name;
			RequestReceiverId = data[$(this).attr("id")].id;		
			RequestCancelProposal();
		};
		td3.appendChild(friend_requestCancel_button[i]);
	}
}




//친구 신청 취소 함수
function RequestCancelProposal(){
	$.ajax({
		type: "post",
		url: "cancelProposal.do",			
		data : {friendMemberId : RequestReceiverId},	
		dataType: "json",					
		success: function (data) {			
			if(data.isSuccess == true){
				alert("cancel sucess!!");
				deleteRequestRow();
			}
		},
		error:function(){
			alert("cancel fail..");
		}
	});
};

function deleteRequestRow(){
	$(".friend_request_table > tbody").children("tr").each(function() {
		if((RequestReceiverId) == $(this).attr('id')) {
			$(this).remove();

			return false;
		}
	});
}


