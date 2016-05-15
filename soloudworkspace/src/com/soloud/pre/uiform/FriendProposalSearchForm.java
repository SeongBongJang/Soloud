package com.soloud.pre.uiform;

public class FriendProposalSearchForm {
	private String senderId;
	private String receiverId;
	private String senderName;
	public FriendProposalSearchForm(String senderId, String receiverId,
			String senderName) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.senderName = senderName;
	}
	public FriendProposalSearchForm(String senderId, String receiverId) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
	}
	public FriendProposalSearchForm(String senderId) {
		super();
		this.senderId = senderId;
	}
	public FriendProposalSearchForm() {
		super();
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	@Override
	public String toString() {
		return "FriendProposalSearchForm [senderId=" + senderId
				+ ", receiverId=" + receiverId + ", senderName=" + senderName
				+ "]";
	}
	
	
	
}
