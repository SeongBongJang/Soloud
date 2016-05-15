package com.soloud.app.model;

import java.io.Serializable;
/**
 * ģ������������ ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class FriendProposal implements Serializable{

	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = -6716817204246951365L;
	/**
	 * �۽��� ���̵�
	 */
	private String senderId;
	/**
	 * �۽��� �̸�
	 */
	private String senderName;
	/**
	 * ������ ���̵�
	 */
	private String receiverId;
	/**
	 * ������ �̸�
	 */
	private String receiverName;
	/**
	 * ��������
	 */
	private String proposalKind;
	/**
	 * FriendProposalŬ���� �����ε� ������
	 * @param senderId �۽��� ���̵�
	 * @param senderName �۽��� �̸�
	 * @param receiverId ������ ���̵�
	 * @param proposalKind ��������
	 */
	public FriendProposal(String senderId, String senderName,
			String receiverId, String receiverName, String proposalKind) {
		
		this.senderId = senderId;
		this.senderName = senderName;
		this.receiverId = receiverId;
		this.receiverName = receiverName;
		this.proposalKind = proposalKind;
	}
	/**
	 * FriendProposalŬ���� �����ε� ������
	 * @param senderId �۽��� ���̵�
	 * @param senderName �۽��� �̸�
	 * @param receiverId ������ ���̵�
	 */
	public FriendProposal(String senderId, String senderName, String receiverId) {
		super();
		this.senderId = senderId;
		this.senderName = senderName;
		this.receiverId = receiverId;
	}
	/**
	 * FriendProposalŬ���� �����ε� ������
	 * @param senderId �۽��� ���̵�
	 * @param senderName �۽��� �̸�
	 */
	public FriendProposal(String senderId, String senderName) {
	
		this.senderId = senderId;
		this.senderName = senderName;
	}
	/**
	 * FriendProposalŬ���� �����ε� ������
	 * @param senderId �۽��� ���̵�
	 */
	public FriendProposal(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * FriendProposalŬ���� �⺻ ������
	 */
	public FriendProposal() {
		this("sender", "senderName", "receiverId", "receiverName","proposalKind");
	}
	/**
	 * getter
	 * @return �۽��� ���̵�
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * setter
	 * @param senderId �۽��� ���̵�
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * getter
	 * @return �۽��� �̸�
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * setter
	 * @param senderName �۽��� �̸�
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * getter
	 * @return ������ ���̵�
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * setter
	 * @param receiverId ������ ���̵�
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * getter
	 * @return ��������
	 */
	public String getProposalKind() {
		return proposalKind;
	}
	/**
	 * setter
	 * @param proposalKind ��������
	 */
	public void setProposalKind(String proposalKind) {
		this.proposalKind = proposalKind;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getReceiverName() {
		return receiverName;
	}
	
	/**
	 * FriendProposal��ü�� �����͸� ���ڿ�ȭ �ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "FriendProposal [senderId=" + senderId + ", senderName="
				+ senderName + ", receiverId=" 
				+ receiverId + ", receiverName ="
				+ receiverName +", proposalKind="
				+ proposalKind + "]";
	}	

}
