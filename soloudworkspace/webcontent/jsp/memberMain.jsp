<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soloud</title>
<!-- JQuery -->
	<script src="/Soloud/script/jquery.js"></script>
	<script src='/Soloud/script/sharedFolder.js/sharedFolderDialog.js'></script>
	<script>
		$(function(){
			$("#upload").hover(function(){
				document.getElementById("upload").src = "/Soloud/image/main/upload_hover.png";
			});
			$("#upload").mouseout(function(){
				document.getElementById("upload").src = "/Soloud/image/main/upload.png";
			});
			
			$("#download").hover(function(){
				document.getElementById("download").src = "/Soloud/image/main/download_hover.png";
			});
			$("#download").mouseout(function(){
				document.getElementById("download").src = "/Soloud/image/main/download.png";
			});
			
			$("#search").hover(function(){
				document.getElementById("search").src = "/Soloud/image/main/search_hover.png";
			});
			$("#search").mouseout(function(){
				document.getElementById("search").src = "/Soloud/image/main/search.png";
			});
			
			$("#friend").mouseover(function(){
				document.getElementById("friend").src = "/Soloud/image/main/friend_hover.png";
			});
			$("#friend").mouseout(function(){
				document.getElementById("friend").src = "/Soloud/image/main/friend.png";
			});
			
			$("#play").mouseover(function(){
				document.getElementById("play").src = "/Soloud/image/main/play_hover.png";
			});
			$("#play").mouseout(function(){
				document.getElementById("play").src = "/Soloud/image/main/play.png";
			});
		});	
	</script>
<!-- 다이얼로그 -->
	<link rel="stylesheet" href="/Soloud/css/jquery-ui.css">
	<script src="/Soloud/script/jquery-ui.js"></script>
	
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
	
	
	<link href="/Soloud/css/sharedFolder/sharedFriendInvite.css" type='text/css' rel='stylesheet'/>
<!-- 메인페이지 css -->
	<style>
	
		/* 페이지 css*/
		body{
			margin:0px auto;
			background-image: url(/Soloud/image/titleBar/mark3.png);
			background-repeat: repeat;
			font-family: 'Nanum Gothic', sans-serif;
		}
		
		/* 메인메뉴 css */	
		#menu{
			margin: 0px auto;
			left: 491px;
			top: 98px;
		}
		
		/* 상단바 css*/
		#top{
			margin-top: 10px;
		}
	</style>
	
<!-- 다이얼로그 css -->	
	<style>
		body { font-size: 62.5%;  }
		label, input { display:block; }
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#users-contain { width: 350px; margin: 20px 0; }
		div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
	</style>
