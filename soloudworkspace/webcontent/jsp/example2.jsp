<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jsTree example demo2</title>

<script type="text/javascript" src="/Soloud/jstree/jquery.jstree.js"></script>
<style type="text/css">
@import url(/Soloud/css/nanum.css);

#treeViewDiv2 li, 
#treeViewDiv2 ins {
    background-image: url("/Soloud/image/main/d.png");
    background-repeat: no-repeat;
    background-color: transparent;
    font-size: 12px;

    margin-top: 1px;
    margin-bottom: 1px;
}

#treeViewDiv2 li {
    background-position: -90px 0;
    background-repeat: repeat-y;
}

#treeViewDiv2 li.jstree-last {
    background: transparent;
}

#treeViewDiv2 .jstree-open > ins {
    background-position: -72px 0;
}

#treeViewDiv2 .jstree-closed > ins {
    background-position: -54px 0;
}

#treeViewDiv2 .jstree-leaf > ins {
    background-position: -36px 0;
}

#treeViewDiv2 .jstree-hovered {
    background: #e7f4f9;
    border: 1px solid #e7f4f9;
    padding: 0 2px 0 1px;
}

#treeViewDiv2 .jstree-clicked {
    background: aqua;
    border: 1px solid aqua;
    padding: 0 2px 0 1px;
    color: black;
}

#treeViewDiv2 a .jstree-icon {
    background-position: -56px -19px;
}

#treeViewDiv2 .jstree-open > a .jstree-icon {
    background-position: -56px -36px;
}

#treeViewDiv2 .jstree-leaf > a .jstree-icon {
    background-position: -56px -36px;
}

#treeViewDiv2 a.jstree-loading .jstree-icon {
    background: url("/Soloud/image/main/throbber.gif") center center no-repeat !important;
}


#treeViewDiv2 .jstree-focused {
    background: white;
}


#treeViewDiv2 .jstree-no-dots li, 
#treeViewDiv2 .jstree-no-dots .jstree-leaf > ins {
     background-position: -18px 0;
}

#treeViewDiv2 .jstree-no-dots .jstree-open > ins {
    background-position: -18px 0;
}

#treeViewDiv2 .jstree-no-dots .jstree-closed > ins {
    background-position: 0 0;
}

#treeViewDiv2 .jstree-no-icons a .jstree-icon {
    display: none;
}


#treeViewDiv2 .jstree-search {
    font-style: italic;
}


#treeViewDiv2 .jstree-no-icons .jstree-checkbox {
    display: inline-block;
}

#treeViewDiv2 .jstree-no-checkboxes .jstree-checkbox {
    display: none !important;
}

#treeViewDiv2 .jstree-checked > a > .jstree-checkbox {
    background-position: -38px -19px;
}

#treeViewDiv2 .jstree-unchecked > a > .jstree-checkbox {
    background-position: -2px -19px;
}

#treeViewDiv2 .jstree-undetermined > a > .jstree-checkbox {
    background-position: -20px -19px;
}

#treeViewDiv2 .jstree-checked > a > .jstree-checkbox: hover {
    background-position: -38px -37px;
}

#treeViewDiv2 .jstree-unchecked > a > .jstree-checkbox: hover {
    background-position: -2px -37px;
}

#treeViewDiv2 .jstree-undetermined > a > .jstree-checkbox: hover {
    background-position: -20px -37px;
}
</style> 


</head>

