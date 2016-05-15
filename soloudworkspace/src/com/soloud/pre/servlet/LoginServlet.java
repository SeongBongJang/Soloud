package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.soloud.app.man.AbstractMemberManager;
import com.soloud.app.man.AlarmMessageManager;
import com.soloud.app.man.FolderManager;
import com.soloud.app.man.MemberManager;
import com.soloud.app.man.SharedFolderManager;
import com.soloud.app.manInt.AlarmMessageSearchable;
import com.soloud.app.manInt.FolderSearchable;
import com.soloud.app.manInt.MemberLoginable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.manInt.SharedFolderSearchable;
import com.soloud.app.model.AlarmMessage;
import com.soloud.app.model.Folder;
import com.soloud.app.model.Member;
import com.soloud.app.model.MemberList;
import com.soloud.per.dao.AlarmSearchDAO;
import com.soloud.per.dto.MemberShareFolderVDTO;
import com.soloud.pre.uiform.LoginForm;
import com.soloud.pre.validator.LoginValidator;
import com.soloud.util.CheckURI;
import com.soloud.util.MakeTree;

/**
 * Servlet implementation class LoginServlet
 */
/**
 * �α��� ��û �� �α׾ƿ� ��û�� ����ϴ� �������� �α��� �� ������/ȸ���� �Ǻ��Ѵ�.
 * @author ����
 *
 */
