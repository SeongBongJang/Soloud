package com.soloud.app.man;

import java.util.ArrayList;
import java.util.List;

import com.soloud.app.manInt.AlarmMessageAlarmable;
import com.soloud.app.manInt.FriendSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.manInt.SharedFolderSearchable;
import com.soloud.app.model.Friend;
import com.soloud.app.model.Member;
import com.soloud.app.model.SharedFolder;
import com.soloud.per.dao.AvailableFolderFriendInsertDAO;
import com.soloud.per.dao.FolderSearchDAO;
import com.soloud.per.dao.FriendSearchDAO;
import com.soloud.per.dao.MemberSearchDAO;
import com.soloud.per.dao.SharedFolderSearchDAO;
import com.soloud.per.dao.SharedFriendVDAO;
import com.soloud.per.dto.AvailableFolderFriendDTO;
import com.soloud.per.dto.FolderDTO;
import com.soloud.per.dto.FriendDTO;
import com.soloud.per.dto.SharedFolderDTO;
import com.soloud.per.dto.SharedFriendVDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;

public class SharedFolderFriendManager extends AbstractSharedFolderFriendManager{

	@Override
	public boolean inviteSharedFolderFriend(String id, String folderCode,
			String friendId) {
		// TODO Auto-generated method stub
		
		
		//�ش� �����ڵ��� �θ��ڵ尡 ��Ʈ���� �ƴ��� Ȯ�� ��Ʈ�� �ȵ�
		Factory factory = (Factory)DAOFactory.getInstance();
		FolderSearchDAO folderSearchDAO = (FolderSearchDAO)factory.create("Folder");
		FolderDTO folderDTO = folderSearchDAO.searchFolderCode(folderCode);
		if(folderDTO.getParentFolderCode().trim().equals("root")) {
			
			return false;
		}
		System.out.println("�ʴ��Ϸ��� ������ �θ� �ƴѰ��� Ȯ�ε���");
		
		//�ش� ������ � ���������� ������������ �ƴ��� Ȯ��. � ���������� ���������� ��� false����
		
		String firstParent = folderSearchDAO.searchFolderCode(folderCode).getParentFolderCode();
		String secondParent = folderSearchDAO.searchFolderCode(firstParent).getParentFolderCode();
		if(!secondParent.trim().equals("root")) {
			//2�� �θ� ��Ʈ�� �ƴѰ�� �ʴ�Ұ����� ��������
			return false;
		}

		
		//�ش� ���� �ڵ� ���� Ȯ��
		SharedFolderSearchable sharedFolderSearchable = new SharedFolderManager();
		SharedFolder sharedFolder = sharedFolderSearchable.searchSharedFolderCode(folderCode, id);
		String sharedFolderCode = sharedFolder.getSharedFolderCode().trim();
		if(sharedFolder == null){
			return false;
		}
		
		//ģ���� ȸ������ �ƴ��� Ȯ��
		MemberSearchable memberSeachable = new MemberManager();
		String friendMemberCode = memberSeachable.searchMemberAdmin(friendId);
		if(friendMemberCode == null){
			return false;
		}
		
		//�ش� ģ���� ��ģ������ Ȯ��
		FriendSearchable friendSearchable = new FriendManager();
		ArrayList<Friend> myFriendList = friendSearchable.searchFriendList(id);

		System.out.println("���������帮����"+friendId);
		boolean check = false;
		if(myFriendList.isEmpty() || myFriendList == null){
			return false;
		} else {
			
			for(Friend temp : myFriendList){
				System.out.println(temp.getFriendId());
				if(temp.getFriendId().equals(friendId)){
					check = true;
				} 
			}
		}
		if(check == false) {
			return false;
		}
		
		//�ʴ��Ϸ��� ģ���� �ش� �������� ģ����Ͽ� �����ϴ��� Ȯ��
		//�����Ѵٸ� �ʴ� ���
		//�������� ���� ��쿡�� �ʴ� �ǽ�
		
		
		SharedFriendVDAO sharedFriendVDAO = (SharedFriendVDAO)factory.create("SharedFriendView");
		List<SharedFriendVDTO> sharedFriendList = sharedFriendVDAO.searchSharedFriend(sharedFolderCode, id);
		for(SharedFriendVDTO temp : sharedFriendList){
			if(temp.getFriendCode().equals(friendId)){//�̹� ���������� ��ϵǾ��ִ� ģ��
				return false;
			}
		}
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		
		
		FriendSearchDAO friendSearchDAO = (FriendSearchDAO)factory.create("Friend");
		List<FriendDTO> friendDTOList = friendSearchDAO.searchMemberCode(id);
		String friendCode = null;
		for(FriendDTO temp : friendDTOList) {
			if(temp.getFriendMemberCode().trim().equals(friendMemberCode)) {
				friendCode = temp.getFriendCode();
			}
		}
		
		System.out.println("fCODE: "+friendCode);
		if(friendCode==null) {
			
			return false;
		}
		 
		
		/*AvailableFolderFriendInsertDAO affDAO = (AvailableFolderFriendInsertDAO)factory.create("AvailableFoldeFriend");
		if(affDAO.insertAFF(new AvailableFolderFriendDTO(friendCode, sharedFolderCode))){
			//if true
			//�ش� ģ���˶��� �߰�
			AlarmMessageAlarmable alram = new AlarmMessageManager();
			if(alram.alarmSharedFolderInvite(id, friendMemberCode, "�����ʴ�")){
				return true;//�ʴ� ����
			} else {
				return false;
			}
		} else {
			return false;
		}*/
		recursive(sharedFolderCode, friendCode);
		AlarmMessageAlarmable alram = new AlarmMessageManager();
		if(alram.alarmSharedFolderInvite(id, friendMemberCode, "�����ʴ�")) {
			return true;
		} else {
			System.out.println("����");
			return false;
		}
	}
	@Override
	public boolean alreadyInvite(String id, String folderCode, String friendId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		SharedFolderDTO sharedFolderDTO = sharedFolderSearchDAO.searchFolderCode(folderCode);
		String sharedFolderCode = sharedFolderDTO.getSharedFolderCode();
		
		
		SharedFriendVDAO sharedFriendVDAO = (SharedFriendVDAO)factory.create("SharedFriendView");
		
		System.out.println(
		"ȣ��Ʈ ���̵� : "+id+" \n"+
		"�ʴ��� �����ڵ� : "+folderCode+" \n"+
		"�ʴ��� ģ���� ����ڵ� : "+friendId);
		
		
		
		SharedFriendVDTO alreadyShared = sharedFriendVDAO.searchSharedFriend(folderCode.trim(), id.trim(), friendId.trim());
		if(alreadyShared.getFriendCode() == null || alreadyShared.getFriendId()==null || alreadyShared.getFriendName()==null || alreadyShared.getMemberCode() == null || alreadyShared.getMemberName() == null || alreadyShared.getSharedFolderCode() == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean inviteSharedFolderFriend(String adminId, String id,
			String folderCode, String friendId) {
		// TODO Auto-generated method stub
		return inviteSharedFolderFriend(id, folderCode, friendId);
	}

	@Override
	public ArrayList<Friend> searchFolderFriend(String sharedFolderCode) {
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFriendVDAO sharedFriendVDAO = (SharedFriendVDAO)factory.create("SharedFriendView");
		List<SharedFriendVDTO> shareFriendList = sharedFriendVDAO.searchSharedFriend(sharedFolderCode.trim());
		ArrayList<Friend> returnList = new ArrayList<Friend>();
		for(SharedFriendVDTO temp : shareFriendList) {
			returnList.add(new Friend(temp.getFriendId()));
		}
		return returnList;
	}

	@Override
	public Friend searchSharedFolderFriendId(String sharedFolderCode,
			String friendId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Friend> searchFolderFriendName(String sharedFolderCode,
			String friendName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Friend> searchSharedFolderFriend(String sharedFolderCode,
			String groupKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Friend> searchSharedFolderFriend(String sharedFolderCode,
			String friendName, String groupKind) {
		// TODO Auto-generated method stub
		return null;
	}
	private void recursive(String sharedFolderCode, String friendCode) {
		//���������ڵ�ϱ�... ���������� �����ڵ带 ã�ƿ�
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		SharedFolderDTO sharedFolderDTO = sharedFolderSearchDAO.searchSharedFolderCode(sharedFolderCode);
		
		//���� ���� �����ڵ�
		String folderCode = sharedFolderDTO.getFolderCode();
		FolderSearchDAO folderSearchDAO = (FolderSearchDAO)factory.create("Folder");
		//���� �θ�� �ϴ� �� �ڽ������� ��������
		List<FolderDTO> folderDTOList = folderSearchDAO.searchFolderParentCode(folderCode);
		
		AvailableFolderFriendInsertDAO affDAO = (AvailableFolderFriendInsertDAO)factory.create("AvailableFoldeFriend");
		affDAO.insertAFF(new AvailableFolderFriendDTO(friendCode, sharedFolderCode));
		if(folderDTOList == null || folderDTOList.isEmpty()) {
			return;
		}
		for(int i=0;i<folderDTOList.size();i++) {
			System.out.println(folderDTOList.size());
			String tempCode = folderDTOList.get(i).getFolderCode();
			SharedFolderDTO tempSharedFolderDTO = sharedFolderSearchDAO.searchFolderCode(tempCode);
			String tempSharedFolderCode = tempSharedFolderDTO.getSharedFolderCode();
			recursive(tempSharedFolderCode, friendCode);
		}
		
	}

	
	
}
