package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ����ڵ忡 ���� ���� ���������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class MemberSharedVDTO 
{
	@Override
	public String toString() {
		return "MemberSharedVDTO [memberCode=" + memberCode
				+ ", sharedFolderCode=" + sharedFolderCode + ", folderCode="
				+ folderCode + ", folderName=" + folderName + ", folderUrl="
				+ folderUrl + ", sharedFolderMakedate=" + sharedFolderMakedate
				+ "]";
	}
	/**
	 * ����ڵ�
	 */
	private String memberCode;
	/**
	 * ���������ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * �����ڵ�
	 */
	private String folderCode;
	/**
	 * �����̸�
	 */
	private String folderName;
	/**
	 * ���� URL
	 */
	private String folderUrl;
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderUrl() {
		return folderUrl;
	}
	public void setFolderUrl(String folderUrl) {
		this.folderUrl = folderUrl;
	}
	public GregorianCalendar getSharedFolderMakedate() {
		return sharedFolderMakedate;
	}
	public void setSharedFolderMakedate(GregorianCalendar sharedFolderMakedate) {
		this.sharedFolderMakedate = sharedFolderMakedate;
	}
	public MemberSharedVDTO() {
		super();
	}
	public MemberSharedVDTO(String memberCode, String sharedFolderCode,
			String folderCode, String folderName, String folderUrl,
			GregorianCalendar sharedFolderMakedate) {
		super();
		this.memberCode = memberCode;
		this.sharedFolderCode = sharedFolderCode;
		this.folderCode = folderCode;
		this.folderName = folderName;
		this.folderUrl = folderUrl;
		this.sharedFolderMakedate = sharedFolderMakedate;
	}
	private GregorianCalendar sharedFolderMakedate;
	
}
