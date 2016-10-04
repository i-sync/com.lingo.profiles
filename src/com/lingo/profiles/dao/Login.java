package com.lingo.profiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingo.profiles.bean.TResult;

public class Login {
	/*
	 * login
	 */
	public TResult<com.lingo.profiles.bean.Contact> login(com.lingo.profiles.bean.Contact data)
	{
		TResult<com.lingo.profiles.bean.Contact> result = new TResult<com.lingo.profiles.bean.Contact>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql =String.format("%s \n%s \n%s \n%s \n%s \n",
					"select c.ID, c.`Password` from",
					"	contacts.contact c",
					"	inner join profiles.rpc r on c.ID = r.CID",
					"	inner join profiles.profile p on r.PID = p.ID",
					"	where p.Name = ? or p.Phone = ? or p.Email = ?");
			Object[] obj = new Object[]{data.getPhone(), data.getPhone(), data.getPhone()};
			
			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			rs = pstmt.executeQuery();
			// check 
			if (rs.next()) {
				data.setId(rs.getInt("ID"));
				String pwd = rs.getString("Password");
				if(data.getPassword().equals(pwd))
				{
					result.setResult(1);
					result.setT(data);
				}
				else
				{
					result.setResult(-2);
					result.setMessage("input password error!");
				}
			}
			else
			{
				result.setResult(-1);
				result.setMessage("input the username is not exists!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} finally {
			PoolManager.free(rs, pstmt, conn);
		}

		return result;
	}
}
