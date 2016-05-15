package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 공유폴더 정보를 캡슐화 하고 있는 클래스
 * @author 장성봉
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
	 * 공유폴더의 고유한 코드
	 */
	private String sharedFolderCode;
	/**
	 * 폴더 코드
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
