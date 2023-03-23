package com.shinhan.day11;

//23.03.08 2교시 3-1
//16장.4 람다식(리턴값이 있는 람다식) page.704
// 함수형표현 - 람다식 : 람다표현식으로 표현가능한지 @FunctionalInterface로 확인가능
// interface에 1개의 메서드만 존재해야한다
@FunctionalInterface
public interface Calculable2 {
//	추상메서드 정의
	int calculate(int x, int y);
//	void calculate2(int x, int y);
}
