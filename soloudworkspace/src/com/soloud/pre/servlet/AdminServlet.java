package com.soloud.pre.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soloud.util.CheckURI;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name="AdminServlet", urlPatterns={"/reEnter.do"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("여기는 새로만든 서블릿");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = CheckURI.getLastURI(request.getRequestURL());
		String dispatchUrl = null;
		if(action.equals("reEnter.do")){
			dispatchUrl = "/jsp/adminSearchFile.jsp";
		}
		request.getRequestDispatcher(dispatchUrl).forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
