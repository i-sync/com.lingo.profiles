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

public class SkillCategory {
	/**
	 * add skill category info
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.SkillCategory data)
	{
		LingoLogger.logger.info("dao level: add skill category info start...");
		Result result = new Result();
		
		try
		{
			String sql = "insert into Profiles.SkillCategory(PID,Title,AddDate,UpdateDate) values(?,?,?,?);";
			Object [] objs = new Object[]{data.getPid(),data.getTitle(),new Date(), new Date()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		}
		catch(Exception e)
		{
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}
		
		LingoLogger.logger.info("dao level: add skill category info end.");
		return result;
	}
	
	/**
	 * update skill category info
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.SkillCategory data)
	{
		LingoLogger.logger.info("dao level: update skill category info start...");
		Result result = new Result();
		
		try
		{
			String sql = "update Profiles.SkillCategory set Title=?,UpdateDate=? where ID=?";
			Object [] objs = new Object[]{data.getTitle(),new Date(),data.getId()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		}
		catch(Exception e)
		{
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}
		
		LingoLogger.logger.info("dao level: update skill category info end.");
		return result;		
	}
	
	/**
	 * delete skill category info
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.SkillCategory data)
	{
		LingoLogger.logger.info("dao level: delete skill category info start...");
		Result result = new Result();
		
		try
		{
			String sql = "delete from Profiles.SkillCategory where ID=?";
			Object [] objs = new Object[]{data.getId()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		}
		catch(Exception e)
		{
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}
		
		LingoLogger.logger.info("dao level: delete skill category info end.");
		return result;		
	}
	
	/**
	 * get skill category model
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.SkillCategory> getModel(com.lingo.profiles.bean.SkillCategory data)
	{
		LingoLogger.logger.info("dao level: get skill category model info start...");
		TResult<com.lingo.profiles.bean.SkillCategory> result = new TResult<com.lingo.profiles.bean.SkillCategory>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.SkillCategory where ID=?";
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

		LingoLogger.logger.info("dao level: get skill category model info end.");
		return result;
	}
	
	/**
	 * get skill category list by pid
	 * @param data
	 * @return
	 */
	public ListResult<com.lingo.profiles.bean.SkillCategory> getList(com.lingo.profiles.bean.SkillCategory data)
	{
		LingoLogger.logger.info("dao level: get skill category list info start...");
		ListResult<com.lingo.profiles.bean.SkillCategory> result = new ListResult<com.lingo.profiles.bean.SkillCategory>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.SkillCategory where PID=?";
			Object[] objs = new Object[] { data.getPid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			List<com.lingo.profiles.bean.SkillCategory> list = new ArrayList<com.lingo.profiles.bean.SkillCategory>();
			
			// if it has result
			while (rs.next()) {				
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				com.lingo.profiles.bean.SkillCategory skill = new com.lingo.profiles.bean.SkillCategory(id, data.getPid(), title);
				list.add(skill);
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
		
		LingoLogger.logger.info("dao level: get skill category list info end.");
		return result;
	}
}
