<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

<!-- 폰트(나눔고딕) -->	
<style type="text/css">
		@import url(/Soloud/css/nanum.css);
</style>  
</head>
	<script>
	var pathFolder='폴더를 선택해주세요';
	var copyFolder='폴더를 선택해주세요';
	$(document).ready(function() {
		$(function() {
			$("#pathTreeDiv").jstree({ 

				"core":{
					"animation" : 0,
					"check_callback" : true,
					"themes":{"stripes" : true}
					
				},

				"json_data" : {
					"ajax" : {
						"url" : "/Soloud/dynamicTree.do",
						"type" : "post",
						"data" : function (n) { 
							return { id : n.attr ? n.attr("id") : 0 }; 
						}
					}
				},
				"types" : {
				    "#" : {
				      "max_children" : 1, 
				      "max_depth" : 4, 
				      "valid_children" : ["root"]
				    },
				    "root" : {
				      "icon" : "/static/3.0.2/assets/images/tree_icon.png",
				      "valid_children" : ["default"]
				    },
				    "default" : {
				      "valid_children" : ["default","file"]
				    },
				    "file" : {
				      "icon" : "glyphicon glyphicon-file",
				      "valid_children" : []
				    }
				  },
				"plugins" : [ "themes", "json_data", "ui",  "crrm", "state", "types", "wholerow"]
			}).bind("select_node.jstree", function (e, data)
				{
				//alert(data.rslt.obj.attr("id"));
				pathFolder=data.rslt.obj.attr("id")
				}
			);
		});
		$(function() {
			$("#copyTreeDiv").jstree({ 

				"core":{
					"animation" : 0,
					"check_callback" : true,
					"themes":{"stripes" : true}
					
				},

				"json_data" : {
					"ajax" : {
						"url" : "/Soloud/dynamicTree.do",
						"type" : "post",
						"data" : function (n) { 
							return { id : n.attr ? n.attr("id") : 0 }; 
						}
					}
				},
				"types" : {
				    "#" : {
				      "max_children" : 1, 
				      "max_depth" : 4, 
				      "valid_children" : ["root"]
				    },
				    "root" : {
				      "icon" : "/static/3.0.2/assets/images/tree_icon.png",
				      "valid_children" : ["default"]
				    },
				    "default" : {
				      "valid_children" : ["default","file"]
				    },
				    "file" : {
				      "icon" : "glyphicon glyphicon-file",
				      "valid_children" : []
				    }
				  },
				"plugins" : [ "themes", "json_data", "ui",  "crrm", "state", "types", "wholerow"]
			}).bind("select_node.jstree", function (e, data)
				{
				//alert(data.rslt.obj.attr("id"));
				copyFolder=data.rslt.obj.attr("id")
				}
			);
		});
		$(function() {
			$("#file_name_dialog").dialog({
				autoOpen : false,
				modal : true,
				width : 250,
				height : 150,
				show: {
			        effect: "blind",
			        duration: 200
			      },
			      hide: {
			        effect: "explode",
			        duration: 200
			      },
				buttons : {
					"수정" : function() {
						menuTemp2 = menuTemp;
						$.ajax({
							url:"file_name", type:"POST", dataType:"json", data:{index : menuTemp2, newName : $("#file_menu_name").val()}, timeout:5000,
			    			success:function(response){
			    				if(response.result == "수정 완료"){
			    					var result = [];
			    	            	var parent = newNameTr[menuTemp2];
			    	            	var childs = parent.childNodes;
			    	            	childs.item(0).innerHTML = "&nbsp;" + response.newName;
			    				}
			    				else if(response.result == "권한"){
			    					alert("권한이 없습니다.");
			    				}
			    				else if(response.result == "이름중복"){
			    					alert("폴더 내 중복되는 이름이 있습니다.");
			    				}
			    				else{
			    					alert("서버가 불안정하여 서비스가 지연되고있습니다...");
			    				}
			    			}
			    		});		
						$(this).dialog("close");
					},
					취소 : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				}
			});
		});
		$(function() {
			$("#file_auth_dialog").dialog({
				autoOpen : false,
				modal : true,
				width : 250,
				height : 150,
				show: {
			        effect: "blind",
			        duration: 200
			      },
			      hide: {
			        effect: "explode",
			        duration: 200
			      },
				buttons : {
					"변경" : function() {
						menuTemp2 = menuTemp;
						$.ajax({
							url:"file_access", type:"POST", dataType:"json", data:{index : menuTemp2, newAccess : $("#file_menu_auth").val()}, timeout:5000,
			    			success:function(response){
			    				if(response.result == "수정 실패"){
			    					alert("서버가 불안정하여 서비스가 지연되고있습니다...");
			    				}
			    				else if(response.result == "권한"){
			    					alert("권한이 없습니다.");
			    				}
			    			}
			    		});		
						$(this).dialog("close");
					},
					취소 : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				}
			});
		});
		$(function() {
			$("#file_del_dialog").dialog({
				autoOpen : false,
				modal : true,
				width : 210,
				height : 160,
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
						menuTemp2 = menuTemp;
						$.ajax({
							url:"file_delete", type:"POST", dataType:"json", data:{index : menuTemp2}, timeout:5000,
			    			success:function(response){
			    				if(response.result == "삭제 완료"){
			    					document.getElementById("fileTable").deleteRow(parseInt(menuTemp2, 10)+1);
			    					document.getElementById("leftPro").innerHTML = response.usedCapacity + "&nbsp/";
			    					document.getElementById("rightPro").innerHTML = response.maxCapacity;
			    					$("#pro").attr("value", response.usedC);
			    					$("#pro").attr("max", response.maxC);
			    				}
			    				else if(response.result == "권한"){
			    					alert("권한이 없습니다.");
			    				}
			    				else{
			    					alert("서버가 불안정하여 서비스가 지연되고있습니다...");
			    				}
			    			}
			    		});		
						$(this).dialog("close");
					},
					취소 : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				}
			});
		});
		$(function() {
			$("#file_path_dialog").dialog({
				autoOpen : false,
				modal : true,
				width : 350,
				height : 300,
				show: {
			        effect: "blind",
			        duration: 200
			      },
			      hide: {
			        effect: "explode",
			        duration: 200
			      },
				buttons : {
					"이동" : function() {
						menuTemp2 = menuTemp;
						if(pathFolder=='폴더를 선택해주세요'){
							alert('폴더를 선택해주세요');
						}
						else{
							$.ajax({
								url:"file_path", type:"POST", dataType:"json", data:{folderCode : pathFolder, index : menuTemp2}, timeout:5000,
				    			success:function(response){
				    				if(response.result == "이동 완료"){
				    					document.getElementById("fileTable").deleteRow(parseInt(menuTemp2, 10)+1);
				    					alert("이동이 완료되었습니다");
				    				}
				    				else if(response.result == "권한"){
				    					alert("권한이 없습니다.");
				    				}
				    				else if(response.result == "중복"){
				    					document.getElementById("fileTable").deleteRow(parseInt(menuTemp2, 10)+1);
				    					alert("해당 폴더에 이미 같은 이름의 파일이 있어, 이동된 파일의 이름이 수정되었습니다.");
				    				}
				    				else if(response.result == "루트"){
										alert("루트 폴더는 이동할 수 없습니다.");				    					
				    				}
				    				else{
				    					alert("서버가 불안정하여 서비스가 지연되고있습니다...");
				    				}
				    			}
				    		});		
						}
						$(this).dialog("close");
					},
					취소 : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				}
			});
		});
		$(function() {
			$("#file_copy_dialog").dialog({
				autoOpen : false,
				modal : true,
				width : 350,
				height : 300,
				show: {
			        effect: "blind",
			        duration: 200
			      },
			      hide: {
			        effect: "explode",
			        duration: 200
			      },
				buttons : {
					"붙여넣기" : function() {
						menuTemp2 = menuTemp;
						if(copyFolder=='폴더를 선택해주세요'){
							alert('폴더를 선택해주세요');
						}
						else{
							$.ajax({
								url:"file_copy", type:"POST", dataType:"json", data:{folderCode : copyFolder, index : menuTemp2},
				    			success:function(response){
				    				if(response.result == "복사 완료"){
				    					document.getElementById("leftPro").innerHTML = response.usedCapacity + "&nbsp/";
				    					document.getElementById("rightPro").innerHTML = response.maxCapacity;
				    					$("#pro").attr("value", response.usedC);
				    					$("#pro").attr("max", response.maxC);
				    					alert("복사가 완료되었습니다.");
				    				}
				    				else if(response.result == "권한"){
				    					alert("권한이 없습니다.");
				    				}
				    				else if(response.result == "중복"){
				    					document.getElementById("leftPro").innerHTML = response.usedCapacity + "&nbsp/";
				    					document.getElementById("rightPro").innerHTML = response.maxCapacity;
				    					$("#pro").attr("value", response.usedC);
				    					$("#pro").attr("max", response.maxC);
				    					alert("해당 폴더에 이미 같은 이름의 파일이 있어, 복사된 파일의 이름이 수정되었습니다.");
				    				}
				    				else if(response.result == "루트"){
										alert("루트 폴더는 이동할 수 없습니다.");				    					
				    				}
				    				else if(response.result == "용량"){
				    					alert("용량이 부족합니다.");
				    				}
				    				else{
				    					alert("서버가 불안정하여 서비스가 지연되고있습니다...");
				    				}
				    			}
				    		});		
						}
						$(this).dialog("close");
					},
					취소 : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				}
			});
		});
	});
