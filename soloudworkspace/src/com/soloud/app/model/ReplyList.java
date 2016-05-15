package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;




/**
 * Reply�� ����� Ŭ����. Reply����� �����ϱ����� Ŭ����
 * @author oong
 *
 */
public class ReplyList implements Serializable{
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = -1850658732827135166L;
	/**
	 * �� ȸ���� ��۸��
	 */
	private Hashtable<String, ArrayList<Reply>> replys;
	

	/**
	 * ReplyList�⺻ ������
	 */
	public ReplyList() {
		this(new Hashtable<String, ArrayList<Reply>>());
	}
	/**
	 * ReplyList �����ε� ������
	 * @param reply �������s
	 */
	public ReplyList(Hashtable<String, ArrayList<Reply>> replys) {
		this.replys = replys;
	}

	/**
	 * ��������� �߰��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param reply �������
	 * @return �߰������� �������� ������ true, ���н� false ����
	 */
	public boolean addReply(String sharedFolderCode, Reply reply) {
		if(replys.get(sharedFolderCode) ==null){
			replys.put(sharedFolderCode, new ArrayList<Reply>());
		} 
		return replys.get(sharedFolderCode).add(reply);
	}
	
	/**
	 * ��������� �߰��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @param content �ۼ�����
	 * @return �߰������� �������� ������ true, ���н� false ����
	 */
	public boolean addReply(String sharedFolderCode, String writerId, String content) {
		if(replys.get(sharedFolderCode) ==null){
			replys.put(sharedFolderCode, new ArrayList<Reply>());
		} 
		return replys.get(sharedFolderCode).add(new Reply(writerId, content, new GregorianCalendar()));
	}
	
	/**
	 * ��������� �߰��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @param content �ۼ�����
	 * @param writeDate �ۼ�����
	 * @return �߰������� �������� ������ true, ���н� false ����
	 */
	public boolean addReply(String sharedFolderCode, String writerId, String content, GregorianCalendar writeDate) {
		if(replys.get(sharedFolderCode) ==null){
			replys.put(sharedFolderCode, new ArrayList<Reply>());
		} 
		return replys.get(sharedFolderCode).add(new Reply(writerId, content, writeDate));
	}
	
	/**
	 * ��������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @param writeDate �ۼ�����
	 */
	public void deleteReply(String sharedFolderCode, String writerId, GregorianCalendar writeDate) {
		if(replys.get(sharedFolderCode) ==null){
			return;
		}  else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode) ;
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriterId().equals(writerId) && replyList.get(i).getWriteDate().equals(writeDate)){
					replyList.remove(i);
					return;
				}
					
			}
		}
	}
	
	/**
	 * ��������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 */
	public void deleteReply(String sharedFolderCode, String writerId) {
		if(replys.get(sharedFolderCode) ==null){
			return;
		}  else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode); 
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriterId().equals(writerId)){
					replyList.remove(i);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param sharedFolderCode ���������ڵ�
	 * @param reply �������
	 */
	public void deleteReply(String sharedFolderCode, Reply reply) {
		if(replys.get(sharedFolderCode) ==null){
			return;
		}  else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode); 
			replyList.remove(reply);
		}
	}
	
	/**
	 * ��������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param startDate ������
	 * @param endDate ����
	 */
	public void deleteReply(String sharedFolderCode, GregorianCalendar startDate, GregorianCalendar endDate) {
		if(replys.get(sharedFolderCode) ==null){
			return;
		} else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode);
			int year = startDate.get(Calendar.YEAR);
			int month = startDate.get(Calendar.MONTH)+1;
			int day = startDate.get(Calendar.DATE);
			////
		}
	}
	
	/**
	 * ��������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @param writeDate �ۼ�����
	 * @param reply �������
	 */
	public void modifyReply(String sharedFolderCode, String writerId, GregorianCalendar writeDate, Reply reply) {
		if(replys.get(sharedFolderCode) ==null){
			return;
		} else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode);
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriteDate().equals(writeDate) && replyList.get(i).getWriterId().equals(writerId)){
					replyList.set(i, reply);
					return;
				}
			}
		}
	}
	
	/**
	 * ��������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @param writeDate �ۼ�����
	 * @param content �ۼ�����
	 */
	public void modifyReply(String sharedFolderCode, String writerId, GregorianCalendar writeDate, String content) {
		if(replys.get(sharedFolderCode) ==null){
			return;
		} else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode);
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriteDate().equals(writeDate) && replyList.get(i).getWriterId().equals(writerId)){
					replyList.get(i).setContent(content);
					return;
				}
			}
		}
	}
	
	/**
	 * ��������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @return �˻���� ��۸��, �˻������ ������������ ��� null ����
	 */
	public ArrayList<Reply> searchReplyWriterId(String sharedFolderCode, String writerId) {
		ArrayList<Reply> returnList = new ArrayList<Reply>();
		if(replys.get(sharedFolderCode) ==null){
			return null;
		} else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode);
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriterId().equals(writerId)){
					returnList.add(replyList.get(i));
				}
			}
			if(returnList.isEmpty()){
				return null;
			}
			return returnList;
		}
	}
	
	/**
	 * ��������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param writerId �ۼ��� ���̵�
	 * @param writeDate �ۼ�����
	 * @return �˻���� ���, �˻������ ������������ ��� null ����
	 */
	public Reply searchReplyWriterId(String sharedFolderCode, String writerId, GregorianCalendar writeDate) {
		if(replys.get(sharedFolderCode) ==null){
			return null;
		} else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode);
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriterId().equals(writerId) && replyList.get(i).getWriteDate().equals(writeDate)){
					return replyList.get(i);
				}
			}
			return null;
		}
	}
	
	/**
	 * ��������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @param startDate ������
	 * @param endDate ����
	 * @return �˻���� ��۸��, �˻������ ������������ ��� null ����
	 */
	public ArrayList<Reply> searchReplyWriteDate(String sharedFolderCode, GregorianCalendar startDate, GregorianCalendar endDate) {
		ArrayList<Reply> returnList = new ArrayList<Reply>();
		if(replys.get(sharedFolderCode) ==null){
			return null;
		} else {
			ArrayList<Reply> replyList = replys.get(sharedFolderCode);
			for(int i=0;i<replyList.size();i++){
				if(replyList.get(i).getWriteDate().compareTo(startDate) > 0 && replyList.get(i).getWriteDate().compareTo(endDate) < 0){
					returnList.add(replyList.get(i));
				}
			}
			if(returnList.isEmpty()){
				return null;
			}
			return returnList;
		}
	}
	
	/**
	 * ��������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode ���������ڵ�
	 * @return �˻���� ��۸��, �˻������ ������������ ��� null ����
	 */
	public ArrayList<Reply> searchReply(String sharedFolderCode) {
		if(replys.get(sharedFolderCode) ==null){
			return null;
		} else {
			return replys.get(sharedFolderCode);
		}
	}
	/**
	 * �� ȸ���� ��۸���� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "ReplyList [replys=" + replys + "]";
	}
	/**
	 * getter
	 * @return
	 */
	public Hashtable<String, ArrayList<Reply>> getReplys() {
		return replys;
	}
	/**
	 * setter
	 * @param reply �������s
	 */
	public void setReplys(Hashtable<String, ArrayList<Reply>> replys) {
		this.replys = replys;
	}
	
	
}
