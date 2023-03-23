package com.shinhan.day08;

// 23.03.03 5교시 1-1
// 13장-연습문제2,3
public class ContainerExample {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}
//	23.03.03 5교시 2-1 변형 2-4
//	13장-연습문제3
	private static void f4() {
		Container<String> container1 = ContainerFactory("Book");
//		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);

		Container<Integer> container2 = ContainerFactory(100);
//		container2.set(100);
		int i = container2.get();
		System.out.println(i);

		Container<Money> container3 = ContainerFactory(new Money(200));
//		container3.set(new Money(10));
		Money m = container3.get();
		System.out.println(m);
	}

//	23.03.03 5교시 2-2 변형 2-3
//	13장-연습문제3
	private static void f3() {
		Container2<String, Integer> container1 = makeContainer("홍길동1", 100);
//		container1.set("홍길동1", 100);
		System.out.println("key = " + container1.getKey());
		System.out.println("value = " + container1.getValue());

		Container2<String, Money> container2 = makeContainer("홍길동2", new Money(200));
//		container2.set("홍길동2", new Money(200));
		System.out.println("key = " + container2.getKey());
		System.out.println("value = " + container2.getValue());
	}

//	제너릭 메서드
	private static <K, V> Container2<K, V> makeContainer(K key, V value) {
		return new Container2<K, V>(key, value);
	}

	private static <T> Container<T> ContainerFactory(T data) {
		return new Container<T>(data);
	}

//	23.03.03 5교시 2-2
//	13장-연습문제3
	private static void f2() {
		Container2<String, Integer> container1 = new Container2<String, Integer>();
		container1.set("홍길동1", 100);
		System.out.println("key = " + container1.getKey());
		System.out.println("value = " + container1.getValue());

		Container2<String, Money> container2 = new Container2<String, Money>();
		container2.set("홍길동2", new Money(200));
		System.out.println("key = " + container2.getKey());
		System.out.println("value = " + container2.getValue());
	}

//	23.03.03 5교시 1-1
//	13장-연습문제2
	private static void f1() {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);

		Container<Integer> container2 = new Container<Integer>();
		container2.set(100);
		int i = container2.get();
		System.out.println(i);

		Container<Money> container3 = new Container<Money>();
		container3.set(new Money(10));
		Money m = container3.get();
		System.out.println(m);
	}
}
