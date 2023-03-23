package com.shinhan.day08;

import java.util.ArrayList;

// 23.03.03 2교시 2-2
// 13장-1 제네릭
public class GenericTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		method1();
//		method2();
//		method3();
//		wildcardTest();
//		wildcardTest2();
//		wildcardTest3();
		wildcardTest4();
	}

//	23.03.03 4교시 3-4
//	13장-5 와일드카드 타입 파라미터
	private static void ff3(HappyBox<? super ChildA> param) {
		System.out.println("ff3");
	}

//	23.03.03 4교시 3-3
//	13장-5 와일드카드 타입 파라미터
	private static void ff2(HappyBox<? extends Number> param) {
		System.out.println("ff2");
	}

//	23.03.03 4교시 3-2
//	13장-5 와일드카드 타입 파라미터
	private static void ff1(HappyBox<?> param) {
		System.out.println("ff1");
	}

//	23.03.03 4교시 3-1
//	13장-5 와일드카드 타입 파라미터
	private static void wildcardTest4() {
		HappyBox<String> box1 = new HappyBox<String>("A", 10);
		ff1(box1);
		HappyBox<Integer> box2 = new HappyBox<Integer>(5, 10);
		ff2(box2);
		HappyBox<Parent> box3 = new HappyBox<Parent>(new Parent(), 10);
		ff3(box3);
	}

//	23.03.03 4교시 2-6
//	13장-5 와일드카드 타입 파라미터
	private static void wildcardTest3() {
//		? extends Worker : Worker, Worker 상위
		Course.registerCourse3(new Applicant<Person>(new Person()));
//		Course.registerCourse3(new Applicant<Student>(new Student()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
//		Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
//		Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
	}

//	23.03.03 4교시 2-5
//	13장-5 와일드카드 타입 파라미터
	private static void wildcardTest2() {
//		? extends Student : Student, Student 하위
//		Course.registerCourse2(new Applicant<Person>(new Person()));
		Course.registerCourse2(new Applicant<Student>(new Student()));
//		Course.registerCourse2(new Applicant<Worker>(new Worker()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
	}

//	23.03.03 4교시 2-4
//	13장-5 와일드카드 타입 파라미터
	private static void wildcardTest() {
//		?
		Course.registerCourse(new Applicant<Person>(new Person()));
		Course.registerCourse(new Applicant<Student>(new Student()));
		Course.registerCourse(new Applicant<Worker>(new Worker()));
		Course.registerCourse(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse(new Applicant<MiddleStudent>(new MiddleStudent()));
	}

//	23.03.03 4교시 1-3
//	13장-5 와일드카드 타입 파라미터
//	제네릭타입 제한(extend, super, ?) : ? super Number : Number의 자신과 상위만 가능
	private static void genericExtendMothod4(HappyBox<? super Number> param) {
		System.out.println("? super Number : Number의 자신과 상위만 가능");
	}

//	23.03.03 4교시 1-2
//	13장-5 와일드카드 타입 파라미터
//	제네릭타입 제한(extend, super, ?) : ? extneds Number : Number의 자식만 가능
	private static void genericExtendMothod3(HappyBox<? extends Number> param) {
		System.out.println("? extneds Number : Number의 자식만 가능");
	}

//	23.03.03 4교시 1-1
//	13장-5 와일드카드 타입 파라미터
//	제네릭타입 제한(extend, super, ?) : ?는 제한이 없다.	
	private static void genericExtendMothod2(HappyBox<?> param) {
		System.out.println("?는 제한이 없다.");
	}

//	23.03.03 3교시 3-5
//	13장-4 제한된 타입 파라미터
	private static <T extends Parent> void genericExtendMothod(T param) {
		System.out.println("genericExtendMothod....");
	}

//	23.03.03 3교시 3-4
//	13장-4 제한된 타입 파라미터
	private static void method3() {
		genericExtendMothod(new ChildA());
		genericExtendMothod(new ChildB());
//		genericExtendMothod(new Money(100));

		genericExtendMothod2(new HappyBox<>("사과", 0));

		genericExtendMothod3(new HappyBox<>(500, 0));

		genericExtendMothod4(new HappyBox<>(new ChildB(), 0));
	}

//	23.03.03 3교시 2-2
//	13장-4 제한된 타입 파라미터
	private static void method2() {
		Integer a = 10;
		Integer b = 20;
		boolean result = compare(a, b);
		System.out.println(result);

		String s1 = new String("자바");
		String s2 = new String("자바");
//		result = compare(s1, s2); // 타입에 제한을 걸어서 Number하위가 아니므로 불가
//		System.out.println(result);
	}

//	23.03.03 3교시 2-1
//	13장-4 제한된 타입 파라미터
//	타입 제한걸기 : extends Number는 Number를 상속받아 하위class만 가능하다는 의미
	public static <T extends Number> boolean compare(T a, T b) {
		return a.equals(b);
	}

//	23.03.03 3교시 1-5
//	13장-3 제네릭 메서드
	private static <T, A, B> HappyBox<T> boxing2(T kind, A a, B b, String s) {
		return null;
	}

//	23.03.03 3교시 1-4
//	13장-3 제네릭 메서드
	private static void method1() {
		HappyBox<String> box1 = boxing("해피박스kind");
		HappyBox<Integer> box2 = boxing(500);
		HappyBox<Money> box3 = boxing(new Money(200));

		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
	}

//	23.03.03 3교시 1-3
//	13장-3 제네릭 메서드
	private static <T> HappyBox<T> boxing(T kind) {
		return new HappyBox<>(kind, 1000);
	}

//	23.03.03 3교시 1-2
	private static void f5() {
		Product<String, Integer> p1 = new Product<>("책", 1000);
		Product<String, Integer> p2 = new Product<>("책", 2000);
		System.out.println(p1);
		System.out.println(p1.equals(p2));
	}

//	23.03.03 2교시 2-6
	private static void f4() {
		ArrayList<Money> data = new ArrayList<>();
		data.add(new Money(1));
		data.add(new Money(10));
		data.add(new Money(12));
		data.add(new Money(16));

		for (Money s : data) {
			System.out.println(s);
		}
	}

//	23.03.03 2교시 2-5
	private static void f3() {
		ArrayList<String> data = new ArrayList<>();
		data.add("월");
		data.add("목");
		data.add("토");
		data.add("월");

		for (String s : data) {
			System.out.println(s);
		}
	}

//	23.03.03 2교시 2-4
//	컴파일단계부터 확인이 가능하다
	private static void f2() {
		HappyBox<String> box1 = new HappyBox<String>("바나나", 100);
		HappyBox<String> box2 = new HappyBox<>("컴퓨터", 100);
		HappyBox<String> box3 = new HappyBox<>("책", 100);

		String s1 = box1.kind;
		String s2 = box2.kind;
		String s3 = box3.kind;

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		HappyBox<Money> box4 = new HappyBox<Money>(new Money(10), 100);
		HappyBox<Money> box5 = new HappyBox<>(new Money(20), 100);
		HappyBox<Money> box6 = new HappyBox<>(new Money(20), 100);

		Money m1 = box4.kind;
		Money m2 = box5.kind;
		Money m3 = box6.kind;

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m2.equals(m3));
	}

//	제네릭스 사용하지 않은 예제
	private static void f1() {
		Box box1 = new Box("바나나", 100);
		Box box2 = new Box(500, 100);
		Box box3 = new Box(new Money(300), 1000);

		String s1 = (String) box1.kind;
		int s2 = (Integer) box2.kind;
		Money money = (Money) box3.kind;

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(money);
	}
}
