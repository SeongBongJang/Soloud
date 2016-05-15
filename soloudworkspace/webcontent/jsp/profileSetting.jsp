<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/Soloud/script/jquery.js"></script>
<script type="text/javascript" src="/Soloud/script/profileSetting.js"></script>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  

</head>
<style>

.setting_menu{
	width:600px;
	display:block;
	margin:auto;
	border-width:2px;
	border-color: #E6E6E6;
	border-left-style: solid; 
	border-right-style: solid;
	background-color: white;
}

hr{
	color:#E6E6E6;
	margin-left: 20px;
	margin-right: 20px;
}
.profileSetting_button{
	width: 100px;
}
.logout_button{
	width: 100px;
}
h3{
	text-align: left;
	margin-left: 30px;
	width: 100px;
}
h4{
	text-align:left;
	margin-left: 30px;
	width: 110px;
}
.name_length{
	width: 300px;
}

.drop_out{
	text-align:left;
	margin-left: 30px;
	width: 200px;
}
a{
color:gray;
text-decoration: none;
}
</style>
<body>
<c:import url="titleBar.jsp"></c:import>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="setting_menu">
		<h3>계정설정</h3>
		<hr>
		<table>
			<tr class="infomation">
				<td><h4>내 프로필</h4></td>
				<td class="name_length">${requestScope.name }</td>
				<td><a href="/Soloud/jsp/profileModify.jsp"><img src="/Soloud/image/profileSetting/profileModify_button2.png"	class="profileSetting_button" id="profileSetting_button" /></a></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr class="soloud">
				<td><h4>솔라우드 계정</h4></td>
				<td class="name_length">${requestScope.email }</td>
				<td><a href="/Soloud/logout.do"><img	src="/Soloud/image/profileSetting/logout2.png"	class="logout_button" id="logout2_button" /></a></td>
			</tr>
		</table>
		<hr>
		<table>
			<tr class="soloud">
				<td><h4 class="drop_out">
						<a href="/Soloud/dropOut.do">솔라우드 계정 탈퇴하기</a>
					</h4></td>
			</tr>
		</table>

	</div>

</body>
</html>