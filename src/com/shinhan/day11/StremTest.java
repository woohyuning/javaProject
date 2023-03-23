package com.shinhan.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.shinhan.day04.Account;

public class StremTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}
//	23.03.08 4교시 1-6
//	17장.2 스트림 요소 처리(내부 반복자) page. 724
//	parallelStream : 병렬처리
	private static void f6() {
		Account[] arr = { new Account("1234", "김1"), new Account("1235", "김2"),
				new Account("1236", "김3"),
				new Account("1236", "김3"),
				new Account("1236", "김3"),
				new Account("1236", "김3"),
				new Account("1236", "김3"),
				new Account("1236", "김3")
				};
		
		List<Account> data1 = Arrays.asList(arr);
		data1.parallelStream().forEach(acc -> {
			System.out.println(acc);
			System.out.println(Thread.currentThread().getName());
			System.out.println("------------------------------------------");
		});
		System.out.println("------------------------------------------");
		data1.forEach(acc -> System.out.println(acc));
	}

//	23.03.08 4교시 1-5
//	17장.2 스트림 요소 처리(내부 반복자) page. 724
//	Set
	private static void f5() {
		Set<Account> data1 = new HashSet<>();
		data1.add(new Account("1234", "김1"));
		data1.add(new Account("1235", "김2"));
		data1.add(new Account("1236", "김3"));

		data1.stream().forEach(acc -> System.out.println(acc));
		System.out.println("------------------------------------------");
		data1.forEach(acc -> System.out.println(acc));
	}

//	23.03.08 4교시 1-4
//	17장.2 스트림 요소 처리(내부 반복자) page. 724
//	List
	private static void f4() {
		Account[] arr = { new Account("1234", "김1"), new Account("1235", "김2"), new Account("1236", "김3") };

		List<Account> data1 = Arrays.asList(arr);
		data1.stream().forEach(acc -> System.out.println(acc));
		System.out.println("------------------------------------------");
		data1.forEach(acc -> System.out.println(acc));
	}

//	23.03.08 4교시 1-3
//	17장.2 스트림 요소 처리(내부 반복자) page. 724
//	Account[]
	private static void f3() {
		Account[] arr = { new Account("1234", "김1"), new Account("1235", "김2"), new Account("1236", "김3") };
		Arrays.stream(arr).forEach(acc -> System.out.println(acc));
	}

//	23.03.08 4교시 1-2
//	17장.2 스트림 요소 처리(내부 반복자) page. 724
//	String[]
	private static void f2() {
//		1. 배열
		String[] arr1 = { "자바", "웹", "front", "back", "framework" };
//		1. 내부반복자 이용 시 stream을 얻는다
		Stream<String> st = Arrays.stream(arr1);
//		2. 내부반복자로 값을 처리한다
		Consumer<String> consumerF = (s) -> {
			System.out.println(s + "----");
		};
		st.forEach(consumerF);

		Arrays.stream(arr1).forEach((s) -> {
			System.out.println(s + "====");
		});
	}

//	23.03.08 4교시 1-1
//	17장.2 스트림 요소 처리(내부 반복자) page. 724
//	int[]
	private static void f1() {
//		1.배열
		int[] arr1 = new int[] { 100, 30, 70, 20, 50 };
		Arrays.stream(arr1).forEach(a -> System.out.println(a));
//		original stream
		IntStream is = Arrays.stream(arr1);
		IntConsumer func1 = a -> {
			System.out.println("a = " + a);
		};
		is.forEach(func1);
	}
}
