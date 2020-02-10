package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVO;

public class MemberDaoTest {

	public static void main(String[] args) {
//		insertTest("홍길동","010-1111-1111","a@gmail.com","123");
//		insertTest("홍길순","010-2222-2222","b@gmail.com","1234");
		
		selectTest();

//		updateTest(1L,"홍길갈");
	}
	
	public static void insertTest(String name,String phone,String email,String password) {
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPassword(password);
		new MemberDao().insert(vo);
	}
	
	public static void selectTest() {
		List<MemberVO> list = new MemberDao().findAll();
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
	}
	public static void deleteTest(Long no) {		
		new MemberDao().delete(no);
	}
	public static void updateTest(Long no,String name) {
		MemberVO vo = new MemberVO();
		vo.setNo(no);
		vo.setName(name);
		new MemberDao().update(vo);
	}
}
