package com.shinhan.day02;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
//		method();
//		method2();
//		method3();
		method4();
	}

	public static void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("직각 역삼각형을 출력할 줄 수 : ");
		int rowCount = sc.nextInt();
		for(int row = 1; row <= rowCount; row++) {
			for(int col = 1;col <= rowCount+1-row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

	private static void method3() {
		// 10을 입력받으면 2+4+6+8+10
		// 11           1+3+5+7+9+11
		int end, total=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요. : ");
		end = sc.nextInt();
		int start = end%2 == 0 ? 2 : 1;
		for(int i = start; i <= end; i+=2) {
			total += i;
			System.out.println(i);
		}
		System.out.printf("결과 값 : %d", total);
		
	}

	private static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. : ");
		String inputString = sc.nextLine();
		inputString = inputString.toUpperCase();
		
		for(int i = 1; i <= inputString.length(); i++) {
			System.out.println(inputString.substring(0, i));
		}
		sc.close();
	}

	private static void method() {
		int start, end, increment, total=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("초기 값을 정수로 입력하세요. : ");
		start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요. : ");
		end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요. : ");
		increment = sc.nextInt();
		for(int i = start; i <= end; i+=increment) {
			total += i;
		}
		
		if(total > 1000)
			total += 2000;
		
		System.out.printf("총합은 %d 입니다", total);
		sc.close();
	}

}
