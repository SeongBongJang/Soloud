<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/Soloud/script/jquery.js"></script>
<!-- 이게 jquery -->
</head>
<!-- 폰트(나눔고딕) -->
<style type="text/css">
		@import url(/Soloud/css/nanum.css);
</style>


<script>
	//var folderName='';
	//var folderCode='';
	$(document).ready(function() {
		$(function() {
			$("#folder_modify_dialog").dialog({
				autoOpen : false,
				width : 300,
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
						if(selectedFolder === '폴더를 선택해주세요')
						{
							alert(selectedFolder);
							$("#folderName5").val('');
							$(this).dialog("close");
						}
						else if(selectedFolder === 'root')
						{
							//alert('Soloud폴더는 삭제할 수 없습니다.');
						//	$("#folderName").val('');
							$(this).dialog("close");
						}
						//폴더를 수정해야하는 상황이라면
						else
						{
							//alert($("#folderName").val());
							//var folderName=$("#folderName").val();
							
							folderName=$("#folderName5").val();
							$("#folderName5").val('');
							
							$.ajax({
								type: "post",
								url: "/Soloud/modifyFolder.do",
								data:{foldName : folderName, folderCode:selectedFolder},
								//data: formData,
								dataType: "json",
								success: function (data) {
									if(data.result)
									{
										$("#treeViewDiv").jstree('rename_node', "#"+selectedFolder, folderName);
									}
									else
									{
										alert(data.resultMsg);
									}
								}
							});
							minimizeAll();
							$(this).dialog("close");
						}
						
					},
					"취소" : function() {
						minimizeAll();
						$("#folderName5").val('');
						$(this).dialog("close");
					}
				},
				close : function() {
					minimizeAll();
					$("#folderName5").val('');
				}
			});
		});
		
		
		
		//var folderName2='';
		//var folderCode2='';
		$(function() {
			$("#shared_folder_modify_dialog").dialog({
				autoOpen : false,
				width : 300,
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
						if(selectedFolder2 === '폴더를 선택해주세요')
						{
							alert(selectedFolder2);
							$("#folderName6").val('');
							$(this).dialog("close");
						}
						else if(selectedFolder2 === 'root')
						{
							alert('Soloud폴더는 삭제할 수 없습니다.');
						//	$("#folderName").val('');
							$(this).dialog("close");
						}
						//폴더를 수정해야하는 상황이라면
						else
						{
							//alert($("#folderName").val());
							//var folderName=$("#folderName").val();
							
							folderName2=$("#folderName6").val();
							$("#folderName6").val('');
							
							//alert(folderName2);
							$.ajax({
								type: "post",
								url: "/Soloud/modifyFolder.do",
								data:{foldName : folderName2, folderCode:selectedFolder2},
								//data: formData,
								dataType: "json",
								success: function (data) {
									if(data.result)
									{
										$("#treeViewDiv2").jstree('rename_node', "#"+selectedFolder2, folderName2);
										
									}
									else
									{
										alert(data.resultMsg);
									}
								}
							});
							minimizeAll2();
							$(this).dialog("close");
						}
					},
					"취소" : function() {
						minimizeAll2();
						$("#folderName6").val('');
						$(this).dialog("close");
					}
				},
				close : function() {
					minimizeAll2();
					$("#folderName6").val('');
				}
			});
		});
		
		
		$(".folder_modify_button").click(function() {
			$("#folder_modify_dialog").dialog("open");
			//$("#treeViewDiv").jstree('rename');
		

		});
		$(".shared_folder_modify_button").click(function() {
			$("#shared_folder_modify_dialog").dialog("open");
			//$("#treeViewDiv2").jstree('rename');
		});
	});
</script>
<body>
	<div id="folder_modify_dialog" title="폴더 이름 수정" style='display: none;font-family: Nanum Gothic, sans-serif;'>
		<fieldset>
			<table class="folder_modify_table">
				<tr>
					<td style="font-family: 'Nanum Gothic', sans-serif;">폴더이름 : </td><td><input id='folderName5' type="text"></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div id="shared_folder_modify_dialog" title="공유 폴더 이름 수정" style='display: none;font-family: Nanum Gothic, sans-serif;'>
		<fieldset>
			<table class="shared_folder_modify_table">
				<tr>
					<td style="font-family: 'Nanum Gothic', sans-serif;">공유 폴더이름 : </td><td><input id='folderName6' type="text"></td>
				</tr>
			</table>
		</fieldset>
	</div>
</body>
</html>