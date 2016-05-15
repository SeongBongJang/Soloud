package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Member�� ����� Ŭ����
 * @author oong
 *
 */
public class MemberList implements Serializable {
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 7001510803820197605L;

	/**
	 * ȸ�����
	 */
	private ArrayList<Member> members;
	
	
	public MemberList() {
		this.members = new ArrayList<Member>();
	}

	public MemberList(ArrayList<Member> members) {
		this.members = members;
	}

	/**
	 * ȸ���� ��Ͽ� �߰��ϱ����� �޼ҵ�
	 * @param member Member ��ü. ȸ������
	 * @return �߰������� ��������. ������ true, ���н� false����
	 */
	public boolean addMember(Member member) {
		return members.add(member);
	}
	
	/**
	 * ȸ���� ��Ͽ� �߰��ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param name ȸ���̸�
	 * @param password ȸ���� ��й�ȣ
	 * @return �߰������� ��������. ������ true, ���н� false����
	 */
	public boolean addMember(String id, String name, String password) {
		return members.add(new Member(id, name, password));
	}
	
	/**
	 * ȸ���� ������κ��� �����ϱ����� �޼ҵ�
	 * @param member ������� Member��ü
	 * @return ���� ��������. ������ true, ���н� false ����
	 */
	public boolean deleteMember(Member member) {
		return members.remove(member);
	}
	
	/**
	 * ȸ���� ������κ��� �����ϱ����� �޼ҵ�
	 * @param id ȸ���� ���̵�
	 * @return ���� ��������. ������ true, ���н� false ����
	 */
	public boolean deleteMember(String id) {
		return members.remove(searchMemberId(id));
	}
	
	/**
	 * ȸ�������� �����ϱ����� �޼ҵ�
	 * @param id ȸ���� ���̵�
	 * @param newName ������ ȸ���� �̸�
	 */
	public void modifyMemberName(String id, String newName) {
		Member member = searchMemberId(id);
		member.setName(newName);
	}
	
	/**
	 * ȸ�������� �����ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param newPassword ȸ���� ��й�ȣ
	 */
	public void modifyMemberPassword(String id, String newPassword) {
		Member member = searchMemberId(id);
		member.setPassword(newPassword);
	}
	
	
	/**
	 * ȸ�������� �����ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param newMember ������ Member��ü, ȸ������
	 */
	public void modifyMember(String id, Member newMember) {
		Member member = searchMemberId(id);
		member.setName(newMember.getName());
		member.setPassword(newMember.getPassword());
		member.setCapacityLimit(newMember.getCapacityLimit());
		member.setUsedCapacity(newMember.getUsedCapacity());
	}
	
	/**
	 * ȸ�������� �����ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param newCapacityLimit ������ �ִ�뷮ġ
	 */
	public void modifyMemberCapacityLimit(String id, float newCapacityLimit) {
		Member member = searchMemberId(id);
		member.setCapacityLimit(newCapacityLimit);
	}
	
	/**
	 * ȸ�������� �����ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param newUsedCapacity ������ ���� ���뷮
	 */
	public void modifyMemberUsedCapacity(String id, float newUsedCapacity) {
		Member member = searchMemberId(id);
		member.setUsedCapacity(newUsedCapacity);
	}
	
	/**
	 * ȸ�������� �����ϱ����� �޼ҵ�
	 * @param member Member��ü, ���� ȸ������
	 * @param newMember ������ Member��ü, ��ü�� ȸ������
	 */
	public void modifyMember(Member member, Member newMember) {
		members.set(members.indexOf(member), newMember);
	}
	
	/**
	 * ȸ�������� �˻��ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @return ȸ������
	 */
	public Member searchMemberId(String id) {
		for(int i=0;i<members.size();i++){
			if(members.get(i).getId().equals(id)){
				return members.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ȸ�������� �˻��ϱ����� �޼ҵ�
	 * @param name ȸ���̸�
	 * @return ȸ�������. �˻������ ������������ ��� null ����
	 */
	public ArrayList<Member> searchMemberName(String name) {
		ArrayList<Member> members = new ArrayList<Member>();
		for(int i=0;i<this.members.size();i++){
			if(this.members.get(i).getName().equals(name)){
				members.add(this.members.get(i));
			}
		}
		if(members.isEmpty()){
			return null;
		}
		return members;
	}
	
	/**
	 * ȸ�������� �˻��ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param password ȸ�� ��й�ȣ
	 * @return ȸ������
	 */
	public Member searchMember(String id, String password) {
		for(int i=0;i<this.members.size();i++){
			if(this.members.get(i).getPassword().equals(password) && this.members.get(i).getId().equals(id)){
				return this.members.get(i);
			}
		}
		return null;
	}
	/**
	 * getter
	 * @return ȸ�����
	 */
	public ArrayList<Member> getMembers() {
		return members;
	}
/**
 * setter
 * @param members ȸ�����
 */
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
}
