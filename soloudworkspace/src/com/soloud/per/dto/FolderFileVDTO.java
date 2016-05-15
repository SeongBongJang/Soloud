package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * �����ڵ忡 ���� ������ ��ü������ ĸ��ȭ �� Ŭ����
 * @author �强��
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
	 * ��������
	 */
	private String fileType;
	/**
	 * ���� ������ ������
	 */
	private GregorianCalendar fileLatestModifydate;
	/**
	 * ������ ũ��
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
