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
	 * ȸ���� ������ ��� �˻���
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
	 * �����ڿ�
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
	 * ��� ���� ���ֿ��� ��� ���� ������ ���� ���� �� ���� �˻�
	 */
	@Override
	public ArrayList<File> searchFileName(String id, String fileName) {
		// TODO Auto-generated method stub
		ArrayList<File> result = new ArrayList<File>();
		if(fileName==null){ // ��� ����
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuth(id);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // ���� ��
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeFileName(id, fileName);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}
	/**
	 * ȸ���� ���� �� �ش� Ÿ���� ���� �˻�
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
	 * ȸ���� ���� �� ���ϸ� �ش��ϴ� ���� �˻�
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
	 * ȸ���� ���� �� ���δ� �̸��� ���ԵǴ� ���� �˻�
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
	 * ȸ���� ���� �� ���δ� �̸��� ���Եǰ� ���� Ÿ���� ��ġ�ϴ� ���� �˻�
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
	 * ȸ���� ���� �� ���ϸ�� ���� ������ �ش��ϴ� ���� �˻�
	 */
	public ArrayList<File> searchMyFileNameType(String id, String fileName, String fileType){
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		ArrayList<File> tempList = new ArrayList<File>();
		if(!fileName.equals("")){
			System.out.println("���� �̸� ���� �˻�");
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFileNameFileType(fileName, fileType);
			for(FileDTO temp : list){
				if(temp.getMemberCode().trim().equals(id)){
					tempList.add(new File(temp.getFileCode().trim(), temp.getFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), temp.getFileCode().trim(), (float)temp.getFileCapacity(), temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{
			System.out.println("���� �̸� ������ �˻�");
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
	 * ���� �ڵ� �ϳ��� �ش��ϴ� ������ ������ �˻�
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
			fileCapacity = (float)(capacity/1024d/1024d);  // �ް�����Ʈ ����
			fileCapacity = Float.parseFloat(df.format(fileCapacity));
			realCapacity = fileCapacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // ų�ι���Ʈ ����
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
		
		String groupKind = "�����ģ��";
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
				groupKind = "ģ��";
			}
			if(groupCode[1]==0){
				groupKind = "��ģ";
			}
		}
		else{
			groupKind="��������";
		}
		
		File result = new File(groupKind, realCapacity, Group.AWKWARDFRIEND, temp.getFileName().trim(), "", 0.0f, temp.getFileType().trim(), temp.getFileComment(), temp.getFileLatestModifyDate(), uploaderName);
		return result;
	}

	/**
	 * ��� ���� ���ֿ��� Ư�� ���� ������ ���� ���� �� �ش��ϴ� ���� �˻�
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
			if(temp.getIsSharedFile().equals("�Ϲ�")){
				result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
			}
		}
		return result;
	}
	/**
	 * ��� ���� ���ֿ��� ��� ���� ������ ���� ���δ� �̸��� ���� �˻�
	 */
	public ArrayList<File> searchFileUploaderName(String id, String uploaderName){
		ArrayList<File> result = new ArrayList<File>();
		if(uploaderName==null){ // ��� ���δ� �̸�
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuth(id);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // Ư�� ���δ� �̸�
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderName(id, uploaderName);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}
	/**
	 * ��� ���� ���ֿ��� Ư�� ���� ������ ���� ���δ� �̸��� ���� �˻�
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
			if(temp.getIsSharedFile().trim().equals("�Ϲ�")){
				result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
			}
		}
		return result;
	}
	/**
	 * ��� ���� ���ֿ��� ��� ���� ������ ���� ���δ� ���̵� ���� �˻�
	 */
	public ArrayList<File> searchFileUploaderId(String id, String uploaderId){
		ArrayList<File> result = new ArrayList<File>();
		if(uploaderId.equals("")){ // ��� ���δ� ���̵�
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuth(id);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // Ư�� ���δ� ���̵�
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderCode(id, uploaderId);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		return result;
	}
	/**
	 * ��� ���� ���ֿ��� Ư�� ���� ������ ���� ���δ� ���̵� ���� �˻�
	 */
	@Override
	public ArrayList<File> searchFileUploaderIdType(String id,
			String uploaderId, String fileType) {
		// TODO Auto-generated method stub
		ArrayList<File> result = new ArrayList<File>();
		if(uploaderId.equals("")){ // ��� ���δ� ���̵�
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeFileType(id, fileType);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("�Ϲ�")){
					result.add(new File(temp.getFileCode().trim(), temp.getFileFolderCode().trim(), Group.BESTFRIEND, temp.getFileName().trim(), "filePath", 0, temp.getFileType().trim(), temp.getFileComment(), temp.getLatestModifiedDate(), temp.getMemberCode().trim()));
				}
			}
		}
		else{ // Ư�� ���δ� ���̵�
			DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
			MemberFileAuthVDAO dao= (MemberFileAuthVDAO)factory.create("MemberFileAuthView");
			ArrayList<MemberFileAuthVDTO> list = (ArrayList<MemberFileAuthVDTO>)dao.searchMemberFileAuthMemberCodeUploaderCode(id, uploaderId, fileType);
			for(MemberFileAuthVDTO temp : list){
				if(temp.getIsSharedFile().trim().equals("�Ϲ�")){
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
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴ� ��� ������ �˻���
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchSharedFile(String id){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϸ� �ش� Ÿ���� ������ �˻���
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchSharedFileType(String id, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� ���� Ÿ���� �ٸ� ���� ���͸�
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� �̸��� ���� ���� �˻�
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchSharedFileName(String id, String fileName){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� �ش� ���ϸ��� ���Դ� ���� ���͸�
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(temp.getFileName().indexOf(fileName)>=0){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� �̸��� ����
	 * �ش� ���� Ÿ���� ���� �˻�
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedFileNameType(String id, String fileName, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� �ش� ���ϸ��� �����ϰ� ���� Ÿ���� ���� ���� ���͸�
		for(File temp : result){
			if(temp.getFileName().indexOf(fileName)>=0 && temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� 
	 * ���� �̸��� ���� ���δ��� ������ ��� ģ���� ���� �˻� 
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderName(String id, String uploaderName){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� �ش� ���δ� �̸��� �����ϴ� ���� ���͸�
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getName().trim().indexOf(uploaderName)>=0){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ�
	 * ���� �̸��� ���� ���δ��� �����ϸ� �ش� ���� Ÿ���� ���� �˻�
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderNameType(String id, String uploaderName, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� �ش� ���δ� �̸��� �����ϰ� ���� Ÿ���� ���� ���� ���͸�
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getName().trim().indexOf(uploaderName)>=0 && temp.getFileType().equals(fileType)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� �� ���̵� �ƴ� �ٸ� ���δ��� ���� �˻�
	 * @param id
	 * @param uploaderId
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderId(String id, String uploaderId){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� �ش� ���δ� ���̵� ���� ���� ���͸�
		for(File temp : result){
			MemberSearchDAO msdao = (MemberSearchDAO)factory.create("Member");
			if(msdao.searchMemberCode(temp.getUploaderId()).getMemberId().trim().equals(uploaderId)){
				realResult.add(temp);
			}
		}
		
		return realResult;
	}
	
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� �� ���̵� �ƴ� �ٸ� ���δ��� �����߿���
	 * �ش� ���� Ÿ���� ���� �˻�
	 * @param id
	 * @param uploaderId
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderIdType(String id, String uploaderId, String fileType){
		ArrayList<File> result = new ArrayList<File>();
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		
		// ���� ȣ��Ʈ�� �ƴ� �ʴ�� ���� ������
		MemberShareFolderVDAO msfvdao = (MemberShareFolderVDAO)factory.create("MemberShareFolderView");
		ArrayList<MemberShareFolderVDTO> msfvdto = (ArrayList<MemberShareFolderVDTO>)msfvdao.searchMemberShareFolder(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
		for(MemberShareFolderVDTO temp : msfvdto){
			FileSearchDAO fsdao = (FileSearchDAO)factory.create("File");
			ArrayList<FileDTO> fdto = (ArrayList<FileDTO>)fsdao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : fdto){
				if(!temp2.getMemberCode().trim().equals(id)){
					result.add(new File(temp2.getFileCode().trim(), temp2.getFolderCode().trim(), Group.BESTFRIEND, temp2.getFileName().trim(), temp2.getFolderCode().trim(), (float)temp2.getFileCapacity(), temp2.getFileType().trim(), temp2.getFileComment(), temp2.getFileLatestModifyDate(), temp2.getMemberCode().trim()));
				}
			}
		}
		
		// ���� ȣ��Ʈ�� ���� ������
		MemberSharedVDAO msvdao = (MemberSharedVDAO)factory.create("MemberSharedView");
		ArrayList<MemberSharedVDTO> msvdto = (ArrayList<MemberSharedVDTO>)msvdao.searchMemberShared(id);
		
		// ������������ ���ϵ� �� ���� ���δ��� �ƴ� ���� �˻�
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
		// ���������鿡�� �ɷ��� �����߿��� �ش� ���δ� ���̵� ���� �ʰ� ���� Ÿ���� �ٸ� ���� ���͸�
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
		if((fileDto.getMemberCode()).trim().equals(id) && fileDto.getIsShareFile().trim().equals("�Ϲ�")){
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
			if(newAccess.equals("��������")){
				dao2.deleteFileCode(fileCode);
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "����";
			}
			else if(newAccess.equals("�����ģ��")){
				dao2.deleteFileCode(fileCode);
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[0]));
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[1]));
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[2]));
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "����";
			}
			else if(newAccess.equals("ģ��")){
				dao2.deleteFileCode(fileCode);
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[0]));
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[1]));
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "����";
			}
			else if(newAccess.equals("��ģ")){
				dao2.deleteFileCode(fileCode);
				dao4.insertAFAG(new AvailableFileAuthGroupDTO(fileCode, "gr"+groupCode[0]));
				FileUpdateDAO dao6 = (FileUpdateDAO)factory.create("File");
				dao6.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "����";
			}
		}
		else{
			return "������ �����ϴ�.";
		}
		return "����";
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
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("����")){
			FileDeleteDAO dao2 = (FileDeleteDAO)factory.create("File");
			int res = dao2.deleteFileCode(fileCode);
			if(res>0){
				return "����";
			}
		}
		else{
			return "����";
		}
		return "����";
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
			return "����";
		}
		return "����";
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
		
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("����")){
			FolderSearchDAO dao3 = (FolderSearchDAO)factory.create("Folder");
			FolderDTO folderDto = dao3.searchFolderCode(newFile);
			if(folderDto.getParentFolderCode().trim().equals("root")){
				return "��Ʈ";
			}
			MemberLimitCapacityVDAO dao4 = (MemberLimitCapacityVDAO)factory.create("MemberLimitCapacityView"); 
			MemberLimitCapacityVDTO capacityTemp = dao4.searchMemberCapacityMemberCode(id);
			if(capacity>capacityTemp.getTotalCapacity()-capacityTemp.getUsedCapacity() || capacity<=0){
				return "�뷮";
			}
			FileInsertDAO dao2 = (FileInsertDAO)dao;
			boolean res = dao2.insert(id, newFile, new GregorianCalendar(), temp.getFileComment(), temp.getFileType().trim(), temp.getFileCapacity(), temp.getFileName().trim(), temp.getIsShareFile().trim());
			if(res){
				ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(newFile);

				// �ش� ȸ���� �ֽ� ���� �ڵ�
				FileSearchDAO dao5 = (FileSearchDAO)factory.create("File"); 
				ArrayList<FileDTO> recentList = (ArrayList<FileDTO>)dao5.searchMemberCode(id);
				int[] fileCodeList = new int[recentList.size()];
				for(int i=0; i<recentList.size(); i++){
					fileCodeList[i] = Integer.parseInt((recentList.get(i).getFileCode().substring(recentList.get(i).getFileCode().indexOf("i")+1)).trim());
				}
				Arrays.sort(fileCodeList);
				String realFileCode = "fi" + String.valueOf(fileCodeList[fileCodeList.length-1]);
				
				for(FileDTO temp2 : list){  // �̸� �ߺ� �� ���� �ð��� ���ϸ� ����
					if(temp2.getFileName().trim().equals(temp.getFileName().trim()) && !(temp2.getFileCode().trim().equals(realFileCode))){
						String newName = "(" + new Date().getTime() + ")" + temp.getFileName(); 
						FileUpdateDAO updateDao = (FileUpdateDAO)dao;
						updateDao.updateFileCodeFileName(realFileCode, newName);
									
						// ���� ���� ���
						AvailableFileAuthGroupSearchDAO authGroupSearchDao = (AvailableFileAuthGroupSearchDAO)factory.create("AvailableFileAuthGroup");
						ArrayList<AvailableFileAuthGroupDTO> fileGroupList = (ArrayList<AvailableFileAuthGroupDTO>)authGroupSearchDao.searchFileCode(fileCode);
						for(AvailableFileAuthGroupDTO groupTemp : fileGroupList){
							AvailableFileAuthGroupInsertDAO dao7 = (AvailableFileAuthGroupInsertDAO)authGroupSearchDao;
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, groupTemp.getGroupCode().trim()));
						}
						
						// ���� ���̳ʸ� ���
						FileBinarySearchDAO binarySearchDao = (FileBinarySearchDAO)factory.create("FileBinary");
						FileBinaryDTO binaryDto = binarySearchDao.selectFileBinary(fileCode);
						FileBinaryInsertDAO dao8= (FileBinaryInsertDAO)binarySearchDao;
						InputStream fileData = (InputStream)binaryDto.getFileBinary();
						CopyInputStream copyStream = new CopyInputStream(fileData);
						InputStream copyData = copyStream.getCopy();
						dao8.insertFileBinary(realFileCode, copyData, binaryDto.getSize());
						return "�ߺ�";
					}
				}
				// ���� ���� ���
				AvailableFileAuthGroupSearchDAO authGroupSearchDao = (AvailableFileAuthGroupSearchDAO)factory.create("AvailableFileAuthGroup");
				ArrayList<AvailableFileAuthGroupDTO> fileGroupList = (ArrayList<AvailableFileAuthGroupDTO>)authGroupSearchDao.searchFileCode(fileCode);
				for(AvailableFileAuthGroupDTO groupTemp : fileGroupList){
					AvailableFileAuthGroupInsertDAO dao7 = (AvailableFileAuthGroupInsertDAO)authGroupSearchDao;
					dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, groupTemp.getGroupCode().trim()));
				}
				
				// ���� ���̳ʸ� ���
				FileBinarySearchDAO binarySearchDao = (FileBinarySearchDAO)factory.create("FileBinary");
				FileBinaryDTO binaryDto = binarySearchDao.selectFileBinary(fileCode);
				FileBinaryInsertDAO dao8= (FileBinaryInsertDAO)binarySearchDao;
				InputStream fileData = (InputStream)binaryDto.getFileBinary();
				CopyInputStream copyStream = new CopyInputStream(fileData);
				InputStream copyData = copyStream.getCopy();
				dao8.insertFileBinary(realFileCode, copyData, binaryDto.getSize());
				return "����";	
			}
		}
		else{
			return "����";
		}
		return "����";
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
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("����")){
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : list){
				if(temp2.getFileName().trim().equals(newFileName))
					return "�̸��ߺ�";
			}
			FileUpdateDAO dao2 = (FileUpdateDAO)dao;
			int res = dao2.updateFileCodeFileName(fileCode, newFileName);
			if(res>0){
				dao2.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "����";
			}
		}
		else{
			return "����";
		}
		return "����";
	}

	@Override
	public String modifyFileNameAdmin(String adminId, String memberId,
			String fileCode, String newFileName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO temp = dao.searchFileCode(fileCode);
		System.out.println("���� :"+temp.getMemberCode());
		System.out.println("���� :"+memberId);
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		MemberDTO memberDTO = memberSearchDAO.searchMemberId(memberId);
		String memberCode = memberDTO.getMemberCode();
		
		if((temp.getMemberCode()).trim().equals(memberCode.trim())){
			System.out.println("����ڵ� Ȯ�οϷ�");
			ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(temp.getFolderCode().trim());
			for(FileDTO temp2 : list){
				if(temp2.getFileName().equals(newFileName))
					return "�̸��ߺ�";
			}
			FileUpdateDAO dao2 = (FileUpdateDAO)dao;
			int res = dao2.updateFileCodeFileName(fileCode, newFileName);
			if(res>0){
				return "����";
			}
		} return "����";
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
		if((temp.getMemberCode()).trim().equals(id) || temp.getIsShareFile().trim().equals("����")){
			FolderSearchDAO dao3 = (FolderSearchDAO)factory.create("Folder");
			FolderDTO folderDto = dao3.searchFolderCode(newFolderCode);
			if(folderDto.getParentFolderCode().trim().equals("root")){
				return "��Ʈ";
			}
			FileUpdateDAO dao2 = (FileUpdateDAO)dao;
			int res = dao2.updateFileCodeFolderCode(fileCode, newFolderCode);
			if(res>0){
				ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao.searchFolderCode(newFolderCode);
				for(FileDTO temp2 : list){  // �̸� �ߺ� �� ���� �ð��� ���ϸ� ����
					if(temp2.getFileName().trim().equals(temp.getFileName().trim()) && !(temp2.getFileCode().trim().equals(fileCode))){
						String newName = "(" + new Date().getTime() + ")" + temp.getFileName(); 
						dao2.updateFileCodeFileName(fileCode, newName);
						dao2.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
						return "�ߺ�";
					}
				}
				dao2.updateFileCodeLatestModifyDate(fileCode, new GregorianCalendar());
				return "����";
			}
		}
		else{
			return "����";
		}
		return "����";
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
