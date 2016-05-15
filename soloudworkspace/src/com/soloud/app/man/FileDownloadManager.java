package com.soloud.app.man;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class FileDownloadManager {

	@RequestMapping(value="fileDownloadAjax.go")
	public ModelAndView fileDownloadAjax(HttpServletRequest request, @RequestParam("index")String index) {
		
		HttpSession session = request.getSession();
		
		// ���� ������� ����ڵ�
		String memberCode = (String)session.getAttribute("memberCode");
		System.out.println(memberCode);
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ���� �ٿ�ε� ��û�� �����ڵ�
		String fileCode = file_table.get(Integer.parseInt(index));
		
		return new ModelAndView("DownView", "downloadFile", fileCode);
	}
	@RequestMapping(value="decFolderLink.do/fileDownloadAjax.go/*")
	public ModelAndView linkFileDownloadAjax(HttpServletRequest request, @RequestParam("index")String index) {
		
		HttpSession session = request.getSession();
		
		// ���� ������� ����ڵ�
		String memberCode = (String)session.getAttribute("memberCode");
		System.out.println(memberCode);
		
		// ���� ������� ���ϸ�Ͽ� �ε�� ���ϵ��� �ڵ�
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// ���� �ٿ�ε� ��û�� �����ڵ�
		String fileCode = file_table.get(Integer.parseInt(index));
		
		return new ModelAndView("DownView", "downloadFile", fileCode);
	}
}
