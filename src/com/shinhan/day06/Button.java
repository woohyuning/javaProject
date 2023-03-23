package com.shinhan.day06;

//23.02.28 3교시 -3
//9장-6 중첩 인터페이스 page 409
public class Button {
//	filed
	int a;
	private ClickListener listener;
	
//	method	
	void setClickListener(ClickListener listener) {
		this.listener = listener;
	}
	public void buttonClick() {
		listener.onClick();
	}
	
//	내부 interface...규격서
	static interface ClickListener {
		void onClick();
	}
}
