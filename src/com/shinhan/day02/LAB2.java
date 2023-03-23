package com.shinhan.day02;

import java.util.Scanner;

public class LAB2 {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
		numday(2001, 5);

		
	}
	// void : return 값이 없다.
	// static : class가 메모리에 load 될 때 method 영역에 올라간다.
	// public : 모든 패키ㅣㅈ에서 이 함수를 호출 할 수 있다.
	public static void numday(int year, int month) {
		int lastDay = 0;
		switch (month) {
			case 1,3,5,7,8,10,12 :
				lastDay = 31;
				System.out.println("31일");
				break;
			case 4,6,9,11 :
				lastDay = 30;
				System.out.println("30일");
				break;
			case 2 :
				method5(year);
				System.out.println("28일");
				break;
			default:
				System.out.println(lastDay == 0 ? "잘못된 월입니다." : lastDay);
				break;
		}
	}

	private static boolean method5(int year) {
		//  윤년
//		[윤년의 조건]
//		1)	4의 배수인 해는 윤년.
//		2)	4의 배수이면서 100의 배수인 해는 윤년이 아님.
//		3)	100의 배수이면서 400의 배수인 해는 윤년.
		boolean result = false;
		if(year % 4 == 0) {
			System.out.println("4의배수에 해당됩니다");
			if(year % 100 == 0 || year % 400 == 0) {
				System.out.println("100의배수이면서 400의 배수에 해당됩니다.");
				System.out.println(year + "년 2월의 말일은 29일입니다");
			}
		}
		System.out.println(year + "년 2월의 말일은 28일입니다");
		return result;
		
	}

	private static void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int number = sc.nextInt();
		if(number < 1 || number > 1000) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			sc.close();
			return;
		}
		int count = 0, sum = 0;
		
		for(int i = number; i <= 1000; i += number) {
			if(i % number == 0) {
				count++;
				sum += i;
			}
		}
		System.out.printf("%d의 배수 개수 = %d\n", number, count);
		System.out.printf("%d의 배수 합 = %d", number, sum);
	}

	private static void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int number = sc.nextInt();
		if(number < 2 || number > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			sc.close();
			return;
		}
		int result = 1;
		for(int i = 1; i <= number; i++) {
			result *= i;
			System.out.println(i + " ! = " + result);
		}
	}

	private static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2 ~ 100 사이의 정수를 입력하세요. : ");
		int number = sc.nextInt();
		boolean isPrime = true;
		
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				isPrime = !isPrime;
				break; // 반복문 빠지기
			}
		}
		System.out.println(number + "는(은) " + (isPrime ? "소수입니다." : "소수가 아닙니다."));
		
	}

	private static void method1() {
		// 입력받으 숫자의 구구단 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int dan = sc.nextInt();
		if(dan < 2 || dan >= 10) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수빠지기, 호출한 곳으로 돌아간다
		}
		// break : switch 빠지기, 반복문장 빠지기
		for(int gop = 1; gop <=9; gop++) {
			System.out.printf(" %d * %d = %d\n", dan, gop, dan*gop);
		}
	}
}
