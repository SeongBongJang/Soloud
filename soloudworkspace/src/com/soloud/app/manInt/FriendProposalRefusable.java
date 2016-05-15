package com.soloud.app.manInt;

public interface FriendProposalRefusable {
	/**
	 * ģ�� ��û�� �����ϴ� �޼ҵ�
	 * @param senderId ģ�� ��û�� ���� ��� ���̵�(�ڵ�)
	 * @param receiverId ģ�� ��û�� ���� ���̵�(�ڵ�)
	 * @return
	 */
	public boolean refuseFriendProposal(String senderId,String receiverId);
	/**
	 * ģ�� ��û�� �����ϴ� �޼ҵ�
	 * @param adminId ������ ���̵�(�ڵ�)
	 * @param senderId ģ�� ��û�� ���� ������̵�(�ڵ�)
	 * @param receiverId ģ�� ��û�� ���� ���̵�(�ڵ�)
	 * @return
	 */
	public boolean refuseFriendProposal(String adminId,String senderId,String receiverId);
}
