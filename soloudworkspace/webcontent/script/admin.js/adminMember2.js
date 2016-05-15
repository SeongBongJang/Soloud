var parent;
var chlids;
var index;
var selectNum;
var selFileName;
var selFileCode;
var selectMemberId;
var tdData;
$(document).ready(function() {

	/**
	 * 마우스 오버시 노드 획득
	 */
	$(".data", document.body).hover(function(event){
		parent = $(this).get(0);
		childs = parent.childNodes;
	});
	/*
	 * 상단BAR 퀵이동 메뉴
	 */
	document.getElementById("refresh").onclick = function(){
		document.getElementById("memberForm").submit();
	};
	document.getElementById("memberManageButton").onclick = function(){
		document.getElementById("memberForm").submit();
	};
	document.getElementById("fileManageButton").onclick = function(){
		document.getElementById("fileForm").submit();
	};
	/*
	 * 관리자 모드 회원정보 수정 대화창
	 */
	$(function(){
		$("#modifyMemberInfo").dialog({
			autoOpen:false,
			modal:true,
			width:300, height:300,
			buttons : {
				"수정" : function(){
					var capacity = $("#memberLimitCapacity").val();
					//alert("용량 : "+capacity);
					/*var realCapacity = capacity.substr(0, indexOf(" "));
					alert("리얼용량 : "+realCapacity);*/
					$.ajax({
						type : 'post',
						data : {memberId : $("#memberId").val(), memberName : $("#memberName").val(), memberPassword : $("#memberPassword").val(), memberLimitCapacity : $("#memberLimitCapacity").val()},
						url : 'adminModifyMemberInfo.do',
						dataType : 'json',
						success : function(jsonArray){
							if(jsonArray.length == 0 || jsonArray == null || jsonArray[0].isSuccess == false){
								alert("존재하지 않는 아이디 입니다.");
							} else {
								var table = document.getElementById("resultTable");
								for(var i=0;i<table.rows.length;i++){
									//alert(table.rows[1].cells[1].innerHTML);
									if((table.rows[i].cells[1].innerHTML) == "&nbsp;"+$("#memberId").val()){
										table.rows[i].cells[2].innerHTML = "&nbsp;"+$("#memberName").val();
										table.rows[i].cells[3].innerHTML = "&nbsp;"+$("#memberPassword").val();
										//var temp = $("#memberLimitCapacity").val();
										var temp = document.getElementById("memberLimitCapacity").value;
										
										table.rows[i].cells[4].innerHTML = "&nbsp;"+unitFunction(temp);
										break;
									}
								}
							}	
						}
						
					});
					$(this).dialog("close");
				},
				"취소" : function(){
					$(this).dialog("close");
				}},
				close : function(){
					$(this).dialog("close");
				}
			}
		);
	});
	/*
	 * 관리자 모드 회원탈퇴컨펌 대화창
	 */
	$(function() {
		$("#dropConfirm").dialog({
			autoOpen : false,
			modal:true,
			width : 250,
			height : 210,
			buttons : {
				"확인" : function() {
					$.ajax({//서블릿에는 회원아이디만 전송
	          			type: "post",
	          			data: {memberId : selectMemberId},
	          			url: "adminDropMember.do",
	          			dataType: "json",
	          			success: function (data) {
	          				if(data.isSuccess == true){
		          				alert("정상적으로 탈퇴처리 되었습니다");
		          				document.getElementById("resultTable").deleteRow(selectNum);
		          				refreshNumber(document.getElementById("resultTable"));
	          				}
	          			}
	            	  });
					$(this).dialog("close");
				},
				"취소" : function() {
					$(this).dialog("close");
				}
			},
			close : function() {
			}
		});
	});
});

