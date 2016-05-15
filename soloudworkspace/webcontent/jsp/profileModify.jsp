<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 편집</title>
<script src="/Soloud/script/jquery.js"></script>
<script type="text/javascript" src="/Soloud/script/profileModify2.js"></script>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  

</head>
<style>

.mofidy_menu{
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
	width: 150px;
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
font-size:12px;
color:gray;
text-decoration: none;
}
.profile_button{
	text-align:left;
	width:100px;
}
p{
	font-size: 12px;
}
</style>
<body>
<script type="text/javascript">


</script>
<c:import url="titleBar.jsp"></c:import>
 <br><br><br><br><br><br><br><br><br><br><br>
 <div class="mofidy_menu">
 <h3>프로필 편집</h3>
 <hr>
 
 
 <form method="post" id='profileModifyForm'>
 <table>

 		<tr class="infomation">
 			<td><h4>이름</h4></td>
 			<td>성</td>
 			<td><input type="text" class="textarea" id="last_name" placeholder="홍" /></td>
 			<td>&nbsp;&nbsp;이름</td>
 			<td><input type="text" class="textarea" id="first_name" placeholder="길동" /></td>
 		</tr>
 		<tr class="warrning">
 			<td></td>
 			<td colspan='4'><p>솔라우드에서 바른 내 이름을 사용하세요.<br>이름 변경은 횟수/글자 제한이 있으며, 이름 외 광고/홍보성 및 부적합한<br> 콘텐츠는 타인에게 불쾌감을 줄 수 있으므로 사용 할 수 없습니다.</p></td>
 		</tr>
 		<tr>
 			<td></td>
 			<td colspan='4'><a href="#">자세히 알아보기</a></td>
 		</tr>
</table>
 <hr>
<table>
	<tr>
		<td><h4>비밀번호</h4></td>
		<td><input type="password" class="textarea" id="password"/></td>
		<td></td><td></td>
	</tr>
	<tr>
		<td><h4>비밀번호 확인</h4></td>
		<td><input type="password" class="textarea" id="password_validate"/></td>
		<td></td><td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td><a href="/Soloud/loadProfile.do"><img src="/Soloud/image/profileModify/cancel2.jpg" class="profile_button" id="cancel_button"></a></td>
		<td><img src="/Soloud/image/profileModify/save2.jpg" class="profile_button" id="save_button"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>