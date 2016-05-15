var selectedFolder='폴더를 선택해주세요';
var parent;
var chlids;
var selectedId;
$(document).ready(function() {
	
	$(".data", document.body).hover(function(event){
		parent = $(this).get(0);
		childs = parent.childNodes;
	});
	
	$("#sharedInvite").click(function(){
		
		loadExceptMyFriend();
		$("#inviteList").dialog("open");
	});
	$("#reply").click(function(){
		$("#replyDialog").dialog("open");
		loadReplyList();
	});
	
	//공유폴더 친구초대 다이얼로그 
	$(function(){
		$("#inviteList").dialog({
			autoOpen : false,
			modal:true,
			width : 330,
			height : 250,
			buttons : {
				"닫기" : function(){
					$(this).dialog("close");
				}},
			close : function(){
				
			}
		});
	});
	$(function(){
		$("#addReply").dialog({
			autoOpen : false,
			modal:true,
			width:300,heigt:180,
			buttons : {
				"등록" : function(){
					$.ajax({
						type:'post',
						url:'addReply.do',
						data:{content : $("#content").val()},
						dataType:'json',
						error : function(){
							alert("add Reply Error");
						},
						success : function(data){
							if(data.isSuccess == true){
								alert("댓글이 등록되었습니다");
								$("#content").val("");
								$("#addReply").dialog("close");
								
								$("#replyDialog").dialog("close");
								return;
							} else {
								alert("댓글 등록에 실패하였습니다");
								$("#content").val("");
								$("#addReply").dialog("close");
								return;
							}
						}
					});	
					$(function(){
						$(this).dialog("close");
					});
				},
				"취소" : function(){
					$(this).dialog("close");
				}
			},
			close : function(){
				$(this).dialog("close");
			}
		});
	});
});
function initTable2(table){
	var cnt = table.rows.length;
	if(cnt == 1){
		return;
	}
	for(var i=cnt-1;i>0;i--){
		table.deleteRow(i);
	}
}
function initTable(table){
	//var table = document.getElementById("friendRecommend_table");
	var cnt = table.rows.length;
	for(var i=cnt-1;i>=0;i--){
		alert(i);
		table.deleteRow(i);
	} 
}
function initTable3(table){
	var cnt = table.rows.length;
	for(var i=0;i<cnt;i++){
		table.deleteRow(0);
	}
}
//공유폴터 댓글목록 다이얼로그
function loadReplyList(){
	var tb = document.getElementById("replyTable");
	initTable3(tb);
	$.ajax({
		type: "post",
		url: "loadReply.do",
		data : {folderCode : selectedFolder},
		dataType: "json",
		success: function (replyList) {			
			var table = document.getElementById("replyTable");
			if(replyList[0].isExist == false){
				var row = table.insertRow(0);
				var cell = row.insertCell(0);
				cell.colSpan='2';
				cell.innerHTML = "댓글이 없습니다";
				cell.style.textAlign = 'center';
				return;
			}
			var tableIndex = 0;
			var dataIndex = 0;
			while(true){
				var writerRow = table.insertRow(tableIndex);
				writerRow.insertCell(0).innerHTML = replyList[dataIndex].writerName;
				writerRow.insertCell(1).innerHTML =  replyList[dataIndex].writerId;
				
				var contentRow = table.insertRow(tableIndex+1);
				contentRow.insertCell(0).innerHTML =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+replyList[dataIndex].content;
				contentRow.insertCell(1).innerHTML =  replyList[dataIndex].writeDate;
				tableIndex+=2;
				dataIndex++;
				if(dataIndex == replyList.length){
					tableIndex = 0;
					dataIndex = 0;
					break;
				}
			}
		},
		error : function(asd){
			alert("공유폴더를 선택하세요");
		}
	});
}


//공유폴더 댓글목록 리스트


//공유폴더 친구초대 다이얼로그
$(function() {
	$("#replyDialog").dialog({
		autoOpen : false,
		modal:true,
		width : 330,
		height : 250,
		buttons : {
			"닫기" : function() {
				$(this).dialog("close");
			},
			"댓글 달기" : function(){
				$.ajax({
					type:'get',
					dataType:'json',
					url:'findUser.do',
					success : function(data){
						if(data.isSuccess){
							$("#id").val("");
							var info = data.name+"("+data.id+")";
							alert(info);
							document.getElementById("id").value = info;
							
							$("#addReply").dialog("open");
						} else {
							alert("사용자 인증에 실패하였습니다");
						}
					}
				});
				
			}},
		close : function() {
		}
	});
});
function loadExceptMyFriend(){
	$.ajax({
		type:'get',
		dataType:'json',
		url:'loadUninvitedFriendList.do',
		error : function(){
			alert("loadFriend ERROR");
		},
		success : function(myFriendList){
			var table = document.getElementById("unInvitefriendList");
			initTable2(table);
			if(myFriendList.length == 0 || myFriendList == null){
				var cell = table.insertRow(1).insertCell(0);
				cell.colSpan = '3';
				cell.innerHTML = "초대 가능한 친구가 없습니다";
				return;
			}
			var buttons =[];
			for(var i=0;i<myFriendList.length;i++){
				buttons[i] = document.createElement("img");
			}
			for(var i=0;i<myFriendList.length;i++){
			
				table = document.getElementById("unInvitefriendList");
				var row = table.insertRow(i+1);
				row.className="data";
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.className = 'friendName';
				cell2.className = 'friendId';
				cell1.innerHTML = myFriendList[i].friendName;
				cell2.innerHTML = myFriendList[i].friendId;
				
				buttons[i].src = '/Soloud/image/sharedFriend/inviteButton.png';
				buttons[i].className = "inviteButton";
				buttons[i].style.cursor = 'pointer';
				buttons[i].onmouseover=function(){
					this.src='/Soloud/image/sharedFriend/inviteButton2.png';
				};
				buttons[i].onmouseout=function(){
					this.src="/Soloud/image/sharedFriend/inviteButton.png";
				};
				$(".inviteButton").css("width","30%").css("cursor", "pointer");
				cell3.appendChild(buttons[i]);
			}		
			reAdjust();
			select();
			invite();
		}
	});
}
function reAdjust(){
	$(".friendName").css("width", "75px");
	$(".friendId").css("width", "100px");
	$(".friendId").hover(function(){
		var buttons = document.getElementsByClassName("inviteButton");
		for(var i=0;i<buttons.length;i++){
			buttons.src = '/Soloud/image/sharedFriend/inviteButton2.png';
		}
	});
}
function select(){
	$(".data", document.body).hover(function(event){
		parent = $(this).get(0);
		childs = parent.childNodes;
		var result = [];
		for(var i=0;i<childs.length;i++){
			if(childs.item(i).nodeType == 1){
				result.push(childs.item(i).innerHTML);
			}
		}
		selectedId = result[1].replace("&nbsp;", "");
	});
}
function invite(){
	$(".inviteButton").click(function(){
		var inviteTarget = selectedId;
		alert(inviteTarget);
		$.ajax({
			type:'post',
			data:{id : inviteTarget},
			dataType : 'json',
			url : "inviteFriend.do",
			success : function(data){
				if(data.isSuccess == true){
					alert("정상적으로 초대되었습니다!");
				} else {
					alert("초대에 실패하였습니다.");
				}
			}
		});
	});
}