function refreshNumber(table) {
	for (var i=1;i<table.rows.length; i++) {
		table.rows[i].cells[0].innerHTML = "&nbsp;"+i;
	}
}
/*function submitFunction(){
	var index = document.getElementById("selectFormat").selectedIndex;
	var options = document.getElementById("selectFormat").options;
	var selectedFormatText = options[index].value;	
	var text = document.getElementById("text").value;
	var method = document.getElementById("form").method;
	var url = document.getElementById("form").action;
	
	
	alert("선택한파일형식:"+selectedFormatText+"\n선택한등록기간:"+selectedDateText+"\n입력한 검색어:"+text+"\n전송방식:"+method+"\n요청URL:"+url);	
}
/*function checkFunction(){
	var boxList = document.getElementsByClassName("selectAll");
	if(document.getElementById("allSelect").checked){
		alert("체크댐");
		for(var i=0;i<boxList.length;i++){
			boxList[i].checked = true;
		}
	} else {
		alert("언체크댐");
		for(var i=0;i<boxList.length;i++){
			boxList[i].checked = false;
		}
	}	
}
/*function multiDelete(){
	var check = [];
	var boxList = document.getElementsByClassName("selectAll");
	for(var i=0;i<boxList.length;i++){
		if(boxList[i].checked){
			check.push(boxList[i]);
		}
	}
	var parentList = [];
	for(var i=0;i<check.length;i++){
		parentList.push(check[i].parentNode.parentNode);
	}
	//여기까진 부모 tr뽑아냄
	var dataList = [];
	for(var i=0;i<parentList.length;i++){
		var childs = parentList[i].childNodes;
		for(var j=0;j<childs.length;j++){
			var result = [];
			if(childs.item(j).nodeType == 1){
				result.push(childs.item(j).innerHTML);
			}
		dataList.push(result);
		}
	}
	for(var i=0;i<dataList.length;i+=17){
		alert("파일명:"+dataList[i+5]+"\n이메일:"+dataList[i+11]+"\n경로명:"+dataList[i+15]);
	}
}*/
function searchMember() {
	initTable(document.getElementById("resultTable"));
	var formData = $("#searchForm").serialize();
	
	$.ajax({
		type: "post",
		url: "adminSearchMember.do",
		data: formData,
		dataType: "json",
		success: function (jsonArray) {
			if(jsonArray.length != 0 ){
				//검색결과가 존재하는 경우
				var table = document.getElementById("resultTable");
				for(var i=0;i<jsonArray.length;i++){
					(function(index){
					var row = table.insertRow(1+index);
					row.className = "data";
					for(var j=0;j<6;j++){
							var cell = row.insertCell(j);
							if(j==0) { 
								cell.innerHTML = "&nbsp;"+(index.valueOf()+1);
								cell.className = "name";
							} else if(j==1){
								cell.innerHTML = "&nbsp;"+jsonArray[index].id;
								cell.className = "type";
							} else if(j==2){
								cell.innerHTML = "&nbsp;"+jsonArray[index].name;
								cell.className = "type";
							} else if(j==3){
								cell.innerHTML = "&nbsp;"+jsonArray[index].password;
								cell.className = "type";
							} else if(j==4){
								cell.innerHTML = "&nbsp;"+jsonArray[index].capacityLimit;
								cell.className = "type";
							} else if(j==5){
								cell.innerHTML = "&nbsp;"+jsonArray[index].usedCapacity;
								cell.className = "time";
							} 
						}
					reAdjustCSS();
					})(i);
				}
				$(".data", document.body).hover(function(event){
					parent = $(this).get(0);
					childs = parent.childNodes;
				});
				$('.data').contextPopup({
				      items: [
				              {label:'회원정보수정', action:function(){
				            	  $(".data", document.body).hover(function(event){
				            			parent = $(this).get(0);
				            			childs = parent.childNodes;
				            		});
				            	  var result = [];
				            	  for(var i=0;i<childs.length;i++){
				            		  if(childs.item(i).nodeType==1){
				            			  result.push(childs.item(i).innerHTML);
				            		  }
				            	  }
				            	  tdData = result;
				            	  selectNum = result[0].replace("&nbsp;","");
				            	  selectMemberId = result[1].replace("&nbsp;","");
				            	  //alert(selectNum+"//"+selectMemberId);
				            	  //alert(result[1].replace("&nbsp;","")+result[2].replace("&nbsp;","")+result[3].replace("&nbsp;","")+result[4].replace("&nbsp;","")+result[5].replace("&nbsp;",""));
				            	  
				            	  $("#memberId").val(result[1].replace("&nbsp;",""));
				            	  $("#memberName").val(result[2].replace("&nbsp;",""));
				            	  $("#memberPassword").val(result[3].replace("&nbsp;",""));
				            	  
				            	  var temp = result[4].replace("&nbsp;","");
				            	  var temp2 = temp.substr(0, temp.indexOf(" "));
				            	  
				            	  //alert(temp2);
				            	  $("#memberLimitCapacity").val(temp2.replace("&nbsp;",""));
				            	  $("#memberUsedCapacity").val(result[5].replace("&nbsp;",""));
				            	  
				            	  $("#modifyMemberInfo").dialog("open");
				              } },
				              {label:'탈퇴시키기', action:function() {
				            	  $(".data", document.body).hover(function(event){
				            			parent = $(this).get(0);
				            			childs = parent.childNodes;
				            		}
				            	  );
				            	  var result = [];
				            	  for(var i=0;i<childs.length;i++){
				            		  if(childs.item(i).nodeType==1){
				            			  result.push(childs.item(i).innerHTML);
				            		  }
				            	  }
				            	  selectNum = result[0].replace("&nbsp;","");
				            	  selectMemberId = result[1].replace("&nbsp;","");
				            	  //alert(selectNum+"//"+selectMemberId);
				            	  $("#dropConfirm").dialog("open");
				              } },
				              ]
				    });
				
			} else {
				alert("isEmpty:"+jsonArray);
				var table = document.getElementById("resultTable");
				var row = table.insertRow(1);
				row.className = 'data';
				var cell = row.insertCell(0);
				cell.colSpan = '10';
				cell.style.textAlign = 'center';
				cell.innerHTML = '<h1>검색결과가 없습니다</h1>';
			}
		}
	});
};
/*$(function() {
    $('.data').contextPopup({
      items: [
              {label:'회원정보수정', action:function(){
            	  var result = [];
            		for(var i=0;i<childs.length;i++){
            			if(childs.item(i).nodeType == 1){
            				result.push(childs.item(i).innerHTML);
            			}
            		}
            		$.ajax({//서블릿에는 파일코드만 전송
            			type: "post",
            			data: {fileCode : fileCode},
            			url: "adminDeleteFile.do",
            			dataType: "json",
            			success: function (data) {
            				if(data.isSuccess == true){
            					var table = document.getElementById("resultTable");
            					table.deleteRow(rowNum);
            					refreshNumber(table);
            					}
            				}
            			}
            		);
              } },
              {label:'탈퇴시키기', action:function() {
            	  
            	  var result = [];
            	  for(var i=0;i<childs.length;i++){
            		  if(childs.item(i).nodeType==1){
            			  result.push(childs.item(i).innerHTML);
            		  }
            	  }
            	  selectNum = result[0].replace("&nbsp;","");
            	  selectMemberId = result[1].replace("&nbsp;","");
            	  alert(selectNum+"//"+selMemberId);
              } },
              ]
    });
  });*/
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
function deleteTableRow(tr){
	var result = [];
	var parent = this;
	var childs = parent.childNodes;
	for(var i=0;i<childs.length;i++){
		if(childs.item(i).nodeType == 1){
			result.push(childs.item(i).innerHTML);
			}
		}
	//alert(result[1]+"..."+result[6]);
	$.ajax({
		type: "post",
		url: "adminDeleteFile.do",
		data: null,
		dataType: "json",
		success: function (data) {}
	});
}
function reAdjustCSS(){
	$(".name").css("height","40px").css("border-style","none").css("border-top-style","solid").css("border-color","#e6e6e6");
	$(".type").css("heigth","40px").css("border-style","none").css("border-top-style","solid").css("border-left-style", "solid").css("border-color","#e6e6e6");
	$(".time").css("heigth","40px").css("border-style","none").css("border-top-style","solid").css("border-left-style", "solid").css("border-color","#e6e6e6");
}
function unitFunction(data){
	return data+" Mbyte";
}





