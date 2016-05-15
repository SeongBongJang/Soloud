package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.soloud.app.man.MemberManager;
import com.soloud.app.manInt.MemberDropable;
import com.soloud.app.manInt.MemberInfoModifiable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.Member;
import com.soloud.pre.uiform.MemberManageForm;
import com.soloud.pre.validator.MemberManageValidator;
import com.soloud.util.CheckURI;

/**
 * Servlet implementation class MemberManageServlet2
 */
@WebServlet({ "/dropOut.do", "/profileModify.do", "/loadProfile.do", "/profileModifyResult.do", "/dropOutGo.do" })
public class MemberManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		System.out.println(action + "^^");
		if(action.equals("loadProfile.do"))
		{
			loadInfo(request);
			RequestDispatcher view = request.getRequestDispatcher("/jsp/profileSetting.jsp");
			view.forward(request, response);
		}
		else if(action.equals("dropOut.do"))
		{
			
			RequestDispatcher view = request.getRequestDispatcher("/jsp/dropOut.jsp");
			view.forward(request, response);
			
		}
		else if(action.equals("dropOutGo.do"))
		{
			MemberDropable md = new MemberManager();
			boolean res=md.dropMember((String) request.getSession().getAttribute("memberCode"));
			if(res)
			{
				response.sendRedirect("/Soloud");
			}
			else
			{
				//시스템상의 이유ㅜ로...탈퇴 실패시...
				System.out.println("탈퇴실패...");
			}
			
		}
		
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		
		String action = CheckURI.getLastURI(request.getRequestURL()); 
		JSONObject json = new JSONObject();
		PrintWriter writer = response.getWriter();
		System.out.println(action + "^^");
		if(action.equals("profileModify.do"))
		{
			//request.getParameter("abc");
			
			String first=request.getParameter("first");
			String last = request.getParameter("last");
			String pass=request.getParameter("pass");
			String rePass=request.getParameter("rePass");
			
			MemberManageForm form = new MemberManageForm();
			form.setNewName(last+first);
			
			
			//System.out.println(pass + first+pass+rePass);
			
			form.setNewPassword(pass);
			form.setNewRepassword(rePass);
			
			MemberManageValidator val = new MemberManageValidator();
			val.validateModify(form);
			
			
			List<String> errList = val.getErrors();
			System.out.println(errList);
			String errLog=errList.toString();
			
			if(errList.size()==0)
			{
				MemberInfoModifiable mif = new MemberManager();
				
				Member m = new Member();
				
				m.setId((String) request.getSession().getAttribute("memberCode"));
				m.setName(form.getNewName());
				m.setPassword(form.getNewPassword());
				
				boolean res=mif.modifyMemberInfo(m);
				
				if(res)
				{
					json.put("isSuccess", true);
					json.put("result", "수정에 성공했습니다");
					writer.print(json);
					System.out.println("수정성공");
					//response.sendRedirect("/Soloud");
				}
				else
				{
					//시스템 상의..이유로...수정 실패..
					System.out.println("수정실패");
				}
				
			}
			else if(errList.size() > 1)
			{
				json.put("isSuccess", false);
				json.put("result", errLog);
				writer.print(json);
				System.out.println("수정실패");
			}
		}
		else if(action.equals("profileModifyResult.do"))
		{
			response.sendRedirect("/Soloud/jsp/memberMain.jsp");
		}
	}
	/**
	 * 
	 * @param request
	 */
	private void loadInfo(HttpServletRequest request) 
	{
		MemberSearchable ms = new MemberManager();
		
		Member t = ms.searchMemberCode((String) request.getSession().getAttribute("memberCode"));
		
		
		request.setAttribute("name", t.getName());
		request.setAttribute("email", t.getId());
		
		
		System.out.println("불러옴");
	}

}
