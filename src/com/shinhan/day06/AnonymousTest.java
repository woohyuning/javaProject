package com.shinhan.day06;

// 23.02.28 4교시 -4
// 9장-7 익명 객체 page 413
public class AnonymousTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		RemoteControl tv = new RemoteControl() {
			int a = 10;
			public void method() {
				System.out.println("구현class에서 메서드추가");
			}
			@Override
			public void turnOn() {
				System.out.println("전원을 켠다 " + a);
				method();
			}
			@Override
			public void turnOff() {
				System.out.println("전원을 끈다");
				method();
			}
		};
		tv.turnOn();
		tv.turnOff();
	}

	private static void f3() {
//		2. 익명객체-2 : 1회성
		(new Colorable() {
			@Override
			public void setForeground(String color) {
				System.out.println("익명 setForeground : " + color);
			}
			@Override
			public void setBackground(String color) {
				System.out.println("익명 setBackground : " + color);
			}
		}).setBackground("green");
	}

	private static void f2() {
//		2. 익명객체-1 : 변수대입
		Colorable a = new Colorable() {
			@Override
			public void setForeground(String color) {
				System.out.println("익명 setForeground : " + color);
			}
			@Override
			public void setBackground(String color) {
				System.out.println("익명 setBackground : " + color);
			}
		};
		a.setBackground("Black");
		a.setForeground("Purple");
	}

	private static void f1() {
//		1. 일반적인 방법
		Book b1 = new Book();
		b1.title = "이것이 자바다";
		b1.setForeground("white");
		b1.setBackground("blue");
		
		Cup c1 = new Cup();
		c1.size = 10;
		c1.setForeground("white");
		c1.setBackground("blue");
	}
}
