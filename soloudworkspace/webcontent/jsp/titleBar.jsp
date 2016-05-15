<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">@import url(/Soloud/css/titleBar.css);</style>
<style type="text/css">
		@import url(/Soloud/css/nanum.css);</style><!-- 폰트(나눔고딕) -->
	<script src="/Soloud/script/jquery.js"></script>
<script type="text/javascript" src="/Soloud/script/titleBar.js"></script>
</head>
<body>
	<header>
		<c:import url="friendRecommend.jsp" />
		<c:import url="alramList.jsp" />
		<c:import url="loginSetting.jsp" />
		<form method="post" action="loginComplete.do" id="form">
			<div id="top">
				<img src="/Soloud/image/titleBar/newTitleBar.png" alt="마크" width="426" height="45" align="left" id="refresh" style="cursor: pointer;"/>
				<div align="right">
					<div align="right">
						<div id="profile2"></div>
						<img src="/Soloud/image/titleBar/profile2.png" alt="프로필2" width="164" height="39" align="right" style="cursor: pointer;"/>
					</div>
					<div id="profile">
						<img align="right" src="/Soloud/image/icon/people29.png" width="33"  height="38" alt="프로필"  style="cursor: pointer;"/>
					</div>
					<div id="alram">
						<c:choose>
							<c:when test="${sessionScope.alarmFlag == true}"><!-- 알람새로운거 뜨게함 -->
								<img align="right" src="/Soloud/image/titleBar/talkbaloon5.png" id='alarmIcon' width="73" height="50" alt="알림" style="cursor: pointer;"/>
							</c:when>
							<c:otherwise>
								<img align="right" src="/Soloud/image/titleBar/talkbaloon4.png" id='alarmIcon' width="73" height="50" alt="알림" style="cursor: pointer;"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div id="friend_Recommend">
					<c:choose>
						<c:when test="${sessionScope.friendFlag == true}"><!-- 알람새로운거 뜨게함 -->
							<img align="right" src="/Soloud/image/titleBar/friendalarm2.png" id='friendAlarmIcon'  width="60" height="44" alt="친구" style="cursor: pointer;"/>
						</c:when>
						<c:otherwise>
							<img align="right" src="/Soloud/image/titleBar/friendalarm.png" id='friendAlarmIcon' width="60" 	height="44" alt="친구" style="cursor: pointer;"/>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form>
	</header>
</body>
</html>
