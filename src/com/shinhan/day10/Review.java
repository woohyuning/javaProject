package com.shinhan.day10;

// thread.start() 하면 run() 호출된다.
// 1. Thread 상속
class MyThreadA extends Thread {
	MyThreadA(String name) {
		super(name);
//		setName(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + " : " + i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

// 2. 이미 상속 중이라면 Runnable interface구현
class MyThreadB extends Object implements Runnable {

	@Override
	public void run() {
		for (int i = 100; i <= 110; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

// 23.03.07 1교시 1-1
// 14장 Thread 복습
public class Review {
	public static void main(String[] args) {
		MyThreadA t1 = new MyThreadA("스레드A");
		Thread t2 = new Thread(new MyThreadB());
		Thread t3 = new Thread() { // 익명 스레드 구현
			public void run() {
				for (int i = 200; i <= 210; i++) {
					System.out.println(getName() + " : " + i);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t4 = new Thread(new Runnable() {  // 익명 스레드 구현
			
			@Override
			public void run() {
				for (int i = 300; i <= 310; i++) {
					System.out.println(Thread.currentThread().getName() + " : " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("main end");
	}
}
