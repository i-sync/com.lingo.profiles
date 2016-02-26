package com.lingo.profiles.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * 
 * @author michael.tian
 *
 */
public class ConnectionPool {

	//
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	private static int INIT_CONN;
	private static int MAX_CONN;

	/**
	 * free connection number 
	 */
	private int free_num;

	/**
	 * active connection number
	 */
	private int active_num;

	/**
	 * store free connection list
	 */
	private LinkedList<Connection> freeConnections;

	private static ConnectionPool pool;
	private static Object obj = new Object();

	/**
	 * load driver
	 */
	static {
		//
		readConfig();
		try {
			java.lang.Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError("load database driver  ：" + DRIVER + " exception:"
					+ e.getMessage());
		}
	}

	/**
	 * 
	 */
	private ConnectionPool() {
		freeConnections = new LinkedList<Connection>();
		System.out.println("database connection pool start initial... ,init number：" + INIT_CONN);
		/**
		 * init some connection
		 */
		for (int i = 0; i < INIT_CONN; i++) {
			Connection conn = newConnection();
			if (conn != null) {
				freeConnections.add(conn);
				free_num++;
			}
		}
		System.out.println("database connection pool init complete.");
	}

	protected static ConnectionPool getInstance() {
		if (pool == null) {
			synchronized (obj) {
				if (pool == null)
					pool = new ConnectionPool();
			}
		}
		return pool;
	}

	/**
	 * create a new connection
	 * 
	 * @return
	 */
	private Connection newConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("get an connection occur an error , error message as follow:");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * get a free connectionn
	 * 
	 * @return
	 */
	public synchronized Connection getConnection() {
		Connection conn = null;
		//judge : current connection pool if has free connection 
		if (freeConnections != null && freeConnections.size() > 0) {
			// get the first one and remove 
			conn = freeConnections.remove();
			// judge: the connection is available
			try {
				if (conn.isClosed() || !conn.isValid(0) ) {
					System.out.println("remove an not available connection ");
					// get next connection
					active_num--;
					conn = getConnection();
				}
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("remove an not available connection ");
				// get next connection
				active_num--;
				conn = getConnection();
			}
			free_num--;
			active_num++;
		}
		/*
		 * 判断：目前连接池中已经没有空闲的链接 当前正忙的连接数是否已经达到数据库连接池的最大值，如果没有达到最大值
		 * 1）、可以初始化一批链接，放到连接池中 2）、可以初始化一个链接，放到连接池中--
		 */
		else if (active_num < MAX_CONN) {
			//create a new connection and put it to connection pool
			conn = newConnection();
			active_num++;
		}
		// no free connection is available.
		else {
			//
			System.out.println("current connection is maximum ,please wait.......");
		}
		return conn;
	}

	/**
	 * release connection
	 * 
	 * @param conn
	 */
	protected synchronized void freeConnection(Connection conn) {
		freeConnections.addLast(conn);
		free_num++;
		active_num--;
		notifyAll();
	}

	/**
	 * get current free connection number
	 * 
	 * @return
	 */
	protected int getFree_num() {
		return free_num;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	protected int getActive_num() {
		return active_num;
	}

	/**
	 * load database config file
	 */
	private static void readConfig() {
		InputStream in = ConnectionPool.class.getClassLoader()
				.getResourceAsStream("config.properties");
		//
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			System.out.println("load database config file error:");
			e.printStackTrace();
		}
		//
		DRIVER = pro.getProperty("driver");
		URL = pro.getProperty("url");
		USER = pro.getProperty("username");
		PASSWORD = pro.getProperty("password");
		INIT_CONN = Integer.parseInt(pro.getProperty("initsize"));
		MAX_CONN = Integer.parseInt(pro.getProperty("poolsize"));

	}

}
