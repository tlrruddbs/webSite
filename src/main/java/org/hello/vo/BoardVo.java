package org.hello.vo;

import java.util.Date;

public class BoardVo {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private Date date;
	private int count;
	
	private String resultMsg;
	
	public BoardVo() {
	}

	public BoardVo(int seq, String title, String content, String writer, Date date, int count) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.count = count;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + ", count=" + count + "]";
	}
	
}
