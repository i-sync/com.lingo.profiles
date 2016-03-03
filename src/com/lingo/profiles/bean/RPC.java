package com.lingo.profiles.bean;

import java.util.Date;

public class RPC {
	private int id;
	private int pid;
	private int cid;
	private Date addDate;
	public RPC(){}
	public RPC(int pid, int cid, Date addDate) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.addDate = addDate;
	}
	public RPC(int id, int pid, int cid, Date addDate) {
		this(pid, cid, addDate);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	
}
