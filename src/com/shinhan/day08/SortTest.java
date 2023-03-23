package com.shinhan.day08;

import java.util.Arrays;
import java.util.Comparator;

//23.03.03 6교시 2-1
//12장 Sort
public class SortTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

//	 23.03.03 6교시 3-3
//	 12장 Sort : class type, Ascending(오름차순)
	private static void print(String title, Car[] arr) {
		System.out.println("---" + title + "---");
		for (Car car : arr) {
			System.out.println(car);
		}
	}

//	 23.03.03 6교시 3-2
//	 12장 Sort : class type, Ascending(오름차순)
	private static void f4() {
		Car[] arr = { new Car("A", 5000), new Car("C", 5000), new Car("D", 4000), new Car("E", 1000),
				new Car("B", 1000) };
		print("Before", arr);
		Arrays.sort(arr); // Comparable인터페이스를 구현하지 않으면 비교불가
		print("가격asc, 모델desc After", arr);
//		23.03.03 7교시 1-3
//		12장 Sort : 익명 인터페이스 구현, Descending(내림차순)
		Arrays.sort(arr, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				int result = o2.price - o1.price;
				if (result == 0)
					return o1.model.compareTo(o2.model);
				return result;
			}
		}); // Comparable인터페이스를 구현하지 않으면 비교불가
		print("가격desc, 모델asc After", arr);
	}

//	 23.03.03 6교시 2-3
//	 12장 Sort : class type, Ascending(오름차순)
	private static void f3() {
//		ASCII code : 'A' -> 65, 'a' -> 97
		Money[] arr = new Money[] { new Money(10), new Money(7), new Money(5), new Money(3), new Money(6) };
		System.out.println("Before : " + Arrays.toString(arr));
		Arrays.sort(arr); // Comparable인터페이스를 구현하지 않으면 비교불가
		System.out.println("Ascending After : " + Arrays.toString(arr));

//		23.03.03 7교시 1-2
//		12장 Sort : 익명 인터페이스 구현, Descending(내림차순)
		Arrays.sort(arr, new Comparator<Money>() {

			@Override
			public int compare(Money o1, Money o2) {
				return o2.amount - o1.amount;
			}
		}); // Comparator인터페이스를 익명구현
		System.out.println("Descending After : " + Arrays.toString(arr));
	}

	// 23.03.03 6교시 2-2
	// 12장 Sort : String type, Ascending(오름차순)
	private static void f2() {
//		ASCII code : 'A' -> 65, 'a' -> 97
		String[] arr = new String[] { "Spring", "Java", "jsp", "servlet", "html", "CSS", "React" };
		System.out.println("Before : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending After : " + Arrays.toString(arr));

//		23.03.03 7교시 1-1
//		12장 Sort : 익명 인터페이스 구현, Descending(내림차순)
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println("Descending After : " + Arrays.toString(arr));
	}

	// 23.03.03 6교시 2-1
	// 12장 Sort : Integer type Ascending(오름차순)
	private static void f1() {
		Integer[] arr = new Integer[] { 100, 30, 80, 20, 99 };
		System.out.println("Before : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending After : " + Arrays.toString(arr));

//		23.03.03 6교시 4-2
//		12장 Sort : 별도 클래스 구현, Descending(내림차순)
		Arrays.sort(arr, new DescendingInteger());
		System.out.println("Descending After : " + Arrays.toString(arr));
	}
}
