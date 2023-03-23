package com.shinhan.day09;

// 23.03.06 6교시 1-1
// 14.6 스레드 동기화 page.615
// 공유영역
public class WorkObject {
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " 작업 실행A...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " 작업 실행B...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
