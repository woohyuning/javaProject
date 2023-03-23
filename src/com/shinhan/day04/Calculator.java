package com.shinhan.day04;

// <1-1>
// Class : Object를 만들기 위한 틀
// Object : class를 이용해서 만들어진 실체(instance)
public class Calculator {
	// 1. Field(특징, 속성, 변수) : static(class 변수), non-static(instance 변수)
	private String color;
	private int price;
	private String model;
	static String company="신한";
	
	// 2. 생성자(new할 때 자동실행되는 메서드)...컴파일 시 자동으로 default 생성자가 제공
	// 생성자는 초기화가 목적
	// 생성자를 정의하면 default 생성자가 제공 안됨
	// this : 이 class를 이용해서 만든 현재객체
	// 1. 매개변수 이름과 맴버변수 이름이 충돌(구분이 필요하다)
	// 2. 하나의 생성자가 다른 생성자를 호출할 때 사용
	// 생성자 Overloading : 이름은 같고 매개변수 사양이 다르다.
	Calculator(String color) {
		this(null, color, 1000);
	}
	Calculator(String model, String color) {
		this(model, color, 1000);
	}
	Calculator(String model, String color, int price) {
		this.color = color;
		this.model = model;
		this.price = price;
	}
	
	// 3. method(일반메서드)...기능(동사)
	// void : return 값이 없다.
	// private로 정보은닉 되어있는 맴버변수들을 읽는 기능구현(getter)
	// private로 정보은닉 되어있는 맴버변수들을 수정 기능구현(setter)
	// static에서 this 사용불가, instance생성없이 사용되는 메서드이므로 instance변수 사용불가
	public static void powerOn() {
		System.out.println(company + " 회사의 계산기 전원을 켠다.");
		// return; // 생략
		// return 100; // 불가능	
	}
	
	void powerOff() {
		System.out.println(color + ", " + model + " 모델의 계산기 전원을 끈다.");
	}
	
	int add(int a, int b) {
		return a + b;
	}
	
	int sub(int a, int b) {
		return a - b;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}	
	
	// 4. block ( instance, static )
	{
		System.out.println("instance 생성시마다 수행된다.");
		System.out.println("-----------------------");
	}

	static {
		System.out.println("1.class load시에 1회 수행된다.");
		System.out.println("*********************");
	}
	
	static {
		System.out.println("2.class load시에 1회 수행된다.");
		System.out.println("*********************");
	}
	
	// 5. inner class
	class AA {
		
	}
}
