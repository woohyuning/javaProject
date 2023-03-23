package com.shinhan.day11;

// 23.03.08 1교시 2-1
// 16장 람다식
// 23.03.08 1교시 3-2
// 16장 람다식 page.696
public class LambdaTest1 {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

//	23.03.08 2교시 3-2
//	16장.4 람다식(리턴값이 있는 람다식) page.704
	private static void f5() {
		Calculable2 f = (a, b) -> a + b;
		Calculable2 f3 = (a, b) -> {
			System.out.println("여러문장이라면 { } 필요");
			System.out.println("반드시 return 사용");
			return a + b;
		};
		Calculable2 f2 = new Calculable2() {
			@Override
			public int calculate(int x, int y) {
				return x + y;
			}
		};
		int result1 = f.calculate(1, 2);
		int result2 = f2.calculate(1, 2);
		int result3 = f3.calculate(1, 2);

		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}

//	23.03.08 2교시 2-4
//	16장.3 람다식(매개변수가 있는 람다식) page.701
	private static void f4() {
		Person p1 = new Person();
		p1.action1(new Workable() {
			@Override
			public void work(String name, String job) {
				System.out.println("----익명class----");
				System.out.println("이름은 : " + name);
				System.out.println("직업은 : " + job);
				System.out.println("----------------\n");
			}
		});

		p1.action1((a, b) -> {
			System.out.println("----람다식표현1----");
			System.out.println("이름1은 : " + a);
			System.out.println("직업1은 : " + b);
			System.out.println("----------------\n");
		});

		Workable f = (a, b) -> {
			System.out.println("----람다식표현2----");
			System.out.println("이름2은 : " + a);
			System.out.println("직업2은 : " + b);
			System.out.println("----------------\n");
		};
		p1.action1(f);

//		p1.action2(a -> System.out.println(a + " 말하기"));

		Speakable f2 = s -> s + "!!!";
		p1.action2(f2);
	}

//	23.03.08 2교시 1-2
//	16장 람다식 page.696
	private static void work(Runnable r) {
		Thread t1 = new Thread(r);
		t1.start();
	}

//	23.03.08 2교시 1-1
//	16장 람다식 page.696
	private static void f3() {
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				
//			}
//		};
		work(() -> {
			System.out.println("A1");
		});
		work(() -> {
			System.out.println("A2");
		});
		work(() -> {
			System.out.println("A3");
		});
		work(() -> {
			System.out.println("A4");
		});
		work(() -> {
			System.out.println("A5");
		});
	}

//	23.03.08 1교시 3-3
//	16장 람다식 page.696
	private static void action(Calculable func) {
		func.calculate(10, 20);
	}

//	23.03.08 1교시 3-2
//	16장 람다식 page.696
	private static void f2() {
//		1. 구현 class 이용 - X
//		2. 익명구현 class 이용 - O
//		(new Calculable() {
//			@Override
//			public void calculate(int x, int y) {
//				System.out.println("익명구현 class 이용");
//				System.out.println("더하기 : " + (x + y));
//			}
//		}).calculate(10, 20);
//		
//		action(new Calculable() {
//			@Override
//			public void calculate(int x, int y) {
//				System.out.println("익명구현 class 이용");
//				System.out.println("더하기 : " + (x + y));
//			}
//		});

		Calculable f1 = new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("익명구현 class 이용");
				System.out.println("더하기 : " + (x + y));
			}
		};

		Calculable f2 = new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("익명구현 class 이용");
				System.out.println("빼기 : " + (x - y));
			}
		};

//		3. 람다식 이용 - JS:화살표함수( -> )	
		Calculable f3 = (a, b) -> {
			System.out.println("람다표현식 이용");
			System.out.println("곱하기 : " + (a * b));
		};

		action(f1);
		action(f2);
		action(f3);
	}

//	23.03.08 1교시 2-1
//	16장 람다식 page.695
	private static void f1() {
//		1. 구현 class 이용
		MyInterface a = new MyClassImplement();
		a.print();

//		2. 익명구현 class 이용
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명구현class1 이용");
			}
		}).print();

		MyInterface b = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명구현class2 이용");
			}
		};
		b.print();
		b.print();

//		3. 람다식 이용 - JS:화살표함수( -> )
		MyInterface c = () -> System.out.println("람다식 이용");
		c.print();
	}
}
