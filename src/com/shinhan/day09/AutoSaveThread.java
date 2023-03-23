package com.shinhan.day09;

//23.03.06 6교시 3-1
//14.8 데몬 스레드 page.624
public class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업내용을 저장합니다");
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
}
