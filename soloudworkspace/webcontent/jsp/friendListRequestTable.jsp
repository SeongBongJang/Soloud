<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/Soloud/script/jquery.js"></script>
<script src='/Soloud/script/friendListRequestTable.js'
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

table.friend_request_table {
	margin: auto;
	width: 800px;
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

img {
	cursor: pointer;
}

</style>
<body>
	<c:import url="titleBar.jsp" />
	<br><br><br><br><br><br><br><br><br><br><br><br><br>
	<table class="title_table">
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
				<p>|</p>&nbsp; <a href="loadFriendSend.do"  style="color: orange;"><span>보낸 제안</span></a>&nbsp;
				<p>|</p>&nbsp; <a href="searchMemberPage.do">친구 찾기</a>&nbsp;
				<p>|</p>&nbsp;</td>
			<td><input type="text" name="name" class="name_field"
				id="request_search_field" placeholder="아이디 or 이름" />&nbsp;&nbsp;&nbsp;
				<img src="/Soloud/image/friends/search2.png" height="30px"
				width="60px" align="top" class="friend_search_button3" /></td>
		</tr>
	</table>
	<table class="friend_request_table" id="friend_request_table">
		<tr></tr>
		<c:forEach var="friendProposal" items="${friendProposalList}">
			<tr class="Requestlist_tr" id="${friendProposal.receiverId}">
				<td style="width: 215px"><img src="/Soloud/image/icon/people21.png" width="80px" /></td>
				<td class="my_proposal_info" style="width: 245px">
					<p class="friend_name">${friendProposal.receiverName}</p><br>(${friendProposal.receiverId})
				</td>
				<td style ="text-align: center;">
					<img src="/Soloud/image/friends/rquestCancel2.png" height="30px"
					width="100px" class="friend_requestCancel_button"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>