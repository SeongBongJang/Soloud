package com.soloud.app.manInt;

import java.util.ArrayList;
import java.util.List;

import com.soloud.app.model.SharedFolder;
import com.soloud.per.dto.MemberShareFolderVDTO;
import com.soloud.per.dto.SharedFriendVDTO;

public interface SharedFolderSearchable {
	public SharedFolder searchSharedFolder(String sharedFolderCode);
	public ArrayList<SharedFolder> searchSharedFolderSender(String id);
	public ArrayList<SharedFolder> searchSharedFolderName(String sharedFolderName);
	public SharedFolder searchSharedFolderCode(String folerCode);
	public SharedFolder searchSharedFolderCode(String folderCode, String id);
	
	
	
	
	
	
	//ㅂㄱ가 쓸라고만든거
	public List<MemberShareFolderVDTO> searchMemberShareFolder(String memberCode);
	
	//공유폴더 코드에 대해서 해당 공유폴더에 지정된 프렌드코드 리스트를 가져옴
	public List<SharedFriendVDTO> searchShareFriend(String sharedFolderCode); 
}
