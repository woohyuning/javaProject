package com.shinhan.day09;

import lombok.Getter;

@Getter
// 23.03.06 4교시 1-1
// 14.6 스레드 동기화 page.611
public class Calculator {
	int memory;

	public synchronized void setMemory(int memory) {
		synchronized (this) {
			this.memory = memory;
			System.out.println(Thread.currentThread().getName() + " -> 메모리 저장 값 : " + this.memory);
		}
	}
	
//	public synchronized void setMemory(int memory) {
//		this.memory = memory;
//		System.out.println(Thread.currentThread().getName() + " -> 메모리 저장 값 : " + this.memory);
//	}
}
