//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SharedFolderManageForm.java
//  @ Date : 2014-07-21
//  @ Author : 
//
//


package com.soloud.pre.uiform;
/**
 * 공유폴더관리에서 필요한 모든 UI 데이터를 캡슐화한 클래스
 * @author 영진
 *
 */
public class SharedFolderManageForm {
	private String folderName;
	private String friendId;
	public SharedFolderManageForm() {
	}
	public SharedFolderManageForm(String folderName, String friendId) {
		this.folderName = folderName;
		this.friendId = friendId;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	@Override
	public String toString() {
		return "SharedFolderManageForm [folderName=" + folderName
				+ ", friendId=" + friendId + "]";
	}
	
}
