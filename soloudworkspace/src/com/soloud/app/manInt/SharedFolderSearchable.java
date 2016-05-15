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
	
	
	
	
	
	
	//������ ��������
	public List<MemberShareFolderVDTO> searchMemberShareFolder(String memberCode);
	
	//�������� �ڵ忡 ���ؼ� �ش� ���������� ������ �������ڵ� ����Ʈ�� ������
	public List<SharedFriendVDTO> searchShareFriend(String sharedFolderCode); 
}
