var parent;
var chlids;
var index;
var selectNum;
var selFileName;
var selFileCode;
var selectMember;
$(document).ready(function() {

	$(".data", document.body).hover(function(event){
		parent = $(this).get(0);
		childs = parent.childNodes;
	});
	document.getElementById("refresh").onclick = function(){
		document.getElementById("fileForm").submit();
	};
	document.getElementById("memberManageButton").onclick = function(){
		document.getElementById("memberForm").submit();
	};
	document.getElementById("fileManageButton").onclick = function(){
		document.getElementById("fileForm").submit();
	};
	$('.data').contextPopup({
	      items: [
	              {label:'삭제하기', action:function(){
	            	  //alert("우클릭 삭제 진입");
	            	  var result = [];
	            		for(var i=0;i<childs.length;i++){
	            			if(childs.item(i).nodeType == 1){
	            				result.push(childs.item(i).innerHTML);
	            			}
	            		}
	            		var rowNum = result[1].replace("&nbsp;","");
	            		var fileCode = result[2].replace("&nbsp;","");
	            		var userId = result[7].replace("&nbsp;", "");
	            		$.ajax({//서블릿에는 파일코드만 전송
	            			type: "post",
	            			data: {fileCode : fileCode},
	            			url: "adminDeleteFile.do",
	            			dataType: "json",
	            			success: function (data) {
	            				if(data.isSuccess == true){
	            					//alert("서블릿한테 받은 데이터 파일코드: "+data.key);
	            					var table = document.getElementById("resultTable");
	            					table.deleteRow(rowNum);
	            					refreshNumber(table);
	            					}
	            				}
	            			}
	            		);
	              } },
	              {label:'이름변경', action:function() {
	            	  $("#fileNameModify").dialog( "open" );
	            	  var result = [];
	            	  for(var i=0;i<childs.length;i++){
	            		  if(childs.item(i).nodeType==1){
	            			  result.push(childs.item(i).innerHTML);
	            		  }
	            	  }
	            	  $("#beforeName").val(result[4].replace("&nbsp;",""));
	            	  document.getElementById("beforeName").select();
	            	  selectNum = result[1].replace("&nbsp;","");
	            	  selFileCode = result[2].replace("&nbsp;","");
	            	  selFileName = result[4].replace("&nbsp;","");
	            	  selectMember = result[7].replace("&nbsp;","");
	              } },
	              ]
	    });
	/*
	 * 다이얼로그 함수
	 */
	$(function() {
		$("#fileNameModify").dialog({
			autoOpen : false,
			modal:true,
			width : 250,
			height : 150,
			buttons : {
				"변경" : function() {
					$.ajax({//서블릿에는 파일코드만 전송
	          			type: "post",
	          			data: {memberCode : selectMember ,fileCode : selFileCode, newFileName : $("#beforeName").val()},
	          			url: "adminFileNameModify.do",
	          			dataType: "json",
	          			success: function (data) {
	          				if(data.isSuccess == true){
		          				var index = parseInt(selectNum);
		          				document.getElementById("resultTable").rows[index].cells[4].innerHTML = "&nbsp;"+ $("#beforeName").val();
	          				} else {
	          					alert(data.reason);
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
		table.rows[i].cells[1].innerHTML = "&nbsp;"+i;
	}
}
function submitFunction(){
	var index = document.getElementById("selectFormat").selectedIndex;
	var options = document.getElementById("selectFormat").options;
	var selectedFormatText = options[index].value;	
	var text = document.getElementById("text").value;
	var method = document.getElementById("form").method;
	var url = document.getElementById("form").action;
	
	
	//alert("선택한파일형식:"+selectedFormatText+"\n선택한등록기간:"+selectedDateText+"\n입력한 검색어:"+text+"\n전송방식:"+method+"\n요청URL:"+url);	
}
function checkFunction(){
	var boxList = document.getElementsByClassName("selectAll");
	if(document.getElementById("allSelect").checked){
		//alert("체크댐");
		for(var i=0;i<boxList.length;i++){
			boxList[i].checked = true;
		}
	} else {
		//alert("언체크댐");
		for(var i=0;i<boxList.length;i++){
			boxList[i].checked = false;
		}
	}	
}
function multiDelete(){
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
		//alert("파일명:"+dataList[i+5]+"\n이메일:"+dataList[i+11]+"\n경로명:"+dataList[i+15]);
	}
}
function searchFile() {
	initTable(document.getElementById("resultTable"));
	var formData = $("#searchForm").serialize();
	
	$.ajax({
		type: "post",
		url: "adminSearchFile.do",
		data: formData,
		dataType: "json",
		success: function (jsonArray) {
			if(jsonArray.length != 0 ){
				//검색결과가 존재하는 경우
				//alert("noEmpty : "+jsonArray);
				//alert(jsonArray.length);
				var table = document.getElementById("resultTable");
				for(var i=0;i<jsonArray.length;i++){
					(function(index){
					var row = table.insertRow(1+index);
					row.className = "data";
					for(var j=0;j<10;j++){
						
							var cell = row.insertCell(j);
							if(j==0){
								var checkBox = document.createElement("input");
								checkBox.type = "checkBox";
								checkBox.className = "selectAll";
								cell.className = "name";
								cell.appendChild(checkBox);
								
							} else if(j==1){
								cell.innerHTML = "&nbsp;"+index;
								cell.className = "type";
								
							} else if(j==2){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].fileCode;
								
							} else if(j==3){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].fileType;
								
							} else if(j==4){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].fileName;
								
							} else if(j==5){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].date;
								
							} else if(j==6){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].uploaderName;
								
							} else if(j==7){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].uploaderId;
								
							} else if(j==8){
								cell.className = "type";
								cell.innerHTML = "&nbsp;"+jsonArray[index].fileCapacity;
								
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
				              {label:'삭제하기', action : function(){
				            	  //alert("우클릭 삭제 진입");
				            	  var result = [];
				            		for(var i=0;i<childs.length;i++){
				            			if(childs.item(i).nodeType == 1){
				            				result.push(childs.item(i).innerHTML);
				            			}
				            		}
				            		var rowNum = result[1].replace("&nbsp;","");
				            		var fileCode = result[2].replace("&nbsp;","");
				            		var userId = result[7].replace("&nbsp;", "");
				            		//alert("삭제하기");
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
				              {label:'이름변경', action:function() {
				            	  $("#fileNameModify").dialog( "open" );
				            	  var result = [];
				            	  for(var i=0;i<childs.length;i++){
				            		  if(childs.item(i).nodeType==1){
				            			  result.push(childs.item(i).innerHTML);
				            		  }
				            	  }
				            	  $("#beforeName").val(result[4].replace("&nbsp;",""));
				            	  document.getElementById("beforeName").select();
				            	  selectNum = result[1].replace("&nbsp;","");
				            	  selFileCode = result[2].replace("&nbsp;","");
				            	  selFileName = result[4].replace("&nbsp;","");
				            	  selectMember = result[7].replace("&nbsp;","");
				              } },
				              ]
				    });
				refreshNumber(document.getElementById("resultTable"));
			} else {
				//alert("isEmpty:"+jsonArray);
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
function reAdjustCSS(){
	$(".name").css("height","40px").css("border-style","none").css("border-top-style","solid").css("border-color","#e6e6e6");
	$(".type").css("heigth","40px").css("border-style","none").css("border-top-style","solid").css("border-left-style", "solid").css("border-color","#e6e6e6");
	$(".time").css("heigth","40px").css("border-style","none").css("border-top-style","solid").css("border-left-style", "solid").css("border-color","#e6e6e6");
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





