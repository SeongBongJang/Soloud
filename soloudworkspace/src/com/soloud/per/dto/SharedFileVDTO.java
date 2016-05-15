package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 공유폴더에 대한 파일 정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class SharedFileVDTO 
{
	@Override
	public String toString() {
		return "SharedFileVDTO [sharedFolderCode=" + sharedFolderCode
				+ ", folderCode=" + folderCode + ", fileCode=" + fileCode
				+ ", fileName=" + fileName + ", fileLatestModifydate="
				+ fileLatestModifydate + ", fileType=" + fileType + "]";
	}
	/**
	 * 공유폴더코드
	 */
	private String sharedFolderCode;
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
	 * 파일마지막 수정일
	 */
	private GregorianCalendar fileLatestModifydate;
	/**
	 * 파일 유형
	 */
	private String fileType;
	
	/**
	 * 파일 크기
	 */
	private int size;
	public SharedFileVDTO(String sharedFolderCode, String folderCode,
			String fileCode, String fileName,
			GregorianCalendar fileLatestModifydate, String fileType, int size) {
		super();
		this.sharedFolderCode = sharedFolderCode;
		this.folderCode = folderCode;
		this.fileCode = fileCode;
		this.fileName = fileName;
		this.fileLatestModifydate = fileLatestModifydate;
		this.fileType = fileType;
		this.size=size;
	}
	public SharedFileVDTO() {
		super();
	}
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
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
	public GregorianCalendar getFileLatestModifydate() {
		return fileLatestModifydate;
	}
	public void setFileLatestModifydate(GregorianCalendar fileLatestModifydate) {
		this.fileLatestModifydate = fileLatestModifydate;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
