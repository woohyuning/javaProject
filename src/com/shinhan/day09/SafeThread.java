package com.shinhan.day09;

import lombok.Setter;

//23.03.06 6교시 2-1
//14.7 스레드 안전 종료 page.618
@Setter
public class SafeThread extends Thread {
	private boolean stop; // false가 default
	
//	23.03.06 6교시 2-5
//	14.7 스레드 안전 종료 page.622
	@Override
	public void run() {

		while(true) {
			System.out.println("SafeThread...실행중");
			if(Thread.interrupted()) break;
		}

		System.out.println("자원정리");
		System.out.println("SafeThread 종료");
	}
	
//	23.03.06 6교시 2-3
//	14.7 스레드 안전 종료 page.621
//	@Override
//	public void run() {
//		try {
//			while(true) {
//				System.out.println("SafeThread...실행중");
//				sleep(1);
//			}
//		} catch(InterruptedException ex) {
//			ex.printStackTrace();
//		}
//		
//		System.out.println("자원정리");
//		System.out.println("SafeThread 종료");
//	}
	
//	23.03.06 6교시 2-1
//	14.7 스레드 안전 종료 page.618
//	@Override
//	public void run() {
//		while(!stop) {
//			System.out.println("SafeThread...실행중");
//		}
//		System.out.println("자원정리");
//		System.out.println("SafeThread 종료");
//	}
}
