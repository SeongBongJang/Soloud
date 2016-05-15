//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MemberSearchDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;//
import java.util.List;

import com.soloud.per.dto.MemberDTO;
/**
 * 멤버데이터를 조회하는 인터페이스
 * @author 장성봉<hr>
 * 멤버데이터베이스에서 지정한 데이터를 가지는 Record를 조회하는 인터페이스
 */
public interface MemberSearchDAO
{
	/**
	 * 멤버데이터베이스의 모든 Record를 조회하는 메소드
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO List 객체
	 */
	public List<MemberDTO> searchAllMember();
	/**
	 * 멤버데이터베이스에서 지정한 멤버코드 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberCode 멤버코드
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO 객체
	 */ 
	public MemberDTO searchMemberCode(String memberCode);
	/**
	 * 멤버데이터베이스에서 지정한 멤버유형코드 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberKindCode 멤버유형코드
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO List 객체
	 */
	public List<MemberDTO> searchMemberKindCode(String memberKindCode);
	/**
	 * 멤버데이터베이스에서 지정한 멤버아이디 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberId 멤버아이디
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO 객체
	 */ 
	public MemberDTO searchMemberId(String memberId);
	/**
	 * 멤버데이터베이스에서 지정한 멤버의 용량 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberLimitCapacity 멤버의 용량
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO List 객체
	 */
	public List<MemberDTO> searchMemberLimitCapacity(double memberLimitCapacity);
	/**
	 * 멤버데이터베이스에서 지정한 멤버이름 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberName
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO List 객체
	 */
	public List<MemberDTO> searchMemberName(String memberName);
	/**
	 * 멤버데이터베이스에서 지정한 멤버아이디, 멤버비밀번호 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberId 멤버아이디
	 * @param memberPwd 멤버비밀번호
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO 객체
	 */
	public MemberDTO searchMemberIdPwd(String memberId, String memberPwd);
	/**
	 * 멤버데이터베이스에서 지정한 멤버아이디,멤버이름 데이터를 가지는 Record를 조회하는 인터페이스
	 * @param memberId 멤버아이디
	 * @param memberName 멤버이름
	 * @return 멤버정보를 캡슐화하고 있는 MemberDTO 객체
	 */
	public MemberDTO searchMemberIdName(String memberId, String memberName);
	public String searchMemberAdmin(String memberId);
}
