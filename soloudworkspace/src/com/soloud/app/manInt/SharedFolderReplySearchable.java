package com.soloud.app.manInt;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.soloud.app.model.Reply;

public interface SharedFolderReplySearchable {
	Reply searchReply(String sharedFolderCode, String writerId, GregorianCalendar writeDate);
	ArrayList<Reply> searchReply(String sharedFolderCode, String writerId);
	ArrayList<Reply> searchReply(String sharedFolderCode, GregorianCalendar startDate, GregorianCalendar endDate );
	ArrayList<Reply> searchReply(String sharedFolderCode);
}
