package com.shinhan.day06;

//23.02.28 2~3교시 -2
//9장 중첩클래스 page 394
public class InnerClassTest {
	public static void main(String[] args) {
//		f1();
		f2();
//		f3();
//		f4();
	}

	private static void f4() {
//		4. LocalClass test
		OuterClass outer = new OuterClass();
		outer.f1(1);
	}

	private static void f3() {
//		3. StaticInnerClass class 사용
		OuterClass.StaticInnerClass v1 = new OuterClass.StaticInnerClass();
		
		System.out.println("StaticInnerClass instance filed : " + v1.s1);
		System.out.println("StaticInnerClass static filed : " + OuterClass.StaticInnerClass.s2);
		v1.method3();
		OuterClass.StaticInnerClass.method4();
	}

	private static void f2() {
//		2. InstanceInnerClass 사용
//		OuterClass outer = new OuterClass();
//		OuterClass.InsctnceInnerClass v1 = outer.new InsctnceInnerClass();
		OuterClass.InsctnceInnerClass v1 = new OuterClass().new InsctnceInnerClass();
		
		System.out.println("InstanceInnerClass instance filed : " + v1.s1);
		System.out.println("InstanceInnerClass static filed : " + OuterClass.InsctnceInnerClass.s2);
		v1.method3();
		OuterClass.InsctnceInnerClass.method4();
	}

	private static void f1() {
//		1. 일반적인 class 사용
		OuterClass v1 = new OuterClass();
		
		System.out.println("instance filed : " + v1.a);
		System.out.println("static instance filed : " + OuterClass.b);
		v1.method1();
		OuterClass.method2();
	}
}
