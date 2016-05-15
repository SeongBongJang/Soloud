package com.soloud.app.man;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soloud.app.manInt.FileSearchable;
import com.soloud.app.model.File;
import com.soloud.per.dao.AvailableFileAuthGroupInsertDAO;
import com.soloud.per.dao.FileBinaryInsertDAO;
import com.soloud.per.dao.FileInsertDAO;
import com.soloud.per.dao.FileSearchDAO;
import com.soloud.per.dao.FolderSearchDAO;
import com.soloud.per.dao.GroupSearchDAO;
import com.soloud.per.dao.MemberLimitCapacityVDAO;
import com.soloud.per.dto.AvailableFileAuthGroupDTO;
import com.soloud.per.dto.FileDTO;
import com.soloud.per.dto.FolderDTO;
import com.soloud.per.dto.GroupDTO;
import com.soloud.per.dto.MemberLimitCapacityVDTO;
import com.soloud.per.factory.DAOFactory;

@Service
public class FileUploadService {
	
	/**
	 * ���� ���� ���ε� ������� ���� �����ڵ�� �ӽ÷� ����־���
	 */
	public String fileUpload(MultipartHttpServletRequest mRequest) {
		String isSuccess = "����";
		
		HttpSession session = mRequest.getSession();
		
		// �ڵ忡 �ش��ϴ� ���� ���� ����
		this.loadFileList(mRequest);

		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ���� �ߴ� ���� ���� ���
		ArrayList<String> nameList = (ArrayList<String>)mRequest.getAttribute("name");  // ���ϸ� �ִ� ��
		ArrayList<String> typeList = (ArrayList<String>)mRequest.getAttribute("type");  // �������� �ִ� ��
		ArrayList<String> timeList = (ArrayList<String>)mRequest.getAttribute("time");  // �����ð� �ִ� ��
		
		/*String uploadPath = "C:/Users/����/Documents/";
		
		File dir = new File(uploadPath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}*/
		Iterator<String> iter = mRequest.getFileNames();
		String uploadFileName = iter.next();
		
		// ���� ���δ� �ڵ�
		String memberCode = (String)mRequest.getSession().getAttribute("memberCode");
		System.out.println(memberCode);
					
		// ���� �ڸ�Ʈ
		String content = mRequest.getParameter("content");
		System.out.println(content);
		
		// ���� ���� �ڵ�
		String folderCode = (String)mRequest.getSession().getAttribute("folderCode");
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FolderSearchDAO dao = (FolderSearchDAO)factory.create("Folder");
		ArrayList<FolderDTO> rootDto = (ArrayList<FolderDTO>)dao.searchMemberCodeParentFolderCode(memberCode, "root");
		System.out.println(folderCode);
		System.out.println(rootDto.get(0));
		System.out.println(rootDto.get(1));
		
		// ��Ʈ ���� ����
		if(folderCode!=null){
			if(folderCode.equals(rootDto.get(0).getFolderCode().trim()) || folderCode.equals(rootDto.get(1).getFolderCode().trim())){
				isSuccess = "��Ʈ";
				return isSuccess;
			}
			else{
				// ���� ���� ����
				String isShare = "�Ϲ�";
				if(dao.searchFolderCode(folderCode).getIsShareFolder().trim().equals("����")){
					isShare = "����";
				}
				System.out.println(isShare);
				
				// ���� ���� ����
				String scope = mRequest.getParameter("scope");
				GroupSearchDAO dao3 = (GroupSearchDAO)factory.create("Group");
				ArrayList<GroupDTO> list2 = (ArrayList<GroupDTO>)dao3.searchMemberCode(memberCode);
				int[] groupCode = new int[3];
				for(int i=0; i<list2.size(); i++){
					groupCode[i] = Integer.parseInt((list2.get(i).getGroupCode().substring(list2.get(i).getGroupCode().indexOf("r")+1)).trim());
				}
				Arrays.sort(groupCode);
							
				// ���� ���� ��¥
				GregorianCalendar today = new GregorianCalendar();
				
				// ���ε� ��û�� ���� ���ϵ�
				List<MultipartFile> fileList = mRequest.getFiles(uploadFileName);
				
				// ���� ������ŭ �ݺ�
				for(MultipartFile tempFile : fileList)
				{
					// ���� �̸�
					String originalFileName = tempFile.getOriginalFilename();
					System.out.println(originalFileName);
					
					// �̸� �ߺ� ó��
					FileSearchDAO dao2= (FileSearchDAO)factory.create("File");
					ArrayList<FileDTO> fileDtoList = (ArrayList<FileDTO>)dao2.searchFolderCode(folderCode);
					for(FileDTO temp2 : fileDtoList){  // �̸� �ߺ� �� ���� �ð��� ���ϸ� ����
						if(temp2.getFileName().trim().equals(originalFileName)){
							isSuccess = "�ߺ�";
							originalFileName = "(" + new Date().getTime() + ")" + originalFileName;
						}
					}
		
					if(originalFileName != null && !originalFileName.equals("")){
						double capacity = 0;
						try{
							// ���� �뷮
							capacity = tempFile.getBytes().length;
							System.out.println(capacity);
							// �뷮 ���� �˻�
							MemberLimitCapacityVDAO dao4 = (MemberLimitCapacityVDAO)factory.create("MemberLimitCapacityView"); 
							MemberLimitCapacityVDTO temp = dao4.searchMemberCapacityMemberCode(memberCode);
							System.out.println(temp.getTotalCapacity());
							System.out.println(temp.getUsedCapacity());
							if(capacity>temp.getTotalCapacity()-temp.getUsedCapacity() || capacity<=0){
								break;
							}
						}
						catch(Exception e){
							e.printStackTrace();
						}
						
						// ���� ����
						String fileType = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
						String realType = null;
						if(fileType.equals("avi")||fileType.equals("wmv")||fileType.equals("mpeg")||fileType.equals("mpg")||fileType.equals("mpe")||fileType.equals("mp4")||fileType.equals("asf")||fileType.equals("asx")){
							realType = "video";
						}
						else if(fileType.equals("mp3")||fileType.equals("ogg")||fileType.equals("wma")||fileType.equals("wav")||fileType.equals("flac")){
							realType = "audio";
						}
						else if(fileType.equals("hwp")||fileType.equals("doc")||fileType.equals("ppt")||fileType.equals("xls")||fileType.equals("docx")||fileType.equals("txt")){
							realType = "document";
						}
						else if(fileType.equals("png")||fileType.equals("jpg")||fileType.equals("jpeg")||fileType.equals("bmp")||fileType.equals("gif")){
							realType = "image";
						}
						else{
							realType = "etc";
						}
						System.out.println(realType);
						
						// ���� ���
						FileInsertDAO dao6 = (FileInsertDAO)factory.create("File"); 
						dao6.insert(memberCode, folderCode, today, content, realType, capacity, originalFileName, isShare);
						
						// �ش� ȸ���� �ֽ� ���� �ڵ�
						FileSearchDAO dao5 = (FileSearchDAO)factory.create("File"); 
						ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao5.searchMemberCode(memberCode);
						int[] fileCode = new int[list.size()];
						for(int i=0; i<list.size(); i++){
							fileCode[i] = Integer.parseInt((list.get(i).getFileCode().substring(list.get(i).getFileCode().indexOf("i")+1)).trim());
						}
						Arrays.sort(fileCode);
						String realFileCode = "fi" + String.valueOf(fileCode[fileCode.length-1]);
						System.out.println(realFileCode);
									
						// ���� ���� ���
						AvailableFileAuthGroupInsertDAO dao7 = (AvailableFileAuthGroupInsertDAO)factory.create("AvailableFileAuthGroup");
						if(isShare.equals("�Ϲ�")){
							System.out.println(isShare);
							if(scope.equals("�����ģ��")){
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[1]));
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[2]));
							}
							else if(scope.equals("ģ��")){
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[1]));
							}
							else if(scope.equals("��ģ")){
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
							}
						}
						else{
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[1]));
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[2]));
						}
		
						// ���� ���̳ʸ� ���
						try {
							FileBinaryInsertDAO dao8= (FileBinaryInsertDAO)factory.create("FileBinary");
							dao8.insertFileBinary(realFileCode, tempFile.getInputStream(), tempFile.getBytes().length);
							//tempFile.transferTo(new File(uploadPath + originalFileName));
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}


						// ���� �ð� ����
						SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");
						
						nameList.add("&nbsp;" + originalFileName);
						typeList.add("&nbsp;" + realType);
						timeList.add("&nbsp;" + format.format(today.getTime()));
						file_table.add(realFileCode);
						
					} // if end
				} // for end
			}
		}
		mRequest.setAttribute("name", nameList);
		mRequest.setAttribute("type", typeList);
		mRequest.setAttribute("time", timeList);
		session.setAttribute("file_table", file_table);
		
		return isSuccess;
	} // fileUpload end
	
	private void loadFileList(MultipartHttpServletRequest mRequest){
		HttpSession session = mRequest.getSession();
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ���ε� �� �ѷ��ֱ� ���� ���̺� ��� ����
		ArrayList<String> nameList = new ArrayList<String>();  // ���ϸ� �ִ� ��
		ArrayList<String> typeList = new ArrayList<String>();  // �������� �ִ� ��
		ArrayList<String> timeList = new ArrayList<String>();  // �����ð� �ִ� ��

		// ���� �ð� ����
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");
		
		FileSearchable fileSearchManager = (FileSearchable)new FileManager();
		for(String fileCode : file_table){
			File temp = fileSearchManager.searchFileCode((String)mRequest.getAttribute("memberCode"), fileCode);
			nameList.add(temp.getFileName());
			typeList.add(temp.getFileType());
			timeList.add(format.format(temp.getLastModifyDate().getTime()));
		}
		mRequest.setAttribute("name", nameList);
		mRequest.setAttribute("type", typeList);
		mRequest.setAttribute("time", timeList);
	}
}