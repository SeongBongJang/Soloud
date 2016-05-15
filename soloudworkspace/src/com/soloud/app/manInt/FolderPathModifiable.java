package com.soloud.app.manInt;

public interface FolderPathModifiable 
{
	public boolean modifyFolderPath(String id, String folderName, String folderPath, String newFolderPath);
	public boolean modifyFolderPath(String adminid, String memberId, String folderName, String folderPath, String newFolderPath);
	public boolean modifyFolderPath(String id, String folderCode, String newParentFolderCode);
	public boolean modifyFolderPathAdmin(String adminId, String memberId, String folderCode, String newParentFolderCode);
	
	
	/////
	public boolean modifyFolderPath_REAL(String folderCode, String newFoldeCode);
}
