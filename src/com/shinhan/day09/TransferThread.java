package com.shinhan.day09;

//import lombok.AllArgsConstructor;

//23.03.06 5교시 1-3
//14.6 스레드 동기화 page.612
//@AllArgsConstructor
public class TransferThread extends Thread {
	ShareArea share;

	public TransferThread(ShareArea share) {
		this.share = share;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 12; i++) {
			share.transfer();
		}
	}
}
