package com.soloud.pre.uiform;

public class FriendProposalManageForm {
	private String senderId;
	private String receiveId;
	public FriendProposalManageForm(String senderId, String receiveId) {
		this.senderId = senderId;
		this.receiveId = receiveId;
	}
	public FriendProposalManageForm() {
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}
	@Override
	public String toString() {
		return "FriendProposalManageForm [senderId=" + senderId
				+ ", receiveId=" + receiveId + "]";
	}
	
	
	
}
