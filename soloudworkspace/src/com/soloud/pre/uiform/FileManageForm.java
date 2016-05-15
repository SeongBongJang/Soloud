package com.soloud.pre.uiform;

/**
 * ���� ���� ��ɿ��� �ʿ��� ��� UI �����͸� ĸ��ȭ �� Ŭ����
 * @author ����
 *
 */
public class FileManageForm {
	private String fileName;
	private String filePath;
	private String newFilePath;
	private String newFileName;
	public FileManageForm() {
	}
	public FileManageForm(String fileName, String filePath, String newFilePath,
			String newFileName) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.newFilePath = newFilePath;
		this.newFileName = newFileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getNewFilePath() {
		return newFilePath;
	}
	public void setNewFilePath(String newFilePath) {
		this.newFilePath = newFilePath;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	@Override
	public String toString() {
		return "FileManageForm [fileName=" + fileName + ", filePath="
				+ filePath + ", newFilePath=" + newFilePath + ", newFileName="
				+ newFileName + "]";
	}
	
	
}
