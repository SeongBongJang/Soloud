package com.soloud.per.dto;
/**
 * �̵�������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class MediaInfoDTO 
{
	@Override
	public String toString() {
		return "MediaInfoDTO [mediaCode=" + mediaCode + ", memberCode="
				+ memberCode + ", fileCode=" + fileCode + ", mediaSequence="
				+ mediaSequence + "]";
	}
	/**
	 * �̵�������� ������ �ڵ�
	 */
	private String mediaCode;
	/**
	 * ����� ����ڵ�
	 */
	private String memberCode;
	/**
	 * �̵�� �����ڵ�
	 */
	private String fileCode;
	/**
	 * �̵�� ������ ��ȣ
	 */
	private int mediaSequence;
	public MediaInfoDTO(String mediaCode, String memberCode, String fileCode,
			int mediaSequence) {
		super();
		this.mediaCode = mediaCode;
		this.memberCode = memberCode;
		this.fileCode = fileCode;
		this.mediaSequence = mediaSequence;
	}
	public String getMediaCode() {
		return mediaCode;
	}
	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}
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
	public int getMediaSequence() {
		return mediaSequence;
	}
	public void setMediaSequence(int mediaSequence) {
		this.mediaSequence = mediaSequence;
	}
	public MediaInfoDTO() {
		super();
	}
	
}
