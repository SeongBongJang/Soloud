package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Folder의 목록형 클래스
 */
public class FolderList implements Serializable{
	/**
	 * 시리얼버전 아이디
	 */
	private static final long serialVersionUID = -3817043298673925475L;
	/**
	 * 사용자의 아이디와 폴더목록을 매핑시킨 테이블
	 */
	private Hashtable<String,ArrayList<Folder>> folderList;
	
	/**
	 * FolderList 오버로딩 생성자
	 * @param folderList 회원 아이디별 폴더목록
	 */
	public FolderList(Hashtable<String, ArrayList<Folder>> folderList) {
		
		this.folderList = folderList;
	}
	
	/**
	 * FolderList 기본생성자
	 */
	public FolderList() {
		this(new Hashtable<String, ArrayList<Folder>>());
	}


	/**
	 * 
	 * @param id 사용자 아이디
	 * @param folder Folder객체
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false
	 */
	public boolean addFolder(String id, Folder folder) {
		if(folderList.get(id) == null){
			folderList.put(id, new ArrayList<Folder>());
		} 
		return folderList.get(id).add(folder);
	}
	
	/**
	 * Folder객체를 리스트에 추가하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderPath 폴더의 경로
	 * @param folderName 폴더명
	 * @param folderCapacity 폴더의 용량
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false
	 */
	public boolean addFolder(String id, String folderPath, String folderName, float folderCapacity) {
		if(folderList.get(id) == null){
			folderList.put(id, new ArrayList<Folder>());
		} 
		return folderList.get(id).add(new Folder(folderPath, folderName, folderCapacity));
	}
	/**
	 * Folder객체를 리스트에 추가하기위한 메소드
	 * @param id 사용자 아아디
	 * @param parentFolderCode 부모폴더 코드
	 * @param folderCode 폴더코드
	 * @param folderName 폴더명
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false
	 */
	public boolean addFolder(String id, String parentFolderCode, String folderCode, String folderName){
		if(folderList.get(id) == null){
			folderList.put(id, new ArrayList<Folder>());
		} 
		return folderList.get(id).add(new Folder(parentFolderCode, folderCode , folderName));
	}
	/**
	 * 목록에서 Folder객체를 제거하기위한 메소드
	 * @param id 사용자 아이디
	 */
	public void deleteFolder(String id) {
		if(folderList.get(id) == null){
			return;
		} else {
			folderList.remove(id);
		}
	}
	/**
	 * 목록에서 Folder객체를 제거하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderCode 폴더코드
	 */
	public void deleteFolderCode(String id, String folderCode){
		if(folderList.get(id) == null){
			return;
		} else {
			folderList.get(id).remove(searchFolderCode(id, folderCode));
		}
	}
	/**
	 * 목록에서 Folder객체를 제거하기위한 메소드
	 * @param id 사용자 아이디
	 * @param parentFolderCode 부모폴더 코드
	 */
	public void deleteFolderParent(String id, String parentFolderCode){
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> idList = folderList.get(id);
			ArrayList<Folder> pList = searchFolderParent(id, parentFolderCode);
			for(int i=0;i<idList.size();i++){
				for(int j=0;j<pList.size();j++){
					if(idList.get(i).getParentFolderCode().equals(pList.get(j).getParentFolderCode())){
						idList.remove(idList.get(i));
					}
				}
			}
		}
	}
	/**
	 * 목록에서 Folder객체를 제거하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folder Folder객체
	 */
	public void deleteFolder(String id, Folder folder) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderName().equals(folder.getFolderName()) && folderList.get(i).getFolderPath().equals(folder.getFolderPath())){
					folderList.remove(folder);
					return;
				}
			}
			
		}
	}
	
	/**
	 * 목록에서 Folder객체를 제거하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderPath 폴더경로
	 * @param folderName 폴더명
	 */
	public void deleteFolder(String id, String folderPath, String folderName) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderName().equals(folderName) && folderList.get(i).getFolderPath().equals(folderName)){
					folderList.remove(folderList.get(i));
					return;
				}
			}
		}
	}
	
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folder Folder객체
	 * @param newFolder 수정할 Folder객체
	 */
	public void modifyFolder(String id, Folder folder, Folder newFolder) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			folderList.set(folderList.indexOf(folder), newFolder);
		}
	}
	
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderPath 폴더경로
	 * @param folderName 폴더명
	 * @param newFolder 수정할 Folder객체
	 */
	public void modifyFolder(String id, String folderPath, String folderName, Folder newFolder) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderPath().equals(folderPath) && folderList.get(i).getFolderPath().equals(folderName)){
					folderList.set(i, newFolder);
					return;
				}
			}
		}
	}
	
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자아이디
	 * @param folderPath 폴더경로
	 * @param folderName 폴더명
	 * @param newFolderPath 수정할 폴더경로
	 */
	public void modifyFolder(String id, String folderPath, String folderName, String newFolderPath) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderPath().equals(folderPath) && folderList.get(i).getFolderPath().equals(folderName)){
					folderList.get(i).setFolderPath(newFolderPath);
					return;
				}
			}
		}
	}
	
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderPath 폴더경로
	 * @param folderName 폴더명
	 * @param newFolderPath 수정할 폴더경로
	 * @param newFolderName 수정할 폴더명
	 */
	public void modifyFolder(String id, String folderPath, String folderName, String newFolderPath, String newFolderName) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderPath().equals(folderPath) && folderList.get(i).getFolderPath().equals(folderName)){
					folderList.get(i).setFolderPath(newFolderPath);
					folderList.get(i).setFolderName(newFolderName);
					return;
				}
			}
		}
	}
	
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderPath 폴더경로
	 * @param folderName 폴더명
	 * @param newFolderName 수정할 폴더명
	 */
	public void modifyFolder(String id, String folderPath, String folderName, StringBuilder newFolderName) {
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderPath().equals(folderPath) && folderList.get(i).getFolderPath().equals(folderName)){
					folderList.get(i).setFolderName(""+newFolderName);
					return;
				}
			}
		}
	}
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderCode 폴더코드
	 * @param newFolder 수정할 Folder객체
	 */
	public void modifyFolderCode(String id, String folderCode, Folder newFolder){
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			folderList.set(folderList.indexOf(newFolder), newFolder);
		}
	}
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderCode 폴더코드
	 * @param newFolderName 수정할 폴더명
	 */
	public void modifyFolerCodeName(String id, String folderCode, String newFolderName){
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderCode().equals(folderCode)){
					folderList.get(i).setFolderName(newFolderName);
					return;
				}
			}
		}
	}
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderCode 폴더코드
	 * @param newParentFolderCode 수정할 부모폴더코드
	 */
	public void modifyFolderCodeParent(String id, String folderCode, String newParentFolderCode){
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderCode().equals(folderCode)){
					folderList.get(i).setParentFolderCode(newParentFolderCode);
				}
			}
		}
	}
	/**
	 * Folder정보를 찾아 수정하기위한 메소드
	 * @param id 사용자 아이디
	 * @param parentFolderCode 부모폴더코드
	 * @param newParentFolderCode 수정할 부모폴더코드
	 */
	public void modifyFolderParentParent(String id, String parentFolderCode, String newParentFolderCode){
		if(folderList.get(id) == null){
			return;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getParentFolderCode().equals(parentFolderCode)){
					folderList.get(i).setParentFolderCode(newParentFolderCode);
				}
			}
		}
	}
	/**
	 * 폴더정보를 검색하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderPath 폴더경로
	 * @return 폴더의 리스트. 검색결과가 없을 경우 null return
	 */
	public ArrayList<Folder> searchFolderPath(String id, String folderPath) {
		ArrayList<Folder> returnList = new ArrayList<Folder>();
		if(folderList.get(id) == null){
			return null;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderPath().equals(folderPath)){
					returnList.add(folderList.get(i));
				}
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	
	/**
	 * 폴더정보를 검색하기위한 메소드
	 * @param id
	 * @param folderName
	 * @return 폴더의 리스트. 검색결과가 없을 경우 null return
	 */
	public ArrayList<Folder> searchFolderName(String id, String folderName) {
		ArrayList<Folder> returnList = new ArrayList<Folder>();
		if(folderList.get(id) == null){
			return null;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderName().equals(folderName)){
					returnList.add(folderList.get(i));
				}
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	
	/**
	 * 폴더정보를 검색하기위한 메소드
	 * @param id
	 * @param folderName
	 * @param folderPath
	 * @return Folder객체. 검색결과가 없을 경우 null return
	 */
	public Folder searchFolderAll(String id, String folderName, String folderPath) {
		if(folderList.get(id) == null){
			return null;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderName().equals(folderName) && folderList.get(i).getFolderPath().equals(folderPath)){
					return folderList.get(i);
				}
			}
		} 
		return null;
	}
	/**
	 * 폴더정보를 검색하기위한 메소드
	 * @param id 사용자 아이디
	 * @param folderCode 폴더코드
	 * @return Folder객체. 검색결과가 없을 경우 null return
	 */
	public Folder searchFolderCode(String id, String folderCode){
		if(folderList.get(id) == null){
			return null;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getFolderCode().equals(folderCode)){
					return folderList.get(i);
				}
			}
			return null;
		}
	}
	/**
	 * 폴더정보를 검색하기위한 메소드
	 * @param id
	 * @param parentFolderCode
	 * @return 폴더 목록. 검색결과가 없을 경우 null return
	 */
	public ArrayList<Folder> searchFolderParent(String id, String parentFolderCode){
		ArrayList<Folder> returnList = new ArrayList<Folder>();
		if(folderList.get(id) == null){
			return null;
		} else {
			ArrayList<Folder> folderList = this.folderList.get(id);
			for(int i=0;i<folderList.size();i++){
				if(folderList.get(i).getParentFolderCode().equals(parentFolderCode)){
					returnList.add(folderList.get(i));
				}
			}
		}
		if(returnList.isEmpty()){
			return null;
		}
		return returnList;
	}
	
	/**
	 * 폴더정보를 검색하기위한 메소드
	 * @param id 사용자아이디
	 * @return 폴더 목록. 검색결과가 없을 경우 null return
	 */
	public ArrayList<Folder> searchFolder(String id) {
		return folderList.get(id);
	}

	/**
	 * getter
	 * @return 사용자별 폴더목록
	 */
	public Hashtable<String, ArrayList<Folder>> getFolderList() {
		return folderList;
	}

	/**
	 * setter
	 * @param folderList 사용자별 폴더목록
	 */
	public void setFolderList(Hashtable<String, ArrayList<Folder>> folderList) {
		this.folderList = folderList;
	}
	/**
	 * 데이터들을 문자열화하는 메소드
	 */
	@Override
	public String toString() {
		return "FolderList [folderList=" + folderList + "]";
	}
	
	

}
