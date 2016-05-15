//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MemberKindDeleteDAOImpl.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//

package com.soloud.per.daoimpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.MemberKindDeleteDAO;
import com.soloud.per.dao.MemberKindInsertDAO;
import com.soloud.per.dao.MemberKindSearchDAO;
import com.soloud.per.dao.MemberKindUpdateDAO;
import com.soloud.per.dto.MemberKindDTO;




public class MemberKindDAOImpl extends BaseDAO implements MemberKindUpdateDAO, MemberKindInsertDAO, MemberKindDeleteDAO, MemberKindSearchDAO
{
	public boolean insertMemberKind(String memberKindName)
	{
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "INSERT INTO member_kind_tb VALUES (" + "'mk'"+ "|| member_kind_sequence.NEXTVAL ,?)";//����ڵ�,��������ڵ�,������̵�,����뷮,������,����̸�
		
		Object[] params = new Object[]{memberKindName};
		int[] types = new int[]{Types.VARCHAR};
		int res = jdbcTemplate.update(sql,params,types);
		if(res > 0)
			return true;
		else
			return false;
	}
	
	public int updateMemberKindName(String memberKindCode, String memberKindName)
	{
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "UPDATE member_kind_tb SET kind_name = '"+memberKindName+"' WHERE member_kind_code = '"+memberKindCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}
	
	public List<MemberKindDTO> searchAllMemberKind()
	{	
		final List<MemberKindDTO> temp = new ArrayList<MemberKindDTO>();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM member_kind_tb";
		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					MemberKindDTO tmp = new MemberKindDTO();
					tmp.setMemberKindCode(rs.getString("member_kind_code"));
					tmp.setMemberKindName(rs.getString("member_kind_name"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;
	}
	
	public MemberKindDTO searchMemberKindCode(String memberKindCode)
	{
		final MemberKindDTO temp = new MemberKindDTO();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM member_kind_tb WHERE member_kind_code = '"+memberKindCode+"'";
		jdbcTemplate.query(sql,new RowCallbackHandler()	{
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					temp.setMemberKindCode(rs.getString("member_kind_code"));
					temp.setMemberKindName(rs.getString("member_kind_name"));
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;
	}
	
	public List<MemberKindDTO> searchMemberKindName(String memberKindName)
	{
		final List<MemberKindDTO> temp = new ArrayList<MemberKindDTO>();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM member_kind_tb WHERE member_kind_name = '"+memberKindName+"'";
		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					MemberKindDTO tmp = new MemberKindDTO();
					tmp.setMemberKindCode(rs.getString("member_kind_code"));
					tmp.setMemberKindName(rs.getString("member_kind_name"));
					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}
			
		});		
		return temp;
	}
	
	public int deleteMemberKind(String memberKindCode)
	{
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM member_kind_tb WHERE member_kind_code = '"+memberKindCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	
	}

	@Override
	public boolean insertMemberKindDTO(MemberKindDTO dto) {

		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "INSERT INTO member_kind_tb VALUES (" + "'mk'"+ "|| member_kind_sequence.NEXTVAL ,?)";//����ڵ�,��������ڵ�,������̵�,����뷮,������,����̸�
		
		Object[] params = new Object[]{dto.getMemberKindName()};
		int[] types = new int[]{Types.VARCHAR};
		int res = jdbcTemplate.update(sql,params,types);
		if(res > 0)
			return true;
		else
			return false;
	}
}