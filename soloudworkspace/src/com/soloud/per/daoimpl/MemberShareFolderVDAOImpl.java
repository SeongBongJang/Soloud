package com.soloud.per.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.MemberShareFolderVDAO;
import com.soloud.per.dto.MemberShareFolderVDTO;

public class MemberShareFolderVDAOImpl extends BaseDAO implements MemberShareFolderVDAO
{

	@Override
	public List<MemberShareFolderVDTO> searchMemberShareFolder(String memberCode) 
	{
		final List<MemberShareFolderVDTO> temp = new ArrayList<MemberShareFolderVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_share_folder_auth_view" 
					+" WHERE \"����ڵ�\" = '" + memberCode+"'";
		
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				// TODO Auto-generated method stub
				while(true)
				{
					
					MemberShareFolderVDTO tmp = new MemberShareFolderVDTO();
					tmp.setMemberCode(rs.getString("����ڵ�"));
					tmp.setFolderCode(rs.getString("�����ڵ�"));
					tmp.setFolderName(rs.getString("�����̸�"));
					tmp.setSharedFolderCode(rs.getString("���������ڵ�"));
					tmp.setHostMemberCode(rs.getString("ȣ��Ʈ����ڵ�"));
					tmp.setParentFolderCode(rs.getString("�θ������ڵ�"));
					tmp.setIsSharedFolder(rs.getString("is_share_folder"));
					tmp.setFolderUrl(rs.getString("����Url"));
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
	public MemberShareFolderVDTO searchMemberShareFolderCode(String folderCode) {
		// TODO Auto-generated method stub
		final MemberShareFolderVDTO tmp =new MemberShareFolderVDTO();
		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM member_share_folder_auth_view" 
					+" WHERE \"�����ڵ�\" = '" + folderCode+"'";
		
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				tmp.setMemberCode(rs.getString("����ڵ�"));
				tmp.setFolderCode(rs.getString("�����ڵ�"));
				tmp.setFolderName(rs.getString("�����̸�"));
				tmp.setSharedFolderCode(rs.getString("���������ڵ�"));
				tmp.setHostMemberCode(rs.getString("ȣ��Ʈ����ڵ�"));
				tmp.setParentFolderCode(rs.getString("�θ������ڵ�"));
				tmp.setIsSharedFolder(rs.getString("is_share_folder"));
				tmp.setFolderUrl(rs.getString("����Url"));
			}
		});
		
		return tmp;
		
	}

}
