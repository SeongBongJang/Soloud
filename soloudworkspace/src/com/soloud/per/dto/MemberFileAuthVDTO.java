package com.soloud.per.dto;

import java.util.GregorianCalendar;

public class MemberFileAuthVDTO 
{
	/**
	 * ����ڵ�
	 */
	private String memberCode;
	/**
	 * ����̸�
	 */
	private String memberName;
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * ���Ͼ��δ��ڵ�
	 */
	private String fileUploaderCode;
	/**
	 * ���Ͼ��δ��̸�
	 */
	private String fileUploaderName;
	/**
	 * �ش� ������ �ִ� ������ �ڵ�
	 */
	private String fileFolderCode;
	/**
	 * �ֱټ�����¥
	 */
	private GregorianCalendar latestModifiedDate;
	/**
	 * ���ϼ���
	 */
	private String fileComment;
	/**
	 * ����Ÿ��
	 */
	private String fileType;
	/**
	 * �����̸�
	 */
	private String fileName;
	/**
	 * �������Ͽ���
	 */
	private String isSharedFile;
	
	public MemberFileAuthVDTO(String memberCode, String memberName,
			String fileCode, String fileUploaderCode, String fileUploaderName,
			String fileFolderCode, GregorianCalendar latestModifyDate,
			String fileComment, String fileType, String fileName,
			String isSharedFile) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.fileCode = fileCode;
		this.fileUploaderCode = fileUploaderCode;
		this.fileUploaderName = fileUploaderName;
		this.fileFolderCode = fileFolderCode;
		this.latestModifiedDate = latestModifyDate;
		this.fileComment = fileComment;
		this.fileType = fileType;
		this.fileName = fileName;
		this.isSharedFile = isSharedFile;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getFileUploaderCode() {
		return fileUploaderCode;
	}
	public void setFileUploaderCode(String fileUploaderCode) {
		this.fileUploaderCode = fileUploaderCode;
	}
	public String getFileUploaderName() {
		return fileUploaderName;
	}
	public void setFileUploaderName(String fileUploaderName) {
		this.fileUploaderName = fileUploaderName;
	}
	public String getFileFolderCode() {
		return fileFolderCode;
	}
	public void setFileFolderCode(String fileFolderCode) {
		this.fileFolderCode = fileFolderCode;
	}
	public GregorianCalendar getLatestModifiedDate() {
		return latestModifiedDate;
	}
	public void setLatestModifiedDate(GregorianCalendar latestModifyDate) {
		this.latestModifiedDate = latestModifyDate;
	}
	public String getFileComment() {
		return fileComment;
	}
	public void setFileComment(String fileComment) {
		this.fileComment = fileComment;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "MemberFileAuthVDTO [memberCode=" + memberCode + ", memberName="
				+ memberName + ", fileCode=" + fileCode + ", fileUploaderCode="
				+ fileUploaderCode + ", fileUploaderName=" + fileUploaderName
				+ ", fileFolderCode=" + fileFolderCode + ", latestModifyDate="
				+ latestModifiedDate + ", fileComment=" + fileComment
				+ ", fileType=" + fileType + ", fileName=" + fileName
				+ ", isSharedFile=" + isSharedFile + "]";
	}
	public String getIsSharedFile() {
		return isSharedFile;
	}
	public MemberFileAuthVDTO() {
		super();
	}
	public void setIsSharedFile(String isSharedFile) {
		this.isSharedFile = isSharedFile;
	}
	
}
