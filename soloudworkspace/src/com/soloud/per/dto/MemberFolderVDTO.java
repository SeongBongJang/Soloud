package com.soloud.per.dto;
/**
 * 회원코드에 대한 폴더의 전체 정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class MemberFolderVDTO 
{
	@Override
	public String toString() {
		return "MemberFolderVDTO [memberCode=" + memberCode + ", folderCode="
				+ folderCode + ", folderName=" + folderName
				+ ", parentFolderCode=" + parentFolderCode + "]";
	}
	/**
	 * 사용자 멤버코드
	 */
	private String memberCode;
	/**
	 * 폴더 코드
	 */
	private String folderCode;
	/**
	 * 폴더이름
	 */
	private String folderName;
	/**
	 * 부모폴더코드
	 */
	private String parentFolderCode;
	public MemberFolderVDTO(String memberCode, String folderCode,
			String folderName, String parentFolderCode) {
		super();
		this.memberCode = memberCode;
		this.folderCode = folderCode;
		this.folderName = folderName;
		this.parentFolderCode = parentFolderCode;
	}
	public MemberFolderVDTO() {
		super();
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getFolderCode() {
		return folderCode;
	}
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getParentFolderCode() {
		return parentFolderCode;
	}
	public void setParentFolderCode(String parentFolderCode) {
		this.parentFolderCode = parentFolderCode;
	}
	
	
}
