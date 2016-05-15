package com.soloud.per.dto;
/**
 * ��������� ĸ��ȭ�ϰ� �ִ� DTO
 * @author �强��
 *
 */
public class MemberDTO 
{
	@Override
	public String toString() {
		return "MemberDTO [memberCode=" + memberCode + ", memberKindCode="
				+ memberKindCode + ", memberId=" + memberId
				+ ", memberLimitCapacity=" + memberLimitCapacity
				+ ", password=" + password + ", name=" + name + "]";
	}
	/**
	 * ����� ������ �ڵ�
	 */
	private String memberCode;
	/**
	 * ������� �ڵ�
	 */
	private String memberKindCode;
	/**
	 * ������̵�
	 */
	private String memberId;
	/**
	 * ����� �ִ� �뷮
	 */
	private double memberLimitCapacity;
	/**
	 * ����� ��й�ȣ
	 */
	private String password;
	/**
	 * ����� �̸�
	 */
	private String name;
	public MemberDTO(String memberCode, String memberKindCode, String memberId,
			double memberLimitCapacity, String password, String name) {
		super();
		this.memberCode = memberCode;
		this.memberKindCode = memberKindCode;
		this.memberId = memberId;
		this.memberLimitCapacity = memberLimitCapacity;
		this.password = password;
		this.name = name;
	}
	public MemberDTO() {
		super();
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberKindCode() {
		return memberKindCode;
	}
	public void setMemberKindCode(String memberKindCode) {
		this.memberKindCode = memberKindCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public double getMemberLimitCapacity() {
		return memberLimitCapacity;
	}
	public void setMemberLimitCapacity(double memberLimitCapacity) {
		this.memberLimitCapacity = memberLimitCapacity;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
