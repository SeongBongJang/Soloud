package com.soloud.app.model;
/**
 * 그룹종류의 열거형 클래스
 * @author oong
 *
 */
public enum Group {
	BESTFRIEND("절친"), NORMALFRIEND("친구"), AWKWARDFRIEND("어색한친구");
	/**
	 * 그룹종류
	 */
	final private String groupKind;
	
	/**
	 * 그룹종류 기본생성자
	 * @param groupKind
	 */
	private Group(String groupKind){
		this.groupKind = groupKind; 
	}
	/**
	 * 그룹종류의 값을 얻기위한 메소드
	 * @return
	 */
	public String value(){
		return this.groupKind;
	}
}
