package com.soloud.pre.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.soloud.app.man.FileManager;
import com.soloud.app.man.MemberManager;
import com.soloud.app.manInt.FileAccessAuthModifiable;
import com.soloud.app.manInt.FileCopyPastable;
import com.soloud.app.manInt.FileDelable;
import com.soloud.app.manInt.FileNameModifiable;
import com.soloud.app.manInt.FilePathModifiable;
import com.soloud.app.manInt.FileSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.File;
import com.soloud.app.model.Member;
import com.soloud.pre.uiform.FileManageForm;
import com.soloud.pre.validator.FileManageValidator;
import com.soloud.util.CheckURI;

/**
 * Servlet implementation class FileManageServlet
 * 
 */
/**
 * 파일 관리 요청을 담당하는 서블릿
 * @author 영진
 *
 */
@WebServlet(name="FileManageServlet", urlPatterns={"/file_name", "/file_path", "/file_delete", "/file_search", "/file_copy", "/file_info", "/file_access", "/file_folder"})
public class FileManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 사용자가 링크 걸기 서비스 이용 후 만들어진 URL을 클릭했을때 해당 파일로 연결해줌 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("asd");
		String url = CheckURI.getLastURI(request.getRequestURL());
		if(url.equals("file_link")){
			//System.out.println("링크걸기");
			//adLinkInfo(request, response);
		}
	}

	/**
	 * 모든 파일 관리 기능의 요청에 응답하는 메소드
	 * 파일명수정, 파일이동, 파일삭제, 파일복붙, 파일검색, 상세보기, 권한변경
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("포스트요청!");
		String url = CheckURI.getLastURI(request.getRequestURL());
		HttpSession session = request.getSession();
		
		if(url.equals("file_name")){
			System.out.println("이름변경");
			modifyFileName(request, response);
		}
		else if(url.equals("file_path")){
			System.out.println("경로변경");
			modifyFilePath(request, response);
		}
		else if(url.equals("file_delete")){
			System.out.println("파일삭제");
			deleteFile(request, response);
		}
		else if(url.equals("file_copy")){
			System.out.println("파일복붙");
			copyPasteFile(request, response);
		}
		else if(url.equals("file_search")){
			System.out.println("파일검색");
			searchFile(request, response);
		}
		else if(url.equals("file_info")){	
			System.out.println("파일상세");
			loadFileInfo(request, response);
		}
		else if(url.equals("file_access")){
			System.out.println("권한변경");
			modifyAccessAuth(request, response);
		}
		else if(url.equals("file_folder")){
			System.out.println("폴더파일");
			loadFileList(request, response);
		}
	}
	
	/**
	 * 파일명 수정 시 호출되는 메소드로 비동기로 결과를 알려준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifyFileName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// 세션 데이터 및 UI 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
		String newName = (String)request.getParameter("newName");
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 사용자가 파일명 수정을 요청한 파일목록의 인덱스
		int index = Integer.parseInt(request.getParameter("index"));
		
		// 인덱스에 해당하는 파일의 코드
		String str = file_table.get(index); 
		
		// 이름수정 매니저 인스턴스
		FileNameModifiable searchManager = new FileManager();
		String result = searchManager.modifyFileName(memberCode, str, newName); 
		if(result.equals("성공")){
			// DB에서 얻어온 결과를 응답으로 날려줌
			jobj.put("result", "수정 완료");
			jobj.put("newName", newName);
		}
		else if(result.equals("권한")){
			jobj.put("result", "권한");
		}
		else if(result.equals("이름중복")){
			jobj.put("result", "이름중복");
		}
		else{
			jobj.put("result", "수정 실패");
		}
		response.getWriter().print(jobj);
	}
	/**
	 * 파일 이동 시 호출되는 메소드로 비동기로 결과를 알려준다
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifyFilePath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();

		// 세션 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 사용자가 파일 경로수정을 요청한 파일목록의 인덱스
		int index = Integer.parseInt(request.getParameter("index"));
		
		// 인덱스에 해당하는 파일의 키값
		String str = file_table.get(index);  
		
		// 이동할 파일의 새로운 폴더코드
		String newFolderCode = request.getParameter("folderCode"); 
		
		// 이동 매니저 인스턴스
		FilePathModifiable pathManager = new FileManager();
		String result = pathManager.modifyFilePath(memberCode, str, newFolderCode);
		if(result.equals("성공")){
			// DB에서 얻어온 결과를 응답으로 날려줌
			jobj.put("result", "이동 완료");
			file_table.remove(str);
		}
		else if(result.equals("중복")){
			jobj.put("result", "중복");
		}
		else if(result.equals("실패")){
			jobj.put("result", "이동 실패");
		}
		else if(result.equals("루트")){
			jobj.put("result", "루트");
		}
		else{
			jobj.put("result", "권한");
		}
		
		// 파일목록에서 삭제된 파일은 jsp 내부 함수로 row를 삭제할 것
		response.getWriter().print(jobj);
	}
	/**
	 * 파일 삭제시 호출되는 메소드로 비동기로 결과를 알려주고 사용자의 사용 용량을 최신화 시켜준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// 세션 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
				
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
				
		// 사용자가 파일 권한수정을 요청한 파일목록의 인덱스
		int index = Integer.parseInt(request.getParameter("index"));
		// 인덱스에 해당하는 파일의 키값
		String str = file_table.get(index);  
				
		// 삭제 매니저 인스턴스
		FileDelable deleteManager = new FileManager();
		String result = deleteManager.deleteFile(memberCode, str);
		if(result.equals("성공")){
			// DB에서 얻어온 결과를 응답으로 날려줌
			jobj.put("result", "삭제 완료");
			file_table.remove(str);
		}
		else if(result.equals("실패")){
			jobj.put("result", "삭제 실패");
		}
		else{
			jobj.put("result", "권한");
		}
		
		// 파일을 삭제하고 최신화 된 개인용량
		loadCapacity(request);
		String maxCapacity = (String)request.getAttribute("maxCapacity");
		String usedCapacity = (String)request.getAttribute("usedCapacity");
		float maxC = (float)request.getAttribute("maxC");
		float usedC = (float)request.getAttribute("usedC");
		jobj.put("maxCapacity", maxCapacity);
		jobj.put("usedCapacity", usedCapacity);
		jobj.put("maxC", maxC);
		jobj.put("usedC", usedC);
		
		// 파일목록에서 삭제된 파일은 jsp 내부 함수로 row를 삭제할 것
		response.getWriter().print(jobj);
	}
	/**
	 * 파일 복붙 시 호출되는 메소드로 비동기로 결과를 알려주고 사용자의 사용 용량을 최신화 시켜준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void copyPasteFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();

		// 세션 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 사용자가 파일 경로수정을 요청한 파일목록의 인덱스
		int index = Integer.parseInt(request.getParameter("index"));
		
		// 인덱스에 해당하는 파일의 키값
		String str = file_table.get(index);  
		
		// 복사할 파일의 붙여넣기 할 폴더코드
		String newFolderCode = request.getParameter("folderCode"); 

		// 복사붙여넣기 매니저 인스턴스
		FileCopyPastable copyManager = new FileManager();
		String result = copyManager.copyPasteFile(memberCode, str, newFolderCode);
		if(result.equals("성공")){
			// DB에서 얻어온 결과를 응답으로 날려줌
			jobj.put("result", "복사 완료");
			file_table.remove(str);
		}
		else if(result.equals("중복")){
			jobj.put("result", "중복");
		}
		else if(result.equals("실패")){
			jobj.put("result", "이동 실패");
		}
		else if(result.equals("루트")){
			jobj.put("result", "루트");
		}
		else{
			jobj.put("result", "권한");
		}

		// 파일을 복사하고 최신화 된 개인용량
		loadCapacity(request);
		String maxCapacity = (String)request.getAttribute("maxCapacity");
		String usedCapacity = (String)request.getAttribute("usedCapacity");
		float maxC = (float)request.getAttribute("maxC");
		float usedC = (float)request.getAttribute("usedC");
		jobj.put("maxCapacity", maxCapacity);
		jobj.put("usedCapacity", usedCapacity);
		jobj.put("maxC", maxC);
		jobj.put("usedC", usedC);
		
		response.getWriter().print(jobj);
	}
	/**
	 * 파일 검색 시 호출되는 메소드로 사용자의 파일목록에 파일 검색결과를 비동기로 처리해줌
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// 세션 데이터 및 UI 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
		String search_scope = request.getParameter("search_scope");
		String search_name = request.getParameter("search_name");
		String search_type = request.getParameter("search_type");
		String search_text = request.getParameter("search_text");
		
		// DB에서 찾아온 데이터
		ArrayList<File> temp = null;

		// 페이지에 뿌려줄 데이터
		ArrayList<String> list = new ArrayList<String>();  // 파일명 넣는 곳
		ArrayList<String> list2 = new ArrayList<String>();  // 파일유형 넣는 곳
		ArrayList<String> list3 = new ArrayList<String>();  // 수정시간 넣는 곳
		ArrayList<String> file_table = new ArrayList<String>();  // 파일목록 파일코드

		// 검색 매니저 인스턴스
		FileSearchable searchManager = new FileManager();
		
		// 수정 시간 포멧
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");
		
		if(search_scope.equals("내 파일")){
			if(search_type.equals("allFile")){
				if(search_text.equals("")){
					System.out.println("내꺼/널/올타입");
					temp = searchManager.searchFile(memberCode);
				}
				else{
					System.out.println("내꺼/파일명/올타입");
					temp = searchManager.searchMyFileName(memberCode, search_text);
				}
			} 
			else{
				System.out.println("내꺼/파일명/해당타입");
				temp = searchManager.searchMyFileNameType(memberCode, search_text, search_type);
			}
		}
		else{ // 모든파일
			if(search_name.equals("fileName"))
			{
				if(search_type.equals("allFile")){
					// 내가 접근 가능한 친구들의 모든 파일
					temp = searchManager.searchFileName(memberCode, search_text);
					for(File tempfile : temp){
						System.out.println("모든/널파일명/올타입/접근가능파일 : " + tempfile);
					}
					if(search_text.equals("")){
						// 내가 업로더인 모든 파일
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							System.out.println("모든/널파일명/올타입/내가 업로더인 파일 : " + temp3);
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아닌 파일
						ArrayList<File> temp3 = searchManager.searchSharedFile(memberCode);
						for(File temp4 : temp3){
							System.out.println("모든/널파일명/올타입/내 공유폴더 파일: " + temp4);
							temp.add(temp4);
						}
					}
					else{ 
						// 내가 업로더인 파일들 중 파일명이 포함되는 파일
						ArrayList<File> temp2 = searchManager.searchMyFileName(memberCode, search_text);
						 for(File temp3 : temp2){
							System.out.println("모든/파일명/올타입/내가 업로더인 파일 : " + temp3);
							 temp.add(temp3);
						 }
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 파일명이 포함되는 파일
						ArrayList<File> temp3 = searchManager.searchSharedFileName(memberCode, search_text);
						for(File temp4 : temp3){
							System.out.println("모든/파일명/올타입/내 공유폴더 파일: " + temp4);
							temp.add(temp4);
						}	 
					}
				}
				else{
					temp = searchManager.searchFileNameType(memberCode, search_text, search_type);
					ArrayList<File> temp2 = searchManager.searchMyFileNameType(memberCode, search_text, search_type);
					for(File temp3 : temp2){
						temp.add(temp3);
					}
					// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 파일명이 포함되며 파일 타입에 해당하는 파일
					ArrayList<File> temp3 = searchManager.searchSharedFileNameType(memberCode, search_text, search_type);
					for(File temp4 : temp3){
						temp.add(temp4);
					}	 
				}
			}
			else if(search_name.equals("uploaderName"))
			{
				MemberSearchable memSearchManager = new MemberManager();
				Member mtemp = memSearchManager.searchMemberCode(memberCode);
				String memberName = mtemp.getName();
				if(search_type.equals("allFile")){
					temp = searchManager.searchFileUploaderName(memberCode, search_text);
					if(search_text.equals("")){
						// 내가 업로더인 모든 파일
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아닌 파일
						ArrayList<File> temp3 = searchManager.searchSharedFile(memberCode);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberName)){
						// 내가 업로더인 모든 파일
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 업로더 이름이 포함되는 파일
						ArrayList<File> temp3 = searchManager.searchSharedUploaderName(memberCode, search_text);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else{
						// 내가 업로더인 모든 파일중 업로더 이름이 포함되는 파일
						ArrayList<File> temp2 = searchManager.searchMyFileUploaderName(memberCode, search_text);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 업로더 이름이 포함되는 파일
						ArrayList<File> temp3 = searchManager.searchSharedUploaderName(memberCode, search_text);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
				else{
					temp = searchManager.searchFileUploaderNameType(memberCode, search_text, search_type);
					if(search_text.equals("")){
						// 내가 업로더인 모든 파일 중 해당 타입의 파일
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 해당 파일명이 포함되며 해당 타입의 파일
						ArrayList<File> temp3 = searchManager.searchSharedFileType(memberCode, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberName)){
						// 내가 업로더인 모든 파일 중 해당 타입의 파일
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 해당 파일명이 포함되며 해당 타입의 파일
						ArrayList<File> temp3 = searchManager.searchSharedUploaderNameType(memberCode, search_text, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else{
						// 내가 업로더인 모든 파일중 업로더 이름이 포함되는 파일
						ArrayList<File> temp2 = searchManager.searchMyFileUploaderType(memberCode, search_text, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 업로더 이름이 포함되며 해당 타입의 파일
						ArrayList<File> temp3 = searchManager.searchSharedUploaderNameType(memberCode, search_text, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
			}
			else{
				// 검색 매니저 인스턴스
				MemberSearchable memSearchManager = new MemberManager();
				String uploaderCode = memSearchManager.searchMemberAdmin(search_text);
				String memberId = memSearchManager.searchMemberCode(memberCode).getId();
				if(search_type.equals("allFile")){
					temp = searchManager.searchFileUploaderId(memberCode, uploaderCode);
					if(search_text.equals("")){
						// 내가 업로더인 모든 파일
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아닌 파일
						ArrayList<File> temp3 = searchManager.searchSharedFile(memberCode);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberId)){
						// 내가 업로더인 모든 파일
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
					}
					else{
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 업로더 아이디가 일치하는 파일
						ArrayList<File> temp3 = searchManager.searchSharedUploaderId(memberCode, search_text);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
				else{
					temp = searchManager.searchFileUploaderIdType(memberCode, uploaderCode, search_type);
					if(search_text.equals("")){
						// 내가 업로더인 모든 파일 중 해당 타입의 파일
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 해당 파일명이 포함되며 해당 타입의 파일
						ArrayList<File> temp3 = searchManager.searchSharedFileType(memberCode, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberId)){
						// 내가 업로더인 모든 파일 중 해당 타입의 파일
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
					}
					else{
						// 내가 호스트이거나 초대된 공유 폴더들의 모든 파일들 중 내가 업로더가 아니고 해당 타입의 파일
						ArrayList<File> temp3 = searchManager.searchSharedUploaderIdType(memberCode, search_text, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
			}
		}
		if(temp!=null){
			for(File temp2 : temp){
				if(!temp2.getFileName().equals("soloud_real_root_file_zzz")){
					list.add("&nbsp;" + temp2.getFileName());
					list2.add("&nbsp;" + temp2.getFileType());
					String date = format.format(temp2.getLastModifyDate().getTime());
					list3.add("&nbsp;" + date);
					file_table.add(temp2.getFileCode().trim());
				}
			}
		}		
		session.setAttribute("file_table", file_table);  // 검색된 파일의 파일코드
		
		jobj.put("size", list.size());  // 검색된 파일의 갯수
		jobj.put("fileName", list);  // 검색된 파일들의 파일명
		jobj.put("fileType", list2);  // 검색된 파일들의 유형
		jobj.put("time", list3);  // 검색된 파일들의 수정날짜
		
		response.getWriter().print(jobj);
	}
	/**
	 * 파일 접근권한 수정 시 호출되는 메소드로 결과를 비동기로 알려준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifyAccessAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();

		// 세션 데이터 및 UI 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
		String newAccessAuth = request.getParameter("newAccess");
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 사용자가 파일 권한수정을 요청한 파일목록의 인덱스
		int index = Integer.parseInt(request.getParameter("index"));
		
		// 인덱스에 해당하는 파일의 키값
		String str = file_table.get(index);  
		
		// 이름수정 매니저 인스턴스
		FileAccessAuthModifiable accessAuthManager = new FileManager();
		String result = accessAuthManager.modifyFileAccessAuth(memberCode, str, newAccessAuth);
		if(result.equals("성공")){
			// DB에서 얻어온 결과를 응답으로 날려줌
			jobj.put("result", "수정 완료");
		}
		else if(result.equals("실패")){
			jobj.put("result", "수정 실패");
		}
		else{
			jobj.put("result", "권한");
		}
		response.getWriter().print(jobj);
	}
	/**
	 * 상세보기 요청시 호출되는 메소드로 사용자에게 상세보기 데이터를 비동기로 알려준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loadFileInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// 세션 데이터 로드
		String memberCode = (String)session.getAttribute("memberCode");
				
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 사용자가 상세보기 요청한 파일목록의 인덱스
		int index = Integer.parseInt(request.getParameter("index"));
		
		// 인덱스에 해당하는 파일의 키값
		String str = file_table.get(index); 
		
		// 이름수정 매니저 인스턴스
		FileSearchable searchManager = new FileManager();
		File result = searchManager.searchFileCode(memberCode, str);
		
		// DB에서 얻어온 데이터를 응답으로 날려줌
		System.out.println(result.getFileCode());
		jobj.put("fileName", result.getFileName());
		jobj.put("type", result.getFileType());
		jobj.put("accessAuth", result.getFileCode());
		jobj.put("capacity", result.getFolderCode());
		jobj.put("uploaderName", result.getUploaderId());
		jobj.put("comment", result.getComment());
		response.getWriter().print(jobj);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	/**
	 * 사용자가 폴더를 선택할때 폴더 내부의 파일들을 파일목록에 로드하는 메소드로 비동기로 처리된다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loadFileList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// 현재 로그인 중인 회원의 아이디
		String member_id = (String)session.getAttribute("memberCode");
		
		// 사용자가 조회를 요청한 파일의 경로
		String folder_path = request.getParameter("folder_path");
		session.setAttribute("folderCode", folder_path);
		
		// 위의 두 키값에 해당하는 파일목록을 DB에서 가져옴
		ArrayList<String> list = new ArrayList<String>();  // 파일명 넣는 곳
		ArrayList<String> list2 = new ArrayList<String>();  // 파일유형 넣는 곳
		ArrayList<String> list3 = new ArrayList<String>();  // 수정시간 넣는 곳
		ArrayList<String> file_table = new ArrayList<String>();  // 파일목록 파일코드

		// 검색 매니저 인스턴스
		FileSearchable searchManager = new FileManager();
		
		// 수정 시간 포멧
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");

		// DB에서 찾아온 데이터
		ArrayList<File> temp = searchManager.searchFolderCode(member_id, folder_path);
		
		if(temp!=null){
			for(File temp2 : temp){
				if(!temp2.getFileName().equals("soloud_real_root_file_zzz")){
					list.add("&nbsp;" + temp2.getFileName());
					list2.add("&nbsp;" + temp2.getFileType());
					String date = format.format(temp2.getLastModifyDate().getTime());
					list3.add("&nbsp;" + date);
					file_table.add(temp2.getFilePath().trim());
				}
			}
		}		
		session.setAttribute("file_table", file_table);  // 검색된 파일의 파일코드
		
		jobj.put("size", list.size());  // 검색된 파일의 갯수
		jobj.put("fileName", list);  // 검색된 파일들의 파일명
		jobj.put("fileType", list2);  // 검색된 파일들의 유형
		jobj.put("time", list3);  // 검색된 파일들의 수정날짜
		
		response.getWriter().print(jobj);
	}
	/**
	 * 사용자의 사용 용량 및 제한용량을 얻어오는 메소드
	 * @param request
	 */
	private void loadCapacity(HttpServletRequest request){
		MemberSearchable ms = new MemberManager();
		System.out.println(request.getSession().getAttribute("memberCode"));
		
		Member m = ms.searchMemberCode((String) request.getSession().getAttribute("memberCode"));

		DecimalFormat df = new DecimalFormat("0.00");
		String max = null;
		String used = null;
		
		// 최대 용량 제한
		float capacity = m.getCapacityLimit();	
		request.setAttribute("maxC", capacity);
		if(capacity>1048575f){
			capacity = (float)(capacity/1024f/1024f);  // 메가바이트 단위
			capacity = Float.parseFloat(df.format(capacity));
			max = capacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // 킬로바이트 단위
			capacity = (float)(capacity/1024d);
			capacity = Float.parseFloat(df.format(capacity));
			max = capacity+"KB";
		}
		else{
			max = "1KB";
		}
		
		// 현재 사용량
		capacity = m.getUsedCapacity();	
		request.setAttribute("usedC", capacity);
		if(capacity>1048575f){
			capacity = (float)(capacity/1024f/1024f);  // 메가바이트 단위
			capacity = Float.parseFloat(df.format(capacity));
			used = capacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // 킬로바이트 단위
			capacity = (float)(capacity/1024d);
			capacity = Float.parseFloat(df.format(capacity));
			used = capacity+"KB";
		}
		else{
			used = "1KB";
		}
		
		request.setAttribute("maxCapacity", max);
		request.setAttribute("usedCapacity", used);
		System.out.println(max + "  " + used);
	}
}
