package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.Friend;

public interface FriendSearchable {
	/**
	 * ģ�� �˻� �޼ҵ�
	 * @param id ����� ���̵�(�ڵ�)
	 * @param friendId ã�� ģ�� ���̵�(�ڵ�)
	 * @return
	 */
	public Friend searchFriendId(String id,String friendId);
	/**
	 * ģ�� �˻� �޼ҵ�<br>
	 * -�̸����� �˻��ϴ� dao�� ���� ����
	 * @param id ����� ���̵�(�ڵ�)
	 * @param friendName ã�� ģ�� �̸�(�ڵ�)
	 * @return
	 */
	public ArrayList<Friend> searchFriendName(String id, String friendName);
	/**
	 * ģ�� �˻� �޼ҵ�<br>
	 * @param id ����� ���̵�(�ڵ�)
	 * @param groupKind �׷��̸�
	 * @return
	 */
	public ArrayList<Friend> searchFriendGroupKind(String id,String groupKind);
	/**
	 * ģ�� �˻� �޼ҵ�
	 * @param id ����� ���̵�(�ڵ�)
	 * @return
	 */
	public ArrayList<Friend> searchFriendList(String id);
}
