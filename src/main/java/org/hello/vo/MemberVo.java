package org.hello.vo;

import java.util.Date;

public class MemberVo {
	private int seq;
	private String userId;
	private String userPw;
	private String userEmail;
	private String userName;
	private Date regDate;
	
	private int idChk;
	
	private String loginMsg;
	
	

	public MemberVo() {
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getIdChk() {
		return idChk;
	}

	public void setIdChk(int idChk) {
		this.idChk = idChk;
	}
	
	public String getLoginMsg() {
		return loginMsg;
	}

	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
	}

	@Override
	public String toString() {
		return "MemberVo [seq=" + seq + ", userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail
				+ ", userName=" + userName + ", redDate=" + regDate + "]";
	}
	
}
