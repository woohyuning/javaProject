package com.shinhan.day09;

// 23.03.06 2교시 1-6
// 14장-4 스레드 이름 page.600
public class ThreadTest3 {
	public static void main(String[] args) {
		System.out.println("main thread 시작");
		
		Thread t1 = new MyThread1("숫자 출력 Thread");
		Thread t2 = new MyThread2("대문자 출력 Thread");
		Runnable r = new MyThread3();
		Thread t3 =  new Thread(r);
		
		System.out.println("t1 : " + t1.getState().name());
		System.out.println("t2 : " + t2.getState().name());
		System.out.println("t3 : " + t3.getState().name());
		
		t3.setName("소문자 출력 Thread");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("t1 : " + t1.getState().name());
		System.out.println("t2 : " + t2.getState().name());
		System.out.println("t3 : " + t3.getState().name());
				
		System.out.println("main thread 끝");
	}
}