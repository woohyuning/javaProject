package com.shinhan.day04;

// <5-1>
// page 262
// class : public 또는 생략
// -------접근제한자 4개 종류 --------
// public : 모든패키지에서 접근가능
// protected : 같은패키지 접근가능, 다른패키지는 상속받으면 가능
// 생략(default) : 같은패키지에서만 접근가능
// private : 같은class에서만 접근가능
public class Phone {
	// 1. field : public / protected / 생략 / private
	protected String model;
	
	// 2. 생성자 : public / 생략 / private
	public Phone() {
		System.out.println("default 생성자 정의");
	}
	
	// 3.메서드
	public void f1() {
		
	}
	protected void f2() {
		
	}
	void f3() {
		f4();
	}
	private void f4() {
		
	}
}