<!-- 다이얼로그 script -->
<style type="text/css">
div#viewLoading {text-align:center;padding-top:120px;filter:alpha(opacity=60);opacity: alpha*0.6;background-color:#222222;color:#bcbfc4;}
div#viewLoading div.progressTitle{text-align:left;border:2px solid #111111;border-bottom:1px solid #111111;padding:15px 0 15px 0;width:99.2%;}
div#viewLoading div.progressTitle span{padding-left:3px;padding-bottom:5px;}
div#viewLoading div.progressWrapper{border:1px solid #111111;width:99.2%;text-align:center;}
div#viewLoading div.progressWrapper div.progresspercent{background-color:#1a1a1a;height:40px;border:1px solid #000000;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper{line-height:38px;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper span.pgbar{display:block;float:left;background-color:#fecf23;width:90%;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper span.pgpercent{position:absolute;left:30%;right:30%;color:#c0c0c0;}
div#viewLoading div.progressWrapper div.progresspercent span.percentwrapper span.pgpercent strong{font-weight:bold;}
div#viewLoading div.progressfilereadsize{margin:0 0 5px 0;height:40px;border:1px solid #111111;}
div#viewLoading div.progressfilereadsize span{line-height:40px;}
div#viewLoading div.progressfilereadsize span.divider strong{font-weight:400;}
div#viewLoading div.progressSpeed{margin:0 0 5px 0;height:40px;border:1px solid #111111;text-align:center;}
div#viewLoading div.progressSpeed span.kbps{line-height:40px;}
div#viewLoading div.progressSpeed span.kbps strong{font-weight:400;}
.pgbarbgcolor{background-color:#fecf23;}
</style><!-- 
<script type="text/javascript">
		$(function(){
			
			
		});
</script> -->
  <script>
	var intervalID = 0;
	//파일업로드 상태를 주기적으로 확인해서 가져온다.
	var getFileUploadProgress = function(){
		$.ajax({
			url : 'uploadStatus.go',
			success : function(jsonData){

				$("#viewLoading").html(										
						"<div class='progressTitle'>" +
						"	<span><strong>업로드 진행상태</strong></span>" +		
						"</div>" +
						"<div class='progressWrapper'>" +
						"	<div class='progresspercent'>" +
						"		<span class='percentwrapper'>"+
						"			<span class='pgbar'>&nbsp;</span>"+
						"			<span class='pgpercent'><strong id='perData'>"+ jsonData.percent+"%</strong></span>" +				
						"		</span>" +
						"	</div>"+
						"	<div class='progressfilereadsize'>"+
						"		<span class='readsize'>" + jsonData.bytesread + "<strong> KB</strong></span>" +
						"		<span class='divider'><strong>/</strong></span>" +
						"		<span class='filelength'>" + jsonData.contentlength + "<strong> KB</strong></span>" +
						"	</div>" +
						"	<div class='progressSpeed'>" +
						"		<span class='kbps'>" + jsonData.kbps + "<strong> KB/s</strong></span>" +
						"	</div>" +								
						"</div>"	);										
				$("#viewLoading").find("div.progresspercent span.pgbar").width(jsonData.percent+"%").addClass("pgbarbgcolor");				
			}
		});
	};
  
			$(function() {

				var dialog;

				dialog = $("#dialog-form").dialog({
					autoOpen : false,
					height : 570,
					width : 500,
					modal : true,
					buttons : {
						"전송" : function() {
							$("#upload-form").ajaxSubmit({
								/* beforeSubmit : function(){
										// 로딩이미지의 위치 및 크기조절	
										$("#viewLoading").css('position', 'absolute');
										$("#viewLoading").css('left', $("body").offset().left);
										$("#viewLoading").css('top', $("body").offset().top);
										$("#viewLoading").css('width', "500px");
										$("#viewLoading").css('height', "200px");
												
										intervalID = setInterval(function(){			
											getFileUploadProgress();	//ajax요청중에 파일업로드 상태를 주기적으로 요청한다.	
										},50);
										$("#viewLoading").fadeIn(100);
								}, */
								success : function(data) {
									//$("#perData").html("100%");		
									alert("전송 완료 되었습니다.");		
									//clearInterval(intervalID); //Stop updating	
									//$("#viewLoading").fadeOut(100);
									//$("#perData").html("");
								},error : function(){
									alert("전송 실패 했습니다.");
									//clearInterval(intervalID); //Stop updating		
									//$("#viewLoading").fadeOut(250);
									//$("#perData").html("");
								}
							});
							$(this).dialog("close");
						},
						"취소" : function() {
							$(this).dialog("close");
						}
					},
					close : function() {
					},
				});

				////////////////1. 업로드 버튼  ////////////////
				$("#upload").button().on(
						"click",
						function() {
							if (selectedFolder == '폴더를 선택해주세요'
									&& selectedFolder2 == '폴더를 선택해주세요') {
								alert('폴더를 선택해주세요');
							} else {
								dialog.dialog("open");
							}
						});

				/* $("#upload_submit").click(function(){
					$("#upload-form").ajaxSubmit({
						url : 'fileUploadAjax.go',
						type : 'POST',
						data : $("#upload-form").formSerialize();
						success : function(data){
							alert("전송 완료 되었습니다.");						
						},error : function(){
							alert("전송 실패 했습니다.");
						}
					});	
				}); */
			});
		</script>
 <!-- 마우스 클릭 이벤트 script-->
	<script>
		var list_data = [];  // 선택된 파일의 정보를 집어넣음... ( 상세보기 데이터는 항상 마지막 인덱스의 데이터 )
		var menuTemp;
		var menuTemp2;
		var searchTemp;
		function mdown()
		{
    		var objs = list_data;
    		var Body = document.getElementsByTagName('BODY')[0];
    		var j=0;

    		for (var i=0; i < objs.length; i++) {
	    		if (mdown.fList[j] == undefined) {
		    		mdown.fList[j] = document.createElement("IFRAME");
		    		mdown.fList[j].style.display = 'none';

		    		Body.appendChild(mdown.fList[j]);
	    		}
	    		mdown.fList[j].src = mdown.GetURL(parseInt(list_data[i],10)-1);
	    		j++;
    		}
		}
		mdown.fList = [];
		mdown.GetURL = function(val) {
			return 'fileDownloadAjax.go?index='+val+'';
		};
		window.onload = function() {
			
			$("#search_scope").change(function(){
				if(this.selectedIndex==0){
					var options = "";
					options += "<option value='fileName'>파일명</option>";
					$("#search_name").html(options);
				}
				else if(this.selectedIndex==1){
					var options = "";
					options += "<option value='fileName'>파일명</option>";
					options += "<option value='uploaderName'>업로더 이름</option>";
					options += "<option value='uploaderEmail'>업로더 이메일</option>";
					$("#search_name").html(options);
				}
			});
			document.getElementById("file_search").style.display = "none" // 검색메뉴 비활성화
			document.getElementById("file_info").style.display = "none" // 상세보기 비활성화
			document.getElementById("search_text").onkeydown = function(e){
				if(e.keyCode == 13){
					$.ajax({
		    			url:"file_search", type:"POST", dataType:"json", data:{search_scope : $("#search_scope").val(), search_name : $("#search_name").val(), search_type : $("#search_type").val(), search_text : $("#search_text").val()}, timeout:5000,
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
			};

		};
		function active_click(){
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
		}

		$(document).ready(function(){
			  //ajax Progress image view Elem
			$("#viewLoading").hide();	//초기로딩시에는 이미지를 숨긴다.
			////////////////  파일목록 호버 색깔  ////////////////
			$(".list_table").hover(    
				function(){
					$(this).css("background", "pink"); 
					menuTemp = this.rowIndex-1; }, function(){
						$(this).css("background", "none");
				}
			);
			////////////////  파일목록 파일 선택  ////////////////
			$(".list_table").on("click", 
				function(){ 
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
				}
			);	
			
			////////////////검색 요청 ////////////////
			$("#search_button").button().on("click", function(){
				$.ajax({
	    			url:"file_search", type:"POST", dataType:"json", data:{search_scope : $("#search_scope").val(), search_name : $("#search_name").val(), search_type : $("#search_type").val(), search_text : $("#search_text").val()}, timeout:5000,
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
			})			
			
			////////////////  검색메뉴 활성화  ////////////////
			$( "#search" ).button().on( "click", function() {  
				if(document.getElementById("file_search").style.display=="none"){
					document.getElementById("file_search").style.display = "inline"
				}
				else{
					document.getElementById("file_search").style.display = "none"
				}
			});	  
			
			////////////////  2. 다운로드 버튼  ////////////////
		    $( "#download" ).button().on( "click", function() {
		    	if(list_data==0){
		    		alert("파일을 선택해주세요");
		    	}
		    	else{
		    		/* for(var i=0; i<list_data.length; i++){
    					(function closure(index){
			    			var tempNum = parseInt(list_data[index],10)-1;
				   			setTimeout(function(){location.href="fileDownloadAjax.go?index="+tempNum;}, 1000);
    					})(i)
		    		} */
		    		mdown();
	    			/* var tempNum = parseInt(list_data[index],10)-1;
		    		$(function downloadAll() {
			    		if(tempNum<list_data.length){
				    		location.href = "fileDownloadAjax.go?index="+tempNum;
				    		tempNum++;
				    		alert(tempNum);
				    		setTimeout(downloadAll(), 3000);
				    	}
				    	else{
				    	}
		    		}); */
			    	$(".이름").css("background", "none");
			    	$(".유형").css("background", "none");
			    	$(".시간").css("background", "none");
			    	list_data = [];
		    	}
			});
			
			////////////////  3. 친구관리 버튼  ////////////////
		    $( "#friend" ).button().on( "click", function() {
		    	document.getElementById("friendForm").submit();
			});

			////////////////  4. 플레이리스트 버튼  ////////////////
		    $( "#play" ).button().on( "click", function() {
			      dialog.dialog( "open" );
			});
		    
			////////////////  5. 선택해제 버튼  ////////////////		
		    $( "#bye" ).button().on( "click", function() {
				document.getElementById("file_info").style.display = "none";
			    $(".이름").css("background", "none");
			    $(".유형").css("background", "none");
			   	$(".시간").css("background", "none");
			    list_data = [];
			});
		}); 	
	</script>

<!-- 왼쪽화면 css -->
	<style>
		
		/* 현재 사용량 */
		#leftPro{
			color:#95B3D7;
			font-weight:bold;
			font-size:15px;
		}
		
		/* 용량 제한량 */
		#rightPro{
			color:#17375E;	
			font-weight:bold;
			font-size:15px;
		}
		
		/* 프로그레스 바 */
		#pro{
			width:300px;
			height:20px;
		}
	</style>
	
<!-- 중앙화면 css -->
	<style>
	
		/* 중앙 몸체 */
		#centerBody{
			margin-top: 40px;
		}
		
		/* 파일 목록 */
		#fileTable
		{
			margin:0 auto;
			border-style:hidden;
			border-spacing:0px;	
			border-color: #E6E6E6;
			text-align: left;
			font-size: 15px;
			color: #1F3E63;
			font-family: 'Nanum Gothic', sans-serif;
		}
		
		/* 파일목록 - 이름 */
		.이름{
			border-bottom-style:none;
			border-left-style:none;
			border-right-style:none;	
			border-color: #E6E6E6;	
			height: 40px;
		}
		
		/* 파일목록 - 유형 */
		.유형{
			border-bottom-style:none;
			border-right-style:none;	
			border-color: #E6E6E6;
			height: 40px;
		}
		
		/* 파일목록 - 시간 */
		.시간{
			border-bottom-style:none;
			border-right-style:none;	
			border-color: #E6E6E6;
			height: 40px;	
		}
	</style>
	
<!-- 오른쪽화면 css -->
	<style>
	
		/* 파일 상세정보 */
		#info_table{
			border:2px solid;
			border-spacing:0px;	
			border-color: #E6E6E6;
			text-align: left;
			font-size: 15px;
			color: #1F3E63;
			font-family: 'Nanum Gothic', sans-serif;
			padding:10px;
			padding-left:15px;
		}
	</style>
	
</head>

<body>
	<c:import url="folderCreateDialog.jsp"/>
	<c:import url="folderDeleteDialog.jsp"/>
	<c:import url='folderModifyDialog.jsp'/>
	<c:import url='folderMoveDialog.jsp'/>
	<c:import url="fileMenuDialog.jsp"/>
	<c:import url="titleBar.jsp"/>
	<c:import url="facebook.jsp"/>
	
	
	<!-- 화면 왼쪽부분 -->
	<div style="position: absolute; width: 368px; height: 686px; border: 2px; border-color: #999; border-style: solid; left: 57px; top: 161px;">
		
		<!-- 프로그레스 바 -->
		<div style="position: absolute; left: -12px; top: -71px;">
			<div style="position: absolute; left: 10px; top: 18px; width: 336px; height: 64px;">
				<div style="margin-bottom:2px; ">
					<div id="leftPro" style="display:inline;">
						${requestScope.usedCapacity }&nbsp/
					</div>
					<div id="rightPro" style="display:inline;">
						${requestScope.maxCapacity }
					</div>
				</div>
				<div style="float:left; margin-top:2px; ">
					<progress id="pro" value="${requestScope.usedC }" max="${requestScope.maxC }"></progress>
				</div>
				<div >
					&nbsp;&nbsp;&nbsp;<img src="/Soloud/image/main/plus.png" width="17" height="18" alt="더보기1" />
				</div>
			</div>
		</div>
		
		<!-- 트리구조 -->
		<div style="position: absolute; border: 2px; border-color: #999; border-bottom-style: solid; width: 368px; height: 333px;">    
			<div id="내트리" style="position: absolute; width: 330px; height: 266px; left: 18px; top: 51px;">
				<c:import url="example.jsp"/>
			</div>
			</div> 
		</div>
		<div id="공유트리" style="position: absolute; width: 330px; height: 267px; left: 76px; top: 550px;">
		  	<c:import url="example2.jsp"/>
		</div>
	
	<!-- 화면 중앙부분 -->
	<div id="menu" align="center" style="position: absolute; width: 645px; height: 753px; z-index: 1; border-width: 2px; border-color: #E6E6E6; border-left-style: solid; border-right-style: solid"  >
		
		<!-- 메인 메뉴 -->
		<form method="get" action="loadFriendList.do" id="friendForm">
			<img id="upload" src="/Soloud/image/main/upload.png" width="100" height="54" alt="업로드" />
			<img id="download" src="/Soloud/image/main/download.png" width="99" height="54" alt="다운로드" />
			<img id="search" src="/Soloud/image/main/search.png" width="100" height="54" alt="검색" />
			<img id="friend" src="/Soloud/image/main/friend.png" width="100" height="54" alt="친구" />
			<img id="play" src="/Soloud/image/main/play.png" width="100" height="54" alt="플레이" />
		</form>
		<!-- 검색창 + 선택해제 버튼 + 파일목록 + 업로드 다이얼로그 -->
			<div id="centerBody">
			
				<!-- 검색창 -->
					<div id='file_search' >
						<select id="search_scope" style="font-family: 'Nanum Gothic', sans-serif;">
							<option>내 파일</option>
							<option>모든 파일</option>
						</select>
						<select id="search_name" style="font-family: 'Nanum Gothic', sans-serif;">
							<option value='fileName'>파일명</option>
						</select>
						
						<select id="search_type" style="font-family: 'Nanum Gothic', sans-serif;">
							<option value="allFile">파일전체</option>
							<option value="video">비디오</option>
							<option value="audio">오디오</option>
							<option value="image">이미지</option>
							<option value="document">문서</option>
							<option value="etc">기타</option>
						</select>
						
						<input type="text" id="search_text" style="display:inline; font-family: 'Nanum Gothic', sans-serif;" placeholder="검색 내용"/>
						<input type="button" id="search_button" style="display:inline; font-family: 'Nanum Gothic', sans-serif;" value='검색'/>
						<br><br><br>
					</div>
				<!-- 페이스북 링크 버튼 -->
				
				<!-- 선택해제 버튼 -->
					<div align="right" style="margin-bottom:10px;">
						<img id="bye" src="/Soloud/image/main/nonselect.png"  width="71" height="26"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				
				<!-- 파일 목록 -->
				
				<table width="511" border="1" id='fileTable'>
					<tbody>
					<tr>
						<th width="156" style="border-style:none; height: 40px; "; scope="col">&nbsp;이름</th>
						<th width="87" style="border-top-style:none; border-right-style:none; border-bottom-style:none; height: 40px;"; scope="col">&nbsp;유형</th>
						<th width="246" style="border-top-style:none; border-right-style:none; border-bottom-style:none; height: 40px;"; scope="col">&nbsp;마지막 수정날짜</th>
					</tr>
				</table>
				<script src="/Soloud/script/context/jquery.contextmenu.js"></script>
				<style>
					.contextMenuPlugin {
					  -webkit-user-select: none;
					  display: none;
					  font-family: tahoma, arial, sans-serif;
					  font-size: 11px;
					  position: absolute;
					  left: 100px;
					  top: 100px;
					  min-width: 100px;
					  list-style-type: none;
					  margin: 0;
					  padding: 0;
					  background-color: #f7f3f7;
					  border: 2px solid #f7f7f7;
					  outline: 1px solid #949694;
					}
					
					.contextMenuPlugin > li {
					  margin: 0 0 0 0;
					  padding: 1px;
					  background-repeat: no-repeat;
					}
					
					.contextMenuPlugin > li > a {
					  position: relative;
					  display: block;
					  padding: 3px 3px 3px 28px;
					  color: ButtonText;
					  text-decoration: none;
					  margin: 1px;
					}
					
					.contextMenuPlugin > li > a img {
					  position: absolute;
					  left: 3px;
					  margin-top: -2px;
					  width: 16px;
					  height: 16px;
					}
					.contextMenuPlugin > li > a:hover {
					  border: 1px solid #fffbff;
					  outline: 1px solid #b5d3ff;
					  margin: 0;
					  background: -moz-linear-gradient(top, rgba(239,239,255,0.5) 0%, rgba(223,223,255,0.5) 100%); /* FF3.6+ */
					  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(239,239,255,0.5)), color-stop(100%,rgba(223,223,255,0.5))); /* Chrome,Safari4+ */
					  background: -webkit-linear-gradient(top, rgba(239,239,255,0.5) 0%,rgba(223,223,255,0.5) 100%); /* Chrome10+,Safari5.1+ */
					  background: -o-linear-gradient(top, rgba(239,239,255,0.5) 0%,rgba(223,223,255,0.5) 100%); /* Opera11.10+ */
					  background: -ms-linear-gradient(top, rgba(239,239,255,0.5) 0%,rgba(223,223,255,0.5) 100%); /* IE10+ */
					  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#80efefff', endColorstr='#80dfdfff',GradientType=0 ); /* IE6-9 */
					  background: linear-gradient(top, rgba(239,239,255,0.5) 0%,rgba(223,223,255,0.5) 100%); /* W3C */
					  cursor: default;
					}
					
					.contextMenuPlugin > li.disabled {
					  pointer-events: none;
					}
					
					.contextMenuPlugin > li.disabled a {
					  color: grey;
					}
					
					.contextMenuPlugin > li.disabled > a:hover {
					  border: none;
					  outline: none;
					}
					
					.contextMenuPlugin > li.divider {
					  border-top: 1px solid #e7e3e7;
					  border-bottom: 1px solid #ffffff;
					  height: 0;
					  padding: 0;
					  margin: 5px 0 5px 27px;
					}
					
					.contextMenuPlugin > .header {
					  background: rgb(90,90,90); /* Old browsers */
					  background: -moz-linear-gradient(top, rgba(90,90,90,1) 0%, rgba(20,20,20,1) 100%); /* FF3.6+ */
					  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(90,90,90,1)), color-stop(100%,rgba(20,20,20,1))); /* Chrome,Safari4+ */
					  background: -webkit-linear-gradient(top, rgba(90,90,90,1) 0%,rgba(20,20,20,1) 100%); /* Chrome10+,Safari5.1+ */
					  background: -o-linear-gradient(top, rgba(90,90,90,1) 0%,rgba(20,20,20,1) 100%); /* Opera11.10+ */
					  background: -ms-linear-gradient(top, rgba(90,90,90,1) 0%,rgba(20,20,20,1) 100%); /* IE10+ */
					  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#5a5a5a', endColorstr='#141414',GradientType=0 ); /* IE6-9 */
					  background: linear-gradient(top, rgba(90,90,90,1) 0%,rgba(20,20,20,1) 100%); /* W3C */
					  position: relative;
					  cursor: default;
					  padding: 3px 3px 3px 3px;
					  color: #ffffff;
					}
					
					.contextMenuPlugin > .gutterLine {
					  position: absolute;
					  border-left: 1px solid #e7e3e7;
					  border-right: 1px solid #ffffff;
					  width: 0;
					  top: 0;
					  bottom: 0;
					  left: 26px;
					  z-index: 0;
					}
				</style>
				<script>				
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
				</script>
				<%-- <c:import url="progressBar.jsp"/> --%>
				<!-- 업로드 다이얼로그 -->
				
