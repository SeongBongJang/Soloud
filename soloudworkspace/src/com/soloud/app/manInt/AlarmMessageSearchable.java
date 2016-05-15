package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.AlarmMessage;

public interface AlarmMessageSearchable {
	/**
	 * �޴� ��� Id(receiverId��(���ް��� memberCode))�� �ش��ϴ� ��� �˶������� ������
	 * @param receiverId �޴»�� id(���� ���ް��� MemberCode)
	 * @return �˶� ����
	 */
	public ArrayList<AlarmMessage> searchAlarmReceiverId(String receiverId);
	
	/**
	 * �˶��޽��� �ڵ忡 �ش��ϴ� �˶������� ������
	 * @param alarmMessageCode �˻��� �˶� �ڵ�
	 * @return �˶��޽��������� ĸ��ȭ�� AlarmMessage��ü
	 */
	public AlarmMessage searchAlarmAlarmMessageCode(String alarmMessageCode);
}
