<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계정 탈퇴</title>
<style type="text/css">@import url(/Soloud/css/dropOut.css);</style>
<script type="text/javascript" src="/Soloud/script/dropOut.js"></script>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
</head>


<body>
<c:import url="titleBar.jsp"/>
<br><br><br><br><br>
<div class="message">
<h1 class="warning">회원 탈퇴시 업로드된 파일은 복구 할 수 없습니다.</h1>
<h1 class="warning">정말로 탈퇴하시겠습니까?</h1>

<table class="button_table">
	<tr>
		<td><a href='/Soloud/dropOutGo.do'><img src="/Soloud/image/drop/drop.jpg" class="button" id="drop_button"></a></td>
		<td><img src="/Soloud/image/drop/line.jpg" class="line"></td>
		<td><a href="memberMain.jsp"><img src="/Soloud/image/drop/cancel2.jpg" class="button" id="cancel_button"></a></td>
	</tr>
</table>

</div>
</body>
</html>