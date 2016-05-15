package com.soloud.app.manInt;

public interface FilePathModifiable {
	public boolean modifyFilePath(String id, String filePath, String fileName, String newFilePath);
	public boolean modifyFilePath(String adminId, String memberId, String filePath, String fileName, String newFilePath);
	public String modifyFilePath(String id, String fileCode, String newFolderCode);
	public boolean modifyFilePathAdmin(String adminId, String memberId, String fileCode, String newFolderCode);
}
