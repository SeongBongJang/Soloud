package com.soloud.per.dto;
/**
 * ����ڵ忡 ���� ģ�������� ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * ����� ����ڵ�
	 */
	private String memberCode;
	/**
	 * ����̸�
	 */
	private String memberName;
	/**
	 * ģ�� ����� ����ڵ�
	 */
	private String friendMemberCode;
	/**
	 * ģ�� ����� ����̸�
	 */
	private String friendMemberName;
	/**
	 * ģ�� ���̵�
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
