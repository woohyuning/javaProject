package com.shinhan.day09;

// 23.03.06 6교시 1-3
// 14.6 스레드 동기화 page.615
public class ThreadB extends Thread {
	WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
		setName("[ThreaB]");
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			workObject.methodB();
		}
	}
}
