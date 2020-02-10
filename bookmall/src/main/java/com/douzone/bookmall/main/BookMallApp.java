package com.douzone.bookmall.main;

import java.util.List;
import java.util.Scanner;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookMallApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("대여 하고 싶은 책의 번호를 입력하세요.");
		Long no = scanner.nextLong();
		scanner.close();
		
		rent(no);
		displayBookInfo();
	}
	public static void rent(Long no) {
		new BookDao().update(no,"대여중");
	}
	
	public static void displayBookInfo() {
		System.out.println("**************** 도서 정보 출력 ****************");
		
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(
					"["+vo.getNo()+"]"
					+"책 제목:"+vo.getTitle()
					+",작가: "+vo.getAuthorName()
					+",대여 유무: "+vo.getState() );
		}
	}

}
