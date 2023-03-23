package com.shinhan.day06;

class Parent {
	
}
class Child extends Parent{
	
}
//23.02.28 8교시 -1
//Exception <- RunTimeException <- IllegalArgumentException
//#Exception 발생?  1.자동 2.강제(throw)
//#Exception 처리해야할까? 안해도될까? (RunTimeException은 안해도된다)
//-------------RunTimeException은 JVM이 오류메시지보여주고 프로그램중지
//#Exception 처리 : 1.내가한다 2.떠넘긴다.
//1.내가한다(try~catch~finally)
//2.떠넘긴다. (메서드의 선언부에 throws 예외이름)
public class ExceptionTest3 {
	public static void main(String[] args) {
		Parent a = new Parent();
		Child b = (Child)a;
		int score = 20;
//		강제
		if(score < 70) {
			throw new IllegalArgumentException("70점 이상만 가능");
		}
		System.out.println("main end");
	}
}
