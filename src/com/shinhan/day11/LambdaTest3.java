package com.shinhan.day11;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.shinhan.day04.Account;

//23.03.08 3교시 1-1
//16장.5(구) 표준 API의 함수적 인터페이스(Consumer)
public class LambdaTest3 {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f8();
	}

//	23.03.08 3교시 3-1
//	16장.6 생성자 참조( 클래스 :: new ) page.712
	private static void f8() {
		BiFunction<String, String, Account> func2 = (no, owner) -> {
			System.out.println("계좌번호 : " + no);
			System.out.println("owner : " + owner);
			return new Account(no, owner);
		};
		Account acc = func2.apply("1234", "KIM");
		System.out.println(acc);
		
		BiFunction<String, String, Account> func3 = Account :: new;
		Account acc2 = func3.apply("4567", "PARK");
		System.out.println(acc2);
	}

//	23.03.08 3교시 2-2
//	16장.5 메소드 참조(Math.max())  page.706
	private static void f7() {
//		BiFunction<Integer, Integer, Integer> func1 = (a, b) -> Math.max(a, b);
		BiFunction<Integer, Integer, Integer> func1 = Math::max;
		int result = func1.apply(10, 20);
		System.out.println("큰값 : " + result);
	}

//	23.03.08 3교시 2-1
//	16장.5 메소드 참조 page.706
	private static void f6() {
		BiFunction<Integer, Integer, Integer> func1 = (a, b) -> {
			if (a > b) {
				return a;
			} else {
				return b;
			}
		};
		int result = func1.apply(10, 20);
		System.out.println("큰값 : " + result);
	}

//	23.03.08 3교시 1-4
//	16장.5(구) 표준 API의 함수적 인터페이스(Predicate)
//	boolean값 출력
	private static void f5() {
		Predicate<Integer> func1 = (a) -> a > 10;
		boolean result = func1.test(20);
		System.out.println(result);

		Predicate<Account> func2 = (a) -> {
			System.out.println("---Account의 잔고조사---");
			System.out.println(a);
			return a.getBalance() >= 100;
		};
		boolean result2 = func2.test(new Account("1234", "Hong", 1000));
		System.out.println(result2);
	}

//	23.03.08 3교시 1-4
//	16장.5(구) 표준 API의 함수적 인터페이스(Operator)
	private static void f4() {
		BinaryOperator<Integer> func1 = (a, b) -> a + b;
		BinaryOperator<Integer> func2 = (a, b) -> a - b;

		System.out.println(func1.apply(1, 2));
		System.out.println(func2.apply(1, 2));
	}

//	23.03.08 3교시 1-3
//	16장.5(구) 표준 API의 함수적 인터페이스(Function)
//	매개값이 있고 return 값이 있는 경우
	private static void f3() {
		Function<String, Account> func1 = (a) -> new Account(a, null, 100);
		BiFunction<String, String, Account> func2 = (no, owner) -> {
			System.out.println("계좌번호 : " + no);
			System.out.println("owner : " + owner);
			return new Account(no, owner, 100);
		};
		Account acc1 = func1.apply("1234");
		Account acc2 = func2.apply("5555", "홍길동");

		System.out.println(acc1);
		System.out.println(acc2);
	}

//	23.03.08 3교시 1-2
//	16장.5(구) 표준 API의 함수적 인터페이스(Supplier)
//	생산자
	private static void f2() {
		Supplier<String> s1 = () -> "자바";
		Supplier<String> s2 = () -> {
			System.out.println("--------------");
			return "자바2";
		};
		Supplier<Account> acc = () -> new Account();

		String ret1 = s1.get();
		String ret2 = s2.get();

		System.out.println(ret1);
		System.out.println(ret2);
		System.out.println(acc.get());
	}

//	23.03.08 3교시 1-1
//	16장.5(구) 표준 API의 함수적 인터페이스(Consumer)
//	소비자
	private static void f1() {
		Consumer<Integer> c1 = (a) -> System.out.println(a + 200);
		Consumer<String> c2 = (a) -> System.out.println(a + 200);
		Consumer<Account> acc = (a) -> {
			System.out.println(a);
			a.deposit(1000);
			int result = a.withdraw(100);
			System.out.println(result + "출금완료");
		};

		c1.accept(100);
		c2.accept("100");

		BiConsumer<String, Integer> c3 = (a, b) -> {
			System.out.println("a = : " + a);
			System.out.println("b = : " + b);
		};
		c3.accept("자바시험", 100);

		acc.accept(new Account("123", "jin", 1000));
	}
}
