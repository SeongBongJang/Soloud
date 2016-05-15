package com.soloud.app.manInt;

public interface FriendProposalRefusable {
	/**
	 * 친구 신청을 거절하는 메소드
	 * @param senderId 친구 신청을 보낸 멤버 아이디(코드)
	 * @param receiverId 친구 신청을 받은 아이디(코드)
	 * @return
	 */
	public boolean refuseFriendProposal(String senderId,String receiverId);
	/**
	 * 친구 신청을 거절하는 메소드
	 * @param adminId 관리자 아이디(코드)
	 * @param senderId 친구 신청을 보낸 멤버아이디(코드)
	 * @param receiverId 친구 신청을 받은 아이디(코드)
	 * @return
	 */
	public boolean refuseFriendProposal(String adminId,String senderId,String receiverId);
}
