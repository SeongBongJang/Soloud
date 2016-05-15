var name2;
var id2;
function loadFriendProposal(){
	$.ajax({
		type: "GET",
		url: "loadFriendProposal.do",
		dataType: "json",
		success: function (data) {
			var table = document.getElementById("friendRecommend_table");
			
			if(data.length==0)
			{
				var emptyRow = table.insertRow(1);
				var emptyCell = emptyRow.insertCell(0);
				emptyCell.innerHTML = "최근 알림이 없습니당";
			}else{
				var imgAccept = [];
				var imgRefuse = [];
				for(var i=0;i<data.length; i++){
					imgAccept[i] = document.createElement("img");
					imgRefuse[i] = document.createElement("img");
				}
				for(var i=0;i<data.length;i++){
					var emptyRow = table.insertRow(i+1);
					emptyRow.style.margin = 0;
					emptyRow.style.padding = 0;
					emptyRow.style.border = "solid";
					emptyRow.id = data[i].id;


					var td1 = emptyRow.insertCell(0);
					td1.innerHTML = data[i].name +" 님이 친구를 신청하였습니다";
					td1.style.textAlign = 'left';
					var td2 = emptyRow.insertCell(1);
					imgAccept[i].id = i;
					imgAccept[i].style.cursor = "pointer";
					imgAccept[i].src="/Soloud/image/friendRecommend/approval1.png";
					imgAccept[i].onmouseover=function(){
						this.src="/Soloud/image/friendRecommend/approval2.png";
					};
					imgAccept[i].onmouseout=function(){
						this.src="/Soloud/image/friendRecommend/approval1.png";
					};
					imgAccept[i].onclick = function(){
						$("#name2").text(data[$(this).attr("id")].name);
						$("#id2").text(data[$(this).attr("id")].id);
						name2 = data[$(this).attr("id")].name;
						id2 = data[$(this).attr("id")].id;
						$(this).parent().parent().remove();
						$("#accept_dialog").dialog("open");
					};
					imgAccept[i].className = "accept3_button";
					td2.appendChild(imgAccept[i]);


					var td3= emptyRow.insertCell(2);
					imgRefuse[i].style.cursor = "pointer";
					imgRefuse[i].id = data[i].id;
					imgRefuse[i].src="/Soloud/image/friendRecommend/refuse1.png";
					imgRefuse[i].onmouseover= function(){
						this.src="/Soloud/image/friendRecommend/refuse2.png";};
						imgRefuse[i].onmouseout = function(){
							this.src="/Soloud/image/friendRecommend/refuse1.png";};
							imgRefuse[i].onclick = function(){
								//$("#recommend_dialog").dialog("open");
								var id = $(this).attr("id");
								$(this).parent().parent().remove();
								refuseFunction(id);
							};
							imgRefuse[i].className = "refuse3_button";
							td3.appendChild(imgRefuse[i]);
				}
				$("#friendAlarmIcon").attr("src","/Soloud/image/titleBar/friendalarm.png");
			}
		}
	});
};
//거절 시 삭제하는 함수
function refuseFunction(id){
	$.ajax({
		type: "post",
		url: "refuseProposal.do",			
		data : {friendMemberId : id},	
		dataType: "json",				
		success: function (data) {		
			if(data.isSuccess == true){
			}
		},
		error:function(){
			alert("refuse fail.."); 
		}
	});
};
function acceptFunction(){
	$.ajax({
		type: "post",
		url: "acceptProposal.do",			
		data : {friendMemberId : id2 , friendMemberName:name2},	
		dataType: "json",				
		success: function (data) {	
		},
		error:function(){
			alert("refuse fail..");
		}
	});
}
function initTable(table){
	//var table = document.getElementById("friendRecommend_table");
	var cnt = table.rows.length;
	if(cnt == 1){
		return;
	}
	for(var i=cnt-1;i>0;i--){
		table.deleteRow(i);
	} 
}
function loadOtherProposal(){

	$.ajax({
		type: "get",
		url: "/Soloud/loadOtherProposal.do",
		dataType: "json",
		success: function (data) {
			var table = document.getElementById("alram_table");
			if(data.otherProposalList==null)
			{
				var emptyRow = table.insertRow(1);
				var emptyCell = emptyRow.insertCell(0);
				emptyCell.innerHTML = "최근 알림이 없습니당";
			}
			else 
			{
				var cnt = data.otherProposalList.length;
				for(var i=0;i<cnt;i++)
				{
					var tr = table.insertRow(i+1);
					var td = tr.insertCell(0);
					td.style.fontSize='14px';
					td.style.textAlign='left';
					td.innerHTML = data.otherProposalList[i];
				}
				$("#alarmIcon").attr('src', '/Soloud/image/titleBar/talkbaloon4.png');
			}
		}
	});
}
$(document).ready(function(){
	$("#accept_dialog").dialog({
		autoOpen : false,
		modal : true,
		width : 400,
		height : 250,
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
				acceptFunction();
				$(this).dialog("close");
			},
			"취소" : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
		}
	});

	$("#friend_Recommend").click(function(){
		if($("#friendRecommend_list").css("display") == "none"){
			initTable(document.getElementById("alram_table"));
			loadFriendProposal();
			jQuery('#friendRecommend_list').css("display", "block");
			jQuery('#alram_list').css("display", "none");
			jQuery('#setting_list').css("display", "none");
		}else{
			initTable(document.getElementById("friendRecommend_table"));
			initTable(document.getElementById("alram_table"));
			jQuery('#friendRecommend_list').css("display", "none");

		}
	});
	$("#alram").click(function(){
		if($("#alram_list").css("display") == "none"){
			initTable(document.getElementById("friendRecommend_table"));
			loadOtherProposal();
			jQuery('#alram_list').css("display", "block");
			jQuery('#friendRecommend_list').css("display", "none");
			jQuery('#setting_list').css("display", "none");
		}else{
			initTable(document.getElementById("alram_table"));
			jQuery('#alram_list').css("display", "none");
		}
	});
	$("#profile").click(function(){
		if($("#setting_list").css("display") == "none"){
			initTable(document.getElementById("friendRecommend_table"));
			initTable(document.getElementById("alram_table"));
			jQuery('#setting_list').css("display", "block");
			jQuery('#friendRecommend_list').css("display", "none");
			jQuery('#alram_list').css("display", "none");
		}else{
			initTable(document.getElementById("alram_table"));
			jQuery('#setting_list').css("display", "none");
		}
	});
	$("#refresh").click(function(){
		$("#form").submit();
	});
});

