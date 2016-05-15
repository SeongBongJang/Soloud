package com.soloud.per.dto;
/**
 * 공유폴더 접근가능 친구정보를 캡슐화하고 있는 클래스
 * @author 장성봉
 *
 */
public class AvailableFolderFriendDTO 
{
	@Override
	public String toString() {
		return "AvailableFolderFriendDTO [friendCode=" + friendCode
				+ ", sharedFolderCode=" + sharedFolderCode + "]";
	}
	/**
	 * 친구의 멤버코드
	 */
	private String friendCode;
	/**
	 * 공유폴더 코드
	 */
	private String sharedFolderCode;
	/**
	 * 오버로디드 생성자
	 * @param friendCode 친구코드
	 * @param sharedFolderCode 공유폴더코드
	 */
	public AvailableFolderFriendDTO(String friendCode, String sharedFolderCode) {
		super();
		this.friendCode = friendCode;
		this.sharedFolderCode = sharedFolderCode;
	}
	/**
	 * 디폴트 생성자
	 */
	public AvailableFolderFriendDTO() {
		super();
	}
	/**
	 * 친구 멤버코드 getter 메소드
	 * @return 친구 멤버코드
	 */
	public String getFriendCode() {
		return friendCode;
	}
	/**
	 * 친구멤버코드 setter 메소드
	 * @param friendCode 친구멤버코드
	 */
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}
	/**
	 * 공유폴더 코드 getter 메소드
	 * @return 공유폴더 코드
	 */
	public String getSharedFolderCode() {
		return sharedFolderCode; 
	}
	/**
	 * 공유폴더 코드 setter 메소드
	 * @param sharedFolderCode 공유폴더 코드
	 */
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
}
