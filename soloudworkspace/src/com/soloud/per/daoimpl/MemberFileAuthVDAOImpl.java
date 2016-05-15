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
import com.soloud.per.dao.MemberFileAuthVDAO;
import com.soloud.per.dto.MemberFileAuthVDTO;

public class MemberFileAuthVDAOImpl extends BaseDAO implements MemberFileAuthVDAO
{

	@Override
	public List<MemberFileAuthVDTO> searchAllMemberFileAuth() 
	{
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view"; 
		
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				//System.out.println(rs.getString("alarm_kind_code"));
				// TODO Auto-generated method stub
				while(true)
				{
					//SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					//String date= format.format(newArrivalDate.getTime()); // 20090529
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
		
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuth(String memberCode) 
	{
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"; 
		
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderCode(
			String memberCode, String uploaderCode) 
	{
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
					+" AND \"업로더멤버코드\"='" + uploaderCode + "'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderName(
			String memberCode, String uploaderName) 
	{
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
					+" AND \"업로더이름\"LIKE'%" + uploaderName + "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileName(
			String memberCode, String fileName) 
	{
		// TODO Auto-generated method stub
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
					+" AND \"파일이름\" LIKE '%" + fileName + "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileType(
			String memberCode, String fileType) 
	{
		// TODO Auto-generated method stub
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
					+" AND \"파일타입\"='" + fileType + "'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderCode(
			String memberCode, String uploaderCode, String fileType) 
	{
		// TODO Auto-generated method stub
				final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

				JdbcTemplate jt = getJdbcTemplate();
				String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
							+" AND \"파일타입\"='" + fileType + "'"
							+" AND \"업로더멤버코드\"='" + uploaderCode + "'";
				System.out.println(sql);
				
				jt.query(sql,new RowCallbackHandler() 
				{
					@Override
					public void processRow(ResultSet rs) throws SQLException 
					{
						while(true)
						{
							Date date = rs.getDate("마지막수정날짜");
							
							long time = date.getTime();
							java.util.Date d = new java.util.Date(time);
							
							GregorianCalendar gc = new GregorianCalendar();
							gc.setTime(d);

							
							
							MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
						
							tmp.setMemberCode(rs.getString("내멤버코드"));
							tmp.setMemberName(rs.getString("내이름"));
							tmp.setFileCode(rs.getString("파일코드"));
							tmp.setFileUploaderName(rs.getString("업로더이름"));
							tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
							tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
							tmp.setLatestModifiedDate(gc);
							tmp.setFileComment(rs.getString("file_comment"));
							tmp.setFileType(rs.getString("파일타입"));
							tmp.setFileName(rs.getString("파일이름"));
							tmp.setIsSharedFile(rs.getString("공유파일여부"));

							temp.add(tmp);
							if(rs.next()==false)
							{
								break;
							}
						}
					}
				});
				return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderName(
			String memberCode, String uploaderName, String fileType) 
	{
		// TODO Auto-generated method stub
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
					+" AND \"파일타입\"='" + fileType + "'"
					+" AND \"업로더이름\" LIKE'%" + uploaderName + "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}

	@Override
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileNameFileType(
			String memberCode, String fileName, String fileType) 
	{
		// TODO Auto-generated method stub
		final List<MemberFileAuthVDTO> temp = new ArrayList<MemberFileAuthVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_file_auth_view WHERE \"내멤버코드\"='" + memberCode+ "'"
					+" AND \"파일타입\"='" + fileType + "'"
					+" AND \"파일이름\" LIKE '%" + fileName+ "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("마지막수정날짜");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("내멤버코드"));
					tmp.setMemberName(rs.getString("내이름"));
					tmp.setFileCode(rs.getString("파일코드"));
					tmp.setFileUploaderName(rs.getString("업로더이름"));
					tmp.setFileUploaderCode(rs.getString("업로더멤버코드"));
					tmp.setFileFolderCode(rs.getString("해당파일이속한폴더"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("파일타입"));
					tmp.setFileName(rs.getString("파일이름"));
					tmp.setIsSharedFile(rs.getString("공유파일여부"));

					temp.add(tmp);
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp;
	}
}
