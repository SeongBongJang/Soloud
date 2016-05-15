package com.soloud.per.dto;

public class FolderCapacityVDTO 
{
	private String folderCode;
	private String folderName;
	private int folderCapacity;
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
	public int getFolderCapacity() {
		return folderCapacity;
	}
	public void setFolderCapacity(int folderCapacity) {
		this.folderCapacity = folderCapacity;
	}
	public FolderCapacityVDTO(String folderCode, String folderName,
			int folderCapacity) {
		super();
		this.folderCode = folderCode;
		this.folderName = folderName;
		this.folderCapacity = folderCapacity;
	}
	public FolderCapacityVDTO() {
		super();
	}
	
	
}
