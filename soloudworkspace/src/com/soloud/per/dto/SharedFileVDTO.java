package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ���������� ���� ���� ������ ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * ���������ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * �����ڵ�
	 */
	private String folderCode;
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * �����̸�
	 */
	private String fileName;
	/**
	 * ���ϸ����� ������
	 */
	private GregorianCalendar fileLatestModifydate;
	/**
	 * ���� ����
	 */
	private String fileType;
	
	/**
	 * ���� ũ��
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
