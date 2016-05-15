//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FriendManageServlet.java
//  @ Date : 2014-07-21
//  @ Author : 
//
//


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
import com.soloud.app.manInt.FriendDeleteable;
import com.soloud.app.manInt.FriendGroupModifiable;
import com.soloud.app.model.AlarmMessage;
import com.soloud.app.model.Friend;
import com.soloud.app.model.Group;
import com.soloud.app.model.Member;
import com.soloud.util.CheckURI;

/**
 * ģ�� ���� ��û�� ����ϴ� ������
 * @author ����
 *
 */
@WebServlet(name="FriendManageServlet",urlPatterns={"/loadFriendList.do", "/dropRelationShip.do","/modifyGroup.do","/requestFriend.do","/searchMemberPage.do","/searchFriend.do"})
public class FriendManageServlet extends HttpServlet{
	/**
	 * �ø��� ��ȣ
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��ģ��, ģ����û ������ ��û
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//urlȮ��
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		if(action.equals("loadFriendList.do"))
		{
			loadInfo(request);			//���� ���� ������
			loadFriendList(request);
			loadAlram(request, response);
			RequestDispatcher view = request.getRequestDispatcher("jsp/friendListTable.jsp");
			view.forward(request, response);
		}else if(action.equals("searchMemberPage.do"))
		{
			loadInfo(request);
			loadAlram(request, response);
			RequestDispatcher view = request.getRequestDispatcher("jsp/memberListSearchTable.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * ���� , �׷캯��, ��û/�񵿱�
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		/*System.out.println("searchInfo : " + request.getParameter("searchInfo"));
		System.out.println("type : " + request.getParameter("type"));*/
		//urlȮ��
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		if(action.equals("dropRelationShip.do"))
		{
			dropRelationShip(request,response);			
			return;
		}else if(action.equals("searchFriend.do"))
		{
			searchFriend(request,response);				//�˻�
			return;
		}else if(action.equals("requestFriend.do"))
		{
			requestFriend(request,response);			
			return;
		}else if(action.equals("modifyGroup.do"))
		{
			modifyGroup(request,response);
			return;
		}
	}
	/**
	 * ģ�� ����/�񵿱�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	private void dropRelationShip(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		//����� ����
		String friendMemberId = request.getParameter("friendMemberId");	//ģ�� ��� ���̵�
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode"); //����� ����ڵ�
		//ģ�� ����
		FriendDeleteable friendDeleteable = new FriendManager();
		if(friendDeleteable.deleteFriend(memberCode, friendMemberId))
		{
			//����
			json.put("isSuccess", true);
			out.print(json);
		}else{
			//����
			json.put("isSuccess", false);
			out.print(json);
		}
	}
	/**
	 * �׷캯�� /�񵿱�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	private void modifyGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		
		//����� ����
		String modifyFriendId = request.getParameter("friendId");	//ģ�� ��� ���̵�
		String modifyGroupName= request.getParameter("mofidyGroup");
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode"); //����� ����ڵ�
		//System.out.println("modifyFriendId : "+modifyFriendId +" | modifyGroupName:"+modifyGroupName);
		FriendGroupModifiable friendGroupModifiable = new FriendManager();
		
		
		if(friendGroupModifiable.modifyFriendGroup(memberCode, modifyFriendId, Group.valueOf(modifyGroupName))){
			json.put("isSuccess", true);
		}else{
			json.put("isSuccess", false);
		}
		

		
	}
	/**
	 * ģ����û / �񵿱�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	private void requestFriend(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		//����� ����
		String requestReceiverId = request.getParameter("requestInfo");	//ģ�� ��� ���̵�
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode"); //����� ����ڵ�
		//
		FriendProposalManager friendManager = new FriendProposalManager();
		if(friendManager.requestFriendProposal(memberCode, requestReceiverId))
		{
			json.put("isSuccess",true);
		}else{
			json.put("isSuccess",false);
			
		}
		out.print(json);
	}
	/**
	 * ģ���� �˻� / �񵿱�
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	private void searchFriend(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();

		//����� ����
		String searchInfo = request.getParameter("searchInfo").trim();			//�˻��� ����� ����	
		String type = request.getParameter("type").trim();						//�˻��� ȣ���� ���� ����	

		switch(type)
		{
		case "myFriend":
			loadFriendList(request);		//�� ģ�� ����� ���� ������	

			ArrayList<Friend> tempList = (ArrayList<Friend>)request.getAttribute("friendList");//ģ������� ������
			for(Friend list : tempList)//������� �ش��ϴ� ���̵� ���� �͸� ������.
			{
				if(list.getFriendId().trim().equals(searchInfo) || list.getFriendName().trim().indexOf(searchInfo)>=0)
				{ 
					JSONObject json = new JSONObject();
					json.put("id", list.getFriendId().trim());
					json.put("name",list.getFriendName().trim());
					jsonArray.add(json);
				}
			}
			out.print(jsonArray);
			break;
		case "searchMember":		
			MemberManager memberManager = new MemberManager();
			Member member = memberManager.searchMemberCode((String)request.getSession().getAttribute("memberCode"));
			ArrayList<Member> memberList = (ArrayList<Member>)memberManager.searchMember();
			
			
			for(int i = 0 ; i < memberList.size(); i++){	
				if(memberList.get(i).getId().trim().equals("admin") || memberList.get(i).getId().trim().equals(member.getId().trim())){
					memberList.remove(i);
					i--;
				}
			}
			if(searchInfo.trim().equals(""))
			{
				for(Member list : memberList)
				{
					JSONObject json = new JSONObject();
					json.put("id", list.getId().trim());
					json.put("name",list.getName().trim());
					jsonArray.add(json);
				}
			}else{
				for(Member list : memberList)
				{
					if(list.getId().trim().equals(searchInfo) || list.getName().trim().indexOf(searchInfo)>=0)
					{ 
						JSONObject json = new JSONObject();
						json.put("id", list.getId().trim());
						json.put("name",list.getName().trim());
						jsonArray.add(json);
					}
				}
			}
			out.print(jsonArray);
			break;
		}

	}
	/**
	 * ģ��������� �ε��ؿ�
	 * @param request
	 */
	private void loadFriendList(HttpServletRequest request) {
		//ȸ�� �ڵ� ������
		String memberCode= (String)request.getSession().getAttribute("memberCode");	
		FriendManager friendManager = new FriendManager();
		ArrayList<Friend> memberFriend = (ArrayList<Friend>)friendManager.searchFriendList(memberCode);
		request.setAttribute("friendList", memberFriend);
	}
	/**
	 * ���������� ������
	 * 
	 * 
	 * 
	 * @param request
	 */
	private void loadInfo(HttpServletRequest request) {
		//ȸ�� �ڵ� ������
		String memberCode= (String)request.getSession().getAttribute("memberCode");	
		MemberManager manager = new MemberManager();									//����ڵ忡 �ش��ϴ� ������ �������� ���� MemberManager
		Member member= manager.searchMemberCode(memberCode);										//searchMemberId()�� ���� ����� ������ ������
		request.setAttribute("member", member);										//�˻��� ��������� ���ǿ� ����	
	}
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