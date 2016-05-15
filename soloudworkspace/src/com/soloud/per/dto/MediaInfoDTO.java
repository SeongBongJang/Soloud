package com.soloud.per.dto;
/**
 * 미디어정보를 캡슐화한 클래스
 * @author 장성봉
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
	 * 미디어정보의 고유한 코드
	 */
	private String mediaCode;
	/**
	 * 사용자 멤버코드
	 */
	private String memberCode;
	/**
	 * 미디어 파일코드
	 */
	private String fileCode;
	/**
	 * 미디어 시퀀스 번호
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
