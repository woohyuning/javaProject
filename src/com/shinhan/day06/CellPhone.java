package com.shinhan.day06;

//23.02.28 8교시 -2
//23.03.02 1교시 복습-3
//LAB 12
public class CellPhone {
	String model;
	double battey = 60;

	CellPhone(String model) {
		this.model = model;
	}

	void call(int time) {
		battey -= time * 0.5;
		if (battey < 0)
			battey = 0;
//		강제Exception발세으 처리는 안함, RuntimeExceptiin에 속한 Exception은 자동으로 throws(던져진다)
		if (time < 0)
			throw new IllegalArgumentException("통화시간입력오류");
		System.out.println("통화 시간 : " + time + "분");
	}

	void charge(int time) {
		battey = time * 2;
		if (battey > 100)
			battey = 100;
		if (time < 0)
			throw new IllegalArgumentException("충전시간입력오류");
		System.out.println("충전 시간 : " + time + "분");
	}

	void printBattery() {
		System.out.println("남은 배터리 양 : " + battey);
	}

//	// Object 타입의 객체를 입력받고, 입력받은 객체가CellPhone 타입의 클래스이면서 모델 번호가 같은 경우에 true를 리턴한다.
//	override : 함수이름, 매개타입과 갯수, return타입이 모두 같아야하고, 접근제한자는 같거나 더 넓어져야한다.
//	overloading : 매개타입과 갯수가 다르면 Overloading이다.
	@Override
	public boolean equals(Object otherObject) {
//		CellPhone cp = (CellPhone) otherObject;
		if (otherObject instanceof CellPhone cp) {
			return this.model.equals(cp.model);
		}
		return false;

//		if (otherObject.equals(model)) {
//			return true;
//		}
//		return false;
	}
}
