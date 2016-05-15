package com.soloud.app.man;

import com.soloud.app.manInt.FolderCopyPastable;
import com.soloud.app.manInt.FolderCreateable;
import com.soloud.app.manInt.FolderDelable;
import com.soloud.app.manInt.FolderNameModifiable;
import com.soloud.app.manInt.FolderPathModifiable;
import com.soloud.app.manInt.FolderSearchable;
import com.soloud.app.model.FolderList;

public abstract class AbstractFolderManager implements FolderCopyPastable, FolderCreateable, FolderDelable, FolderNameModifiable, FolderPathModifiable, FolderSearchable
{
	private static FolderList folderList;

	
	static
	{
		AbstractFolderManager.folderList=new FolderList();
	}
	public static synchronized FolderList getFolderList() 
	{
		return AbstractFolderManager.folderList;
	}

	public static void setFolderList(FolderList folderList) 
	{
		AbstractFolderManager.folderList = folderList;
	}
}
