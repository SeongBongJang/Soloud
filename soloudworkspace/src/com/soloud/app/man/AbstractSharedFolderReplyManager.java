package com.soloud.app.man;

import com.soloud.app.manInt.SharedFolderReplyAddable;
import com.soloud.app.manInt.SharedFolderReplyDelabe;
import com.soloud.app.manInt.SharedFolderReplySearchable;
import com.soloud.app.model.ReplyList;

abstract public class AbstractSharedFolderReplyManager implements SharedFolderReplyAddable, SharedFolderReplySearchable, SharedFolderReplyDelabe{
	private static ReplyList replyList;
	static {
		replyList = new ReplyList();
	}
	public static ReplyList getReplyList() {
		return replyList;
	}
	public static void setReplyList(ReplyList replyList) {
		AbstractSharedFolderReplyManager.replyList = replyList;
	}
}
