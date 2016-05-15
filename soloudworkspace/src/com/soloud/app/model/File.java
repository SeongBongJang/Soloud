package com.soloud.app.model;
import java.util.GregorianCalendar;
/**
 * ���������� ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class File {
	/**
	 * ������ �ĺ� �ڵ�
	 */
	private String fileCode;
	/**
	 * ������ �����ڵ�
	 */
	private String folderCode;
	/**
	 * ������ ���ٱ���
	 */
	private Group accessAuth;
	/**
	 * ������ �̸�
	 */
	private String fileName;
	/**
	 * ������ ���
	 */
	private String filePath;
	/**
	 * ������ �뷮
	 */
	private float fileCapacity;
	/**
	 * ������ ����
	 */
	private String fileType;
	/**
	 * ������ �ڸ�Ʈ ����
	 */
	private String comment;
	/**
	 * ������ �������
	 */
	private GregorianCalendar lastModifyDate;
	/**
	 * ���� ���δ� ���̵�
	 */
	private String uploaderId;
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth �������ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
	 * @param comment ������ �ڸ�Ʈ����
	 * @param lastModifyDate ������ �������
	 * @param uploaderId ���� ���δ� ���̵�
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
	 * ����Ŭ���� �����ε� ������
	 * @param fileCode ������ �ĺ��ڵ�
	 * @param folderCode ������ �����ڵ�
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath �����ǰ��
	 * @param fileCapacity �����ǿ뷮
	 * @param fileType ������ ����
	 * @param comment �������ڸ�Ʈ ����
	 * @param lastModifyDate ������ �������
	 * @param uploaderId ������ ���δ� ���̵�
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
	 * ����Ŭ���� �⺻ ������
	 */
	public File() {
		this("fileCode", "folderCode", Group.NORMALFRIEND, "fileName", "filePath", 0.0f, "fileType", "comment", new GregorianCalendar(), "uploaderId");
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
	 * @param comment ������ �ڸ�Ʈ ����
	 * @param lastModifyDate ������ �������
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
	 * ����Ŭ���� �����ε� ������
	 * @param fileCode ������ �ĺ��ڵ�
	 * @param folderCode ������ �����ڵ�
	 */
	public File(String fileCode, String folderCode){
		this.fileCode = fileCode;
		this.folderCode = folderCode;
	}
	/**
	 * ����Ŭ������ �����ε�������
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
	 * @param comment ������ �ڸ�Ʈ����
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
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
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
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ���ϰ��
	 * @param fileCapacity ������ �뷮
	 */
	public File(Group accessAuth, String fileName, String filePath,
			float fileCapacity) {
		
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileCapacity = fileCapacity;
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ���ϰ��
	 */
	public File(Group accessAuth, String fileName, String filePath) {
		
		this.accessAuth = accessAuth;
		this.fileName = fileName;
		this.filePath = filePath;
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 */
	public File(Group accessAuth, String fileName) {
		
		this.accessAuth = accessAuth;
		this.fileName = fileName;
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param accessAuth ������ ���ٱ���
	 */
	public File(Group accessAuth) {
		
		this.accessAuth = accessAuth;
	}
	/**
	 * getter
	 * @return ������ ���ٱ���
	 */
	public Group getAccessAuth() {
		return accessAuth;
	}
	/**
	 * setter
	 * @param accessAuth ������ ���ٱ���
	 */
	public void setAccessAuth(Group accessAuth) {
		this.accessAuth = accessAuth;
	}
	/**
	 * getter
	 * @return ���ϸ�
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * setter
	 * @param fileName ���ϸ�
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * getter 
	 * @return ���ϰ��
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * setter
	 * @param filePath ���ϰ��
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * getter
	 * @return ������ �뷮
	 */
	public float getFileCapacity() {
		return fileCapacity;
	}
	/**
	 * setter
	 * @param fileCapacity �����ǿ뷮
	 */
	public void setFileCapacity(float fileCapacity) {
		this.fileCapacity = fileCapacity;
	}
	/**
	 * getter
	 * @return ������ ����
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * setter
	 * @param fileType ������ ����
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * getter
	 * @return ������ �ڸ�Ʈ ����
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * setter
	 * @param comment ������ �ڸ�Ʈ ����
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * getter
	 * @return ������ �������
	 */
	public GregorianCalendar getLastModifyDate() {
		return lastModifyDate;
	}
	/**
	 * setter
	 * @param lastModifyDate ������ �������
	 */
	public void setLastModifyDate(GregorianCalendar lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	/**
	 * getter
	 * @return ������ ���δ� ���̵�
	 */
	public String getUploaderId() {
		return uploaderId;
	}
	/**
	 * setter
	 * @param uploaderId ������ ���δ� ���̵�
	 */
	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}
	/**
	 * getter
	 * @return ������ �ĺ� �ڵ�
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * setter 
	 * @param fileCode ������ �ĺ� �ڵ�
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * getter
	 * @return ������ �����ڵ�
	 */
	public String getFolderCode() {
		return folderCode;
	}
	/**
	 * setter
	 * @param folderCode ������ �����ڵ�
	 */
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
	}
	/**
	 * ����Ŭ������ �����͸� ���ڿ�ȭ�ϴ� �޼ҵ�
	 * @return ����Ŭ������ ���ڿ�ȭ�� ������
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
