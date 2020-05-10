package org.hello.controller.utils;

public class Pagination {
  private int pageSize = 8;
  
  private int rangeSize = 10;
   
  private int curPage = 1;
  
  private int curRange = 1;
   
  private int listCnt;
  
  private int pageCnt;
  
  private int rangeCnt;
  
  private int startPage = 1;
  
  private int endPage = 1;
  
  private int startIndex = 0;
  
  private int prevPage;
  
  private int nextPage;
  
  public int getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
  
  public int getRangeSize() {
    return this.rangeSize;
  }
  
  public void setRangeSize(int rangeSize) {
    this.rangeSize = rangeSize;
  }
  
  public int getCurPage() {
    return this.curPage;
  }
  
  public void setCurPage(int curPage) {
    this.curPage = curPage;
  }
  
  public int getCurRange() {
    return this.curRange;
  }
  
  public int getListCnt() {
    return this.listCnt;
  }
  
  public void setListCnt(int listCnt) {
    this.listCnt = listCnt;
  }
  
  public int getPageCnt() {
    return this.pageCnt;
  }
  
  public int getRangeCnt() {
    return this.rangeCnt;
  }
  
  public int getStartPage() {
    return this.startPage;
  }
  
  public void setStartPage(int startPage) {
    this.startPage = startPage;
  }
  
  public int getEndPage() {
    return this.endPage;
  }
  
  public void setEndPage(int endPage) {
    this.endPage = endPage;
  }
  
  public int getStartIndex() {
    return this.startIndex;
  }
  
  public int getPrevPage() {
    return this.prevPage;
  }
  
  public void setPrevPage(int prevPage) {
    this.prevPage = prevPage;
  }
  
  public int getNextPage() {
    return this.nextPage;
  }
  
  public void setNextPage(int nextPage) {
    this.nextPage = nextPage;
  }
  
  public Pagination(int listCnt, int curPage) {
    setCurPage(curPage);
    setListCnt(listCnt);
    setPageCnt(listCnt);
    setRangeCnt(this.pageCnt);
    rangeSetting(curPage);
    setStartIndex(curPage);
  }
  
  public void setPageCnt(int listCnt) {
    this.pageCnt = (int)Math.ceil(listCnt * 1.0D / this.pageSize);
  }
  
  public void setRangeCnt(int pageCnt) {
    this.rangeCnt = (int)Math.ceil(pageCnt * 1.0D / this.rangeSize);
  }
  
  public void rangeSetting(int curPage) {
    setCurRange(curPage);
    this.startPage = (this.curRange - 1) * this.rangeSize + 1;
    this.endPage = this.startPage + this.rangeSize - 1;
    if (this.endPage > this.pageCnt)
      this.endPage = this.pageCnt; 
    this.prevPage = curPage - 1;
    this.nextPage = curPage + 1;
  }
  
  public void setCurRange(int curPage) {
    this.curRange = (curPage - 1) / this.rangeSize + 1;
  }
  
  public void setStartIndex(int curPage) {
    this.startIndex = (curPage - 1) * this.pageSize;
  }
}
