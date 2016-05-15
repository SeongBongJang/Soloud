package com.soloud.app.manInt;

public interface FileAccessAuthModifiable {
	public boolean modifyFileAccessAuth(String id, String filePath, String fileName, Object newAccessAuth);
	public boolean modifyFileAccessAuth(String adminId, String memeberId, String filePath, String fileName, Object newAccessAuth);
	public String modifyFileAccessAuth(String id, String fileCode, Object newAccessAuth);
	public boolean modifyFileAccessAuthAdmin(String adminId, String memeberId, String fileCode, Object newAccessAuth);
}
