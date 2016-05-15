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
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"; 
		
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
					+" AND \"���δ�����ڵ�\"='" + uploaderCode + "'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
					+" AND \"���δ��̸�\"LIKE'%" + uploaderName + "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
					+" AND \"�����̸�\" LIKE '%" + fileName + "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
					+" AND \"����Ÿ��\"='" + fileType + "'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
				String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
							+" AND \"����Ÿ��\"='" + fileType + "'"
							+" AND \"���δ�����ڵ�\"='" + uploaderCode + "'";
				System.out.println(sql);
				
				jt.query(sql,new RowCallbackHandler() 
				{
					@Override
					public void processRow(ResultSet rs) throws SQLException 
					{
						while(true)
						{
							Date date = rs.getDate("������������¥");
							
							long time = date.getTime();
							java.util.Date d = new java.util.Date(time);
							
							GregorianCalendar gc = new GregorianCalendar();
							gc.setTime(d);

							
							
							MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
						
							tmp.setMemberCode(rs.getString("������ڵ�"));
							tmp.setMemberName(rs.getString("���̸�"));
							tmp.setFileCode(rs.getString("�����ڵ�"));
							tmp.setFileUploaderName(rs.getString("���δ��̸�"));
							tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
							tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
							tmp.setLatestModifiedDate(gc);
							tmp.setFileComment(rs.getString("file_comment"));
							tmp.setFileType(rs.getString("����Ÿ��"));
							tmp.setFileName(rs.getString("�����̸�"));
							tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
					+" AND \"����Ÿ��\"='" + fileType + "'"
					+" AND \"���δ��̸�\" LIKE'%" + uploaderName + "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
		String sql = "SELECT * FROM member_file_auth_view WHERE \"������ڵ�\"='" + memberCode+ "'"
					+" AND \"����Ÿ��\"='" + fileType + "'"
					+" AND \"�����̸�\" LIKE '%" + fileName+ "%'";
		System.out.println(sql);
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					Date date = rs.getDate("������������¥");
					
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					
					
					MemberFileAuthVDTO tmp = new MemberFileAuthVDTO();
				
					tmp.setMemberCode(rs.getString("������ڵ�"));
					tmp.setMemberName(rs.getString("���̸�"));
					tmp.setFileCode(rs.getString("�����ڵ�"));
					tmp.setFileUploaderName(rs.getString("���δ��̸�"));
					tmp.setFileUploaderCode(rs.getString("���δ�����ڵ�"));
					tmp.setFileFolderCode(rs.getString("�ش������̼�������"));
					tmp.setLatestModifiedDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("����Ÿ��"));
					tmp.setFileName(rs.getString("�����̸�"));
					tmp.setIsSharedFile(rs.getString("�������Ͽ���"));

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
