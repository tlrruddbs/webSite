package org.hello.vo;

import java.util.Date;
 
public class MemberVo extends WeatherVo {
	private int seq;
	private String userId;
	private String userPw;
	private String userEmail;
	private String userName;
	private Date regDate;
	private String memberCode;
	private String memberStatus;
	private int myBoardCountList;
	private String memberCodeString;
	
	public String getMemberCodeString() {
		return memberCodeString;
	}

	public void setMemberCodeString(String memberCodeString) {
		this.memberCodeString = memberCodeString;
	}

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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public int getMyBoardCountList() {
		return myBoardCountList;
	}

	public void setMyBoardCountList(int myBoardCountList) {
		this.myBoardCountList = myBoardCountList;
	}

	@Override
	public String toString() {
		return "MemberVo [seq=" + seq + ", userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail
				+ ", userName=" + userName + ", regDate=" + regDate + ", memberCode=" + memberCode + ", memberStatus="
				+ memberStatus + ", idChk=" + idChk + ", loginMsg=" + loginMsg + "]";
	}

}
