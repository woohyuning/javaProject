package com.shinhan.day05;

// 23.02.27 2교시 2-2
public class KumhoTire extends Tire {
	String intro = "최고!!!";
	void method2() {
		System.out.println("KumhoTire 기능");
	}
	@Override
	void roll() {
		System.out.println("KumhoTire roll() Override");
	}

}
