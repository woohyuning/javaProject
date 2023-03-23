package com.shinhan.day06;

import com.shinhan.day06.Button.ClickListener;

//23.02.28 3교시 -5
//9장-6 중첩 인터페이스 page 409
public class CancleListener implements ClickListener{
	
	@Override
	public void onClick() {
		System.out.println("Cancle Button클릭 시 수행되는 로직입니다.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
