package com.shinhan.day04;

import java.util.Calendar;

// <6-2>
// page 273. 싱글톤 패턴
public class singletonTest {
	public static void main(String[] args) {
		MyServlet a = MyServlet.getInstance();
		MyServlet b = MyServlet.getInstance();
		
		System.out.println(a==b);
		
		a.print();
		b.print2();
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
	}
}
