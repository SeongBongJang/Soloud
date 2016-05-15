package com.soloud.app.manInt;

import java.util.List;

import com.soloud.app.model.Folder;

public interface FolderSearchable 
{
	public Folder searchFolder(String id, String folderName, String folderPath);
	public List<Folder> searchFolderIdPath(String id, String folderPath);
	public List<Folder> searchFolder(String id);
	public Folder searchFolderIdCode(String id, String folderCode);
	public List<Folder> searchFolderIdParent(String id, String parentrFodlerCode);
	
	
	
	//
	public List<Folder> searchFolder_REAL1(String memberCode, String folderName);
	public List<Folder> searchFolder_REAL2(String memberCode, String isSharedFolder);
	public Folder searchFolder_REAL3(String folderCode);
}
