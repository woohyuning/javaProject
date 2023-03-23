package com.shinhan.day05;

//23.02.27 2교시 1-1
//23.02.27 4교시 3-1
public sealed class Animal permits Cat, Dog  {
	int a = 10;
	
	void method1() {
		System.out.println("Animal Method1");
	}
}
