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
		
		
		//해당 폴더코드의 부모코드가 루트인지 아닌지 확인 루트면 안됨
		Factory factory = (Factory)DAOFactory.getInstance();
		FolderSearchDAO folderSearchDAO = (FolderSearchDAO)factory.create("Folder");
		FolderDTO folderDTO = folderSearchDAO.searchFolderCode(folderCode);
		if(folderDTO.getParentFolderCode().trim().equals("root")) {
			
			return false;
		}
		System.out.println("초대하려는 폴더가 부모가 아닌것은 확인됫음");
		
		//해당 폴더가 어떤 공유폴더의 하위폴더인지 아닌지 확인. 어떤 공유폴더의 하위폴더일 경우 false리턴
		
		String firstParent = folderSearchDAO.searchFolderCode(folderCode).getParentFolderCode();
		String secondParent = folderSearchDAO.searchFolderCode(firstParent).getParentFolderCode();
		if(!secondParent.trim().equals("root")) {
			//2차 부모가 루트가 아닌경우 초대불가능한 공유폴더
			return false;
		}

		
		//해당 폴더 코드 존재 확인
		SharedFolderSearchable sharedFolderSearchable = new SharedFolderManager();
		SharedFolder sharedFolder = sharedFolderSearchable.searchSharedFolderCode(folderCode, id);
		String sharedFolderCode = sharedFolder.getSharedFolderCode().trim();
		if(sharedFolder == null){
			return false;
		}
		
		//친구가 회원인지 아닌지 확인
		MemberSearchable memberSeachable = new MemberManager();
		String friendMemberCode = memberSeachable.searchMemberAdmin(friendId);
		if(friendMemberCode == null){
			return false;
		}
		
		//해당 친구가 내친구인지 확인
		FriendSearchable friendSearchable = new FriendManager();
		ArrayList<Friend> myFriendList = friendSearchable.searchFriendList(id);

		System.out.println("마이프렌드리스ㅡ"+friendId);
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
		
		//초대하려는 친구가 해당 공유폴더 친구목록에 존재하는지 확인
		//존재한다면 초대 취소
		//존재하지 않을 경우에만 초대 실시
		
		
		SharedFriendVDAO sharedFriendVDAO = (SharedFriendVDAO)factory.create("SharedFriendView");
		List<SharedFriendVDTO> sharedFriendList = sharedFriendVDAO.searchSharedFriend(sharedFolderCode, id);
		for(SharedFriendVDTO temp : sharedFriendList){
			if(temp.getFriendCode().equals(friendId)){//이미 공유폴더에 등록되어있는 친구
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
			//해당 친구알람에 추가
			AlarmMessageAlarmable alram = new AlarmMessageManager();
			if(alram.alarmSharedFolderInvite(id, friendMemberCode, "공유초대")){
				return true;//초대 성공
			} else {
				return false;
			}
		} else {
			return false;
		}*/
		recursive(sharedFolderCode, friendCode);
		AlarmMessageAlarmable alram = new AlarmMessageManager();
		if(alram.alarmSharedFolderInvite(id, friendMemberCode, "공유초대")) {
			return true;
		} else {
			System.out.println("ㅉㅉ");
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
		"호스트 아이디 : "+id+" \n"+
		"초대할 폴더코드 : "+folderCode+" \n"+
		"초대할 친구의 멤버코드 : "+friendId);
		
		
		
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
		//공유폴더코드니까... 공유폴더의 폴더코드를 찾아왕
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		SharedFolderDTO sharedFolderDTO = sharedFolderSearchDAO.searchSharedFolderCode(sharedFolderCode);
		
		//현재 나의 폴더코드
		String folderCode = sharedFolderDTO.getFolderCode();
		FolderSearchDAO folderSearchDAO = (FolderSearchDAO)factory.create("Folder");
		//나를 부모로 하는 내 자식폴더들 가져오긔
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
