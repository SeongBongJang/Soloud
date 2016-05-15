package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.FriendProposal;

public interface FriendProposalSearchable {
	/**
	 * 친구제안을 검색하는 메소드
	 * @param senderId 친구신청을 한  아이디(코드)
	 * @param receiverId 친구제안 받는 멤버 아이디(코드)
	 * @return 
	 */
	public FriendProposal searchFriendProposal(String senderId,String receiverId);
	/**
	 * 보낸사람 아이디(코드)로 친구제안을 검색하는 메소드
	 * @param senderId 친구신청을 한  아이디(코드)
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalSenderId(String senderId);
	/**
	 * 보낸사람 이름으로 친구 제안을 검색하는 메소드
	 * @param receiverId 친구신청을 받는 멤버 아이디(코드)
	 * @param senderName 친구신청을 한  사용자 이름
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalSenderName(String receiverId,String senderName);
	/**
	 * 친구 제안을 검색하는 메소드
	 * @param senderId 친구 신청을 한 멤버 아이디(코드)
	 * @param receiverName 친구 신청을 받는 멤버 아이디(코드)
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalReceiverName(String senderId,String receiverName);
	/**
	 * 친구 제안을 검색하는 메소드
	 * @param receiverId 친구 신청을 받는 멤버 아이디(코드)
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalReceiverId(String receiverId);
}
