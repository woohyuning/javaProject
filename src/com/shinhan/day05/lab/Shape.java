package com.shinhan.day05.lab;

//23.02.27 8교시 9-1
//8장 LAP2
public abstract class Shape {
	int numSides;
	
	Shape(int numSides) {
		this.numSides = numSides;
	}
	
	public int getNumSides() {
		return numSides;
	}
	
	abstract double getArea(); // 넓이
	abstract double getPerimeter(); // 둘레
}