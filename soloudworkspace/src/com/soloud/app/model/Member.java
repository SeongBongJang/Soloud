package com.soloud.app.model;

import java.io.Serializable;

/**
 * ȸ�������� ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class Member implements Serializable{
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = -7356997670309165687L;
	/**
	 * ȸ���� ���̵�
	 */
	private String id;
	/**
	 * ȸ���� �̸�
	 */
	private String name;
	/**
	 * ȸ���� ��й�ȣ
	 */
	private String password;
	/**
	 * ȸ���� �뷮�ִ�ġ
	 */
	private float capacityLimit;
	/**
	 * ȸ���� ���� ���뷮
	 */
	private float usedCapacity;
	/**
	 * MemberŬ������ �����ε� ������
	 * @param id ȸ���� ���̵�
	 * @param name ȸ���� �̸�
	 * @param password ȸ���� ��й�ȣ
	 * @param capacityLimit ȸ���� �뷮�ִ�ġ 
	 * @param usedCapacity ȸ���� ���� ���뷮
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
	 * MemberŬ���� �⺻ ������
	 */
	public Member() {
		this("id","name","password", 0.0f, 0.0f);
	}
	/**
	 * MemberŬ���� �����ε� ������
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
	 * MemberŬ���� �����ε� ������
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
	 * MemberŬ���� �����ε� ������
	 * @param id
	 * @param name
	 */
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * MemberŬ���� �����ε� ������
	 * @param id ȸ���� ���̵�
	 */
	public Member(String id) {
		this.id = id;
	}
	/**
	 * getter
	 * @return ȸ�����̵�
	 */
	public String getId() {
		return id;
	}
	/**
	 * setter
	 * @param id ȸ���� ���̵�
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * getter
	 * @return ȸ���̸�
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter
	 * @param name ȸ���̸�
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter
	 * @return ȸ���� ��й�ȣ
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter
	 * @param password ȸ���� ��й�ȣ
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * getter
	 * @return ȸ���� �뷮�ִ�ġ
	 */
	public float getCapacityLimit() {
		return capacityLimit;
	}
	/**
	 * setter
	 * @param capacityLimit ȸ���� �뷮 �ִ�ġ
	 */
	public void setCapacityLimit(float capacityLimit) {
		this.capacityLimit = capacityLimit;
	}
	/**
	 * getter
	 * @return ȸ���� ���� ���뷮
	 */
	public float getUsedCapacity() {
		return usedCapacity;
	}
	/**
	 * setter 
	 * @param usedCapacity ȸ���� ���� ���뷮
	 */
	public void setUsedCapacity(float usedCapacity) {
		this.usedCapacity = usedCapacity;
	}
	/**
	 * ȸ�������� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password
				+ ", capacityLimit=" + capacityLimit + ", usedCapacity="
				+ usedCapacity + "]";
	}
	
	
}
