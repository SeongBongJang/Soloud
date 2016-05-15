//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : AvailableFileAuthGroupInsertDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import com.soloud.per.dto.AvailableFileAuthGroupDTO;
/**
 * 사용가능한파일그룹 데이터를 추가하는 인터페이스
 * @author user
 * 사용가능한파일그룹 데이터베이스에서 지정한 데이터를 가지는<br>
 * 사용가능한파일그룹 Record를 추가하는 인터페이스
 */
public interface AvailableFileAuthGroupInsertDAO
{
	/**
	 * 사용가능한파일그룹 데이터베이스에서 지정한 AvailableFileAuthGroupDTO를<br>
	 * 가지는 Record를 추가하는 메소드 
	 * @param dto AvailableFileAuthGroupDTO타입의 객체
	 * @return 성공적으로 추가한 경우 -true
	 */
	public boolean insertAFAG(AvailableFileAuthGroupDTO dto);
}
