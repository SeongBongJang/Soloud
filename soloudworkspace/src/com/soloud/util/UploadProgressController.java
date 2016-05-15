package com.soloud.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadProgressController {

	//파일업로드 상태를 가져온다.
		@RequestMapping("/uploadStatus.go")
		public ModelAndView getFileUploadStatus(HttpServletRequest request, HttpServletResponse response, HttpSession session){
			ModelAndView mav = new ModelAndView();
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "no-cache");
			try{
				request.setCharacterEncoding("UTF-8");
			}
			catch(Exception e){
			}
			
			int percent = 0;	  //업로드 percent
			long bytesRead = 0;  //읽어들인 바이트
			long contentLength = 0;  //전체 바이트
			double kbps = 0;
			if(session==null){
				percent = 0;
				bytesRead = 0;
				contentLength = 0;
				kbps = 0;
			}else{
				percent = (Integer)session.getAttribute("percent");
				bytesRead = (Long)session.getAttribute("bytesread");
				contentLength = (Long)session.getAttribute("contentlength");
				kbps = (Double)session.getAttribute("kbps");
			}
			
			mav.addObject("percent", percent);
			mav.addObject("bytesread", bytesRead);
			mav.addObject("contentlength", contentLength);
			mav.addObject("kbps", kbps);
			
			mav.setViewName("JSON");	
			return mav;
		}
}
