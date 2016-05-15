package com.soloud.per.dto;
/**
 * ȸ���ڵ忡 ���� ������ ��ü ������ ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * ����� ����ڵ�
	 */
	private String memberCode;
	/**
	 * ���� �ڵ�
	 */
	private String folderCode;
	/**
	 * �����̸�
	 */
	private String folderName;
	/**
	 * �θ������ڵ�
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
