package org.hello.vo;

import java.util.List;
import java.util.Map;

public class AddVo {
	
	String userId;
	
	int seq;
	
	String stationName;
	
	String memberSelect;

	String stationSelect;

	List<Map> stationList;

	List<Map> memberAuthorityList;

	int authorityChk;

	int idChk;

	int deleteChk;

	public String getMemberSelect() {
		return this.memberSelect;
	}

	public void setMemberSelect(String memberSelect) {
		this.memberSelect = memberSelect;
	}

	public String getStationSelect() {
		return this.stationSelect;
	}

	public void setStationSelect(String stationSelect) {
		this.stationSelect = stationSelect;
	}

	public List<Map> getStationList() {
		return this.stationList;
	}

	public void setStationList(List<Map> stationList) {
		this.stationList = stationList;
	}

	public List<Map> getMemberAuthorityList() {
		return this.memberAuthorityList;
	}

	public void setMemberAuthorityList(List<Map> memberAuthorityList) {
		this.memberAuthorityList = memberAuthorityList;
	}

	public int getAuthorityChk() {
		return this.authorityChk;
	}

	public void setAuthorityChk(int authorityChk) {
		this.authorityChk = authorityChk;
	}

	public int getIdChk() {
		return this.idChk;
	}

	public void setIdChk(int idChk) {
		this.idChk = idChk;
	}

	public int getDeleteChk() {
		return this.deleteChk;
	}

	public void setDeleteChk(int deleteChk) {
		this.deleteChk = deleteChk;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
}
