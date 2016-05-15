package com.soloud.per.dto;
/**
 * 공유폴더에 대한 공유하는 친구정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class SharedFriendVDTO 
{

	/**
	 * 공유폴더 코드
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
	 * 멤버코드
	 */
	private String memberCode;
	/**
	 * 멤버이름
	 */
	private String memberName;
	/**
	 * 친구코드
	 */
	private String friendCode;
	/**
	 * 친구이름
	 */
	private String friendName;
	/**
	 * 친구아이디(이메일)
	 */
	private String friendId;

}
