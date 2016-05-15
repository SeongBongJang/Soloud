package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Folder�� ����� Ŭ����
 */
public class FolderList implements Serializable{
	/**
	 * �ø������ ���̵�
	 */
	private static final long serialVersionUID = -3817043298673925475L;
	/**
	 * ������� ���̵�� ��������� ���ν�Ų ���̺�
	 */
	private Hashtable<String,ArrayList<Folder>> folderList;
	
	/**
	 * FolderList �����ε� ������
	 * @param folderList ȸ�� ���̵� �������
	 */
	public FolderList(Hashtable<String, ArrayList<Folder>> folderList) {
		
		this.folderList = folderList;
	}
	
	/**
	 * FolderList �⺻������
	 */
	public FolderList() {
		this(new Hashtable<String, ArrayList<Folder>>());
	}


	/**
	 * 
	 * @param id ����� ���̵�
	 * @param folder Folder��ü
	 * @return �߰��� ���� �������� ������ true, ���н� false
	 */
	public boolean addFolder(String id, Folder folder) {
		if(folderList.get(id) == null){
			folderList.put(id, new ArrayList<Folder>());
		} 
		return folderList.get(id).add(folder);
	}
	
	/**
	 * Folder��ü�� ����Ʈ�� �߰��ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderPath ������ ���
	 * @param folderName ������
	 * @param folderCapacity ������ �뷮
	 * @return �߰��� ���� �������� ������ true, ���н� false
	 */
	public boolean addFolder(String id, String folderPath, String folderName, float folderCapacity) {
		if(folderList.get(id) == null){
			folderList.put(id, new ArrayList<Folder>());
		} 
		return folderList.get(id).add(new Folder(folderPath, folderName, folderCapacity));
	}
	/**
	 * Folder��ü�� ����Ʈ�� �߰��ϱ����� �޼ҵ�
	 * @param id ����� �ƾƵ�
	 * @param parentFolderCode �θ����� �ڵ�
	 * @param folderCode �����ڵ�
	 * @param folderName ������
	 * @return �߰��� ���� �������� ������ true, ���н� false
	 */
	public boolean addFolder(String id, String parentFolderCode, String folderCode, String folderName){
		if(folderList.get(id) == null){
			folderList.put(id, new ArrayList<Folder>());
		} 
		return folderList.get(id).add(new Folder(parentFolderCode, folderCode , folderName));
	}
	/**
	 * ��Ͽ��� Folder��ü�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 */
	public void deleteFolder(String id) {
		if(folderList.get(id) == null){
			return;
		} else {
			folderList.remove(id);
		}
	}
	/**
	 * ��Ͽ��� Folder��ü�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderCode �����ڵ�
	 */
	public void deleteFolderCode(String id, String folderCode){
		if(folderList.get(id) == null){
			return;
		} else {
			folderList.get(id).remove(searchFolderCode(id, folderCode));
		}
	}
	/**
	 * ��Ͽ��� Folder��ü�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param parentFolderCode �θ����� �ڵ�
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
	 * ��Ͽ��� Folder��ü�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folder Folder��ü
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
	 * ��Ͽ��� Folder��ü�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderPath �������
	 * @param folderName ������
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folder Folder��ü
	 * @param newFolder ������ Folder��ü
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderPath �������
	 * @param folderName ������
	 * @param newFolder ������ Folder��ü
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����ھ��̵�
	 * @param folderPath �������
	 * @param folderName ������
	 * @param newFolderPath ������ �������
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderPath �������
	 * @param folderName ������
	 * @param newFolderPath ������ �������
	 * @param newFolderName ������ ������
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderPath �������
	 * @param folderName ������
	 * @param newFolderName ������ ������
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderCode �����ڵ�
	 * @param newFolder ������ Folder��ü
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderCode �����ڵ�
	 * @param newFolderName ������ ������
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderCode �����ڵ�
	 * @param newParentFolderCode ������ �θ������ڵ�
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
	 * Folder������ ã�� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param parentFolderCode �θ������ڵ�
	 * @param newParentFolderCode ������ �θ������ڵ�
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
	 * ���������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderPath �������
	 * @return ������ ����Ʈ. �˻������ ���� ��� null return
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
	 * ���������� �˻��ϱ����� �޼ҵ�
	 * @param id
	 * @param folderName
	 * @return ������ ����Ʈ. �˻������ ���� ��� null return
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
	 * ���������� �˻��ϱ����� �޼ҵ�
	 * @param id
	 * @param folderName
	 * @param folderPath
	 * @return Folder��ü. �˻������ ���� ��� null return
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
	 * ���������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵�
	 * @param folderCode �����ڵ�
	 * @return Folder��ü. �˻������ ���� ��� null return
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
	 * ���������� �˻��ϱ����� �޼ҵ�
	 * @param id
	 * @param parentFolderCode
	 * @return ���� ���. �˻������ ���� ��� null return
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
	 * ���������� �˻��ϱ����� �޼ҵ�
	 * @param id ����ھ��̵�
	 * @return ���� ���. �˻������ ���� ��� null return
	 */
	public ArrayList<Folder> searchFolder(String id) {
		return folderList.get(id);
	}

	/**
	 * getter
	 * @return ����ں� �������
	 */
	public Hashtable<String, ArrayList<Folder>> getFolderList() {
		return folderList;
	}

	/**
	 * setter
	 * @param folderList ����ں� �������
	 */
	public void setFolderList(Hashtable<String, ArrayList<Folder>> folderList) {
		this.folderList = folderList;
	}
	/**
	 * �����͵��� ���ڿ�ȭ�ϴ� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "FolderList [folderList=" + folderList + "]";
	}
	
	

}
