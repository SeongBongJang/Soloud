package com.soloud.app.man;

import com.soloud.app.manInt.SharedFolderCreatable;
import com.soloud.app.manInt.SharedFolderDelable;
import com.soloud.app.manInt.SharedFolderSearchable;
import com.soloud.app.model.SharedFolderList;

public abstract class AbstractSharedFolderManager implements SharedFolderDelable, SharedFolderSearchable, SharedFolderCreatable{
	private static SharedFolderList sharedFolderList;
	static {
		sharedFolderList = new SharedFolderList();
	}
	public static SharedFolderList getSharedFolderList() {
		return sharedFolderList;
	}
	public static void setSharedFolderList(SharedFolderList sharedFolderList) {
		AbstractSharedFolderManager.sharedFolderList = sharedFolderList;
	}
}
