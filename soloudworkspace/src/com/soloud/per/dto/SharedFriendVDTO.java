package com.soloud.per.dto;
/**
 * ���������� ���� �����ϴ� ģ�������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class SharedFriendVDTO 
{

	/**
	 * �������� �ڵ�
	 */
	private String sharedFolderCode;
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	@Override
	public String toString() {
		return "SharedFriendVDTO [sharedFolderCode=" + sharedFolderCode
				+ ", memberCode=" + memberCode + ", memberName=" + memberName
				+ ", friendCode=" + friendCode + ", friendName=" + friendName
				+ ", friendId=" + friendId + "]";
	}
	public SharedFriendVDTO(){}
	public SharedFriendVDTO(String sharedFolderCode, String memberCode,
			String memberName, String friendCode, String friendName,
			String friendId) {
		super();
		this.sharedFolderCode = sharedFolderCode;
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.friendCode = friendCode;
		this.friendName = friendName;
		this.friendId = friendId;
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
	public String getFriendCode() {
		return friendCode;
	}
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	/**
	 * ����ڵ�
	 */
	private String memberCode;
	/**
	 * ����̸�
	 */
	private String memberName;
	/**
	 * ģ���ڵ�
	 */
	private String friendCode;
	/**
	 * ģ���̸�
	 */
	private String friendName;
	/**
	 * ģ�����̵�(�̸���)
	 */
	private String friendId;

}
