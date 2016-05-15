//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FileBinaryDAOImpl.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.daoimpl;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.FileBinaryDeleteDAO;
import com.soloud.per.dao.FileBinaryInsertDAO;
import com.soloud.per.dao.FileBinarySearchDAO;
import com.soloud.per.dao.FileBinaryUpdateDAO;
import com.soloud.per.dto.FileBinaryDTO;





public class FileBinaryDAOImpl extends BaseDAO implements FileBinaryInsertDAO, FileBinaryUpdateDAO, FileBinaryDeleteDAO, FileBinarySearchDAO
{
	@Override
	public List<FileBinaryDTO> selectAllFileBinary() {
		// TODO Auto-generated method stub
		final List<FileBinaryDTO> temp = new ArrayList<FileBinaryDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM file_binary_tb FOR UPDATE";
		
		//InputStream 
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				//System.out.println(rs.getString("alarm_kind_code"));
				// TODO Auto-generated method stub
				while(true)
				{
					FileBinaryDTO tmp = new FileBinaryDTO();
					
					tmp.setFileBinaryCode(rs.getString("file_binary_code"));
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setSize(rs.getInt("file_size"));
					tmp.setFileBinary(rs.getBinaryStream("file_binary"));
					
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
	public FileBinaryDTO selectFileBinary(String fileCode)
	{
		final List<FileBinaryDTO> temp = new ArrayList<FileBinaryDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM file_binary_tb WHERE file_code = '" + fileCode +"' FOR UPDATE";
		
		//InputStream 
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				//System.out.println(rs.getString("alarm_kind_code"));
				// TODO Auto-generated method stub
				while(true)
				{
					FileBinaryDTO tmp = new FileBinaryDTO();
					
					tmp.setFileBinaryCode(rs.getString("file_binary_code"));
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setSize(rs.getInt("file_size"));
					tmp.setFileBinary(rs.getBinaryStream("file_binary"));
					
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

	public FileBinaryDTO selectFileBinaryCode(String fileBinaryCode)
	{
		
		final List<FileBinaryDTO> temp = new ArrayList<FileBinaryDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM file_binary_tb WHERE file_binary_code = '" + fileBinaryCode +"' FOR UPDATE";
		
		//InputStream 
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
					FileBinaryDTO tmp = new FileBinaryDTO();
					
					tmp.setFileBinaryCode(rs.getString("file_binary_code"));
					tmp.setFileCode(rs.getString("file_code"));
					tmp.setSize(rs.getInt("file_size"));
					tmp.setFileBinary(rs.getBinaryStream("file_binary"));
					
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
	
	public boolean insertFileBinary(String fileCode, final Object fileBinary, final int size)
	{
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "INSERT INTO file_binary_tb"
					+" VALUES ('fb' || file_binary_sequence.nextval,"
					+" '" + fileCode +"', ?, ?)";
		
		System.out.println(sql);
		int res=jt.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setBinaryStream(1, (InputStream)fileBinary, size);
				ps.setInt(2, size);
			}
		});
		
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
	public boolean insertFileBinaryDTO(final FileBinaryDTO dto) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "INSERT INTO file_binary_tb"
					+" VALUES (?, ?, ?, ?)";
		
		System.out.println(sql);
		int res=jt.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, dto.getFileBinaryCode());
				ps.setString(2, dto.getFileCode());
				ps.setBinaryStream(3, (InputStream)dto.getFileBinary(), dto.getSize());
				ps.setInt(4, dto.getSize());
			}
		});
		
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//���Ͼ��� ������������������
	public int updateFileBinary(String fileCode, Object newFileBinary)
	{
		
		return 0;
	}

	@Override
	public int deleteFileBinaryCode(String fileBinaryCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "DELETE FROM file_binary_tb"
					+" WHERE file_binary_code='" + fileBinaryCode + "'";
		
		System.out.println(sql);
		int res=jt.update(sql);
		return res;
	}

	@Override
	public int deleteFileCode(String fileCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "DELETE FROM file_binary_tb"
					+" WHERE file_code='" + fileCode + "'";
		
		System.out.println(sql);
		int res=jt.update(sql);
		return res;
	}

	



}