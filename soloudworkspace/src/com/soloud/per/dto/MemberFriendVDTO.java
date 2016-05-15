package com.soloud.per.dto;
/**
 * 멤버코드에 대한 친구정보를 캡슐화한 클래스
 * @author 장성봉
 * 
 */
public class MemberFriendVDTO 
{
	@Override
	public String toString() {
		return "MemberFriendVDTO [memberCode=" + memberCode + ", memberName="
				+ memberName + ", friendMemberCode=" + friendMemberCode
				+ ", friendMemberName=" + friendMemberName 
				+ ", friendMemberId = " + friendMemberId +"]";
	}
	/**
	 * 사용자 멤버코드
	 */
	private String memberCode;
	/**
	 * 멤버이름
	 */
	private String memberName;
	/**
	 * 친구 사용자 멤버코드
	 */
	private String friendMemberCode;
	/**
	 * 친구 사용자 멤버이름
	 */
	private String friendMemberName;
	/**
	 * 친구 아이디
	 */
	private String friendMemberId;
	public MemberFriendVDTO(String memberCode, String memberName,
			String friendMemberCode, String friendMemberName,String friendMemberId) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.friendMemberCode = friendMemberCode;
		this.friendMemberName = friendMemberName;
		this.friendMemberId = friendMemberId;
	}
	public String getFriendMemberId() {
		return friendMemberId;
	}
	public void setFriendMemberId(String friendMemberId) {
		this.friendMemberId = friendMemberId;
	}
	public MemberFriendVDTO() {
		super();
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFriendMemberCode() {
		return friendMemberCode;
	}
	public void setFriendMemberCode(String friendMemberCode) {
		this.friendMemberCode = friendMemberCode;
	}
	public String getFriendMemberName() {
		return friendMemberName;
	}
	public void setFriendMemberName(String friendMemberName) {
		this.friendMemberName = friendMemberName;
	}
	
	
}
