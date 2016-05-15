package com.soloud.app.manInt;
import com.soloud.app.model.Group;

public interface FriendGroupModifiable {
	public boolean modifyFriendGroup(String memberId, String friendId,Group groupKind);
	public boolean modifyFriendGroup(String adminId,String memberId,String friendId,Group groupKind);
}
