package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.soloud.app.man.FolderManager;
import com.soloud.app.man.MemberManager;
import com.soloud.app.man.SharedFolderManager;
import com.soloud.app.manInt.FolderCreateable;
import com.soloud.app.manInt.FolderDelable;
import com.soloud.app.manInt.FolderNameModifiable;
import com.soloud.app.manInt.FolderPathModifiable;
import com.soloud.app.manInt.FolderSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.manInt.SharedFolderCreatable;
import com.soloud.app.manInt.SharedFolderSearchable;
import com.soloud.app.model.Folder;
import com.soloud.app.model.Member;
import com.soloud.app.model.SharedFolder;
import com.soloud.per.dto.SharedFriendVDTO;
import com.soloud.pre.uiform.FolderManageForm;
import com.soloud.pre.validator.FolderManageValidator;
import com.soloud.util.CheckURI;
import com.soloud.util.MakeTree;

/**
 * Servlet implementation class FolderManagerServlet
 */
@WebServlet({"/makeFolder.do", "/deleteFolder.do", "/modifyFolder.do", "/dynamicTree3.do/*", "/moveFolder.do", "/dynamicTree4.do/*"})
public class FolderManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String url = CheckURI.getLastURI(request.getRequestURL());
		System.out.println(url);
		if(url.equals("makeFolder.do"))
		{
		//	System.out.println("����^^");
			addFolder(request, response);
		}
		else if(url.equals("deleteFolder.do"))
		{
			
			deleteFolder(request, response);
		}
		else if(url.equals("modifyFolder.do"))
		{
			modifyFolderName(request, response);
		}
		//Ư�� �����ڵ带 ���� ���̼� ������ ����������...
		else if(url.startsWith("fo"))
		{
			loadTree(request, response, url);
			return;
		}
		else if(url.startsWith("sfo"))
		{
			loadTree2(request, response, url);
			return;
		}
		else if(url.equals("moveFolder.do"))
		{
			modifyFolderPath(request, response);
			return;
		}
	}
	


	/**
	 * ������ �߰��� �� ȣ�� �Ǵ� �޼ҵ�� �񵿱�ó���� ����� �˷���
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addFolder(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		JSONObject json = new JSONObject();
		FolderSearchable fc = new FolderManager();
		
		String folderName = request.getParameter("foldName");
		String parentFolderCode = request.getParameter("parentFolderCode");
		String isSharedFolder = request.getParameter("isSharedFolder");
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		
		FolderManageValidator valid= new FolderManageValidator();
		FolderManageForm form = new FolderManageForm();
		form.setFolderName(folderName);
		
		
		//��ȿ�� �˻�κ�
		valid.validateAdd(form);
		List<String> errorList = valid.getErrors();
		
		

		//�ش� �θ� ���������� �̹� ���� �̸��� ������ �����ϴ��� �˻��ϴ� �κ�
		List<Folder> tList = fc.searchFolderIdParent(memberCode, parentFolderCode);
		for(Folder folder : tList)
		{
			if(folder.getFolderName().equals(folderName))
			{
				errorList.add("���� �̸��� �ߺ��˴ϴ�. �ٸ� �̸��� �Է����ּ���");
				System.out.println("�ߺ���^^");
			}
		}
		
		
		if(errorList.size()==0)
		{
			boolean res=false;
			//�߰��Ϸ��� ������ ���� ȣ��Ʈ�� �������� �˻��ϴ� �κ�
			Folder fff = fc.searchFolder_REAL3(parentFolderCode);
			String memberCode2 = fff.getFolderPath(); 	//����� �˻��� ������ ������ ����ڵ���
		//	String parentFolderCode2 = fff.getParentFolderCode();
			System.out.println("������ ���� ������ ����ڵ� : " + memberCode2);
			System.out.println("������ ������ �ڵ� : " + parentFolderCode);
			FolderSearchable fs = (FolderSearchable)fc;
			List<Folder> folderList = null;
			
			
			if(!memberCode2.equals(memberCode))		//���� �߰��Ϸ��� ������ ���� �������� ������ �ƴ϶�� ����ڵ带 ȣ��Ʈ���ؼ� ������ �߰��ؾߵ�
			{
				//�� ���������� ���� ȣ��Ʈ�̸����� �߰��ؾߵ�
				res = ((FolderCreateable) fc).createFolder_REAL(memberCode2, folderName, parentFolderCode, isSharedFolder);
				if(res)
				{
					folderList = fs.searchFolder(memberCode2);
				}
				//���࿡ �����ϸ�..
				else
				{
					System.out.println("�ý��ۻ��� ������ �����߾��~ ����� �ٽ� �õ����ּ���~");
				}
			}
			else
			{
				//�Ϲ������� ���� ���̸����� ������ �߰���
				res = ((FolderCreateable) fc).createFolder_REAL(memberCode, folderName, parentFolderCode, isSharedFolder);
				if(res)
				{
					folderList = fs.searchFolder(memberCode);
				}
				//���࿡ �����ϸ�..
				else
				{
					System.out.println("�ý��ۻ��� ������ �����߾��~ ����� �ٽ� �õ����ּ���~");
				}
				
			}
			
			
			List<Integer> folderCodeList = new ArrayList<Integer>();
			
			for(Folder f : folderList)
			{
				folderCodeList.add(Integer.parseInt(f.getFolderCode().trim().substring(2)));
			}
			
			Object[] t = folderCodeList.toArray();
			
			Arrays.sort(t);
		
			
			//���� �Ӽ��� �� ������� ��� �߰��� ���������ؼ�  
			//�θ������� ���ٰ��� ģ����� �Ӽ��� �״�� ����������
			if(isSharedFolder.trim().equals("����"))
			{
				addAFF(parentFolderCode, "fo" + t[t.length-1]);	//parentFolderCode�� ���ٰ��� ģ����ϼӼ���  
																//folderCode�� �ش��ϴ� sharedFolderCode�� ���� ģ����� �Ӽ���
																//�״�� �߰����־�� �Ѵ�.
			}
			
			json.put("result", true);
			json.put("nextCode", "fo" + t[t.length-1]);
			response.getWriter().print(json);
			
			System.out.println("�����߻�");
		
	
			
		}
		//�̸� ��ȿ�� �ɸ�
		else
		{
			json.put("result", false);
			json.put("resultMsg", errorList);
			response.getWriter().print(json);

		}
		
	}
	
	private void addAFF(String parentFolderCode, String folderCode) 
	{
		// TODO Auto-generated method stub
		FolderSearchable fs = new FolderManager();
		SharedFolderSearchable sfs = new SharedFolderManager();
		
		//�߰��Ϸ��� ������ ���ٰ��� ģ����� �ڵ带 ������
		Folder f = fs.searchFolder_REAL3(parentFolderCode);		//�ϴ� �� ������ ������ ������
		SharedFolder sf = sfs.searchSharedFolderCode(f.getFolderCode());	//�� ������ ���� ���� �ڵ带 ������
		String sfCode = sf.getSharedFolderCode().trim();							
		
		List<SharedFriendVDTO> dtoList = sfs.searchShareFriend(sfCode);	//�θ� �����ڵ忡 ���ؼ� ���� ������ ������ �ڵ带 �ٰ�����
		List<String> friendCodeList = new ArrayList<String>();
		
		//���� ���� ģ�� �ڵ� �ٰ�����
		for(SharedFriendVDTO dto : dtoList)
		{
			friendCodeList.add(dto.getFriendCode());
		}
		
		//�� ģ���ڵ带 ���� ���� �����ڵ��� ���������ڵ忡 ���ؼ� �߰�����
		
		//�ϴ� ���θ��� �����ڵ�� ���������ڵ带 ã�ƿ�
		String sf2 = sfs.searchSharedFolderCode(folderCode).getSharedFolderCode().trim();
		
		
		//�� ���������ڵ忡 ���ٰ��� ģ���� �߰�����
		SharedFolderCreatable sfc = new SharedFolderManager();
		boolean res = false;
		int successCount=0;
		int falseCount=0;
		for(String frCode : friendCodeList)
		{
			res = sfc.createSharedFolderAuthFriend(frCode, sf2);
			if(res)
			{
				successCount++;
			}
			else
			{
				falseCount++;
			}
		}
		
		System.out.println("��ǲ ���� ���� : " + successCount);
		System.out.println("��ǲ ���� ���� : " + falseCount);
		
		
		
	}

	/**
	 * �������� ������ �� ȣ�� �Ǵ� �޼ҵ�� �񵿱�ó���� ����� �˷���
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void modifyFolderName(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		JSONObject json = new JSONObject();
		String folderCode = request.getParameter("folderCode");
		String folderName = request.getParameter("foldName");
		FolderSearchable fc = new FolderManager();
		
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		FolderManageValidator valid= new FolderManageValidator();
		FolderManageForm form = new FolderManageForm();
		form.setFolderName(folderName);
		
		
		//��ȿ�� �˻�κ�
		valid.validateAdd(form);
		List<String> errorList = valid.getErrors();
		
		

		//�ش� �θ� ���������� �̹� ���� �̸��� ������ �����ϴ��� �˻��ϴ� �κ�
		List<Folder> f = fc.searchFolder_REAL1(memberCode, folderName);
		String parentFolderCode=null;
		if(f.size()==0)
		{
			
		}
		else
		{
			Folder ff= f.get(0);
			System.out.println(ff);
			parentFolderCode = ff.getParentFolderCode();
		}
		
		
		
		List<Folder> tList = fc.searchFolderIdParent(memberCode, parentFolderCode);
		for(Folder folder : tList)
		{
			if(folder.getFolderName().equals(folderName))
			{
				errorList.add("���� �̸��� �ߺ��˴ϴ�. �ٸ� �̸��� �Է����ּ���");
				System.out.println("�ߺ���^^");
			}
		}
		
		
		if(errorList.size()==0)
		{
			//System.out.println(folderCode +  "  " + folderName);
			FolderNameModifiable fnm = new FolderManager();
			boolean res = fnm.modifyFolderName_REAL(folderCode,  folderName);
			if(res)
			{
				json.put("result", true);
				
			}
			//�ý��� ���� ��..
			else
			{
				json.put("result", false);
				json.put("resultMsg", "�ý��ۿ� ��� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ����ּ���");
			}
			response.getWriter().print(json);
		}
		// ��ȿ���˻� ���� ��..
		else
		{
			json.put("result", false);
			json.put("resultMsg", errorList);
			response.getWriter().print(json);
		}
	}
	/**
	 * ���� ��θ� ������ �� ȣ�� �Ǵ� �޼ҵ�� �񵿱�ó���� ����� �˷���
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void modifyFolderPath(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		String destFolderCode = request.getParameter("dest");
		String startFolderCode = request.getParameter("start");
		JSONObject json = new JSONObject();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		
		
		//�ű���� ���������� �̹� ���� �̸��� ������ �����ϴ��� �˻��ϴ� �κ�

		FolderSearchable fs = new FolderManager();
		List<Folder> fList = fs.searchFolderIdParent(memberCode, destFolderCode);	//�ű�� ������ �ڽ� ��������Ʈ
		Folder fo = fs.searchFolder_REAL3(startFolderCode);	
		String startFolderName = fo.getFolderName().trim();		//�ű���� ������ �̸�
		
		
		for(Folder f : fList)
		{
			//�ű���� ������ �ڽ� ���� ��Ͽ� ���� �ű��� ������ �̸��� ���� ������ �ִٸ�
			if(f.getFolderName().trim().equals(startFolderName))
			{
				json.put("result", false);
				json.put("resultMsg", "Folder Move Failed!! FolderName is duplicated!!");
				response.getWriter().print(json);
				return;
			}
		}
		
		
		
		System.out.println(destFolderCode + "  " + startFolderCode);
		FolderPathModifiable fpm = new FolderManager();
		boolean res = fpm.modifyFolderPath_REAL(startFolderCode, destFolderCode);
		if(res)
		{
			json.put("result", true);
			json.put("resultMsg", "Folder Move Success!!");
		}
		else
		{
			json.put("result", false);
			json.put("resultMsg", "Folder Move Failed!!");
		}
		response.getWriter().print(json);
	}
	/**
	 * ������ ������ �� ȣ�� �Ǵ� �޼ҵ�� �񵿱�ó���� ����� �˷���
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void deleteFolder(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		/*
		FolderSearchable fc = new FolderManager();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		boolean res=false;
		//�߰��Ϸ��� ������ ���� ȣ��Ʈ�� �������� �˻��ϴ� �κ�
		Folder fff = fc.searchFolder_REAL3(parentFolderCode);
		String memberCode2 = fff.getFolderPath(); 	//����� �˻��� ������ ������ ����ڵ���
		if(!memberCode2.equals(memberCode))		//���� �߰��Ϸ��� ������ ���� �������� ������ �ƴ϶�� ����ڵ带 ȣ��Ʈ���ؼ� ������ �߰��ؾߵ�
		{
			//�� ���������� ���� ȣ��Ʈ�̸����� �߰��ؾߵ�
			res = ((FolderCreateable) fc).createFolder_REAL(memberCode2, folderName, parentFolderCode, isSharedFolder);
		}	
		*/
		
		String folderCode= request.getParameter("folderCode");
		int count=0;
		
		JSONObject json = new JSONObject();
		//String memberCode = (String) request.getSession().getAttribute("memberCode");
		FolderSearchable fs = new FolderManager();
		
		Folder f2 = (Folder) fs.searchFolder_REAL3(folderCode);
		
		if(f2.getParentFolderCode().trim().equals("root"))
		{
			json.put("result", false);
			json.put("resultMsg", "Root Folder Can't be removed!");
			response.getWriter().print(json);
			return;
		}
		
		deleteFolder(request, folderCode, count);
		loadCapacity(request, response);
		
	}
	
	//�����ڵ忡 ���� ��� �ڽ� ������ �����ϴ� recursive Method
	private void deleteFolder(HttpServletRequest request, String folderCode, int count)
	{
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		FolderSearchable fs = new FolderManager();
		
		
		List<Folder> folderList =  fs.searchFolderIdParent(memberCode, folderCode);
	
		
		
		FolderDelable fd = (FolderDelable) fs;
		for(Folder f : folderList)
		{
			
			deleteFolder(request, f.getFolderCode(), count);
		}
		fd.deleteFolder_REAL(folderCode);
		System.out.println("������ : " + folderCode);
		//System.out.println("ȣ��!");
	}
	/**
	 * ������ ������ �� ȣ�� �Ǵ� �޼ҵ�� �񵿱�ó���� ����� �˷���
	 * @param request
	 * @param response
	 */
	private void copyPasteFolder(HttpServletRequest request, HttpServletResponse response) {
	
	}
	/**
	 * ������� Ʈ�������� �񵿱�� �ε��ϴ� �޼ҵ�
	 * @param request
	 * @throws IOException 
	 */
	private void loadTree(HttpServletRequest request, HttpServletResponse response, String folderCode) throws IOException 
	{
		//���ڷ� ���� �����ڵ忡 ���� ������ �� ���������� ������ ����Ʈ���� ����
		PrintWriter writer = response.getWriter();
		JSONArray jarr = new JSONArray();
		FolderSearchable fs = new FolderManager();
		List<Folder> folderList1 = fs.searchFolder_REAL2((String) request.getSession().getAttribute("memberCode"), "�Ϲ�");

		for(Folder fo : folderList1)
		{
			if(fo.getParentFolderCode()==null || fo.getFolderCode().trim().equals(folderCode))
			{
				continue;
			}
			else
			{
				JSONObject json = new JSONObject();
				json.put("data", fo.getFolderName());
				json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
				//System.out.println(json + "^^");
				jarr.add(json);
			}
		}
		
		//System.out.println("������!");
		MakeTree mk = new MakeTree(jarr);
		//System.out.println(mk.createTreeGo().toString());
		
		
		writer.print(mk.createTreeGo().toString());
		//writer.flush();
	}
	
	private void loadTree2(HttpServletRequest request, HttpServletResponse response, String folderCode2) throws IOException
	{
		String folderCode = folderCode2.substring(1);
		System.out.println("������ �����ڵ� : " + folderCode);
		PrintWriter writer = response.getWriter();
		JSONArray jarr = new JSONArray();
		FolderSearchable fs = new FolderManager();
		
		
		//Ŭ���� ������ �ֻ��� ��Ʈ  �������� Ŭ���� ������ �����ϰ� ���������!~!!!!!
		//Ŭ���� ������ ������ �������� �˾ƾ���!
		FolderSearchable fc = new FolderManager();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		//boolean res=false;
		//�̵��Ϸ��� ������ ���� ȣ��Ʈ�� �������� �˻��ϴ� �κ�
		Folder fff = fc.searchFolder_REAL3(folderCode);
		String memberCode2 = fff.getFolderPath().trim(); 	//����� �˻��� ������ ������ ����ڵ���
		System.out.println("�ش����� �������ڵ� : " + memberCode2);
		
		if(!memberCode2.equals(memberCode))		//�����̵��Ϸ��� ������ ���� ȣ��Ʈ�� �������� ����Ʈ�� �ƴ϶��!
		{
			System.out.println("�����ƴ�");
			//�� �� ȣ��Ʈ�� ��Ʈ ��������Ʈ�� ��Ͽ� ���������
			List<Folder> folderList1 = fs.searchFolder_REAL2(memberCode2, "����");
			for(Folder fo : folderList1)
			{
				if(fo.getParentFolderCode()==null || fo.getFolderCode().trim().equals(folderCode))
				{
					continue;
				}
				else
				{
					JSONObject json = new JSONObject();
					json.put("data", fo.getFolderName());
					json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
					json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
					System.out.println(json + "^^");
					jarr.add(json);
				}
			}
		}	
		//�� �ڱ� �ڽ��� ������ �����ߴٸ�
		else
		{	
			System.out.println("������");
			List<Folder> folderList1 = fs.searchFolder_REAL2(memberCode, "����");
			//�ڽ��� ȣ��Ʈ�� ���������� ���ؼ� �߰��ϴºκ�
			for(Folder fo : folderList1)
			{
				if(fo.getParentFolderCode()==null || fo.getFolderCode().trim().equals(folderCode))
				{
					continue;
				}
				else
				{
					JSONObject json = new JSONObject();
					json.put("data", fo.getFolderName());
					json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
					json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
					System.out.println(json + "^^");
					jarr.add(json);
				}
			}
		}
		
		
		
		//System.out.println("������!");
		MakeTree mk = new MakeTree(jarr);
		//System.out.println(mk.createTreeGo().toString());
		
		
		writer.print(mk.createTreeGo().toString());
		
		
	}
	
	/**
	 * ������� ���ο뷮�� �񵿱�� �ε��ϴ� �޼ҵ�
	 * @param request
	 * @throws IOException 
	 */
	private void loadCapacity(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		//�뷮 �ֽ�ȭ ������ �ڵ� �κ�
				MemberSearchable ms = new MemberManager();
				System.out.println(request.getSession().getAttribute("memberCode"));
				
				Member m = ms.searchMemberCode((String) request.getSession().getAttribute("memberCode"));

				DecimalFormat df = new DecimalFormat("0.00");
				String max = null;
				String used = null;
				
				
				
				
				// �ִ� �뷮 ����
				float capacity = m.getCapacityLimit();	
				//request.setAttribute("maxC", capacity);
				float val1=capacity;
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
				//request.setAttribute("usedC", capacity);
				float val2=capacity;
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
				
				
				String val3=max;
				String val4=used;
				
				//request.setAttribute("maxCapacity", max);
				//request.setAttribute("usedCapacity", used);
				//System.out.println(val1 + '  ' + );
				
				JSONObject json2 = new JSONObject();
				json2.put("val1", val1);
				json2.put("val2", val2);
				json2.put("val3", val3);
				json2.put("val4", val4+" /");
				json2.put("result", true);
				
				response.getWriter().print(json2);
	}

}
