package com.soloud.per.dto;
/**
 * �˶����������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class AlarmKindDTO 
{
	@Override
	public String toString() {
		return "AlarmKindDTO [alarmKindCode=" + alarmKindCode
				+ ", alarmKindName=" + alarmKindName + "]";
	}
	/**
	 * �˶������� ������ �ڵ�
	 */
	private String alarmKindCode;
	/**
	 * �˶������� �̸�
	 */
	private String alarmKindName;
	/**
	 * �˶�����Ŭ���� �������̵� ������
	 * @param alarmKindCode �˶������ڵ�
	 * @param alarmKindName �˶������̸�
	 */
	public AlarmKindDTO(String alarmKindCode,
			String alarmKindName) {
		super();
		this.alarmKindCode = alarmKindCode;
	
		this.alarmKindName = alarmKindName;
	}
	/**
	 * �˶�����Ŭ���� Defalut ������
	 */
	public AlarmKindDTO() {
		super();
	}
	/**
	 * �˶������ڵ� getter�޼ҵ�
	 * @return �˶�����
	 */
	public String getAlarmKindCode() {
		return alarmKindCode;
	}
	/**
	 * �˶������ڵ� setter�޼ҵ�
	 * @param alarmKindCode ���� �� �˶������ڵ�
	 */
	public void setAlarmKindCode(String alarmKindCode) {
		this.alarmKindCode = alarmKindCode;
	}
	/**
	 * �˶������̸� getter�޼ҵ�
	 * @return �˶������̸�
	 */
	public String getAlarmKindName() {
		return alarmKindName;
	}
	/**
	 * �˶������̸� setter�޼ҵ�
	 * @param alarmKindName ���� �� �˶����� �̸�
	 */
	public void setAlarmKindName(String alarmKindName) {
		this.alarmKindName = alarmKindName;
	}
	
	
	
}
