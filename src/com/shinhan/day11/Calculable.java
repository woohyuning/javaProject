package com.shinhan.day11;

// 23.03.08 1교시 3-1
// 16장 람다식 page.696
// 함수형표현 - 람다식 : 람다표현식으로 표현가능한지 @FunctionalInterface로 확인가능
// interface에 1개의 메서드만 존재해야한다
@FunctionalInterface
public interface Calculable {
//	추상메서드 정의
	void calculate(int x, int y);
//	void calculate2(int x, int y);
}
