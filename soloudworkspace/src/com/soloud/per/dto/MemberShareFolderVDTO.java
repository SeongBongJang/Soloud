package com.soloud.per.dto;

public class MemberShareFolderVDTO 
{
	private String memberCode;
	private String folderCode;
	private String folderName;
	private String sharedFolderCode;
	private String hostMemberCode;
	private String parentFolderCode;
	private String isSharedFolder;
	private String folderUrl;
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
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	public String getHostMemberCode() {
		return hostMemberCode;
	}
	public void setHostMemberCode(String hostMemberCode) {
		this.hostMemberCode = hostMemberCode;
	}
	public String getParentFolderCode() {
		return parentFolderCode;
	}
	public void setParentFolderCode(String parentFolderCode) {
		this.parentFolderCode = parentFolderCode;
	}
	public String getIsSharedFolder() {
		return isSharedFolder;
	}
	public void setIsSharedFolder(String isSharedFolder) {
		this.isSharedFolder = isSharedFolder;
	}
	public String getFolderUrl() {
		return folderUrl;
	}
	public void setFolderUrl(String folderUrl) {
		this.folderUrl = folderUrl;
	}
	public MemberShareFolderVDTO(String memberCode, String folderCode,
			String folderName, String sharedFolderCode, String hostMemberCode,
			String parentFolderCode, String isSharedFolder, String folderUrl) {
		super();
		this.memberCode = memberCode;
		this.folderCode = folderCode;
		this.folderName = folderName;
		this.sharedFolderCode = sharedFolderCode;
		this.hostMemberCode = hostMemberCode;
		this.parentFolderCode = parentFolderCode;
		this.isSharedFolder = isSharedFolder;
		this.folderUrl = folderUrl;
	}
	public MemberShareFolderVDTO() {
		super();
	}

	
	
}
