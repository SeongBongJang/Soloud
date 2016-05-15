package com.soloud.per.dto;
/**
 * ����ڵ忡 ���� �̵�������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class MemberFileMediaVDTO 
{
	/**
	 * ����� ����ڵ�
	 */
	private String memberCode;
	/**
	 * �̵�� �ڵ�
	 */
	private String mediaCode;
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * �����̸�
	 */
	private String fileName;
	/**
	 * ��������
	 */
	private String fileType;
	/**
	 * �̵�� ������ ��ȣ
	 */
	private int mediaSequence;
	/**
	 * ���� �̵������ ũ��
	 */
	private int size;
	public MemberFileMediaVDTO(String memberCode, String mediaCode,
			String fileCode, String fileName, String fileType, int mediaSequence, int size) {
		super();
		this.memberCode = memberCode;
		this.mediaCode = mediaCode;
		this.fileCode = fileCode;
		this.fileName = fileName;
		this.fileType = fileType;
		this.mediaSequence = mediaSequence;
		this.setSize(size);
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMediaCode() {
		return mediaCode;
	}
	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fielType) {
		this.fileType = fielType;
	}
	public int getMediaSequence() {
		return mediaSequence;
	}
	public void setMediaSequence(int mediaSequence) {
		this.mediaSequence = mediaSequence;
	}
	public MemberFileMediaVDTO() {
		super();
	}
	@Override
	public String toString() {
		return "MemberFileMediaVDTO [memberCode=" + memberCode + ", mediaCode="
				+ mediaCode + ", fileCode=" + fileCode + ", fileName="
				+ fileName + ", fielType=" + fileType + ", mediaSequence="
				+ mediaSequence + "]";
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
