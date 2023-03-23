package com.shinhan.day08;

//23.03.03 2교시 1-2
//12장-12 어노테이션
public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@PrintAnnotation("*")
	public void method2() {
		System.out.println("실행 내용2");
	}

	@PrintAnnotation(value = "#", number = 20, woohyun = "유진")
	public void method3() {
		System.out.println("실행 내용3");
	}
}
