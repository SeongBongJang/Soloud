package com.soloud.app.manInt;

import com.soloud.app.model.Group;

public interface FriendProposalAcceptable {
	/**
	 * ģ�� ������ �����ϴ� �޼ҵ�
	 * @param id ����� ���̵�(�ڵ�)
	 * @param friendId ģ�� ��û�� ���� ģ�����̵�(����ڵ�)
	 * @return ���������� ���� �Ϸ�� -true
	 */
	public boolean acceptFriendProposal(String id,String friendId);
	/**
	 * ģ�� ������ �����ϴ� ������ �޼ҵ�
	 * @param adminId ������ ���̵�(�ڵ�)
	 * @param memberId �����ڰ� �����ϴ� ����� ���̵�(�ڵ�)
	 * @param friendId ����ڿ��� ģ����û�� ���� ������̵�(�ڵ�)
	 * @return
	 */
	public boolean acceptFriendProposal(String adminId, String memberId,String friendId);
}
