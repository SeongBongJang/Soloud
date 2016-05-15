package com.soloud.per.dao;

import java.util.List;

import com.soloud.per.dto.MemberFileAuthVDTO;

/**
 * 특정회원에 대해 접근 가능한 파일을 검색할 수 있는 인터페이스
 * @author BK
 *
 */
public interface MemberFileAuthVDAO 
{
	//업로더아이디, 업로더이름, 파일명, 
	//파일유형별
	/**
	 * 모든 회원의 접근 가능한 파일 리스트를 가져온다
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchAllMemberFileAuth();
	/**
	 * 회원코드에 해당하는 회원에 대해 접근 가능한 모든 파일의 정보를 가져온다
	 * @param memberCode 멤버코드
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuth(String memberCode);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 업로더 코드에 해당하는 회원이 업로드한 파일의 정보만 가져온다. 
	 * @param memberCode 멤버코드
	 * @param uploaderCode 업로더 코드
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderCode(String memberCode, String uploaderCode);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 업로더 이름에 해당하는 회원이 업로드한 파일의 정보만 가져온다. 
	 * @param memberCode 멤버코드
	 * @param uploaderName 업로더이름
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderName(String memberCode, String uploaderName);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 검색하려는 파일명이 들어가는 파일의 정보만 가져온다. 
	 * @param memberCode 멤버코드
	 * @param fileName 파일이름
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileName(String memberCode, String fileName);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 특정 타입의 파일에 대한 정보를 가져온다
	 * @param memberCode 멤버코드
	 * @param fileType 멤버코드
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileType(String memberCode, String fileType);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 특정 업로더 코드와 파일타입에 해당하는 파일의 정보를 가져온다
	 * @param memberCode 멤버코드
	 * @param uploaderCode 업로더코드
	 * @param fileType 파일타입
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderCode(String memberCode, String uploaderCode, String fileType);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 특정 업로더 이름과 파일타입에 해당하는 파일의 정보를 가져온다.
	 * @param memberCode 멤버코드
	 * @param uploaderName 업로더 이름
	 * @param fileType 파일타입 
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderName(String memberCode, String uploaderName, String fileType);
	/**
	 * 멤버코드에 해당하는 회원이 접근 가능한 파일 중 특정 업로더 일므과 파일타입에 해당하는 파일의 정보를 가져온다.
	 * @param memberCode 멤버코드
	 * @param fileName 파일이름
	 * @param fileType 파일 타입
	 * @return 접근가능한 모든 파일의 리스트
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileNameFileType(String memberCode, String fileName, String fileType);
	
	
}
