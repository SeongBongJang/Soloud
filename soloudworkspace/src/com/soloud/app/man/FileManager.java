package com.soloud.app.man;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.File;
import com.soloud.app.model.FileList;
import com.soloud.app.model.Group;
import com.soloud.app.model.Member;
import com.soloud.per.dao.AvailableFileAuthGroupDeleteDAO;
import com.soloud.per.dao.AvailableFileAuthGroupInsertDAO;
import com.soloud.per.dao.AvailableFileAuthGroupSearchDAO;
import com.soloud.per.dao.FileBinaryInsertDAO;
import com.soloud.per.dao.FileBinarySearchDAO;
import com.soloud.per.dao.FileDeleteDAO;
import com.soloud.per.dao.FileGroupVDAO;
import com.soloud.per.dao.FileInsertDAO;
import com.soloud.per.dao.FileSearchDAO;
import com.soloud.per.dao.FileUpdateDAO;
import com.soloud.per.dao.FolderFileVDAO;
import com.soloud.per.dao.FolderSearchDAO;
import com.soloud.per.dao.GroupSearchDAO;
import com.soloud.per.dao.MemberFileAuthVDAO;
import com.soloud.per.dao.MemberLimitCapacityVDAO;
import com.soloud.per.dao.MemberSearchDAO;
import com.soloud.per.dao.MemberShareFolderVDAO;
import com.soloud.per.dao.MemberSharedVDAO;
import com.soloud.per.dto.AvailableFileAuthGroupDTO;
import com.soloud.per.dto.FileBinaryDTO;
import com.soloud.per.dto.FileDTO;
import com.soloud.per.dto.FileGroupVDTO;
import com.soloud.per.dto.FolderDTO;
import com.soloud.per.dto.FolderFileVDTO;
import com.soloud.per.dto.GroupDTO;
import com.soloud.per.dto.MemberDTO;
import com.soloud.per.dto.MemberFileAuthVDTO;
import com.soloud.per.dto.MemberLimitCapacityVDTO;
import com.soloud.per.dto.MemberShareFolderVDTO;
import com.soloud.per.dto.MemberSharedVDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;
import com.soloud.util.CopyInputStream;

public class FileManager extends AbstractFileManager {

	public FileManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<File> searchAllFile() {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		FileSearchDAO fileSearchDAO = (FileSearchDAO)factory.create("File");
		List<FileDTO> fileList = fileSearchDAO.searchAllFile();
		ArrayList<File> returnList = new ArrayList<File>();
		for(FileDTO temp : fileList){
			String fileCode = temp.getFileCode();
			FolderFileVDAO ffvd = (FolderFileVDAO)factory.create("FolderFileView");
			List<FolderFileVDTO> ffdtoList = ffvd.searchFolderFile();
			FolderFileVDTO vdto = new FolderFileVDTO();
			for(FolderFileVDTO ttemp : ffdtoList){
				if(temp.getFileCode().equals(fileCode)){
					vdto = ttemp;
					break;
				}
			}
			
			FolderSearchDAO folderDAO = (FolderSearchDAO)factory.create("Folder");
			FolderDTO folderDTO = folderDAO.searchFolderCode(vdto.getFolderCode());
			String url = folderDTO.getFolderUrl();
			
			MemberSearchDAO memberDAO = (MemberSearchDAO)factory.create("Member");
			MemberDTO memberDTO = memberDAO.searchMemberCode(temp.getMemberCode());
			String memberId = memberDTO.getMemberId();
			String memberName = memberDTO.getName();
			
			returnList.add(new File(temp.getFileCode(),temp.getFolderCode(),Group.AWKWARDFRIEND,temp.getFileName(),
					url, Float.parseFloat(""+temp.getFileCapacity()),temp.getFileType(), temp.getFileComment(),
					temp.getFileLatestModifyDate(), memberId));
		}
		return returnList;
	}

