package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 폴더코드에 대한 파일의 전체정보를 캡슐화 한 클래스
 * @author 장성봉
 *
 */
public class FolderFileVDTO 
{
	@Override
	public String toString() {
		return "FolderFileVDTO [folderCode=" + folderCode + ", fileCode="
				+ fileCode + ", fileName=" + fileName + ", fileType="
				+ fileType + ", fileLatestModifydate=" + fileLatestModifydate
				+ "]";
	}
	/**
	 * 폴더코드
	 */
	private String folderCode;
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
	 * 파일 마지막 수정일
	 */
	private GregorianCalendar fileLatestModifydate;
	/**
	 * 파일의 크기
	 */
	private int size;
	public FolderFileVDTO(String folderCode, String fileCode, String fileName,
			String fileType, GregorianCalendar fileLatestModifydate, int size) {
		super();
		this.folderCode = folderCode;
		this.fileCode = fileCode;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileLatestModifydate = fileLatestModifydate;
		this.setSize(size);
	}
	public FolderFileVDTO() {
		super();
	}
	public String getFolderCode() {
		return folderCode;
	}
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
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
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public GregorianCalendar getFileLatestModifydate() {
		return fileLatestModifydate;
	}
	public void setFileLatestModifydate(GregorianCalendar fileLatestModifydate) {
		this.fileLatestModifydate = fileLatestModifydate;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