<body>
	<div id='treeViewDiv2' class='jstree-corral'>
	</div>
	<script type="text/javascript">
	var selectedFolder2='폴더를 선택해주세요';
	$(function () {
			$("#treeViewDiv2").jstree({ 
				"core":{
					"animation" : 200,
					"check_callback" : true,
					"themes":{"stripes" : true}
					
				},
				 "types" : {     
					   "valid_children" : [ "fo21" ], //<== THIS IS THE IMPORTANT ONE !
					 "types" : {
                        "default" : {
                              "valid_children" : "none"
       	   				  },
                        "root" : {
                              "valid_children" : "default"
				 	      }
					   }
			     },
				"json_data" : {
					"ajax" : {
						"url" : "/Soloud/dynamicTree2.do",
						"type" : "post",
						"data" : function (n) { 
							return { id : n.attr ? n.attr("id") : 0 }; 
						}
					}
				},
				"plugins" : [ "themes", "json_data", "ui", "crrm" ]
			}).bind("select_node.jstree", function (e, data)
					{
				//alert(data.rslt.obj.attr("id"));
				selectedFolder2=data.rslt.obj.attr("id");
				$.ajax({
	    			url:"file_folder", type:"POST", dataType:"json", data:{folder_path : selectedFolder2}, timeout:5000,
	    			success:function(response){
	    				var size = document.getElementById("fileTable").rows.length;
	    				for(var i=size-1; i>0; i--){
	    					document.getElementById("fileTable").deleteRow(i);
	    				}
	    				for(var i=0; i<response.size; i++){
	    					(function closure(index){
		    					document.getElementById("fileTable").insertRow(index+1);
		    					document.getElementById("fileTable").rows[index+1].className = "list_table";
		    					document.getElementById("fileTable").rows[index+1].insertCell();
		    					document.getElementById("fileTable").rows[index+1].insertCell();
		    					document.getElementById("fileTable").rows[index+1].insertCell();		    					
		    					document.getElementById("fileTable").rows[index+1].onmouseout = function(){this.style.backgroundColor="white"};
		    					document.getElementById("fileTable").rows[index+1].onmouseover = function(){ menuTemp = this.rowIndex-1; this.style.backgroundColor="pink"};
		    					document.getElementById("fileTable").rows[index+1].onclick = function(){ 
		    						// 선택된 row 색깔 변경
		    					  	$(this.childNodes).css("background", "pink");
		    					  	// 선택된 데이터 저장
		    					  	list_data.push(this.rowIndex);
		    					  	var temp = this.rowIndex-1;
		    					  	$.ajax({
		    			    			url:"file_info", type:"POST", dataType:"json", data:{index : temp}, timeout:5000,
		    			    			success:function(response){
		    			    				document.getElementById("info_name").innerHTML = response.fileName;
		    			    				document.getElementById("info_type").innerHTML = response.type;
		    			    				document.getElementById("info_access").innerHTML = response.accessAuth;
		    			    				document.getElementById("info_capacity").innerHTML = response.capacity;
		    			    				document.getElementById("info_uploader").innerHTML = response.uploaderName;
		    			    				document.getElementById("info_comment").innerHTML = response.comment;
		    			    				document.getElementById("file_info").style.display = "inline";
		    			    			}
		    			    		});		
		    					};
		    					document.getElementById("fileTable").rows[index+1].cells[0].className = "이름";
		    					document.getElementById("fileTable").rows[index+1].cells[0].innerHTML = response.fileName[index];		    					
		    					document.getElementById("fileTable").rows[index+1].cells[0].style.borderBottomStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[0].style.borderLeftStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[0].style.borderRightStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[0].style.borderColor="#E6E6E6";
		    					document.getElementById("fileTable").rows[index+1].cells[0].style.height="40px";
		    					document.getElementById("fileTable").rows[index+1].cells[1].className = "유형";
		    					document.getElementById("fileTable").rows[index+1].cells[1].innerHTML = response.fileType[index];
		    					document.getElementById("fileTable").rows[index+1].cells[1].style.borderBottomStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[1].style.borderRightStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[1].style.borderColor="#E6E6E6";
		    					document.getElementById("fileTable").rows[index+1].cells[1].style.height="40px";
		    					document.getElementById("fileTable").rows[index+1].cells[2].className = "시간";
		    					document.getElementById("fileTable").rows[index+1].cells[2].innerHTML = response.time[index];
		    					document.getElementById("fileTable").rows[index+1].cells[2].style.borderBottomStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[2].style.borderRightStyle="none";
		    					document.getElementById("fileTable").rows[index+1].cells[2].style.borderColor="#E6E6E6";
		    					document.getElementById("fileTable").rows[index+1].cells[2].style.height="40px";
	    					})(i);
	    				} 
	    				$(function() {
	    				    $('.list_table').contextPopup({
	    				      items: [
	    				        {label:'PlayList +',              action:function() { alert('서비스 준비중'); } },
	    				        null, // divider
	    				        {label:'삭제',                 action:function() { $("#file_del_dialog").dialog("open"); } },
	    				        {label:'이름 바꾸기',                 action:function() { newNameTr = $(".list_table"); $("#file_name_dialog").dialog("open"); $("#file_menu_name").val("");} },
	    				        {label:'권한변경',             action:function() { $("#file_auth_dialog").dialog("open"); document.getElementById("file_menu_auth").selectedIndex = "0";} },
	    				        null, // divider
	    				        {label:'복사..',                action:function() { $("#file_copy_dialog").dialog("open"); } },
	    				        {label:'이동',         action:function() { $("#file_path_dialog").dialog("open"); } }
	    				      ]
	    				    });
	    				  });
	    			}
	    		});
			}
			);

			$('#scissor2').click(function(){
				$('#scissor2').animate({
			          width: '40px',
					  height : '40px'
			        }, 100 ); 
				
				$('#copypaste2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#plus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#minus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#pencil2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
			});
			
			
			$('#copypaste2').click(function(){
				$('#copypaste2').animate({
			          width: '40px',
					  height : '40px'
			        }, 100 ); 
				
				$('#scissor2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#plus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#minus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#pencil2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
			 });
			
			$('#plus2').click(function(){
				$('#plus2').animate({
			          width: '40px',
					  height : '40px'
			        }, 100 ); 
				$('#copypaste2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#scissor2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#minus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#pencil2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
			 });
			
			$('#minus2').click(function(){
				$('#minus2').animate({
			          width: '40px',
					  height : '40px'
			        }, 100 ); 
				$('#copypaste2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#scissor2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#pencil2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#plus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
			 });
			
			$('#pencil2').click(function(){
				$('#pencil2').animate({
			          width: '40px',
					  height : '40px'
			        }, 100 ); 
				$('#copypaste2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#scissor2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#minus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
				$('#plus2').animate({
			          width: '20px',
					  height : '20px'
			        }, 100 ); 
			 });
		});
	function minimizeAll2()
	{
		$('#copypaste2').animate({
	          width: '20px',
			  height : '20px'
	        }, 100 ); 
		$('#scissor2').animate({
	          width: '20px',
			  height : '20px'
	        }, 100 ); 
		$('#minus2').animate({
	          width: '20px',
			  height : '20px'
	        }, 100 ); 
		$('#plus2').animate({
	          width: '20px',
			  height : '20px'
	        }, 100 ); 
		$('#pencil2').animate({
	          width: '20px',
			  height : '20px'
	        }, 100 ); 
	}
	
	
	
	
	</script>
<div id='plusFolder2'>
	<span style="position: absolute; left:-15px; top: -48px;">
		<img src="/Soloud/image/main/shareTree1.png"  alt="공유트리" align="middle" width="150px"/>
		<img src="/Soloud/image/main/plus.png"  align="middle" id='plus2' class = "shared_folder_create_button" style='cursor: pointer;width:20px; height:20px;'/>
		<img src="/Soloud/image/main/minus.png"  align="middle" id='minus2' class = "shared_folder_delete_button" style='cursor: pointer;width:20px; height:20px;'/>
		<img src="/Soloud/image/main/pencil.png"  align="middle" id='pencil2' class = "shared_folder_modify_button" style='cursor: pointer; width:20px; height:20px;'/>  
	
		<img src="/Soloud/image/main/scissor.png"  align="middle" id='scissor2' class='shared_folder_move_button' style='cursor: pointer; width:20px; height:20px;'/>  
		<img src="/Soloud/image/main/copypaste.png"  align="middle" id='copypaste2'  class='shared_folder_copypaste_button' style='cursor: pointer; width:20px; height:20px;'/>  
		<img class='icon' src="/Soloud/image/sharedFriend/friend.png" align="middle" id="sharedInvite" style="cursor: pointer; width:20px; height:20px;"/>
		<img class='icon' src="/Soloud/image/sharedFriend/speech.png" align="middle" id="reply" style="cursor: pointer; width:20px; height:20px;"/>
	</span>    
</div>



</body>
</html>
