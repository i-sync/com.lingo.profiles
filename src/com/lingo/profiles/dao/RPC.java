package com.lingo.profiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;

public class RPC {

	/**
	 * add rpc
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.RPC data) {
		LingoLogger.logger.info("dao level: add rpc info start...");
		Result result = new Result();

		try {
			String sql = "insert into Profiles.RPC(PID,CID,AddDate) values(?,?,?);";
			Object[] objs = new Object[] { data.getPid() ,data.getCid(),new Date()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		} catch (Exception e) {
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}

		LingoLogger.logger.info("dao level: add rpc info end.");
		return result;

	}

	/**
	 * get Profile model by cid(Contact.ID)
	 * 
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Profile> getModel(
			com.lingo.profiles.bean.RPC data) {
		TResult<com.lingo.profiles.bean.Profile> result = new TResult<com.lingo.profiles.bean.Profile>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Profiles.RPC where CID=?";
			Object[] objs = new Object[] { data.getCid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// if it has result
			if (rs.next()) {
				// data.setId(rs.getInt("ID"));
				// data.setPid(rs.getInt("PID"));
				// data.setAddDate(new
				// Date(rs.getTimestamp("AddDate").getTime()));

				com.lingo.profiles.bean.Profile profile = new com.lingo.profiles.bean.Profile();
				profile.setId(rs.getInt("PID"));
				result = new Profile().getModel(profile);

			} else {
				result.setResult(-1);
				result.setMessage("RPC not found record!");
			}
		} catch (SQLException e) {
			LingoLogger.logger.error(e);
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			LingoLogger.logger.error(e);
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} finally {
			PoolManager.free(rs, pstmt, conn);
		}

		LingoLogger.logger.info("dao level: RPC  model info end.");
		return result;
	}
}
