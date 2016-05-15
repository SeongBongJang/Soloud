package com.soloud.app.manInt;

public interface SharedFolderFriendInvitable {
	boolean inviteSharedFolderFriend(String id, String folderCode, String friendId);
	boolean inviteSharedFolderFriend(String adminId, String id, String folderCode, String friendId);
}
