package com.soloud.per.dto;
/**
 * 알람유형정보를 캡슐화한 클래스
 * @author 장성봉
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
	 * 알람유형의 고유항 코드
	 */
	private String alarmKindCode;
	/**
	 * 알람유형의 이름
	 */
	private String alarmKindName;
	/**
	 * 알람유형클래스 오버라이드 생성자
	 * @param alarmKindCode 알람유형코드
	 * @param alarmKindName 알람유형이름
	 */
	public AlarmKindDTO(String alarmKindCode,
			String alarmKindName) {
		super();
		this.alarmKindCode = alarmKindCode;
	
		this.alarmKindName = alarmKindName;
	}
	/**
	 * 알람유형클래스 Defalut 생성자
	 */
	public AlarmKindDTO() {
		super();
	}
	/**
	 * 알람유형코드 getter메소드
	 * @return 알람유형
	 */
	public String getAlarmKindCode() {
		return alarmKindCode;
	}
	/**
	 * 알람유형코드 setter메소드
	 * @param alarmKindCode 변경 할 알람유형코드
	 */
	public void setAlarmKindCode(String alarmKindCode) {
		this.alarmKindCode = alarmKindCode;
	}
	/**
	 * 알람유형이름 getter메소드
	 * @return 알람유형이름
	 */
	public String getAlarmKindName() {
		return alarmKindName;
	}
	/**
	 * 알람유형이름 setter메소드
	 * @param alarmKindName 변경 할 알람유형 이름
	 */
	public void setAlarmKindName(String alarmKindName) {
		this.alarmKindName = alarmKindName;
	}
	
	
	
}
