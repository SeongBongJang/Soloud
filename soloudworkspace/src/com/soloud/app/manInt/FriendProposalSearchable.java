package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.FriendProposal;

public interface FriendProposalSearchable {
	/**
	 * ģ�������� �˻��ϴ� �޼ҵ�
	 * @param senderId ģ����û�� ��  ���̵�(�ڵ�)
	 * @param receiverId ģ������ �޴� ��� ���̵�(�ڵ�)
	 * @return 
	 */
	public FriendProposal searchFriendProposal(String senderId,String receiverId);
	/**
	 * ������� ���̵�(�ڵ�)�� ģ�������� �˻��ϴ� �޼ҵ�
	 * @param senderId ģ����û�� ��  ���̵�(�ڵ�)
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalSenderId(String senderId);
	/**
	 * ������� �̸����� ģ�� ������ �˻��ϴ� �޼ҵ�
	 * @param receiverId ģ����û�� �޴� ��� ���̵�(�ڵ�)
	 * @param senderName ģ����û�� ��  ����� �̸�
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalSenderName(String receiverId,String senderName);
	/**
	 * ģ�� ������ �˻��ϴ� �޼ҵ�
	 * @param senderId ģ�� ��û�� �� ��� ���̵�(�ڵ�)
	 * @param receiverName ģ�� ��û�� �޴� ��� ���̵�(�ڵ�)
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalReceiverName(String senderId,String receiverName);
	/**
	 * ģ�� ������ �˻��ϴ� �޼ҵ�
	 * @param receiverId ģ�� ��û�� �޴� ��� ���̵�(�ڵ�)
	 * @return
	 */
	public ArrayList<FriendProposal> searchFriendProposalReceiverId(String receiverId);
}
