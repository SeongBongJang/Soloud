package com.soloud.per.dto;
/**
 * �ϳ��� ���������� ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * ������ ������ �ڵ�
	 */
	private String folderCode;
	/**
	 * ����� ����ڵ�(���δ��ڵ�)
	 */
	private String memberCode;
	/**
	 * �Ҽӵ� �θ� ���� �ڵ�
	 */
	private String parentFolderCode;
	/**
	 * �����̸�
	 */
	private String folderName;
	/**
	 * ������������
	 */
	private String isShareFolder;
	/**
	 * ���� url
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
