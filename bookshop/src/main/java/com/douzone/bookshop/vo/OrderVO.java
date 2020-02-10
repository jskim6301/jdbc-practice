package com.douzone.bookshop.vo;
//selectTest(); //주문리스트 - 주분번호,결재금액,배송지,주문자
// String sql = "select a.order_no,a.authorization_price,a.location, b.name  from orders a,member b where a.member_no = b.no ";
public class OrderVO {
	private Long no; //주문 기본키
	private String orderNo; //주문 번호
	private int authorizationPrice; //결재금액
	private String location; //배송지
	
	private Long memberNo;//고객번호
	private String memberName;//고객 이름
	private String memberEmail;//고객이메일
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getAuthorizationPrice() {
		return authorizationPrice;
	}
	public void setAuthorizationPrice(int authorizationPrice) {
		this.authorizationPrice = authorizationPrice;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", authorizationPrice=" + authorizationPrice + ", location=" + location
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
	}	
	
}
