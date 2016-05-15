package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ���������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class FileDTO 
{
	@Override
	public String toString() {
		return "FileDTO [fileCode=" + fileCode + ", memberCode=" + memberCode
				+ ", folderCode=" + folderCode + ", fileLatestModifyDate="
				+ fileLatestModifyDate + ", fileComment=" + fileComment
				+ ", fileType=" + fileType + ", fileCapacity=" + fileCapacity
				+ ", fileName=" + fileName + ", isShareFile=" + isShareFile
				+ "]";
	}
	/**
	 * ������ ������ �ڵ�
	 */
	private String fileCode;
	/**
	 * ����� ����ڵ�(���δ� ����ڵ�)
	 */
	private String memberCode;
	/**
	 * �Ҽӵ� ���� �ڵ�
	 */
	private String folderCode;
	/**
	 * ���ϸ����� ������
	 */
	private GregorianCalendar fileLatestModifyDate;
	/**
	 * ���� �ڸ�Ʈ
	 */
	private String fileComment;
	/**
	 * ��������
	 */
	private String fileType;
	/**
	 * ���� �뷮
	 */
	private double fileCapacity;
	/**
	 * �����̸�
	 */
	private String fileName;
	/**
	 * �������� ����
	 */
	private String isShareFile;
	public FileDTO() {
		super();
	}
	public FileDTO(String fileCode, String memberCode, String folderCode,
			GregorianCalendar fileLatestModifyDate, String fileComment,
			String fileType, double fileCapacity, String fileName,
			String isShareFile) {
		super();
		this.fileCode = fileCode;
		this.memberCode = memberCode;
		this.folderCode = folderCode;
		this.fileLatestModifyDate = fileLatestModifyDate;
		this.fileComment = fileComment;
		this.fileType = fileType;
		this.fileCapacity = fileCapacity;
		this.fileName = fileName;
		this.isShareFile = isShareFile;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
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
	public GregorianCalendar getFileLatestModifyDate() {
		return fileLatestModifyDate;
	}
	public void setFileLatestModifyDate(GregorianCalendar fileLatestModifyDate) {
		this.fileLatestModifyDate = fileLatestModifyDate;
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
	public double getFileCapacity() {
		return fileCapacity;
	}
	public void setFileCapacity(double fileCapacity) {
		this.fileCapacity = fileCapacity;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIsShareFile() {
		return isShareFile;
	}
	public void setIsShareFile(String isShareFile) {
		this.isShareFile = isShareFile;
	}
}
