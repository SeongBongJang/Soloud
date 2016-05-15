package com.soloud.per.dto;
/**
 * 멤버정보를 캡슐화하고 있는 DTO
 * @author 장성봉
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
	 * 멤버의 고유한 코드
	 */
	private String memberCode;
	/**
	 * 멤버유형 코드
	 */
	private String memberKindCode;
	/**
	 * 멤버아이디
	 */
	private String memberId;
	/**
	 * 멤버의 최대 용량
	 */
	private double memberLimitCapacity;
	/**
	 * 멤버의 비밀번호
	 */
	private String password;
	/**
	 * 멤버의 이름
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
