package com.soloud.app.manInt;
public interface FriendProposalCancelable {
	/**
	 * ������� ģ�� ��û�� ����ϴ� �޼ҵ�
	 * @param senderId ����ھ��̵�(�ڵ�)
	 * @param receiverId �޴� ������̵�(�ڵ�)
	 * @return ���������� ������ �Ϸ��ϸ� -true
	 */
	public boolean cancelFriendProposal(String senderId,String receiverId);
	/**
	 * ������� ģ�� ��û�� ����ϴ� �޼ҵ�
	 * @param adminId ������ ���̵�(�ڵ�)
	 * @param senderId ����� ���̵�(�ڵ�)
	 * @param receiverId ������� ģ����û�� �޴� ������̵�(�ڵ�)
	 * @return ���������� ������ �Ϸ��ϸ� -true
	 */
	public boolean cancelFriendProposal(String adminId,String senderId,String receiverId);
}
