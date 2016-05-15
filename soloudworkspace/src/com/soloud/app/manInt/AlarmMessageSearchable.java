package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.AlarmMessage;

public interface AlarmMessageSearchable {
	/**
	 * 받는 사람 Id(receiverId로(전달값은 memberCode))에 해당하는 모든 알람정볼르 가져옴
	 * @param receiverId 받는사람 id(실제 전달값을 MemberCode)
	 * @return 알람 내역
	 */
	public ArrayList<AlarmMessage> searchAlarmReceiverId(String receiverId);
	
	/**
	 * 알람메시지 코드에 해당하는 알람정보를 가져옴
	 * @param alarmMessageCode 검색할 알람 코드
	 * @return 알람메시지정보를 캡슐화한 AlarmMessage객체
	 */
	public AlarmMessage searchAlarmAlarmMessageCode(String alarmMessageCode);
}
