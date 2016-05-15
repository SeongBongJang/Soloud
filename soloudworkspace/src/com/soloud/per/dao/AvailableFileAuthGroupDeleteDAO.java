//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : AvailableFileAuthGroupDeleteDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
/**
 * 사용가능한파일그룹 데이터를 삭제하는 인터페이스
 * @author 장성봉<hr>
 * 사용가능한파일그룹 데이터베이스에서 지정한 데이터를 가지는 <br>
 * Record를 삭제하는 인터페이스
 */
public interface AvailableFileAuthGroupDeleteDAO
{
	/**
	 * 사용가능한파일그룹 데이터베이스에서 지정한 파일코드를 가지는 사용가능한파일그룹 Record를 삭제하는 메소드
	 * @param fileCode 파일코드
	 * @return 성공적으로 삭제한 행의 개수
	 */
	public int deleteFileCode(String fileCode);
	/**
	 * 사용가능한파일그룹 데이터베이스에서 지정한 그룹코드를 가지는 사용가능한파일그룹 Record를 삭제하는 메소드 
	 * @param groupCode 그룹코드
	 * @return 성공적으로 삭제한 행의 개수
	 */
	public int deleteGroupCode(String groupCode);
	/**
	 *  사용가능한파일그룹 데이터베이스에서 지정한 파일코드와 그룹코드를 가지는 사용가능한파일그룹 Record를 삭제하는 메소드
	 * @param fileCode 파일코드
	 * @param groupCode 그룹코드
	 * @return 성공적으로 삭제한 행의 개수
	 */
	public int deleteFileCodeGroupCode(String fileCode, String groupCode);
}
