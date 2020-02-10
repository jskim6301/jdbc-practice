package com.douzone.bookshop.vo;

public class CartVO {
	private int amount; //카트 서적수량
	private Long memberNo; //고객번호
	private Long bookNo; //서적번호
	
	private String memberName; //고객이름
	private String bookTitle; //서적 제목
	private int bookPrice; //서적 가격
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	@Override
	public String toString() {
		return "CartVO [bookTitle=" + bookTitle + ", amount=" + amount + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
	
	
	
}
