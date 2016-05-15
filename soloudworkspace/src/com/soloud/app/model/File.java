package com.soloud.app.model;
import java.util.GregorianCalendar;
/**
 * 파일정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class File {
	/**
	 * 파일의 식별 코드
	 */
	private String fileCode;
	/**
	 * 파일의 폴더코드
	 */
	private String folderCode;
	/**
	 * 파일의 접근권한
	 */
	private Group accessAuth;
	/**
	 * 파일의 이름
	 */
	private String fileName;
	/**
	 * 파일의 경로
	 */
	private String filePath;
	/**
	 * 파일의 용량
	 */
	private float fileCapacity;
	/**
	 * 파일의 유형
	 */
	private String fileType;
	/**
	 * 파일의 코멘트 정보
	 */
	private String comment;
	/**
	 * 파일의 등록일자
	 */
	private GregorianCalendar lastModifyDate;
	/**
	 * 파일 업로더 아이디
	 */
	private String uploaderId;
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 파일접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 * @param comment 파일의 코멘트정보
	 * @param lastModifyDate 파일의 등록일자
	 * @param uploaderId 파일 업로더 아이디
	 */
	public File(Group accessAuth, String fileName, String filePath,
			float fileCapacity, String fileType, String comment,
			GregorianCalendar lastModifyDate, String uploaderId) {
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;   
		this.fileCapacity = fileCapacity;
		this.fileType = fileType;
		this.comment = comment;
		this.lastModifyDate = lastModifyDate;
		this.uploaderId = uploaderId;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param fileCode 파일의 식별코드
	 * @param folderCode 파일의 폴더코드
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의경로
	 * @param fileCapacity 파일의용량
	 * @param fileType 파일의 유형
	 * @param comment 파일의코멘트 정보
	 * @param lastModifyDate 파일의 등록일자
	 * @param uploaderId 파일의 업로더 아이디
	 */
	public File(String fileCode, String folderCode, Group accessAuth, String fileName,
			String filePath, float fileCapacity, String fileType,
			String comment, GregorianCalendar lastModifyDate, String uploaderId) {
		this.folderCode = folderCode;
		this.fileCode = fileCode;
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileCapacity = fileCapacity;
		this.fileType = fileType;
		this.comment = comment;
		this.lastModifyDate = lastModifyDate;
		this.uploaderId = uploaderId;
	}
	/**
	 * 파일클래스 기본 생성자
	 */
	public File() {
		this("fileCode", "folderCode", Group.NORMALFRIEND, "fileName", "filePath", 0.0f, "fileType", "comment", new GregorianCalendar(), "uploaderId");
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 * @param comment 파일의 코멘트 정보
	 * @param lastModifyDate 파일의 등록일자
	 */
	public File(Group accessAuth, String fileName, String filePath,
			float fileCapacity, String fileType, String comment,
			GregorianCalendar lastModifyDate) {
		super();
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileCapacity = fileCapacity;
		this.fileType = fileType;
		this.comment = comment;
		this.lastModifyDate = lastModifyDate;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param fileCode 파일의 식별코드
	 * @param folderCode 파일의 폴더코드
	 */
	public File(String fileCode, String folderCode){
		this.fileCode = fileCode;
		this.folderCode = folderCode;
	}
	/**
	 * 파일클래스의 오버로딩생성자
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 * @param comment 파일의 코멘트정보
	 */
	public File(Group accessAuth, String fileName, String filePath,
			float fileCapacity, String fileType, String comment) {
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileCapacity = fileCapacity;
		this.fileType = fileType;
		this.comment = comment;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 */
	public File(Group accessAuth, String fileName, String filePath,
			float fileCapacity, String fileType) {
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileCapacity = fileCapacity;
		this.fileType = fileType;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일경로
	 * @param fileCapacity 파일의 용량
	 */
	public File(Group accessAuth, String fileName, String filePath,
			float fileCapacity) {
		
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileCapacity = fileCapacity;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일경로
	 */
	public File(Group accessAuth, String fileName, String filePath) {
		
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 */
	public File(Group accessAuth, String fileName) {
		
		this.accessAuth = accessAuth;
		this.fileName = fileName;
	}
	/**
	 * 파일클래스 오버로딩 생성자
	 * @param accessAuth 파일의 접근권한
	 */
	public File(Group accessAuth) {
		
		this.accessAuth = accessAuth;
	}
	/**
	 * getter
	 * @return 파일의 접근권한
	 */
	public Group getAccessAuth() {
		return accessAuth;
	}
	/**
	 * setter
	 * @param accessAuth 파일의 접근권한
	 */
	public void setAccessAuth(Group accessAuth) {
		this.accessAuth = accessAuth;
	}
	/**
	 * getter
	 * @return 파일명
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * setter
	 * @param fileName 파일명
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * getter 
	 * @return 파일경로
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * setter
	 * @param filePath 파일경로
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * getter
	 * @return 파일의 용량
	 */
	public float getFileCapacity() {
		return fileCapacity;
	}
	/**
	 * setter
	 * @param fileCapacity 파일의용량
	 */
	public void setFileCapacity(float fileCapacity) {
		this.fileCapacity = fileCapacity;
	}
	/**
	 * getter
	 * @return 파일의 유형
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * setter
	 * @param fileType 파일의 유형
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * getter
	 * @return 파일의 코멘트 정보
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * setter
	 * @param comment 파일의 코멘트 정보
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * getter
	 * @return 파일의 등록일자
	 */
	public GregorianCalendar getLastModifyDate() {
		return lastModifyDate;
	}
	/**
	 * setter
	 * @param lastModifyDate 파일의 등록일자
	 */
	public void setLastModifyDate(GregorianCalendar lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	/**
	 * getter
	 * @return 파일의 업로더 아이디
	 */
	public String getUploaderId() {
		return uploaderId;
	}
	/**
	 * setter
	 * @param uploaderId 파일의 업로더 아이디
	 */
	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}
	/**
	 * getter
	 * @return 파일의 식별 코드
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * setter 
	 * @param fileCode 파일의 식별 코드
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * getter
	 * @return 파일의 폴더코드
	 */
	public String getFolderCode() {
		return folderCode;
	}
	/**
	 * setter
	 * @param folderCode 파일의 폴더코드
	 */
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
	}
	/**
	 * 파일클래스의 데이터를 문자열화하는 메소드
	 * @return 파일클래스의 문자열화한 데이터
	 */
	@Override
	public String toString() {
		return "File [fileCode=" + fileCode + ", folderCode=" + folderCode
				+ ", accessAuth=" + accessAuth + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", fileCapacity=" + fileCapacity
				+ ", fileType=" + fileType + ", comment=" + comment
				+ ", lastModifyDate=" + lastModifyDate + ", uploaderId="
				+ uploaderId + "]";
	}

	
	
}
