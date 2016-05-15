package com.soloud.app.manInt;

public interface FriendDeleteable {
	public boolean deleteFriend(String id,String friendId);
	public boolean deleteFriend(String adminId,String memberId,String friendId);
}
