//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MemberFriendVDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import java.util.List;

import com.soloud.per.dto.MemberFriendVDTO;
/**
 * 멤버에 대한 친구정보를 조회하는 VIEW 인터페이스
 * @author 장성봉<hr>
 * 멤버 데이터베이스 ,친구 데이터베이스에서 멤버에 대한 <br>
 * 친구정보를 조회하는 VIEW 인터페이스 *
 */
public interface MemberFriendVDAO
{
	/**
	 * 멤버 데이터베이스 ,친구 데이터베이스의 모든 멤버에  대한 친구정보를 <br>
	 * 조회하는 VIEW 인터페이스
	 * @return 내 코드,내 이름,친구 코드,친구 이름을 캡슐화한 MemberFriendVDTO List 객체
	 */
	public List<MemberFriendVDTO> searchMemberFriend();
	/**
	 * 멤버 데이터베이스 ,친구 데이터베이스에서 지정한 멤버코드 데이터를 가지는 멤버에대한 친구정보를<br>
	 * 조회하는 메소드
	 * @param memberCode 멤버 코드
	 * @return 내 코드,내 이름,친구 코드,친구 이름을 캡슐화한 MemberFriendVDTO List 객체
	 */
	public List<MemberFriendVDTO> searchMemberFriend(String memberCode);
}
