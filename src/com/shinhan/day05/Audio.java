package com.shinhan.day05;

//23.02.27 6교시 6-4
// 구현class
public class Audio implements RemoteControl, WIFI {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + " 전원켠다");
	}
	
	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + " 전원끈다");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		RemoteControl.super.display();
		System.out.println("default method");
	}
	void display2() {
		System.out.println("!!!!!!!!!!1");
	}

	@Override
	public void wifiTurnOn() {
		System.out.println("wifi turn on");
	}
}
