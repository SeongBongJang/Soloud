package com.soloud.app.manInt;

import java.util.ArrayList;

public interface AlarmMessageAlarmable {
	/**
	 * �������� �ʴ� �˶� ���� 
	 * @param sender ������� �ڵ�
	 * @param receiverId �޴»�� �ڵ�
	 * @param alarmKindName �˶������̸�
	 * @return
	 */
	public boolean alarmSharedFolderInvite(String senderId,String receiverId, String alarmKindName);
	/**
	 * ģ����û �˶�  ����
	 * @param alarmMessageName �˶��̸�
	 * @param receiverId �޴»�� �ڵ�
	 * @param senderId ������ ��� �ڵ�
	 * @return
	 */
	public boolean alarmFriendRequest(String alarmMessageName,String receiverId,String senderId);
	/**
	 * ģ����û ���� �˶� ����
	 * @param senderId ��������ڵ�
	 * @param receiverId �޴»���ڵ�
	 * @param alarmKindName �˶������ڵ�
	 * @param alarmCode �˶��ڵ�
	 * @return
	 */
	public boolean alarmFriendAccept(String senderId,String receiverId,String alarmKindName);
	/**
	 * �±׾˶� ����
	 * @param senderId ������� �ڵ�
	 * @param receiverId �޴»�� �ڵ�
	 * @param alarmKindName �˶������ڵ�
	 * @return
	 */
	public boolean alarmTag(String senderId,ArrayList<String> receiverId,String alarmKindName);
}
