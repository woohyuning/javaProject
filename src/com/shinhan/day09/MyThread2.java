package com.shinhan.day09;

// 23.03.06 2교시 1-2
// 14장-스레드 page.592
// 멀티쓰래드 만드는 방법
// 1. extends Thread.... run() 메서드 재정의
public class MyThread2 extends Thread {
	public MyThread2() {}
	
	public MyThread2(String threadname) {
		super(threadname);
	}
	
	@Override
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println(getName() + " i = " + i);
		}
	}
}
