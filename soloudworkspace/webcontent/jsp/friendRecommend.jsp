<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>친구 제안 목록</title>
	<script src="/Soloud/script/jquery.js"></script>
<script src="/Soloud/script/jquery-ui.js"></script>
<style type="text/css">
@import url(/Soloud/css/friendRecommend.css);</style>
<script type="text/javascript" src="/Soloud/script/friendRecommend.js"></script>

<!-- 폰트(나눔고딕) -->	
	<style type="text/css">
		@import url(/Soloud/css/nanum.css);
	</style>  
	
<!-- 영진이가 필요하다고 한거 -->
<link rel="stylesheet" href="/Soloud/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<style>
table.recommend_table{
	height: 300px;
}
table tr{
	margin:0px;
	padding:0px;
	border-style:none;
	border-width:1px;
}
</style>
<body>
	<c:import url="friendAcceptDialog.jsp"/>
	<div id="friendRecommend_list"
		style="position: absolute; top: 70px; right: 100px; z-index:999;">
		<table class="friendRecommend_table" id="friendRecommend_table">
			<thead>
				<tr>
					<td colspan='3'>친구 신청 목록</td>
				</tr>
			</thead>
		</table>
	</div>

</body>
</html>
