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
					+" WHERE \"멤버코드\" = '" + memberCode+"'";
		
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				// TODO Auto-generated method stub
				while(true)
				{
					
					MemberShareFolderVDTO tmp = new MemberShareFolderVDTO();
					tmp.setMemberCode(rs.getString("멤버코드"));
					tmp.setFolderCode(rs.getString("폴더코드"));
					tmp.setFolderName(rs.getString("폴더이름"));
					tmp.setSharedFolderCode(rs.getString("공유폴더코드"));
					tmp.setHostMemberCode(rs.getString("호스트멤버코드"));
					tmp.setParentFolderCode(rs.getString("부모폴더코드"));
					tmp.setIsSharedFolder(rs.getString("is_share_folder"));
					tmp.setFolderUrl(rs.getString("폴더Url"));
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
					+" WHERE \"폴더코드\" = '" + folderCode+"'";
		
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				tmp.setMemberCode(rs.getString("멤버코드"));
				tmp.setFolderCode(rs.getString("폴더코드"));
				tmp.setFolderName(rs.getString("폴더이름"));
				tmp.setSharedFolderCode(rs.getString("공유폴더코드"));
				tmp.setHostMemberCode(rs.getString("호스트멤버코드"));
				tmp.setParentFolderCode(rs.getString("부모폴더코드"));
				tmp.setIsSharedFolder(rs.getString("is_share_folder"));
				tmp.setFolderUrl(rs.getString("폴더Url"));
			}
		});
		
		return tmp;
		
	}

}
