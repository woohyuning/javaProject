package com.shinhan.day09;

import lombok.AllArgsConstructor;

// 23.03.06 3교시 2-2
// 14.6 스레드 동기화 page.609
// 출력영역
@AllArgsConstructor
public class BathThread extends Thread {
	BathRoom room;
	String userName;
	
	@Override
	public void run() {
		for(int i = 0; i <= 3; i++) {
			room.use(userName);
		}
	}
}
