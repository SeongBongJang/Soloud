package com.soloud.app.manInt;

public interface FolderDelable 
{
	public boolean deleteFolder(String id, String folderName, String folderPath);
	public boolean deleteFolder(String adminId, String mebmerId, String folderName, String folderPath);
	public boolean deleteFolder(String id, String folderId);
	public boolean deleteFolderd(String adminid, String memberId, String folderCode);

	
	/////
	public boolean deleteFolder_REAL(String folderCode);
}
