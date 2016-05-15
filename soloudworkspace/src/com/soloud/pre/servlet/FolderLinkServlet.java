package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.soloud.app.manInt.FileSearchable;
import com.soloud.app.model.File;
import com.soloud.util.ASEEnctypt;
import com.soloud.util.CheckURI;


/**
 * Servlet implementation class FolderLinkServlet
 */
@WebServlet({"/encFolderLink.do", "/decFolderLink.do/*"})
public class FolderLinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		System.out.println(action + "^^" + "post!!");
		
		if(action.equals("encFolderLink.do"))
		{
			String password = request.getParameter("password");
			String folderCode = request.getParameter("folderCode");
			encryptFolderCode(password, folderCode, response);
		}
		else if(action.endsWith("file_link"))
		{
			System.out.println("���������~!");
			System.out.println("��ũ�ɱ�");
			String password = (String) request.getParameter("password");
			
			//String linkFolderCode=(String) request.getSession().getAttribute("linkFolderCode");
			System.out.println(password);
			String decUrl=(String) request.getSession().getAttribute("linkFolderEncryptedCode");
			String realFolderCode=decryptFolderCode(decUrl, password);
			System.out.println("������ ã�ƾ��� ���� �ڵ� : " + realFolderCode);
			loadLinkInfo(request, response, realFolderCode);
		}
	}

	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		super.init();
		//ServletContext sc = getServletContext();
		//Hashtable<String, String> hashPassword = new Hashtable<String, String>();
	//	sc.setAttribute("HashPassword", hashPassword);
	}

	private void encryptFolderCode(String password, String folderCode, HttpServletResponse response) throws IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		String encryptedFolderCode = null;
		
		ASEEnctypt enc = new ASEEnctypt();
		try {
			encryptedFolderCode = enc.testASEEncodeWithKey(folderCode, password);
			
			//Hashtable<String, String> hashPassword = (Hashtable<String, String>) getServletContext().getAttribute("HashPassword");
		//	hashPassword.put(folderCode, password);
			
			json.put("result", true);
			json.put("encryptedFolderCode", encryptedFolderCode);
			System.out.println(encryptedFolderCode.toString() + "������� �ɴϴ�");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.print(json);
	}
	//private void decryptFolderCode(String )

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		String dispatchUrl=null;
		
		System.out.println(action + "^^" + "get!");
		if(action.startsWith("link"))
		{
			action = action.substring(4);
			System.out.println(action);
			
			String decUrl=null;
			decUrl=decryptFolderCode(action, "1234");
			System.out.println("������ ã�ƾ��� ���� �ڵ� : " + decUrl);
			request.getSession().setAttribute("linkFolderEncryptedCode", action);
			//request.setAttribute("linkFolderCode", decUrl);
			
			dispatchUrl="/jsp/folderLinkRoot.jsp";
			System.out.println("��������!?");
			RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
			view.forward(request, response);
			
			//Hashtable<String, String> hashPassword = (Hashtable<String, String>) getServletContext().getAttribute("HashPassword");
			//String realFolderCode = hashPassword.get(password);	//�н����带 ��ǲ���� �ָ� ���� �����ڵ尡 ����
			
			
			//�״��� �� �����ڵ�� ��û�� �����ڵ尡 ������ �˻��ؼ� ���ٸ� ������ �ѷ��� ����ġ!!
		}
	}
	
	public String decryptFolderCode(String encFolderCode, String password)
	{
		ASEEnctypt enc = new ASEEnctypt();

		String decUrl = null;
		try {
			decUrl = enc.testASEDecodeWithKey(encFolderCode, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decUrl;
	}
	
	private void loadLinkInfo(HttpServletRequest request, HttpServletResponse response, String realFolderCode) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		// ����ڰ� ��ȸ�� ��û�� ������ ���
		//String folder_path = request.getParameter("linkFolderCode");
		System.out.println("���� ���� " + realFolderCode + "�� ã���ս��ϴ�...");
		
		String folder_path = realFolderCode;
		session.setAttribute("folderCode", folder_path);
		
		// ���� �� Ű���� �ش��ϴ� ���ϸ���� DB���� ������
		ArrayList<String[]> list = new ArrayList<String[]>();  // ���ϸ� �ִ� ��
		ArrayList<String> file_table = new ArrayList<String>();  // ���ϸ�� �����ڵ�

		// �˻� �Ŵ��� �ν��Ͻ�
		FileSearchable searchManager = new FileManager();
		
		// ���� �ð� ����
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd a HH:mm");

		// DB���� ã�ƿ� ������
		ArrayList<File> temp = searchManager.searchFolderCode("", folder_path);
		
		if(temp!=null){
			for(File temp2 : temp){
				if(!temp2.getFileName().equals("soloud_real_root_file_zzz")){
					String date = format.format(temp2.getLastModifyDate().getTime());
					DecimalFormat df = new DecimalFormat("0.00");
					float capacity = temp2.getFileCapacity();
					String realCapacity = null;
					if(capacity>1048575f){
						capacity = (float)(capacity/1024f/1024f);  // �ް�����Ʈ ����
						capacity = Float.parseFloat(df.format(capacity));
						realCapacity = capacity+"MB";
					}
					else if(capacity>1023d && capacity<=1048575d){ // ų�ι���Ʈ ����
						capacity = (float)(capacity/1024d);
						capacity = Float.parseFloat(df.format(capacity));
						realCapacity = capacity+"KB";
					}
					else{
						realCapacity = "1KB";
					}
					String[] str = new String[]{"&nbsp;" + temp2.getFileName(), "&nbsp;" + temp2.getFileType(), "&nbsp;" + realCapacity, "&nbsp;" + date};
					list.add(str);
					file_table.add(temp2.getFilePath().trim());
				}
			}
		}		
		
		session.setAttribute("file_table", file_table);  // �˻��� ������ �����ڵ�
		
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("/jsp/folderLink.jsp");
		view.forward(request, response);
	}
	
}
