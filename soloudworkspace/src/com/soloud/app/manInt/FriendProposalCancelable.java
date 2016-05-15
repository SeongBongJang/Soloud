package com.soloud.app.manInt;
public interface FriendProposalCancelable {
	/**
	 * 사용자의 친구 신청을 취소하는 메소드
	 * @param senderId 사용자아이디(코드)
	 * @param receiverId 받는 멤버아이디(코드)
	 * @return 성공적으로 거절을 완료하면 -true
	 */
	public boolean cancelFriendProposal(String senderId,String receiverId);
	/**
	 * 사용자의 친구 신청을 취소하는 메소드
	 * @param adminId 관리자 아이디(코드)
	 * @param senderId 사용자 아이디(코드)
	 * @param receiverId 사용자의 친구신청을 받는 멤버아이디(코드)
	 * @return 성공적으로 거절을 완료하면 -true
	 */
	public boolean cancelFriendProposal(String adminId,String senderId,String receiverId);
}
