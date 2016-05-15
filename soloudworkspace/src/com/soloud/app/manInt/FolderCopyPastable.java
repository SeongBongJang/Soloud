package com.soloud.app.manInt;

import com.soloud.app.model.Folder;

public interface FolderCopyPastable 
{
	/**
	 * À¸¾î¾î
	 * @param id
	 * @param folderName
	 * @param folderPath
	 * @return
	 */
	public boolean copyPasteFolder(String id, String folderName, String folderPath);
	public boolean copyPasteFolderAdmin(String adminId, String memberId, String folderPath);
	public boolean copyPasteFolder(String id, String folderCode, Folder newFolder);
	public boolean copyPasteFolderAdmin(String adminId, String folderCode, Folder newFolder);
}
