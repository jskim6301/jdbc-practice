package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVO;


public class CartDaoTest {

	public static void main(String[] args) {
//		insertTest(2L,2L,50); //회원번호 2번, 서적번호 2번 , 구매 수량 30개
//		insertTest(1L,1L,20); //회원번호 1번, 서적번호 1번 , 구매 수량 20개
		selectTest();
//		updateTest(2L,20);
	}

	public static void insertTest(Long memberNo,Long bookNo,int amount) {
		CartVO cartVO = new CartVO();
		cartVO.setMemberNo(memberNo);
		cartVO.setBookNo(bookNo);
		cartVO.setAmount(amount);
		new CartDao().insert(cartVO);
	}
	
	public static void selectTest() {
		List<CartVO> list = new CartDao().findAll();
		for(CartVO vo : list) {
			System.out.println(vo);
		}
	}
	public static void updateTest(Long memberNo,int amount) {
		CartVO vo = new CartVO();
		vo.setMemberNo(memberNo);
		vo.setAmount(amount);
		new CartDao().update(vo);
	}
}



