package com.soloud.per.dto;
/**
 * 친구정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class FriendDTO 
{
	@Override
	public String toString() {
		return "FriendDTO [friendCode=" + friendCode + ", memberCode="
				+ memberCode + ", groupCode=" + groupCode
				+ ", friendMemberCode=" + friendMemberCode + "]";
	}
	/**
	 * 관계된 친구정보에 대한 고유한 코드
	 */
	private String friendCode;
	/**
	 * 사용자 코드
	 */
	private String memberCode;
	/**
	 * 사용자의 그룹코드
	 */
	private String groupCode;
	/**
	 * 친구의 멤버코드
	 */
	private String friendMemberCode;
	public FriendDTO(String friendCode, String memberCode, String groupCode,
			String friendMemberCode) {
		super();
		this.friendCode = friendCode;
		this.memberCode = memberCode;
		this.groupCode = groupCode;
		this.friendMemberCode = friendMemberCode;
	}
	public FriendDTO() {
		super();
	}
	public String getFriendCode() {
		return friendCode;
	}
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getFriendMemberCode() {
		return friendMemberCode;
	}
	public void setFriendMemberCode(String friendMemberCode) {
		this.friendMemberCode = friendMemberCode;
	}
	
	
}
