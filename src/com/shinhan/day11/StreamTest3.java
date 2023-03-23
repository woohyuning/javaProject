package com.shinhan.day11;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.shinhan.day04.Account;

//23.03.08 5교시 1-1
//17장.3 중간처리와 최종처리 page. 726
public class StreamTest3 {
	public static void main(String[] args) throws IOException, URISyntaxException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
		f14();
	}

//	23.03.08 7교시 3-1
//	17장.12 요소 수집 page. 765
	private static void f14() {
		List<Student2> data = new ArrayList<>();
		data.add(new Student2("김길동", 95, "남"));
		data.add(new Student2("이기동", 85, "남"));
		data.add(new Student2("김길순", 100, "여"));
		data.add(new Student2("김아라", 90, "여"));
		data.add(new Student2("박길동", 100, "남"));
//		성별group으로 집계를 하고 다시 group이 Collection으로 만든다
		Map<String, Double> map = data.stream().collect(
				Collectors.groupingBy(std -> std.getGender(), Collectors.averagingDouble(std -> std.getScore())));
		System.out.println(map);
	}

//	23.03.08 7교시 2-1
//	17장.9 요소 조건 만족 여부(매칭) page. 748
	private static void f13() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		모든요소가 만족하는지 여부
		boolean result1 = Arrays.stream(arr).allMatch(num -> num % 2 == 0);
		System.out.println(result1);
//		최소한 하나의 요소가 만족하는지 여부
		boolean result2 = Arrays.stream(arr).anyMatch(num -> num % 2 == 0);
		System.out.println(result2);
//		모든요소가 만족하지 않는지 여부
		boolean result3 = Arrays.stream(arr).noneMatch(num -> num % 2 == 0);
		System.out.println(result3);

//		Optional 클래스 page. 754
		double d = Arrays.stream(arr).filter(num -> num % 2 == 0).average().orElse(0);
		System.out.println(d);
	}

//	23.03.08 7교시 1-2
//	17장.7 요소 정렬 page. 743
	private static void f12() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 100));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));

		data.stream().sorted().forEach(arr -> System.out.println(arr));
		System.out.println("------------sort 변경------------");
		data.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(arr -> System.out.println(arr));
	}

//	23.03.08 7교시 1-1
//	17장.7 요소 정렬 page. 743
	private static void f11() {
		Integer[] arr = { 100, 88, 99, 50, 60 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr, (a, b) -> b - a);
		System.out.println(Arrays.toString(arr));

		Student[] arr2 = { new Student("김", 90), new Student("양", 77), new Student("김", 70), new Student("박", 90),
				new Student("정", 88), new Student("이", 100) };
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));

		Arrays.sort(arr2, (a, b) -> a.getName().compareTo(b.getName()));
		System.out.println(Arrays.toString(arr2));
	}

//	23.03.08 6교시 3-2
//	17장.6 요소를 복수 개의 요소로 변환 page. 743
	private static void f10() {
		List<String> data = new ArrayList<>();
		data.add("This is java");
		data.add("I am a best developer");

//		for(String s : data) {
//			String[] arr = s.split(" ");
//			for(String word : arr) {
//				System.out.println(word);
//			}
//		}ㅠ

		data.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(word -> System.out.println(word));
	}

//	23.03.08 6교시 3-1
//	17장.6 요소 변환(매핑) page. 741
//	asDoubleStream() - double로 변경
//	boxed() - 객체로 변환
	private static void f9() {
		int[] arr = { 10, 20, 70, 90 };
		Arrays.stream(arr).asDoubleStream().forEach(d -> System.out.println(d));
		System.out.println("-----------------------");
		Arrays.stream(arr).boxed().forEach(d -> System.out.println(d.floatValue()));
	}

//	23.03.08 6교시 2-2
//	17장.5 요소 걸러내기(필터링) page. 736
	private static void f8() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));

		System.out.println("-----점수가 70점 초과인 학생만 출력-----");
		data.stream().distinct().filter(s -> s.getScore() > 70).forEach(s -> System.out.println(s));

		System.out.println("\n-----이름이 김씨인 사람만 출력-----");
		data.stream().distinct().filter(s -> s.getName().startsWith("김")).forEach(s -> System.out.println(s));

		System.out.println("\n-----이름이 김씨인 사람만 출력.점수.평균-----");
		data.stream().distinct().filter(s -> s.getName().startsWith("김")).mapToInt(num -> num.getScore()).average()
				.ifPresent(avg -> System.out.println("평균 : " + avg));
	}

