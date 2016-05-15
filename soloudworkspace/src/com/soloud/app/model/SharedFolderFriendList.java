package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 공유폴더 친구목록을 관리하기위한 클래스
 * @author oong
 *
 */
public class SharedFolderFriendList implements Serializable{
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 9147876583330351754L;

	/**
	 * 각 공유폴더별 공유친구목록
	 */
	private Hashtable<String, ArrayList<Friend>> sharedFolderFriends;
	
	

	/**
	 * SharedFolderFriendList 기본생성자
	 */
	public SharedFolderFriendList() {
		this(new Hashtable<String, ArrayList<Friend>>());
	}
	/**
	 * SharedFolderFriendList 오버로딩 생성자
	 * @param sharedFolderFriends 공유폴더친구목록
	 */
	public SharedFolderFriendList(
			Hashtable<String, ArrayList<Friend>> sharedFolderFriends) {
		this.sharedFolderFriends = sharedFolderFriends;
	}

	/**
	 * 
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구공유폴더별 친구목록에 친구정보를 추가하기위한 메소드
	 * @return 친구추가에 대한 성공여부. 성공시 true, 실패시 false
	 */
	public boolean addFriend(String sharedFolderCode, Friend friend) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			sharedFolderFriends.put(sharedFolderCode, new ArrayList<Friend>());
		}
		return sharedFolderFriends.get(sharedFolderCode).add(friend);
	}
	
	/**
	 * 공유폴더별 친구목록에 친구정보를 추가하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friendId 추가할 친구
	 * @param friendName 친구이름 추가할 친구
	 * @param groupKind 그룹종류
	 * @return 친구추가에 대한 성공여부. 성공시 true, 실패시 false
	 */
	public boolean addFriend(String sharedFolderCode, String friendId, String friendName, Group groupKind) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			sharedFolderFriends.put(sharedFolderCode, new ArrayList<Friend>());
		}
		return sharedFolderFriends.get(sharedFolderCode).add(new Friend(friendId, friendName, groupKind));
	}
	
	/**
	 * 공유폴더별 친구목록에서 친구정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구
	 */
	public void deleteFriend(String sharedFolderCode, Friend friend) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			sharedFolderFriends.get(sharedFolderCode).remove(friend);
		}
	}
	
	/**
	 * 공유폴더별 친구목록에서 친구정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구Id
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
	 * 공유폴더별 친구목록에서 친구정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 */
	public void deleteFriend(String sharedFolderCode) {
		if(sharedFolderFriends.get(sharedFolderCode) == null){
			return;
		} else {
			sharedFolderFriends.remove(sharedFolderCode);
		}
	}
	
	/**
	 * 공유폴더 별 공유폴더친구목록에서 친구정보를 수정하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구Id
	 * @param newFriend 새롭게 적용할 친구정보 Friend객체
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
	 * 공유폴더 별 공유폴더친구목록에서 친구정보를 수정하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구Id
	 * @param newFriendName 새롭게 적용할 친구이름
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
	 * 공유폴더 별 공유폴더친구목록에서 친구정보를 수정하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구Id
	 * @param newGroupKind 새롭게 적용할 그룹종류
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
	 * 공유폴더별 공유폴더친구목록에서 친구정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구Id
	 * @return 친구정보. 검색결과가 존재하지 않을 경우 null 리턴
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
	 * 공유폴더별 공유폴더친구목록에서 친구정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friend 추가할 친구Name
	 * @return 친구목록. 검색결과가 존재하지 않을 경우 null 리턴
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
	 * 공유폴더별 공유폴더친구목록에서 친구정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param groupKind 그룹종류
	 * @return 친구목록. 검색결과가 존재하지 않을 경우 null 리턴
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
	 * 공유폴더별 공유폴더친구목록에서 친구정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 공유폴더코드
	 * @param friendName 친구이름
	 * @param groupKind 그룹종류
	 * @return 친구목록. 검색결과가 존재하지 않을 경우 null 리턴
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
	 * 공유폴더별 공유폴더친구목록에서 친구정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드 
	 * @return 친구목록. 검색결과가 존재하지 않을 경우 null 리턴
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
	 * @param sharedFolderFriends 공유폴더친구목록
	 */
	public void setSharedFolderFriends(
			Hashtable<String, ArrayList<Friend>> sharedFolderFriends) {
		this.sharedFolderFriends = sharedFolderFriends;
	}
	/**
	 * 각 회원의 공유폴더친구목록을 문자열화 하기위한 메소드
	 */
	@Override
	public String toString() {
		return "SharedFolderFriendList [sharedFolderFriends="
				+ sharedFolderFriends + "]";
	}
	
	
}
