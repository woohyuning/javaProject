package com.shinhan.day05;

import com.shinhan.day05.lab.Resizable;

//23.02.27 4교시 1-4
public class Rectangle extends Shape {
	int width;
	int length;

	public Rectangle(String color, int width, int length) {
		super(color, "Rectangle");
		this.width = width;
		this.length = length;
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width * length;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2 * (width + length);
	}

}
