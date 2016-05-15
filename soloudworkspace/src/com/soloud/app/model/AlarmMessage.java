package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;


/**
 * �˶��޽��������� ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class AlarmMessage implements Serializable{
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 2880180427883196108L;

	/**
	 * �˶��޽��� �ڵ�
	 */
	private String alarmMessageCode;
	
	/**
	 * �˶��޽��� �����ð�
	 */
	private GregorianCalendar arrivalDate;
	
	/**
	 * ������ ���̵�
	 */
	private String receiverId;
	
	/**
	 * �˶��޽��� ����
	 */
	private String alarmMessageKind;
	
	/**
	 * �˶��޽��� ����
	 */
	private String message;
	/**
	 * �˶��޽��� Ŭ���� �����ε� ������
	 * @param alarmMessageCode �˶��޽����ڵ�
	 * @param arrivalDate �����ð�
	 * @param receiverId �����ھ��̵�
	 * @param alarmMessageKind �˶��޽�������
	 * @param message �˶��޽�������
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
	 * �˶��޽��� Ŭ���� �����ε� ������
	 * @param alarmMessageCode �˶��޽��� �ڵ�
	 * @param arrivalDate �����ð�
 	 * @param receiverId ������ ���̵�
	 * @param alarmMessageKind �˶��޽�������
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate,
			String receiverId, String alarmMessageKind) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
		this.receiverId = receiverId;
		this.alarmMessageKind = alarmMessageKind;
	}
	/**
	 * �˶��޽��� Ŭ���� �����ε� ������
	 * @param alarmMessageCode �˶��޽����ڵ�
	 * @param arrivalDate �����ð�
	 * @param receiverId ������ ���̵�
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate,
			String receiverId) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
		this.receiverId = receiverId;
	}
	/**
	 * �˸��޽��� �����ε� ������
	 * @param alarmMessageCode �˶��޽����ڵ�
	 * @param arrivalDate �����ð�
	 */
	public AlarmMessage(String alarmMessageCode, GregorianCalendar arrivalDate) {
		
		this.alarmMessageCode = alarmMessageCode;
		this.arrivalDate = arrivalDate;
	}
	/**
	 * �˶��޽��� Ŭ���� �����ε� ������
	 * @param alarmMessageCode �˶��޽����ڵ�
	 */
	public AlarmMessage(String alarmMessageCode) {
		this.alarmMessageCode = alarmMessageCode;
	}
	/**
	 * �˶��޽��� Ŭ���� �⺻������
	 */
	public AlarmMessage() {
		this("",new GregorianCalendar(), "receiver", "messageKind");
	}
	/**
	 * getter
	 * @return �˶��޽����ڵ�
	 */
	
	public String getAlarmMessageCode() {
		return alarmMessageCode;
	}
	/**
	 * setter
	 * @param alarmMessageCode �˶��޽��� �ڵ�
	 */
	public void setAlarmMessageCode(String alarmMessageCode) {
		this.alarmMessageCode = alarmMessageCode;
	}
	/**
	 * getter
	 * @return �˶��޽��� �����ð�
	 */
	public GregorianCalendar getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * setter
	 * @param arrivalDate �˶��޽��� �����ð�
	 */
	public void setArrivalDate(GregorianCalendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * getter
	 * @return �����ھ��̵�
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * setter
	 * @param receiverId �����ھ��̵�
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * getter
	 * @return �˶��޽�������
	 */
	public String getAlarmMessageKind() {
		return alarmMessageKind;
	}
	/**
	 * setter
	 * @param alarmMessageKind �˶��޽�������
	 */
	public void setAlarmMessageKind(String alarmMessageKind) {
		this.alarmMessageKind = alarmMessageKind;
	}
	/**
	 * getter
	 * @return �޼�������
	 */
	
	public String getMessage() {
		return message;
	}
	/**
	 * setter
	 * @param message �޼�������
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * �˶��޽��� ��ü�� �����͸� ���ڿ�ȭ
	 * @return �˶��޽����� ĸ��ȭ�� �������� ���ڿ�
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
