package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.AuthorDao;
import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.AuthorVo;
import com.douzone.bookmall.vo.BookVo;

public class AuthDaoTest {

	public static void main(String[] args) {
//		insertTest("김난도");
//		insertTest("천상병");
//		insertTest("조정래");
//		insertTest("원상병");
//		selectTest();
//		deleteTest("조정래");
//		updateTest("김난도","김절도");
		
//		insertTest2("트와일라잇","대여중",(long) 1);
//		insertTest2("뉴문","대여중",(long) 1);
//		insertTest2("이클립스","대여가능",(long) 1);
//		
//		insertTest2("아리랑","대여중",(long) 2);
//		insertTest2("아프니까 청춘이다","대여가능",(long) 3);
//		insertTest2("풀하우스","대여가능",(long) 3);
		selectTest2();
//		deleteTest2("트와일라잇");
//		deleteTest2("이클립스");
//		deleteTest2("뉴문");
//		deleteTest2("아리랑");
//		deleteTest2("아프니까 청춘이다");
//		deleteTest2("비닐하우스");
//		deleteTest2("풀하우스");
//		updateTest2("풀하우스","비닐하우스");
	}
	
	public static void insertTest(String name) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		new AuthorDao().insert(vo);
	}
	public static void insertTest2(String title,String state,Long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setState(state);
		vo.setAuthorNo(authorNo);
		new BookDao().insert(vo);
	}
	
	
	public static void selectTest() {
		List<AuthorVo> list = new AuthorDao().findAll();
		for(AuthorVo vo : list) {
			System.out.println(vo);
		}
	}
	public static void selectTest2() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void deleteTest(String name) {
		
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		new AuthorDao().delete(vo);
	}
	public static void deleteTest2(String title) {
			
			BookVo vo = new BookVo();
			vo.setTitle(title);
			new BookDao().delete(vo);
	}	
	
	
	public static void updateTest(String name,String newName) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		new AuthorDao().update(vo,newName);
	}
	public static void updateTest2(Long no,String newState) {
//		BookVo vo = new BookVo();
		
		new BookDao().update(no,newState);
	}
	

}
