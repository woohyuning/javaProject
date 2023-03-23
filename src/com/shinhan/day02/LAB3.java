package com.shinhan.day02;

public class LAB3 {
	
	// public : 모든 패키지에서 접근가능
	// static : >java LAB3 실행하면 실행하기 전에 LAB3 class의 byte code가 method 영역에 올라간다.
	// static 붙은 method, variable들이 올라간다.
	// void : return 값이 없다. 함수 수행 후 돌아갈때 값을 가지고 가지않는다.
	public static void main(String[] args) {
		gcd(2, 5);
		gcd(5, 15);
		gcd(250, 30);
//		double result = sum(1, 10);
//		System.out.println(result);
	}
	
	private static void gcd(int i, int j) {
		int min = i > j ? j : i;
		int result = 1;
		for(int su = min; su>=1; su--) {
			if(i % su == 0 && j % su == 0) {
				result = su;
				break;
			}
		}
		System.out.println(result);
	}

	private static double sum(int start, int end) {
		int total = 0;
		for(int loop=start; loop <= end; loop++) {
			total += loop;
		}
		return total;
	}

}
