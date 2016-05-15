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
		
		// 현재 사용자의 멤버코드
		String memberCode = (String)session.getAttribute("memberCode");
		System.out.println(memberCode);
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 현재 다운로드 요청된 파일코드
		String fileCode = file_table.get(Integer.parseInt(index));
		
		return new ModelAndView("DownView", "downloadFile", fileCode);
	}
	@RequestMapping(value="decFolderLink.do/fileDownloadAjax.go/*")
	public ModelAndView linkFileDownloadAjax(HttpServletRequest request, @RequestParam("index")String index) {
		
		HttpSession session = request.getSession();
		
		// 현재 사용자의 멤버코드
		String memberCode = (String)session.getAttribute("memberCode");
		System.out.println(memberCode);
		
		// 현재 사용자의 파일목록에 로드된 파일들의 코드
		ArrayList<String> file_table = (ArrayList<String>)session.getAttribute("file_table");
		
		// 현재 다운로드 요청된 파일코드
		String fileCode = file_table.get(Integer.parseInt(index));
		
		return new ModelAndView("DownView", "downloadFile", fileCode);
	}
}
