package com.shinhan.day09;

// 23.03.06 2교시 1-3
// 14장-스레드 page.592
// 멀티쓰래드 만드는 방법
// 1. extends Thread.... Thread class 상속 받아 run() 메서드 재정의
// 2. implements Runnable... 이미 부모class를 상속 받은 경우는 Runnable interface 구현한다.
public class MyThread3 extends Object implements Runnable {

	@Override
	public void run() {
		for (char i = 'a'; i <= 'z'; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
		}
	}
}
