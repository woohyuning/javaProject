package com.shinhan.day06;

//23.02.28 3교시 -4
//9장-6 중첩 인터페이스 page 409
public class OkListener implements Button.ClickListener{

	@Override
	public void onClick() {
		System.out.println("OK Button클릭 시 수행되는 로직입니다.");
		System.out.println("----------------------------");
	}

}
