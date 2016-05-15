package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ����ڵ忡 ���� �˸������� ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * ����� ��� �ڵ�
	 */
	private String memberCode;
	/**
	 * ����� ����̸�
	 */
	private String memberName;
	/**
	 * ���� ����� ����ڵ�
	 */
	private String senderCode;
	/**
	 * ��������� ����̸�
	 */
	private String senderName;
	/**
	 * �˶���¥
	 */
	private GregorianCalendar alarmArrivalDate;
	/**
	 * �˶������̸�
	 */
	private String alarmKindName;
	/**
	 * ����Ȯ�� ����
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
