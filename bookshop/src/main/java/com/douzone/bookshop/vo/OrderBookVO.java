package com.douzone.bookshop.vo;

//selectTest2(); //주문도서 리스트 - 주문번호,서적제목,서적가격,수량

public class OrderBookVO {
	private String orderNo; //주문 번호
	private Long bookNo;//서적번호
	private String bookTitle;//서적제목
	private int bookPrice;//서적가격
	private int amount; //수량
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderBookVO [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", amount=" + amount + "]";
	}	
	
}
