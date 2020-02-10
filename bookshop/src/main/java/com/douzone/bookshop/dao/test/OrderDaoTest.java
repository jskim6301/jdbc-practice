package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderBookVO;
import com.douzone.bookshop.vo.OrderVO;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insertTest("202012132012",35000,"상하이",1L);
		selectTest(); //주문리스트 - 주분번호,결재금액,배송지,주문자
		selectTest2(); //주문도서 리스트 - 주문번호,서적제목,서적가격,수량
//		deleteTest(1L);
	}
	public static void insertTest(String orderNo,int authorizationPrice,String location,Long memberNo) {
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderNo(orderNo);
		orderVO.setAuthorizationPrice(authorizationPrice);
		orderVO.setLocation(location);
		orderVO.setMemberNo(memberNo);
		
		new OrderDao().insert(orderVO);
	}
	
	public static void selectTest() {
		List<OrderVO> list = new OrderDao().orderList();
		for(OrderVO vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void selectTest2() {
		List<OrderBookVO> list = new OrderDao().orderBookList();
		for(OrderBookVO vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void deleteTest(Long no) {		
		new OrderDao().delete(no);
	}

}
