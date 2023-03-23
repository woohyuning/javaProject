package com.shinhan.day06;

// 23.02.28 4교시 -3
// 9장-7 익명 객체 page 413
public class Cup implements Colorable{
	int size;
	String foregroundColor;
	String backgroundColor;
	
	@Override
	public void setForeground(String color) {
		foregroundColor = color;
		System.out.println("Cup의 Foreground 변경 : " + color);
		System.out.println("-----------------------------");
	}

	@Override
	public void setBackground(String color) {
		backgroundColor = color;
		System.out.println("Cup의 Background 변경 : " + color);
		System.out.println("-----------------------------");
	}
	
}
