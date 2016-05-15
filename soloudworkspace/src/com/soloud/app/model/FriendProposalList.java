package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;





/**
 * FriendProposal�� ����� Ŭ����
 * @author oong
 *
 */
public class FriendProposalList implements Serializable{
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 4052535252595482674L;
	/**
	 * ģ������ ���
	 */
	private ArrayList<FriendProposal> friendProposals;
	
	
	/**
	 * FriendPrposaList �⺻ ������
	 */
	public FriendProposalList() {
		this(new ArrayList<FriendProposal>());
	}
	/**
	 * FriendProposalList �����ε� ������
	 * @param friendProposals ģ�����ȸ��
	 */
	public FriendProposalList(ArrayList<FriendProposal> friendProposals) {
		this.friendProposals = friendProposals;
	}

	/**
	 * ģ������������ �߰��ϱ����� �޼ҵ�
	 * @param friendProposal FriendProposal��ü, ģ����������
	 * @return �������߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFriendProposal(FriendProposal friendProposal) {
		return friendProposals.add(friendProposal);
	
	}
	
	/**
	 * ģ������������ �߰��ϱ����� �޼ҵ�
	 * @param senderId �۽��� ���̵�
	 * @param senderName �۽��� �̸�
	 * @param receiveId ������ ���̵�
	 * @param proposalKind
	 * @return �������߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFriendProposal(String senderId, String senderName, String receiveId, String receiveName,String proposalKind) {
		return friendProposals.add(new FriendProposal(senderId, senderName, receiveId,receiveName, proposalKind));
	}
	
	/**
	 * ģ������������ �����ϱ����� �޼ҵ�
	 * @param senderId
	 */
	public void deleteFriendProposal(String senderId) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId)){
				friendProposals.remove(i);
				return;
			}
		}
	}
	
	/**
	 * ģ�����ȸ���� �����ϱ����� �޼ҵ�
	 * @param friendProposal
	 */
	public void deleteFriendProposal(FriendProposal friendProposal) {
		friendProposals.remove(friendProposal);
	}
	
	/**
	 * ģ������������ �����ϱ����� �޼ҵ�
	 * @param senderId �۽��� ���̵�
	 * @param receiverId ������ ���̵�
	 * @param newFriendProposal ������ FriendProposal��ü. ģ����������
	 */
	public void modifyFriendProposal(String senderId, String receiverId, FriendProposal newFriendProposal) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId) ){
				friendProposals.set(i, newFriendProposal);
			}
		}
	}
	
	/**
	 * ģ������������ �����ϱ����� �޼ҵ�
	 * @param senderId �۽��� ���̵�
	 * @param receiverId ������ ���̵�
	 * @param newSenderName ������ �۽��� �̸�
	 */
	public void modifyFriendProposalSenderName(String senderId, String receiverId, String newSenderName) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId) ){
				friendProposals.get(i).setSenderName(newSenderName);
			}
		}
	}
	
	/**
	 * ģ������������ �����ϱ����� �޼ҵ�
	 * @param senderId �۽��� ���̵�
	 * @param receiverId ������ ���̵�
	 * @param proposalKind ��������
	 */
	public void modifyFriendProposalKind(String senderId, String receiverId, String proposalKind) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId) ){
				friendProposals.get(i).setProposalKind(proposalKind);
			}
		}
	}
	
	/**
	 * ģ������������ �˻��ϱ����� �޼ҵ�
	 * @param senderId �۽��� ���̵�
	 * @return ģ�����ȸ��. �˻������ ������������ ��� null ����
	 */
	public ArrayList<FriendProposal> searchFriendProposalSenderId(String senderId) {
		ArrayList<FriendProposal> returnList = new ArrayList<FriendProposal>();
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId)){
				returnList.add(friendProposals.get(i));
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	
	/**
	 * ģ������������ �˻��ϱ����� �޼ҵ�
	 * @param receiverId ������ ���̵�
	 * @return ģ�����ȸ��. �˻������ ������������ ��� null ����
	 */
	public ArrayList<FriendProposal> searchFriendProposalReceiverId(String receiverId) {
		ArrayList<FriendProposal> returnList = new ArrayList<FriendProposal>();
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getReceiverId().equals(receiverId)){
				returnList.add(friendProposals.get(i));
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	
	/**
	 * ģ������������ �˻��ϱ����� �޼ҵ�
	 * @param senderId �۽��� ���̵�
	 * @param receiverId ������ ���̵�
	 * @return ģ����������. �˻������ ������������ ��� null ����
	 */
	public FriendProposal searchFriendProposal(String senderId, String receiverId) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId)){
				return friendProposals.get(i);
			}
		}
		return null;
	}
	
	/**
	 * ģ������������ �˻��ϱ����� �޼ҵ�
	 * @param senderName
	 * @return ģ�����ȸ��. �˻������ ������������ ��� null ����
	 */
	public ArrayList<FriendProposal> searchFriendProposalSenderName(String senderName) {
		ArrayList<FriendProposal> returnList = new ArrayList<FriendProposal>();
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderName().equals(senderName)){
				returnList.add(friendProposals.get(i));
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	/**
	 * getter
	 * @return ģ�����ȸ��
	 */
	public ArrayList<FriendProposal> getFriendProposals() {
		return friendProposals;
	}
	/**
	 * setter
	 * @param friendProposals ģ�����ȸ��
	 */
	public void setFriendProposals(ArrayList<FriendProposal> friendProposals) {
		this.friendProposals = friendProposals;
	}
	/**
	 * ģ�����ȸ���� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "FriendProposalList [friendProposals=" + friendProposals + "]";
	}
	

}
