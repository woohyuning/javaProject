package com.shinhan.day09;

//23.03.06 2교시 1-5
//14장-스레드 page.592
//Thread를 익명구현객체로 만들기
public class ThreadTest2 {
	public static void main(String[] args) {
		System.out.println("main start");
		f1();
		System.out.println("main end");
	}

	private static void f1() {
//		Thread t1 = new MyThead1();
//		Thread t2 = new MyThead2();
//		Runnable r = new MyThead3();
//		Thread t3 = new Thread(r);
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (char i = 'A'; i <= 'Z'; i++) {
					System.out.println(getName() + " i = " + i);
					try {
						sleep((int) Math.random() * 100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 26; i++) {
					System.out.println(getName() + " i = " + i);
					try {
						sleep((int) Math.random() * 100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (char i = 'a'; i <= 'z'; i++) {
					System.out.println(Thread.currentThread().getName() + " i = " + i);
					try {
						Thread.sleep((int) Math.random() * 100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		t1.start(); // 숫자
		t2.start(); // 대문자
		t3.start(); // 소문자
	}
}
