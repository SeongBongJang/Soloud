//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : GroupSearchDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import java.util.List;

import com.soloud.per.dto.GroupDTO;
/**
 * 그룹 데이터를 조회하는 인터페이스
 * @author 장성봉<hr>
 * 그룹 데이터베이스에서 지정한 데이터를 가지는 <br>
 * Record를 조회하는 인터페이스
 */
public interface GroupSearchDAO
{
	/**
	 * 그룹 데이터베이스의 모든 Record를 조회하는 메소드
	 * @return 찾은 Record 데이터를 캡슐화한 GroupDTO List 객체
	 */
	public List<GroupDTO> searchAllGroup();
	/**
	 * 그룹 데이터베이스에서 지정한 그룹코드 데이터를 가지는<br>
	 * Record를 조회하는 메소드
	 * @param groupCode 그룹코드
	 * @return 찾은 Record 데이터를 캡슐화한 GroupDTO 객체
	 */
	public GroupDTO searchGroupCode(String groupCode);
	/**
	 * 그룹 데이터베이스에서 지정한 멤버코드 데이터를 가지는<br>
	 * Record를 조회하는 메소드	 
	 * @param memberCode 멤버코드
	 * @return 찾은 Record 데이터를 캡슐화한 GroupDTO List 객체
	 */
	public List<GroupDTO> searchMemberCode(String memberCode);
	/**
	 * 그룹 데이터베이스에서 지정한 그룹이름 데이터를 가지는<br>
	 * Record를 조회하는 메소드
	 * @param groupName 그룹이름
	 * @return 찾은 Record 데이터를 캡슐화한 GroupDTO List 객체
	 */
	public List<GroupDTO> searchGroupName(String groupName);
	/**
	 * 그룹 데이터베이스에서 지정한 멤버코드,그룹이름 데이터를 가지는<br>
	 * Record를 조회하는 메소드
	 * @param memberCode 멤버코드
	 * @param groupName 그룹이름 
	 * @return 찾은 Record 데이터를 캡슐화한 GroupDTO 객체
	 */
	public GroupDTO searchMemberCodeGroupName(String memberCode, String groupName);
}
