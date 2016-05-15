package com.soloud.app.manInt;

public interface FolderCreateable 
{

	public boolean createFolder(String id, String folderName, String folderPath);
	public boolean createFolder(String adminId, String memberId, String folderName, String folderPath);
	public boolean createFolder(String id, String folderCode, String parentFolderCode, String folderName, String isSharedFolder);
	public boolean createFolderAdmin(String adminId, String memberId, String folderCode, String parentFolderCoder, String isSharedFolderCode );
	
	////
	public boolean createFolder_REAL(String memberCode, String folderName,  String parentFolderCode, String isSharedFolder);
}
