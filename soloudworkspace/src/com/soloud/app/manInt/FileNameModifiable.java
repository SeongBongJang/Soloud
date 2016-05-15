package com.soloud.app.manInt;

public interface FileNameModifiable {
	public boolean modifyFileName(String id, String filePath, String fileName, String newFileName);
	public boolean modifyFileName(String adminId, String memberId, String filePath, String fileName, String newFileName);
	public String modifyFileName(String id, String fileCode, String newFileName);
	public String modifyFileNameAdmin(String adminId, String memberId, String fileCode, String newFileName);
}
