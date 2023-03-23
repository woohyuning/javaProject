package com.shinhan.day06;

//23.02.28 7교시 -2
//11장-6 사용자 정의 예외 page 479
public class ExceptionTest2 {
	public static void main(String[] args) {
//		Exception : 자동발생, 강제발생
//		int a = 10/0; // 자동

//		0 <= a < 1 사이 실수
		double a = Math.random();
//		1 ~ 10 정수
		int b = (int) (a * 8)+1; // 1 <= b <= 8
		System.out.println(a);
		System.out.println(b);

		String pass = "123456";

		char ch = pass.charAt(0);
		try {
			if (ch < 'A' || ch > 'Z') {
				throw new LoginException("대문자로 시작해야 한다");
			}
		} catch (LoginException ex) {
			System.out.println(ex.getMessage());
			ex.printMsg();
		}
		System.out.println("main end");
	}
}