</script>
	<body>
	<div id="file_name_dialog" title="이름 바꾸기" style="display:none">
		<fieldset>
				<table class="file_name_table">
					<tr>
						<td>파일이름 : </td><td><input type="text" name="fileMenuName" id="file_menu_name"></td>
					</tr>
				</table>
		</fieldset>
	</div>
	<div id="file_auth_dialog" title="권한 바꾸기" style="display:none;font-family: 'Nanum Gothic', sans-serif;">
		<fieldset>
			<form action="file_access" method="post" id="accessForm">
				<table class="file_auth_table">
					<tr>
						<td style="font-family: 'Nanum Gothic', sans-serif;">권한 설정 : </td><td>
						<select class="file_friend_step" style="width: 150px;"
							tabindex="-1" name="fileMenuAuth" id="file_menu_auth">
								<option value="나만보기">나만보기</option>
								<option value="절친">절친</option>
								<option value="친구">친구</option>
								<option value="어색한친구">어색한친구</option>
						</select></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
	<div id="file_del_dialog" title="삭제하기" style="display:none;font-family: 'Nanum Gothic', sans-serif;">
		<fieldset>
			<form action="file_delete" method="post" id="deleteForm">
				<table class="file_del_table">
					<tr>
						<td style="font-size:13px; text-align:center; font-family: 'Nanum Gothic', sans-serif;">정말로 삭제 하시겠습니까?</td>
					</tr>
					<tr>
						<td style="font-size:11px; text-align:center; font-family: 'Nanum Gothic', sans-serif;">삭제된 파일은 다시 복구되지 않습니다.</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
	<div id="file_copy_dialog" title="복사/붙여넣기" style="display:none;font-family: Nanum Gothic, sans-serif;">
			<p style="font-family: 'Nanum Gothic', sans-serif;">붙여넣기 할 폴더를 선택하세요.</p>
			<form action="file_copy" method="post" id="copyForm">
				<table class="file_copy_table">
					<tr>	
					</tr>
					<tr>
						<td><div id='copyTreeDiv'></div></td>
					</tr>
				</table>
			</form>
	</div>
	<div id="file_path_dialog" title="이동하기" style="display:none;font-family: Nanum Gothic, sans-serif;">
			<p style="font-family: 'Nanum Gothic', sans-serif;">이동 할 폴더를 선택하세요.</p>
			<form action="file_path" method="post" id="pathForm">
				<table class="file_path_table">
					<tr>	
					</tr>
					<tr>
						<td><div id='pathTreeDiv'></div></td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>