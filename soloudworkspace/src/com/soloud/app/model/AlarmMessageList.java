package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;






/**
 * 알람메시지의 목록형 클래스
 * @author oong
 *
 */
public class AlarmMessageList implements Serializable{
	/**
	 * 시리얼버전 아이디
	 */
	private static final long serialVersionUID = 3958316324299399908L;
	

	/**
	 * 알람메시지를 엘리먼트로 하는 리스트
	 */
	private ArrayList<AlarmMessage> alarmMessages;
	
	/**
	 * 알람메시지리스트 기본 생성자
	 */
	public AlarmMessageList() {
		this.alarmMessages = new ArrayList<AlarmMessage>();
	}
	/**
	 * 알람메시지리스트 오버로딩 생성자
	 * @param alarmMessages
	 */
	public AlarmMessageList(ArrayList<AlarmMessage> alarmMessages) {
		this.alarmMessages = alarmMessages;
	}

	/**
	 * 알람메시지 객체를 추가하는 메소드
	 * @param alarmMessage
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addAlarmMessage(AlarmMessage alarmMessage) {
		return this.alarmMessages.add(alarmMessage);	
	}
	
	/**
	 * 알람메시지 객체를 추가하기위한 메소드
	 * @param receiverId 수신자 아이디
	 * @param alarmMessageKind 알람메시지종류
	 * @param message 메시지내용
	 * @param alarmMessageCode 알람메시지 코드 
	 * @return
	 */
	public boolean addAlarmMessage(String receiverId, String alarmMessageKind, String message, String alarmMessageCode) {
		return this.alarmMessages.add(new AlarmMessage(alarmMessageCode, new GregorianCalendar(), receiverId, alarmMessageKind, message));
	}
	
	/**
	 * 알람메시지 객체를 삭제하기위한 메소드
	 * @param alarmMessageCode 알람메시지코드
	 */
	public void deleteAlarmMessageAlarmMessageCode(String alarmMessageCode) {
		this.alarmMessages.remove(searchAlarmMessageCode(alarmMessageCode));
	}
	
	/**
	 * 알람메시지 객체를 삭제하기위한 메소드
	 * @param receiverId 수신자 아이디
	 */
	public void deleteAlarmMessageReceiverId(String receiverId) {
		for(int i=0;i<this.alarmMessages.size();i++){
			if(alarmMessages.get(i).getReceiverId().equals(receiverId)){
				alarmMessages.remove(i);
			}
		}
	}
	
	/**
	 * 알람메시지의 내용을 수정하기위한 메소드
	 * @param alaramMessageCode 알람메시지코드
	 * @param newMessage 수정할 내용
	 */
	public void modifyAlarmMessage(String alaramMessageCode, String newMessage) {
		searchAlarmMessageCode(alaramMessageCode).setMessage(newMessage);
	}
	
	/**
	 * 알람메시지를 검색하기위한 메소드
	 * @param alarmMessageCode 알람메시지코드
	 * @return 검색결과 알람메시지객체. 존재하지않을 경우 null 리턴
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
	 * 알람메시지를 검색하기위한 메소드
	 * @param receiverId 수신자 아이디
	 * @return 알람메시지목록. 검색결과가 없을 경우 null 리턴
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
