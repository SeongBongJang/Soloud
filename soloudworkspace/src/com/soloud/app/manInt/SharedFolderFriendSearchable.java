package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.Friend;

public interface SharedFolderFriendSearchable {
	ArrayList<Friend> searchFolderFriend(String sharedFolderCode);
	Friend searchSharedFolderFriendId(String sharedFolderCode , String friendId);
	ArrayList<Friend> searchFolderFriendName(String sharedFolderCode, String friendName);
	ArrayList<Friend> searchSharedFolderFriend(String sharedFolderCode, String groupKind);
	ArrayList<Friend> searchSharedFolderFriend(String sharedFolderCode, String friendName, String groupKind);
	
	boolean alreadyInvite(String id, String sharedFolderCode, String friendId);
}
