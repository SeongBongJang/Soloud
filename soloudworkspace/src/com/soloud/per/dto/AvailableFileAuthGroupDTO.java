package com.soloud.per.dto;
/**
 * 공유파일그룹정보를 캡슐화하고 있는 클래스
 * @author 장성봉
 *
 */
public class AvailableFileAuthGroupDTO 
{
	@Override
	public String toString() {
		return "AvailableFileAuthGroupDTO [fileCode=" + fileCode
				+ ", groupCode=" + groupCode + "]";
	}
	/**
	 * 파일코드
	 */
	private String fileCode;
	/**
	 * 그룹코드
	 */
	private String groupCode;
	/**
	 * 파일코드 getter메소드
	 * @return 파일코드
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * Defalut 생성자
	 */
	public AvailableFileAuthGroupDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param fileCode 파일코드
	 * @param groupCode 그룹코드
	 */
	public AvailableFileAuthGroupDTO(String fileCode, String groupCode) {
		super();
		this.fileCode = fileCode;
		this.groupCode = groupCode;
	}
	/**
	 * 파일코드 setter메소드
	 * @param fileCode 파일코드
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * 그룹코드 getter 메소드
	 * @return 그룹코드
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * 그룹코드 setter 메소드
	 * @param groupCode 그룹코드
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
	
}
