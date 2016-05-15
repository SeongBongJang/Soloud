package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;


/**
 * 알람메시지정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class AlarmMessage implements Serializable{
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 2880180427883196108L;

	/**
	 * 알람메시지 코드
	 */
	private String alarmMessageCode;
	
	/**
	 * 알람메시지 도착시간
	 */
	private GregorianCalendar arrivalDate;
	
	/**
	 * 수신자 아이디
	 */
	private String receiverId;
	
	/**
	 * 알람메시지 종류
	 */
	private String alarmMessageKind;
	
	/**
	 * 알람메시지 내용
	 */
	private String message;
	/**
	 * 알람메시지 클래스 오버로딩 생성자
	 * @param alarmMessageCode 알람메시지코드
	 * @param arrivalDate 도착시간
	 * @param receiverId 수신자아이디
	 * @param alarmMessageKind 알람메시지종류
	 * @param message 알람메시지내용
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate,
			String receiverId, String alarmMessageKind, String message) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
		this.receiverId = receiverId;
		this.alarmMessageKind = alarmMessageKind;
		this.message = message;
	}
	/**
	 * 알람메시지 클래스 오버로딩 생성자
	 * @param alarmMessageCode 알람메시지 코드
	 * @param arrivalDate 도착시간
 	 * @param receiverId 수신자 아이디
	 * @param alarmMessageKind 알람메시지종류
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate,
			String receiverId, String alarmMessageKind) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
		this.receiverId = receiverId;
		this.alarmMessageKind = alarmMessageKind;
	}
	/**
	 * 알람메시지 클래스 오버로딩 생성자
	 * @param alarmMessageCode 알람메시지코드
	 * @param arrivalDate 도착시간
	 * @param receiverId 수신자 아이디
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate,
			String receiverId) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
		this.receiverId = receiverId;
	}
	/**
	 * 알림메시지 오버로딩 생성자
	 * @param alarmMessageCode 알람메시지코드
	 * @param arrivalDate 도착시간
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
	}
	/**
	 * 알람메시지 클래스 오버로딩 생성자
	 * @param alarmMessageCode 알람메시지코드
	 */
	public AlarmMessage(String alarmMessageCode) {
		this.alarmMessageCode = alarmMessageCode;
	}
	/**
	 * 알람메시지 클래스 기본생성자
	 */
	public AlarmMessage() {
		this("",new GregorianCalendar(), "receiver", "messageKind");
	}
	/**
	 * getter
	 * @return 알람메시지코드
	 */
	
	public String getAlarmMessageCode() {
		return alarmMessageCode;
	}
	/**
	 * setter
	 * @param alarmMessageCode 알람메시지 코드
	 */
	public void setAlarmMessageCode(String alarmMessageCode) {
		this.alarmMessageCode = alarmMessageCode;
	}
	/**
	 * getter
	 * @return 알람메시지 도착시간
	 */
	public GregorianCalendar getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * setter
	 * @param arrivalDate 알람메시지 도착시간
	 */
	public void setArrivalDate(GregorianCalendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * getter
	 * @return 수신자아이디
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * setter
	 * @param receiverId 수신자아이디
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * getter
	 * @return 알람메시지종류
	 */
	public String getAlarmMessageKind() {
		return alarmMessageKind;
	}
	/**
	 * setter
	 * @param alarmMessageKind 알람메시지종류
	 */
	public void setAlarmMessageKind(String alarmMessageKind) {
		this.alarmMessageKind = alarmMessageKind;
	}
	/**
	 * getter
	 * @return 메세지내용
	 */
	
	public String getMessage() {
		return message;
	}
	/**
	 * setter
	 * @param message 메세지내용
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 알람메시지 객체의 데이터를 문자열화
	 * @return 알람메시지에 캡슐화된 데이터의 문자열
	 * 
	 */
	@Override
	public String toString() {
		return "AlarmMessage [alarmMessageCode=" + alarmMessageCode
				+ ", arrivalDate=" + arrivalDate + ", receiverId=" + receiverId
				+ ", alarmMessageKind=" + alarmMessageKind + ", message="
				+ message + "]";
	}
	
	
}
