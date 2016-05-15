package com.soloud.app.man;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.soloud.per.dao.FileBinarySearchDAO;
import com.soloud.per.dao.FileSearchDAO;
import com.soloud.per.dto.FileBinaryDTO;
import com.soloud.per.dto.FileDTO;
import com.soloud.per.factory.DAOFactory;


public class FileDownloadView extends AbstractView {

	public void DownView(){
        setContentType("application/download; utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userAgent = request.getHeader("User-Agent");
		
		// 파일 코드
		String fileCode = (String)model.get("downloadFile");
		System.out.println(fileCode);
		
		// 파일 이름
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		FileSearchDAO dao= (FileSearchDAO)factory.create("File");
		FileDTO fileDto = dao.searchFileCode(fileCode);
		String fileName = URLEncoder.encode(fileDto.getFileName().trim(), "UTF-8");
		System.out.println(fileName);
		
		// 파일 데이터
		FileBinarySearchDAO dao2 = (FileBinarySearchDAO)factory.create("FileBinary");
		FileBinaryDTO fileBinaryDto = dao2.selectFileBinary(fileCode);
		InputStream stream = (InputStream)fileBinaryDto.getFileBinary();

		// 응답 환경설정
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setContentType(getContentType());
        response.setContentLength(fileBinaryDto.getSize());
        
		OutputStream out = response.getOutputStream();
		
		try{
            FileCopyUtils.copy(stream, out);
        } 
		catch(Exception e){
            e.printStackTrace();
        }
		finally{
            if(stream != null)
            {
                try{
                    stream.close();
                }
                catch(Exception e){
                	e.printStackTrace();
                }
            }
        }// try end;
        out.flush();
    }// render() end;
}
