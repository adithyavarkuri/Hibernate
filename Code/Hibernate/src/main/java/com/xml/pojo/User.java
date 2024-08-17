package com.xml.pojo;
import java.util.Date;
public class User {
	private int v;
	private int userId;
	private String username;
	private String createdBy;
	private Date createdDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	
	
	
}