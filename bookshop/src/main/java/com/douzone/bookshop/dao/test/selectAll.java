package com.douzone.bookshop.dao.test;

public class selectAll {

	public static void main(String[] args) {
		CategoryDaoTest.selectTest(); //카테고리 리스트
		BookDaoTest.selectTest(); //서적 리스트
		MemberDaoTest.selectTest(); //회원 리스트
		CartDaoTest.selectTest(); //카트 리스트
		OrderDaoTest.selectTest(); //주문리스트 
		OrderDaoTest.selectTest2(); //주문도서 리스트  
	}
}
