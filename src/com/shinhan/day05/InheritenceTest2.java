package com.shinhan.day05;

// 07-09
class A {}
class B extends A {}
class C extends A {}
class D extends B {
	int max = 100;
}
class E extends B {}
class F extends C {}



//23.02.27 2교시 3
//23.02.27 2교시 2-5
public class InheritenceTest2 {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}
	
//	07-09
	private static void f5() {
//		자동형변환 : 부모타입 = 자식객체
		D v1 = new D();
		B v2 = new D();
		A v3 = new D();
		System.out.println(v1.max);
//		System.out.println(v2.max);
//		강제형변환 : 자식타입 = (자식타입) 부모타입객체
		D v4 = (D) v2;
		System.out.println(v4.max);
//		System.out.println(v3.max);
		D v5 = (D) v3;
		System.out.println(v5.max);
		
//		E v6 = (E) v2; // 컴파일 시에 오류 없음
//		본래 생성된 Instance로만 형변환이 가능하다.
//		E v7 = (E) v3;
		
//		형변환가능한지 체크하자
		System.out.println(v3 instanceof D ? "OK" : "NO 형변환불가");
		System.out.println(v3 instanceof E ? "OK" : "NO 형변환불가");
		
		if(v3 instanceof D dd) { // 12버전부터 형변환결과 받을 변수추가됨
			System.out.println(dd.max);
		}
	}

	private static void f4() {
		CarTest car = new CarTest();
		HankokTire hk = new HankokTire();
		car.go(hk);
		car.go(new KumhoTire());
	}

	private static void f3() {
		Cat c1 = new Cat();
		Dog d1 = new Dog();
		call(c1);
		call(d1);
	}

	private static void call(Animal ani) {
		ani.method1();
		if(ani instanceof Dog) {
			Dog d2 = (Dog) ani;
			d2.method3();
			System.out.println(d2.a + d2.c);
		} else if(ani instanceof Cat) {
			Cat c2 = (Cat) ani;
			c2.method2();
			System.out.println(c2.a + c2.b);
		}
	}

	private static void f2() {
//		field, method는 instance가 아닌 타입을 따른다
		Animal c1 = new Cat();
		System.out.println(c1.a);
//		System.out.println(c1.b);
		c1.method1();
//		c1.method2();
	}
	private static void f1() {
		Cat c1 = new Cat();
		System.out.println(c1.a);
		c1.method1();
	}
}
