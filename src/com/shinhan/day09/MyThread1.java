package com.shinhan.day09;

// 23.03.06 2교시 1-1
// 14장-스레드 page.592
// 멀티쓰래드 만드는 방법
// 1. extends Thread.... run() 메서드 재정의
public class MyThread1 extends Thread {
	public MyThread1() {}
	
	public MyThread1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 26; i++) {
			System.out.println(getName() + " i = " + i);
		}
	}
}
