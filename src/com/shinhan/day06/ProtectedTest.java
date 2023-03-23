package com.shinhan.day06;

import com.shinhan.day05.Machine;

//23.02.27 4교시 2-3
public class ProtectedTest extends Machine {
	
	void test2() {
//		System.out.println(a+b+c+d);
		System.out.println(b+d);
		f1();
		f2();
	}

	protected void f2() {
		System.out.println("재정의 가능");
	}
	
	void test() {
//		Machine m = new Machine;
	}

	public ProtectedTest(int a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
}
