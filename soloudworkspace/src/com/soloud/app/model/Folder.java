package com.soloud.app.model;

import java.io.Serializable;
/**
 * 폴더정보를 캡슐화한 클래스
 * @author oong 
 *
 */
public class Folder implements Serializable {
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 1698752316957270416L;
	/**
	 * 폴더의 코드
	 */
	private String folderCode;
	/**
	 * 부모폴더의 코드
	 */
	private String parentFolderCode;
	/**
	 * 폴더의 경로
	 */
	private String folderPath;
	/**
	 * 폴더명
	 */
	private String folderName;
	/**
	 * 폴더 용량
	 */
	private float folderCapacity;
	/**
	 * 폴더클래스 오버로딩 생성자
	 * @param folderPath 폴더경로
	 * @param folderName 폴더이름
	 * @param folderCapacity 폴더용량
	 */
	public Folder(String folderPath, String folderName, float folderCapacity) {
		super();
		this.folderPath = folderPath;
		this.folderName = folderName;
		this.folderCapacity = folderCapacity;
	}
	/**
	 * 폴더클래스 기본 생성자
	 */
	public Folder() {
		
	}
	/**
	 * 폴더클래스 오버로딩 생성자
	 * @param folderCode 폴더코드
	 */
	public Folder(String folderCode) {
		this.folderCode = folderCode;
	}
	/**
	 * 폴더클래스 오버로딩 생성자
	 * @param folderCode 폴드코드
	 * @param parentFolderCode 폴더접건
	 */
	public Folder(String folderCode, String parentFolderCode) {
		this.folderCode = folderCode;
		this.parentFolderCode = parentFolderCode;
	}
	/**
	 * 폴더클래스 오버로딩 생성자
	 * @param folderCode 폴더코드
	 * @param parentFolderCode 부모폴더코드
	 * @param folderPath 폴더경로
	 * @param folderName 폴더명
	 * @param folderCapacity 폴더용량
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
	 * 폴더클래스 오버로딩 생성자
	 * @param parentFolderCode 부모폴더코드
	 * @param folderCode 폴더코드
	 * @param folderName 폴더이름
	 */
	public Folder(String parentFolderCode, String folderCode, String folderName){
		this.parentFolderCode = parentFolderCode;
		this.folderCode = folderCode;
		this.folderName = folderName;
	}
	/**
	 * getter
	 * @return 폴더경로
	 */
	public String getFolderPath() {
		return folderPath;
	}
	/**
	 * setter 
	 * @param folderPath 폴더경로
	 */
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	/**
	 * getter 
	 * @return 폴더이름
	 */
	public String getFolderName() {
		return folderName;
	}
	/**
	 * setter
	 * @param folderName 폴더이름
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	/**
	 * getter
	 * @return 폴더용량
	 */
	public float getFolderCapacity() {
		return folderCapacity;
	}
	/**
	 * setter
	 * @param folderCapacity 폴더용량
	 */
	public void setFolderCapacity(float folderCapacity) {
		this.folderCapacity = folderCapacity;
	}
	/**
	 * getter 
	 * @return 부모폴더코드
	 */
	public String getParentFolderCode() {
		return parentFolderCode;
	}
	/**
	 * setter
	 * @param parentFolderCode 부모폴더코드
	 */
	public void setParentFolderCode(String parentFolderCode) {
		this.parentFolderCode = parentFolderCode;
	}
	
	/**
	 * getter
	 * @return 폴더코드
	 */
	public String getFolderCode() {
		return folderCode;
	}
	/**
	 * setter
	 * @param folderCode 폴더코드
	 */
	public void setFolderCode(String folderCode) {
		this.folderCode = folderCode;
	}
	/**
	 * toString 객체의 데이터를 문자열화하기위한 메소드
	 * @return 문자열화시킨 객체의 데이터
	 */
	@Override
	public String toString() {
		return "Folder [folderCode=" + folderCode + ", parentFolderCode="
				+ parentFolderCode + ", folderPath=" + folderPath
				+ ", folderName=" + folderName + ", folderCapacity="
				+ folderCapacity + "]";
	}
	/**
	 * 객체의 데이터를 비교하기위한 메소드
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
