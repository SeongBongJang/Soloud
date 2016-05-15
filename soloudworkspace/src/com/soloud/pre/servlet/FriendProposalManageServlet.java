package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.soloud.app.man.AlarmMessageManager;
import com.soloud.app.man.FriendManager;
import com.soloud.app.man.FriendProposalManager;
import com.soloud.app.man.MemberManager;
import com.soloud.app.manInt.AlarmMessageSearchable;
import com.soloud.app.manInt.FriendProposalAcceptable;
import com.soloud.app.manInt.FriendProposalCancelable;
import com.soloud.app.manInt.FriendProposalRefusable;
import com.soloud.app.manInt.FriendProposalSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.AlarmMessage;
import com.soloud.app.model.FriendProposal;
import com.soloud.app.model.Member;
import com.soloud.util.CheckURI;

/**
 * Servlet implementation class FriendProposalManageServlet1
 */
@WebServlet(name = "/FriendProposalManageServlet",urlPatterns={"/loadFriendReceive.do","/loadFriendSend.do","/refuseProposal.do","/cancelProposal.do","/acceptProposal.do","/searchProposalFriend.do"})
public class FriendProposalManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//url확인
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		if(action.equals("loadFriendReceive.do"))
		{
			loadFriendReceive(request);
			loadAlram(request, response);
			RequestDispatcher view = request.getRequestDispatcher("jsp/friendListRecommendTable.jsp");
			view.forward(request, response);
			return;
		}else if(action.equals("loadFriendSend.do"))
		{
			loadFriendSend(request);
			loadAlram(request, response);
			RequestDispatcher view = request.getRequestDispatcher("jsp/friendListRequestTable.jsp");
			view.forward(request, response);
			return;
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(1);
		//System.out.println("friendMemberId : " + request.getParameter("friendMemberId")); //ajax로 날라온 값 확인
		//url확인
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		if(action.equals("refuseProposal.do"))
		{
			refuseProposal(request,response);
			return;
		}else if(action.equals("cancelProposal.do"))
		{

			cancelProposal(request,response);
			return;
		}else if(action.equals("acceptProposal.do"))
		{
			acceptProposal(request,response);
			return;
		}else if(action.equals("searchProposalFriend.do"))
		{
			searchProposalFriend(request,response);				//검색
			return;
		}
	}
	@SuppressWarnings("unchecked")
	public void searchProposalFriend(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();

		//사용자 정보
		String searchInfo = request.getParameter("searchInfo").trim();			//검색할 사용자 정보
		String type = request.getParameter("type").trim();						//검색을 호출한 곳의 정보			
		String memberCode = (String)request.getSession().getAttribute("memberCode");
		
		//
		FriendProposalSearchable friendProposalSearchable = new FriendProposalManager();
		//분기 처리 (보낸곳에 따라)
		switch(type)
		{
		case "recommendMember" :
			ArrayList<FriendProposal> friendProposals = friendProposalSearchable.searchFriendProposalSenderName(memberCode, searchInfo);
			for(FriendProposal temp : friendProposals){
				JSONObject json = new JSONObject();
				json.put("id", temp.getSenderId().trim());
				json.put("name",temp.getSenderName().trim());
				jsonArray.add(json);
			}
			out.print(jsonArray);
			break;
		case "requestMember" :
			ArrayList<FriendProposal> friendProposals2 = friendProposalSearchable.searchFriendProposalReceiverName(memberCode, searchInfo);
			for(FriendProposal temp : friendProposals2){
				JSONObject json = new JSONObject();
				json.put("id", temp.getSenderId().trim());
				json.put("name",temp.getSenderName().trim());
				jsonArray.add(json);
			}
			out.print(jsonArray);
			break;
		}
	}
	@SuppressWarnings("unchecked")
	public void acceptProposal(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		//사용자 정보
		String friendMemberId = request.getParameter("friendMemberId");	//친구 멤버 아이디
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode"); //사용자 멤버코드
		//System.out.println( request.getParameter("groupName"));
		//친구 신청 수락
		FriendProposalAcceptable friendProposalAcceptable = new FriendManager();
		if(friendProposalAcceptable.acceptFriendProposal(memberCode, friendMemberId))
		{
			System.out.println(111);
			//종료
			json.put("isSuccess", true);
			out.print(json);
		}else
		{
			System.out.println(222);
			//종료
			json.put("isSuccess", false);
			out.print(json);
		}
	}
	@SuppressWarnings("unchecked")
	public void refuseProposal(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		//사용자 정보
		String friendMemberId = request.getParameter("friendMemberId");	//친구 멤버 아이디
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode"); //사용자 멤버코드
		//친구 신청 거절
		FriendProposalRefusable friendProposalRefusable = new FriendProposalManager();

		if(friendProposalRefusable.refuseFriendProposal(friendMemberId, memberCode))
		{
			System.out.println("성공");
			//종료
			json.put("isSuccess", true);
			out.print(json);
		}else
		{
			System.out.println("실패");
			//종료
			json.put("isSuccess", false);
			out.print(json);
		}
	}
	@SuppressWarnings("unchecked")
	public void cancelProposal(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		//사용자 정보
		String friendMemberId = request.getParameter("friendMemberId");	//친구 멤버 아이디
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode"); //사용자 멤버코드
		//친구 신청 취소
		FriendProposalCancelable friendProposalCancelable = new FriendProposalManager();
		if(friendProposalCancelable.cancelFriendProposal(memberCode, friendMemberId))
		{
			//종료
			json.put("isSuccess", true);
			out.print(json);
		}else
		{
			//종료
			json.put("isSuccess", false);
			out.print(json);
		}

	}
	public void loadFriendReceive(HttpServletRequest request)
	{
		//회원 코드 가져옴
		String memberCode= (String)request.getSession().getAttribute("memberCode");	
		MemberManager manager = new MemberManager();					//멤버코드에 해당하는 정보를 가져오기 위해 MemberManager
		Member member= manager.searchMemberCode(memberCode);			//searchMemberId()를 통해 멤버의 정보를 가져옴
		request.setAttribute("member", member);							//검색한 멤버정보를 세션에 넣음	


		//나에게 온 친구 제안 목록 가져오기
		FriendProposalSearchable friendProposalSearchable = new FriendProposalManager();
		ArrayList<FriendProposal> friendProposalList = (ArrayList<FriendProposal>)friendProposalSearchable.searchFriendProposalReceiverId(memberCode);		
		request.setAttribute("friendProposalList", friendProposalList);		
	}
	public void loadFriendSend(HttpServletRequest request)
	{
		//회원 코드 가져옴
		String memberCode= (String)request.getSession().getAttribute("memberCode");	
		MemberSearchable memberSearchable = new MemberManager();					//멤버코드에 해당하는 정보를 가져오기 위해 MemberManager
		Member member= memberSearchable.searchMemberCode(memberCode);			//searchMemberId()를 통해 멤버의 정보를 가져옴
		request.setAttribute("member", member);							//검색한 멤버정보를 세션에 넣음	

		//내가 보낸 친구 제안 목록 가져오기
		FriendProposalSearchable friendProposalSearchable = new FriendProposalManager();
		ArrayList<FriendProposal> friendProposalList = (ArrayList<FriendProposal>)friendProposalSearchable.searchFriendProposalSenderId(memberCode);
		request.setAttribute("friendProposalList", friendProposalList);
	}
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
