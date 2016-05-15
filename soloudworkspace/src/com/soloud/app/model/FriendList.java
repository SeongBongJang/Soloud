package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;




/**
 * Friend객체의 의 목록형 클래스
 * @author oong
 *
 */
public class FriendList implements Serializable{
	
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 394204255079399932L;
	/**
	 * 회원마다의 친구목록을 표현하는 Collection
	 * 
	 */
	private Hashtable<String,ArrayList<Friend>> friends;
	/**
	 * FriendList 기본생성자
	 */
	public FriendList() {
		this(new Hashtable<String, ArrayList<Friend>>());
	}
	/**
	 * FriendList 오버로딩 생성자
	 * @param friends 회원마다의 친구목록
	 */
	public FriendList(Hashtable<String, ArrayList<Friend>> friends) {
		this.friends = friends;
	}

	/**
	 * 특정 회원의 친구목록에 친구를 추가하기위한 메소드
	 * @param id 회원 아이디
	 * @param friend Friend객체
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFriend(String id, Friend friend) {
		if(friends.get(id) == null){
			return false;
		} else {
			return friends.get(id).add(friend);
		}
	}
	
	/**
	 * 특정 회원의 친구목록에 친구를 추가하기위한 메소드
	 * @param id 회원 아아디
	 * @param friendId 친구 아이디
	 * @param friendName 친구이름
	 * @param groupKind 친구의 그룹 종류
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFriend(String id, String friendId, String friendName, Group groupKind) {
		if(friends.get(id) == null){
			return false;
		} else {
			return friends.get(id).add(new Friend(friendId, friendName, groupKind));
		}
	}
	
	/**
//	 * 회원의 친구목록에서 친구를 삭제하기위한 메소드
	 * @param id 회원 아이디
	 * @param friend Friend객체
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
	 * 회원의 친구목록에서 친구를 삭제하기위한 메소드
	 * @param id 회원 아이디
	 * @param friendId 친구 아이디
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
	 * 회원의 친구목록에서 친구의 정보를 수정하기위한 메소드
	 * @param id 회원아이디
	 * @param friendId 친구아이디
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
	 * 회원의 친구목록에서 친구의 정보를 수정하기위한 메소드
	 * @param id 회원아이디
	 * @param friendId 친구아이디
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
	 * 회원의 친구목록에서 친구를 검색하기위한 메소드
	 * @param id 회원아이디
	 * @param friendId 친구아이디
	 * @return Friend객체
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
	 * 회원의 친구목록에서 친구를 검색하기위한 메소드
	 * @param id 회원아이디
	 * @param friendName 친구이름
	 * @return 친구목록. 검색결과가 없을 시 null 리턴
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
	 * 회원의 친구목록에서 친구를 검색하기위한 메소드
	 * @param id 회원아이디
	 * @param groupKind 그룹종류
	 * @return 친구목록. 검색결과가 없을 시 null 리턴  
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
	 * 회원의 친구목록에서 친구를 검색하기위한 메소드
	 * @param id 회원아이디
	 * @param friendName 친구이름
	 * @param groupKind 그룹종류
	 * @return 친구목록. 검색결과가 없을 시 null 리턴
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
	 * @return 회원마다의 친구목록
	 */
	public Hashtable<String, ArrayList<Friend>> getFriends() {
		return friends;
	}
	/**
	 * setter
	 * @param friends 회원마다의 친구목록
	 */
	public void setFriends(Hashtable<String, ArrayList<Friend>> friends) {
		this.friends = friends;
	}
	/**
	 * 회원마다의 친구목록 데이터를 문자열화 하는 메소드
	 */
	@Override
	public String toString() {
		return "FriendList [friends=" + friends + "]";
	}
	
	
}
