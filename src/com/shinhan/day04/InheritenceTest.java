package com.shinhan.day04;

// <8-1>
// 상속연습
class Parent {
	int a  = 10;
	
	Parent() {
		System.out.println("Parent 생성");
	}
	void f1() {
		System.out.println("부모의 f1메서드");
	}
}

class Child extends Parent {
	String a = "자바"; // 부모가 가진 변수 이름과 같으므로 자식 변수
	int b = 20;
	
	Child() {
//		super();
		System.out.println("Child 생성");
	}
	
	void f1() {
		super.f1();
		System.out.println("자식의 f1메서드");
	}
	
	void f2() {
		System.out.println("자식의 f2메서드");
	}
}

public class InheritenceTest {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		ch.f1();
		ch.f2();		
	}
}
