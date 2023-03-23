package com.shinhan.day09;

// 23.03.06 3교시 1-1
// 14장-5 스레드 상태 page.606
public class WorkThread extends Thread {
	public boolean work = true;

	public WorkThread() {
	}

	public WorkThread(String name) {
//		super(name);
		setName(name);
	}

	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(getName() + ".....작업처리");
			} else {
				Thread.yield(); // 나의 스레드 잠깐 멈춤... 다른스레드에 양보... 계속진행
			}
		}
	}
}
