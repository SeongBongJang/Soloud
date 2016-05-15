package com.soloud.app.man;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.Member;
@Controller
public class FileUploadManager {

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping(value="fileUploadAjax.go", method=RequestMethod.POST)
	public ModelAndView fileUploadAjax(MultipartHttpServletRequest mRequest) {

		ModelAndView mav = new ModelAndView();
		
		String res = fileUploadService.fileUpload(mRequest);
		if(res.equals("성공")) {
			mav.addObject("result", "SUCCESS");
		} 
		else if(res.equals("중복")){
			mav.addObject("result", "DUP");
		}
		else if(res.equals("루트")){
			mav.addObject("result", "ROOT");
		}
		else{
			mav.addObject("result", "FAIL");
		}
		ArrayList<String> list = (ArrayList<String>)mRequest.getAttribute("name");
		ArrayList<String> list2 = (ArrayList<String>)mRequest.getAttribute("type");
		ArrayList<String> list3 = (ArrayList<String>)mRequest.getAttribute("time");
		
		mav.addObject("size", list.size());  
		mav.addObject("fileName", list); 
		mav.addObject("fileType", list2);
		mav.addObject("time", list3);
		
		// 파일을 삭제하고 최신화 된 개인용량
		loadCapacity(mRequest);
		String maxCapacity = (String)mRequest.getAttribute("maxCapacity");
		String usedCapacity = (String)mRequest.getAttribute("usedCapacity");
		float maxC = (float)mRequest.getAttribute("maxC");
		float usedC = (float)mRequest.getAttribute("usedC");
		
		mav.addObject("maxCapacity", maxCapacity);
		mav.addObject("usedCapacity", usedCapacity);
		mav.addObject("maxC", maxC);
		mav.addObject("usedC", usedC);
		
		mav.setViewName("JSON");
		
		return mav;
	}
	private void loadCapacity(HttpServletRequest request){
		MemberSearchable ms = new MemberManager();
		System.out.println(request.getSession().getAttribute("memberCode"));
		
		Member m = ms.searchMemberCode((String) request.getSession().getAttribute("memberCode"));

		DecimalFormat df = new DecimalFormat("0.00");
		String max = null;
		String used = null;
		
		// 최대 용량 제한
		float capacity = m.getCapacityLimit();	
		request.setAttribute("maxC", capacity);
		if(capacity>1048575f){
			capacity = (float)(capacity/1024f/1024f);  // 메가바이트 단위
			capacity = Float.parseFloat(df.format(capacity));
			max = capacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // 킬로바이트 단위
			capacity = (float)(capacity/1024d);
			capacity = Float.parseFloat(df.format(capacity));
			max = capacity+"KB";
		}
		else{
			max = "1KB";
		}
		
		// 현재 사용량
		capacity = m.getUsedCapacity();	
		request.setAttribute("usedC", capacity);
		if(capacity>1048575f){
			capacity = (float)(capacity/1024f/1024f);  // 메가바이트 단위
			capacity = Float.parseFloat(df.format(capacity));
			used = capacity+"MB";
		}
		else if(capacity>1023d && capacity<=1048575d){ // 킬로바이트 단위
			capacity = (float)(capacity/1024d);
			capacity = Float.parseFloat(df.format(capacity));
			used = capacity+"KB";
		}
		else{
			used = "1KB";
		}
		
		request.setAttribute("maxCapacity", max);
		request.setAttribute("usedCapacity", used);
		System.out.println(max + "  " + used);
	}
}
