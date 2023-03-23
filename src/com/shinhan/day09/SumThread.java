package com.shinhan.day09;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 23.03.06 3교시 1-3
// 14장-5 스레드 상태 page.605
public class SumThread extends Thread {
	private long sum;
	int start = 0;
	int end = 0;
	
	public SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			sum += i;
		}
	}
}
