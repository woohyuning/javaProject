package com.shinhan.day05.lab;

//23.02.27 8교시 9-4
//8장 LAP2
public class RectTangle extends Shape implements Resizable {
	double width;
	double height;
	
	RectTangle(int width, int height) {
		super(4);
		this.width = width;
		this.height = height;
	}
	
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * (width + height);
	}
	
	@Override
	public void resize(double s) {
		// TODO Auto-generated method stub
		width = width * s;
		height = height * s;
	}
}