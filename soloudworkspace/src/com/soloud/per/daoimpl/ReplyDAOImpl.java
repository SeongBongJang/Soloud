package com.soloud.per.daoimpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.soloud.per.dao.BaseDAO;
import com.soloud.per.dao.ReplyDeleteDAO;
import com.soloud.per.dao.ReplyInsertDAO;
import com.soloud.per.dao.ReplySearchDAO;
import com.soloud.per.dao.ReplyUpdateDAO;
import com.soloud.per.dto.ReplyDTO;


public class ReplyDAOImpl extends BaseDAO implements ReplyInsertDAO,ReplyDeleteDAO,ReplySearchDAO,ReplyUpdateDAO{

	@Override
	public int updateReplyContent(String replyCode, String newReplyContent) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "UPDATE reply_tb SET reply_content = '"+newReplyContent+ "' WHERE reply_code = '"+replyCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public int updateReplyContent(String memberCode, String shared_folder_code,String newReplyContent) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "UPDATE reply_tb SET reply_content = '"+newReplyContent+ "' WHERE member_code = '"+memberCode+"' AND shared_folder_code = '"+shared_folder_code+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public List<ReplyDTO> searchAllReply() {
		final List<ReplyDTO> temp = new ArrayList<ReplyDTO>();


		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM reply_tb";

		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("reply_writedate");

					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);

					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					ReplyDTO tmp = new ReplyDTO();
					tmp.setReplyCode(rs.getString("reply_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setReplyWriteDate(gc);
					tmp.setReplyContent(rs.getString("reply_content"));

					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public ReplyDTO searchReplyCode(String replyCode) {
		final ReplyDTO temp = new ReplyDTO();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM reply_tb WHERE reply_code = '"+replyCode+"'";
		jdbcTemplate.query(sql,new RowCallbackHandler()	{
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("reply_writedate");

					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);
					temp.setReplyCode(rs.getString("reply_code"));
					temp.setSharedFolderCode(rs.getString("shared_folder_code"));
					temp.setMemberCode(rs.getString("member_code"));
					temp.setReplyWriteDate(gc);
					temp.setReplyContent(rs.getString("reply_content"));

					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public List<ReplyDTO> searchSharedFolderCode(String sharedFolderCode) {
		final List<ReplyDTO> temp = new ArrayList<ReplyDTO>();


		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM reply_tb WHERE shared_folder_code = '"+sharedFolderCode+"'";

		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("reply_writedate");

					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);

					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					ReplyDTO tmp = new ReplyDTO();
					tmp.setReplyCode(rs.getString("reply_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setReplyWriteDate(gc);
					tmp.setReplyContent(rs.getString("reply_content"));

					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public List<ReplyDTO> searchMemberCode(String memberCode) {
		final List<ReplyDTO> temp = new ArrayList<ReplyDTO>();


		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM reply_tb WHERE member_code = '"+memberCode+"'";

		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("reply_writedate");

					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);

					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					ReplyDTO tmp = new ReplyDTO();
					tmp.setReplyCode(rs.getString("reply_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setReplyWriteDate(gc);
					tmp.setReplyContent(rs.getString("reply_content"));

					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public List<ReplyDTO> searchReplyWriteDate(GregorianCalendar startDate,	GregorianCalendar endDate) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		final List<ReplyDTO> temp = new ArrayList<ReplyDTO>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String start= format.format(startDate.getTime()); // 20090529
		String end = format.format(endDate.getTime());

		String sql = "SELECT * FROM reply_tb WHERE reply_writedate > '" + start
				+"' AND  reply_writedate < '" + end +"'";

		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("reply_writedate");

					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);

					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					ReplyDTO tmp = new ReplyDTO();
					tmp.setReplyCode(rs.getString("reply_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setReplyWriteDate(gc);
					tmp.setReplyContent(rs.getString("reply_content"));

					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public List<ReplyDTO> searchReplyShardFolderCodeMemberCode(	String sharedFolderCode, String memberCode) {
		final List<ReplyDTO> temp = new ArrayList<ReplyDTO>();


		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "SELECT * FROM reply_tb WHERE member_code = '"+memberCode+"' AND shared_folder_code = '"+sharedFolderCode+"'";

		jdbcTemplate.query(sql,new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(true)
				{
					Date date = rs.getDate("reply_writedate");

					long time = date.getTime();
					java.util.Date d = new java.util.Date(time);

					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(d);

					ReplyDTO tmp = new ReplyDTO();
					tmp.setReplyCode(rs.getString("reply_code"));
					tmp.setSharedFolderCode(rs.getString("shared_folder_code"));
					tmp.setMemberCode(rs.getString("member_code"));
					tmp.setReplyWriteDate(gc);
					tmp.setReplyContent(rs.getString("reply_content"));

					temp.add(tmp);
					if(rs.next() == false)
						break;
				}
			}

		});		
		return temp;
	}

	@Override
	public int deleteReplyCode(String replyCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM reply_tb WHERE reply_code = '"+replyCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public int deleteSharedFolderCode(String sharedFolderCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM reply_tb WHERE shared_folder_code = '"+sharedFolderCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public int deleteMemberCode(String memberCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "DELETE FROM reply_tb WHERE member_code = '"+memberCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public int deleteMemberCodeReplyWritedateSharedFolderCode(String memberCode, GregorianCalendar startDate,GregorianCalendar endDate, String sharedFolderCode) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String start= format.format(startDate.getTime()); //
		String end= format.format(endDate.getTime()); // 

		String sql = "DELETE FROM reply_tb WHERE reply_writedate > '" + start+ "'"+" AND reply_writedate < '" + end + "'AND member_code = '"+memberCode+"' AND shared_folder_code = '"+sharedFolderCode+"'";
		int res = jdbcTemplate.update(sql);
		return res;
	}

	@Override
	public boolean insertReply(String sharedFolderCode, String memberCode,GregorianCalendar replyWritedate, String replyContent) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "INSERT INTO reply_tb VALUES ("+"'r'"+"  || reply_sequence.NEXTVAL, ? ,?,SYSDATE,?)";//¸â¹öÄÚµå,¸â¹öÀ¯ÇüÄÚµå,¸â¹ö¾ÆÀÌµð,¸â¹ö¿ë·®,¸â¹öºñ¹ø,¸â¹öÀÌ¸§

		Object[] params = new Object[]{sharedFolderCode,memberCode,replyContent};
		int[] types = new int[]{Types.CHAR,Types.CHAR,Types.VARCHAR};
		int res = jdbcTemplate.update(sql,params,types);
		if(res > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean insertReplyDTO(ReplyDTO dto) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "INSERT INTO reply_tb VALUES ("+"'r'"+"  || reply_sequence.NEXTVAL, ? ,?,SYSDATE,?)";//¸â¹öÄÚµå,¸â¹öÀ¯ÇüÄÚµå,¸â¹ö¾ÆÀÌµð,¸â¹ö¿ë·®,¸â¹öºñ¹ø,¸â¹öÀÌ¸§

		Object[] params = new Object[]{dto.getSharedFolderCode(),dto.getMemberCode(),dto.getReplyContent()};
		int[] types = new int[]{Types.CHAR,Types.CHAR,Types.VARCHAR};
		int res = jdbcTemplate.update(sql,params,types);
		if(res > 0)
			return true;
		else
			return false;
	}


}
