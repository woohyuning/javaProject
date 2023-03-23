package com.shinhan.day08;

// 23.03.03 5교시 3-4
// 13장-연습문제4
public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 25);
		Integer age = Util.getValue2(pair, "홍길동");
		System.out.println("pair 나이는 : " + age);

		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer age2 = Util.getValue2(childPair, "홍삼순");
		System.out.println("childPair 나이는 : " + age2);
//		오류
		/*
		 * OtherPair<String, Integer> OtherPair = new OtherPair<>("홍삼원", 20); Integer
		 * age3 = Util.getValue(OtherPair, "홍삼순"); System.out.println("childPair 나이는 : "
		 * + age3);
		 */
	}
}