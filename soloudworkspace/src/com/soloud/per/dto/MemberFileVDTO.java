package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 멤버코드에 대한 전체파일 정보를 캡슐화한 클래스
 * @author 장성봉
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
	 * 사용자 멤버코드
	 */
	private String memberCode;
	/**
	 * 파일코드
	 */
	private String fileCode;
	/**
	 * 마지막 수정날짜
	 */
	private GregorianCalendar fileLatestModifyDate;
	/**
	 * 파일 코멘트
	 */
	private String fileComment;
	/**
	 * 파일유형
	 */
	private String fileType;
	/**
	 * 파일용량
	 */
	private double fileCapacity;
	/**
	 * 파일이름
	 */
	private String fileName;
	/**
	 * 파일 크기
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
