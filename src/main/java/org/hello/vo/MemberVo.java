package org.hello.vo;

public class MemberVo {

	String userId;
	String userNM;
	String passWD;
	String tel;
	String email;

	int power;
	int idChk;
	int modifyChk;
	int memberModifyChk;
	int memberRegisterChk;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNM() {
		return userNM;
	}

	public void setUserNM(String userNM) {
		this.userNM = userNM;
	}

	public String getPassWD() {
		return passWD;
	}

	public void setPassWD(String passWD) {
		this.passWD = passWD;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getIdChk() {
		return idChk;
	}

	public void setIdChk(int idChk) {
		this.idChk = idChk;
	}

	public int getModifyChk() {
		return modifyChk;
	}

	public void setModifyChk(int modifyChk) {
		this.modifyChk = modifyChk;
	}

	public int getMemberModifyChk() {
		return memberModifyChk;
	}

	public void setMemberModifyChk(int memberModifyChk) {
		this.memberModifyChk = memberModifyChk;
	}

	public int getMemberRegisterChk() {
		return memberRegisterChk;
	}

	public void setMemberRegisterChk(int memberRegisterChk) {
		this.memberRegisterChk = memberRegisterChk;
	}

}
