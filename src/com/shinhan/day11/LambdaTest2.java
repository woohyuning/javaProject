package com.shinhan.day11;

//23.03.08 2교시 4
public class LambdaTest2 {
	String subject = "자바";
	
	public static void main(String[] args) {
//		f1(100);
		new LambdaTest2().f2(100);
	}

//	23.03.08 2교시 4-2
//	16장.4(구) 클래스 맴버와 로컬변수 사용
	private void f2(int num1) { // 파라메터는 지역변수
		int num2 = 200; // 지역변수
		int num3 = 300;
		num3++;
//		내부class에서 지역변수를 사용한다면 final의 특성을 갖는다.(수정불가)
//		num1++;
//		num2++;
//		2. 람다표현식
		Calculable2 f = (a, b) -> {
				System.out.println("람다표현식" + subject);
//				num1++;
//				num2++;
				return a + b + num1 + num2;
		};
		int result = f.calculate(1, 2);
		System.out.println(result);
	}
//	23.03.08 2교시 4-1
//	16장.4(구) 클래스 맴버와 로컬변수 사용
	private static void f1(int num1) { // 파라메터는 지역변수
		int num2 = 200; // 지역변수
		int num3 = 300;
		num3++;
//		내부class에서 지역변수를 사용한다면 final의 특성을 갖는다.(수정불가)
//		num1++;
//		num2++;
//		1. 익명 구현 클래스
		Calculable2 f = new Calculable2() {
			@Override
			public int calculate(int x, int y) {
				System.out.println("익명구현객체");
//				num1++;
//				num2++;
				return x + y + num1 + num2;
			}
		};
		int result = f.calculate(1, 2);
		System.out.println(result);
	}
}
