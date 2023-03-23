package com.shinhan.day09;

import lombok.Setter;

@Setter
// 23.03.06 4교시 1-3
// 14.6 스레드 동기화 page.612
public class User2Thread extends Thread {
	Calculator calculator;

	public User2Thread() {
		setName("User2Thread");
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
