package com.soloud.per.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.AvailableFolderFriendDeleteDAO;
import com.soloud.per.dao.AvailableFolderFriendInsertDAO;
import com.soloud.per.dao.AvailableFolderFriendSearchDAO;
import com.soloud.per.dao.AvailableFolderFriendUpdateDAO;
import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dto.AvailableFolderFriendDTO;


public class AvailableFolderFriendDAOImpl extends BaseDAO implements AvailableFolderFriendDeleteDAO, AvailableFolderFriendSearchDAO,AvailableFolderFriendInsertDAO,AvailableFolderFriendUpdateDAO{

	@Override
	public boolean insertAFF(AvailableFolderFriendDTO dto) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		String sql = "INSERT INTO available_folder_friend_tb VALUES(?,?)";

		Object[] params = new Object[]{dto.getFriendCode(),dto.getSharedFolderCode()};
		int[] types = new int[]{Types.CHAR,Types.CHAR};
		int res = jdbcTemplate.update(sql,params,types);
		if(res > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<AvailableFolderFriendDTO> searchAllAFAF() 
	{
		final List<AvailableFolderFriendDTO> temp = new ArrayList<AvailableFolderFriendDTO>();


		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM available_folder_friend_tb";
		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					AvailableFolderFriendDTO tmp = new AvailableFolderFriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public List<AvailableFolderFriendDTO> searchFriendCode(String friendCode) {
		final List<AvailableFolderFriendDTO> temp = new ArrayList<AvailableFolderFriendDTO>();

		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM available_folder_friend_tb WHERE friend_code = '"+friendCode+"'";
		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					AvailableFolderFriendDTO tmp = new AvailableFolderFriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public List<AvailableFolderFriendDTO> searchSharedFolderCode(String sharedFolderCode) {
		final List<AvailableFolderFriendDTO> temp = new ArrayList<AvailableFolderFriendDTO>();

		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM available_folder_friend_tb WHERE shared_folder_code = '"+sharedFolderCode+"'";
		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					AvailableFolderFriendDTO tmp = new AvailableFolderFriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public int deleteFriendCode(String friendCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM available_folder_friend_tb WHERE friend_code = '"+friendCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public int deleteSharedFolderCode(String sharedFolderCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM available_folder_friend_tb WHERE shared_folder_code = '"+sharedFolderCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public int deleteFriendCodeSharedCode(String friendCode, String sharedFolderCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM available_folder_friend_tb WHERE friend_code = '"+friendCode+"' AND shared_folder_code = '"+sharedFolderCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}


}
