package com.soloud.per.dto;
/**
 * ��� ������ ĸ��ȭ �ϰ� �ִ� Ŭ����
 * @author �强��
 *
 */
public class MemberKindDTO 
{
	@Override
	public String toString() {
		return "MemberKindDTO [memberKindCode=" + memberKindCode
				+ ", memberKindName=" + memberKindName + "]";
	}
	/**
	 * ��������� ������ �ڵ�
	 */
	private String memberKindCode;
	/**
	 * ��������̸�
	 */
	private String memberKindName;
	public MemberKindDTO(String memberKindCode, String memberKindName) {
		super();
		this.memberKindCode = memberKindCode;
		this.memberKindName = memberKindName;
	}
	public MemberKindDTO() {
		super();
	}
	public String getMemberKindCode() {
		return memberKindCode;
	}
	public void setMemberKindCode(String memberKindCode) {
		this.memberKindCode = memberKindCode;
	}
	public String getMemberKindName() {
		return memberKindName;
	}
	public void setMemberKindName(String memberKindName) {
		this.memberKindName = memberKindName;
	}
	
	
}
