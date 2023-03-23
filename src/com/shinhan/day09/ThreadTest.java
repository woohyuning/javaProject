package com.shinhan.day09;

// 23.03.06 2교시 1-4
// 14장-스레드 page.592
public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("쓰레드 이름 : " + Thread.currentThread().getName() + " ...시작");

		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		Runnable r = new MyThread3();
		Thread t3 = new Thread(r);
//		스레드가 run을 수행하도록 한다.
		t1.start(); // 숫자
		t2.start(); // 대문자
		t3.start(); // 소문자
		
		for(int i = 100; i < 110; i++) {
			System.out.println(Thread.currentThread().getName() + i + "!!!!!");
		}
		
		System.out.println("쓰레드 이름 : " + Thread.currentThread().getName() + " ...끝");
	}

	private static void f2() {
		System.out.println("쓰레드 이름 : " + Thread.currentThread().getName() + " ...f2");
		for (int i = 1; i <= 26; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
		}
	}

	private static void f1() {
		System.out.println("쓰레드 이름 : " + Thread.currentThread().getName() + " ...f1");
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
		}
	}
}
