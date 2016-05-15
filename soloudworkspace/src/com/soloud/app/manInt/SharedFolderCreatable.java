package com.soloud.app.manInt;

public interface SharedFolderCreatable {
	boolean createSharedFolder(String id, String folderName, String isSharedFolder);
	boolean createSharedFolder(String adminId, String id, String folderName, String isSharedFolder);
	
	
	
	
	//ㅂㄱ가 쓸라곻 만든거
	public boolean createSharedFolderAuthFriend(String friendCode, String sharedFolderCode);
}
