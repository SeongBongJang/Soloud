package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;




/**
 * Reply의 목록형 클래스. Reply목록을 관리하기위한 클래스
 * @author oong
 *
 */
public class ReplyList implements Serializable{
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = -1850658732827135166L;
	/**
	 * 각 회원별 댓글목록
	 */
	private Hashtable<String, ArrayList<Reply>> replys;
	

	/**
	 * ReplyList기본 생성자
	 */
	public ReplyList() {
		this(new Hashtable<String, ArrayList<Reply>>());
	}
	/**
	 * ReplyList 오버로딩 생성자
	 * @param reply 댓글정보s
	 */
	public ReplyList(Hashtable<String, ArrayList<Reply>> replys) {
		this.replys = replys;
	}

	/**
	 * 댓글정보를 추가하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param reply 댓글정보
	 * @return 추가에대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addReply(String sharedFolderCode, Reply reply) {
		if(replys.get(sharedFolderCode) ==null){
			replys.put(sharedFolderCode, new ArrayList<Reply>());
		} 
		return replys.get(sharedFolderCode).add(reply);
	}
	
	/**
	 * 댓글정보를 추가하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @param content 작성내용
	 * @return 추가에대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addReply(String sharedFolderCode, String writerId, String content) {
		if(replys.get(sharedFolderCode) ==null){
			replys.put(sharedFolderCode, new ArrayList<Reply>());
		} 
		return replys.get(sharedFolderCode).add(new Reply(writerId, content, new GregorianCalendar()));
	}
	
	/**
	 * 댓글정보를 추가하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @param content 작성내용
	 * @param writeDate 작성일자
	 * @return 추가에대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addReply(String sharedFolderCode, String writerId, String content, GregorianCalendar writeDate) {
		if(replys.get(sharedFolderCode) ==null){
			replys.put(sharedFolderCode, new ArrayList<Reply>());
		} 
		return replys.get(sharedFolderCode).add(new Reply(writerId, content, writeDate));
	}
	
	/**
	 * 댓글정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @param writeDate 작성일자
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
	 * 댓글정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
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
	 * @param sharedFolderCode 공유폴더코드
	 * @param reply 댓글정보
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
	 * 댓글정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param startDate 시작일
	 * @param endDate 끝일
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
	 * 댓글정보를 수정하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @param writeDate 작성일자
	 * @param reply 댓글정보
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
	 * 댓글정보를 수정하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @param writeDate 작성일자
	 * @param content 작성내용
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
	 * 댓글정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @return 검색결과 댓글목록, 검색결과가 존재하지않을 경우 null 리턴
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
	 * 댓글정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param writerId 작성자 아이디
	 * @param writeDate 작성일자
	 * @return 검색결과 댓글, 검색결과가 존재하지않을 경우 null 리턴
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
	 * 댓글정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @param startDate 시작일
	 * @param endDate 끝일
	 * @return 검색결과 댓글목록, 검색결과가 존재하지않을 경우 null 리턴
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
	 * 댓글정보를 검색하기위한 메소드
	 * @param sharedFolderCode 공유폴더코드
	 * @return 검색결과 댓글목록, 검색결과가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<Reply> searchReply(String sharedFolderCode) {
		if(replys.get(sharedFolderCode) ==null){
			return null;
		} else {
			return replys.get(sharedFolderCode);
		}
	}
	/**
	 * 각 회원별 댓글목록을 문자열화하기위한 메소드
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
	 * @param reply 댓글정보s
	 */
	public void setReplys(Hashtable<String, ArrayList<Reply>> replys) {
		this.replys = replys;
	}
	
	
}
