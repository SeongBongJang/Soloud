package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ����ڵ忡 ���� ��ü���� ������ ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class MemberFileVDTO 
{
	@Override
	public String toString() {
		return "MemberFileVDTO [memberCode=" + memberCode + ", fileCode="
				+ fileCode + ", fileLatestModifyDate=" + fileLatestModifyDate
				+ ", fileComment=" + fileComment + ", fileType=" + fileType
				+ ", fileCapacity=" + fileCapacity + ", fileName=" + fileName
				+ "]";
	}
	/**
	 * ����� ����ڵ�
	 */
	private String memberCode;
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * ������ ������¥
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
	 * ���Ͽ뷮
	 */
	private double fileCapacity;
	/**
	 * �����̸�
	 */
	private String fileName;
	/**
	 * ���� ũ��
	 */
	private int size;
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
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
	public MemberFileVDTO() {
		super();
	}
	public MemberFileVDTO(String memberCode, String fileCode,
			GregorianCalendar fileLatestModifyDate, String fileComment,
			String fileType, double fileCapacity, String fileName, int size) {
		super();
		this.memberCode = memberCode;
		this.fileCode = fileCode;
		this.fileLatestModifyDate = fileLatestModifyDate;
		this.fileComment = fileComment;
		this.fileType = fileType;
		this.fileCapacity = fileCapacity;
		this.fileName = fileName;
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
