package com.shinhan.day05;

// 23.02.27 1교시 복습 -3
// new Child() : Object생성 - Parent생성 - Child생성
// ch.a
// ch.method1()

// final class : 상속 불가
// final filed : 값 수정 불가
// final method : 재정의 불가
class Parent extends Object {
	int a = 10;
	Parent() {
//		super();
//		a = 20; 값수정불가
		System.out.println("부모의 생성자");
		System.out.println(a);
	}
	void method1() {
		System.out.println("부모의 method");
	}
}

class Child extends Parent {
//	String a = "자바"; // 덮어쓰기
	int b = 20;
	Child() {
//		super();
		System.out.println("자식 생성자");
//		System.out.println(a);
	}

	
	  void method1() { // 덮어쓰기(Override)
		  System.out.println("자식의 method"); }
	  
	 /* void method1(String b) { // 추가(Overloading) System.out.println("자식의 method"); }
	 */
	void method2() {
		System.out.println("자식의 method2");
	}
}

public class InheritenceTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}
	private static void f4() {
		Parent ch =  new Child();
		System.out.println(ch.a); //+ ch.b);
		ch.method1();
//		ch.method2();
	}
	private static void f3() {
//		부모를 통해서 자식을 본다...부모의 변수와 메서드만 호출가능
		Parent ch =  new Child();
		System.out.println(ch.a); //+ ch.b);
		ch.method1();
//		ch.method2();
	}
	
	private static void f2() {
		Child ch =  new Child();
		System.out.println(ch.a + ch.b);
		ch.method1();
		ch.method2();
	}

	private static void f1() {
		Student st1 = new Student("123", "홍길동");
		Student st2 = new Student("124", "박길동", "컴공");
		Student st3 = new Student("125", "양길동", "화학", 99);
		ExchangeStuedent st4 = new ExchangeStuedent("126", "은빈", new String[] {"영어", "프랑스"});
		
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(st4);
		System.out.println(Student.count + "명");
	}
}
