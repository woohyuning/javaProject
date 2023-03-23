package com.shinhan.day06;

//23.02.28 4교시 -6
//9장-확인문제4
class Car {
	class Tire { }
	static class Engine { }
	void go(int score2) {
		int score = 100; // 지역변수는 내부class를 사용하면 final특성
//		score = 300;
//		score2 = 400;
		class LocalClass {
			void f1() {
//				score = 300;
//				score2 = 400;
				System.out.println(score);
				System.out.println(score2);
			}
		}
		LocalClass v1 = new LocalClass();
		System.out.println(v1);
		v1.f1();
	}
}

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.go(200);
		
		Car.Tire tire = new Car().new Tire();
		Car.Engine engine = new Car.Engine();
	}
}
