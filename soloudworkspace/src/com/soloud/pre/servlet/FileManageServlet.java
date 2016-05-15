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
 * ���� ���� ��û�� ����ϴ� ����
 * @author ����
 *
 */
@WebServlet(name="FileManageServlet", urlPatterns={"/file_name", "/file_path", "/file_delete", "/file_search", "/file_copy", "/file_info", "/file_access", "/file_folder"})
public class FileManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * ����ڰ� ��ũ �ɱ� ���� �̿� �� ������� URL�� Ŭ�������� �ش� ���Ϸ� �������� 
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
			//System.out.println("��ũ�ɱ�");
			//adLinkInfo(request, response);
		}
	}

	/**
	 * ��� ���� ���� ����� ��û�� �����ϴ� �޼ҵ�
	 * ���ϸ����, �����̵�, ���ϻ���, ���Ϻ���, ���ϰ˻�, �󼼺���, ���Ѻ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("����Ʈ��û!");
		String url = CheckURI.getLastURI(request.getRequestURL());
		HttpSession session = request.getSession();
		
		if(url.equals("file_name")){
			System.out.println("�̸�����");
			modifyFileName(request, response);
		}
		else if(url.equals("file_path")){
			System.out.println("��κ���");
			modifyFilePath(request, response);
		}
		else if(url.equals("file_delete")){
			System.out.println("���ϻ���");
			deleteFile(request, response);
		}
		else if(url.equals("file_copy")){
			System.out.println("���Ϻ���");
			copyPasteFile(request, response);
		}
		else if(url.equals("file_search")){
			System.out.println("���ϰ˻�");
			searchFile(request, response);
		}
		else if(url.equals("file_info")){	
			System.out.println("���ϻ�");
			loadFileInfo(request, response);
		}
		else if(url.equals("file_access")){
			System.out.println("���Ѻ���");
			modifyAccessAuth(request, response);
		}
		else if(url.equals("file_folder")){
			System.out.println("��������");
			loadFileList(request, response);
		}
	}
	
	/**
	 * ���ϸ� ���� �� ȣ��Ǵ� �޼ҵ�� �񵿱�� ����� �˷��ش�.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifyFileName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// ���� ������ �� UI ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
		String newName = (String)request.getParameter("newName");
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ����ڰ� ���ϸ� ������ ��û�� ���ϸ���� �ε���
		int index = Integer.parseInt(request.getParameter("index"));
		
		// �ε����� �ش��ϴ� ������ �ڵ�
		String str = file_table.get(index); 
		
		// �̸����� �Ŵ��� �ν��Ͻ�
		FileNameModifiable searchManager = new FileManager();
		String result = searchManager.modifyFileName(memberCode, str, newName); 
		if(result.equals("����")){
			// DB���� ���� ����� �������� ������
			jobj.put("result", "���� �Ϸ�");
			jobj.put("newName", newName);
		}
		else if(result.equals("����")){
			jobj.put("result", "����");
		}
		else if(result.equals("�̸��ߺ�")){
			jobj.put("result", "�̸��ߺ�");
		}
		else{
			jobj.put("result", "���� ����");
		}
		response.getWriter().print(jobj);
	}
	/**
	 * ���� �̵� �� ȣ��Ǵ� �޼ҵ�� �񵿱�� ����� �˷��ش�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifyFilePath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();

		// ���� ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ����ڰ� ���� ��μ����� ��û�� ���ϸ���� �ε���
		int index = Integer.parseInt(request.getParameter("index"));
		
		// �ε����� �ش��ϴ� ������ Ű��
		String str = file_table.get(index);  
		
		// �̵��� ������ ���ο� �����ڵ�
		String newFolderCode = request.getParameter("folderCode"); 
		
		// �̵� �Ŵ��� �ν��Ͻ�
		FilePathModifiable pathManager = new FileManager();
		String result = pathManager.modifyFilePath(memberCode, str, newFolderCode);
		if(result.equals("����")){
			// DB���� ���� ����� �������� ������
			jobj.put("result", "�̵� �Ϸ�");
			file_table.remove(str);
		}
		else if(result.equals("�ߺ�")){
			jobj.put("result", "�ߺ�");
		}
		else if(result.equals("����")){
			jobj.put("result", "�̵� ����");
		}
		else if(result.equals("��Ʈ")){
			jobj.put("result", "��Ʈ");
		}
		else{
			jobj.put("result", "����");
		}
		
		// ���ϸ�Ͽ��� ������ ������ jsp ���� �Լ��� row�� ������ ��
		response.getWriter().print(jobj);
	}
	/**
	 * ���� ������ ȣ��Ǵ� �޼ҵ�� �񵿱�� ����� �˷��ְ� ������� ��� �뷮�� �ֽ�ȭ �����ش�.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// ���� ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
				
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
				
		// ����ڰ� ���� ���Ѽ����� ��û�� ���ϸ���� �ε���
		int index = Integer.parseInt(request.getParameter("index"));
		// �ε����� �ش��ϴ� ������ Ű��
		String str = file_table.get(index);  
				
		// ���� �Ŵ��� �ν��Ͻ�
		FileDelable deleteManager = new FileManager();
		String result = deleteManager.deleteFile(memberCode, str);
		if(result.equals("����")){
			// DB���� ���� ����� �������� ������
			jobj.put("result", "���� �Ϸ�");
			file_table.remove(str);
		}
		else if(result.equals("����")){
			jobj.put("result", "���� ����");
		}
		else{
			jobj.put("result", "����");
		}
		
		// ������ �����ϰ� �ֽ�ȭ �� ���ο뷮
		loadCapacity(request);
		String maxCapacity = (String)request.getAttribute("maxCapacity");
		String usedCapacity = (String)request.getAttribute("usedCapacity");
		float maxC = (float)request.getAttribute("maxC");
		float usedC = (float)request.getAttribute("usedC");
		jobj.put("maxCapacity", maxCapacity);
		jobj.put("usedCapacity", usedCapacity);
		jobj.put("maxC", maxC);
		jobj.put("usedC", usedC);
		
		// ���ϸ�Ͽ��� ������ ������ jsp ���� �Լ��� row�� ������ ��
		response.getWriter().print(jobj);
	}
	/**
	 * ���� ���� �� ȣ��Ǵ� �޼ҵ�� �񵿱�� ����� �˷��ְ� ������� ��� �뷮�� �ֽ�ȭ �����ش�.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void copyPasteFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();

		// ���� ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ����ڰ� ���� ��μ����� ��û�� ���ϸ���� �ε���
		int index = Integer.parseInt(request.getParameter("index"));
		
		// �ε����� �ش��ϴ� ������ Ű��
		String str = file_table.get(index);  
		
		// ������ ������ �ٿ��ֱ� �� �����ڵ�
		String newFolderCode = request.getParameter("folderCode"); 

		// ����ٿ��ֱ� �Ŵ��� �ν��Ͻ�
		FileCopyPastable copyManager = new FileManager();
		String result = copyManager.copyPasteFile(memberCode, str, newFolderCode);
		if(result.equals("����")){
			// DB���� ���� ����� �������� ������
			jobj.put("result", "���� �Ϸ�");
			file_table.remove(str);
		}
		else if(result.equals("�ߺ�")){
			jobj.put("result", "�ߺ�");
		}
		else if(result.equals("����")){
			jobj.put("result", "�̵� ����");
		}
		else if(result.equals("��Ʈ")){
			jobj.put("result", "��Ʈ");
		}
		else{
			jobj.put("result", "����");
		}

		// ������ �����ϰ� �ֽ�ȭ �� ���ο뷮
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
	 * ���� �˻� �� ȣ��Ǵ� �޼ҵ�� ������� ���ϸ�Ͽ� ���� �˻������ �񵿱�� ó������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// ���� ������ �� UI ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
		String search_scope = request.getParameter("search_scope");
		String search_name = request.getParameter("search_name");
		String search_type = request.getParameter("search_type");
		String search_text = request.getParameter("search_text");
		
		// DB���� ã�ƿ� ������
		ArrayList<File> temp = null;

		// �������� �ѷ��� ������
		ArrayList<String> list = new ArrayList<String>();  // ���ϸ� �ִ� ��
		ArrayList<String> list2 = new ArrayList<String>();  // �������� �ִ� ��
		ArrayList<String> list3 = new ArrayList<String>();  // �����ð� �ִ� ��
		ArrayList<String> file_table = new ArrayList<String>();  // ���ϸ�� �����ڵ�

		// �˻� �Ŵ��� �ν��Ͻ�
		FileSearchable searchManager = new FileManager();
		
		// ���� �ð� ����
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");
		
		if(search_scope.equals("�� ����")){
			if(search_type.equals("allFile")){
				if(search_text.equals("")){
					System.out.println("����/��/��Ÿ��");
					temp = searchManager.searchFile(memberCode);
				}
				else{
					System.out.println("����/���ϸ�/��Ÿ��");
					temp = searchManager.searchMyFileName(memberCode, search_text);
				}
			} 
			else{
				System.out.println("����/���ϸ�/�ش�Ÿ��");
				temp = searchManager.searchMyFileNameType(memberCode, search_text, search_type);
			}
		}
		else{ // �������
			if(search_name.equals("fileName"))
			{
				if(search_type.equals("allFile")){
					// ���� ���� ������ ģ������ ��� ����
					temp = searchManager.searchFileName(memberCode, search_text);
					for(File tempfile : temp){
						System.out.println("���/�����ϸ�/��Ÿ��/���ٰ������� : " + tempfile);
					}
					if(search_text.equals("")){
						// ���� ���δ��� ��� ����
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							System.out.println("���/�����ϸ�/��Ÿ��/���� ���δ��� ���� : " + temp3);
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedFile(memberCode);
						for(File temp4 : temp3){
							System.out.println("���/�����ϸ�/��Ÿ��/�� �������� ����: " + temp4);
							temp.add(temp4);
						}
					}
					else{ 
						// ���� ���δ��� ���ϵ� �� ���ϸ��� ���ԵǴ� ����
						ArrayList<File> temp2 = searchManager.searchMyFileName(memberCode, search_text);
						 for(File temp3 : temp2){
							System.out.println("���/���ϸ�/��Ÿ��/���� ���δ��� ���� : " + temp3);
							 temp.add(temp3);
						 }
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� ���ϸ��� ���ԵǴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedFileName(memberCode, search_text);
						for(File temp4 : temp3){
							System.out.println("���/���ϸ�/��Ÿ��/�� �������� ����: " + temp4);
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
					// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� ���ϸ��� ���ԵǸ� ���� Ÿ�Կ� �ش��ϴ� ����
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
						// ���� ���δ��� ��� ����
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedFile(memberCode);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberName)){
						// ���� ���δ��� ��� ����
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� ���δ� �̸��� ���ԵǴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedUploaderName(memberCode, search_text);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else{
						// ���� ���δ��� ��� ������ ���δ� �̸��� ���ԵǴ� ����
						ArrayList<File> temp2 = searchManager.searchMyFileUploaderName(memberCode, search_text);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� ���δ� �̸��� ���ԵǴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedUploaderName(memberCode, search_text);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
				else{
					temp = searchManager.searchFileUploaderNameType(memberCode, search_text, search_type);
					if(search_text.equals("")){
						// ���� ���δ��� ��� ���� �� �ش� Ÿ���� ����
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� ���ϸ��� ���ԵǸ� �ش� Ÿ���� ����
						ArrayList<File> temp3 = searchManager.searchSharedFileType(memberCode, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberName)){
						// ���� ���δ��� ��� ���� �� �ش� Ÿ���� ����
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� ���ϸ��� ���ԵǸ� �ش� Ÿ���� ����
						ArrayList<File> temp3 = searchManager.searchSharedUploaderNameType(memberCode, search_text, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else{
						// ���� ���δ��� ��� ������ ���δ� �̸��� ���ԵǴ� ����
						ArrayList<File> temp2 = searchManager.searchMyFileUploaderType(memberCode, search_text, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� ���δ� �̸��� ���ԵǸ� �ش� Ÿ���� ����
						ArrayList<File> temp3 = searchManager.searchSharedUploaderNameType(memberCode, search_text, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
			}
			else{
				// �˻� �Ŵ��� �ν��Ͻ�
				MemberSearchable memSearchManager = new MemberManager();
				String uploaderCode = memSearchManager.searchMemberAdmin(search_text);
				String memberId = memSearchManager.searchMemberCode(memberCode).getId();
				if(search_type.equals("allFile")){
					temp = searchManager.searchFileUploaderId(memberCode, uploaderCode);
					if(search_text.equals("")){
						// ���� ���δ��� ��� ����
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedFile(memberCode);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberId)){
						// ���� ���δ��� ��� ����
						ArrayList<File> temp2 = searchManager.searchFile(memberCode);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
					}
					else{
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� ���δ� ���̵� ��ġ�ϴ� ����
						ArrayList<File> temp3 = searchManager.searchSharedUploaderId(memberCode, search_text);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
				}
				else{
					temp = searchManager.searchFileUploaderIdType(memberCode, uploaderCode, search_type);
					if(search_text.equals("")){
						// ���� ���δ��� ��� ���� �� �ش� Ÿ���� ����
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� ���ϸ��� ���ԵǸ� �ش� Ÿ���� ����
						ArrayList<File> temp3 = searchManager.searchSharedFileType(memberCode, search_type);
						for(File temp4 : temp3){
							temp.add(temp4);
						}
					}
					else if(search_text.equals(memberId)){
						// ���� ���δ��� ��� ���� �� �ش� Ÿ���� ����
						ArrayList<File> temp2 = searchManager.searchMyFileType(memberCode, search_type);
						for(File temp3 : temp2){
							temp.add(temp3);
						}
					}
					else{
						// ���� ȣ��Ʈ�̰ų� �ʴ�� ���� �������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� Ÿ���� ����
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
		session.setAttribute("file_table", file_table);  // �˻��� ������ �����ڵ�
		
		jobj.put("size", list.size());  // �˻��� ������ ����
		jobj.put("fileName", list);  // �˻��� ���ϵ��� ���ϸ�
		jobj.put("fileType", list2);  // �˻��� ���ϵ��� ����
		jobj.put("time", list3);  // �˻��� ���ϵ��� ������¥
		
		response.getWriter().print(jobj);
	}
	/**
	 * ���� ���ٱ��� ���� �� ȣ��Ǵ� �޼ҵ�� ����� �񵿱�� �˷��ش�.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modifyAccessAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();

		// ���� ������ �� UI ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
		String newAccessAuth = request.getParameter("newAccess");
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ����ڰ� ���� ���Ѽ����� ��û�� ���ϸ���� �ε���
		int index = Integer.parseInt(request.getParameter("index"));
		
		// �ε����� �ش��ϴ� ������ Ű��
		String str = file_table.get(index);  
		
		// �̸����� �Ŵ��� �ν��Ͻ�
		FileAccessAuthModifiable accessAuthManager = new FileManager();
		String result = accessAuthManager.modifyFileAccessAuth(memberCode, str, newAccessAuth);
		if(result.equals("����")){
			// DB���� ���� ����� �������� ������
			jobj.put("result", "���� �Ϸ�");
		}
		else if(result.equals("����")){
			jobj.put("result", "���� ����");
		}
		else{
			jobj.put("result", "����");
		}
		response.getWriter().print(jobj);
	}
	/**
	 * �󼼺��� ��û�� ȣ��Ǵ� �޼ҵ�� ����ڿ��� �󼼺��� �����͸� �񵿱�� �˷��ش�.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loadFileInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// ���� ������ �ε�
		String memberCode = (String)session.getAttribute("memberCode");
				
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ����ڰ� �󼼺��� ��û�� ���ϸ���� �ε���
		int index = Integer.parseInt(request.getParameter("index"));
		
		// �ε����� �ش��ϴ� ������ Ű��
		String str = file_table.get(index); 
		
		// �̸����� �Ŵ��� �ν��Ͻ�
		FileSearchable searchManager = new FileManager();
		File result = searchManager.searchFileCode(memberCode, str);
		
		// DB���� ���� �����͸� �������� ������
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
	 * ����ڰ� ������ �����Ҷ� ���� ������ ���ϵ��� ���ϸ�Ͽ� �ε��ϴ� �޼ҵ�� �񵿱�� ó���ȴ�.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loadFileList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jobj = new JSONObject();
		HttpSession session = request.getSession();
		
		// ���� �α��� ���� ȸ���� ���̵�
		String member_id = (String)session.getAttribute("memberCode");
		
		// ����ڰ� ��ȸ�� ��û�� ������ ���
		String folder_path = request.getParameter("folder_path");
		session.setAttribute("folderCode", folder_path);
		
		// ���� �� Ű���� �ش��ϴ� ���ϸ���� DB���� ������
		ArrayList<String> list = new ArrayList<String>();  // ���ϸ� �ִ� ��
		ArrayList<String> list2 = new ArrayList<String>();  // �������� �ִ� ��
		ArrayList<String> list3 = new ArrayList<String>();  // �����ð� �ִ� ��
		ArrayList<String> file_table = new ArrayList<String>();  // ���ϸ�� �����ڵ�

		// �˻� �Ŵ��� �ν��Ͻ�
		FileSearchable searchManager = new FileManager();
		
		// ���� �ð� ����
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");

		// DB���� ã�ƿ� ������
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
		session.setAttribute("file_table", file_table);  // �˻��� ������ �����ڵ�
		
		jobj.put("size", list.size());  // �˻��� ������ ����
		jobj.put("fileName", list);  // �˻��� ���ϵ��� ���ϸ�
		jobj.put("fileType", list2);  // �˻��� ���ϵ��� ����
		jobj.put("time", list3);  // �˻��� ���ϵ��� ������¥
		
		response.getWriter().print(jobj);
	}
	/**
	 * ������� ��� �뷮 �� ���ѿ뷮�� ������ �޼ҵ�
	 * @param request
	 */
	private void loadCapacity(HttpServletRequest request){
		MemberSearchable ms = new MemberManager();
		System.out.println(request.getSession().getAttribute("memberCode"));
		
		Member m = ms.searchMemberCode((String) request.getSession().getAttribute("memberCode"));

		DecimalFormat df = new DecimalFormat("0.00");
		String max = null;
		String used = null;
		
		// �ִ� �뷮 ����
		float capacity = m.getCapacityLimit();	
		request.setAttribute("maxC", capacity);
		if(capacity>1048575f){
			capacity = (float)(capacity/1024f/1024f);  // �ް�����Ʈ ����
			capacity = Float.parseFloat(df.format(capacity));
			max = capacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // ų�ι���Ʈ ����
			capacity = (float)(capacity/1024d);
			capacity = Float.parseFloat(df.format(capacity));
			max = capacity+"KB";
		}
		else{
			max = "1KB";
		}
		
		// ���� ��뷮
		capacity = m.getUsedCapacity();	
		request.setAttribute("usedC", capacity);
		if(capacity>1048575f){
			capacity = (float)(capacity/1024f/1024f);  // �ް�����Ʈ ����
			capacity = Float.parseFloat(df.format(capacity));
			used = capacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // ų�ι���Ʈ ����
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
