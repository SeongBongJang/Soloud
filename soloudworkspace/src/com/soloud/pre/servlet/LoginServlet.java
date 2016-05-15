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
 * 로그인 요청 및 로그아웃 요청을 담당하는 서블릿으로 로그인 시 관리자/회원을 판별한다.
 * @author 영진
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
	 * 로그아웃 요청 시 로그인 페이지를 로드시켜줌
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 로그아웃 // 회원가입 페이지 요청
		 */
		
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		System.out.println(action);
		if(action.equals("logout.do"))
		{
			List<String> memberList = (List<String>) getServletContext().getAttribute("ActiveMemberList");
			boolean res = memberList.remove(request.getSession().getAttribute("memberCode"));
			System.out.println(res + "로그아웃에 성공");
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
	 * 로그인 요청 시 입력받은 값을 판별하고 정보가 옳지 않을 때 비동기처리로 에러메시지를 보낸다. <br>로그인 성공시 메인페이지를 로드시켜줌
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		/**
		 * 로그인 요청
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
			//일반 사용자
			if(kindCode.equals("mk1"))
			{
				loadAlram(request, response);
				loadCapacity(request, response);
				dispatchUrl = "/jsp/memberMain.jsp";
			}
			//관리자
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
	 * 로그인 검사
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
			//DB결과 받는 쪽
			//유효성에 이상이 없는 경우
			
			MemberLoginable ml = new MemberManager();
			boolean res = ml.loginMember(id, password);
			
			
			System.out.println("로그인에"+res+ "   "+ id + "  " + password );
			if(res==false)
			{
				System.out.println("실패시퀀스");
				
				json.put("isLogin", true);
				json.put("isSuccess", false);
				json.put("resultMsg", "ID 또는 비밀번호가 잘못됬습니다!!");
				writer.print(json);
				return;
			}
			
			MemberList list =  AbstractMemberManager.getMemberList();
			ArrayList<Member> m = list.searchMemberName(id);
			Member t = m.get(0);
			
			list.deleteMember(t.getName());
			
			String memberKindCode = t.getPassword();
			//mk1이면 일반 사용자, mk2면 관리자
			
			
			/*
			컨텍스트 검색하여 로그인 되있는지 검사
			*/
			List<String> activeMemberList = (List<String>) getServletContext().getAttribute("ActiveMemberList");
			//이미 로그인 중이라면
			
			
			if(activeMemberList.contains(t.getId().trim()))
			{
				json.put("isLogin", true);
				json.put("resultMsg", "로그인 중입니다...");
				writer.print(json);
				return;
			}
			//로그인 중이 아니라면
			else
			{
				System.out.println("들어오니..?");
				json.put("isLogin", false);
				json.put("resultMsg", "로그인 중이 아닙니다...");
			
			}
			
			
			//이미 멤버코드에 대한 정보가 세션에올라가있다면
			if(request.getSession().getAttribute("memberCode") != null)	
			{
				//세션에있는 기존 로그인 정보를 삭제하고
				activeMemberList.remove(((String)request.getSession().getAttribute("memberCode")).trim());			
				System.out.println("기존에 세션에올라있던 멤버코드에 대한 정보를 컨텍스트에서 삭제");
			}
			
			//세션에 사용자 정보를 올려둠
			request.getSession().setAttribute("memberCode", t.getId().trim());
			request.getSession().setAttribute("kindCode", memberKindCode.trim());
			
			
			
			if(memberKindCode.trim().equals("mk2"))
			{
		
				json.put("isSuccess", true);
				json.put("isAdmin", true);
				json.put("resultMsg", "관리자로 로그인합니다...");
				writer.print(json);
			}
			else if(memberKindCode.trim().equals("mk1"))
			{
			
				json.put("isSuccess", true);
				json.put("isAdmin", false);
				json.put("resultMsg", "사용자로 로그인합니다...");
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
	 * 로그인 성공 시 메인페이지에 필요한 사용자 용량 정보 로드
	 * @param request
	 */
	private void loadCapacity(HttpServletRequest request, HttpServletResponse response){
		/**
		 * 사용자 용량정보 로드
		 */
		
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
	/**
	 * 로그인 성공 시 메인페이지에 필요한 사용자 트리구조 로드
	 * @param request
	 * @throws IOException 
	 */
	private void loadTree(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/**
		 * 사용자 내폴더, 공유폴더 트리구조 로드
		 */
		JSONArray jarr = new JSONArray();
		FolderSearchable fs = new FolderManager();
		List<Folder> folderList1 = fs.searchFolder_REAL2((String) request.getSession().getAttribute("memberCode"), "일반");
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
		
		
		//자기가 호스트인 공유폴더의 리스트를 추가
		FolderSearchable fs = new FolderManager();
		List<Folder> folderList1 = fs.searchFolder_REAL2(memberCode, "공유");
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
				
				System.out.println("내꺼인거 : " + json);
				jarr1.add(json);
			}
		}
		
		
		
		String rootShareFolderCode=null;
		
		//내 공유폴더의 루트 코드를 찾는 부분
		
		List<Folder> fList =fs.searchFolder_REAL2(memberCode, "공유");
		for(Folder f : fList)
		{
			if(f.getParentFolderCode().trim().equals("root"))
			{
				rootShareFolderCode = f.getFolderCode();
			}
		}
		System.out.println("나의 공유 루트 폴더코드 : " + rootShareFolderCode);
		
		
		
		
		//자기가 호스트는 아니지만 접근이 가능한 공유폴더의 리스트를 추가
		SharedFolderSearchable sfs = new SharedFolderManager();
		List<MemberShareFolderVDTO> shareFolderList =  sfs.searchMemberShareFolder(memberCode);
		
		for(MemberShareFolderVDTO dto : shareFolderList)
		{
			JSONObject json=new JSONObject();
			//상대의 공유폴더중 부모폴더코드가 호스트 폴더코드의 공유루트 폴더코드인거에대해서는  부모코드를 나의 공유 루트 코드로하고
			String parentCode = dto.getParentFolderCode();
			String hostCode = dto.getHostMemberCode();
			
			
			//호스트의 공유폴더의 루트 코드를 찾는 부분
			String hostRootShareFolderCode=null;
			List<Folder> ff =fs.searchFolder_REAL2(hostCode, "공유");
			for(Folder f : ff)
			{
				if(f.getParentFolderCode().trim().equals("root"))
				{
					hostRootShareFolderCode = f.getFolderCode();
				}
			}
			
			System.out.println("호스트의 멤버코드 : " + hostCode);
			System.out.println("상대의 공유 루트 폴더코드 : " + hostRootShareFolderCode + ", 공유된 폴더의 부모코드 : " + parentCode);
			
			if(parentCode.trim().equals(hostRootShareFolderCode.trim()))
			{
				json.put("data", dto.getFolderName());
				json.put("attr", "{'id':'"+ dto.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ rootShareFolderCode.trim() + "'}");
			}
			//나머지는 그대로 간다
			else
			{
				json.put("data", dto.getFolderName());
				json.put("attr", "{'id':'"+ dto.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ dto.getParentFolderCode().trim() + "'}");
			}
			System.out.println("내꺼아닌거 : " + json);
			jarr1.add(json);
		}
		

		
		
		
		MakeTree mt = new MakeTree(jarr1);
		
		
		
		///전체 공유가능목록
		System.out.println("전체목록");
		System.out.println(mt.createTreeGo().toString());
		
		response.getWriter().write(mt.createTreeGo().toString());
		
	}
	/**
	 * 로그인 성공시 메인 페이지에 필요한 상단바 알림정보 로드
	 * @param request
	 */
	private void loadAlram(HttpServletRequest request, HttpServletResponse response)
	{
		/**
		 * 사용자 알람정보 로드
		 */
		//만약 새로운 알람이 한개라도 있다면!?
		//친구신청 알림은 제외
		boolean alarmFlag=false;
		boolean friendFlag=false;
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		AlarmMessageSearchable ams = new AlarmMessageManager();
		List<AlarmMessage> alarmList = ams.searchAlarmReceiverId(memberCode);
		for(AlarmMessage alarm : alarmList)
		{
			if(alarm.getMessage().trim().equals("noread") && !alarm.getAlarmMessageKind().equals("ak1"))	//안읽엇는데 알람이잇다면
			{
				alarmFlag=true;
			}
			if(alarm.getMessage().trim().equals("noread") && alarm.getAlarmMessageKind().equals("ak1"))	//안읽엇는데친구신청잇다면
			{
				friendFlag=true;
			}
		}
		
		request.getSession().setAttribute("alarmFlag", alarmFlag);
		request.getSession().setAttribute("friendFlag", friendFlag);
	}
	
	
}
