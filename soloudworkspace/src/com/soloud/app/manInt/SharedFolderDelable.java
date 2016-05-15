package com.soloud.app.manInt;

public interface SharedFolderDelable {
	boolean deleteSharedFolder(String id, String folderCode);
	boolean deleteSharedFolder(String adminId, String id, String folderCode);
}
