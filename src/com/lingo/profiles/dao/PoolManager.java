package com.lingo.profiles.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class PoolManager {
	//
	private PoolManager() {
	}

	/**
	 * get a availavle connection from connection pool
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		return ConnectionPool.getInstance().getConnection();
	}

	/**
	 * release connection and put it to connection pool
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (null != rs) {
				rs.close();
			}
		} catch (SQLException e) {
			// record log
			e.printStackTrace();
		} finally {
			try {
				if (null != stmt) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (null != conn) {
					ConnectionPool.getInstance().freeConnection(conn);
				}
			}
		}
	}

	/**
	 * get current free connection number .
	 * 
	 * @return
	 */
	public static int getFree_num() {
		return ConnectionPool.getInstance().getFree_num();
	}

	/**
	 * get current active connection number. 
	 * 
	 * @return
	 */
	public static int getActive_num() {
		return ConnectionPool.getInstance().getActive_num();
	}
}
