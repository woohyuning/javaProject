package com.shinhan.day08;

// 23.03.03 4교시 2-3
// 13장-5 와일드카드 타입 파라미터
public class Course {
	public static void registerCourse(Applicant<?> appicant) {
		System.out.println(appicant.kind.getClass().getSimpleName() + "가 등록한 과정임...모두");
	}

	public static void registerCourse2(Applicant<? extends Student> appicant) {
		System.out.println(appicant.kind.getClass().getSimpleName() + "가 등록한 과정임...Student, HighStudent, MiddleStudent");
	}
	
	public static void registerCourse3(Applicant<? super Worker> appicant) {
		System.out.println(appicant.kind.getClass().getSimpleName() + "가 등록한 과정임...Worker, Person");
	}
}
