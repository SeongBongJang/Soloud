//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : AvailableFolderAuthFriendInsertDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import com.soloud.per.dto.AvailableFolderFriendDTO;
/**
 * 공유폴더친구 데이터를 추가하는 인터페이스
 * @author 장성봉<hr>
 * 공유폴더친구 데이터베이스에서 지정한 데이터를 가지는 공유폴더친구 Record를 추가하는 인터페이스
 */
public interface AvailableFolderFriendInsertDAO
{
	/**
	 * 공유폴더친구 데이터베이스에 AvailableFolderFriendDTO정보를 가지는 공유폴더친구데이터를 추가하는 메소드
	 * @param dto AvailableFolderFriendDTO 객체
	 * @return 성공적으로 추가한 경우 -true
	 */
	public boolean insertAFF(AvailableFolderFriendDTO dto);
}
