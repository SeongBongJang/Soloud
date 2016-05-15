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
		//����� ����
		String memberCode = (String)request.getSession().getAttribute("memberCode");
		//�Ŵ��� ����
		MemberManager memberManager = new MemberManager();
		AlarmMessageManager alarmMessageManager = new AlarmMessageManager();
		//ȸ�� �ڵ带 �޴� �ڵ�� �Ͽ� ��� �˶� ������ ������
		ArrayList<AlarmMessage> friendProposal = alarmMessageManager.searchAlarmReceiverId(memberCode);
		
		//ģ�� ��û �˶��̸鼭 noread�� �͵��� ������
		for(AlarmMessage temp : friendProposal)
		{
			if(temp.getAlarmMessageKind().trim().equals("ak1") && temp.getMessage().trim().equals("noread"))
			{
				Member member = memberManager.searchMemberCode(temp.getReceiverId().trim());	// �ڵ带 ������ �˻�
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
		System.out.println("���� �������� id : "+ id);
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
			if(temp.getAlarmMessageKind().trim().equals("ak1")) 	//���� ģ�� ��û������ �˶��̶��...
			{
				continue;
			}
			else if(temp.getMessage().trim().equals("noread"))	//ģ����û�� �ƴ� �˶��� ���� ���� ���� �������̶��
			{
				System.out.println("�˶�!");
				String alarmKind = temp.getAlarmMessageKind().trim();
				String message=null;
				MemberSearchable ms = new MemberManager();
				Member m = ms.searchMemberCode(temp.getReceiverId());		//���⿡ ������� ����ڵ尡 ����..
				//System.out.println(alarmKind + "12312dmdmdkdkr");
				switch(alarmKind)
				{
					case "ak2":	//ģ������ �˸�
					{
						message = m.getName() + "���� ģ�������� �Ͽ����ϴ� ^_^. Ȯ�����ּ���~";
						break;
					}
					case "ak3":	//�������ʴ�
					{
						message = m.getName() + "���� �������� �ʴ븦 �Ͽ����ϴ� ^_^. ���������� Ȯ�����ּ���~";
						break;
					}
					case "ak4":	//�±׾˸�
					{
						message = m.getName() + "���� ȸ������ �±��Ͽ����ϴ� ^_^. Ȯ�� �� ������ ^_^";
						break;
					}
				}
				tempList.add(message);
				
				//Ȯ���� �˶��� ����� �ٲ��ߴ�
				AlarmMessageModifiable amm = new AlarmMessageManager();
				amm.modifyAlarmNoReadChange(temp.getAlarmMessageCode());
			}
		}
		
		json.put("otherProposalList", tempList);
		pr.print(json);
		
	}

}
