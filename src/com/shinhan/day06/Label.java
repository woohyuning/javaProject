package com.shinhan.day06;

//23.02.28 1교시 복습-4
public class Label implements Changeale {
	String text;
	int width, height;
	String color, font;

	public Label(String text, int width, int height, String color, String font) {
		super();
		this.text = text;
		this.width = width;
		this.height = height;
		this.color = color;
		this.font = font;
	}


	@Override
	public void size(int width, int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setForeground(String color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackground(String color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFont(String font) {
		// TODO Auto-generated method stub
		
	}

}
