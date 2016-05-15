<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
<style>
	body{
	font-family: 'Nanum Gothic', sans-serif;
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
		.name{
			border-bottom-style:none;
			border-left-style:none;
			border-right-style:none;	
			border-color: #E6E6E6;	
			height: 40px;
		}
		
		/* 파일목록 - 유형, 용량 */
		.type{
			border-bottom-style:none;
			border-right-style:none;	
			border-color: #E6E6E6;
			height: 40px;
		}
		
		/* 파일목록 - 시간 */
		.time{
			border-bottom-style:none;
			border-right-style:none;	
			border-color: #E6E6E6;
			height: 40px;	
		}
</style>
<script src="/Soloud/script/jquery.js"></script>
<script src="/Soloud/script/context/jquery.contextmenu.js"></script>
<link href='/Soloud/css/jquery.contextmenu.css' type='text/css' rel='stylesheet' />
<script>
var menuTemp;
	$(document).ready(function(){
		$(".fileList").hover(    
				function(){
					$(this).css("background", "pink"); menuTemp = this.rowIndex-1;}, 
				function(){
					$(this).css("background", "none");
				}
			);
		$(function() {
		    $('.fileList').contextPopup({
		      items: [
		        {label:'다운로드',    action:function() { location.href='/Soloud/fileDownloadAjax.go?index='+menuTemp+''; } },
		      ]
		    });
		  });
	});
</script>
</head>
<body>
<br>
	<div><p style="text-align:center; font-size:25px">솔라우드 폴더 URL 공유</p></div>
	<div align="center">
		<table width="821" border="1" id='fileTable'>
			<tbody>
				<tr>
					<th width="276" style="border-style: none; height: 40px;"
						 scope="col">&nbsp;이름</th>
					<th width="87"
						style="border-top-style: none; border-right-style: none; border-bottom-style: none; height: 40px;
						 scope=col;">&nbsp;유형</th>
					<th width="156"
						style="border-top-style: none; border-right-style: none; border-bottom-style: none; height: 40px;
						 scope=col">&nbsp;용량</th>
					<th width="276"
						style="border-top-style: none; border-right-style: none; border-bottom-style: none; height: 40px;
						 scope=col">&nbsp;마지막 수정 날짜</th>
				</tr>
				
			 	<c:forEach var="temp" items="${requestScope.list}">
					<tr class="fileList">
						<td class="name">&nbsp;${temp[0] }</td>
						<td class="type">&nbsp;${temp[1] }</td>
						<td class="type">&nbsp;${temp[2] }</td>
						<td class="time">&nbsp;${temp[3] }</td>
					</tr>
				</c:forEach>
 		</table>
	</div>
</body>
</html>