//	23.03.08 6교시 2-1
//	17장.5 요소 걸러내기(필터링) page. 736
//	distinct() - 중복제거
//	filter() - 조건필터
	private static void f7() {
		List<String> data = new ArrayList<>();
		data.add("홍길동1");
		data.add("홍길동3");
		data.add("홍길동5");
		data.add("홍길동6");
		data.add("홍길동23");
		data.add("홍길동43");
		data.add("홍길동5");
		data.add("홍길동6");
		data.stream().distinct().filter(s -> s.endsWith("3")).forEach(s -> System.out.println(s));
	}

//	23.03.08 6교시 1-3
//	17장.4 리소스로부터 스트림 얻기 page. 734
//	파일읽기 - Files.lines()
	private static void f6() throws URISyntaxException, IOException {
		Path path = Paths.get(StreamTest3.class.getResource("data.txt").toURI());
		System.out.println(path);
		System.out.println(Charset.defaultCharset());
		Stream<String> streamData = Files.lines(path, Charset.defaultCharset());
		streamData.forEach(line -> System.out.println(line));
	}

//	23.03.08 6교시 1-2
//	17장.4 리소스로부터 스트림 얻기 page. 734
//	파일읽기 - FileReader
	private static void f5() throws IOException {
		FileReader fi = new FileReader("src/com/shinhan/day11/data.txt");
		int i;
		while ((i = fi.read()) != -1) {
			System.out.print((char) i);
		}
	}

//	23.03.08 6교시 1-1
//	17장.4 리소스로부터 스트림 얻기 page. 729
//	IntStream
	private static void f4() {
//		1~9까지
		System.out.print("IntStream : ");
		IntStream.range(1, 10).forEach(num -> {
			System.out.print(num + " ");
		});
//		외부반복자
		System.out.print("\n일반for문 : ");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + " ");
		}
	}

//	23.03.08 5교시 1-3
//	17장.3 중간처리와 최종처리 page. 726
//	Account class
//	모든계좌의 잔고의 합을 출력하기 - 내부반복자를 이용
	private static void f3() {
		List<Account> data = new LinkedList<>();
		data.add(new Account("123", "홍1", 1000));
		data.add(new Account("124", "홍2", 2000));
		data.add(new Account("127", "홍6", 3000));
		data.add(new Account("128", "홍5", 4000));
		data.add(new Account("126", "홍4", 5000));
		data.add(new Account("125", "홍3", 6000));

		long total = data.stream().mapToLong(acc -> acc.getBalance()).sum();
		System.out.println("잔고의 합계 : " + total);

		long total2 = data.stream().map(acc -> acc.getOwner()).count();
		System.out.println("건수는 : " + total2);

//		forEach : 순서 보장 안함
//		forEachOrdered : 순서 보장 함
		data.parallelStream().map(acc -> acc.getOwner()).forEachOrdered(owner -> System.out.println(owner + " 예금주님"));
		;
	}

//	23.03.08 5교시 1-2
//	17장.3 중간처리와 최종처리 page. 726
//	Account class
//	모든계좌의 잔고의 합을 출력하기 - 외부반복자를 이용
	private static void f2() {
		List<Account> data = new LinkedList<>();
		data.add(new Account("123", "홍1", 1000));
		data.add(new Account("124", "홍2", 2000));
		data.add(new Account("127", "홍6", 3000));
		data.add(new Account("128", "홍5", 4000));
		data.add(new Account("126", "홍4", 5000));
		data.add(new Account("125", "홍3", 6000));

		int total = 0;
		for (Account acc : data) {
			total += acc.getBalance();
		}
		System.out.println("잔고의 합계 : " + total);
	}

//	23.03.08 5교시 1-1
//	17장.3 중간처리와 최종처리 page. 726
//	Student class
	private static void f1() {
//		여러건 저장하기 : 배열, Collection(List, Set, Map)
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("김4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("김5", 60));
		data.add(new Student("김2", 80));
//		data를 stream으로 만들어서 중간처리, 최종처리
		data.stream().forEach((std) -> {
			System.out.println(std);
			System.out.println(std.getName() + " -> " + std.getScore());
		});
		System.out.println("--중간처리--");
		data.stream().mapToInt((std) -> std.getScore()).forEach(score -> {
			System.out.println(score);
			System.out.println("-----------");
		});

//		System.out.println("--최종처리--");
//		Double d = data.stream().mapToInt((std) -> std.getScore()).average().getAsDouble();
//		System.out.println("average = " + d);

		System.out.println("--Optional test1--");
		OptionalDouble option = data.stream().mapToInt(std -> std.getScore()).average();
		option.ifPresent(result -> System.out.println(result));

		System.out.println("--Optional test2--");
		data.stream().mapToInt(std -> std.getScore()).average().ifPresent(result -> System.out.println(result));

		System.out.println("--Optional test3--");
		data.stream().mapToInt(std -> std.getScore()).average().ifPresentOrElse(result -> System.out.println(result),
				() -> System.out.println("평균을 구할 수 없다"));
	}
}