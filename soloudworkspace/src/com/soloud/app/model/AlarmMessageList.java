package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;






/**
 * �˶��޽����� ����� Ŭ����
 * @author oong
 *
 */
public class AlarmMessageList implements Serializable{
	/**
	 * �ø������ ���̵�
	 */
	private static final long serialVersionUID = 3958316324299399908L;
	

	/**
	 * �˶��޽����� ������Ʈ�� �ϴ� ����Ʈ
	 */
	private ArrayList<AlarmMessage> alarmMessages;
	
	/**
	 * �˶��޽�������Ʈ �⺻ ������
	 */
	public AlarmMessageList() {
		this.alarmMessages = new ArrayList<AlarmMessage>();
	}
	/**
	 * �˶��޽�������Ʈ �����ε� ������
	 * @param alarmMessages
	 */
	public AlarmMessageList(ArrayList<AlarmMessage> alarmMessages) {
		this.alarmMessages = alarmMessages;
	}

	/**
	 * �˶��޽��� ��ü�� �߰��ϴ� �޼ҵ�
	 * @param alarmMessage
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addAlarmMessage(AlarmMessage alarmMessage) {
		return this.alarmMessages.add(alarmMessage);	
	}
	
	/**
	 * �˶��޽��� ��ü�� �߰��ϱ����� �޼ҵ�
	 * @param receiverId ������ ���̵�
	 * @param alarmMessageKind �˶��޽�������
	 * @param message �޽�������
	 * @param alarmMessageCode �˶��޽��� �ڵ� 
	 * @return
	 */
	public boolean addAlarmMessage(String receiverId, String alarmMessageKind, String message, String alarmMessageCode) {
		return this.alarmMessages.add(new AlarmMessage(alarmMessageCode, new GregorianCalendar(), receiverId, alarmMessageKind, message));
	}
	
	/**
	 * �˶��޽��� ��ü�� �����ϱ����� �޼ҵ�
	 * @param alarmMessageCode �˶��޽����ڵ�
	 */
	public void deleteAlarmMessageAlarmMessageCode(String alarmMessageCode) {
		this.alarmMessages.remove(searchAlarmMessageCode(alarmMessageCode));
	}
	
	/**
	 * �˶��޽��� ��ü�� �����ϱ����� �޼ҵ�
	 * @param receiverId ������ ���̵�
	 */
	public void deleteAlarmMessageReceiverId(String receiverId) {
		for(int i=0;i<this.alarmMessages.size();i++){
			if(alarmMessages.get(i).getReceiverId().equals(receiverId)){
				alarmMessages.remove(i);
			}
		}
	}
	
	/**
	 * �˶��޽����� ������ �����ϱ����� �޼ҵ�
	 * @param alaramMessageCode �˶��޽����ڵ�
	 * @param newMessage ������ ����
	 */
	public void modifyAlarmMessage(String alaramMessageCode, String newMessage) {
		searchAlarmMessageCode(alaramMessageCode).setMessage(newMessage);
	}
	
	/**
	 * �˶��޽����� �˻��ϱ����� �޼ҵ�
	 * @param alarmMessageCode �˶��޽����ڵ�
	 * @return �˻���� �˶��޽�����ü. ������������ ��� null ����
	 */
	public AlarmMessage searchAlarmMessageCode(String alarmMessageCode) {
		for(AlarmMessage temp : this.alarmMessages){
			if(temp.getAlarmMessageCode()==alarmMessageCode){
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * �˶��޽����� �˻��ϱ����� �޼ҵ�
	 * @param receiverId ������ ���̵�
	 * @return �˶��޽������. �˻������ ���� ��� null ����
	 */
	public ArrayList<AlarmMessage> searchAlarmReceiverId(String receiverId) {
		ArrayList<AlarmMessage> list = new ArrayList<AlarmMessage>();
		for(int i=0; i<this.alarmMessages.size(); i++){
			if(this.alarmMessages.get(i).getReceiverId().equals(receiverId)){
				list.add(this.alarmMessages.get(i));
			}
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
}
