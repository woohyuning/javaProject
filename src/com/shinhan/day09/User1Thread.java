package com.shinhan.day09;

import lombok.Setter;

@Setter
// 23.03.06 4교시 1-2
// 14.6 스레드 동기화 page.612
public class User1Thread extends Thread {
	Calculator calculator;

	public User1Thread() {
		setName("User1Thread");
	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}
}
