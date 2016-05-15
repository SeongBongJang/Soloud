<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jsTree example demo1</title>


<script type="text/javascript" src="/Soloud/jstree/_lib/jquery.js"></script>
<script type="text/javascript" src="/Soloud/jstree/_lib/jquery.cookie.js"></script>
<script type="text/javascript" src="/Soloud/jstree/_lib/jquery.hotkeys.js"></script>
<script type="text/javascript" src="/Soloud/jstree/jquery.jstree.js"></script>

</head>

<body class="nosidebar">
	<div id='demo1' class='demo'>
		<ul>
			<li id='phtml_1'><a href='#'>부모 노드 1</a>
				<ul>
					<li id='phtml_2'><a href='#'>자식 노드 1</a></li>
					<li id='phtml_3'><a href='#'>자식 노드 2</a></li>
					<li id='phtml_4'><a href='#'>자식 노드 3</a></li>
				</ul>
			</li>
			<li id='phtml_5'><a href='#'>부모 노드 2</a>
				<ul>
					<li id='phtml_6'><a href='#'>자식 노드 1</a></li>
					<li id='phtml_7'><a href='#'>자식 노드 2</a></li>
					<li id='phtml_8'><a href='#'>자식 노드 3</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#toggle_node").click(function() {
				$("#demo1").jstree("toggle_node", "#phtml_1");
			});
			$("#demo1")
				.jstree({
					"themes" : {
						"theme" : [ "default" ]
					}, // 트리 테마
					"ui" : {
						"initially_select" : [ "phtml_2" ]
					},
					"core" : {
						"initially_open" : [ "phtml_1" ],
						"html_titles" : [ "true" ]
					},
					"contextmenu" : {					
					      "items" : {
					          "create" : {
					              "separator_before" : false,
					              "separator_after"  : true,
					              "label"            : "만들기",
					              "action"           : function (obj) { this.create(obj); }
					          },
					          "rename" : {
					              "separator_before" : false,
					              "separator_after"  : true,
					              "label"            : "이름변경",
					              "action"           : function (obj) { this.rename(obj); }
					          },
					          "remove" : {
					              "separator_before" : false,
					              "separator_after"  : true,
					              "label"            : "삭제",
					              "action"           : function (obj) { this.remove(obj); }
					          },    
					          "ccp" : {
									"separator_before"	: true,
									"icon"				: false,
									"separator_after"	: false,
									"label"				: "Edit",
									"action"			: false,
									"submenu" : { 
										"cut" : {
											"separator_before"	: false,
											"separator_after"	: false,
											"label"				: "Cut",
											"action"			: function (obj) { this.cut(obj); }
										},
										"copy" : {
											"separator_before"	: false,
											"icon"				: false,
											"separator_after"	: false,
											"label"				: "Copy",
											"action"			: function (obj) { this.copy(obj); }
										},
										"paste" : {
											"separator_before"	: false,
											"icon"				: false,
											"separator_after"	: false,
											"label"				: "Paste",
											"action"			: function (obj) { this.paste(obj); }
										}
									}
								},    
					      }					
					},
					"dnd" : {
					       "drop_finish" : function () { 
					            alert("DROP"); 
					        },
					        "drag_check" : function (data) {
					            alert("CHECK"); 
					            if(data.r.attr("id") == "phtml_1") {
					                return false;
					            }
					            return { 
					               after : false, 
					               before : false, 
					               inside : true 
					            };
					        },
					        "drag_finish" : function (data) { 
					            alert("DRAG OK"); 
					        }
					},
					"plugins" : [ "themes", "html_data" ,"ui", "crrm", "contextmenu","dnd" ]
				});
			
			$("#demo1")
				.bind("select_node.jstree", function (event, data) {      
					$("#log1").html('선택된 노드 id: ' + data.rslt.obj.attr("id"));
      			});
						
			$("#demo1")
				.bind("open_node.jstree", function(event, data) {
					$("#log1").html("oepn operation: " + event.type);
				});
			
			$("#demo1")
				.bind("close_node.jstree", function(event, data) {
					$("#log1").html(data.rslt.obj.attr("id") + " close operation: " + event.type);	
				});
			
		});
	</script>
	
	<div id="log1">log</div>	
</body>
</html>
