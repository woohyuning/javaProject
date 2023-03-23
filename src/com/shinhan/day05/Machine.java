package com.shinhan.day05;

// 23.02.27 4교시 2-1
// 23.02.27 4교시 07-10
// abstract class는 abstract method
public abstract class Machine {

	public int b = 10;
	protected int d = 20;
	int a = 30;
	private int c = 40;

	public void f1() {}
	protected void f2() {}
	void f3() {}
	private void f4() {}
	
	public Machine(int a) {
		
	}
	
	public void powerOn() {}
	
	public void powerOff() {}
	
	public abstract void work();
	
}