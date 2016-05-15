package com.soloud.app.man;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.soloud.app.model.ReplyList;
import com.soloud.app.model.SharedFolder;
import com.soloud.app.model.SharedFolderFriendList;
import com.soloud.per.dao.AvailableFolderFriendInsertDAO;
import com.soloud.per.dao.FolderDeleteDAO;
import com.soloud.per.dao.FolderInsertDAO;
import com.soloud.per.dao.FolderSearchDAO;
import com.soloud.per.dao.MemberShareFolderVDAO;
import com.soloud.per.dao.MemberSharedVDAO;
import com.soloud.per.dao.SharedFolderSearchDAO;
import com.soloud.per.dao.SharedFriendVDAO;
import com.soloud.per.dto.AvailableFolderFriendDTO;
import com.soloud.per.dto.FolderDTO;
import com.soloud.per.dto.MemberShareFolderVDTO;
import com.soloud.per.dto.MemberSharedVDTO;
import com.soloud.per.dto.SharedFolderDTO;
import com.soloud.per.dto.SharedFriendVDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;

public class SharedFolderManager extends AbstractSharedFolderManager {

	@Override
	public boolean createSharedFolder(String id, String folderName,
			String isSharedFolder) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		FolderInsertDAO fi = (FolderInsertDAO)factory.create("Folder");
		return fi.insertFolder(id, null, folderName, "°øÀ¯", "asd");
	}

	@Override
	public boolean createSharedFolder(String adminId, String id,
			String folderName, String isSharedFolder) {
		// TODO Auto-generated method stub
		return createSharedFolder(id, folderName, isSharedFolder);
	}

	@Override
	public boolean deleteSharedFolder(String id, String folderCode) {
		// TODO Auto-generated method stub
		System.out.println("id : "+id+"\n folderCode :"+folderCode);
		Factory factory = (Factory)DAOFactory.getInstance();
		FolderDeleteDAO fd = (FolderDeleteDAO)factory.create("Folder");
		int res = fd.deleteFolderCode(folderCode);
		if(res == 1){
			return true;
		} else return false;
	}

	@Override
	public boolean deleteSharedFolder(String adminId, String id,
			String folderCode) {
		// TODO Auto-generated method stub
		return deleteSharedFolder(id, folderCode);
	}
	
	
	@Override
	public SharedFolder searchSharedFolder(String sharedFolderCode) {
		// TODO Auto-generated method stub
		
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		
		SharedFolderDTO sharedFolderDTO = sharedFolderSearchDAO.searchSharedFolderCode(sharedFolderCode);
		
		if(sharedFolderDTO == null){
			return null;
		}
		String folderCode = sharedFolderDTO.getFolderCode();
		GregorianCalendar makeDate = sharedFolderDTO.getSharedFolderMakeDate();
		
		FolderSearchDAO folderSearchDAO = (FolderSearchDAO)factory.create("Folder");
		FolderDTO folderDTO = folderSearchDAO.searchFolderCode(folderCode);
		if(folderDTO == null){
			return null;
		}
		String folderName = folderDTO.getFolderName();
		String memberCode = folderDTO.getMemberCode();
		
		SharedFolder sharedFolder = new SharedFolder();
		sharedFolder.setCreateDate(makeDate);
		sharedFolder.setSharedFolderCode(sharedFolderCode);
		sharedFolder.setSharedFolderName(folderName);
		sharedFolder.setSenderId(memberCode);
		
		return sharedFolder;
	}

	@Override
	public ArrayList<SharedFolder> searchSharedFolderSender(String id) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		MemberSharedVDAO memberSharedVDAO = (MemberSharedVDAO)factory.create("MemberSharedView");
		List<MemberSharedVDTO> memberSharedVDTOList = memberSharedVDAO.searchMemberShared(id);
		if(memberSharedVDTOList.isEmpty() || memberSharedVDTOList == null){
			return null;
		}
		ArrayList<SharedFolder> sharedFolderList = new ArrayList<SharedFolder>();
		for(MemberSharedVDTO temp : memberSharedVDTOList){
			sharedFolderList.add(new SharedFolder(temp.getSharedFolderCode(),null,id,null,null,temp.getFolderName()));
		}
		return sharedFolderList;
	}

	@Override
	public ArrayList<SharedFolder> searchSharedFolderName(String sharedFolderName) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		MemberSharedVDAO memberSharedVDAO = (MemberSharedVDAO)factory.create("Folder");
		List<MemberSharedVDTO> memberSharedVDTOList = memberSharedVDAO.searchMemberShared();
		if(memberSharedVDTOList.isEmpty() || memberSharedVDTOList == null){
			return null;
		}
		ArrayList<SharedFolder> sharedFolderList = new ArrayList<SharedFolder>();
		for(MemberSharedVDTO temp : memberSharedVDTOList){
			if(temp.getFolderName().equals(sharedFolderName)){
				sharedFolderList.add(new SharedFolder(temp.getSharedFolderCode(), temp.getSharedFolderMakedate(), temp.getMemberCode(), null, null, temp.getFolderName()));
				
			}
		}
		return sharedFolderList;
		
	}

	@Override
	public SharedFolder searchSharedFolderCode(String folderCode, String id) {
		
		Factory factory = (Factory)DAOFactory.getInstance();
		MemberSharedVDAO memberSharedVDAO = (MemberSharedVDAO)factory.create("MemberSharedView");
		MemberSharedVDTO temp = memberSharedVDAO.searchMemberSharedFolder(id, folderCode);
		
		return new SharedFolder(temp.getSharedFolderCode(),temp.getSharedFolderMakedate(),temp.getMemberCode(), new SharedFolderFriendList(), new ReplyList(), temp.getFolderName());
		
	}

	@Override
	public SharedFolder searchSharedFolderCode(String folderCode) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		SharedFolderDTO sharedFolderDTO = sharedFolderSearchDAO.searchFolderCode(folderCode);
		SharedFolder sharedFolder = new SharedFolder();
		sharedFolder.setSharedFolderCode(sharedFolderDTO.getSharedFolderCode());
		return sharedFolder;
	}

	
	
	
	
	////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////
	@Override
	public List<MemberShareFolderVDTO> searchMemberShareFolder(String memberCode) {
		// TODO Auto-generated method stub
		Factory factory = DAOFactory.getInstance();
		MemberShareFolderVDAO dao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		
		return dao.searchMemberShareFolder(memberCode);
	}

	@Override
	public List<SharedFriendVDTO> searchShareFriend(String sharedFolderCode) 
	{
		// TODO Auto-generated method stub
		Factory factory = DAOFactory.getInstance();
		SharedFriendVDAO dao = (SharedFriendVDAO) factory.create("SharedFriendView");
		return dao.searchSharedFriend(sharedFolderCode);
		
	}

	@Override
	public boolean createSharedFolderAuthFriend(String friendCode,
			String sharedFolderCode) {
		// TODO Auto-generated method stub
		Factory factory = DAOFactory.getInstance();
		AvailableFolderFriendInsertDAO dao = (AvailableFolderFriendInsertDAO) factory.create("AvailableFoldeFriend");
		boolean res =  dao.insertAFF(new AvailableFolderFriendDTO(friendCode, sharedFolderCode));
		if(res)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
