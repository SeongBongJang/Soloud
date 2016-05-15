package com.soloud.app.manInt;

public interface SharedFolderCreatable {
	boolean createSharedFolder(String id, String folderName, String isSharedFolder);
	boolean createSharedFolder(String adminId, String id, String folderName, String isSharedFolder);
	
	
	
	
	//������ ����� �����
	public boolean createSharedFolderAuthFriend(String friendCode, String sharedFolderCode);
}
