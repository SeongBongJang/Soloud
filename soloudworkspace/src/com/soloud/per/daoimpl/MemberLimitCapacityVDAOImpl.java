package com.soloud.per.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.MemberLimitCapacityVDAO;
import com.soloud.per.dto.MemberLimitCapacityVDTO;

public class MemberLimitCapacityVDAOImpl extends BaseDAO implements MemberLimitCapacityVDAO
{

	@Override
	public MemberLimitCapacityVDTO searchMemberCapacityMemberCode(
			String memberCode) {

		JdbcTemplate jt = getJdbcTemplate();
		
		final MemberLimitCapacityVDTO tmp = new MemberLimitCapacityVDTO();
		
		String sql = "SELECT * FROM member_limit_capacity_view WHERE member_code='" + memberCode + "'";
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				//System.out.println(rs.getString("alarm_kind_code"));
			// TODO Auto-generated method stub
			
				
				tmp.setMemberCode(rs.getString("member_code"));
				tmp.setMemberId(rs.getString("member_id"));
				tmp.setUsedCapacity(rs.getInt("현재사용량"));
				tmp.setTotalCapacity(rs.getInt("전체사용량"));
	
			}
			
		});
		
		return tmp;
	}

	@Override
	public MemberLimitCapacityVDTO searchMemberCapacityMemberId(String memberId) {
		// TODO Auto-generated method stub
JdbcTemplate jt = getJdbcTemplate();
		
		final MemberLimitCapacityVDTO tmp = new MemberLimitCapacityVDTO();
		
		String sql = "SELECT * FROM member_limit_capacity_view WHERE member_id='" + memberId+ "'";
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				//System.out.println(rs.getString("alarm_kind_code"));
			// TODO Auto-generated method stub
			
				
				tmp.setMemberCode(rs.getString("member_code"));
				tmp.setMemberId(rs.getString("member_id"));
				tmp.setUsedCapacity(rs.getInt("현재사용량"));
				tmp.setTotalCapacity(rs.getInt("전체사용량"));
	
			}
			
		});
		
		return tmp;
	}
	

}