<div id="viewLoading">
</div>

				<script src="/Soloud/script/jquery.form.js"></script>
				<div id="dialog-form" title="업로드">
					 <form name="uploadForm" action="fileUploadAjax.go" id="upload-form" method="post"  enctype="multipart/form-data"><br>
						<span style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">업로드 할 파일</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" style="display:inline;" name="file1" multiple="true"><br><br>
						<span style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">권한 범위</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select name="scope" id='scope' style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">
								  <option value="나만보기">나만보기</option>
						          <option value="절친">절친</option>
						          <option value="친구">친구</option>
						          <option value="어색한친구">어색한친구</option>
						    </select><br><br>
						<span style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">파일 설명</span><br><textarea cols="60" rows="20" draggable="false" name="content" > </textarea><br></br>
						<span style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">태그</span> <input type="text" style="display:inline; width:355px"></input>
					</form>
				</div>
				
		</div>
	</div>
	
	<!-- 화면 오른쪽부분 -->
	<div style="position: absolute; left: 1150px; top: 233px; width: 335px; height: 378px; margin-left:40px;" id="file_info">
	
		<!-- 파일 상세 보기 -->
			<table id="info_table">
				<tr>
					<td style="height: 30px; width: 60px">파일명 :</td>
					<td colspan=3 id="info_name" style="height: 30px; width: 170px">후보군.docx</td>
				</tr>
				<tr>
					<td style="height: 30px; width: 60px">용량 :</td>
					<td id="info_capacity" style="height: 30px; width: 107px">200.37KB</td>
					<td style="height: 30px; width: 55px">유형 :</td>
					<td id="info_type" style="height: 30px; width: 67px">이미지</td>
				</tr>
				<tr>
					<td style="height: 30px; width: 60px">권한 :</td>
					<td id="info_access" style="height: 30px; width: 107px">어색한친구</td>
					<td style="height: 30px; width: 55px">업로더 :</td>
					<td id="info_uploader" style="height: 30px; width: 67px">정영진</td>
				</tr>
				<tr>
					<td style="height: 30px; width: 60px">코멘트 :</td>
					<td colspan=3 style="height: 30px; width: 107px">&nbsp;</td>
				</tr>
				<tr>
					<td id="info_comment" colspan="4" style="width: 325px">업로드 파일입니다.</td>
				</tr>
			</table>
	</div>
	
	<div style="margin:0 auto">	
	<!--  -->
	<div title="공유폴더 댓글방" id='replyDialog' style="display:none;">
		<table id='replyTableDummy'>
			<tr>
				<td colspan='3' style='text-align:center; height:42px;width:302px; font-size: 14px; font-family: Nanum Gothic, sans-serif;'>
					<img style="height:100%;width:45%;padding-top:0px"src="/Soloud/image/Reply/titleBar.png">
				</td>
			</tr> 
		</table>
		<table id='replyTable'>
			<tr></tr>
		</table>
	</div>
	<!--  -->
	<div title='친구초대' id='inviteList' style="display:none">
		<table id='unInvitefriendList'>
			<tr>
				<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">친구이름</td>
				<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">아이디</td>
				<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">요청</td>
			</tr>
		</table>
	</div>
	<div title="댓글달기" style="display:none" id='addReply'>
		<table>
			<tr>
				<td id='writerName' style="width:50px;font-family: 'Nanum Gothic', sans-serif; ">작성자</td>
				<td><input id='id' type='text' disabled="disabled"/></td>
			</tr>
			<tr>
				<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;">내용</td>
				<td><input style="width:150px"type='text' id='content'/></td>
			</tr>
		</table>
	</div>
</body>
</html>