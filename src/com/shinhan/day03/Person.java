package com.shinhan.day03;

public class Person {
	// 맴버변수 : instance 변수, static 변수
	static int numberOfPersons; // 전체 인구 수
								// Person 객체가 생성될 때 마다 증가
	int age;
	String name;
	
	Person() {
		this(12, "Anonymous");
	}
	Person(int age, String name) {
		this.age = age;
		this.name = name;
		
		numberOfPersons++;
	}
	public void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살 입니다." );
	}
	public int getPopulation(int numberOfPersons) {
		System.out.println("전체 인구수 : " + numberOfPersons);
		
		return numberOfPersons;
	}
	
}
