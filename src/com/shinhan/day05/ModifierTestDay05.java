package com.shinhan.day05;

import com.shinhan.day04.Phone;

// <5-2>
// page 262
// 다른 패키지 연습
public class ModifierTestDay05 extends Phone {
	private void method() {
		System.out.println(model);
		f2();
	}
	
	public static void main(String[] args) {
		Phone p = new Phone();
//		p.model = "겔럭시22";
		
		System.out.println(p);
		
		p.f1();

	}
}
