package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * �˶������� ĸ��ȭ�ϰ� �ִ� Ŭ����
 * @author �强��<hr>
 * 
 */
public class AlarmDTO 
{
	/**
	 * �˶��� ���� ������ �ڵ� 
	 */
	private String alarmCode;
	/**
	 * �˶� ���� �ڵ�
	 */
	private String alarmKindCode;
	/**
	 * ������� �ɹ��ڵ�
	 */
	private String memberCode;
	/**
	 * ��������� ����ڵ�
	 */
	private String senderCode;
	/**
	 * �˶� ��¥ 
	 */
	private GregorianCalendar arrivalDate;
	/**
	 * �˶����� ����Ȯ�� ���� 
	 */
	private String isReadAlarm;
	/**
	 * Defalut ������
	 */
	public AlarmDTO() {
		super();
	}
	/**
	 * �����ε�� ������
	 * @param alarmCode �˶��ڵ�
	 * @param alarmKindCode �˶�����
	 * @param memberCode ����� ����ڵ�
	 * @param senderCode ��������� ����ڵ�
	 * @param arrivalDate �˶���¥
	 * @param isReadAlarm ����Ȯ�� ����
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
	 * �˶���¥ getter �޼ҵ�
	 * @return �˶���¥
	 */
	public GregorianCalendar getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * �˶���¥ setter �޼ҵ�
	 * @param arrivalDate ���� �� �˶� ��¥
	 */
	public void setArrivalDate(GregorianCalendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * �˶��ڵ� getter�޼ҵ�
	 * @return �˶���¥
	 */
	public String getAlarmCode() {
		return alarmCode;
	}
	/**
	 * �˶��ڵ� setter�޼ҵ�
	 * @param alarmCode ������ �˶� �ڵ�
	 */
	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}
	/**
	 * ����� ����ڵ� getter�޼ҵ�
	 * @return ����� ����ڵ�
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * ����� ����ڵ� setter�޼ҵ�
	 * @param memberCode ���� �� ����ڵ�
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * ��������� ����ڵ� getter�޼ҵ�
	 * @return ��������� ����ڵ�
	 */
	public String getSenderCode() {
		return senderCode;
	}
	/**
	 * ��������� ����ڵ� setter�޼ҵ�
	 * @param senderCode ���� �� ������� �ڵ�
	 */
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	/**
	 * ����Ȯ�� ���� getter �޼ҵ�
	 * @return ����Ȯ�ο���
	 */
	public String getIsReadAlarm() {
		return isReadAlarm;
	}
	/**
	 * ����Ȯ�ο��� setter �޼ҵ�
	 * @param isReadAlarm ���� �� ����Ȯ�� ����
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
	 * �˶����� getter�޼ҵ�
	 * @return �˶�����
	 */
	public String getAlarmKindCode() {
		return alarmKindCode;
	}
	/**
	 * �˶����� setter�޼ҵ�
	 * @param alarmKindCode ���� �� �˶� ����
	 */
	public void setAlarmKindCode(String alarmKindCode) {
		this.alarmKindCode = alarmKindCode;
	}
	
}
