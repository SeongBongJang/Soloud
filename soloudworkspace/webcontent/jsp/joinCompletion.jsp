<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입 완료</title>
<style type="text/css">@import url(/Soloud/css/joinCompletion.css);</style>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
<script>
	window.onload = function(){
		
		document.getElementById("checkButton").onmouseover = function()	{
			this.src="/Soloud/image/joinCompletion/checkButton.jpg";				
		};
		document.getElementById("checkButton").onmouseout = function()	{
			this.src="/Soloud/image/joinCompletion/checkButton2.jpg";	
		};
	};
</script>
</head>
<body>
<c:import url="joinTitleBar.jsp"/>
<table class="table_step">
			<tr>
				<td><img src="/Soloud/image/joinCompletion/infoinput.jpg" /></td>
				<td><img src="/Soloud/image/joinCompletion/joinEnd_.jpg"/></td>
			</tr>
	</table>
<br><br>	
	<div class="section">	
		<h4>가입완료</h4>
		<hr>
		<img src="/Soloud/image/joinCompletion/logo_ver1.jpg" class="logo"/>
		<img src="/Soloud/image/joinCompletion/completion.jpg" class="logo"/>
		<img src="/Soloud/image/joinCompletion/completion2.jpg" class="logo"/>
		<fieldset>
		<table class="table_info">
			<tr>
				<td>솔라우드 계정 : ${id }</td>
			</tr>
			<tr>
				<td>(가입일: ${date })</td>
			</tr>
		</table>
		</fieldset>
		<br><br>
		<a href="/Soloud/join_bye"><img src="/Soloud/image/joinCompletion/checkButton2.jpg" class="button" id="checkButton"/></a>
	</div>
</body>
</html>