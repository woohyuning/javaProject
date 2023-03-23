package com.shinhan.day05;

//23.02.27 5교시 5-3
public class SybaseDB implements JDBCInterface {

	@Override
	public void dbConnect(String dbName) {
		System.out.println("SybaseDB..상수접근 :" + JDBC);
		System.out.println("SybaseDB..상수접근 :" + JDBC2);
//		default method 호출
		select();
//		static method 호출
		JDBCInterface.update();
//		private는 호출불가
	}
	
	@Override
	public void dbConnect2(String dbName) {
		System.out.println(dbName +"SybaseDB dbConnect2");
	}
	
	public void select() {
		System.out.println("SybaseDB..select 재정의가 가능하다");
	}
	
}
