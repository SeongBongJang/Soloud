package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.Friend;

public interface FriendSearchable {
	/**
	 * 친구 검색 메소드
	 * @param id 사용자 아이디(코드)
	 * @param friendId 찾을 친구 아이디(코드)
	 * @return
	 */
	public Friend searchFriendId(String id,String friendId);
	/**
	 * 친구 검색 메소드<br>
	 * -이름으로 검색하는 dao가 현재 없음
	 * @param id 사용자 아이디(코드)
	 * @param friendName 찾을 친구 이름(코드)
	 * @return
	 */
	public ArrayList<Friend> searchFriendName(String id, String friendName);
	/**
	 * 친구 검색 메소드<br>
	 * @param id 사용자 아이디(코드)
	 * @param groupKind 그룹이름
	 * @return
	 */
	public ArrayList<Friend> searchFriendGroupKind(String id,String groupKind);
	/**
	 * 친구 검색 메소드
	 * @param id 사용자 아이디(코드)
	 * @return
	 */
	public ArrayList<Friend> searchFriendList(String id);
}
