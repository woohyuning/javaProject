package com.shinhan.day05;




// 23.02.27 4교시 1-1
// abstract class : abstract method가 1개이상 있다.
// 직접객체 생성불가 -> new Shape() 불가
// abstract class 상속받은 자식 class를 이용해서 객체생성가능
public abstract class Shape {

	private String color;
	private String type;
	
	public Shape() {}
	
	public Shape(String color, String type)	{
		this.color = color;
		this.type = type;
	}
	
	public String getColor() {
		return color;
	}
	public String getType()	{
		return type;
	}
	
//	abstract method : 정의는 있고 구현은 상속 받은 자식 class에서 반드시한다.(override)
	public abstract double calculateArea();
	
	public abstract double calculatePerimeter();
	
	public String toString() {
		return color + " " + type;
	}
	
}
