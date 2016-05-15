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
 * ȸ�������� ����ϴ� ����
 * @author ����
 *
 */
@WebServlet(name="JoinServlet", urlPatterns={"/join_first", "/join_check", "/join_complete", "/join_completion", "/join_bye"})
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * ȸ������ �Ϸ� �ȳ��������� ȸ������ ��� �������� �ε���
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
	 * �̸��� �ߺ����� Ȯ��(�񵿱�) / ȸ������ ��ȿ�� üũ(�񵿱�) / ȸ������ ���� ������ �ε� �� ������.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String url = CheckURI.getLastURI(request.getRequestURL());

		// �̸��� �ߺ�Ȯ��
		if(url.equals("join_check")){
			idDupCheck(request, response);
		}
		// ȸ������ ��û (��ȿ�� �˻�)
		else if(url.equals("join_complete")){
			joinCheck(request, response);
		}
		//ȸ������ ����
		else if(url.equals("join_completion")){
			joinPass(request, response);
		}
	}
	/**
	 * �̸��� �ߺ����� Ȯ�� �޼ҵ�� �Է��� �̸����� �����̳� �ߺ����ΰ� ���� ��<br> true���� �����Ͽ� ȸ������ ��û�� �� �� �ְ� ����ڿ��� ��Ʈ�� �����ش�.
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
		
		System.out.println("�ߺ�üũ����");
		System.out.println(id+"  " + domain + "�� �ߺ�üũ�� ^^" + state);
		
		if(state.trim().equals("true"))	//��ȿ���˻簡 ���� ���¿��� �ٽ� �ߺ� üũ�� �Ҷ�
		{
			jobj.put("result", false);
			jobj.put("resultMsg", "�ߺ� üũ ó���� �Ϸ�Ǿ����ϴ�. ȸ�������� �����ּ���");
			writer.print(jobj);
			return;
		}
		
		JoinValidator validator = new JoinValidator();
		validator.validateDup(new JoinForm(id, domain, "", "", ""));
		
		
		//�������������
		if(validator.getErrors().size()>0)
		{
			System.out.println("��ȿ����������");
			jobj.put("result", false);
			jobj.put("resultMsg", validator.getErrors().get(0));
			writer.print(jobj);
		}
		
		//��ȿ�� ������ ���� ���
		else
		{
			System.out.println("��ȿ����������");
			MemberSearchable ms = new MemberManager();
			Member m = ms.searchMemberId(id+"@"+domain);
			System.out.println(id+"@"+domain);
			if(m.getId()==null)
			{
				request.getSession().setAttribute("email", id+"@"+domain);
				
				jobj.put("result", true);
				jobj.put("resultMsg", "���� ������ ID�Դϴ�. ������ ������ �Է����ּ��� ");
				writer.print(jobj);
			}
			else
			{
				jobj.put("result", false);
				jobj.put("resultMsg", "�ߺ��Ǵ� ���̵��Դϴ�. �ٸ� ���̵� �Է����ּ���");
				writer.print(jobj);
			}
		}
	}
	/**
	 * ȸ������ ���� ��ȿ��üũ �޼ҵ�� ��� ������ �Է��ߴ����� <br>���ڼ��� �°� �Է��ߴ����� �Ǻ��ϰ� �񵿱� ó���� ����� �˷��ش�.
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
		
	
		//System.out.println("�Է��� �Ƶ� : " + id );
		//System.out.println("������: " + domain );
		System.out.println("�̸��� : " + email);
		System.out.println("�̸�: " + name );
		System.out.println("�н�����: " + password );
		System.out.println("�н�����Ȯ��: " + rePassword );
		
		
		
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
			jobj.put("resultMsg", "��ȿ�� ���� ����");
			writer.print(jobj);
		}
	}
	/**
	 * ȸ������ ��ȿ�� üũ�� �������� �� �ٽ� �Ϸ��û�� �޴� �޼ҵ�� ȸ�������� DB�� ����ϰ� �Ϸ��������� �ε��Ѵ�.
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
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY��-MM��-dd��");
		String date = format.format(new GregorianCalendar().getTime());			
		request.setAttribute("date", date);
		
		System.out.println("ȸ�������մϴ�");
		
		Member m = new Member();
		m.setCapacityLimit(10485760f);	//10�ް� ����Ʈ
		m.setId(email);
		m.setName(name);
		m.setPassword(password);
		m.setUsedCapacity(0);
		
		
		MemberJoinable mj = new MemberManager();
		
		mj.joinMember(m);
	
		
		
		
		
		request.getRequestDispatcher("/jsp/joinCompletion.jsp").forward(request, response);
	}
}
