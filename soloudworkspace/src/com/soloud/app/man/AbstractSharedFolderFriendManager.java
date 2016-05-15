package com.soloud.app.man;

import com.soloud.app.manInt.SharedFolderFriendInvitable;
import com.soloud.app.manInt.SharedFolderFriendSearchable;
import com.soloud.app.model.SharedFolderFriendList;

abstract public class AbstractSharedFolderFriendManager implements SharedFolderFriendInvitable, SharedFolderFriendSearchable{
	private static SharedFolderFriendList sharedFolderFriendList;
	static{
		sharedFolderFriendList = new SharedFolderFriendList();
	}
	public static SharedFolderFriendList getSharedFolderFriendList() {
		return sharedFolderFriendList;
	}
	public static void setSharedFolderFriendList(
			SharedFolderFriendList sharedFolderFriendList) {
		AbstractSharedFolderFriendManager.sharedFolderFriendList = sharedFolderFriendList;
	}
	
}
