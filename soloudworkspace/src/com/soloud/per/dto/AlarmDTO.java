package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 알람정보를 캡슐화하고 있는 클래스
 * @author 장성봉<hr>
 * 
 */
public class AlarmDTO 
{
	/**
	 * 알람에 대한 공유한 코드 
	 */
	private String alarmCode;
	/**
	 * 알람 유형 코드
	 */
	private String alarmKindCode;
	/**
	 * 사용자의 맴버코드
	 */
	private String memberCode;
	/**
	 * 보낸멤버의 멤버코드
	 */
	private String senderCode;
	/**
	 * 알람 날짜 
	 */
	private GregorianCalendar arrivalDate;
	/**
	 * 알람정보 수신확인 여부 
	 */
	private String isReadAlarm;
	/**
	 * Defalut 생성자
	 */
	public AlarmDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param alarmCode 알람코드
	 * @param alarmKindCode 알람유형
	 * @param memberCode 사용자 멤버코드
	 * @param senderCode 보낸사용자 멤버코드
	 * @param arrivalDate 알람날짜
	 * @param isReadAlarm 수신확인 여부
	 */
	public AlarmDTO(String alarmCode, String alarmKindCode, String memberCode, String senderCode,
			GregorianCalendar arrivalDate, String isReadAlarm) {
		super();
		this.setAlarmKindCode(alarmKindCode);
		this.alarmCode = alarmCode;
		this.memberCode = memberCode;
		this.senderCode = senderCode;
		this.arrivalDate = arrivalDate;
		this.isReadAlarm = isReadAlarm;
	}
	/**
	 * 알람날짜 getter 메소드
	 * @return 알람날짜
	 */
	public GregorianCalendar getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * 알람날짜 setter 메소드
	 * @param arrivalDate 변경 할 알람 날짜
	 */
	public void setArrivalDate(GregorianCalendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * 알람코드 getter메소드
	 * @return 알람날짜
	 */
	public String getAlarmCode() {
		return alarmCode;
	}
	/**
	 * 알람코드 setter메소드
	 * @param alarmCode 변경할 알람 코드
	 */
	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}
	/**
	 * 사용자 멤버코드 getter메소드
	 * @return 사용자 멤버코드
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * 사용자 멤버코드 setter메소드
	 * @param memberCode 변경 할 멤버코드
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * 보낸사용자 멤버코드 getter메소드
	 * @return 보내사용자 멤버코드
	 */
	public String getSenderCode() {
		return senderCode;
	}
	/**
	 * 보낸사용자 멤버코드 setter메소드
	 * @param senderCode 변경 할 보낸사람 코드
	 */
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	/**
	 * 수신확인 여부 getter 메소드
	 * @return 수신확인여부
	 */
	public String getIsReadAlarm() {
		return isReadAlarm;
	}
	/**
	 * 수신확인여부 setter 메소드
	 * @param isReadAlarm 변경 항 수신확인 여부
	 */
	public void setIsReadAlarm(String isReadAlarm) {
		this.isReadAlarm = isReadAlarm;
	}
	@Override
	public String toString() {
		return "AlarmDTO [alarmCode=" + alarmCode + ", alarmKindCode="
				+ alarmKindCode + ", memberCode=" + memberCode
				+ ", senderCode=" + senderCode + ", arrivalDate=" + arrivalDate
				+ ", isReadAlarm=" + isReadAlarm + "]";
	}
	/**
	 * 알람유형 getter메소드
	 * @return 알람유형
	 */
	public String getAlarmKindCode() {
		return alarmKindCode;
	}
	/**
	 * 알람유형 setter메소드
	 * @param alarmKindCode 변경 할 알람 유형
	 */
	public void setAlarmKindCode(String alarmKindCode) {
		this.alarmKindCode = alarmKindCode;
	}
	
}
