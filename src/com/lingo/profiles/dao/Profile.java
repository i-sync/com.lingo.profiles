package com.lingo.profiles.dao;


import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		LingoLogger.logger.info("add profile info.");
		Result result = new Result();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{			
			String sql ="insert into Profile(Name,Email,Phone,Address,Intro,Avatar) values(?,?,?,?,?,?);";
			Object[] objs = new Object[]{data.getName(),data.getEmail(),data.getPhone(),data.getAddress(),data.getIntro()};
			
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
		LingoLogger.logger.info("get profile model info.");
		TResult<com.lingo.profiles.bean.Profile> result = new TResult<com.lingo.profiles.bean.Profile>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profile where ID=?";
			Object[] objs = new Object[] { data.getId() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// if it has result
			if (rs.next()) {
				data.setName(rs.getString("Name"));
				//avatar
				byte[] avatar = ByteUtils.GetByteFromResultSet(rs,"Avatar");				
				data.setAvatar(avatar);
				data.setEmail(rs.getString("Email"));
				data.setPhone(rs.getString("Phone"));
				data.setAddress(rs.getString("Address"));
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
		
		return result ;
	}
}
