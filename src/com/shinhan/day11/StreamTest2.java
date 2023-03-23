package com.shinhan.day11;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

// 23.03.08 4교시 2-1
// 17장.3 중간 처리와 최종 처리 page.728
public class StreamTest2 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍1", 100),
				new Student("홍5", 70),
				new Student("홍3", 80),
				new Student("홍2", 40),
				new Student("홍4", 90)
		);

//		list.forEach(st -> System.out.println(st));
//		mapToInt : 중간 처리
//		map : 변형한다는 의미
//		average() : 최종처리 - 평균구함
		double avg = list.stream().mapToInt(st -> st.getScore()).average().getAsDouble();
		System.out.println(avg);
		
		OptionalDouble opAvg = list.stream().mapToInt(st -> st.getScore()).average();
		opAvg.ifPresentOrElse(a -> System.out.println("평균 : " + a), () -> System.out.println("평균 계산 할 수 없음"));
	}
}
