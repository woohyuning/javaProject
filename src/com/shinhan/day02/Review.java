package com.shinhan.day02;

public class Review {
	public static void main(String[] args) {
		System.out.println("main 시작");
		f1();
		f2();
		System.out.println("main 끝");
	}

	private static void f2() {
		// TODO Auto-generated method stub
		
	}

	private static void f1() {
		System.out.println("f1 function");
		// 기본형 dataType :
		// byte, short, char, int, long, float, double, boolean
		// 값 저장, 연산, 비교
		// Wrapper class : 기본형 dataType + 기능추가
		boolean b = true;
		
		// 1. 자동형변환
		byte v1 = 100;
		int v2;
		v2 = v1;
		System.out.println(v1);
		System.out.println(v2);
		
		//2. 강제형변환...casting
		v1 = (byte) v2;
		System.out.println(v1);
		System.out.println(v2);
		
		// String 기본형이 아니다... java.lang.String class
		String s = "100";
		int v3 = Integer.parseInt(s);
		System.out.println(v3 + 300);
	}
}
