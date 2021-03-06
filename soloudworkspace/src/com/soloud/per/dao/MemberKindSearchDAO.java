//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MemberKindSearchDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import java.util.List;

import com.soloud.per.dto.MemberKindDTO;
/**
 * 멤버유형 데이터를 조회하는 인터페이스
 * @author user 장성봉<hr>
 * 멤버유형 데이터베이스에서 지정한 데이터를 가지는
 * Record를 조회하는 인터페이스
 */
public interface MemberKindSearchDAO extends DAO
{
	/**
	 * 멤버유형 데이터베이스의 모든 Record를 조회하는 메소드
	 * @return  멤버유형코드,멤버이름을 캡슐화한 MemberKindDTO List 객체 
	 */
	public List<MemberKindDTO> searchAllMemberKind();
	/**
	 * 멤버유형 데이터베이스에서 지정한 멤버유형 코드 데이터를 가지는 Record를 조회하는메소드
	 * @param memberKindCode 멤버유형 코드
	 * @return 멤버유형코드,멤버이름을 캡슐화한 MemberKindDTO 객체
	 */
	public MemberKindDTO searchMemberKindCode(String memberKindCode);
	/**
	 * 멤버유형 데이터베이스에서 지정한 멤버유형이름데이터를 가지는 Record를 조회하는메소드
	 * @param memberKindName 멤버유형이름
	 * @return 멤버유형코드,멤버이름을 캡슐화한 MemberKindDTO List 객체
	 */
	public List<MemberKindDTO> searchMemberKindName(String memberKindName);
}
