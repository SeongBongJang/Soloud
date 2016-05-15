package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * ��������Ŭ����
 * @author ����
 *
 */
public class SharedFolder implements Serializable {

	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = -3126899982143549586L;
	/**
	 * ���������ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * ������������
	 */
	private GregorianCalendar createDate;
	/**
	 * �ʴ���(ȣ��Ʈ) ���̵�
	 */
	private String senderId;
	/**
	 * ��������ģ�����
	 */
	private SharedFolderFriendList sharedFolderFriendList;
	/**
	 * ��۸��
	 */
	private ReplyList replyList;
	/**
	 * ���������̸�
	 */
	private String sharedFolderName;
	/**
	 * SharedFolder �����ε� ������
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
	 * SharedFolder �����ε� ������
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
	 * SharedFolder �����ε� ������
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
	 * SharedFolder �����ε� ������
	 * @param sharedFolderCode
	 * @param createDate
	 * @param senderId
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate,
			String senderId) {
		this(sharedFolderCode, createDate, senderId, new SharedFolderFriendList(), new ReplyList(), "SharedFolderName");
	}
	/**
	 * SharedFolder �����ε� ������
	 * @param sharedFolderCode
	 * @param createDate
	 */
	public SharedFolder(String sharedFolderCode, GregorianCalendar createDate) {
		this(sharedFolderCode, createDate, "SenderId",new SharedFolderFriendList(), new ReplyList(), "SharedFolderName");
	}
	/**
	 * SharedFolder �����ε� ������
	 * @param sharedFolderCode
	 */
	public SharedFolder(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	/**
	 * SharedFolder �⺻ ������
	 */
	public SharedFolder() {
		this("0000", new GregorianCalendar(), "SenderId", new SharedFolderFriendList(), new ReplyList(), "SharedFolderName");
	}
	/**
	 * getter
	 * @return ���������ڵ�
	 */
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	/**
	 * setter
	 * @param sharedFolderCode ���������ڵ�
	 */
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	/**
	 * getter 
	 * @return ����������������
	 */
	public GregorianCalendar getCreateDate() {
		return createDate;
	}
	/**
	 * setter
	 * @param createDate ����������������
	 */
	public void setCreateDate(GregorianCalendar createDate) {
		this.createDate = createDate;
	}
	/**
	 * getter
	 * @return ���������� ���̵�
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * setter
	 * @param senderId ���������� ���̵�
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * getter
	 * @return ��������ģ�����
	 */
	public SharedFolderFriendList getSharedFolderFriendList() {
		return sharedFolderFriendList;
	}
	/**
	 * setter
	 * @param sharedFolderFriendList ��������ģ�����
	 */
	public void setSharedFolderFriendList(
			SharedFolderFriendList sharedFolderFriendList) {
		this.sharedFolderFriendList = sharedFolderFriendList;
	}
	/**
	 * getter
	 * @return ��۸�� 
	 */
	public ReplyList getReplyList() {
		return replyList;
	}
	/**
	 * setter
	 * @param replyList ��۸��
	 */
	public void setReplyList(ReplyList replyList) {
		this.replyList = replyList;
	}
	/**
	 * setter
	 * @return ���������̸�
	 */
	public String getSharedFolderName() {
		return sharedFolderName;
	}
	/**
	 * setter
	 * @param sharedFolderName ���������̸�
	 */
	public void setSharedFolderName(String sharedFolderName) {
		this.sharedFolderName = sharedFolderName;
	}
	/**
	 * �����������������͸� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "SharedFolder [sharedFolderCode=" + sharedFolderCode
				+ ", createDate=" + createDate + ", senderId=" + senderId
				+ ", sharedFolderName=" + sharedFolderName + "]";
	}
	
	
}
