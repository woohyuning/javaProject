package com.shinhan.day02;

import java.util.Scanner;

public class 노우현 {

	public static void main(String[] args) {
//		chap3Method1();
//		chap3Method2();
//		chap3Method3();
//		chap3Method4();
//		chap3Method5();
//		chap3Method6();
//		chap3Method7();
		
//		chap4method2();
//		chap4method3();
//		chap4method4();
//		chap4method5();
//		chap4method6();
		chap4method7();
	}

	private static void chap4method7() {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println(" 1.예금  | 2.출금  | 3.잔고  | 4.종료 ");
			System.out.println("---------------------------------");
			System.out.print("선택>");
			
			String str = sc.nextLine();
			if(str.equals("1")) {
				System.out.print("예금액>");
				money += sc.nextInt();
			} else if(str.equals("2")) {
				System.out.print("출금액>");
				money -= sc.nextInt();
			} else if(str.equals("3")) {
				System.out.println("잔고>" + money);
			} else if(str.equals("4")) {
				System.out.println("프로그램 종료");
				break;
			}
			
//			int strNum = sc.nextInt();
//			if(strNum == 1) {
//				System.out.print("예금액>");
//				money += sc.nextInt();
//			} else if(strNum == 2) {
//				System.out.print("출금액>");
//				money -= sc.nextInt();
//			} else if(strNum == 3) {
//				System.out.println("잔고>" + money);
//			} else if(strNum == 4) {
//				System.out.println("프로그램 종료");
//				break;
//			}
		}
	}

	private static void chap4method6() {
		for(int i = 1; i <= 5 ; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void chap4method5() {
		int i = 1, j = 1;
		for(i = 1; i <= 10; i++) {
			for(j = 1; j <= 10; j++) {
				if(4 * i + 5 * j == 60) {
					System.out.println("(" + i + ", " + j + ")");
				}
			}
		}
	}

	private static void chap4method4() {
		while(true) {
			int x = (int)(Math.random() * 6) + 1;
			int y = (int)(Math.random() * 6) + 1;
			
			if(x + y == 5) {
				System.out.printf("(%d , %d)\n", x, y);
				System.out.println("주사위 눈의 합이 5입니다.");
				break;
			}
			System.out.printf("(%d , %d)\n", x, y);
		}
	}

	private static void chap4method3() {
		int num = 3;
		int sum = 0;
		for(int i = 0; i <= 100; i++) {
			if(i % num == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	private static void chap4method2() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
			case "A", "a" -> {
				score1 = 100;
			}
			case "B", "b" -> {
				int result = 100 - 20;
				score1 = result;
			}
			default -> {
				score1 = 60;
			}
		}
	}

	private static void chap3Method7() {
		double x = 5.0, y = 0.0, z = 5 % y;
		if(Double.isInfinite(x % y)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			double result = z + 10;
			System.out.println("결과 : " + result);
		}
	}

	private static void chap3Method6() {
		int x = 10, y = 5;
		System.out.println((x > 7) && (y <= 5));
		System.out.println((x % 3 == 2) || (y % 2 != 1));
	}

	private static void chap3Method5() {
		int lengthTop = 5, lengthBottom = 10, height = 7;
		double area = (double)(lengthTop + lengthBottom) * height / 2;
		System.out.println(area);
	}

	private static void chap3Method4() {
		int value = 356;
		System.out.println(value / 100 * 100);
	}

	private static void chap3Method3() {
		int pencils = 534, students = 30;
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
	}

	private static void chap3Method2() {
		int score = 85;
		String result = (!(score > 90)) ? "가" : "나";
		System.out.println(result);
	}

	private static void chap3Method1() {
		int x = 10, y = 20, z = (++x) + (y--);
		System.out.println(z);
	}

}
