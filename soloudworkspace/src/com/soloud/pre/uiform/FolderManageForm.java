//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FolderManageForm.java
//  @ Date : 2014-07-21
//  @ Author : 
//
//


package com.soloud.pre.uiform;

/***
 * ������������ �ʿ��� ��� UI�����͸� ĸ��ȭ�� Ŭ����
 * @author ����
 *
 */
public class FolderManageForm {
	private String folderName;
	private String folderPath;
	private String newFolderName;
	private String newFolderPath;
	public FolderManageForm() {
	}
	public FolderManageForm(String folderName, String folderPath,
			String newFolderName, String newFolderPath) {
		this.folderName = folderName;
		this.folderPath = folderPath;
		this.newFolderName = newFolderName;
		this.newFolderPath = newFolderPath;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	public String getNewFolderName() {
		return newFolderName;
	}
	public void setNewFolderName(String newFolderName) {
		this.newFolderName = newFolderName;
	}
	public String getNewFolderPath() {
		return newFolderPath;
	}
	public void setNewFolderPath(String newFolderPath) {
		this.newFolderPath = newFolderPath;
	}
	@Override
	public String toString() {
		return "FolderManageForm [folderName=" + folderName + ", folderPath="
				+ folderPath + ", newFolderName=" + newFolderName
				+ ", newFolderPath=" + newFolderPath + "]";
	}
	
	
}