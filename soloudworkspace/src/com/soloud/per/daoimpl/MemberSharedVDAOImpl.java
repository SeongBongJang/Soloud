//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MemberSharedVDAOImpl.java
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
import com.soloud.per.dao.MemberSharedVDAO;
import com.soloud.per.dto.MemberSharedVDTO;





public class MemberSharedVDAOImpl extends BaseDAO implements MemberSharedVDAO
{
	public List<MemberSharedVDTO> searchMemberShared(String memberCode)
	{
		final List<MemberSharedVDTO> temp = new ArrayList<MemberSharedVDTO>();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		String sql = "SELECT m.member_code, sf.shared_folder_code, sf.folder_code, fo.folder_name, fo.folder_url, sf.shared_folder_makedate " +
				" FROM member_tb m, folder_tb fo, shared_folder_tb sf" +
				" WHERE m.member_code = '"+memberCode+"' AND m.member_code=fo.member_code AND fo.folder_code = sf.folder_code";                                  


		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("shared_folder_makedate");
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					
					MemberSharedVDTO tmp = new MemberSharedVDTO();
					tmp.setFolderCode(rs.getString("folder_Code"));
					tmp.setFolderName(rs.getString("folder_name"));
					tmp.setFolderUrl(rs.getString("folder_url"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setSharedFolderMakedate(gc);
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;
	}
	
	public List<MemberSharedVDTO> searchMemberShared()
	{
		final List<MemberSharedVDTO> temp = new ArrayList<MemberSharedVDTO>();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		String sql = "SELECT m.member_code, sf.shared_folder_code, sf.folder_code, fo.folder_name, fo.folder_url, sf.shared_folder_makedate " +
				" FROM member_tb m, folder_tb fo, shared_folder_tb sf" +
				" WHERE m.member_code=fo.member_code AND fo.folder_code = sf.folder_code";                                  


		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("shared_folder_makedate");
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					
					MemberSharedVDTO tmp = new MemberSharedVDTO();
					tmp.setFolderCode(rs.getString("folder_Code"));
					tmp.setFolderName(rs.getString("folder_name"));
					tmp.setFolderUrl(rs.getString("folder_url"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setSharedFolderMakedate(gc);
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;
	}
	@Override
	public MemberSharedVDTO searchMemberSharedFolder(String memberCode,
			String folderCode) {
		// TODO Auto-generated method stub
		System.out.println("임플 ㅎㅇ");
		final MemberSharedVDTO temp = new MemberSharedVDTO();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		String sql = "SELECT * FROM member_shared_view where 멤버코드='"+memberCode+
				"' and 폴더코드='"+folderCode+"'";                                  


		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					
					Date date = rs.getDate("공유폴더만든날");
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					
					temp.setFolderCode(rs.getString("폴더코드"));
					System.out.println("이거 임플에서 직접꺼낸거임 ㅡㅡ"+rs.getString("폴더코드"));
					temp.setFolderName(rs.getString("폴더이름"));
					temp.setFolderUrl(rs.getString("폴더의 실제위치URL"));
					temp.setMemberCode(rs.getString("멤버코드"));
					temp.setSharedFolderCode(rs.getString("공유폴더코드"));
					temp.setSharedFolderMakedate(gc);
					System.out.println("으악");
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		System.out.println("임플"+temp);
		return temp;
	}
	
}
