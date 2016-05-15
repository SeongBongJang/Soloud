package com.soloud.app.manInt;

import java.io.InputStream;

public interface FileUploadable {
	public boolean uploadFile(Object file, InputStream stream);
	public boolean uploadFile(String adminId, Object file, InputStream stream);
}
