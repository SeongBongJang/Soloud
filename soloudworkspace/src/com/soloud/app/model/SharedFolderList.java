package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * 공유폴더를 관리하기위한 목록형 클래스
 * @author oong
 *
 */
public class SharedFolderList implements Serializable{
	/**
	 * 시리얼 버전 아이디 
	 */
	private static final long serialVersionUID = 7268010534988988930L;
	/**
	 * 공유폴더 목록
	 */
	private ArrayList<SharedFolder> sharedFolders;
	
	/**
	 * SharedFolderList 클래스 기본생성자
	 */
	public SharedFolderList() {
		this(new ArrayList<SharedFolder>());
	}
	/**
	 * SharedFolderList 클래스 오버로딩 생성자
	 * @param sharedFolders 공유폴더목록
	 */
	public SharedFolderList(ArrayList<SharedFolder> sharedFolders) {
		this.sharedFolders = sharedFolders;
	}

	/**
	 * 공유폴더목록에 공유폴더정보를 추가하기위한 메소드
	 * @param sharedFolder 추가할 공유폴더정보
	 * @return
	 */
	public boolean addSharedFolder(SharedFolder sharedFolder) {
		return sharedFolders.add(sharedFolder);
	}
	
	/**
	 * 공유폴더목록에 공유폴더정보를 추가하기위한 메소드
	 * @param sharedFolderName 추가할 공유폴더이름
	 * @param senderId 추가할 공유폴더의 생성자(초대자 및 호스트) 아이디
	 * @return
	 */
	public boolean addSharedFolder(String sharedFolderName, String senderId) {
		return sharedFolders.add(new SharedFolder("0000", new GregorianCalendar(), senderId, new SharedFolderFriendList(), new ReplyList(), sharedFolderName));
	}	
	
	/**
	 * 공유폴더목록에서 공유폴더정보를 삭제하기위한 메소드
	 * @param sharedFolderCode 색인자로 사용될 공유폴더 코드
	 */
	public void deleteSharedFolder(String sharedFolderCode) {
		for(int i=0;i<sharedFolders.size();i++){
			if(sharedFolders.get(i).getSharedFolderCode().equals(sharedFolderCode)){
				sharedFolders.remove(i);
				return;
			}
		}
	}
	
	/**
	 * 공유폴더목록에서 공유폴더정보를 수정하기위한 메소드
	 * @param sharedFolderCode 색인자로 사용될 공유폴더 코드
	 * @param newSharedFolderName 새롭게 적용될 공유폴더명
	 */
	public void modifySharedFolder(String sharedFolderCode, String newSharedFolderName) {
		SharedFolder temp = searchSharedFolderCode(sharedFolderCode);
		if(temp != null){
			temp.setSharedFolderName(newSharedFolderName);
		} 
	}
	
	/**
	 * 공유폴더목록에서 공유폴더정보를 수정하기위한 메소드
	 * @param sharedFolderCode 색인자로 사용될 공유폴더 코드
	 * @param newSharedFolderFriendList 새롭게 적용될 공유폴더 친구목록 정보
	 */
	public void modifySharedFolder(String sharedFolderCode, SharedFolderFriendList newSharedFolderFriendList) {
		SharedFolder temp = searchSharedFolderCode(sharedFolderCode);
		if(temp != null){
			temp.setSharedFolderFriendList(newSharedFolderFriendList);
		} 
	}
	
	/**
	 * 공유폴더목록에서 공유폴더정보를 검색하기위한 메소드
	 * @param sharedFolderCode 색인자로 사용될 공유폴더 코드
	 * @return 공유폴더 정보. 검색결과가 존재하지않을 경우 null 리턴
	 */
	public SharedFolder searchSharedFolderCode(String sharedFolderCode) {
		for(int i=0;i<sharedFolders.size();i++){
			if(sharedFolders.get(i).getSharedFolderCode().equals(sharedFolderCode)){
				return sharedFolders.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 공유폴더목록에서 공유폴더정보를 검색하기위한 메소드
	 * @param sharedFolderName 색인자로 사용될 공유폴더 이름
	 * @return 공유폴더목록. 검색결과 존재하지 않을 경우 null 리턴
	 */ 
	public ArrayList<SharedFolder> searchSharedFolderName(String sharedFolderName) {
		ArrayList<SharedFolder> returnList = new ArrayList<SharedFolder>();
		for(int i=0;i<sharedFolders.size();i++){
			if(sharedFolders.get(i).getSharedFolderName().equals(sharedFolderName)){
				returnList.add(sharedFolders.get(i));
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	
	/**
	 * 공유폴더목록에서 공유폴더정보를 검색하기위한 메소드
	 * @param senderId
	 * @return 공유폴더목록. 검색결과 존재하지 않을 경우 null 리턴
	 */
	public ArrayList<SharedFolder> searchSharedFolderSender(String senderId) {
		ArrayList<SharedFolder> returnList = new ArrayList<SharedFolder>();
		for(int i=0;i<sharedFolders.size();i++){
			if(sharedFolders.get(i).getSenderId().equals(senderId)){
				returnList.add(sharedFolders.get(i));
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	/**
	 * getter
	 * @return 공유폴더목록
	 */
	public ArrayList<SharedFolder> getSharedFolders() {
		return sharedFolders;
	}
	/**
	 * setter
	 * @param sharedFolders 공유폴더목록
	 */
	public void setSharedFolders(ArrayList<SharedFolder> sharedFolders) {
		this.sharedFolders = sharedFolders;
	}
	/**
	 * 공유폴더목록의 데이터를 문자열화하기위한 메소드
	 */
	@Override
	public String toString() {
		return "SharedFolderList [sharedFolders=" + sharedFolders + "]";
	}
	
}
