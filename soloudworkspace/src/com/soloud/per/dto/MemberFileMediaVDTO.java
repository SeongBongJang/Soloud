package com.soloud.per.dto;
/**
 * 멤버코드에 대한 미디어정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class MemberFileMediaVDTO 
{
	/**
	 * 사용자 멤버코드
	 */
	private String memberCode;
	/**
	 * 미디어 코드
	 */
	private String mediaCode;
	/**
	 * 파일코드
	 */
	private String fileCode;
	/**
	 * 파일이름
	 */
	private String fileName;
	/**
	 * 파일유형
	 */
	private String fileType;
	/**
	 * 미디어 시퀀스 번호
	 */
	private int mediaSequence;
	/**
	 * 실제 미디어파일 크기
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
