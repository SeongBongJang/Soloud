package com.soloud.per.dto;
/**
 * ģ�������� ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * ����� ģ�������� ���� ������ �ڵ�
	 */
	private String friendCode;
	/**
	 * ����� �ڵ�
	 */
	private String memberCode;
	/**
	 * ������� �׷��ڵ�
	 */
	private String groupCode;
	/**
	 * ģ���� ����ڵ�
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
