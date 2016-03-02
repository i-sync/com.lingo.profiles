package com.lingo.profiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lingo.profiles.bean.ListResult;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;

public class Education {
	/**
	 * add education info
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.Education data)
	{
		LingoLogger.logger.info("dao level: add education info start...");
		Result result = new Result();
		
		try
		{
			String sql = "insert into Education(PID,Title,Period,Professional,Link,Intro) values(?,?,?,?,?,?);";
			Object [] objs = new Object[]{data.getPid(),data.getTitle(),data.getPeriod(),data.getProfessional(),data.getLink(),data.getIntro()};
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
		
		LingoLogger.logger.info("dao level: add education info end.");
		return result;
	}
	
	/**
	 * update education info
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.Education data)
	{
		LingoLogger.logger.info("dao level: update education info start...");
		Result result = new Result();
		
		try
		{
			String sql = "update Education set Title=?,Period=?,Professional=?,Link=?,Intro=? where ID=?";
			Object [] objs = new Object[]{data.getTitle(),data.getPeriod(),data.getProfessional(),data.getLink(),data.getIntro(),data.getId()};
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
		
		LingoLogger.logger.info("dao level: update education info end.");
		return result;		
	}
	
	/**
	 * delete education info
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.Education data)
	{
		LingoLogger.logger.info("dao level: delete education info start...");
		Result result = new Result();
		
		try
		{
			String sql = "delete from Education where ID=?";
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
		
		LingoLogger.logger.info("dao level: delete education info end.");
		return result;		
	}
	
	/**
	 * get education model
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Education> getModel(com.lingo.profiles.bean.Education data)
	{
		LingoLogger.logger.info("dao level: get education model info start...");
		TResult<com.lingo.profiles.bean.Education> result = new TResult<com.lingo.profiles.bean.Education>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Education where ID=?";
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
				data.setPeriod(rs.getString("Period"));
				data.setProfessional(rs.getString("Professional"));
				data.setLink(rs.getString("Link"));
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

		LingoLogger.logger.info("dao level: get education model info end.");
		return result;
	}
	
	/**
	 * get education list by pid
	 * @param data
	 * @return
	 */
	public ListResult<com.lingo.profiles.bean.Education> getList(com.lingo.profiles.bean.Education data)
	{
		LingoLogger.logger.info("dao level: get education list info start...");
		ListResult<com.lingo.profiles.bean.Education> result = new ListResult<com.lingo.profiles.bean.Education>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Education where PID=?";
			Object[] objs = new Object[] { data.getPid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			List<com.lingo.profiles.bean.Education> list = new ArrayList<com.lingo.profiles.bean.Education>();
			
			// if it has result
			while (rs.next()) {				
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				String period = rs.getString("Period");
				String professional = rs.getString("Professional");
				String link = rs.getString("Link");
				String intro = rs.getString("Intro");
				com.lingo.profiles.bean.Education education = new com.lingo.profiles.bean.Education(id, data.getPid(), title,period,professional,link ,intro);
				list.add(education);
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
		
		LingoLogger.logger.info("dao level: get education list info end.");
		return result;
	}
}
