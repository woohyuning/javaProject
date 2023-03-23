package com.shinhan.day09;

//23.03.06 7교시 1-1
//14장-확인문제2 page.633

class MovieThread extends Thread {
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			System.out.println("동양상을 재생합니다.");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class MusicRunnable implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			System.out.println("음악을 재생합니다.");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ThreadExample {
	public static void main(String[] args) {
		Thread t1 = new MovieThread();
		t1.start();
		
		Thread t2 = new Thread(new MusicRunnable());
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 3; i++) {
					System.out.println("익명메소드 활용");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t3.start();
	}
}
