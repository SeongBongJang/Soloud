package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 멤버코드에 대한 알림정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class MemberAlarmVDTO 
{
	@Override
	public String toString() {
		return "MemberAlarmVDTO [memberCode=" + memberCode + ", memberName="
				+ memberName + ", senderCode=" + senderCode + ", senderName="
				+ senderName + ", alarmArrivalDate=" + alarmArrivalDate
				+ ", alarmKindName=" + alarmKindName + "]";
	}
	/**
	 * 사용자 멤버 코드
	 */
	private String memberCode;
	/**
	 * 사용자 멤버이름
	 */
	private String memberName;
	/**
	 * 보낸 사용자 멤버코드
	 */
	private String senderCode;
	/**
	 * 보낸사용자 멤버이름
	 */
	private String senderName;
	/**
	 * 알람날짜
	 */
	private GregorianCalendar alarmArrivalDate;
	/**
	 * 알람유형이름
	 */
	private String alarmKindName;
	/**
	 * 수신확인 여부
	 */
	private String isReadAlarm;
	public MemberAlarmVDTO() {
		super();
	}
	public MemberAlarmVDTO(String memberCode, String memberName,
			String senderCode, String senderName,
			GregorianCalendar alarmArrivalDate, String alarmKindName, String isReadAlarm) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.senderCode = senderCode;
		this.senderName = senderName;
		this.alarmArrivalDate = alarmArrivalDate;
		this.alarmKindName = alarmKindName;
		this.isReadAlarm = isReadAlarm;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getSenderCode() {
		return senderCode;
	}
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public GregorianCalendar getAlarmArrivalDate() {
		return alarmArrivalDate;
	}
	public void setAlarmArrivalDate(GregorianCalendar alarmArrivalDate) {
		this.alarmArrivalDate = alarmArrivalDate;
	}
	public String getAlarmKindName() {
		return alarmKindName;
	}
	public void setAlarmKindName(String alarmKindName) {
		this.alarmKindName = alarmKindName;
	}
	public String getIsReadAlarm() {
		return isReadAlarm;
	}
	public void setIsReadAlarm(String isReadAlarm) {
		this.isReadAlarm = isReadAlarm;
	}
	
	
}
