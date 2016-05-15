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
	var folderName='';
	//var folderCode='';
	$(document).ready(function() {
		$(function() {
			$("#folder_create_dialog").dialog({
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
					"생성" : function() {
						if(selectedFolder === '폴더를 선택해주세요')
						{
							alert(selectedFolder);
							$("#folderName").val('');
							$(this).dialog("close");
						}
						//폴더를 생성해야하는 상황이라면
						else
						{
							//alert($("#folderName").val());
							//var folderName=$("#folderName").val();
							
							folderName=$("#folderName").val();
							
							$("#folderName").val('');
							
							
							$.ajax({
								type: "post",
								url: "/Soloud/makeFolder.do",
								data:{foldName : folderName, parentFolderCode:selectedFolder, isSharedFolder:"일반"},
								//data: formData,
								dataType: "json",
								success: function (data) {
									//alert(data.nextCode);
									if(data.result)
									{
										$("#treeViewDiv").jstree("create", "#" + selectedFolder, "last", {"data" : folderName, "attr" : {"id" : data.nextCode}}, false, true);
										
									}
									else
									{
										alert(data.resultMsg);
										
									}
								}
							});
							$(this).dialog("close");
							minimizeAll();
						}
					},
					"취소" : function() {
						$("#folderName").html("");
						minimizeAll();
						$(this).dialog("close");
					}
				},
				close : function() {
					$("#folderName").html("");
					minimizeAll();
					//$(this).dialog("close");
				}
			});
		});
		
		
		
		var folderName2='';
		//var folderCode2='';
		$(function() {
			$("#shared_folder_create_dialog").dialog({
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
					"생성" : function() {
						if(selectedFolder2 === '폴더를 선택해주세요')
						{
							alert(selectedFolder2);
							$("#folderName2").val('');
							$(this).dialog("close");
						}
						//폴더를 생성해야하는 상황이라면
						else
						{
							//alert($("#folderName2").val());
							//var folderName=$("#folderName").val();
							folderName2=$("#folderName2").val();
							
							$("#folderName2").val('');
							
							
							$.ajax({
								type: "post",
								url: "/Soloud/makeFolder.do",
								data:{foldName : folderName2, parentFolderCode:selectedFolder2, isSharedFolder:"공유"},
								//data: formData,
								dataType: "json",
								success: function (data) {
									if(data.result)
									{
										alert("새로 생성한 폴더의폴더코드 : " + data.nextCode);
										$("#treeViewDiv2").jstree("create", "#" + selectedFolder2, "last", {"data" : folderName2, "attr" : {"id" : data.nextCode}}, false, true);
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
						$("#folderName2").val('');
						$(this).dialog("close");
					}
				},
				close : function() {
					minimizeAll2();
					$("#folderName2").html("");
					//$(this).dialog("close");
				}
			});
		});
		
		
		$(".folder_create_button").click(function() {
			$("#folder_create_dialog").dialog("open");
		});
		$(".shared_folder_create_button").click(function() {
			$("#shared_folder_create_dialog").dialog("open");
		});
	});
</script>
<body>
	<div id="folder_create_dialog" title="폴더 생성" style='display: none;font-family: Nanum Gothic, sans-serif;'>
		<fieldset>
			<table class="folder_create_table">
				<tr>
					<td style="font-family: 'Nanum Gothic', sans-serif;">폴더이름 : </td><td><input id='folderName' type="text"></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div id="shared_folder_create_dialog" title="공유 폴더 생성" style='display: none;font-family: Nanum Gothic, sans-serif;'>
		<fieldset>
			<table class="shared_folder_create_table">
				<tr>
					<td style="font-family: 'Nanum Gothic', sans-serif;">공유 폴더이름 : </td><td><input id='folderName2' type="text"></td>
				</tr>
			</table>
		</fieldset>
	</div>
</body>
</html>