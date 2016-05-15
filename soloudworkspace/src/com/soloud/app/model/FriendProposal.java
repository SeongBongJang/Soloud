package com.soloud.app.model;

import java.io.Serializable;
/**
 * 친구제안정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class FriendProposal implements Serializable{

	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = -6716817204246951365L;
	/**
	 * 송신자 아이디
	 */
	private String senderId;
	/**
	 * 송신자 이름
	 */
	private String senderName;
	/**
	 * 수신자 아이디
	 */
	private String receiverId;
	/**
	 * 수신자 이름
	 */
	private String receiverName;
	/**
	 * 제안종류
	 */
	private String proposalKind;
	/**
	 * FriendProposal클래스 오버로딩 생성자
	 * @param senderId 송신자 아이디
	 * @param senderName 송신자 이름
	 * @param receiverId 수신자 아이디
	 * @param proposalKind 제안종류
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
	 * FriendProposal클래스 오버로딩 생성자
	 * @param senderId 송신자 아이디
	 * @param senderName 송신자 이름
	 * @param receiverId 수신자 아이디
	 */
	public FriendProposal(String senderId, String senderName, String receiverId) {
		super();
		this.senderId = senderId;
		this.senderName = senderName;
		this.receiverId = receiverId;
	}
	/**
	 * FriendProposal클래스 오버로딩 생성자
	 * @param senderId 송신자 아이디
	 * @param senderName 송신자 이름
	 */
	public FriendProposal(String senderId, String senderName) {
	
		this.senderId = senderId;
		this.senderName = senderName;
	}
	/**
	 * FriendProposal클래스 오버로딩 생성자
	 * @param senderId 송신자 아이디
	 */
	public FriendProposal(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * FriendProposal클래스 기본 생성자
	 */
	public FriendProposal() {
		this("sender", "senderName", "receiverId", "receiverName","proposalKind");
	}
	/**
	 * getter
	 * @return 송신자 아이디
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * setter
	 * @param senderId 송신자 아이디
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * getter
	 * @return 송신자 이름
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * setter
	 * @param senderName 송신자 이름
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * getter
	 * @return 수신자 아이디
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * setter
	 * @param receiverId 수신자 아이디
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * getter
	 * @return 제안종류
	 */
	public String getProposalKind() {
		return proposalKind;
	}
	/**
	 * setter
	 * @param proposalKind 제안종류
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
	 * FriendProposal객체의 데이터를 문자열화 하기위한 메소드
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
