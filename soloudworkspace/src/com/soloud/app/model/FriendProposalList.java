package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;





/**
 * FriendProposal의 목록형 클래스
 * @author oong
 *
 */
public class FriendProposalList implements Serializable{
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 4052535252595482674L;
	/**
	 * 친구제안 목록
	 */
	private ArrayList<FriendProposal> friendProposals;
	
	
	/**
	 * FriendPrposaList 기본 생성자
	 */
	public FriendProposalList() {
		this(new ArrayList<FriendProposal>());
	}
	/**
	 * FriendProposalList 오버로딩 생성자
	 * @param friendProposals 친구제안목록
	 */
	public FriendProposalList(ArrayList<FriendProposal> friendProposals) {
		this.friendProposals = friendProposals;
	}

	/**
	 * 친구제안정보를 추가하기위한 메소드
	 * @param friendProposal FriendProposal객체, 친구제안정보
	 * @return 데이터추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFriendProposal(FriendProposal friendProposal) {
		return friendProposals.add(friendProposal);
	
	}
	
	/**
	 * 친구제안정보를 추가하기위한 메소드
	 * @param senderId 송신자 아이디
	 * @param senderName 송신자 이름
	 * @param receiveId 수신자 아이디
	 * @param proposalKind
	 * @return 데이터추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFriendProposal(String senderId, String senderName, String receiveId, String receiveName,String proposalKind) {
		return friendProposals.add(new FriendProposal(senderId, senderName, receiveId,receiveName, proposalKind));
	}
	
	/**
	 * 친구제안정보를 삭제하기위한 메소드
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
	 * 친구제안목록을 삭제하기위한 메소드
	 * @param friendProposal
	 */
	public void deleteFriendProposal(FriendProposal friendProposal) {
		friendProposals.remove(friendProposal);
	}
	
	/**
	 * 친구제안정보를 수정하기위한 메소드
	 * @param senderId 송신자 아이디
	 * @param receiverId 수신자 아이디
	 * @param newFriendProposal 수정할 FriendProposal객체. 친구제안정보
	 */
	public void modifyFriendProposal(String senderId, String receiverId, FriendProposal newFriendProposal) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId) ){
				friendProposals.set(i, newFriendProposal);
			}
		}
	}
	
	/**
	 * 친구제안정보를 수정하기위한 메소드
	 * @param senderId 송신자 아이디
	 * @param receiverId 수신자 아이디
	 * @param newSenderName 수정할 송신자 이름
	 */
	public void modifyFriendProposalSenderName(String senderId, String receiverId, String newSenderName) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId) ){
				friendProposals.get(i).setSenderName(newSenderName);
			}
		}
	}
	
	/**
	 * 친구제안정보를 수정하기위한 메소드
	 * @param senderId 송신자 아이디
	 * @param receiverId 수신자 아이디
	 * @param proposalKind 제안종류
	 */
	public void modifyFriendProposalKind(String senderId, String receiverId, String proposalKind) {
		for(int i=0;i<friendProposals.size();i++){
			if(friendProposals.get(i).getSenderId().equals(senderId) && friendProposals.get(i).getReceiverId().equals(receiverId) ){
				friendProposals.get(i).setProposalKind(proposalKind);
			}
		}
	}
	
	/**
	 * 친구제안정보를 검색하기위한 메소드
	 * @param senderId 송신자 아이디
	 * @return 친구제안목록. 검색결과가 존재하지않을 경우 null 리턴
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
	 * 친구제안정보를 검색하기위한 메소드
	 * @param receiverId 수신자 아이디
	 * @return 친구제안목록. 검색결과가 존재하지않을 경우 null 리턴
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
	 * 친구제안정보를 검색하기위한 메소드
	 * @param senderId 송신자 아이디
	 * @param receiverId 수신자 아이디
	 * @return 친구제안정보. 검색결과가 존재하지않을 경우 null 리턴
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
	 * 친구제안정보를 검색하기위한 메소드
	 * @param senderName
	 * @return 친구제안목록. 검색결과가 존재하지않을 경우 null 리턴
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
	 * @return 친구제안목록
	 */
	public ArrayList<FriendProposal> getFriendProposals() {
		return friendProposals;
	}
	/**
	 * setter
	 * @param friendProposals 친구제안목록
	 */
	public void setFriendProposals(ArrayList<FriendProposal> friendProposals) {
		this.friendProposals = friendProposals;
	}
	/**
	 * 친구제안목록을 문자열화하기위한 메소드
	 */
	@Override
	public String toString() {
		return "FriendProposalList [friendProposals=" + friendProposals + "]";
	}
	

}
