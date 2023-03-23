package com.shinhan.day05;

//23.02.27 4교시 1-3
public class Circle extends Shape{
	private double radius;
	double circumference;
	
	public Circle(String color, double radius) {
		super(color, "Circle");
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return radius * Math.PI;
	}

	@Override
	public double calculatePerimeter() {
		circumference = 2 * Math.PI;
		return circumference;
	}

	public double getRadius() {
		return radius;
	}

}
