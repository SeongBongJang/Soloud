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
	$(document).ready(function() {
		//alert("ㅋㅋㅋ");
		$(function() {
			$("#folder_delete_dialog").dialog({
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
					"삭제" : function() {
						if(selectedFolder === '폴더를 선택해주세요')
						{
							alert(selectedFolder);
						//	$("#folderName").val('');
							$(this).dialog("close");
						}
						//폴더를 삭제해야하는 상황이라면
						else
						{
							$.ajax({
								type: "post",
								url: "/Soloud/deleteFolder.do",
								data:{folderCode:selectedFolder},
								//data: formData,
								dataType: "json",
								success: function (data) 
								{
									if(data.result)
									{
										$("#treeViewDiv").jstree("remove");
										$("#leftPro").html(data.val4);
										$("#rightPro").html(data.val3);
										$("#pro").attr('value', data.val2);
										$("#pro").attr('max', data.val1);
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
						$(this).dialog("close");
					}
				},
				close : function() {
					minimizeAll();
				}
			});
		});
		
		

		$(function() {
			$("#shared_folder_delete_dialog").dialog({
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
					"삭제" : function() {
						if(selectedFolder2 === '폴더를 선택해주세요')
						{
							alert(selectedFolder2);
							$(this).dialog("close");
						}
						//폴더를 삭제해야하는 상황이라면
						else
						{
							$.ajax({
								type: "post",
								url: "/Soloud/deleteFolder.do",
								data:{folderCode:selectedFolder2},
								//data: formData,
								dataType: "json",
								success: function (data) {
									if(data.result)
									{
										$("#treeViewDiv2").jstree("remove");
										$("#leftPro").html(data.val4);
										$("#rightPro").html(data.val3);
										$("#pro").attr('value', data.val2);
										$("#pro").attr('max', data.val1);
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
						$(this).dialog("close");
					}
				},
				close : function() {
					minimizeAll2();
				}
			});
		});
		
		
		$(".folder_delete_button").click(function() {
		//	alert("폴더삭제하기");
			$("#folder_delete_dialog").dialog("open");
		});
		$(".shared_folder_delete_button").click(function() {
			$("#shared_folder_delete_dialog").dialog("open");
		});
		
	});
</script>
<body>
	<div id="folder_delete_dialog" title="폴더 삭제" style='display: none;font-family: 'Nanum Gothic', sans-serif;'>
		<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 0px 0;"></span><p style="font-family: 'Nanum Gothic', sans-serif;">삭제하시겠어요~? 데이터는 모두 지워집니다^^</p>
	</div>
	<div id="shared_folder_delete_dialog" title="공유 폴더 삭제" style='display: none;font-family: 'Nanum Gothic', sans-serif;'>
		<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 0px 0;"></span><p style="font-family: 'Nanum Gothic', sans-serif;">삭제하시겠어요~? 데이터는 모두 지워집니다^^</p>
	</div>
</body>
</html>