package com.soloud.app.model;

import java.io.Serializable;
/**
 * ���������� ĸ��ȭ�� Ŭ����
 * @author oong 
 *
 */
public class Folder implements Serializable {
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 1698752316957270416L;
	/**
	 * ������ �ڵ�
	 */
	private String folderCode;
	/**
	 * �θ������� �ڵ�
	 */
	private String parentFolderCode;
	/**
	 * ������ ���
	 */
	private String folderPath;
	/**
	 * ������
	 */
	private String folderName;
	/**
	 * ���� �뷮
	 */
	private float folderCapacity;
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param folderPath �������
	 * @param folderName �����̸�
	 * @param folderCapacity �����뷮
	 */
	public Folder(String folderPath, String folderName, float folderCapacity) {
		super();
		this.folderPath = folderPath;
		this.folderName = folderName;
		this.folderCapacity = folderCapacity;
	}
	/**
	 * ����Ŭ���� �⺻ ������
	 */
	public Folder() {
		
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param folderCode �����ڵ�
	 */
	public Folder(String folderCode) {
		this.folderCode = folderCode;
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param folderCode �����ڵ�
	 * @param parentFolderCode ��������
	 */
	public Folder(String folderCode, String parentFolderCode) {
		this.folderCode = folderCode;
		this.parentFolderCode = parentFolderCode;
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param folderCode �����ڵ�
	 * @param parentFolderCode �θ������ڵ�
	 * @param folderPath �������
	 * @param folderName ������
	 * @param folderCapacity �����뷮
	 */
	public Folder(String folderCode, String parentFolderCode, String folderPath, String folderName,
			float folderCapacity ) {
		this.parentFolderCode = parentFolderCode;
		this.folderCode = folderCode;
		this.folderPath = folderPath;
		this.folderName = folderName;
		this.folderCapacity = folderCapacity;
	}
	/**
	 * ����Ŭ���� �����ε� ������
	 * @param parentFolderCode �θ������ڵ�
	 * @param folderCode �����ڵ�
	 * @param folderName �����̸�
	 */
	public Folder(String parentFolderCode, String folderCode, String folderName){
		this.parentFolderCode = parentFolderCode;
		this.folderCode = folderCode;
		this.folderName = folderName;
	}
	/**
	 * getter
	 * @return �������
	 */
	public String getFolderPath() {
		return folderPath;
	}
	/**
	 * setter 
	 * @param folderPath �������
	 */
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	/**
	 * getter 
	 * @return �����̸�
	 */
	public String getFolderName() {
		return folderName;
	}
	/**
	 * setter
	 * @param folderName �����̸�
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	/**
	 * getter
	 * @return �����뷮
	 */
	public float getFolderCapacity() {
		return folderCapacity;
	}
	/**
	 * setter
	 * @param folderCapacity �����뷮
	 */
	public void setFolderCapacity(float folderCapacity) {
		this.folderCapacity = folderCapacity;
	}
	/**
	 * getter 
	 * @return �θ������ڵ�
	 */
	public String getParentFolderCode() {
		return parentFolderCode;
	}
	/**
	 * setter
	 * @param parentFolderCode �θ������ڵ�
	 */
	public void setParentFolderCode(String parentFolderCode) {
		this.parentFolderCode = parentFolderCode;
	}
	
	/**
	 * getter
	 * @return �����ڵ�
	 */
	public String getFolderCode() {
		return folderCode;
	}
	/**
	 * setter
	 * @param folderCode �����ڵ�
	 */
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
	}
	/**
	 * toString ��ü�� �����͸� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 * @return ���ڿ�ȭ��Ų ��ü�� ������
	 */
	@Override
	public String toString() {
		return "Folder [folderCode=" + folderCode + ", parentFolderCode="
				+ parentFolderCode + ", folderPath=" + folderPath
				+ ", folderName=" + folderName + ", folderCapacity="
				+ folderCapacity + "]";
	}
	/**
	 * ��ü�� �����͸� ���ϱ����� �޼ҵ�
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (Float.floatToIntBits(folderCapacity) != Float
				.floatToIntBits(other.folderCapacity))
			return false;
		if (folderName == null) {
			if (other.folderName != null)
				return false;
		} else if (!folderName.equals(other.folderName))
			return false;
		if (folderPath == null) {
			if (other.folderPath != null)
				return false;
		} else if (!folderPath.equals(other.folderPath))
			return false;
		return true;
	}
	
	
}
