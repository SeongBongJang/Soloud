//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : AlarmSearchDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//

package com.soloud.per.dao;
import java.util.GregorianCalendar;
import java.util.List;

import com.soloud.per.dto.AlarmDTO;

/**
 * 알람 데이터를 조회하는 인터페이스
 * @author 장성봉 <hr>
 * 알람 DataBase에 지정한 데이터를 가지는 Record를 조회한는 인터페이스
 */
public interface AlarmSearchDAO
{
	/**
	 * 알람 DataBase의 모든 데이터를 조회하는 메소드
	 * @return AlarmDTO타입의 List 객체
	 */
	public List<AlarmDTO> searchAllAlarm();
	/**
	 * 알람 DataBase에서 지정한 알람코드를 가지는 모든 알람 Record를 조회하는 메소드
	 * @param alarmCode 알람코드
	 * @return 지정한 알람코드를가지는 AalramDTO 타입의 List 객체
	 */
	public AlarmDTO searchAlarmCode(String alarmCode);
	/**
	 * 알람 DataBase에서 지정한 멤버코드를 가지는 모든 알람 Record를 조회하는 메소드
	 * @param memberCode 멤버코드
	 * @return 지정한 멤버코드를 가지는 AalramDTO 타입의 List 객체
	 */
	public List<AlarmDTO> searchAlarmMemberCode(String memberCode);
	/**
	 * 알람 DataBase에서 지정한 멤버코드와 보낸멤버코드를 가지는 모든 알람 Record를 조회하는 메소드
	 * @param memberCode 멤버코드
	 * @param senderCode 보낸이 멤버코드
	 * @return 지정한 멤버코드,보낸이멤버코드를 가지는 AalarmDTO 타입의 List객체
	 */
	public List<AlarmDTO> searchAlarmMemberSenderCode(String memberCode, String senderCode);
	/**
	 * 알람 DataBase에서 지정한 멤버코드와 기간을 가지는 모든 알람 Record를 조회하는 메소드
	 * @param memberCode 멤버코드
	 * @param starDate 시작일
	 * @param endDate 마지막일
	 * @return 지정한 멤버코드와 기간내의 값을 가지는 모든 AlarmDTO타입의 객체
	 */
	public List<AlarmDTO> searchAlarmMemberDate(String memberCode, GregorianCalendar starDate, GregorianCalendar endDate);
	/**
	 * 알람 DataBase에서 지정한 멤버코드와 멤버유형코드를 가지는 모든 알람 Record를 조회하는 메소드
	 * @param memberCode 멤버코드
	 * @param alarmKindCode 알람유형코드
	 * @return 지정한 멤버코드와 알람유형코드를 가지는 모든 AlarmDTO 타입의 객체
	 */
	public List<AlarmDTO> searchAlarmMemberKindCode(String memberCode, String alarmKindCode);
	/**
	 * 알람 DataBase에서 지정한 멤버코드와 알람유형코드,보낸멤버코드를 가지는 모든 알람 Record를 조회하는 메소드
	 * @param memberCode 멤버코드
	 * @param alarmKindCode 알람유형코드
	 * @param senderCode 보낸멤버코드
	 * @return 지정한 멤버코드와 알람유형코드를 가지는 모든 AlarmDTO 타입의 객체
	 */
	public List<AlarmDTO> searchAlarmMemberKindSenderCode(String memberCode, String alarmKindCode, String senderCode);
	/**
	 * 알람 DataBase에서 지정한 멤버코드와 알람확인여부를 가지는 모든 알람 Record를 조회하는 메소드
	 * @param memberCode 멤버코드 
	 * @param isReadAlarm 수신확인여부
	 * @return @return 지정한 멤버코드와 수신확이여부를 가지는 모든 AlarmDTO 타입의 객체
	 */
	public List<AlarmDTO> searchAlarmMemberCodeIsReadAlram(String memberCode, String isReadAlarm);
	public List<AlarmDTO> searchAlarmSenderCodeAlarmKindCode(String senderCode,String alarmKindCode);
}