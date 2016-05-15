package com.soloud.app.man;

import com.soloud.app.manInt.FileAccessAuthModifiable;
import com.soloud.app.manInt.FileCopyPastable;
import com.soloud.app.manInt.FileDelable;
import com.soloud.app.manInt.FileNameModifiable;
import com.soloud.app.manInt.FilePathModifiable;
import com.soloud.app.manInt.FileSearchable;
import com.soloud.app.manInt.FileUploadable;
import com.soloud.app.model.FileList;

public abstract class AbstractFileManager implements FileSearchable,
		FileAccessAuthModifiable, FileDelable, FileCopyPastable,
		FileNameModifiable, FilePathModifiable, FileUploadable {
	private static FileList fileList;
	static{
		AbstractFileManager.fileList = new FileList();
	}
	public static synchronized FileList getFileList() {
		return fileList;
	}

	public static synchronized void setFileList(FileList fileList) {
		AbstractFileManager.fileList = fileList;
	}
}
