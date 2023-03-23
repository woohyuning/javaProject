package com.shinhan.day05;

//23.02.27 6교시 6-3
// 구현class
public class Television implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원켠다");
	}
	
	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원끈다");
	}
	void display2() {
		System.out.println("!!!!!!!!!!11");
	}
}
