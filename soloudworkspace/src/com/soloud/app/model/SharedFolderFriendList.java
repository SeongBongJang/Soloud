package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * �������� ģ������� �����ϱ����� Ŭ����
 * @author oong
 *
 */
public class SharedFolderFriendList implements Serializable{
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 9147876583330351754L;

	/**
	 * �� ���������� ����ģ�����
	 */
	private Hashtable<String, ArrayList<Friend>> sharedFolderFriends;
	
	

	/**
	 * SharedFolderFriendList �⺻������
	 */
	public SharedFolderFriendList() {
		this(new Hashtable<String, ArrayList<Friend>>());
	}
	/**
	 * SharedFolderFriendList �����ε� ������
	 * @param sharedFolderFriends ��������ģ�����
	 */
	public SharedFolderFriendList(
			Hashtable<String, ArrayList<Friend>> sharedFolderFriends) {
		this.sharedFolderFriends = sharedFolderFriends;
	}

	/**
	 * 
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ������������ ģ����Ͽ� ģ�������� �߰��ϱ����� �޼ҵ�
	 * @return ģ���߰��� ���� ��������. ������ true, ���н� false
	 */
	public boolean addFriend(String sharedFolderCode, Friend friend) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			sharedFolderFriends.put(sharedFolderCode, new ArrayList<Friend>());
		}
		return sharedFolderFriends.get(sharedFolderCode).add(friend);
	}
	
	/**
	 * ���������� ģ����Ͽ� ģ�������� �߰��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friendId �߰��� ģ��
	 * @param friendName ģ���̸� �߰��� ģ��
	 * @param groupKind �׷�����
	 * @return ģ���߰��� ���� ��������. ������ true, ���н� false
	 */
	public boolean addFriend(String sharedFolderCode, String friendId, String friendName, Group groupKind) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			sharedFolderFriends.put(sharedFolderCode, new ArrayList<Friend>());
		}
		return sharedFolderFriends.get(sharedFolderCode).add(new Friend(friendId, friendName, groupKind));
	}
	
	/**
	 * ���������� ģ����Ͽ��� ģ�������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��
	 */
	public void deleteFriend(String sharedFolderCode, Friend friend) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			sharedFolderFriends.get(sharedFolderCode).remove(friend);
		}
	}
	
	/**
	 * ���������� ģ����Ͽ��� ģ�������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��Id
	 */
	public void deleteFriend(String sharedFolderCode, String friendId) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendId().equals(friendId)){
					friendList.remove(i);
					return;
				}
			}
		}
	}
	
	/**
	 * ���������� ģ����Ͽ��� ģ�������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 */
	public void deleteFriend(String sharedFolderCode) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			sharedFolderFriends.remove(sharedFolderCode);
		}
	}
	
	/**
	 * �������� �� ��������ģ����Ͽ��� ģ�������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��Id
	 * @param newFriend ���Ӱ� ������ ģ������ Friend��ü
	 */
	public void modifyFriend(String sharedFolderCode, String friendId, Friend newFriend) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendId().equals(friendId)){
					friendList.set(i, newFriend);
					return;
				}
			}
		}
	}
	
	/**
	 * �������� �� ��������ģ����Ͽ��� ģ�������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��Id
	 * @param newFriendName ���Ӱ� ������ ģ���̸�
	 */
	public void modifyFriend(String sharedFolderCode, String friendId, String newFriendName) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendId().equals(friendId)){
					friendList.get(i).setFriendName(newFriendName);
					return;
				}
			}
		}
	}
	
	/**
	 * �������� �� ��������ģ����Ͽ��� ģ�������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��Id
	 * @param newGroupKind ���Ӱ� ������ �׷�����
	 */
	public void modifyFriend(String sharedFolderCode, String friendId, Group newGroupKind) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendId().equals(friendId)){
					friendList.get(i).setGroupKind(newGroupKind);
					return;
				}
			}
		}
	}
	/**
	 * ���������� ��������ģ����Ͽ��� ģ�������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��Id
	 * @return ģ������. �˻������ �������� ���� ��� null ����
	 */
	public Friend searchFriendId(String sharedFolderCode, String friendId) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return null;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendId().equals(friendId)){
					return friendList.get(i);
				}
			}
			return null;
		}
	}
	
	/**
	 * ���������� ��������ģ����Ͽ��� ģ�������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friend �߰��� ģ��Name
	 * @return ģ�����. �˻������ �������� ���� ��� null ����
	 */
	public ArrayList<Friend> searchFriendName(String sharedFolderCode, String friendName) {
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return null;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendName().equals(friendName)){
					returnList.add(friendList.get(i));
				}
			}
			if(returnList.isEmpty()){
				return null;
			}
			return returnList;
		}
	}
	
	/**
	 * ���������� ��������ģ����Ͽ��� ģ�������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param groupKind �׷�����
	 * @return ģ�����. �˻������ �������� ���� ��� null ����
	 */
	public ArrayList<Friend> searchFriendGroupKind(String sharedFolderCode, Group groupKind) {
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return null;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getGroupKind().value().equals(groupKind.value())){
					returnList.add(friendList.get(i));
				}
			}
			if(returnList.isEmpty()){
				return null;
			}
			return returnList;
		}
	}
	
	/**
	 * ���������� ��������ģ����Ͽ��� ģ�������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� ���������ڵ�
	 * @param friendName ģ���̸�
	 * @param groupKind �׷�����
	 * @return ģ�����. �˻������ �������� ���� ��� null ����
	 */
	public ArrayList<Friend> searchFriend(String sharedFolderCode, String friendName, Group groupKind) {
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return null;
		} else {
			ArrayList<Friend> friendList = sharedFolderFriends.get(sharedFolderCode);
			for(int i=0;i<friendList.size();i++){
				if(friendList.get(i).getFriendName().equals(friendName) && friendList.get(i).getGroupKind().value().equals(groupKind.value())){
					returnList.add(friendList.get(i));
				}
			}
			if(returnList.isEmpty()){
				return null;
			}
			return returnList;
		}
	}
	/**
	 * ���������� ��������ģ����Ͽ��� ģ�������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ� 
	 * @return ģ�����. �˻������ �������� ���� ��� null ����
	 */
	public ArrayList<Friend> searchFriendAll(String sharedFolderCode){
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return null;
		} 
		return sharedFolderFriends.get(sharedFolderCode);
	}
	/**
	 * getter
	 * @return
	 */
	public Hashtable<String, ArrayList<Friend>> getSharedFolderFriends() {
		return sharedFolderFriends;
	}
	/**
	 * setter
	 * @param sharedFolderFriends ��������ģ�����
	 */
	public void setSharedFolderFriends(
			Hashtable<String, ArrayList<Friend>> sharedFolderFriends) {
		this.sharedFolderFriends = sharedFolderFriends;
	}
	/**
	 * �� ȸ���� ��������ģ������� ���ڿ�ȭ �ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "SharedFolderFriendList [sharedFolderFriends="
				+ sharedFolderFriends + "]";
	}
	
	
}
