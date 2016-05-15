package com.soloud.app.manInt;

public interface FileCopyPastable {
	public boolean copyPasteFile(String id, Object file);
	public boolean copyPasteFile(String id);
	public String copyPasteFile(String id, String fileCode, String newFile);
}
