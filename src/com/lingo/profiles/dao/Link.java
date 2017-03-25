package com.lingo.profiles.dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lingo.profiles.bean.ListResult;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.utils.ByteUtils;
import com.mysql.jdbc.StringUtils;

public class Link {
	/**
	 * add link info
	 * 
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.Link data) {
		LingoLogger.logger.info("dao level: add link info start...");
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into Profiles.Link(PID,Title,Icon,Link,AddDate,UpdateDate,Logo) values(?,?,?,?,?,?,?);";
			//String sql = "insert into Profiles.Link(PID,Title,Icon,Link,Logo) values(?,?,?,?,?);";
			Object[] objs = new Object[] { data.getPid(), data.getTitle(),data.getIcon(), data.getLink(), new Date(), new Date(), data.getLogo() };
			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}

			// storge logo
			/*
			byte[] logo = data.getLogo();
			ByteArrayInputStream bis = new ByteArrayInputStream(logo);
			pstmt.setBinaryStream(i + 1, bis);
			*/
			int res = pstmt.executeUpdate();
			result.setResult(res);
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
			PoolManager.free(null, pstmt, conn);
		}

		LingoLogger.logger.info("dao level: add link info end.");
		return result;
	}

	/**
	 * update link info
	 * 
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.Link data) {
		LingoLogger.logger.info("dao level: update link info start...");
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = String.format(
					"update Profiles.Link set Title=?,Icon=?,Link=?,UpdateDate=? %s where ID=?",
					StringUtils.isNullOrEmpty(data.getLogo()) ? "" : ",Logo=?");
			Object[] objs = new Object[] { data.getTitle(),data.getIcon(), data.getLink(),new Date() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			// add avatar param
			if (!StringUtils.isNullOrEmpty(data.getLogo())) {
				// storage avatar
				//byte[] logo = data.getLogo();
				//ByteArrayInputStream bis = new ByteArrayInputStream(logo);
				//pstmt.setBinaryStream(++i, bis);
				pstmt.setObject(++i, data.getLogo());
			}
			// add id param
			pstmt.setObject(++i, data.getId());

			int res = pstmt.executeUpdate();
			result.setResult(res);
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
			PoolManager.free(null, pstmt, conn);
		}

		LingoLogger.logger.info("dao level: update link info end.");
		return result;
	}

	/**
	 * delete link info
	 * 
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.Link data) {
		LingoLogger.logger.info("dao level: delete link info start...");
		Result result = new Result();

		try {
			String sql = "delete from Profiles.Link where ID=?";
			Object[] objs = new Object[] { data.getId() };
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		} catch (Exception e) {
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}

		LingoLogger.logger.info("dao level: delete link info end.");
		return result;
	}

	/**
	 * get link model
	 * 
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Link> getModel(
			com.lingo.profiles.bean.Link data) {
		LingoLogger.logger.info("dao level: get link model info start...");
		TResult<com.lingo.profiles.bean.Link> result = new TResult<com.lingo.profiles.bean.Link>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Link where ID=?";
			Object[] objs = new Object[] { data.getId() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// if it has result
			if (rs.next()) {
				data.setPid(rs.getInt("PID"));
				data.setTitle(rs.getString("Title"));
				data.setIcon(rs.getString("Icon"));
				data.setLink(rs.getString("Link"));
				data.setLogo(rs.getString("Logo"));
				//byte[] logo = ByteUtils.GetByteFromResultSet(rs, "Logo");
				//data.setLogo(logo);

				result.setResult(1);
				result.setT(data);
			} else {
				result.setResult(0);
				result.setMessage("not found record!");
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

		LingoLogger.logger.info("dao level: get link model info end.");
		return result;
	}

	/**
	 * get link list by pid
	 * 
	 * @param data
	 * @return
	 */
	public ListResult<com.lingo.profiles.bean.Link> getList(
			com.lingo.profiles.bean.Link data) {
		LingoLogger.logger.info("dao level: get link list info start...");
		ListResult<com.lingo.profiles.bean.Link> result = new ListResult<com.lingo.profiles.bean.Link>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Link where PID=?";
			Object[] objs = new Object[] { data.getPid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			List<com.lingo.profiles.bean.Link> list = new ArrayList<com.lingo.profiles.bean.Link>();

			// if it has result
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				String icon  = rs.getString("Icon");
				String lin = rs.getString("Link");
				String logo = rs.getString("Logo");
				//byte[] logo = ByteUtils.GetByteFromResultSet(rs, "Logo");
				com.lingo.profiles.bean.Link link = new com.lingo.profiles.bean.Link(
						id, data.getPid(), title, icon, lin, null);
				list.add(link);
			}
			rs.close();
			result.setResult(1);
			result.setList(list);

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

		LingoLogger.logger.info("dao level: get link list info end.");
		return result;
	}
}
