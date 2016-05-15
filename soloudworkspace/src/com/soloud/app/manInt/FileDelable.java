package com.soloud.app.manInt;

public interface FileDelable {
	public boolean deleteFile(String id, String filePath, String fileName);
	public boolean deleteFile(String adminId, String memberId, String filePath, String fileName);
	public String deleteFile(String id, String fileCode);
	public String deleteFileAdmin(String adminId, String memberId, String fileCode);
}
