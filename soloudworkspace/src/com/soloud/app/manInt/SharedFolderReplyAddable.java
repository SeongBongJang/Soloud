package com.soloud.app.manInt;

import java.util.GregorianCalendar;

public interface SharedFolderReplyAddable {
	boolean addReply(String sharedFolderCode, String writerId, String content, GregorianCalendar writeDate);
	boolean addReply(String adminId, String sharedFolderCode, String writerId, String content, GregorianCalendar writeDate);
}
