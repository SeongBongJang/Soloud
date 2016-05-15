package com.soloud.app.manInt;

import com.soloud.app.model.Group;

public interface FriendProposalAcceptable {
	/**
	 * 친구 제안을 수락하는 메소드
	 * @param id 사용자 아이디(코드)
	 * @param friendId 친구 신청을 보낸 친구아이디(멤버코드)
	 * @return 성공적으로 수락 완료시 -true
	 */
	public boolean acceptFriendProposal(String id,String friendId);
	/**
	 * 친구 제안을 수락하는 관리자 메소드
	 * @param adminId 관리자 아이디(코드)
	 * @param memberId 관리자가 관리하는 사용자 아이디(코드)
	 * @param friendId 사용자에게 친구신청을 보낸 멤버아이디(코드)
	 * @return
	 */
	public boolean acceptFriendProposal(String adminId, String memberId,String friendId);
}
