package com.soloud.app.man;

import java.util.ArrayList;
import java.util.List;

import com.soloud.app.model.Folder;
import com.soloud.per.dao.FolderCapacityVDAO;
import com.soloud.per.dao.FolderDeleteDAO;
import com.soloud.per.dao.FolderInsertDAO;
import com.soloud.per.dao.FolderSearchDAO;
import com.soloud.per.dao.FolderUpdateDAO;
import com.soloud.per.dto.FolderCapacityVDTO;
import com.soloud.per.dto.FolderDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;


public class FolderManager extends AbstractFolderManager
{

	//====================== 복사 / 붙여넣기 ==============================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================
	@Override
	public boolean copyPasteFolder(String id, String folderName,
			String folderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean copyPasteFolderAdmin(String adminId, String memberId,
			String folderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean copyPasteFolder(String id, String folderCode,
			Folder newFolder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean copyPasteFolderAdmin(String adminId, String folderCode,
			Folder newFolder) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	//====================== 추가 ==============================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================
	@Override
	public boolean createFolder(String id, String folderName, String folderPath) {
		// TODO Auto-generated method stub
		return false;
	
	}

	@Override
	public boolean createFolder(String adminId, String memberId,
			String folderName, String folderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createFolder(String id, String folderCode,
			String parentFolderCode, String folderName, String isSharedFolder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createFolderAdmin(String adminId, String memberId,
			String folderCode, String parentFolderCoder,
			String isSharedFolderCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createFolder_REAL(String memberCode, String folderName,
			String parentFolderCode, String isSharedFolder) {
		Factory factory = DAOFactory.getInstance();
		
		FolderInsertDAO dao = (FolderInsertDAO) factory.create("Folder");
		
		boolean res = dao.insertFolder(memberCode, parentFolderCode, folderName, isSharedFolder, "폴더URL");
		
		// TODO Auto-generated method stub
		return res;
		
	}

	
	//====================== 삭제 ==============================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================
	
	@Override
	public boolean deleteFolder(String id, String folderName, String folderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFolder(String adminId, String mebmerId,
			String folderName, String folderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFolder(String id, String folderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFolderd(String adminid, String memberId,
			String folderCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFolder_REAL(String folderCode) {
		// TODO Auto-generated method stub
		Factory factory = DAOFactory.getInstance();
		
		FolderDeleteDAO dao = (FolderDeleteDAO) factory.create("Folder");
		
		int res = dao.deleteFolderCode(folderCode);
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		// TODO Auto-generated method stub
		
	}

	
	
	//====================== 이름 수정 ==============================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================
	@Override
	public boolean modifyFolderPathFolderName(String id, String folderName,
			String newFolderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderPath(String adminId, String memberId,
			String folderName, String folderPath, String newFolderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderPathFolderCode(String id, String folderCode,
			String newParentFolderCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderName(String adminId, String memberId,
			String folderCode, String newFolderName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderName_REAL(String folderCode,
			String newFolderName) {
		Factory factory = DAOFactory.getInstance();
		
		FolderUpdateDAO dao = (FolderUpdateDAO) factory.create("Folder");
		
		int res = dao.updateFolderNameFolderCode(folderCode, newFolderName);
				
		
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		// TODO Auto-generated method stub
	}

	
	
	
	//====================== 폴더 이동 ==============================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================ㄴ
	@Override
	public boolean modifyFolderPath(String id, String folderName,
			String folderPath, String newFolderPath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderPath(String id, String folderCode,
			String newParentFolderCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderPathAdmin(String adminId, String memberId,
			String folderCode, String newParentFolderCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFolderPath_REAL(String folderCode,
			String parentFolderCode) {

		Factory factory = DAOFactory.getInstance();
		FolderUpdateDAO dao = (FolderUpdateDAO) factory.create("Folder");
		int res = dao.updateFolderParentFolder(folderCode, parentFolderCode);
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	
	
	
	
	//====================== 폴더 검색 ==============================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================
	//=====================================================================================
	@Override
	public Folder searchFolder(String id, String folderName, String folderPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Folder> searchFolderIdPath(String id, String folderPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Folder> searchFolder(String id) {
		// TODO Auto-generated method stub
		List<Folder> folderList = new ArrayList<Folder>();
		
		Factory factory = DAOFactory.getInstance();
		
		FolderSearchDAO dao = (FolderSearchDAO) factory.create("Folder");
		FolderCapacityVDAO dao2 = (FolderCapacityVDAO) factory.create("FolderCapacityView");
		
		List<FolderDTO> list = dao.searchMemberCode(id);
		
		for(FolderDTO dto : list)
		{
			Folder folder=new Folder();
			folder.setFolderCode(dto.getFolderCode());
			folder.setFolderName(dto.getFolderName());
			folder.setFolderPath("폴더패스");
			folder.setParentFolderCode(dto.getParentFolderCode());
			
			
			
			FolderCapacityVDTO dto2 = dao2.searchFolderCapacity(folder.getFolderCode());
			folder.setFolderCapacity(dto2.getFolderCapacity());	//인트가 플로트로..ㅠㅠ;;
			
			folderList.add(folder);
		}
		
		
		return folderList;
	}

	
		///이걸 과연 사용할까.....??
	@Override
	public Folder searchFolderIdCode(String id, String folderCode) {
		// TODO Auto-generated method stub
		return null;
		//ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ DAO에 메서드 업성..
	}

	@Override
	public List<Folder> searchFolderIdParent(String id, String parentFolderCode) {
		// TODO Auto-generated method stub
		List<Folder> folderList = new ArrayList<Folder>();
		
		Factory factory = DAOFactory.getInstance();
		
		FolderSearchDAO dao = (FolderSearchDAO) factory.create("Folder");
		FolderCapacityVDAO dao2 = (FolderCapacityVDAO) factory.create("FolderCapacityView");
		
		List<FolderDTO> list = dao.searchMemberCodeParentFolderCode(id, parentFolderCode);
		
		for(FolderDTO dto : list)
		{
			Folder folder=new Folder();
			folder.setFolderCode(dto.getFolderCode());
			folder.setFolderName(dto.getFolderName());
			folder.setFolderPath("폴더패스");
			folder.setParentFolderCode(dto.getParentFolderCode());
			
			
			
			FolderCapacityVDTO dto2 = dao2.searchFolderCapacity(folder.getFolderCode());
			folder.setFolderCapacity(dto2.getFolderCapacity());	//인트가 플로트로..ㅠㅠ;;
			
			folderList.add(folder);
		}
		
		
		return folderList;
	}

	@Override
	public List<Folder> searchFolder_REAL1(String memberCode, String folderName) {
		// TODO Auto-generated method stub
		List<Folder> folderList = new ArrayList<Folder>();
		
		Factory factory = DAOFactory.getInstance();
		
		FolderSearchDAO dao = (FolderSearchDAO) factory.create("Folder");
		FolderCapacityVDAO dao2 = (FolderCapacityVDAO) factory.create("FolderCapacityView");
		
		List<FolderDTO> list = dao.searchMemberCodeFolderName(memberCode, folderName);
		
		for(FolderDTO dto : list)
		{
			Folder folder=new Folder();
			folder.setFolderCode(dto.getFolderCode());
			folder.setFolderName(dto.getFolderName());
			folder.setFolderPath("폴더패스");
			folder.setParentFolderCode(dto.getParentFolderCode());
			
			
			
			FolderCapacityVDTO dto2 = dao2.searchFolderCapacity(folder.getFolderCode());
			folder.setFolderCapacity(dto2.getFolderCapacity());	//인트가 플로트로..ㅠㅠ;;
			
			folderList.add(folder);
		}
		
		
		return folderList;
	}

	@Override
	public List<Folder> searchFolder_REAL2(String memberCode,
			String isSharedFolder) {
		// TODO Auto-generated method stub
		List<Folder> folderList = new ArrayList<Folder>();
		
		Factory factory = DAOFactory.getInstance();
		
		FolderSearchDAO dao = (FolderSearchDAO) factory.create("Folder");
		FolderCapacityVDAO dao2 = (FolderCapacityVDAO) factory.create("FolderCapacityView");
		
		List<FolderDTO> list = dao.searchMemberCodeIsSharedFolder(memberCode, isSharedFolder);
		
		for(FolderDTO dto : list)
		{
			Folder folder=new Folder();
			folder.setFolderCode(dto.getFolderCode());
			folder.setFolderName(dto.getFolderName());
			folder.setFolderPath("폴더패스");
			folder.setParentFolderCode(dto.getParentFolderCode());
			
			
			
			FolderCapacityVDTO dto2 = dao2.searchFolderCapacity(folder.getFolderCode());
			folder.setFolderCapacity(dto2.getFolderCapacity());	//인트가 플로트로..ㅠㅠ;;
			
			folderList.add(folder);
		}
		
		
		return folderList;
	}

	@Override
	public Folder searchFolder_REAL3(String folderCode) {
		// TODO Auto-generated method stub
		Folder folder = new Folder();
		
		Factory factory = DAOFactory.getInstance();
		
		FolderSearchDAO dao = (FolderSearchDAO) factory.create("Folder");
		
		FolderDTO dto = dao.searchFolderCode(folderCode);
		
		folder.setFolderCode(dto.getFolderCode());
		folder.setFolderName(dto.getFolderName());
		folder.setFolderPath(dto.getMemberCode());
		folder.setParentFolderCode(dto.getParentFolderCode());
		
		
		return folder;
	}

}
