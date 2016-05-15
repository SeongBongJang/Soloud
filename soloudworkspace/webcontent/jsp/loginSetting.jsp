<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/Soloud/script/loginSetting.js"></script>
<script type="text/javascript" src="/Soloud/script/profileSetting.jsp"></script>
</head>
<style type="text/css">@import url(/Soloud/css/loginSetting.css);</style>
<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  

<body>
<form method="post" action="">
<div id="setting_list" style ="position:absolute; top: 70px; right: 20px;">
<table class="setting_table">
	<thead>
	<tr>
		<td>로그인 셋팅</td>
	</tr>
	</thead>
	<tr class="line"><td></td></tr>
	<tr>
		<td><a href="/Soloud/loadProfile.do"><img src="/Soloud/image/loginSetting/setting1.png" class="button" id="setting_button"></a></td>
	</tr>
	<tr class="line"><td></td></tr>
	<tr>
		<td><a href="/Soloud/logout.do"><img src="/Soloud/image/loginSetting/logout1.png" class="button" id="logout_button"></a></td>
	</tr>
	<tr class="line"><td></td></tr>
</table>
</div>
</form>
</body>
</html>