	@Override
	public ArrayList<File> searchAllFileTypeName(String fileType,
			String fileName) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		FileSearchDAO fileSearchDAO = (FileSearchDAO)factory.create("File");
		List<FileDTO> fileDTOList = fileSearchDAO.searchMemberFileTypeName(fileType, fileName);
		ArrayList<File> returnList = new ArrayList<File>();
		for(FileDTO temp : fileDTOList){
			String fileCode = temp.getFileCode();
			FolderFileVDAO ffvd = (FolderFileVDAO)factory.create("FolderFileView");
			List<FolderFileVDTO> ffdtoList = ffvd.searchFolderFile();
			FolderFileVDTO vdto = new FolderFileVDTO();
			for(FolderFileVDTO ttemp : ffdtoList){
				if(temp.getFileCode().equals(fileCode)){
					vdto = ttemp;
					break;
				}
			}
			FolderSearchDAO folderDAO = (FolderSearchDAO)factory.create("Folder");
			FolderDTO folderDTO = folderDAO.searchFolderCode(vdto.getFolderCode());
			String url = folderDTO.getFolderUrl();
			
			
			returnList.add(new File(temp.getFileCode(),temp.getFolderCode(),Group.AWKWARDFRIEND,temp.getFileName(),
					url, Float.parseFloat(""+temp.getFileCapacity()),temp.getFileType(), temp.getFileComment(),
					temp.getFileLatestModifyDate(), temp.getMemberCode()));
		}
		return returnList;
	}

	@Override
	public ArrayList<File> searchAllFileDateName(int underDate, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<File> searchAllFile(String fileType, int underDate,
			String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 회원의 파일을 모두 검색함
	 */
	@Override
	public ArrayList<File> searchFile(String id) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchMemberCode(id);
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : list){
			result.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
		}
		return result;
	}

	/**
	 * 관리자용
	 */
	@Override
	public ArrayList<File> searchFileType(String id, String fileType) {
		// TODO Auto-generated method stub
		
		Factory factory = (Factory)DAOFactory.getInstance();
		FileSearchDAO fileSearchDAO = (FileSearchDAO)factory.create("File");
		List<FileDTO> fileDTOList = fileSearchDAO.searchFileType(fileType);
		
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : fileDTOList){
			result.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", (float) temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
		}
		return result;
	}
	/**
	 * 모든 파일 범주에서 모든 파일 종류에 대해 파일 명에 대한 검색
	 */
	@Override
	public ArrayList<File> searchFileName(String id, String fileName) {
		// TODO Auto-generated method stub
		ArrayList<File> result = new ArrayList<File>();
		if(fileName==null){ // 모든 파일
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuth(id);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // 파일 명
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeFileName(id, fileName);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}
	/**
	 * 회원의 파일 중 해당 타입의 파일 검색
	 */
	public ArrayList<File> searchMyFileType(String id, String fileType){
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchMemberCode(id);
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : list){
			if(temp.getFileType().trim().equals(fileType)){
				result.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
			}
		}
		return result;		
	}
	/**
	 * 회원의 파일 중 파일명에 해당하는 파일 검색
	 */
	public ArrayList<File> searchMyFileName(String id, String fileName){
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFileNameMemberCode(fileName, id);
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : list){
			result.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
		}
		return result;
	}
	
	/**
	 * 회원의 파일 중 업로더 이름이 포함되는 파일 검색
	 */
	public ArrayList<File> searchMyFileUploaderName(String id, String uploaderName){
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchMemberCode(id);
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : list){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getMemberCode()).getName().indexOf(uploaderName)>=0){
				result.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));	
			}
		}
		return result;
	}
	
	/**
	 * 회원의 파일 중 업로더 이름이 포함되고 파일 타입이 일치하는 파일 검색
	 */
	public ArrayList<File> searchMyFileUploaderType(String id,
			String uploaderName, String fileType) {
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchMemberCode(id);
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : list){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getMemberCode()).getName().indexOf(uploaderName)>=0){
				result.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));	
			}
		}
		ArrayList<File> realResult = new ArrayList<File>();
		for(File temp : result){
			if(temp.getFileType().trim().equals(fileType)){
				realResult.add(temp);
			}
		}
		return realResult;
	}

	/**
	 * 회원의 파일 중 파일명과 파일 종류에 해당하는 파일 검색
	 */
	public ArrayList<File> searchMyFileNameType(String id, String fileName, String fileType){
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<File> tempList = new ArrayList<File>();
		if(!fileName.equals("")){
			System.out.println("파일 이름 포함 검색");
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFileNameFileType(fileName, fileType);
			for(FileDTO temp : list){
				if(temp.getMemberCode().trim().equals(id)){
					tempList.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{
			System.out.println("파일 이름 안포함 검색");
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchMemberCodeFileType(id, fileType);
			for(FileDTO temp : list){
				if(temp.getMemberCode().trim().equals(id)){
					tempList.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
				}
			}
		}
		
		return tempList;
	}
	/**
	 * 파일 코드 하나에 해당하는 파일의 상세정보 검색
	 */
	@Override
	public File searchFileCode(String id, String fileCode) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao = (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		DecimalFormat df = new DecimalFormat("0.00");
		double capacity = temp.getFileCapacity(); 
		float fileCapacity;
		String realCapacity = null;
		if(capacity>1048575d){
			fileCapacity = (float)(capacity/1024d/1024d);  // 메가바이트 단위
			fileCapacity = Float.parseFloat(df.format(fileCapacity));
			realCapacity = fileCapacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // 킬로바이트 단위
			fileCapacity = (float)(capacity/1024d);
			fileCapacity = Float.parseFloat(df.format(fileCapacity));
			realCapacity = fileCapacity+"KB";
		}
		else{
			realCapacity = "1KB";
		}
		MemberSearchable memSearchManager = new MemberManager();
		Member mtemp = memSearchManager.searchMemberCode(temp.getMemberCode().trim());
		String uploaderName = mtemp.getName();
		
		String groupKind = "어색한친구";
		FileGroupVDAO dao2 = (FileGroupVDAO)factory.create("FileGroupView");
		ArrayList<FileGroupVDTO> list = (ArrayList<FileGroupVDTO>)dao2.searchFileGroup(fileCode);
		if(list.size()>0){
			int[] groupCode = new int[3];
			for(int i=0; i<list.size(); i++){
				groupCode[i] = Integer.parseInt((list.get(i).getGroupCode().substring(list.get(i).getGroupCode().indexOf("r")+1)).trim());
			}
			Arrays.sort(groupCode);
			System.out.println(groupCode[0]);
			System.out.println(groupCode[1]);
			System.out.println(groupCode[2]);
			if(groupCode[0]==0){
				groupKind = "친구";
			}
			if(groupCode[1]==0){
				groupKind = "절친";
			}
		}
		else{
			groupKind="나만보기";
		}
		
		File result = new File(groupKind, realCapacity, Group.AWKWARDFRIEND, temp.getFileName().trim(), "", 0.0f, temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), uploaderName);
		return result;
	}

	/**
	 * 모든 파일 범주에서 특정 파일 종류에 대해 파일 명에 해당하는 파일 검색
	 */
	@Override
	public ArrayList<File> searchFileNameType(String id, String fileName,
			String fileType) {
		// TODO Auto-generated method stub
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
		ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeFileNameFileType(id, fileName, fileType);
		for(MemberFileAuthVDTO temp : list){
			if(temp.getIsSharedFile().equals("일반")){
				result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
			}
		}
		return result;
	}
	/**
	 * 모든 파일 범주에서 모든 파일 종류에 대해 업로더 이름에 대한 검색
	 */
	public ArrayList<File> searchFileUploaderName(String id, String uploaderName){
		ArrayList<File> result = new ArrayList<File>();
		if(uploaderName==null){ // 모든 업로더 이름
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuth(id);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // 특정 업로더 이름
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderName(id, uploaderName);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}
	/**
	 * 모든 파일 범주에서 특정 파일 종류에 대해 업로더 이름에 대한 검색
	 */
	@Override
	public ArrayList<File> searchFileUploaderNameType(String id,
			String uploaderName, String fileType) {
		// TODO Auto-generated method stub
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
		ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderName(id, uploaderName, fileType);
		for(MemberFileAuthVDTO temp : list){
			if(temp.getIsSharedFile().trim().equals("일반")){
				result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
			}
		}
		return result;
	}
	/**
	 * 모든 파일 범주에서 모든 파일 종류에 대해 업로더 아이디에 대한 검색
	 */
	public ArrayList<File> searchFileUploaderId(String id, String uploaderId){
		ArrayList<File> result = new ArrayList<File>();
		if(uploaderId.equals("")){ // 모든 업로더 아이디
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuth(id);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // 특정 업로더 아이디
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderCode(id, uploaderId);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}
	/**
	 * 모든 파일 범주에서 특정 파일 종류에 대해 업로더 아이디에 대한 검색
	 */
	@Override
	public ArrayList<File> searchFileUploaderIdType(String id,
			String uploaderId, String fileType) {
		// TODO Auto-generated method stub
		ArrayList<File> result = new ArrayList<File>();
		if(uploaderId.equals("")){ // 모든 업로더 아이디
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeFileType(id, fileType);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // 특정 업로더 아이디
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderCode(id, uploaderId, fileType);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("일반")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}

	@Override
	public ArrayList<File> searchFolderCode(String id, String folderCode) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(folderCode);
		ArrayList<File> result = new ArrayList<File>();
		for(FileDTO temp : list){
			result.add(new File(Group.AWKWARDFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate()));
		}
		return result;
	}

	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아닌 모든 파일을 검색함
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchSharedFile(String id){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니며 해당 타입의 파일을 검색함
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchSharedFileType(String id, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 파일 타입이 다른 파일 필터링
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고 해당 이름이 들어가는 파일 검색
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchSharedFileName(String id, String fileName){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 해당 파일명을 포함는 파일 필터링
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(temp.getFileName().indexOf(fileName)>=0){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고 해당 이름이 들어가며
	 * 해당 파일 타입의 파일 검색
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedFileNameType(String id, String fileName, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 해당 파일명을 포함하고 파일 타입이 같은 파일 필터링
		for(File temp : result){
			if(temp.getFileName().indexOf(fileName)>=0 && temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고 
	 * 나와 이름이 같은 업로더를 포함한 모든 친구의 파일 검색 
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderName(String id, String uploaderName){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 해당 업로더 이름을 포함하는 파일 필터링
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getName().trim().indexOf(uploaderName)>=0){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고
	 * 나와 이름이 같은 업로더를 포함하며 해당 파일 타입의 파일 검색
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderNameType(String id, String uploaderName, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 해당 업로더 이름을 포함하고 파일 타입이 같은 파일 필터링
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getName().trim().indexOf(uploaderName)>=0 && temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내 아이디가 아닌 다른 업로더의 파일 검색
	 * @param id
	 * @param uploaderId
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderId(String id, String uploaderId){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 해당 업로더 아이디가 같은 파일 필터링
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getMemberId().trim().equals(uploaderId)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내 아이디가 아닌 다른 업로더의 파일중에서
	 * 해당 파일 타입의 파일 검색
	 * @param id
	 * @param uploaderId
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderIdType(String id, String uploaderId, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// 내가 호스트가 아닌 초대된 공유 폴더들
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// 내가 호스트인 공유 폴더들
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// 공유폴더들의 파일들 중 내가 업로더가 아닌 파일 검색
		for(MemberSharedVDTO temp : msvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		ArrayList<File> realResult = new ArrayList<File>();
		// 공유폴더들에서 걸러낸 파일중에서 해당 업로더 아이디가 같지 않고 파일 타입이 다른 파일 필터링
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getMemberId().trim().equals(uploaderId) && temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	@Override
	public boolean modifyFileAccessAuth(String id, String filePath,
			String fileName, Object newAccessAuth) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFileAccessAuth(String adminId, String memeberId,
			String filePath, String fileName, Object newAccessAuth) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String modifyFileAccessAuth(String id, String fileCode,
			Object newAccessAuth) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao5 = (FileSearchDAO)factory.create("File");
		FileDTO fileDto = dao5.searchFileCode(fileCode);
		if((fileDto.getMemberCode()).trim().equals(id) && fileDto.getIsShareFile().trim().equals("일반")){
			FileGroupVDAO dao = (FileGroupVDAO)factory.create("FileGroupView");
			ArrayList<FileGroupVDTO> list = (ArrayList<FileGroupVDTO>)dao.searchFileGroup(fileCode);
			AvailableFileAuthGroupDeleteDAO dao2 = (AvailableFileAuthGroupDeleteDAO)factory.create("AvailableFileAuthGroup");
			GroupSearchDAO dao3 = (GroupSearchDAO)factory.create("Group");
			ArrayList<GroupDTO> list2 = (ArrayList<GroupDTO>)dao3.searchMemberCode(id);
			AvailableFileAuthGroupInsertDAO dao4 = (AvailableFileAuthGroupInsertDAO)dao2;
			
			int[] groupCode = new int[3];
			for(int i=0; i<list2.size(); i++){
				groupCode[i] = Integer.parseInt((list2.get(i).getGroupCode().substring(list2.get(i).getGroupCode().indexOf("r")+1)).trim());
			}
			Arrays.sort(groupCode);
			String newAccess = (String)newAccessAuth; 
			if(newAccess.equals("나만보기")){
				dao2.deleteFileCode(fileCode);
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "성공";
			}
			else if(newAccess.equals("어색한친구")){
				dao2.deleteFileCode(fileCode);
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[0]));
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[1]));
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[2]));
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "성공";
			}
			else if(newAccess.equals("친구")){
				dao2.deleteFileCode(fileCode);
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[0]));
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[1]));
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "성공";
			}
			else if(newAccess.equals("절친")){
				dao2.deleteFileCode(fileCode);
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[0]));
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "성공";
			}
		}
		else{
			return "권한이 없습니다.";
		}
		return "실패";
	}

	@Override
	public boolean modifyFileAccessAuthAdmin(String adminId, String memeberId,
			String fileCode, Object newAccessAuth) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFile(String id, String filePath, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFile(String adminId, String memberId, String filePath,
			String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String deleteFile(String id, String fileCode) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("공유")){
			FileDeleteDAO dao2 = (FileDeleteDAO)factory.create("File");
			int res = dao2.deleteFileCode(fileCode);
			if(res>0){
				return "성공";
			}
		}
		else{
			return "권한";
		}
		return "실패";
	}

	@Override
	public String deleteFileAdmin(String adminId, String memberId,
			String fileCode) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		FileDeleteDAO dao2 = (FileDeleteDAO)factory.create("File");
		int res = dao2.deleteFileCode(fileCode);
		if(res>0){
			return "성공";
		}
		return "실패";
	}

	@Override
	public boolean copyPasteFile(String id, Object file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean copyPasteFile(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String copyPasteFile(String id, String fileCode, String newFile) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		double capacity = temp.getFileCapacity();
		
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("공유")){
			FolderSearchDAO dao3 = (FolderSearchDAO)factory.create("Folder");
			FolderDTO folderDto = dao3.searchFolderCode(newFile);
			if(folderDto.getParentFolderCode().trim().equals("root")){
				return "루트";
			}
			MemberLimitCapacityVDAO dao4 = (MemberLimitCapacityVDAO)factory.create("MemberLimitCapacityView"); 
			MemberLimitCapacityVDTO capacityTemp = dao4.searchMemberCapacityMemberCode(id);
			if(capacity>capacityTemp.getTotalCapacity()-capacityTemp.getUsedCapacity() || capacity<=0){
				return "용량";
			}
			FileInsertDAO dao2 = (FileInsertDAO)dao;
			boolean res = dao2.insert(id, newFile, new GregorianCalendar(), temp.getFileComment(), temp.getFileType().trim(), temp.getFileCapacity(), temp.getFileName().trim(), temp.getIsShareFile().trim());
			if(res){
				ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(newFile);

				// 해당 회원의 최신 파일 코드
				FileSearchDAO dao5 = (FileSearchDAO)factory.create("File"); 
				ArrayList<FileDTO> recentList = (ArrayList<FileDTO>)dao5.searchMemberCode(id);
				int[] fileCodeList = new int[recentList.size()];
				for(int i=0; i<recentList.size(); i++){
					fileCodeList[i] = Integer.parseInt((recentList.get(i).getFileCode().substring(recentList.get(i).getFileCode().indexOf("i")+1)).trim());
				}
				Arrays.sort(fileCodeList);
				String realFileCode = "fi" + String.valueOf(fileCodeList[fileCodeList.length-1]);
				
				for(FileDTO temp2 : list){  // 이름 중복 시 현재 시간을 파일명에 더함
					if(temp2.getFileName().trim().equals(temp.getFileName().trim()) && !(temp2.getFileCode().trim().equals(realFileCode))){
						String newName = "(" + new Date().getTime() + ")" + temp.getFileName(); 
						FileUpdateDAO updateDao = (FileUpdateDAO)dao;
						updateDao.updateFileCodeFileName(realFileCode, newName);
									
						// 파일 권한 등록
						AvailableFileAuthGroupSearchDAO authGroupSearchDao = (AvailableFileAuthGroupSearchDAO)factory.create("AvailableFileAuthGroup");
						ArrayList<AvailableFileAuthGroupDTO> fileGroupList = (ArrayList<AvailableFileAuthGroupDTO>)authGroupSearchDao.searchFileCode(fileCode);
						for(AvailableFileAuthGroupDTO groupTemp : fileGroupList){
							AvailableFileAuthGroupInsertDAO dao7 = (AvailableFileAuthGroupInsertDAO)authGroupSearchDao;
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, groupTemp.getGroupCode().trim()));
						}
						
						// 파일 바이너리 등록
						FileBinarySearchDAO binarySearchDao = (FileBinarySearchDAO)factory.create("FileBinary");
						FileBinaryDTO binaryDto = binarySearchDao.selectFileBinary(fileCode);
						FileBinaryInsertDAO dao8= (FileBinaryInsertDAO)binarySearchDao;
						InputStream fileData = (InputStream)binaryDto.getFileBinary();
						CopyInputStream copyStream = new CopyInputStream(fileData);
						InputStream copyData = copyStream.getCopy();
						dao8.insertFileBinary(realFileCode, copyData, binaryDto.getSize());
						return "중복";
					}
				}
				// 파일 권한 등록
				AvailableFileAuthGroupSearchDAO authGroupSearchDao = (AvailableFileAuthGroupSearchDAO)factory.create("AvailableFileAuthGroup");
				ArrayList<AvailableFileAuthGroupDTO> fileGroupList = (ArrayList<AvailableFileAuthGroupDTO>)authGroupSearchDao.searchFileCode(fileCode);
				for(AvailableFileAuthGroupDTO groupTemp : fileGroupList){
					AvailableFileAuthGroupInsertDAO dao7 = (AvailableFileAuthGroupInsertDAO)authGroupSearchDao;
					dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, groupTemp.getGroupCode().trim()));
				}
				
				// 파일 바이너리 등록
				FileBinarySearchDAO binarySearchDao = (FileBinarySearchDAO)factory.create("FileBinary");
				FileBinaryDTO binaryDto = binarySearchDao.selectFileBinary(fileCode);
				FileBinaryInsertDAO dao8= (FileBinaryInsertDAO)binarySearchDao;
				InputStream fileData = (InputStream)binaryDto.getFileBinary();
				CopyInputStream copyStream = new CopyInputStream(fileData);
				InputStream copyData = copyStream.getCopy();
				dao8.insertFileBinary(realFileCode, copyData, binaryDto.getSize());
				return "성공";	
			}
		}
		else{
			return "권한";
		}
		return "실패";
	}

	@Override
	public boolean modifyFileName(String id, String filePath, String fileName,
			String newFileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFileName(String adminId, String memberId,
			String filePath, String fileName, String newFileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String modifyFileName(String id, String fileCode, String newFileName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("공유")){
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : list){
				if(temp2.getFileName().trim().equals(newFileName))
					return "이름중복";
			}
			FileUpdateDAO dao2 = (FileUpdateDAO)dao;
			int res = dao2.updateFileCodeFileName(fileCode, newFileName);
			if(res>0){
				dao2.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "성공";
			}
		}
		else{
			return "권한";
		}
		return "실패";
	}

	@Override
	public String modifyFileNameAdmin(String adminId, String memberId,
			String fileCode, String newFileName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		System.out.println("내부 :"+temp.getMemberCode());
		System.out.println("내부 :"+memberId);
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		MemberDTO memberDTO = memberSearchDAO.searchMemberId(memberId);
		String memberCode = memberDTO.getMemberCode();
		
		if((temp.getMemberCode()).trim().equals(memberCode.trim())){
			System.out.println("멤버코드 확인완료");
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : list){
				if(temp2.getFileName().equals(newFileName))
					return "이름중복";
			}
			FileUpdateDAO dao2 = (FileUpdateDAO)dao;
			int res = dao2.updateFileCodeFileName(fileCode, newFileName);
			if(res>0){
				return "성공";
			}
		} return "실패";
	}

	@Override
	public boolean modifyFilePath(String id, String filePath, String fileName,
			String newFilePath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFilePath(String adminId, String memberId,
			String filePath, String fileName, String newFilePath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String modifyFilePath(String id, String fileCode,
			String newFolderCode) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("공유")){
			FolderSearchDAO dao3 = (FolderSearchDAO)factory.create("Folder");
			FolderDTO folderDto = dao3.searchFolderCode(newFolderCode);
			if(folderDto.getParentFolderCode().trim().equals("root")){
				return "루트";
			}
			FileUpdateDAO dao2 = (FileUpdateDAO)dao;
			int res = dao2.updateFileCodeFolderCode(fileCode, newFolderCode);
			if(res>0){
				ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(newFolderCode);
				for(FileDTO temp2 : list){  // 이름 중복 시 현재 시간을 파일명에 더함
					if(temp2.getFileName().trim().equals(temp.getFileName().trim()) && !(temp2.getFileCode().trim().equals(fileCode))){
						String newName = "(" + new Date().getTime() + ")" + temp.getFileName(); 
						dao2.updateFileCodeFileName(fileCode, newName);
						dao2.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
						return "중복";
					}
				}
				dao2.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "성공";
			}
		}
		else{
			return "권한";
		}
		return "실패";
	}

	@Override
	public boolean modifyFilePathAdmin(String adminId, String memberId,
			String fileCode, String newFolderCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadFile(Object file, InputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean uploadFile(String adminId, Object file, InputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}

}
