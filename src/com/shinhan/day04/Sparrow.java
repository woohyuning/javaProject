package com.shinhan.day04;

// <4-2>
// 자바의 최상위 class : Object ( toString, equals, ... )
public class Sparrow {
	private String name;
	private int legs;
	private int length;

	public Sparrow(String name, int legs, int length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}

	public void fly() {
		System.out.println("참새(" + name + ")는 날지 않습니다.");
	}
	
	public void sing() {
		System.out.println("참새(" + name + ")가 소리내어 웁니다.");
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void display() {
		System.out.println("참새의 이름은 " + name + " 입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.");
	}
}
