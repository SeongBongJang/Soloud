package com.soloud.per.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.FolderCapacityVDAO;
import com.soloud.per.dto.FolderCapacityVDTO;

public class FolderCapacityVDAOImpl extends BaseDAO implements FolderCapacityVDAO
{

	@Override
	public List<FolderCapacityVDTO> searchAllFolderCapacity() {
		// TODO Auto-generated method stub
		final List<FolderCapacityVDTO> temp = new ArrayList<FolderCapacityVDTO>();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM folder_capacity_view";
					
		
		jt.query(sql,new RowCallbackHandler() 
		{
			@Override
			public void processRow(ResultSet rs) throws SQLException 
			{
				while(true)
				{
					FolderCapacityVDTO tmp = new FolderCapacityVDTO();
					tmp.setFolderCapacity((int)rs.getFloat("폴더용량"));
					tmp.setFolderCode(rs.getString("folder_code"));
					tmp.setFolderName(rs.getString("folder_name"));
					
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
	public FolderCapacityVDTO searchFolderCapacity(String folderCode) {
		// TODO Auto-generated method stub
		final FolderCapacityVDTO temp = new FolderCapacityVDTO();

		JdbcTemplate jt = getJdbcTemplate();
		String sql = "SELECT * FROM folder_capacity_view" 
					+" WHERE folder_code='" + folderCode + "'";
					
		
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
					
					
					temp.setFolderCapacity((int)rs.getFloat("폴더용량"));
					temp.setFolderCode(rs.getString("folder_code"));
					temp.setFolderName(rs.getString("folder_name"));
					
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
