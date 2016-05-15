package com.soloud.per.dto;
/**
 * 하나의 폴더정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class FolderDTO 
{
	@Override
	public String toString() {
		return "FolderDTO [folderCode=" + folderCode + ", memberCode="
				+ memberCode + ", parentFolderCode=" + parentFolderCode
				+ ", folderName=" + folderName + ", isShareFolder="
				+ isShareFolder + ", folderUrl=" + folderUrl + "]";
	}
	/**
	 * 폴더의 고유한 코드
	 */
	private String folderCode;
	/**
	 * 사용자 멤버코드(업로더코드)
	 */
	private String memberCode;
	/**
	 * 소속된 부모 폴더 코드
	 */
	private String parentFolderCode;
	/**
	 * 폴더이름
	 */
	private String folderName;
	/**
	 * 공유폴더여부
	 */
	private String isShareFolder;
	/**
	 * 폴더 url
	 */
	private String folderUrl;
	public FolderDTO() {
		super();
	}
	public FolderDTO(String folderCode, String memberCode,
			String parentFolderCode, String folderName, String isShareFolder,
			String folderUrl) {
		super();
		this.folderCode = folderCode;
		this.memberCode = memberCode;
		this.parentFolderCode = parentFolderCode;
		this.folderName = folderName;
		this.isShareFolder = isShareFolder;
		this.folderUrl = folderUrl;
	}
	public String getFolderCode() {
		return folderCode;
	}
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getParentFolderCode() {
		return parentFolderCode;
	}
	public void setParentFolderCode(String parentFolderCode) {
		this.parentFolderCode = parentFolderCode;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getIsShareFolder() {
		return isShareFolder;
	}
	public void setIsShareFolder(String isShareFolder) {
		this.isShareFolder = isShareFolder;
	}
	public String getFolderUrl() {
		return folderUrl;
	}
	public void setFolderUrl(String folderUrl) {
		this.folderUrl = folderUrl;
	}
}
