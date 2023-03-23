package com.shinhan.day04;

// <3-2>
// 6장LAB04
// Servuce : Business logic을 구현
public class BookService {
	BookVO[] booklist;
	
	public BookService(BookVO[] booklist) {
		this.booklist = booklist;
	}
	
	public void printBookList() {
		System.out.println("=== 책 목록 ===");
		for(BookVO book : booklist) {
//			System.out.println(book.getTitle());
			System.out.println(book);
		}
		System.out.println();
	}
	
	public void printTotalPrice() {
		int total = 0;
		
		System.out.println("=== 책 가격의 총합 ===");
		
		for(BookVO book : booklist) {
			total += book.getPrice();
		}
		
		System.out.println("전체 책 가격의 합 : " + total);
	}
}
