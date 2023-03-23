package com.shinhan.day11;

// 23.03.08 2교시 2-3
// 16장.3 람다식(매개변수가 있는 람다식) page.701
public class Person {
	public void action1(Workable workable) {
		workable.work("홍길동", "프로그래밍");
	}
	
	public void action2(Speakable speakable) {
		String result = speakable.speak("안녕하세요");
		System.out.println(result);
	}	
}