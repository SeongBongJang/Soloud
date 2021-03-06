//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FolderFileVDAOImpl.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.daoimpl;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.FolderFileVDAO;
import com.soloud.per.dto.FolderFileVDTO;




public class FolderFileVDAOImpl extends BaseDAO implements FolderFileVDAO
{
	public List<FolderFileVDTO> searchFolderFile(String folderCode)
	{
		final List<FolderFileVDTO> temp = new ArrayList<FolderFileVDTO>();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		String sql = "SELECT *"
					+" FROM folder_file_view"
					+" WHERE \"폴더코드\"='" + folderCode + "'";
		

		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("파일최근수정날짜");
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					
					FolderFileVDTO tmp = new FolderFileVDTO();
					tmp.setFileCode(rs.getString("폴더코드"));
					tmp.setFileLatestModifydate(gc);
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFolderCode(rs.getString("폴더코드"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;
	}
	
	public List<FolderFileVDTO> searchFolderFile()
	{
		final List<FolderFileVDTO> temp = new ArrayList<FolderFileVDTO>();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		String sql = "SELECT *"
				+" FROM folder_file_view";                                                           


		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("파일최근수정날짜");
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					
					FolderFileVDTO tmp = new FolderFileVDTO();
					tmp.setFileCode(rs.getString("폴더내파일코드"));
					tmp.setFileLatestModifydate(gc);
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFolderCode(rs.getString("폴더코드"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;

	}
}
