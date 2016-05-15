package com.soloud.pre.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.soloud.app.man.FolderManager;
import com.soloud.app.man.MemberManager;
import com.soloud.app.man.SharedFolderManager;
import com.soloud.app.manInt.FolderCreateable;
import com.soloud.app.manInt.FolderDelable;
import com.soloud.app.manInt.FolderNameModifiable;
import com.soloud.app.manInt.FolderPathModifiable;
import com.soloud.app.manInt.FolderSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.manInt.SharedFolderCreatable;
import com.soloud.app.manInt.SharedFolderSearchable;
import com.soloud.app.model.Folder;
import com.soloud.app.model.Member;
import com.soloud.app.model.SharedFolder;
import com.soloud.per.dto.SharedFriendVDTO;
import com.soloud.pre.uiform.FolderManageForm;
import com.soloud.pre.validator.FolderManageValidator;
import com.soloud.util.CheckURI;
import com.soloud.util.MakeTree;

/**
 * Servlet implementation class FolderManagerServlet
 */
@WebServlet({"/makeFolder.do", "/deleteFolder.do", "/modifyFolder.do", "/dynamicTree3.do/*", "/moveFolder.do", "/dynamicTree4.do/*"})
public class FolderManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String url = CheckURI.getLastURI(request.getRequestURL());
		System.out.println(url);
		if(url.equals("makeFolder.do"))
		{
		//	System.out.println("들어옴^^");
			addFolder(request, response);
		}
		else if(url.equals("deleteFolder.do"))
		{
			
			deleteFolder(request, response);
		}
		else if(url.equals("modifyFolder.do"))
		{
			modifyFolderName(request, response);
		}
		//특정 폴더코드를 빼고 제이손 데이터 보내기위함...
		else if(url.startsWith("fo"))
		{
			loadTree(request, response, url);
			return;
		}
		else if(url.startsWith("sfo"))
		{
			loadTree2(request, response, url);
			return;
		}
		else if(url.equals("moveFolder.do"))
		{
			modifyFolderPath(request, response);
			return;
		}
	}
	


	/**
	 * 폴더를 추가할 때 호출 되는 메소드로 비동기처리로 결과를 알려줌
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addFolder(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		JSONObject json = new JSONObject();
		FolderSearchable fc = new FolderManager();
		
		String folderName = request.getParameter("foldName");
		String parentFolderCode = request.getParameter("parentFolderCode");
		String isSharedFolder = request.getParameter("isSharedFolder");
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		
		FolderManageValidator valid= new FolderManageValidator();
		FolderManageForm form = new FolderManageForm();
		form.setFolderName(folderName);
		
		
		//유효성 검사부분
		valid.validateAdd(form);
		List<String> errorList = valid.getErrors();
		
		

		//해당 부모 폴더내에서 이미 같은 이름의 폴더가 존재하는지 검사하는 부분
		List<Folder> tList = fc.searchFolderIdParent(memberCode, parentFolderCode);
		for(Folder folder : tList)
		{
			if(folder.getFolderName().equals(folderName))
			{
				errorList.add("폴더 이름이 중복됩니다. 다른 이름을 입력해주세요");
				System.out.println("중복됨^^");
			}
		}
		
		
		if(errorList.size()==0)
		{
			boolean res=false;
			//추가하려는 폴더가 내가 호스트인 폴더인지 검사하는 부분
			Folder fff = fc.searchFolder_REAL3(parentFolderCode);
			String memberCode2 = fff.getFolderPath(); 	//사실은 검색한 폴더의 소유자 멤버코드임
		//	String parentFolderCode2 = fff.getParentFolderCode();
			System.out.println("선택한 폴더 소유자 멤버코드 : " + memberCode2);
			System.out.println("선택한 폴더의 코드 : " + parentFolderCode);
			FolderSearchable fs = (FolderSearchable)fc;
			List<Folder> folderList = null;
			
			
			if(!memberCode2.equals(memberCode))		//만약 추가하려는 폴더가 내가 소유자인 폴더가 아니라면 상대코드를 호스트로해서 폴더를 추가해야됨
			{
				//즉 공유폴더에 내가 호스트이름으로 추가해야됨
				res = ((FolderCreateable) fc).createFolder_REAL(memberCode2, folderName, parentFolderCode, isSharedFolder);
				if(res)
				{
					folderList = fs.searchFolder(memberCode2);
				}
				//만약에 실패하면..
				else
				{
					System.out.println("시스템상의 문제로 실패했어요~ 잠시후 다시 시도해주세요~");
				}
			}
			else
			{
				//일반폴더에 내가 내이름으로 폴더를 추가함
				res = ((FolderCreateable) fc).createFolder_REAL(memberCode, folderName, parentFolderCode, isSharedFolder);
				if(res)
				{
					folderList = fs.searchFolder(memberCode);
				}
				//만약에 실패하면..
				else
				{
					System.out.println("시스템상의 문제로 실패했어요~ 잠시후 다시 시도해주세요~");
				}
				
			}
			
			
			List<Integer> folderCodeList = new ArrayList<Integer>();
			
			for(Folder f : folderList)
			{
				folderCodeList.add(Integer.parseInt(f.getFolderCode().trim().substring(2)));
			}
			
			Object[] t = folderCodeList.toArray();
			
			Arrays.sort(t);
		
			
			//만약 속성ㅇ ㅣ 공유라면 방금 추가한 폴더에대해서  
			//부모폴더의 접근가능 친구목록 속성을 그대로 상속해줘야함
			if(isSharedFolder.trim().equals("공유"))
			{
				addAFF(parentFolderCode, "fo" + t[t.length-1]);	//parentFolderCode의 접근가능 친구목록속성을  
																//folderCode에 해당하는 sharedFolderCode에 대해 친구목록 속성을
																//그대로 추가해주어야 한다.
			}
			
			json.put("result", true);
			json.put("nextCode", "fo" + t[t.length-1]);
			response.getWriter().print(json);
			
			System.out.println("성공했삼");
		
	
			
		}
		//이름 유효성 걸림
		else
		{
			json.put("result", false);
			json.put("resultMsg", errorList);
			response.getWriter().print(json);

		}
		
	}
	
	private void addAFF(String parentFolderCode, String folderCode) 
	{
		// TODO Auto-generated method stub
		FolderSearchable fs = new FolderManager();
		SharedFolderSearchable sfs = new SharedFolderManager();
		
		//추가하려는 폴더의 접근가능 친구목록 코드를 가져옴
		Folder f = fs.searchFolder_REAL3(parentFolderCode);		//일단 그 폴더의 정보를 가져옴
		SharedFolder sf = sfs.searchSharedFolderCode(f.getFolderCode());	//그 폴더의 공유 폴더 코드를 가져옴
		String sfCode = sf.getSharedFolderCode().trim();							
		
		List<SharedFriendVDTO> dtoList = sfs.searchShareFriend(sfCode);	//부모 폴더코드에 대해서 접근 가능한 프렌드 코드를 다가져옴
		List<String> friendCodeList = new ArrayList<String>();
		
		//접근 가능 친구 코드 다가져옴
		for(SharedFriendVDTO dto : dtoList)
		{
			friendCodeList.add(dto.getFriendCode());
		}
		
		//그 친구코드를 새로 만든 폴더코드의 공유폴더코드에 대해서 추가해줌
		
		//일단 새로만든 폴더코드로 공유폴더코드를 찾아옴
		String sf2 = sfs.searchSharedFolderCode(folderCode).getSharedFolderCode().trim();
		
		
		//그 공유폴더코드에 접근가능 친구를 추가해줌
		SharedFolderCreatable sfc = new SharedFolderManager();
		boolean res = false;
		int successCount=0;
		int falseCount=0;
		for(String frCode : friendCodeList)
		{
			res = sfc.createSharedFolderAuthFriend(frCode, sf2);
			if(res)
			{
				successCount++;
			}
			else
			{
				falseCount++;
			}
		}
		
		System.out.println("인풋 성공 갯수 : " + successCount);
		System.out.println("인풋 실패 갯수 : " + falseCount);
		
		
		
	}

	/**
	 * 폴더명을 수정할 때 호출 되는 메소드로 비동기처리로 결과를 알려줌
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void modifyFolderName(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		JSONObject json = new JSONObject();
		String folderCode = request.getParameter("folderCode");
		String folderName = request.getParameter("foldName");
		FolderSearchable fc = new FolderManager();
		
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		FolderManageValidator valid= new FolderManageValidator();
		FolderManageForm form = new FolderManageForm();
		form.setFolderName(folderName);
		
		
		//유효성 검사부분
		valid.validateAdd(form);
		List<String> errorList = valid.getErrors();
		
		

		//해당 부모 폴더내에서 이미 같은 이름의 폴더가 존재하는지 검사하는 부분
		List<Folder> f = fc.searchFolder_REAL1(memberCode, folderName);
		String parentFolderCode=null;
		if(f.size()==0)
		{
			
		}
		else
		{
			Folder ff= f.get(0);
			System.out.println(ff);
			parentFolderCode = ff.getParentFolderCode();
		}
		
		
		
		List<Folder> tList = fc.searchFolderIdParent(memberCode, parentFolderCode);
		for(Folder folder : tList)
		{
			if(folder.getFolderName().equals(folderName))
			{
				errorList.add("폴더 이름이 중복됩니다. 다른 이름을 입력해주세요");
				System.out.println("중복됨^^");
			}
		}
		
		
		if(errorList.size()==0)
		{
			//System.out.println(folderCode +  "  " + folderName);
			FolderNameModifiable fnm = new FolderManager();
			boolean res = fnm.modifyFolderName_REAL(folderCode,  folderName);
			if(res)
			{
				json.put("result", true);
				
			}
			//시스템 오류 시..
			else
			{
				json.put("result", false);
				json.put("resultMsg", "시스템에 잠시 문제가 발생했습니다. 잠시 후 다시 시도해주세요");
			}
			response.getWriter().print(json);
		}
		// 유효성검사 실패 시..
		else
		{
			json.put("result", false);
			json.put("resultMsg", errorList);
			response.getWriter().print(json);
		}
	}
	/**
	 * 폴더 경로를 수정할 때 호출 되는 메소드로 비동기처리로 결과를 알려줌
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void modifyFolderPath(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		String destFolderCode = request.getParameter("dest");
		String startFolderCode = request.getParameter("start");
		JSONObject json = new JSONObject();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		
		
		
		
		//옮기려는 폴더내에서 이미 같은 이름의 폴더가 존재하는지 검사하는 부분

		FolderSearchable fs = new FolderManager();
		List<Folder> fList = fs.searchFolderIdParent(memberCode, destFolderCode);	//옮기는 폴더의 자식 폴더리스트
		Folder fo = fs.searchFolder_REAL3(startFolderCode);	
		String startFolderName = fo.getFolderName().trim();		//옮기려는 폴더의 이름
		
		
		for(Folder f : fList)
		{
			//옮기려는 폴더의 자식 폴더 목록에 내가 옮길라는 폴더와 이름이 같은 폴더가 있다면
			if(f.getFolderName().trim().equals(startFolderName))
			{
				json.put("result", false);
				json.put("resultMsg", "Folder Move Failed!! FolderName is duplicated!!");
				response.getWriter().print(json);
				return;
			}
		}
		
		
		
		System.out.println(destFolderCode + "  " + startFolderCode);
		FolderPathModifiable fpm = new FolderManager();
		boolean res = fpm.modifyFolderPath_REAL(startFolderCode, destFolderCode);
		if(res)
		{
			json.put("result", true);
			json.put("resultMsg", "Folder Move Success!!");
		}
		else
		{
			json.put("result", false);
			json.put("resultMsg", "Folder Move Failed!!");
		}
		response.getWriter().print(json);
	}
	/**
	 * 폴더를 삭제할 때 호출 되는 메소드로 비동기처리로 결과를 알려줌
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void deleteFolder(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		/*
		FolderSearchable fc = new FolderManager();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		boolean res=false;
		//추가하려는 폴더가 내가 호스트인 폴더인지 검사하는 부분
		Folder fff = fc.searchFolder_REAL3(parentFolderCode);
		String memberCode2 = fff.getFolderPath(); 	//사실은 검색한 폴더의 소유자 멤버코드임
		if(!memberCode2.equals(memberCode))		//만약 추가하려는 폴더가 내가 소유자인 폴더가 아니라면 상대코드를 호스트로해서 폴더를 추가해야됨
		{
			//즉 공유폴더에 내가 호스트이름으로 추가해야됨
			res = ((FolderCreateable) fc).createFolder_REAL(memberCode2, folderName, parentFolderCode, isSharedFolder);
		}	
		*/
		
		String folderCode= request.getParameter("folderCode");
		int count=0;
		
		JSONObject json = new JSONObject();
		//String memberCode = (String) request.getSession().getAttribute("memberCode");
		FolderSearchable fs = new FolderManager();
		
		Folder f2 = (Folder) fs.searchFolder_REAL3(folderCode);
		
		if(f2.getParentFolderCode().trim().equals("root"))
		{
			json.put("result", false);
			json.put("resultMsg", "Root Folder Can't be removed!");
			response.getWriter().print(json);
			return;
		}
		
		deleteFolder(request, folderCode, count);
		loadCapacity(request, response);
		
	}
	
	//폴더코드에 대해 모든 자식 폴더를 삭제하는 recursive Method
	private void deleteFolder(HttpServletRequest request, String folderCode, int count)
	{
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		FolderSearchable fs = new FolderManager();
		
		
		List<Folder> folderList =  fs.searchFolderIdParent(memberCode, folderCode);
	
		
		
		FolderDelable fd = (FolderDelable) fs;
		for(Folder f : folderList)
		{
			
			deleteFolder(request, f.getFolderCode(), count);
		}
		fd.deleteFolder_REAL(folderCode);
		System.out.println("삭제함 : " + folderCode);
		//System.out.println("호출!");
	}
	/**
	 * 폴더를 복사할 때 호출 되는 메소드로 비동기처리로 결과를 알려줌
	 * @param request
	 * @param response
	 */
	private void copyPasteFolder(HttpServletRequest request, HttpServletResponse response) {
	
	}
	/**
	 * 사용자의 트리구조를 비동기로 로드하는 메소드
	 * @param request
	 * @throws IOException 
	 */
	private void loadTree(HttpServletRequest request, HttpServletResponse response, String folderCode) throws IOException 
	{
		//인자로 받은 폴더코드에 대한 폴더와 그 하위폴더를 제외한 폴더트리를 만듬
		PrintWriter writer = response.getWriter();
		JSONArray jarr = new JSONArray();
		FolderSearchable fs = new FolderManager();
		List<Folder> folderList1 = fs.searchFolder_REAL2((String) request.getSession().getAttribute("memberCode"), "일반");

		for(Folder fo : folderList1)
		{
			if(fo.getParentFolderCode()==null || fo.getFolderCode().trim().equals(folderCode))
			{
				continue;
			}
			else
			{
				JSONObject json = new JSONObject();
				json.put("data", fo.getFolderName());
				json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
				json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
				//System.out.println(json + "^^");
				jarr.add(json);
			}
		}
		
		//System.out.println("라이팅!");
		MakeTree mk = new MakeTree(jarr);
		//System.out.println(mk.createTreeGo().toString());
		
		
		writer.print(mk.createTreeGo().toString());
		//writer.flush();
	}
	
	private void loadTree2(HttpServletRequest request, HttpServletResponse response, String folderCode2) throws IOException
	{
		String folderCode = folderCode2.substring(1);
		System.out.println("선택한 폴더코드 : " + folderCode);
		PrintWriter writer = response.getWriter();
		JSONArray jarr = new JSONArray();
		FolderSearchable fs = new FolderManager();
		
		
		//클릭한 폴더의 최상위 루트  폴더부터 클릭한 폴더를 제외하고 보여줘야함!~!!!!!
		//클릭한 폴더의 주인이 누구인지 알아야함!
		FolderSearchable fc = new FolderManager();
		String memberCode = (String) request.getSession().getAttribute("memberCode");
		//boolean res=false;
		//이동하려는 폴더가 내가 호스트인 폴더인지 검사하는 부분
		Folder fff = fc.searchFolder_REAL3(folderCode);
		String memberCode2 = fff.getFolderPath().trim(); 	//사실은 검색한 폴더의 소유자 멤버코드임
		System.out.println("해당폴더 소유자코드 : " + memberCode2);
		
		if(!memberCode2.equals(memberCode))		//만약이동하려는 폴더가 내가 호스트인 공유폴더 리스트가 아니라면!
		{
			System.out.println("내께아님");
			//즉 그 호스트의 루트 폴더리스트를 목록에 보여줘야함
			List<Folder> folderList1 = fs.searchFolder_REAL2(memberCode2, "공유");
			for(Folder fo : folderList1)
			{
				if(fo.getParentFolderCode()==null || fo.getFolderCode().trim().equals(folderCode))
				{
					continue;
				}
				else
				{
					JSONObject json = new JSONObject();
					json.put("data", fo.getFolderName());
					json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
					json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
					System.out.println(json + "^^");
					jarr.add(json);
				}
			}
		}	
		//즉 자기 자신의 폴더를 선택했다면
		else
		{	
			System.out.println("내꺼임");
			List<Folder> folderList1 = fs.searchFolder_REAL2(memberCode, "공유");
			//자신이 호스트인 공유폴더에 대해서 추가하는부분
			for(Folder fo : folderList1)
			{
				if(fo.getParentFolderCode()==null || fo.getFolderCode().trim().equals(folderCode))
				{
					continue;
				}
				else
				{
					JSONObject json = new JSONObject();
					json.put("data", fo.getFolderName());
					json.put("attr", "{'id':'"+ fo.getFolderCode().trim() + "'}");
					json.put("parentId", "{'id':'"+ fo.getParentFolderCode().trim() + "'}");
					System.out.println(json + "^^");
					jarr.add(json);
				}
			}
		}
		
		
		
		//System.out.println("라이팅!");
		MakeTree mk = new MakeTree(jarr);
		//System.out.println(mk.createTreeGo().toString());
		
		
		writer.print(mk.createTreeGo().toString());
		
		
	}
	
	/**
	 * 사용자의 개인용량을 비동기롤 로드하는 메소드
	 * @param request
	 * @throws IOException 
	 */
	private void loadCapacity(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		//용량 최신화 시켜줄 코드 부분
				MemberSearchable ms = new MemberManager();
				System.out.println(request.getSession().getAttribute("memberCode"));
				
				Member m = ms.searchMemberCode((String) request.getSession().getAttribute("memberCode"));

				DecimalFormat df = new DecimalFormat("0.00");
				String max = null;
				String used = null;
				
				
				
				
				// 최대 용량 제한
				float capacity = m.getCapacityLimit();	
				//request.setAttribute("maxC", capacity);
				float val1=capacity;
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
				//request.setAttribute("usedC", capacity);
				float val2=capacity;
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
				
				
				String val3=max;
				String val4=used;
				
				//request.setAttribute("maxCapacity", max);
				//request.setAttribute("usedCapacity", used);
				//System.out.println(val1 + '  ' + );
				
				JSONObject json2 = new JSONObject();
				json2.put("val1", val1);
				json2.put("val2", val2);
				json2.put("val3", val3);
				json2.put("val4", val4+" /");
				json2.put("result", true);
				
				response.getWriter().print(json2);
	}

}
