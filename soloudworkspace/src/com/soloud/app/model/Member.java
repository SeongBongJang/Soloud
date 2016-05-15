package com.soloud.app.model;

import java.io.Serializable;

/**
 * 회원정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class Member implements Serializable{
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = -7356997670309165687L;
	/**
	 * 회원의 아이디
	 */
	private String id;
	/**
	 * 회원의 이름
	 */
	private String name;
	/**
	 * 회원의 비밀번호
	 */
	private String password;
	/**
	 * 회원의 용량최대치
	 */
	private float capacityLimit;
	/**
	 * 회원의 현재 사용용량
	 */
	private float usedCapacity;
	/**
	 * Member클래스의 오버로딩 생성자
	 * @param id 회원의 아이디
	 * @param name 회원의 이름
	 * @param password 회원의 비밀번호
	 * @param capacityLimit 회원의 용량최대치 
	 * @param usedCapacity 회원의 현재 사용용량
	 */
	public Member(String id, String name, String password, float capacityLimit,
			float usedCapacity) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.capacityLimit = capacityLimit;
		this.usedCapacity = usedCapacity;
	}
	/**
	 * Member클래스 기본 생성자
	 */
	public Member() {
		this("id","name","password", 0.0f, 0.0f);
	}
	/**
	 * Member클래스 오버로딩 생성자
	 * @param id
	 * @param name
	 * @param password
	 * @param capacityLimit
	 */
	public Member(String id, String name, String password, float capacityLimit) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.capacityLimit = capacityLimit;
	}
	/**
	 * Member클래스 오버로딩 생성자
	 * @param id
	 * @param name
	 * @param password
	 */
	public Member(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	/**
	 * Member클래스 오버로딩 생성자
	 * @param id
	 * @param name
	 */
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * Member클래스 오버로딩 생성자
	 * @param id 회원의 아이디
	 */
	public Member(String id) {
		this.id = id;
	}
	/**
	 * getter
	 * @return 회원아이디
	 */
	public String getId() {
		return id;
	}
	/**
	 * setter
	 * @param id 회원의 아이디
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * getter
	 * @return 회원이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter
	 * @param name 회원이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter
	 * @return 회원의 비밀번호
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter
	 * @param password 회원의 비밀번호
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * getter
	 * @return 회원의 용량최대치
	 */
	public float getCapacityLimit() {
		return capacityLimit;
	}
	/**
	 * setter
	 * @param capacityLimit 회원의 용량 최대치
	 */
	public void setCapacityLimit(float capacityLimit) {
		this.capacityLimit = capacityLimit;
	}
	/**
	 * getter
	 * @return 회원의 현재 사용용량
	 */
	public float getUsedCapacity() {
		return usedCapacity;
	}
	/**
	 * setter 
	 * @param usedCapacity 회원의 현재 사용용량
	 */
	public void setUsedCapacity(float usedCapacity) {
		this.usedCapacity = usedCapacity;
	}
	/**
	 * 회원정보를 문자열화하기위한 메소드
	 */
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password
				+ ", capacityLimit=" + capacityLimit + ", usedCapacity="
				+ usedCapacity + "]";
	}
	
	
}
