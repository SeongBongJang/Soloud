<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/Soloud/script/jquery.js"></script>
<!-- 이게 jquery -->
</head>
<style type="text/css">

@import url(/Soloud/css/nanum.css);

.jstree-corral li, 
.jstree-corral ins {
    background-image: url("/Soloud/image/main/d.png");
    background-repeat: no-repeat;
    background-color: transparent;
    font-size: 12px;

    margin-top: 1px;
    margin-bottom: 1px;
}

.jstree-corral li {
    background-position: -90px 0;
    background-repeat: repeat-y;
}

.jstree-corral li.jstree-last {
    background: transparent;
}

.jstree-corral .jstree-open > ins {
    background-position: -72px 0;
}

.jstree-corral .jstree-closed > ins {
    background-position: -54px 0;
}

.jstree-corral .jstree-leaf > ins {
    background-position: -36px 0;
}

.jstree-corral .jstree-hovered {
    background: #e7f4f9;
    border: 1px solid #e7f4f9;
    padding: 0 2px 0 1px;
}

.jstree-corral .jstree-clicked {
    background: aqua;
    border: 1px solid aqua;
    padding: 0 2px 0 1px;
    color: black;
}

.jstree-corral a .jstree-icon {
    background-position: -56px -19px;
}

.jstree-corral .jstree-open > a .jstree-icon {
    background-position: -56px -36px;
}

.jstree-corral .jstree-leaf > a .jstree-icon {
    background-position: -56px -36px;
}

.jstree-corral a.jstree-loading .jstree-icon {
    background: url("/Soloud/image/main/throbber.gif") center center no-repeat !important;
}


.jstree-corral.jstree-focused {
    background: white;
}


.jstree-corral .jstree-no-dots li, 
.jstree-corral .jstree-no-dots .jstree-leaf > ins {
     background-position: -18px 0;
}

.jstree-corral .jstree-no-dots .jstree-open > ins {
    background-position: -18px 0;
}

.jstree-corral .jstree-no-dots .jstree-closed > ins {
    background-position: 0 0;
}

.jstree-corral .jstree-no-icons a .jstree-icon {
    display: none;
}


.jstree-corral .jstree-search {
    font-style: italic;
}


.jstree-corral .jstree-no-icons .jstree-checkbox {
    display: inline-block;
}

.jstree-corral .jstree-no-checkboxes .jstree-checkbox {
    display: none !important;
}

.jstree-corral .jstree-checked > a > .jstree-checkbox {
    background-position: -38px -19px;
}

.jstree-corral .jstree-unchecked > a > .jstree-checkbox {
    background-position: -2px -19px;
}

.jstree-corral .jstree-undetermined > a > .jstree-checkbox {
    background-position: -20px -19px;
}

.jstree-corral .jstree-checked > a > .jstree-checkbox: hover {
    background-position: -38px -37px;
}

.jstree-corral .jstree-unchecked > a > .jstree-checkbox: hover {
    background-position: -2px -37px;
}

.jstree-corral .jstree-undetermined > a > .jstree-checkbox: hover {
    background-position: -20px -37px;
} 
</style> 


<script>
var selectedFolder3='';
	$(document).ready(function() {
		
		$(function() {
			$("#folder_copypaste_dialog").dialog({
				autoOpen : false,
				width : 300,
				height : 400,
				show: {
			        effect: "blind",
			        duration: 200
			      },
			      hide: {
			        effect: "explode",
			        duration: 200
			      },
				buttons : {
					"복사" : function() {
						
						
						alert('목적지' +  selectedFolder3 + '출발지' + selectedFolder);
						$.ajax({
							type: "post",
							url: "/Soloud/copyPasteFolder.do",
							data:{dest : selectedFolder3, start:selectedFolder},
							dataType: "json",
							success: function (data) {
								if(data.result)
								{
									//$("#treeViewDiv").jstree("move_node", "#"+selectedFolder,"#"+selectedFolder3);
									alert(data.resultMsg);
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
					,
					"취소" : function() {
						
						minimizeAll();
						$(this).dialog("close");
					}
			
				},
				close : function() {
					
					minimizeAll();
					//$(this).dialog("close");
				}
			});
		});
		
		
		$(function() {
			$("#shared_folder_copypaste_dialog").dialog({
				autoOpen : false,
				width : 300,
				height : 400,
				show: {
			        effect: "blind",
			        duration: 200
			      },
			      hide: {
			        effect: "explode",
			        duration: 200
			      },
				buttons : {
					"복사" : function() {
					//	alert('목적지' +  selectedFolder4 + '출발지' + selectedFolder2);
						$.ajax({
							type: "post",
							url: "/Soloud/copyPasteFolder.do",
							data:{dest : selectedFolder4, start:selectedFolder2},
							dataType: "json",
							success: function (data) {
								if(data.result)
								{
									//$("#treeViewDiv2").jstree("move_node", "#"+selectedFolder2,"#"+selectedFolder4);
									alert(data.resultMsg);
								}
								else
								{
									alert(data.resultMsg);
								}
						
							}
						});
						minimizeAll2();
						$(this).dialog("close");
					},
					"취소" : function() {
						minimizeAll2();
						$(this).dialog("close");
					}
				},
				close : function() {
					minimizeAll2();
					$(this).dialog("close");
				}
			});
		});
		
		$(".folder_copypaste_button").click(function() {
			
			$("#folderCopyPasteTree").jstree({ 
				"core":{
					"animation" : 200
				},
				"json_data" : {
					"ajax" : {
						"url" : "/Soloud/dynamicTree3.do/"+selectedFolder,
						"type" : "post",
						"data" : function (n) { 
							return { id : n.attr ? n.attr("id") : 0 }; 
						}
					}
				},
				"plugins" : [ "themes", "json_data", "ui"]
			}).bind("select_node.jstree", function (e, data)
				{
					selectedFolder3=data.rslt.obj.attr("id");
					alert('목적지' +  selectedFolder3 + '출발지' + selectedFolder);
				}
			);
			
			
			$("#folder_copypaste_dialog").dialog("open");
		});
		$(".shared_folder_copypaste_button").click(function() {
			
			$("#folderCopyPasteTree2").jstree({ 
				"core":{
					"animation" : 200
				},
				"json_data" : {
					"ajax" : {
						"url" : "/Soloud/dynamicTree4.do/s"+selectedFolder2,
						"type" : "post",
						"data" : function (n) { 
							return { id : n.attr ? n.attr("id") : 0 }; 
						}
					}
				},
				"plugins" : [ "themes", "json_data", "ui"]
			}).bind("select_node.jstree", function (e, data)
				{
					selectedFolder4=data.rslt.obj.attr("id");
					alert('목적지' +  selectedFolder4 + '출발지' + selectedFolder2);
				}
			);
			
			$("#shared_folder_copypaste_dialog").dialog("open");
		});
	});
</script>
<body>
<div id="folder_copypaste_dialog" title="폴더 복사" style='display: none;font-family: 'Nanum Gothic', sans-serif;'>
	<div id='folderCopyPasteTree' class='jstree-corral' >
	</div>
</div>

<div id="shared_folder_copypaste_dialog" title="공유 폴더 복사" style='display: none;font-family: 'Nanum Gothic', sans-serif;'>
	<div id='folderCopyPasteTree2' class='jstree-corral' >
	</div>
</div>

</body>
</html>