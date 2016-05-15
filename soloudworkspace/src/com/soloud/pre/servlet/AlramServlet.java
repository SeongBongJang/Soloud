package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.soloud.app.man.AlarmMessageManager;
import com.soloud.app.man.MemberManager;
import com.soloud.app.manInt.AlarmMessageModifiable;
import com.soloud.app.manInt.AlarmMessageSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.AlarmMessage;
import com.soloud.app.model.Member;
import com.soloud.util.CheckURI;

/**
 * Servlet implementation class AlarmServlet
 */
@WebServlet(name="AlarmServlet", urlPatterns={"/loadFriendProposal.do", "/loadOtherProposal.do"})
public class AlramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = CheckURI.getLastURI(request.getRequestURL());
		if(action.equals("loadFriendProposal.do")){
			loadRequest(request, response);
			return;
		} else if(action.equals("loadOtherProposal.do")){
			loadAlram(request, response);
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
	}
	private void loadRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		//사용자 정보
		String memberCode = (String)request.getSession().getAttribute("memberCode");
		//매니저 생성
		MemberManager memberManager = new MemberManager();
		AlarmMessageManager alarmMessageManager = new AlarmMessageManager();
		//회원 코드를 받는 코드로 하여 모든 알람 정보를 가져옴
		ArrayList<AlarmMessage> friendProposal = alarmMessageManager.searchAlarmReceiverId(memberCode);
		
		//친구 신청 알람이면서 noread인 것들을 가져옴
		for(AlarmMessage temp : friendProposal)
		{
			if(temp.getAlarmMessageKind().trim().equals("ak1") && temp.getMessage().trim().equals("noread"))
			{
				Member member = memberManager.searchMemberCode(temp.getReceiverId().trim());	// 코드를 보내어 검색
				JSONObject json = new JSONObject();
				json.put("name", member.getName().trim());
				json.put("id",member.getId().trim());
				json.put("alarmCode",temp.getAlarmMessageCode().trim());
				jsonArray.add(json);
				//System.out.println(temp.getAlarmMessageCode().trim());
				System.out.println(alarmMessageManager.modifyAlarmNoReadChange(temp.getAlarmMessageCode().trim()));
			}
		}
		System.out.println(jsonArray);
		out.print(jsonArray);
		
		return;		
	}
	private void loadAlram(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		PrintWriter pr = response.getWriter();
		String id = (String) request.getSession().getAttribute("memberCode");
		System.out.println("현재 접속중인 id : "+ id);
		if(id==null){
			return;
		}
	
		AlarmMessageSearchable ams = new AlarmMessageManager();
		List<AlarmMessage> resultList  = ams.searchAlarmReceiverId(id);
		
		
		//System.out.println(resultList);
		JSONObject json = new JSONObject();
		int cnt=0;
		
		
		
		for(int i=0; i<resultList.size();i++)
		{
			AlarmMessage temp = resultList.get(i);
			if(temp.getMessage().trim().equals("read"))
			{
				cnt++;
			}
		}
		if(cnt==resultList.size())
		{
			json.put("otherProposalList", null);
			pr.print(json);
			return;
		}
		
		
		
		ArrayList<String> tempList = new ArrayList<String>();
		for(int i=0;i<resultList.size();i++){
			AlarmMessage temp = resultList.get(i);
			if(temp.getAlarmMessageKind().trim().equals("ak1")) 	//만약 친구 신청에대한 알람이라면...
			{
				continue;
			}
			else if(temp.getMessage().trim().equals("noread"))	//친구신청이 아닌 알람에 대해 아직 읽지 않은것이라면
			{
				System.out.println("알람!");
				String alarmKind = temp.getAlarmMessageKind().trim();
				String message=null;
				MemberSearchable ms = new MemberManager();
				Member m = ms.searchMemberCode(temp.getReceiverId());		//여기에 보낸사람 멤버코드가 있음..
				//System.out.println(alarmKind + "12312dmdmdkdkr");
				switch(alarmKind)
				{
					case "ak2":	//친구수락 알림
					{
						message = m.getName() + "님이 친구수락을 하였습니다 ^_^. 확인해주세요~";
						break;
					}
					case "ak3":	//리빙룸초대
					{
						message = m.getName() + "님이 공유폴더 초대를 하였습니다 ^_^. 공유폴더를 확인해주세요~";
						break;
					}
					case "ak4":	//태그알림
					{
						message = m.getName() + "님이 회원님을 태그하였습니다 ^_^. 확인 해 보세요 ^_^";
						break;
					}
				}
				tempList.add(message);
				
				//확인한 알람들 리드로 바꺼야댐
				AlarmMessageModifiable amm = new AlarmMessageManager();
				amm.modifyAlarmNoReadChange(temp.getAlarmMessageCode());
			}
		}
		
		json.put("otherProposalList", tempList);
		pr.print(json);
		
	}

}
