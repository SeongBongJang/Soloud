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
	 * 다중 파일 업로드 기능으로 현재 폴더코드는 임시로 집어넣었음
	 */
	public String fileUpload(MultipartHttpServletRequest mRequest) {
		String isSuccess = "성공";
		
		HttpSession session = mRequest.getSession();
		
		// 코드에 해당하는 파일 정보 셋팅
		this.loadFileList(mRequest);

		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 셋팅 했던 파일 정보 목록
		ArrayList<String> nameList = (ArrayList<String>)mRequest.getAttribute("name");  // 파일명 넣는 곳
		ArrayList<String> typeList = (ArrayList<String>)mRequest.getAttribute("type");  // 파일유형 넣는 곳
		ArrayList<String> timeList = (ArrayList<String>)mRequest.getAttribute("time");  // 수정시간 넣는 곳
		
		/*String uploadPath = "C:/Users/영진/Documents/";
		
		File dir = new File(uploadPath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}*/
		Iterator<String> iter = mRequest.getFileNames();
		String uploadFileName = iter.next();
		
		// 파일 업로더 코드
		String memberCode = (String)mRequest.getSession().getAttribute("memberCode");
		System.out.println(memberCode);
					
		// 파일 코멘트
		String content = mRequest.getParameter("content");
		System.out.println(content);
		
		// 현재 폴더 코드
		String folderCode = (String)mRequest.getSession().getAttribute("folderCode");
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FolderSearchDAO dao = (FolderSearchDAO)factory.create("Folder");
		ArrayList<FolderDTO> rootDto = (ArrayList<FolderDTO>)dao.searchMemberCodeParentFolderCode(memberCode, "root");
		System.out.println(folderCode);
		System.out.println(rootDto.get(0));
		System.out.println(rootDto.get(1));
		
		// 루트 파일 여부
		if(folderCode!=null){
			if(folderCode.equals(rootDto.get(0).getFolderCode().trim()) || folderCode.equals(rootDto.get(1).getFolderCode().trim())){
				isSuccess = "루트";
				return isSuccess;
			}
			else{
				// 공유 파일 여부
				String isShare = "일반";
				if(dao.searchFolderCode(folderCode).getIsShareFolder().trim().equals("공유")){
					isShare = "공유";
				}
				System.out.println(isShare);
				
				// 파일 접근 권한
				String scope = mRequest.getParameter("scope");
				GroupSearchDAO dao3 = (GroupSearchDAO)factory.create("Group");
				ArrayList<GroupDTO> list2 = (ArrayList<GroupDTO>)dao3.searchMemberCode(memberCode);
				int[] groupCode = new int[3];
				for(int i=0; i<list2.size(); i++){
					groupCode[i] = Integer.parseInt((list2.get(i).getGroupCode().substring(list2.get(i).getGroupCode().indexOf("r")+1)).trim());
				}
				Arrays.sort(groupCode);
							
				// 파일 수정 날짜
				GregorianCalendar today = new GregorianCalendar();
				
				// 업로드 요청을 받은 파일들
				List<MultipartFile> fileList = mRequest.getFiles(uploadFileName);
				
				// 파일 갯수만큼 반복
				for(MultipartFile tempFile : fileList)
				{
					// 파일 이름
					String originalFileName = tempFile.getOriginalFilename();
					System.out.println(originalFileName);
					
					// 이름 중복 처리
					FileSearchDAO dao2= (FileSearchDAO)factory.create("File");
					ArrayList<FileDTO> fileDtoList = (ArrayList<FileDTO>)dao2.searchFolderCode(folderCode);
					for(FileDTO temp2 : fileDtoList){  // 이름 중복 시 현재 시간을 파일명에 더함
						if(temp2.getFileName().trim().equals(originalFileName)){
							isSuccess = "중복";
							originalFileName = "(" + new Date().getTime() + ")" + originalFileName;
						}
					}
		
					if(originalFileName != null && !originalFileName.equals("")){
						double capacity = 0;
						try{
							// 파일 용량
							capacity = tempFile.getBytes().length;
							System.out.println(capacity);
							// 용량 제한 검사
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
						
						// 파일 유형
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
						
						// 파일 등록
						FileInsertDAO dao6 = (FileInsertDAO)factory.create("File"); 
						dao6.insert(memberCode, folderCode, today, content, realType, capacity, originalFileName, isShare);
						
						// 해당 회원의 최신 파일 코드
						FileSearchDAO dao5 = (FileSearchDAO)factory.create("File"); 
						ArrayList<FileDTO> list = (ArrayList<FileDTO>)dao5.searchMemberCode(memberCode);
						int[] fileCode = new int[list.size()];
						for(int i=0; i<list.size(); i++){
							fileCode[i] = Integer.parseInt((list.get(i).getFileCode().substring(list.get(i).getFileCode().indexOf("i")+1)).trim());
						}
						Arrays.sort(fileCode);
						String realFileCode = "fi" + String.valueOf(fileCode[fileCode.length-1]);
						System.out.println(realFileCode);
									
						// 파일 권한 등록
						AvailableFileAuthGroupInsertDAO dao7 = (AvailableFileAuthGroupInsertDAO)factory.create("AvailableFileAuthGroup");
						if(isShare.equals("일반")){
							System.out.println(isShare);
							if(scope.equals("어색한친구")){
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[1]));
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[2]));
							}
							else if(scope.equals("친구")){
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[1]));
							}
							else if(scope.equals("절친")){
								dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
							}
						}
						else{
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[0]));
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[1]));
							dao7.insertAFAG(new AvailableFileAuthGroupDTO(realFileCode, "gr"+groupCode[2]));
						}
		
						// 파일 바이너리 등록
						try {
							FileBinaryInsertDAO dao8= (FileBinaryInsertDAO)factory.create("FileBinary");
							dao8.insertFileBinary(realFileCode, tempFile.getInputStream(), tempFile.getBytes().length);
							//tempFile.transferTo(new File(uploadPath + originalFileName));
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}


						// 수정 시간 포멧
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
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 업로드 후 뿌려주기 위한 테이블 목록 세팅
		ArrayList<String> nameList = new ArrayList<String>();  // 파일명 넣는 곳
		ArrayList<String> typeList = new ArrayList<String>();  // 파일유형 넣는 곳
		ArrayList<String> timeList = new ArrayList<String>();  // 수정시간 넣는 곳

		// 수정 시간 포멧
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