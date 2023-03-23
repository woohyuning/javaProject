package com.shinhan.day06;

//23.02.28 3교시 -6
//9장-6 중첩 인터페이스 page 409
public class InnerInterfaceTest {
	public static void main(String[] args) {
//		Button b1 = new Button();
//		Button.ClickListener listener = new OkListener();
//		b1.setClickListener(listener);
//		b1.buttonClick();
//
//		Button.ClickListener listener2 = new CancleListener();
//		b1.setClickListener(listener2);
//		b1.buttonClick();
		
		Button b1 = new Button();
		Button b2 = new Button();
		Button.ClickListener listener = new OkListener();
		Button.ClickListener listener2 = new CancleListener();
		test(b1, listener);
		test(b2, listener2);
	}
	static void test(Button b1, Button.ClickListener listener) {
		b1.setClickListener(listener); // callback
		b1.buttonClick();
	}
}
