package com.soloud.per.dto;
/**
 * 멤버 유형을 캡슐화 하고 있는 클래스
 * @author 장성봉
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
	 * 멤버유형의 고유항 코드
	 */
	private String memberKindCode;
	/**
	 * 멤버유형이름
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
