package com.soloud.per.daoimpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.FileDeleteDAO;
import com.soloud.per.dao.FileInsertDAO;
import com.soloud.per.dao.FileSearchDAO;
import com.soloud.per.dao.FileUpdateDAO;
import com.soloud.per.dto.FileDTO;

public class FileDAOImpl extends BaseDAO implements FileInsertDAO, FileSearchDAO, FileUpdateDAO, FileDeleteDAO
{

	@Override
	public int deleteMemberCodeFileName(String memberCode, String fileName) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE member_code ='" + memberCode + "'" 
					+" AND file_name='" + fileName + "'";
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}
	@Override
	public int deleteFileCode(String fileCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE file_code ='" + fileCode + "'" ;
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteMemberCode(String memberCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE member_code ='" + memberCode + "'" ;
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteFolderCode(String folderCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE folder_code ='" + folderCode + "'" ;
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	//쓸일 없는 메서드임...ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
	@Override
	public int deleteMemberCodeLatestModifyDate(String memberCode,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int deleteMemberCodeFileType(String memberCode, String fileType) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE member_code ='" + memberCode + "'" 
					+" AND file_type LIKE '%" + fileType+ "%'";
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteFileType(String fileType) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE file_type LIKE '%" + fileType+ "%'";
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteMemberCodeFileCapacity(String memberCode,
			double startCapacity, double endCapacity) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE member_code ='" + memberCode + "'" 
					+" AND file_capacity > " + startCapacity
					+" AND file_capacity < " + endCapacity;
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteMemberCodeIsShareFile(String memberCode, String isSharedFile) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM file_tb"
					+" WHERE member_code ='" + memberCode + "'" 
					+" AND is_share_file='" + isSharedFile+ "'";
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int updateFileCodeLatestModifyDate(String fileCode,
			GregorianCalendar latestModifyDate) {
		JdbcTemplate jt = getJdbcTemplate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		String date= format.format(latestModifyDate.getTime()); // 20090529
		
		
		String sql = "UPDATE file_tb"
					+" SET file_latest_modifydate='" + date+ "'" 
					+" WHERE file_code ='" + fileCode+ "'" ;
		
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int updateFileCodeFileComment(String fileCode, String fileComment) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		
		
		String sql = "UPDATE file_tb"
					+" SET file_comment='" + fileComment+ "'" 
					+" WHERE file_code ='" + fileCode+ "'" ;
		
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}
	@Override
	public int updateFileCodeFileName(String fileCode, String fileName) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		
		
		String sql = "UPDATE file_tb"
					+" SET file_name='" + fileName+ "'" 
					+" WHERE file_code ='" + fileCode+ "'" ;
		
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}
	@Override
	public int updateFileCodeFileIsShared(String fileCode, String fileIsShared) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		
		
		String sql = "UPDATE file_tb"
					+" SET file_is_share='" + fileIsShared+ "'" 
					+" WHERE file_code ='" + fileCode+ "'" ;
		
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}
	@Override
	public int updateFileCodeFolderCode(String fileCode, String newFolderCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		
		
		String sql = "UPDATE file_tb"
					+" SET folder_code ='" + newFolderCode+ "'" 
					+" WHERE file_code ='" + fileCode+ "'" ;
		
		
		System.out.println(sql);
		int res = jt.update(sql);

		return res;
	}
	@Override
	public List<FileDTO> searchAllFile() {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "select file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file from file_tb";
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public FileDTO searchFileCode(String fileCode) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE file_code = '" + fileCode + "'";
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
					temp.add(tmp);
					
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return temp.get(0);
	}

	@Override
	public List<FileDTO> searchMemberCode(String memberCode) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE member_code = '" + memberCode + "'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchFolderCode(String folderCode) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE folder_code = '" + folderCode + "'";
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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

		//쓸일 없는놈 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
	@Override
	public List<FileDTO> searchFileLatestModifyDate(
			GregorianCalendar startDate, GregorianCalendar endDate) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<FileDTO> searchFileType(String fileType) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE file_type LIKE '%" + fileType + "%'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchFileName(String fileName) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE file_name LIKE '%" + fileName + "%'";
					
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
					String date = rs.getString("최근수정");
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchIsSharedFile(String isSharedFile) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE is_share_file = '" + isSharedFile + "'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchFileNameMemberCode(String fileName,
			String memberCode) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE file_name LIKE '%" + fileName + "%'"
					+" AND member_code = '" + memberCode + "'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchFileNameFileType(String fileName, String fileType) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE file_name LIKE '%" + fileName + "%'"
					+" AND file_type LIKE '%" + fileType + "%'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchFileNameIsSharedFile(String fileName,
			String isSharedFile) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE file_name LIKE '%" + fileName + "%'"
					+" AND is_share_file = '" + isSharedFile + "'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchMemberCodeIsSharedFile(String memberCode,
			String isSharedFile) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE member_code = '" + memberCode + "'"
					+" AND isSharedFile = '" + isSharedFile+ "'";
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchMemberCodeFileType(String memberCode,
			String fileType) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE member_code = '" + memberCode + "'"
					+" AND file_type LIKE '%" + fileType + "%'";
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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

	
	//이거도 안쓸거야
	@Override
	public List<FileDTO> searchMemberCodeFolderLatestModifyDate(
			String memberCode, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileDTO> searchMemberCodeFileName(String memberCode,
			String fileName) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE member_code = '" + memberCode + "'"
					+" AND file_name LIKE '%" + fileName + "%'";
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public boolean insert(String memberCode, String folderCode,
			GregorianCalendar latestModifyDate, String fileComment,
			String fileType, double fileCapacity, String fileName,
			String isSharedFile) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		
		String sql = "INSERT INTO file_tb"
					+" VALUES ('fi' || file_sequence.nextval,"  
					+ "'" + memberCode + "',"
					+ "'" + folderCode + "',"
					+ "" + "sysdate" + ","
					+ "'" + fileComment + "',"
					+ "'" + fileType + "',"
					+ "" + fileCapacity + ","
					+ "'" + fileName + "',"
					+ "'" + isSharedFile + "')";
					
		System.out.println(sql);
		int res = jt.update(sql);

		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean insert(FileDTO dto) {
		// TODO Auto-generated method stub
				JdbcTemplate jt = getJdbcTemplate();
				
				//SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				//String date= format.format(dto.getFileLatestModifyDate().getTime()); // 20090529
				
				
				String sql = "INSERT INTO file_tb"
							+" VALUES (" + dto.getFileCode() + "',"  
							+ "'" + dto.getMemberCode() + "',"
							+ "'" + dto.getFolderCode() + "',"
							+ "" + "sysdate" + ","
							+ "'" + dto.getFileComment()+ "',"
							+ "'" + dto.getFileType() + "',"
							+ "" + dto.getFileCapacity() + ","
							+ "'" + dto.getFileName() + "',"
							+ "'" + dto.getIsShareFile() + "')";
							
				System.out.println(sql);
				int res = jt.update(sql);

				if(res>0)
				{
					return true;
				}
				else
				{
					return false;
				}
	}
	@Override
	public List<FileDTO> searchMemberCodeFolderCode(String memberCode,
			String folderCode) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT file_code, member_code, folder_code, to_char(file_latest_modifydate,'yyyy.mm.dd hh24:mi:ss')\"최근수정\", file_comment, file_type, file_capacity, file_name, is_share_file FROM file_tb"
					+" WHERE member_code = '" + memberCode + "'"
					+" AND folder_code = '" + folderCode + "'";
					
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
					String date = rs.getString("최근수정");
					
					
					int year = Integer.parseInt(date.substring(0, 4));
					int month = Integer.parseInt(date.substring(5, 7));
					int day = Integer.parseInt(date.substring(8, 10));
					int hour = Integer.parseInt(date.substring(11, 13));
					int min = Integer.parseInt(date.substring(14, 16));
					int sec = Integer.parseInt(date.substring(17, 19));
					
					GregorianCalendar gc = new GregorianCalendar(year, month-1, day, hour, min, sec);
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
	public List<FileDTO> searchMemberFileTypeName(String fileType,
			String fileName) {
		// TODO Auto-generated method stub
		final List<FileDTO> temp = new ArrayList<FileDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM file_tb"
					+" WHERE file_type LIKE '%" + fileType + "%'"
					+" AND file_name LIKE '%" + fileName + "%'";
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
					Date date = rs.getDate("file_latest_modifydate");
					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					
					
					FileDTO tmp = new FileDTO();
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFileLatestModifyDate(gc);
					tmp.setFileComment(rs.getString("file_comment"));
					tmp.setFileType(rs.getString("file_type"));
					tmp.setFileCapacity(rs.getDouble("file_capacity"));
					tmp.setFileName(rs.getString("file_name"));
					tmp.setIsShareFile(rs.getString("is_share_file"));
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
