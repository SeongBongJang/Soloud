package com.soloud.app.man;

import com.soloud.app.manInt.FriendDeleteable;
import com.soloud.app.manInt.FriendGroupModifiable;
import com.soloud.app.manInt.FriendProposalAcceptable;
import com.soloud.app.manInt.FriendSearchable;
import com.soloud.app.model.FriendList;

public abstract class AbstractFriendManager implements FriendDeleteable, FriendGroupModifiable, FriendProposalAcceptable, FriendSearchable{
	private static FriendList friendList;
	public static FriendList getFriendList()
	{
		return friendList;
	}
	public static synchronized void setFriendList(FriendList friendList)
	{
		AbstractFriendManager.friendList = friendList;
	}
}
