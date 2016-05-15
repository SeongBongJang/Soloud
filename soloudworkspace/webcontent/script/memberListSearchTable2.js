var requestReceiverId;
var searchIdName;

$(document).ready(function(){
	$(".friend_search_button4").mouseover(function(){
		$(this).attr("src","/Soloud/image/friends/search.png");
	});
	$(".friend_search_button4").mouseout(function(){
		$(this).attr("src","/Soloud/image/friends/search2.png");
	});	
	$(".friend_search_button4").click(function(){
		searchIdName = "";
		searchIdName = $("#member_search_field").val();
		searchMember();
	});	
	$("#member_search_field").keydown(function(event){
		
		if (event.keyCode == 13) {
			searchIdName = "";
			searchIdName = $("#member_search_field").val();
			searchMember();
         }
	});	
});


//검색함수
//검색 함수
function searchMember(){
	$.ajax({
		type: "post",
		url: "searchFriend.do",			
		data : {searchInfo : searchIdName,type:"searchMember"},	
		dataType: "json",					
		success: function (data) {		
			$("#search_list_table > tbody").children("tr:not(:first)").remove();
			searchMemberUpdate(data);
		},
		error:function(){
			alert("search fail..");
		}
	});
}

//행 추가 함수
function searchMemberUpdate(data){
	var table = document.getElementById("search_list_table");
	var peopleImg = [];
	var request_button1 = [];

	for(var i = 0; i< data.length; i++)
	{	
		peopleImg[i] = document.createElement("img");
		request_button1[i] = document.createElement("img");
	}

	for(var i = 0; i<data.length; i++){
		
		var emptyRow2 = table.insertRow(i+1);
	
		emptyRow2.id = data[i].id;	
	
		var td1 = emptyRow2.insertCell(0);
		peopleImg[i].src="/Soloud/image/icon/people20.png";
		peopleImg[i].width="80";

		td1.appendChild(peopleImg[i]);

	
		var td2 = emptyRow2.insertCell(1);
		td2.innerHTML = data[i].name + "<br>(" + data[i].id + ")";
		td2.style.textAlign = 'left';
		td2.width = '243';
		var td3 = emptyRow2.insertCell(2);
		td3.style.textAlign = 'center';
		request_button1[i].src = "/Soloud/image/friendSearch/request_button.png";
		request_button1[i].width="100";
		request_button1[i].height="30";
		request_button1[i].margin="10";
		request_button1[i].className = "friend_requestCancel_button";
		request_button1[i].id=i;
		
		request_button1[i].onmouseover = function(){
			this.src = "/Soloud/image/friendSearch/request2_button.png";};
			request_button1[i].onmouseout = function(){
			this.src = "/Soloud/image/friendSearch/request_button.png";};
			request_button1[i].onclick = function(){
			//alert(data[$(this).attr("id")].id);
			//alert(data[$(this).attr("id")].name);
			requestReceiverId = data[$(this).attr("id")].id;
			alert(requestReceiverId);
			requestMessage();
		};
	
		td3.appendChild(request_button1[i]);
	}	
}


//친구신청 메시지 보내는 함수
function requestMessage(){
	$.ajax({
		type: "post",
		url: "requestFriend.do",			
		data : {requestInfo : requestReceiverId},	
		dataType: "json",					
		success: function (data) {
			if(data.isSuccess == true){
				alert("search sucess!!");
			}else{
				alert("search fail..");
			}				
		},
		error:function(){
			alert("search fail..");
		}
	});	
}