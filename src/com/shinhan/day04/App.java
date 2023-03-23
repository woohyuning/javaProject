package com.shinhan.day04;

// <1-2>
public class App {
	public static void main(String[] args) {
//		f1();
		sum(1, 2);
		sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		sum(1, 2, 3, 4, 5);
		sum(1, 2, 3);
		sum(1.5, 2.5);
		
		Integer a = new Integer(100);
		Integer a2 = 100;
		System.out.println(a.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
	// 메서드 Overloading : 메서드 이름은 같고 매개변수 사양이 다르다.
	// 파라메타 자동형변환이 된다.
	static void sum(int ... arr) {
		int total = 0;
		for(int su : arr) {
			total += su;
		}
		if(total == 0) return; // return : 함수를 중단하고 호출한 곳으로 돌아간다
		System.out.println("가변길이 매개변수 : " + total);
	}
	static void sum(int a, int b) {
		System.out.println("int 합계2 : " + (a + b));
	}
	static void sum(double a, double b) {
		System.out.println("double 합계2 : " + (a + b));
	}
	static void sum(int a, int b, int c) {
		System.out.println("합계3 : " + (a + b + c));
	}
	

	private static void f1() {
		Calculator[] calArr = new Calculator[4];
		Calculator.powerOn();
		
		calArr[0] = new Calculator("red");
		calArr[0].setModel("A모델");
		calArr[1] = new Calculator("balck");
		calArr[2] = new Calculator("B모델", "blue");
		calArr[3] = new Calculator("c모델", "Green", 2000);
		
		for( Calculator cc : calArr) {
			print(cc);
		}
	}

	private static void print(Calculator cal) {
		System.out.println(cal.getModel());
		System.out.println(cal.getColor());
		System.out.println(cal.getPrice());
		cal.powerOn();
		cal.powerOff();
		System.out.println(cal.add(1, 2));
		System.out.println(cal.sub(1, 2) + "\n");
		
	}
}
