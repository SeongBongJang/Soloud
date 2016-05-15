package com.soloud.app.manInt;

import java.util.ArrayList;

public interface AlarmMessageAlarmable {
	/**
	 * 공유폴더 초대 알람 생성 
	 * @param sender 보낸사람 코드
	 * @param receiverId 받는사람 코드
	 * @param alarmKindName 알람유형이름
	 * @return
	 */
	public boolean alarmSharedFolderInvite(String senderId,String receiverId, String alarmKindName);
	/**
	 * 친구신청 알람  생성
	 * @param alarmMessageName 알람이름
	 * @param receiverId 받는사람 코드
	 * @param senderId 보내는 사람 코드
	 * @return
	 */
	public boolean alarmFriendRequest(String alarmMessageName,String receiverId,String senderId);
	/**
	 * 친구신청 수락 알람 생성
	 * @param senderId 보낸사람코드
	 * @param receiverId 받는사람코드
	 * @param alarmKindName 알람유형코드
	 * @param alarmCode 알람코드
	 * @return
	 */
	public boolean alarmFriendAccept(String senderId,String receiverId,String alarmKindName);
	/**
	 * 태그알람 생성
	 * @param senderId 보낸사람 코드
	 * @param receiverId 받는사람 코드
	 * @param alarmKindName 알람유형코드
	 * @return
	 */
	public boolean alarmTag(String senderId,ArrayList<String> receiverId,String alarmKindName);
}
