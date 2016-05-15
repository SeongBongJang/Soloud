package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.soloud.app.man.MemberManager;
import com.soloud.app.manInt.MemberJoinable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.Member;
import com.soloud.pre.uiform.JoinForm;
import com.soloud.pre.validator.JoinValidator;
import com.soloud.util.CheckURI;

/**
 * Servlet implementation class JoinServlet
 */
/**
 * 회원가입을 담당하는 서블릿
 * @author 영진
 *
 */
@WebServlet(name="JoinServlet", urlPatterns={"/join_first", "/join_check", "/join_complete", "/join_completion", "/join_bye"})
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * 회원가입 완료 안내페이지와 회원가입 양식 페이지를 로드함
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = CheckURI.getLastURI(request.getRequestURL());
		if(url.equals("join_bye")){
			response.sendRedirect("/Soloud");
			request.getSession().invalidate();
		}
		else if(url.equals("join_first")){
			request.getRequestDispatcher("/jsp/join.jsp").forward(request, response);
		}		
	}

	/**
	 * 이메일 중복여부 확인(비동기) / 회원가입 유효성 체크(비동기) / 회원가입 성공 페이지 로드 로 나뉜다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String url = CheckURI.getLastURI(request.getRequestURL());

		// 이메일 중복확인
		if(url.equals("join_check")){
			idDupCheck(request, response);
		}
		// 회원가입 요청 (유효성 검사)
		else if(url.equals("join_complete")){
			joinCheck(request, response);
		}
		//회원가입 성공
		else if(url.equals("join_completion")){
			joinPass(request, response);
		}
	}
	/**
	 * 이메일 중복여부 확인 메소드로 입력한 이메일의 형식이나 중복여부가 옳을 때<br> true값을 전송하여 회원가입 요청을 할 수 있게 사용자에게 루트를 열어준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void idDupCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		JSONObject jobj = new JSONObject();
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		String domain = request.getParameter("domain");
		String state = request.getParameter("state");
		
		System.out.println("중복체크들어옴");
		System.out.println(id+"  " + domain + "을 중복체크함 ^^" + state);
		
		if(state.trim().equals("true"))	//유효성검사가 끝난 상태에서 다시 중복 체크를 할때
		{
			jobj.put("result", false);
			jobj.put("resultMsg", "중복 체크 처리가 완료되었습니다. 회원가입을 눌러주세요");
			writer.print(jobj);
			return;
		}
		
		JoinValidator validator = new JoinValidator();
		validator.validateDup(new JoinForm(id, domain, "", "", ""));
		
		
		//에러가있을경우
		if(validator.getErrors().size()>0)
		{
			System.out.println("유효성에러잇음");
			jobj.put("result", false);
			jobj.put("resultMsg", validator.getErrors().get(0));
			writer.print(jobj);
		}
		
		//유효성 에러가 없을 경우
		else
		{
			System.out.println("유효성에러없음");
			MemberSearchable ms = new MemberManager();
			Member m = ms.searchMemberId(id+"@"+domain);
			System.out.println(id+"@"+domain);
			if(m.getId()==null)
			{
				request.getSession().setAttribute("email", id+"@"+domain);
				
				jobj.put("result", true);
				jobj.put("resultMsg", "가입 가능한 ID입니다. 나머지 정보를 입력해주세요 ");
				writer.print(jobj);
			}
			else
			{
				jobj.put("result", false);
				jobj.put("resultMsg", "중복되는 아이디입니다. 다른 아이디를 입력해주세요");
				writer.print(jobj);
			}
		}
	}
	/**
	 * 회원가입 정보 유효성체크 메소드로 모든 정보를 입력했는지와 <br>글자수에 맞게 입력했는지는 판별하고 비동기 처리로 결과를 알려준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void joinCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		JSONObject jobj = new JSONObject();
		PrintWriter writer = response.getWriter();
		
		String id = request.getParameter("id");
		String domain = request.getParameter("domain");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("confirm_password");
		String email = (String) request.getSession().getAttribute("email");
		
	
		//System.out.println("입력한 아디 : " + id );
		//System.out.println("도메인: " + domain );
		System.out.println("이메일 : " + email);
		System.out.println("이름: " + name );
		System.out.println("패스워드: " + password );
		System.out.println("패스워드확인: " + rePassword );
		
		
		
		JoinValidator validator = new JoinValidator();
		validator.validateJoin(new JoinForm(id, domain, name, password, rePassword));
		
		if(validator.getErrors().size()>0)
		{
			jobj.put("result", true);
			jobj.put("resultMsg", validator.getErrors().get(0));
			writer.print(jobj);
		}
		else
		{
			jobj.put("result", true);
			jobj.put("resultMsg", "유효성 검증 성공");
			writer.print(jobj);
		}
	}
	/**
	 * 회원가입 유효성 체크가 성공했을 때 다시 완료요청을 받는 메소드로 회원정보를 DB에 등록하고 완료페이지를 로드한다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void joinPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		
		//String domain2 = request.getParameter("domain2");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//String rePassword = request.getParameter("confirm_password");
		
		request.setAttribute("id", email);
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY년-MM월-dd일");
		String date = format.format(new GregorianCalendar().getTime());			
		request.setAttribute("date", date);
		
		System.out.println("회원가입합니다");
		
		Member m = new Member();
		m.setCapacityLimit(10485760f);	//10메가 바이트
		m.setId(email);
		m.setName(name);
		m.setPassword(password);
		m.setUsedCapacity(0);
		
		
		MemberJoinable mj = new MemberManager();
		
		mj.joinMember(m);
	
		
		
		
		
		request.getRequestDispatcher("/jsp/joinCompletion.jsp").forward(request, response);
	}
}
