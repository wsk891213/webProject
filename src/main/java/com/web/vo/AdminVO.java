package com.web.vo;

import java.time.LocalDateTime;

/** Admin VO
* @packageName : com.web.vo 
* @fileName : AdminVO.java 
* @author : WooSin Kim
* @date : 2020.12.02 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.02			WooSin Kim				최초 생성 
*/
public class AdminVO {

	private int adminAccountSeq;
	private String id;
	private String password;
	private LocalDateTime lastLogin;
	private Boolean isMaster;
	
	public int getAdminAccountSeq() {
		return adminAccountSeq;
	}
	public void setAdminAccountSeq(int adminAccountSeq) {
		this.adminAccountSeq = adminAccountSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Boolean getIsMaster() {
		return isMaster;
	}
	public void setIsMaster(Boolean isMaster) {
		this.isMaster = isMaster;
	}
	
}
