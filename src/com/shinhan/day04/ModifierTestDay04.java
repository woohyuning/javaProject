package com.shinhan.day04;

// <5-3>
// page 262
// 같은 패키지 연습
public class ModifierTestDay04 {

	public static void main(String[] args) {
		Phone p = new Phone();
		p.model = "겔럭시22";
		
		System.out.println(p);
		
		p.f1();
		p.f2();
		p.f3();
		
	}

}
