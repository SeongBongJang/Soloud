package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * �������� ������ ĸ��ȭ �ϰ� �ִ� Ŭ����
 * @author �强��
 *
 */
public class SharedFolderDTO 
{
	@Override
	public String toString() {
		return "SharedFolderDTO [sharedFolderCode=" + sharedFolderCode
				+ ", folderCode=" + folderCode + ", sharedFolderMakeDate="
				+ sharedFolderMakeDate + "]";
	}
	/**
	 * ���������� ������ �ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * ���� �ڵ�
	 */
	private String folderCode;
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
	public SharedFolderDTO() {
		super();
	}
	public GregorianCalendar getSharedFolderMakeDate() {
		return sharedFolderMakeDate;
	}
	public void setSharedFolderMakeDate(GregorianCalendar sharedFolderMakeDate) {
		this.sharedFolderMakeDate = sharedFolderMakeDate;
	}
	public SharedFolderDTO(String sharedFolderCode, String folderCode,
			GregorianCalendar sharedFolderMakeDate) {
		super();
		this.sharedFolderCode = sharedFolderCode;
		this.folderCode = folderCode;
		this.sharedFolderMakeDate = sharedFolderMakeDate;
	}
	private GregorianCalendar sharedFolderMakeDate;
	
}
