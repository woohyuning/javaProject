package com.shinhan.day07;

//23.02.28 8교시 -1
//23.03.02 1교시 복습-4
//LAB 12
public class CellPhoneMain {

	public static void main(String[] args) {
		CellPhone myPhone = new CellPhone("SCH-600");

		myPhone.charge(20); // 20분간 충전을 한다.
		myPhone.printBattery();

		myPhone.call(300); // 300분간 통화를 한다.
		myPhone.printBattery();

		myPhone.charge(50); // 50분간 충전을 한다.
		myPhone.printBattery();

		myPhone.call(40); // 40분간 통화를 한다.
		myPhone.printBattery();

//		Exception 처리를 내가한다.
		try {
			myPhone.call(-20); // 통화시간이 잘못 입력되었다.
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		CellPhone yourPhone = new CellPhone("SCH-600");

		String s1 = new String("자바");
		String s2 = new String("자바");

//		System.out.println(System.identityHashCode(myPhone));
//		System.out.println(System.identityHashCode(yourPhone));
//		System.out.println(s1.equals(s2) ? "내용이같다" : "내용이다르다");
//		System.out.println(System.identityHashCode(s1));
//		System.out.println(System.identityHashCode(s2));
		
		if (myPhone.equals(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}
}
