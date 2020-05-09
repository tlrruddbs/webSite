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
  
  public BoardVo() {}
  
  public BoardVo(int seq, String title, String content, String writer, Date date, int count) {
    this.seq = seq;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.date = date;
    this.count = count;
  }
  
  public int getSeq() {
    return this.seq;
  }
  
  public void setSeq(int seq) {
    this.seq = seq;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getWriter() {
    return this.writer;
  }
  
  public void setWriter(String writer) {
    this.writer = writer;
  }
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public int getCount() {
    return this.count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
  
  public String getResultMsg() {
    return this.resultMsg;
  }
  
  public void setResultMsg(String resultMsg) {
    this.resultMsg = resultMsg;
  }
  
  public String toString() {
    return "BoardVo [seq=" + this.seq + ", title=" + this.title + ", content=" + this.content + ", writer=" + this.writer + ", date=" + 
      this.date + ", count=" + this.count + "]";
  }
}