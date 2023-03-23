package com.shinhan.day09;

//import lombok.AllArgsConstructor;

//23.03.06 5교시 1-4
//14.6 스레드 동기화 page.612
//@AllArgsConstructor
public class PrintThread extends Thread {
	ShareArea share;

	public PrintThread(ShareArea share) {
		this.share = share;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			share.printBalance();
		}
	}
}
