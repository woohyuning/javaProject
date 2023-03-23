package com.shinhan.day07;

import java.util.HashSet;
import java.util.Set;

// 23.03.02 3교시 1-1
// 12장.3 Object 클래스 page.497
public class ObjectTest2 {
	public static void main(String[] args) {
		f1();
//		f2();
//		f3();

	}

//	23.03.02 3교시 2-4
//	12장.3 Object 클래스(롬복) page.507
	private static void f3() {
		Computer c1 = new Computer("A");
		Computer c2 = new Computer("A", 100, "LG1");
		Computer c3 = new Computer("A", 100, "LG2");
		System.out.println(c2.getModel());
		c1.setMaker("엘지");
		System.out.println(c1.equals(c3));
		System.out.println(c2);
		System.out.println(c3);
	}

//	23.03.02 3교시 2-2
//	12장.3 Object 클래스(레코드선언) page.505
	private static void f2() {
		Person p1 = new Person("홍길동", 20);
		System.out.println(p1);
		System.out.println(p1.name());
		System.out.println(p1.age());
	}

	private static void f1() {
		ProductVO p1 = new ProductVO("컴퓨터", 100, "삼성");
		ProductVO p2 = new ProductVO("컴퓨터", 100, "삼성");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1 == p2); // 주소비교, 자바는 연산자 재정의불가
		System.out.println(p1.equals(p2)); // 재정의 안하면 주소비교
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

		Set<ProductVO> data = new HashSet<ProductVO>();
		data.add(p1);
		data.add(p2);
		for (ProductVO p : data) {
			System.out.println(p);
		}
	}
}
