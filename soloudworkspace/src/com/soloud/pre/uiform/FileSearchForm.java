package com.soloud.pre.uiform;

/**
 * 파일 검색기능에서 필요한 UI 데이터를 캡슐화한 클래스
 * @author 영진
 *
 */
public class FileSearchForm {
	private String fileName;
	private String uploaderName;
	private String uploaderId;
	private String fileType;
	private String content;
	public FileSearchForm() {
	}
	public FileSearchForm(String fileName, String uploaderName,
			String uploaderId, String fileType, String content) {
		this.fileName = fileName;
		this.uploaderName = uploaderName;
		this.uploaderId = uploaderId;
		this.fileType = fileType;
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploaderName() {
		return uploaderName;
	}
	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}
	public String getUploaderId() {
		return uploaderId;
	}
	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "FileSearchForm [fileName=" + fileName + ", uploaderName="
				+ uploaderName + ", uploaderId=" + uploaderId + ", fileType="
				+ fileType + ", content=" + content + "]";
	}
	
	
}
