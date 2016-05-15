package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 파일정보를 캡슐화한 클래스
 * @author 장성봉
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
	 * 파일의 고유한 코드
	 */
	private String fileCode;
	/**
	 * 사용자 멤버코드(업로더 멤버코드)
	 */
	private String memberCode;
	/**
	 * 소속된 폴더 코드
	 */
	private String folderCode;
	/**
	 * 파일마지막 수정일
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
	 * 파일 용량
	 */
	private double fileCapacity;
	/**
	 * 파일이름
	 */
	private String fileName;
	/**
	 * 공유파일 여부
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
