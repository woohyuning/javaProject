package com.shinhan.day05;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTest {
	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
//		f4();
//		f5();
	}
//	23.02.27 6교시 6-6
	private static void f5() {
		String[] arr = new String[] {"자바", "SQL", "WEB", "Spring"};
//		List, Set, Map
//		List interface : 순서가 있다, 중복허용, ArrayList, Vector, LinkedList
//		Set : 순서가 없다, 중복불가
		List<String> data = new ArrayList<String>();
		data.add("자바");
		data.add("SQL");
		data.add("WEB");
		data.add("자바");
		data.add("Spring");
		
		print(data);
	}
	
	static void print(List<String> data) {
		for(String s : data) {
			System.out.println(s);
		}
	}
	
//	23.02.27 6교시 6-5
//	23.02.27 7교시 6-8
//	자동형변환 + override -> 다형성
//	사용법은 같고 결과는 다양하다
	private static void f4(RemoteControl rc) {
		rc.powerOn();
		rc.powerOff();
		rc.display();
		RemoteControl.display2(); // static 호출
		
		
		if(rc instanceof Audio audio) {
			audio.display2();
			audio.wifiTurnOn();
		}
		if(rc instanceof WIFI wifi) {
			wifi.wifiTurnOn();
		}
	}
//	23.02.27 6교시 6-4
	private static void f3() {
		f4(new Television());
		f4(new Audio());
	}
//	23.02.27 6교시 6-1
	private static void f2() {
		String s1 = "Z";
		String s2 = "A";
		System.out.println(s1.compareTo(s2));
	}
//	23.02.27 5교시 5-4
	private static void f1() {
//		1. 객체 생성
		OracleDB odb = new OracleDB();
		SybaseDB sdb = new SybaseDB();
		
//		OracleDB 사용
//		SybaseDB 사용
		use(odb);
		
	}

	private static void use(JDBCInterface db) {
		db.dbConnect("데이터베이스!");
	}
}
