package com.soloud.app.manInt;

public interface FriendRequestable {
	public boolean requestFriendProposal(String senderId,String receiverId);
	public boolean requestFriendProposal(String adminId,String senderId,String receiverId);
}
