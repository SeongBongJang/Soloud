package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;




/**
 * Friend��ü�� �� ����� Ŭ����
 * @author oong
 *
 */
public class FriendList implements Serializable{
	
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 394204255079399932L;
	/**
	 * ȸ�������� ģ������� ǥ���ϴ� Collection
	 * 
	 */
	private Hashtable<String,ArrayList<Friend>> friends;
	/**
	 * FriendList �⺻������
	 */
	public FriendList() {
		this(new Hashtable<String, ArrayList<Friend>>());
	}
	/**
	 * FriendList �����ε� ������
	 * @param friends ȸ�������� ģ�����
	 */
	public FriendList(Hashtable<String, ArrayList<Friend>> friends) {
		this.friends = friends;
	}

	/**
	 * Ư�� ȸ���� ģ����Ͽ� ģ���� �߰��ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param friend Friend��ü
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFriend(String id, Friend friend) {
		if(friends.get(id) == null){
			return false;
		} else {
			return friends.get(id).add(friend);
		}
	}
	
	/**
	 * Ư�� ȸ���� ģ����Ͽ� ģ���� �߰��ϱ����� �޼ҵ�
	 * @param id ȸ�� �ƾƵ�
	 * @param friendId ģ�� ���̵�
	 * @param friendName ģ���̸�
	 * @param groupKind ģ���� �׷� ����
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFriend(String id, String friendId, String friendName, Group groupKind) {
		if(friends.get(id) == null){
			return false;
		} else {
			return friends.get(id).add(new Friend(friendId, friendName, groupKind));
		}
	}
	
	/**
//	 * ȸ���� ģ����Ͽ��� ģ���� �����ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param friend Friend��ü
	 */
	public void deleteFriend(String id, Friend friend) {
		if(friends.get(id)==null){
			return;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			friends.remove(friend);
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� �����ϱ����� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param friendId ģ�� ���̵�
	 */
	public void deleteFriend(String id, String friendId) {
		if(friends.get(id)==null){
			return;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getFriendId().equals(friendId)){
					friends.remove(i);
					return;
				}
			}
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� ������ �����ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param friendId ģ�����̵�
	 * @param newFriend
	 */
	public void modifyFriend(String id, String friendId, Friend newFriend) {
		if(friends.get(id)==null){
			return;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getFriendId().equals(friendId)){
					friends.set(i, newFriend);
					return;
				}
			}
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� ������ �����ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param friendId ģ�����̵�
	 * @param groupKind
	 */
	public void modifyFriend(String id, String friendId, Group groupKind) {
		if(friends.get(id)==null){
			return;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getFriendId().equals(friendId)){
					friends.get(i).setGroupKind(groupKind);
					return;
				}
			}
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� �˻��ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param friendId ģ�����̵�
	 * @return Friend��ü
	 */
	public Friend searchFriendId(String id, String friendId) {
		if(friends.get(id)==null){
			return null;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getFriendId().equals(id)){
					return friends.get(i);
				}
			}
			return null;
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� �˻��ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param friendName ģ���̸�
	 * @return ģ�����. �˻������ ���� �� null ����
	 */
	public ArrayList<Friend> searchFriendName(String id, String friendName) {
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		if(friends.get(id)==null){
			return null;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getFriendName().equals(friendName)){
					returnList.add(friends.get(i));
				}
			}
			return returnList;
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� �˻��ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param groupKind �׷�����
	 * @return ģ�����. �˻������ ���� �� null ����  
	 */
	public ArrayList<Friend> searchFriendGroup(String id, Group groupKind) {
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		if(friends.get(id)==null){
			return null;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getGroupKind().value().equals(groupKind.value())){
					returnList.add(friends.get(i));
				}
			}
			return returnList;
		}
	}
	
	/**
	 * ȸ���� ģ����Ͽ��� ģ���� �˻��ϱ����� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param friendName ģ���̸�
	 * @param groupKind �׷�����
	 * @return ģ�����. �˻������ ���� �� null ����
	 */
	public ArrayList<Friend> searchFriend(String id, String friendName, Group groupKind) {
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		if(friends.get(id)==null){
			return null;
		} else {
			ArrayList<Friend> friends = this.friends.get(id);
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).getFriendName().equals(friendName) && friends.get(i).getGroupKind().value().equals(groupKind.value())){
					returnList.add(friends.get(i));
				}
			}
			return returnList;
		}
	}
	/**
	 * getter
	 * @return ȸ�������� ģ�����
	 */
	public Hashtable<String, ArrayList<Friend>> getFriends() {
		return friends;
	}
	/**
	 * setter
	 * @param friends ȸ�������� ģ�����
	 */
	public void setFriends(Hashtable<String, ArrayList<Friend>> friends) {
		this.friends = friends;
	}
	/**
	 * ȸ�������� ģ����� �����͸� ���ڿ�ȭ �ϴ� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "FriendList [friends=" + friends + "]";
	}
	
	
}
