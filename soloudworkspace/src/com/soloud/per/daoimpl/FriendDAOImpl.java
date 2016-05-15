package com.soloud.per.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.FriendDeleteDAO;
import com.soloud.per.dao.FriendInsertDAO;
import com.soloud.per.dao.FriendSearchDAO;
import com.soloud.per.dao.FriendUpdateDAO;
import com.soloud.per.dto.FriendDTO;

public class FriendDAOImpl extends BaseDAO implements FriendInsertDAO, FriendSearchDAO, FriendUpdateDAO, FriendDeleteDAO
{

	@Override
	public int deleteFriendCode(String friendCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM friend_tb WHERE friend_code ='" + friendCode + "'";
		
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteFriendMemberCode(String friendMemberCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM friend_tb WHERE friend_member_code ='" + friendMemberCode + "'";
		
		int res = jt.update(sql);

		return res;
	}

	@Override
	public int deleteMemberCode(String memberCode, String friendMemberCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "DELETE FROM friend_tb WHERE member_code ='" + memberCode + "'"
					+" AND friend_member_code ='" + friendMemberCode + "'";
		
		int res = jt.update(sql);

		return res;
	}

	@Override
	public List<FriendDTO> searchAllFriend() {
		// TODO Auto-generated method stub
		final List<FriendDTO> temp = new ArrayList<FriendDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM friend_tb";
		
		
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
			
					FriendDTO tmp = new FriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setGroupCode(rs.getString("group_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFriendMemberCode(rs.getString("friend_member_code"));
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
	public FriendDTO searchFriendCode(String friendCode) {
		// TODO Auto-generated method stub
		final List<FriendDTO> temp = new ArrayList<FriendDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM friend_tb WHERE friend_code ='" + friendCode + "'";
		
		
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
			
					FriendDTO tmp = new FriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setGroupCode(rs.getString("group_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFriendMemberCode(rs.getString("friend_member_code"));
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
	public List<FriendDTO> searchGroupCode(String groupCode) {
		// TODO Auto-generated method stub
		final List<FriendDTO> temp = new ArrayList<FriendDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM friend_tb WHERE group_code ='" + groupCode + "'";
		
		
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
			
					FriendDTO tmp = new FriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setGroupCode(rs.getString("group_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFriendMemberCode(rs.getString("friend_member_code"));
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
	public List<FriendDTO> searchMemberCode(String memberCode) {
		// TODO Auto-generated method stub
		final List<FriendDTO> temp = new ArrayList<FriendDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM friend_tb WHERE member_code ='" + memberCode + "'";
		
		
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
			
					FriendDTO tmp = new FriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setGroupCode(rs.getString("group_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFriendMemberCode(rs.getString("friend_member_code"));
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
	public List<FriendDTO> searchGroupMemberCode(String groupCode,
			String memberCode) {
		// TODO Auto-generated method stub
		final List<FriendDTO> temp = new ArrayList<FriendDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM friend_tb"
					+" WHERE group_code ='" + groupCode + "'"
					+"AND member_code ='" + memberCode + "'";
		
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
			
					FriendDTO tmp = new FriendDTO();
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setGroupCode(rs.getString("group_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFriendMemberCode(rs.getString("friend_member_code"));
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
	public FriendDTO searchMemberCodeFriendMemberCode(String memberCode,String friendMemberCode) {
		// TODO Auto-generated method stub
		//final List<FriendDTO> temp = new ArrayList<FriendDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM friend_tb"
					+" WHERE friend_member_code='" + friendMemberCode + "'"
					+"AND member_code ='" + memberCode + "'";
		final FriendDTO tmp = new FriendDTO();
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
					tmp.setFriendCode(rs.getString("friend_code"));
					tmp.setGroupCode(rs.getString("group_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setFriendMemberCode(rs.getString("friend_member_code"));
					if(rs.next()==false)
					{
						break;
					}
				}
			}
		});
		return tmp;
	}

	@Override
	public boolean insertFriend(String groupCode, String memberCode,String friendMemberCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "INSERT INTO friend_tb VALUES ("
					+ "'fr' || friend_sequence.NEXTVAL" + ",'"
					+ groupCode+ "',"
					+ "'" + memberCode + "',"
					+ "'" + friendMemberCode + "')";
		
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
	public boolean insertFriendDTO(FriendDTO dto) {
		// TODO Auto-generated method stub
				JdbcTemplate jt = getJdbcTemplate();
				String sql = "INSERT INTO friend_tb VALUES ("
							+ "'" + dto.getFriendCode() + "',"
							+ "'" + dto.getGroupCode()+ "',"
							+ "'" + dto.getMemberCode() + "',"
							+ "'" + dto.getFriendMemberCode() + "')";
				
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
	public int updateFriendGroup(String memberCode, String friendMemberCode,
			String groupCode) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = getJdbcTemplate();
		
		String sql = "UPDATE friend_tb"
					+" SET group_code='" + groupCode + "'"
					+" WHERE member_code='" + memberCode + "'"
					+" AND friend_member_code='" + friendMemberCode + "'";
				
		int res = jt.update(sql);

		return res;
	}

}
