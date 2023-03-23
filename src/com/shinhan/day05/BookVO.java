package com.shinhan.day05;

// <4-2>
// page 256
// Book에는 업무 로직은 없다.
// VO(Value Object) : data를 저장하는 가방이다.
// DTO(Data Transfer Object) : data를 저장해서 전송하는 목적으로 만든 class
// JavaBeans 기술에서 사용한다.
// 맴버변수는 private으로 설정, 맴버메서드는 public으로 설정한다.
// JspServlet, Spring, MyBatis framework에서 사용된다.
// final : 변수(값 수정 불가), 메서드(override 불가), 클래스(상속 불가)
public class BookVO {
	// instance 변수
	private String title;
	private int price;
	
	// class 변수
	static int count;
	
	// final : 수정불가 , instance, 선언 시 or 생성 시 초기화
	final String isbn = "12345";
	final String isbn2;
	
	// static final : 수정불가 , 상수, class, 선언 시 초기화
	static final String PUBLISHER = "한빛";
	
	public BookVO(String title, int price) {
		super();
		
		System.out.println("day05에 있는 BookVO");

		this.title = title;
		this.price = price;
		isbn2 = title + "67890";
		count++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVO [title=" + title + ", price=" + price + "]";
	}
	

}
