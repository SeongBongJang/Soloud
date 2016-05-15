<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<script src="/Soloud/script/jquery.js"></script>
<script src='/Soloud/script/memberListSearchTable2.js'
	type='text/javascript'></script>
</head>
<style>
a {
	font-size: 17px;
	text-decoration: none;
	color: gray;
}

a:HOVER {
	color: red;
}

.name_field {
	width: 100px;
	height: 20px;
	margin: auto;
	font-size: 13px;
}

p {
	display: inline;
	font-size: 15px;
	color: gray;
}
</style>
<style>
body {
	font-family: 'Nanum Gothic', sans-serif;
	margin: 0px auto;
}

#search_list_table {
	margin: auto;
	width: 800px;
	padding-left: 30px;
	padding-right: 30px;
	border-width: 2px;
	border-color: #E6E6E6;
	border-left-style: solid;
	border-right-style: solid;
}

table.title_list_table {
	font-family: 'Nanum Gothic', sans-serif;
	margin: auto;
	width: 800px;
	text-align: center;
	padding-left: 30px;
	padding-right: 30px;
	border-width: 2px;
	border-color: #E6E6E6;
	border-left-style: solid;
	border-right-style: solid;
}

table tr td.my_proposal_info {
	text-align: left;
	color: gray;
}
img{cursor: pointer;}
</style>
<body>
	<c:import url="titleBar.jsp" />
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<table class="title_list_table">
		<tr>
			<td></td>
			<td><img src="/Soloud/image/icon/people23.png" /></td>
			<td></td>
			<td>

				<h1>${member.name}</h1> <!-- 여기에 이름을 넣는다. --> <br>
				<h2>
					<strong>${member.id }</strong>
					<!-- 여기에 아이디를 넣는다. -->
				</h2>
			</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"><a href="loadFriendList.do">내 친구 </a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendReceive.do">받은 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendSend.do">보낸 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="searchMemberPage.do"  style="color: orange;"><span>친구 찾기</span></a>&nbsp;
				<p>|</p>&nbsp;</td>
			<td><input type="text" name="name" class="name_field" id="member_search_field" placeholder="아이디 or 이름" />&nbsp;&nbsp;&nbsp;
				<img src="/Soloud/image/friends/search2.png" height="30px" width="60px" align="top" class="friend_search_button4" /></td>
		</tr>
	</table>
	<table id="search_list_table">
		<tr>
			<td style="width: 210px"></td>
			<td></td>
			<td  style ="text-align: center;"></td>
		</tr>
	</table>
</body>
</html>