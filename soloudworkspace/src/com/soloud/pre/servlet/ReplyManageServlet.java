package com.soloud.pre.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.simple.JSONArray;

import com.soloud.app.man.MemberManager;
import com.soloud.app.man.SharedFolderReplyManager;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.manInt.SharedFolderReplyAddable;
import com.soloud.app.manInt.SharedFolderReplySearchable;
import com.soloud.app.model.Member;
import com.soloud.app.model.Reply;
import com.soloud.util.CheckURI;

/**
 * Servlet implementation class ReplyManageServlet
 */
@WebServlet(name="ReplyManageServlet", urlPatterns={"/addReply.do", "/loadReply.do", "/findUser.do"})
public class ReplyManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = CheckURI.getLastURI(request.getRequestURL());
		if(action.equals("loadReply.do")){
			loadReplyList(request,response);
			return;
		} else if(action.equals("findUser.do")) {
			findUserInfo(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = CheckURI.getLastURI(request.getRequestURL());
		if(action.equals("addReply.do")){
			addReply(request, response);
			return;
		} else if(action.equals("loadReply.do")){
			loadReplyList(request,response);
			return;
		}
	}
	private void addReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//요청으롭부터 날라온 데이터 및 세션데이터 
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		String folderCode = (String) request.getSession().getAttribute("folderCode");
		String content = request.getParameter("content");

		//멤버확인
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberCode(memberCode);
		System.out.println("서블릿 확인 : "+member);
		if(member==null){return;}
		
		//멤버 아이디 및 이름
		String memberId = member.getId();
		String memberName = member.getName();
		
		
		//
		SharedFolderReplyAddable sharedFolderReplyAddable = new SharedFolderReplyManager();
		GregorianCalendar date = new GregorianCalendar();
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH)+1;
		int dat = date.get(Calendar.DATE);
		JSONObject json = new JSONObject();
		if(sharedFolderReplyAddable.addReply(folderCode, memberId, content, date)){
			//성공
			json.put("isSuccess", true);
			json.put("memberId", memberId);
			json.put("memberName", memberName);
			json.put("writeDate", year+"-"+month+"-"+dat);
		} else {
			json.put("isSuccess", false);
		}
		response.getWriter().print(json);
	}
	private void loadReplyList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		String folderCode = (String) request.getSession().getAttribute("folderCode");
		System.out.println("댓글등록에서의 폴더코드 : "+folderCode);
		System.out.println("Member Code : "+memberCode +"\n"+"FolderCode : "+folderCode);
		
		SharedFolderReplySearchable sharedFolderReplySearchable = new SharedFolderReplyManager();
		ArrayList<Reply> replyList = sharedFolderReplySearchable.searchReply(folderCode);
			
		JSONArray jsonArray = new JSONArray();
		if(replyList == null || replyList.isEmpty()) {
			JSONObject json = new JSONObject();
			json.put("isExist", false);
			jsonArray.add(json);
			response.getWriter().print(jsonArray);
			return;
		} else {
			
			for(Reply temp : replyList) {
				JSONObject json = new JSONObject();
				json.put("writerId", temp.getWriterId());
				
				
				String writerId = temp.getWriterId();
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberId(writerId);
				String writerName = member.getName();
				
				json.put("writerName", writerName);
				
				json.put("content", temp.getContent());
				
				GregorianCalendar writeDate = temp.getWriteDate();
			
				int month = writeDate.get(Calendar.MONTH)+1;
				int date = writeDate.get(Calendar.DATE);
				int hour = writeDate.get(Calendar.HOUR_OF_DAY);
				int min = writeDate.get(Calendar.MINUTE);
				
				String viewDate = month+"-"+date+" "+hour+":"+min;
				System.out.println(viewDate);
				json.put("writeDate", viewDate);
				jsonArray.add(json);
			}
			response.getWriter().print(jsonArray);
		}		
	}
	private void findUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberCode(memberCode);
		JSONObject json = new JSONObject();
		if(member == null) {
			json.put("isSuccess", false);
		} else {
			String id = member.getId();
			String name = member.getName();
			System.out.println("findUserInfo : "+id+"//"+name);
			json.put("isSuccess", true);
			json.put("id", id);
			json.put("name", name);

		}
		response.getWriter().print(json);
	}
}
