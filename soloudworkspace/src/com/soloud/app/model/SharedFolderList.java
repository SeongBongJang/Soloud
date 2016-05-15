package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * ���������� �����ϱ����� ����� Ŭ����
 * @author oong
 *
 */
public class SharedFolderList implements Serializable{
	/**
	 * �ø��� ���� ���̵� 
	 */
	private static final long serialVersionUID = 7268010534988988930L;
	/**
	 * �������� ���
	 */
	private ArrayList<SharedFolder> sharedFolders;
	
	/**
	 * SharedFolderList Ŭ���� �⺻������
	 */
	public SharedFolderList() {
		this(new ArrayList<SharedFolder>());
	}
	/**
	 * SharedFolderList Ŭ���� �����ε� ������
	 * @param sharedFolders �����������
	 */
	public SharedFolderList(ArrayList<SharedFolder> sharedFolders) {
		this.sharedFolders = sharedFolders;
	}

	/**
	 * ����������Ͽ� �������������� �߰��ϱ����� �޼ҵ�
	 * @param sharedFolder �߰��� ������������
	 * @return
	 */
	public boolean addSharedFolder(SharedFolder sharedFolder) {
		return sharedFolders.add(sharedFolder);
	}
	
	/**
	 * ����������Ͽ� �������������� �߰��ϱ����� �޼ҵ�
	 * @param sharedFolderName �߰��� ���������̸�
	 * @param senderId �߰��� ���������� ������(�ʴ��� �� ȣ��Ʈ) ���̵�
	 * @return
	 */
	public boolean addSharedFolder(String sharedFolderName, String senderId) {
		return sharedFolders.add(new SharedFolder("0000", new GregorianCalendar(), senderId, new SharedFolderFriendList(), new ReplyList(), sharedFolderName));
	}	
	
	/**
	 * ����������Ͽ��� �������������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode �����ڷ� ���� �������� �ڵ�
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
	 * ����������Ͽ��� �������������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode �����ڷ� ���� �������� �ڵ�
	 * @param newSharedFolderName ���Ӱ� ����� ����������
	 */
	public void modifySharedFolder(String sharedFolderCode, String newSharedFolderName) {
		SharedFolder temp = searchSharedFolderCode(sharedFolderCode);
		if(temp != null){
			temp.setSharedFolderName(newSharedFolderName);
		} 
	}
	
	/**
	 * ����������Ͽ��� �������������� �����ϱ����� �޼ҵ�
	 * @param sharedFolderCode �����ڷ� ���� �������� �ڵ�
	 * @param newSharedFolderFriendList ���Ӱ� ����� �������� ģ����� ����
	 */
	public void modifySharedFolder(String sharedFolderCode, SharedFolderFriendList newSharedFolderFriendList) {
		SharedFolder temp = searchSharedFolderCode(sharedFolderCode);
		if(temp != null){
			temp.setSharedFolderFriendList(newSharedFolderFriendList);
		} 
	}
	
	/**
	 * ����������Ͽ��� �������������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderCode �����ڷ� ���� �������� �ڵ�
	 * @return �������� ����. �˻������ ������������ ��� null ����
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
	 * ����������Ͽ��� �������������� �˻��ϱ����� �޼ҵ�
	 * @param sharedFolderName �����ڷ� ���� �������� �̸�
	 * @return �����������. �˻���� �������� ���� ��� null ����
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
	 * ����������Ͽ��� �������������� �˻��ϱ����� �޼ҵ�
	 * @param senderId
	 * @return �����������. �˻���� �������� ���� ��� null ����
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
	 * @return �����������
	 */
	public ArrayList<SharedFolder> getSharedFolders() {
		return sharedFolders;
	}
	/**
	 * setter
	 * @param sharedFolders �����������
	 */
	public void setSharedFolders(ArrayList<SharedFolder> sharedFolders) {
		this.sharedFolders = sharedFolders;
	}
	/**
	 * ������������� �����͸� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "SharedFolderList [sharedFolders=" + sharedFolders + "]";
	}
	
}
