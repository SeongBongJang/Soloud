package com.soloud.app.man;

import com.soloud.app.manInt.FriendProposalCancelable;
import com.soloud.app.manInt.FriendProposalRefusable;
import com.soloud.app.manInt.FriendProposalSearchable;
import com.soloud.app.manInt.FriendRequestable;
import com.soloud.app.model.FriendProposalList;

public abstract class AbstractFriendProposalManager implements FriendProposalCancelable,
FriendProposalRefusable,FriendProposalSearchable,FriendRequestable{
	private static FriendProposalList friendProposalList;

	static{
		AbstractFriendProposalManager.friendProposalList = new FriendProposalList();
	}
	public static synchronized FriendProposalList getFriendProposalList() {
		return friendProposalList;
	}

	public static synchronized void setFriendProposalList(FriendProposalList friendProposalList) {
		AbstractFriendProposalManager.friendProposalList = friendProposalList;
	}	
}
