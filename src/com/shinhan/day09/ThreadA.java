package com.shinhan.day09;

// 23.03.06 6교시 1-2
// 14.6 스레드 동기화 page.615
public class ThreadA extends Thread {
	WorkObject workObject;
	
	public ThreadA(WorkObject workObject) {
		setName("[ThreaA]");
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			workObject.methodA();
		}
	}
}
