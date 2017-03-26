package com.lingo.profiles.dao;

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
import com.mysql.jdbc.StringUtils;

public class Project {
	/**
	 * add project info
	 * 
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.Project data) {
		LingoLogger.logger.info("dao level: add project info start...");
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into Profiles.Project(PID,Title,Link,Tags,Intro,AddDate,UpdateDate,Image) values(?,?,?,?,?,?,?,?);";
			Object[] objs = new Object[] { data.getPid(), data.getTitle(),
					data.getLink(),data.getTags(),data.getIntro(),new Date(), new Date(), data.getImage() };
			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}

			// storge logo
			//byte[] image = data.getImage();
			//ByteArrayInputStream bis = new ByteArrayInputStream(image);
			//pstmt.setBinaryStream(i + 1, bis);

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

		LingoLogger.logger.info("dao level: add project info end.");
		return result;
	}

	/**
	 * update project info
	 * 
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.Project data) {
		LingoLogger.logger.info("dao level: update project info start...");
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = String.format(
					"update Profiles.Project set Title=?,Link=?,Tags=?,Intro=?,UpdateDate=? %s where ID=?",
					StringUtils.isNullOrEmpty(data.getImage()) ? "" : ",Image=?");
			Object[] objs = new Object[] { data.getTitle(), data.getLink(),data.getTags(),data.getIntro(),new Date() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			// add avatar param
			if (!StringUtils.isNullOrEmpty( data.getImage() )) {
				// storage avatar
				//byte[] image = data.getImage();
				//ByteArrayInputStream bis = new ByteArrayInputStream(image);				
				//pstmt.setBinaryStream(++i, bis);
				pstmt.setObject(++i, data.getImage());
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

		LingoLogger.logger.info("dao level: update project info end.");
		return result;
	}

	/**
	 * delete project info
	 * 
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.Project data) {
		LingoLogger.logger.info("dao level: delete project info start...");
		Result result = new Result();

		try {
			String sql = "delete from Profiles.Project where ID=?";
			Object[] objs = new Object[] { data.getId() };
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		} catch (Exception e) {
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}

		LingoLogger.logger.info("dao level: delete project info end.");
		return result;
	}

	/**
	 * get project model
	 * 
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Project> getModel(
			com.lingo.profiles.bean.Project data) {
		LingoLogger.logger.info("dao level: get project model info start...");
		TResult<com.lingo.profiles.bean.Project> result = new TResult<com.lingo.profiles.bean.Project>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Project where ID=?";
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
				data.setLink(rs.getString("Link"));
				//byte[] image = ByteUtils.GetByteFromResultSet(rs, "Image");
				data.setImage(rs.getString("Image"));
				data.setLink(rs.getString("Link"));
				data.setTags(rs.getString("Tags"));
				data.setIntro(rs.getString("Intro"));

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

		LingoLogger.logger.info("dao level: get project model info end.");
		return result;
	}

	/**
	 * get project list by pid
	 * 
	 * @param data
	 * @return
	 */
	public ListResult<com.lingo.profiles.bean.Project> getList(
			com.lingo.profiles.bean.Project data) {
		LingoLogger.logger.info("dao level: get project list info start...");
		ListResult<com.lingo.profiles.bean.Project> result = new ListResult<com.lingo.profiles.bean.Project>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Project where PID=?";
			Object[] objs = new Object[] { data.getPid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			List<com.lingo.profiles.bean.Project> list = new ArrayList<com.lingo.profiles.bean.Project>();

			// if it has result
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				//byte [] image = ByteUtils.GetByteFromResultSet(rs, "Image");
				String image = rs.getString("Image");
				String link = rs.getString("Link");
				String tags = rs.getString("Tags");
				String intro = rs.getString("Intro");
				com.lingo.profiles.bean.Project project = new com.lingo.profiles.bean.Project(
						id, data.getPid(), title,image,link,tags,intro);
				list.add(project);
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

		LingoLogger.logger.info("dao level: get project list info end.");
		return result;
	}
}
