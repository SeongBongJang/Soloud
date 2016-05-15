package com.soloud.app.manInt;

public interface FolderNameModifiable 
{
	public boolean modifyFolderPathFolderName(String id, String folderName, String newFolderPath);
	public boolean modifyFolderPath(String adminId, String memberId, String folderName, String folderPath, String newFolderPath);
	public boolean modifyFolderPathFolderCode(String id, String folderCode, String newParentFolderCode);
	public boolean modifyFolderName(String adminId, String memberId, String folderCode, String newFolderName);
	
	///
	public boolean modifyFolderName_REAL(String folderCode, String newFolderName);
	
}
