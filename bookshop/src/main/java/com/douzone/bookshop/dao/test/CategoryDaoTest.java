package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVO;



public class CategoryDaoTest {

	public static void main(String[] args) {
//		insertTest("상");
//		insertTest("중");
//		insertTest("하");
		selectTest();
//		deleteTest(1L);
//		updateTest(1L,"중상");
	}

	public static void insertTest(String name) {
		CategoryVO vo = new CategoryVO();
		new CategoryDao().insert(name);
	}
	public static void selectTest() {
		List<CategoryVO> list = new CategoryDao().findAll();
		for(CategoryVO vo : list) {
			System.out.println(vo);
		}
	}
	public static void deleteTest(Long no) {		
		new CategoryDao().delete(no);
	}
	public static void updateTest(Long no,String name) {
		CategoryVO vo = new CategoryVO();
		vo.setNo(no);
		vo.setName(name);
		new CategoryDao().update(vo);
	}
}
