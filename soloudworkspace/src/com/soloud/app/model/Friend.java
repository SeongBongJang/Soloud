package com.soloud.app.model;

import java.io.Serializable;
/**
 * 친구의 정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class Friend implements Serializable {

	/**
	 *시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 7312962768182496088L;
	/**
	 * 친구의 아이디
	 */
	private String friendId;
	/**
	 * 친구의 이름
	 */
	private String friendName;
	/**
	 * 친구의 그룹종류
	 */
	private Group groupKind;
	
	/**
	 * Friend클래스 오버로딩 생성자 
	 * @param friendId 친구아이디
	 * @param friendName 친구이름
	 * @param groupKind 그룹종료
	 */ 
	public Friend(String friendId, String friendName, Group groupKind) {
		this.friendId = friendId;
		this.friendName = friendName;
		this.groupKind = groupKind;
	}
	/**
	 * Friend클래스 오버로딩 생성자
	 * @param friendId 친구아이디
	 * @param friendName 친구이름
	 */
	public Friend(String friendId, String friendName) {
		this.friendId = friendId;
		this.friendName = friendName;
	}
	/**
	 * Friend클래스 오버로딩 생성자
	 * @param friendId 친구아이디
	 */
	public Friend(String friendId) {
		this.friendId = friendId;
	}
	/**
	 * Friend클래스 기본 생성자
	 */
	public Friend() {
	}
	/**
	 * getter
	 * @return
	 */
	public String getFriendId() {
		return friendId;
	}
	/**
	 * setter
	 * @param friendId
	 */
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	/**
	 * getter
	 * @return
	 */
	public String getFriendName() {
		return friendName;
	}
	/**
	 * setter
	 * @param friendName
	 */
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	/**
	 * getter
	 * @return
	 */
	public Group getGroupKind() {
		return groupKind;
	}
	/**
	 * setter
	 * @param groupKind
	 */
	public void setGroupKind(Group groupKind) {
		this.groupKind = groupKind;
	}
	/**
	 * Friend객체의 데이터를 문자열화하는 메소드
	 */
	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", friendName=" + friendName
				+ "]";
	}
	
}
