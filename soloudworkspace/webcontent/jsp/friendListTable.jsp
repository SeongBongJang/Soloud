<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/Soloud/script/jquery.js"></script>
<script src='/Soloud/script/friendListTable.js' type='text/javascript'></script>

</head>
<!-- 폰트(나눔고딕) -->	
<style type="text/css">@import url(/Soloud/css/nanum.css);</style>  
<style>
.sub_table {
	height: 100px;
}

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

table.title_table {
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

table.friends_table {
	margin: auto;
	width: 800px;
	padding-left: 30px;
	padding-right: 30px;
	border-width: 2px;
	border-color: #E6E6E6;
	border-left-style: solid;
	border-right-style: solid;
}

table tr td.friend_list_info {
	text-align: left;
	color: gray;
}

#group_modify_dialog{
	display: none;
}
table.group_modify_table{
	margin: auto;
}
#name_field{
	cursor: text;
}
img{cursor: pointer;}
#delete_check_dialog{
	display: none;
}
</style>

<body>

	<c:import url="titleBar.jsp" />
	<br><br><br><br><br><br><br><br><br><br><br><br><br>

	<table class="title_table" id="title_table">
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
			<td colspan="3"><a href="loadFriendList.do"  style="color: orange;"><span>내 친구</span> </a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendReceive.do">받은 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="loadFriendSend.do">보낸 제안</a>&nbsp;
				<p>|</p>&nbsp; <a href="searchMemberPage.do">친구 찾기</a>&nbsp;
				<p>|</p>&nbsp;</td>
			<td><input type="text" name="name" class="name_field"
				id="name_field" placeholder="아이디 or 이름" value="" />&nbsp;&nbsp;&nbsp;
				<img src="/Soloud/image/friends/search2.png" height="30px"
				width="60px" align="top" class="friend_search_button" />
			</td>
		</tr>
	</table>
	<table class="friends_table" id="friends_table">
		<tr></tr>
		<c:forEach var="friend" items="${friendList}">
			<tr class="list_tr" id="${friend.friendId}">
				<td style="width: 210px"><img src="/Soloud/image/icon/people21.png" width="80px" /></td>
				<td class="friend_list_info" style="width: 245px">
					${friend.friendName}&nbsp;&nbsp;<br>(${friend.friendId})</td>
				<td style ="text-align: center;"><img src="/Soloud/image/friends/cut_button2.png" height="30px" width="100px" id="${friend.friendId}" class="friend_cut_button">
					<img src="/Soloud/image/friends/modify_group2.png" height="30"
					width="100" id="${friend.friendId}" class="modify_group_button">
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- ----------------------------------dialog----------------------------------------------------------------- -->
	<div id="group_modify_dialog" title ="그룹변경" >
		<fieldset>
				<table class="group_modify_table">
					<tr>
						<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;" >변경 할 권한 설정 :</td>
						<td><select class="group_step" tabindex="-1" name="group_list" id="group_list" style="font-size: 14px">
								<option value="BESTFRIEND">절친</option>
								<option value="NORMALFRIEND">친구</option>
								<option value="AWKWARDFRIEND">어색한친구</option>
						</select></td>
					</tr>
				</table>
		</fieldset>
	</div>
	<!--  -->
	<!-- 거절 확인 다이얼로그 -->
	<div id="delete_check_dialog" title ="친구 삭제 확인" >
		<fieldset>
				<table class="delete_check_table">
					<tr>
						<td style="font-size: 14px; font-family: 'Nanum Gothic', sans-serif;" >정말로 친구를 삭제하시겠습니까?</td>
					</tr>
				</table>
		</fieldset>
	
	</div>
</body>

</html>