package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVO;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest("춘향전",28000,2L);
//		insertTest("흥부전",25000,1L);
		selectTest();
//		deleteTest(2L);
//		updateTest(1L,25000);
	}
	
	public static void insertTest(String title,int price,Long categoryNo) {
		BookVO bookVO = new BookVO();
		bookVO.setTitle(title);
		bookVO.setPrice(price);
		bookVO.setCategoryNo(categoryNo);
		new BookDao().insert(bookVO);
	}
	public static void selectTest() {
		List<BookVO> list = new BookDao().findAll();
		for(BookVO vo : list) {
			System.out.println(vo);
		}
	}
	public static void deleteTest(Long no) {		
		new BookDao().delete(no);
	}
	public static void updateTest(Long no,int price) {
		BookVO vo = new BookVO();
		vo.setNo(no);
		vo.setPrice(price);
		new BookDao().update(vo);
	}
	
}
