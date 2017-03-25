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

public class Experience {
	/**
	 * add experience info
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.Experience data)
	{
		LingoLogger.logger.info("dao level: add experience info start...");
		Result result = new Result();
		
		try
		{
			String sql = "insert into Profiles.Experience(PID,Title,Company,Link,Period,Location,Position,Intro,AddDate,UpdateDate,Logo) values(?,?,?,?,?,?,?,?,?,?,?);";
			Object [] objs = new Object[]{data.getPid(),data.getTitle(),data.getCompany(),data.getLink(),data.getPeriod(),data.getLocation(),data.getPosition(),data.getIntro(),new Date(), new Date(), data.getLogo()};
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
		
		LingoLogger.logger.info("dao level: add experience info end.");
		return result;
	}
	
	/**
	 * update experience info
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.Experience data)
	{
		LingoLogger.logger.info("dao level: update experience info start...");
		Result result = new Result();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = String.format("update Profiles.Experience set Title=?,Company=?, Link=?, Period=?,Location=?,Position=?,Intro=?,UpdateDate=? %s where ID=?", StringUtils.isNullOrEmpty(data.getLogo())?"":",Logo=?");
			Object [] objs = new Object[]{data.getTitle(),data.getCompany(),data.getLink(),data.getPeriod(),data.getLocation(),data.getPosition(),data.getIntro(),new Date(),data.getId()};
			
			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			// add avatar param
			if (!StringUtils.isNullOrEmpty( data.getLogo() )) {
				// storage avatar
				//byte[] image = data.getImage();
				//ByteArrayInputStream bis = new ByteArrayInputStream(image);				
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
	
		LingoLogger.logger.info("dao level: update experience info end.");
		return result;		
	}
	
	/**
	 * delete experience info
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.Experience data)
	{
		LingoLogger.logger.info("dao level: delete experience info start...");
		Result result = new Result();
		
		try
		{
			String sql = "delete from Profiles.Experience where ID=?";
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
		
		LingoLogger.logger.info("dao level: delete experience info end.");
		return result;		
	}
	
	/**
	 * get experience model
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Experience> getModel(com.lingo.profiles.bean.Experience data)
	{
		LingoLogger.logger.info("dao level: get experience model info start...");
		TResult<com.lingo.profiles.bean.Experience> result = new TResult<com.lingo.profiles.bean.Experience>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Experience where ID=?";
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
				data.setLogo(rs.getString("Logo"));
				data.setCompany(rs.getString("Company"));
				data.setLink(rs.getString("Link"));
				data.setPeriod(rs.getString("Period"));
				data.setLocation(rs.getString("Location"));
				data.setPosition(rs.getString("Position"));
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

		LingoLogger.logger.info("dao level: get experience model info end.");
		return result;
	}
	
	/**
	 * get experience list by pid
	 * @param data
	 * @return
	 */
	public ListResult<com.lingo.profiles.bean.Experience> getList(com.lingo.profiles.bean.Experience data)
	{
		LingoLogger.logger.info("dao level: get experience list info start...");
		ListResult<com.lingo.profiles.bean.Experience> result = new ListResult<com.lingo.profiles.bean.Experience>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Experience where PID=?";
			Object[] objs = new Object[] { data.getPid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			List<com.lingo.profiles.bean.Experience> list = new ArrayList<com.lingo.profiles.bean.Experience>();
			
			// if it has result
			while (rs.next()) {				
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				String logo = rs.getString("Logo");
				String company = rs.getString("Company");
				String link = rs.getString("Link");
				String period = rs.getString("Period");
				String location = rs.getString("Location");
				String position = rs.getString("Position");
				String intro = rs.getString("Intro");
				com.lingo.profiles.bean.Experience experience = new com.lingo.profiles.bean.Experience(id, data.getPid(), title, logo, company,link,period,location,position ,intro);
				list.add(experience);
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
		
		LingoLogger.logger.info("dao level: get experience list info end.");
		return result;
	}
}
