package com.soloud.app.manInt;

import java.util.GregorianCalendar;

public interface SharedFolderReplyDelabe {
	boolean deleteReply(String sharedFolderCode, String writerId, GregorianCalendar writeDate);
	boolean deleteReply(String adminId, String sharedFolderCode, String writerId, GregorianCalendar writeDate);
}
