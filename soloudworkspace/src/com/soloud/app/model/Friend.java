package com.soloud.app.model;

import java.io.Serializable;
/**
 * ģ���� ������ ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class Friend implements Serializable {

	/**
	 *�ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 7312962768182496088L;
	/**
	 * ģ���� ���̵�
	 */
	private String friendId;
	/**
	 * ģ���� �̸�
	 */
	private String friendName;
	/**
	 * ģ���� �׷�����
	 */
	private Group groupKind;
	
	/**
	 * FriendŬ���� �����ε� ������ 
	 * @param friendId ģ�����̵�
	 * @param friendName ģ���̸�
	 * @param groupKind �׷�����
	 */ 
	public Friend(String friendId, String friendName, Group groupKind) {
		this.friendId = friendId;
		this.friendName = friendName;
		this.groupKind = groupKind;
	}
	/**
	 * FriendŬ���� �����ε� ������
	 * @param friendId ģ�����̵�
	 * @param friendName ģ���̸�
	 */
	public Friend(String friendId, String friendName) {
		this.friendId = friendId;
		this.friendName = friendName;
	}
	/**
	 * FriendŬ���� �����ε� ������
	 * @param friendId ģ�����̵�
	 */
	public Friend(String friendId) {
		this.friendId = friendId;
	}
	/**
	 * FriendŬ���� �⺻ ������
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
	 * Friend��ü�� �����͸� ���ڿ�ȭ�ϴ� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", friendName=" + friendName
				+ "]";
	}
	
}