@WebServlet(name="LoginServlet", urlPatterns={"/loginAdmin.do", "/loginComplete.do", "/loginTry.do", "/logout.do", "/dynamicTree.do", "/dynamicTree2.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		getServletContext().setAttribute("ActiveMemberList", new ArrayList<String>());
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * �α׾ƿ� ��û �� �α��� �������� �ε������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * �α׾ƿ� // ȸ������ ������ ��û
		 */
		
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		System.out.println(action);
		if(action.equals("logout.do"))
		{
			List<String> memberList = (List<String>) getServletContext().getAttribute("ActiveMemberList");
			boolean res = memberList.remove(request.getSession().getAttribute("memberCode"));
			System.out.println(res + "�α׾ƿ��� ����");
			request.getSession().invalidate();
			response.sendRedirect("/Soloud");
		}
		else if(action.equals("loadOtherProposal.do"))
		{
			loadAlram(request, response);
			return;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * �α��� ��û �� �Է¹��� ���� �Ǻ��ϰ� ������ ���� ���� �� �񵿱�ó���� �����޽����� ������. <br>�α��� ������ ������������ �ε������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		/**
		 * �α��� ��û
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		String dispatchUrl = null;
		System.out.println(action);
		if(action.equals("loginTry.do"))
		{
			processLogin(request,response);
			return;
		} 
		else if(action.equals("loginComplete.do"))
		{
			//String member_id = (String)request.getSession().getAttribute("member_id");
			//String admin_id = (String)request.getSession().getAttribute("admin_id");
			String kindCode=(String)request.getSession().getAttribute("kindCode");
			String memberCode = (String)request.getSession().getAttribute("memberCode");
			
			List<String> activeMemberList = (List<String>) getServletContext().getAttribute("ActiveMemberList");
			activeMemberList.add(memberCode.trim());
			//�Ϲ� �����
			if(kindCode.equals("mk1"))
			{
				loadAlram(request, response);
				loadCapacity(request, response);
				dispatchUrl = "/jsp/memberMain.jsp";
			}
			//������
			else{
				dispatchUrl = "/jsp/adminSearchFile.jsp";				
			}	
		} 
		else if(action.equals("loginAdmin.do"))
		{
			dispatchUrl = "/jsp/adminSearchFile.jsp";
			request.getSession().setAttribute("admin_id", request.getParameter("input_id"));
		}
		else if(action.equals("dynamicTree.do"))
		{
			loadTree(request, response);
			return;
		}
		else if(action.equals("dynamicTree2.do"))
		{
			loadTree2(request, response);
			return;
		}
		request.getRequestDispatcher(dispatchUrl).forward(request, response);
		
		
	}
	

	/**
	 * �α��� �˻�
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter writer = response.getWriter();
		JSONObject json = new JSONObject();
		String id = request.getParameter("input_id");
		String password = request.getParameter("input_password");
		LoginForm loginForm = new LoginForm(id, password);
		
		LoginValidator loginValidator = new LoginValidator();
		loginValidator.validateLogin(loginForm);
		ArrayList<String> errors = loginValidator.getErrors();
		
		if(errors.isEmpty()){
			//DB��� �޴� ��
			//��ȿ���� �̻��� ���� ���
			
			MemberLoginable ml = new MemberManager();
			boolean res = ml.loginMember(id, password);
			
			
			System.out.println("�α��ο�"+res+ "   "+ id + "  " + password );
			if(res==false)
			{
				System.out.println("���н�����");
				
				json.put("isLogin", true);
				json.put("isSuccess", false);
				json.put("resultMsg", "ID �Ǵ� ��й�ȣ�� �߸�����ϴ�!!");
				writer.print(json);
				return;
			}
			
			MemberList list =  AbstractMemberManager.getMemberList();
			ArrayList<Member> m = list.searchMemberName(id);
			Member t = m.get(0);
			
			list.deleteMember(t.getName());
			
			String memberKindCode = t.getPassword();
			//mk1�̸� �Ϲ� �����, mk2�� ������
			
			
			/*
			���ؽ�Ʈ �˻��Ͽ� �α��� ���ִ��� �˻�
			*/
			List<String> activeMemberList = (List<String>) getServletContext().getAttribute("ActiveMemberList");
			//�̹� �α��� ���̶��
			
			
			if(activeMemberList.contains(t.getId().trim()))
			{
				json.put("isLogin", true);
				json.put("resultMsg", "�α��� ���Դϴ�...");
				writer.print(json);
				return;
			}
			//�α��� ���� �ƴ϶��
			else
			{
				System.out.println("������..?");
				json.put("isLogin", false);
				json.put("resultMsg", "�α��� ���� �ƴմϴ�...");
			
			}
			
			
			//�̹� ����ڵ忡 ���� ������ ���ǿ��ö��ִٸ�
			if(request.getSession().getAttribute("memberCode") != null)	
			{
				//���ǿ��ִ� ���� �α��� ������ �����ϰ�
				activeMemberList.remove(((String)request.getSession().getAttribute("memberCode")).trim());			
				System.out.println("������ ���ǿ��ö��ִ� ����ڵ忡 ���� ������ ���ؽ�Ʈ���� ����");
			}
			
			//���ǿ� ����� ������ �÷���
			request.getSession().setAttribute("memberCode", t.getId().trim());
			request.getSession().setAttribute("kindCode", memberKindCode.trim());
			
			
			
			if(memberKindCode.trim().equals("mk2"))
			{
		
				json.put("isSuccess", true);
				json.put("isAdmin", true);
				json.put("resultMsg", "�����ڷ� �α����մϴ�...");
				writer.print(json);
			}
			else if(memberKindCode.trim().equals("mk1"))
			{
			
				json.put("isSuccess", true);
				json.put("isAdmin", false);
				json.put("resultMsg", "����ڷ� �α����մϴ�...");
				writer.print(json);
			} 
			

		}
		else {
		
			json.put("isSuccess", false);
			json.put("isAdmin", false);
			json.put("resultMsg", errors);
			writer.print(json);

		}
	}
	/**
	 * �α��� ���� �� ������������ �ʿ��� ����� �뷮 ���� �ε�
	 * @param request
	 */
	private void loadCapacity(HttpServletRequest request, HttpServletResponse response){
		/**
		 * ����� �뷮���� �ε�
		 */
		
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
	/**
	 * �α��� ���� �� ������������ �ʿ��� ����� Ʈ������ �ε�
	 * @param request
	 * @throws IOException 
	 */
	private void loadTree(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/**
		 * ����� ������, �������� Ʈ������ �ε�
		 */
		JSONArray jarr = new JSONArray();
		FolderSearchable fs = new FolderManager();
		List<Folder> folderList1 = fs.searchFolder_REAL2((String) request.getSession().getAttribute("memberCode"), "�Ϲ�");
		//List<Folder> folderListReal1 = new ArrayList<Folder>();
		for(Folder fo : folderList1)
		{
			
			if(fo.getParentFolderCode()==null)
			{
				continue;
			}
			else
			{
				JSONObject json = new JSONObject();
				json.put("data", fo.getFolderName());
				json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
				
				System.out.println(json);
				jarr.add(json);
			}
		}
		
		MakeTree mk = new MakeTree(jarr);
		response.getWriter().print(mk.createTreeGo().toString());
	}
	
	private void loadTree2(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		JSONArray jarr1 = new JSONArray();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		//�ڱⰡ ȣ��Ʈ�� ���������� ����Ʈ�� �߰�
		FolderSearchable fs = new FolderManager();
		List<Folder> folderList1 = fs.searchFolder_REAL2(memberCode, "����");
		//List<Folder> folderListReal1 = new ArrayList<Folder>();
		for(Folder fo : folderList1)
		{
			
			if(fo.getParentFolderCode()==null)
			{
				continue;
			}
			else
			{
				JSONObject json = new JSONObject();
				json.put("data", fo.getFolderName());
				json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
				
				System.out.println("�����ΰ� : " + json);
				jarr1.add(json);
			}
		}
		
		
		
		String rootShareFolderCode=null;
		
		//�� ���������� ��Ʈ �ڵ带 ã�� �κ�
		
		List<Folder> fList =fs.searchFolder_REAL2(memberCode, "����");
		for(Folder f : fList)
		{
			if(f.getParentFolderCode().trim().equals("root"))
			{
				rootShareFolderCode = f.getFolderCode();
			}
		}
		System.out.println("���� ���� ��Ʈ �����ڵ� : " + rootShareFolderCode);
		
		
		
		
		//�ڱⰡ ȣ��Ʈ�� �ƴ����� ������ ������ ���������� ����Ʈ�� �߰�
		SharedFolderSearchable sfs = new SharedFolderManager();
		List<MemberShareFolderVDTO> shareFolderList =  sfs.searchMemberShareFolder(memberCode);
		
		for(MemberShareFolderVDTO dto : shareFolderList)
		{
			JSONObject json=new JSONObject();
			//����� ���������� �θ������ڵ尡 ȣ��Ʈ �����ڵ��� ������Ʈ �����ڵ��ΰſ����ؼ���  �θ��ڵ带 ���� ���� ��Ʈ �ڵ���ϰ�
			String parentCode = dto.getParentFolderCode();
			String hostCode = dto.getHostMemberCode();
			
			
			//ȣ��Ʈ�� ���������� ��Ʈ �ڵ带 ã�� �κ�
			String hostRootShareFolderCode=null;
			List<Folder> ff =fs.searchFolder_REAL2(hostCode, "����");
			for(Folder f : ff)
			{
				if(f.getParentFolderCode().trim().equals("root"))
				{
					hostRootShareFolderCode = f.getFolderCode();
				}
			}
			
			System.out.println("ȣ��Ʈ�� ����ڵ� : " + hostCode);
			System.out.println("����� ���� ��Ʈ �����ڵ� : " + hostRootShareFolderCode + ", ������ ������ �θ��ڵ� : " + parentCode);
			
			if(parentCode.trim().equals(hostRootShareFolderCode.trim()))
			{
				json.put("data", dto.getFolderName());
				json.put("attr", "{'id':'"+ dto.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ rootShareFolderCode.trim() + "'}");
			}
			//�������� �״�� ����
			else
			{
				json.put("data", dto.getFolderName());
				json.put("attr", "{'id':'"+ dto.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ dto.getParentFolderCode().trim() + "'}");
			}
			System.out.println("�����ƴѰ� : " + json);
			jarr1.add(json);
		}
		

		
		
		
		MakeTree mt = new MakeTree(jarr1);
		
		
		
		///��ü �������ɸ��
		System.out.println("��ü���");
		System.out.println(mt.createTreeGo().toString());
		
		response.getWriter().write(mt.createTreeGo().toString());
		
	}
	/**
	 * �α��� ������ ���� �������� �ʿ��� ��ܹ� �˸����� �ε�
	 * @param request
	 */
	private void loadAlram(HttpServletRequest request, HttpServletResponse response)
	{
		/**
		 * ����� �˶����� �ε�
		 */
		//���� ���ο� �˶��� �Ѱ��� �ִٸ�!?
		//ģ����û �˸��� ����
		boolean alarmFlag=false;
		boolean friendFlag=false;
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		AlarmMessageSearchable ams = new AlarmMessageManager();
		List<AlarmMessage> alarmList = ams.searchAlarmReceiverId(memberCode);
		for(AlarmMessage alarm : alarmList)
		{
			if(alarm.getMessage().trim().equals("noread") && !alarm.getAlarmMessageKind().equals("ak1"))	//���о��µ� �˶����մٸ�
			{
				alarmFlag=true;
			}
			if(alarm.getMessage().trim().equals("noread") && alarm.getAlarmMessageKind().equals("ak1"))	//���о��µ�ģ����û�մٸ�
			{
				friendFlag=true;
			}
		}
		
		request.getSession().setAttribute("alarmFlag", alarmFlag);
		request.getSession().setAttribute("friendFlag", friendFlag);
	}
	
	
}
