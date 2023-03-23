package com.shinhan.day06;

// 23.02.27 7교시 7-1. 인터페이스 타입변환
// page 368
interface A {
	void method1();
}
class B implements A {
	public void method1() {
		System.out.println("B 메서드 재정의");
	}
}
class C implements A {
	public void method1() {
		System.out.println("C 메서드 재정의");
	}
}
class D extends B {
	public void method1() {
		System.out.println("D 메서드 재정의");
	}
	public void method2() {
		System.out.println("D 메서드2 추가");
	}
}
class E extends C {
	public void method1() {
		System.out.println("E 메서드 재정의");
	}
}

public class InterfaceCastingTest {
	public static void main(String[] args) {
		A v1 = new D();
		B v2 = new D();
		D v3 = new D();
		
		v1.method1();
		v2.method1();
		v3.method1();
		
		((D)v1).method2();
		((D)v2).method2();
		v3.method2();
		
//		실행오류
//		E e = (E) v1;
//		e.method1();
	}
}
