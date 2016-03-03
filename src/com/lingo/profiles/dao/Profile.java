package com.lingo.profiles.dao;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
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

public class Profile {

	/**
	 * add profile 
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.Profile data)
	{
		//record log
		LingoLogger.logger.info(String.format("dao level:add profile info start...Name:%s",data.getName()));
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{			
			String sql ="insert into Profiles.Profile(Name,NickName,Email,Phone,Address,Intro,AddDate,UpdateDate,Avatar) values(?,?,?,?,?,?,?,?,?);";
			Object[] objs = new Object[]{data.getName(),data.getNickName(),data.getEmail(),data.getPhone(),data.getAddress(),data.getIntro(),new Date(),new Date()};
			
			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i=0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}			
			
			//storge avatar
			byte[] avatar = data.getAvatar();
			ByteArrayInputStream bis = new ByteArrayInputStream(avatar);
			pstmt.setBinaryStream(i+1, bis);
			
			int res = pstmt.executeUpdate();
			result.setResult(res);
		}
		catch (SQLException e) {
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
		LingoLogger.logger.info("dao level:add profile info end...");
		return result;
	}
	
	/**
	 * update profile 
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.Profile data)
	{
		//record log
		LingoLogger.logger.info(String.format("dao level: update profile info start...ID:%d",data.getId()));
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{			
			String sql =String.format("update Profiles.Profile set Name=?,NickName=?, Email=?,Phone=?,Address=?,Intro=?,UpdateDate=? %s where ID=?",data.getAvatar()==null?"":",Avatar=?");//"insert into Profile(Name,Email,Phone,Address,Intro,Avatar) values(?,?,?,?,?,?);";
			Object[] objs = new Object[]{data.getName(),data.getNickName(),data.getEmail(),data.getPhone(),data.getAddress(),data.getIntro(),new Date()};
			
			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i=0;
			for (; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}			
			//add avatar param
			if (data.getAvatar() != null) {
				// storage avatar
				byte[] avatar = data.getAvatar();
				ByteArrayInputStream bis = new ByteArrayInputStream(avatar);
				pstmt.setBinaryStream(++i, bis);
			}
			//add id param
			pstmt.setObject(++i, data.getId());
			
			int res = pstmt.executeUpdate();
			result.setResult(res);
		}
		catch (SQLException e) {
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
		
		LingoLogger.logger.info("dao level:update profile info end...");
		return result;
	}
	
	/**
	 * delete profile by id
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.Profile data)
	{
		//record log
		LingoLogger.logger.info(String.format("dao level: delete profile info start...ID:%d",data.getId()));
		Result result = new Result();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs =null;
		try
		{
			String sql = "{call Profiles.proc_profile_delete(?)}";//"delete from Profile where ID=?";
			//Object[] objs = new Object[] { data.getId() };
			
			conn = PoolManager.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, data.getId());//set first parameter to #
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next())
			{
				int res = rs.getInt(0);
				result.setResult(res);
			}
			//int res = DBHelper.executeNonQuery(sql, objs);
			else
			{
				result.setResult(0);
			}
		}
		catch (SQLException e) {
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
			PoolManager.free(rs, cstmt, conn);
		}
		LingoLogger.logger.info("dao level: delete profile info end");
		return result;
	}
	
	/**
	 * get profile model
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Profile> getModel(com.lingo.profiles.bean.Profile data)
	{
		//record log
		LingoLogger.logger.info(String.format("dao level: get profile model info.ID:%d",data.getId()));
		TResult<com.lingo.profiles.bean.Profile> result = new TResult<com.lingo.profiles.bean.Profile>();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			String sql = "{call Profiles.proc_profile_select(?)}";//"select * from Profile where ID=?";
			//Object[] objs = new Object[] { data.getId() };

			conn = PoolManager.getConnection();
			//pstmt = conn.prepareStatement(sql);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, data.getId());
			cstmt.execute();
			rs = cstmt.getResultSet();
			// profile 
			if (rs.next()) {
				data.setName(rs.getString("Name"));
				data.setNickName(rs.getString("NickName"));
				//avatar
				byte[] avatar = ByteUtils.GetByteFromResultSet(rs,"Avatar");				
				data.setAvatar(avatar);
				data.setEmail(rs.getString("Email"));
				data.setPhone(rs.getString("Phone"));
				data.setAddress(rs.getString("Address"));
				data.setIntro(rs.getString("Intro"));
				data.setAddDate(new Date(rs.getTimestamp("AddDate").getTime()));
				data.setUpdateDate(new Date(rs.getTimestamp("UpdateDate").getTime()));
				
				result.setResult(1);
			} 
			else
			{
				result.setResult(0);
			}
			//skill
			if(cstmt.getMoreResults())
			{
				rs = cstmt.getResultSet();
				List<com.lingo.profiles.bean.Skill> list = new ArrayList<com.lingo.profiles.bean.Skill>();
				while(rs.next())
				{
					int id = rs.getInt("ID");
					String title = rs.getString("Title");
					String content = rs.getString("Content");
					com.lingo.profiles.bean.Skill skill = new com.lingo.profiles.bean.Skill(id, data.getId(), title, content);
					list.add(skill);
				}
				data.setSkill(list);
			}
			//project
			if(cstmt.getMoreResults())
			{
				rs = cstmt.getResultSet();
				List<com.lingo.profiles.bean.Project> list = new ArrayList<com.lingo.profiles.bean.Project>();
				while(rs.next())
				{
					int id = rs.getInt("ID");
					String title = rs.getString("Title");
					byte [] image = ByteUtils.GetByteFromResultSet(rs, "Image");
					String link = rs.getString("Link");
					String tags = rs.getString("Tags");
					String intro = rs.getString("Intro");
					com.lingo.profiles.bean.Project project = new com.lingo.profiles.bean.Project(
							id, data.getId(), title,image,link,tags,intro);
					list.add(project);
				}
				data.setProject(list);
			}
			//education
			if(cstmt.getMoreResults())
			{
				rs = cstmt.getResultSet();
				List<com.lingo.profiles.bean.Education> list = new ArrayList<com.lingo.profiles.bean.Education>();
				while(rs.next())
				{
					int id = rs.getInt("ID");
					String title = rs.getString("Title");
					String period = rs.getString("Period");
					String professional = rs.getString("Professional");
					String link = rs.getString("Link");
					String intro = rs.getString("Intro");
					com.lingo.profiles.bean.Education education = new com.lingo.profiles.bean.Education(id, data.getId(), title,period,professional,link ,intro);
					list.add(education);
				}
				data.setEducation(list);
			}
			//link
			if(cstmt.getMoreResults())
			{
				rs = cstmt.getResultSet();
				List<com.lingo.profiles.bean.Link> list = new ArrayList<com.lingo.profiles.bean.Link>();
				while(rs.next())
				{
					int id = rs.getInt("ID");
					String title = rs.getString("Title");
					String lin = rs.getString("Link");
					byte[] logo = ByteUtils.GetByteFromResultSet(rs, "Logo");
					com.lingo.profiles.bean.Link link = new com.lingo.profiles.bean.Link(
							id, data.getId(), title, lin, logo);
					list.add(link);
				}
				data.setLink(list);
			}
			//living
			if(cstmt.getMoreResults())
			{
				rs = cstmt.getResultSet();
				List<com.lingo.profiles.bean.Living> list = new ArrayList<com.lingo.profiles.bean.Living>();
				while(rs.next())
				{
					int id = rs.getInt("ID");
					String title = rs.getString("Title");
					String content = rs.getString("Content");
					com.lingo.profiles.bean.Living living = new com.lingo.profiles.bean.Living(id, data.getId(), title, content);
					list.add(living);
				}
				data.setLiving(list);
			}
			
			result.setT(data);
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
			PoolManager.free(rs, cstmt, conn);
		}
		LingoLogger.logger.info("dao level: get profile model info end.");
		
		return result ;
	}
	
	/**
	 * get profile id by name;
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Profile> getIdByName(com.lingo.profiles.bean.Profile data)
	{
		LingoLogger.logger.info("dao level: get profile id start...");
		TResult<com.lingo.profiles.bean.Profile> result = new TResult<com.lingo.profiles.bean.Profile>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select ID from Profiles.Profile where `Name`=?";
			Object[] objs = new Object[] { data.getName() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// if it has result
			if (rs.next()) {
				data.setId( rs.getInt("ID"));
				result.setResult(1);
				result.setT(data);
			} else {
				result.setResult(-1);
				result.setMessage(String.format("can't found name is %s record!",data.getName()));
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
		
		LingoLogger.logger.info("dao level: get profile id end.");
		return result;
	}
}
