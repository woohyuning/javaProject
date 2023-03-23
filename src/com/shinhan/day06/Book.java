package com.shinhan.day06;

// 23.02.28 4교시 -2
// 9장-7 익명 객체 page 413
public class Book implements Colorable{
	String title;
	String foregroundColor;
	String backgroundColor;
	
	@Override
	public void setForeground(String color) {
		foregroundColor = color;
		System.out.println("Book의 Foreground 변경 : " + color);
		System.out.println("-----------------------------");
	}

	@Override
	public void setBackground(String color) {
		backgroundColor = color;
		System.out.println("Book의 Background 변경 : " + color);
		System.out.println("-----------------------------");
	}
	
}
