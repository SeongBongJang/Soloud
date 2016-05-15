package com.soloud.per.dto;
/**
 * 파일코드에 대하여 접근가능 그룹의 정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class FileGroupVDTO 
{
	@Override
	public String toString() {
		return "FileGroupVDTO [fileCode=" + fileCode + ", groupCode="
				+ groupCode + ", groupName=" + groupName + ", memberCode="
				+ memberCode + "]";
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
	 * 그룹이름
	 */
	private String groupName;
	/**
	 * 멤버코드
	 */
	private String memberCode;
	public FileGroupVDTO() {
		super();
	}
	public FileGroupVDTO(String fileCode, String groupCode, String groupName,
			String memberCode) {
		super();
		this.fileCode = fileCode;
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.memberCode = memberCode;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
}
