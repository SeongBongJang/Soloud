package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * 공유폴더클래스
 * @author 영진
 *
 */
public class SharedFolder implements Serializable {

	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = -3126899982143549586L;
	/**
	 * 공유폴더코드
	 */
	private String sharedFolderCode;
	/**
	 * 폴더생성일자
	 */
	private GregorianCalendar createDate;
	/**
	 * 초대자(호스트) 아이디
	 */
	private String senderId;
	/**
	 * 공유폴더친구목록
	 */
	private SharedFolderFriendList sharedFolderFriendList;
	/**
	 * 댓글목록
	 */
	private ReplyList replyList;
	/**
	 * 공유폴더이름
	 */
	private String sharedFolderName;
	/**
	 * SharedFolder 오버로딩 생성자
	 * @param sharedFolderCode
	 * @param createDate
	 * @param senderId
	 * @param sharedFolderFriendList
	 * @param replyList
	 * @param sharedFolderName
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate,
			String senderId, SharedFolderFriendList sharedFolderFriendList,
			ReplyList replyList, String sharedFolderName) {
		this.sharedFolderCode = sharedFolderCode;
		this.createDate = createDate;
		this.senderId = senderId;
		this.sharedFolderFriendList = sharedFolderFriendList;
		this.replyList = replyList;
		this.sharedFolderName = sharedFolderName;
	}
	/**
	 * SharedFolder 오버로딩 생성자
	 * @param sharedFolderCode
	 * @param createDate
	 * @param senderId
	 * @param sharedFolderFriendList
	 * @param replyList
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate,
			String senderId, SharedFolderFriendList sharedFolderFriendList,
			ReplyList replyList) {
		this(sharedFolderCode, createDate, senderId, sharedFolderFriendList, replyList, "SharedFolderName");
	}
	/**
	 * SharedFolder 오버로딩 생성자
	 * @param sharedFolderCode
	 * @param createDate
	 * @param senderId
	 * @param sharedFolderFriendList
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate,
			String senderId, SharedFolderFriendList sharedFolderFriendList) {
		this(sharedFolderCode, createDate, senderId, sharedFolderFriendList, new ReplyList(), "SharedFolderName");
	}
	/**
	 * SharedFolder 오버로딩 생성자
	 * @param sharedFolderCode
	 * @param createDate
	 * @param senderId
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate,
			String senderId) {
		this(sharedFolderCode, createDate, senderId, new SharedFolderFriendList(), new ReplyList(), "SharedFolderName");
	}
	/**
	 * SharedFolder 오버로딩 생성자
	 * @param sharedFolderCode
	 * @param createDate
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate) {
		this(sharedFolderCode, createDate, "SenderId",new SharedFolderFriendList(), new ReplyList(), "SharedFolderName");
	}
	/**
	 * SharedFolder 오버로딩 생성자
	 * @param sharedFolderCode
	 */
	public SharedFolder(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	/**
	 * SharedFolder 기본 생성자
	 */
	public SharedFolder() {
		this("0000", new GregorianCalendar(), "SenderId", new SharedFolderFriendList(), new ReplyList(), "SharedFolderName");
	}
	/**
	 * getter
	 * @return 공유폴더코드
	 */
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	/**
	 * setter
	 * @param sharedFolderCode 공유폴더코드
	 */
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	/**
	 * getter 
	 * @return 공유폴더생성일자
	 */
	public GregorianCalendar getCreateDate() {
		return createDate;
	}
	/**
	 * setter
	 * @param createDate 공유폴더생성일자
	 */
	public void setCreateDate(GregorianCalendar createDate) {
		this.createDate = createDate;
	}
	/**
	 * getter
	 * @return 폴더생성자 아이디
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * setter
	 * @param senderId 폴더생성자 아이디
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * getter
	 * @return 공유폴더친구목록
	 */
	public SharedFolderFriendList getSharedFolderFriendList() {
		return sharedFolderFriendList;
	}
	/**
	 * setter
	 * @param sharedFolderFriendList 공유폴더친구목록
	 */
	public void setSharedFolderFriendList(
			SharedFolderFriendList sharedFolderFriendList) {
		this.sharedFolderFriendList = sharedFolderFriendList;
	}
	/**
	 * getter
	 * @return 댓글목록 
	 */
	public ReplyList getReplyList() {
		return replyList;
	}
	/**
	 * setter
	 * @param replyList 댓글목록
	 */
	public void setReplyList(ReplyList replyList) {
		this.replyList = replyList;
	}
	/**
	 * setter
	 * @return 공유폴더이름
	 */
	public String getSharedFolderName() {
		return sharedFolderName;
	}
	/**
	 * setter
	 * @param sharedFolderName 공유폴더이름
	 */
	public void setSharedFolderName(String sharedFolderName) {
		this.sharedFolderName = sharedFolderName;
	}
	/**
	 * 공유폴더정보데이터를 문자열화하기위한 메소드
	 */
	@Override
	public String toString() {
		return "SharedFolder [sharedFolderCode=" + sharedFolderCode
				+ ", createDate=" + createDate + ", senderId=" + senderId
				+ ", sharedFolderName=" + sharedFolderName + "]";
	}
	
	
}
