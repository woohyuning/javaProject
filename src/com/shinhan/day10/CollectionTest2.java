package com.shinhan.day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import com.shinhan.day04.Account;
import com.shinhan.day04.Employee;

// 23.03.07 4교시 1-1
// 15장 컬렉션 자료구조(tree) page.664
// List : 순서있음, 중복가능, ArrayList, LinkedList, Vector(MultiThread환경에서 동기화 지원)
// Map : 키와 값의 쌍
// HashSet : hashcode(), equals()로 동등비교, 동등하면 add불가
// TreeSet : compareTo()로 크기비교

public class CollectionTest2 {
	public static void main(String[] args) {
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
		String[] arr = new String[] {"A", "B", "C"};
		Integer[] arr2 = {100,99,88};
		List<String> data = Arrays.asList(arr);
		List<Integer> data2 = Arrays.asList(arr2);
	}
//	23.03.07 6교시 3-3
//	15장 컬렉션 자료구조(수정할 수 없는 컬렉션) page.684
//	수정불가한 Collection copyOf
	private static void f14() {
		Set<Fruit> data = new HashSet<>();
		data.add(new Fruit("귤1", 100));
		data.add(new Fruit("귤2", 100));
		data.add(new Fruit("귤3", 100));
		data.add(new Fruit("귤4", 100));
		data.add(new Fruit("귤5", 100));
		
		Set<Fruit> data2 = Set.copyOf(data);
		data.add(new Fruit("사과", 200));
//		data2.add(new Fruit("사과", 200)); // 수정불가
		for(Fruit fruit : data2) {
			System.out.println(fruit);
		}
	}

//	23.03.07 6교시 3-2
//	15장 컬렉션 자료구조(수정할 수 없는 컬렉션) page.684
//	수정불가한 Collection Map
	private static void f13() {
		Map<String, Integer> mapData = Map.of("김", 100, "양", 90, "박", 80); // 값은 중복 불가
//		mapData.add("a", 11); //수정불가
		for (String key : mapData.keySet()) {
			System.out.println(key + "---" + mapData.get(key));
		}
	}

//	23.03.07 6교시 3-2
//	15장 컬렉션 자료구조(수정할 수 없는 컬렉션) page.684
//	수정불가한 Collection Set
	private static void f12() {
		Set<Integer> setData = Set.of(100, 88, 99, 55, 80); // 값은 중복 불가
//		setData.add(11); //수정불가
		for (Integer i : setData) {
			System.out.println(i);
		}
//		
	}

//	23.03.07 6교시 3-1
//	15장 컬렉션 자료구조(수정할 수 없는 컬렉션) page.684
//	수정불가한 Collection List
	private static void f11() {
		List<Integer> listData = List.of(100, 88, 99, 55, 80);

//		listData.add(9999); 수정불가
		for (Integer i : listData) {
			System.out.println(i);
		}
//		int[] arr = new int[] { 100, 88, 99, 55, 80 };
//		List<int[]> listData2 = Arrays.asList(arr);
//		for(int[] a : listData2) {
//			System.out.println(Arrays.toString(a));
//		}
	}

//	23.03.07 6교시 2-2
//	15장 컬렉션 자료구조(Queue) page.679
//	Queue(FIFO) - 선입선출
	private static void f10() {
		Queue<Fruit> data = new LinkedList<>();
		data.offer(new Fruit("귤2", 20000));
		data.offer(new Fruit("귤1", 40000));
		data.offer(new Fruit("귤4", 10000));
		data.offer(new Fruit("귤3", 30000));
		data.offer(new Fruit("귤5", 70000));

		while (!data.isEmpty()) {
			Fruit f = data.poll();
			System.out.println(f);
		}
	}

//	 23.03.07 6교시 2-1
//	15장 컬렉션 자료구조(Stack) page.677
//	Stack(LIFO) - 후입선출
	private static void f9() {
		Stack<Fruit> data = new Stack<>();
		data.push(new Fruit("귤2", 20000));
		data.push(new Fruit("귤1", 40000));
		data.push(new Fruit("귤4", 10000));
		data.push(new Fruit("귤3", 30000));
		data.push(new Fruit("귤5", 70000));

		while (!data.isEmpty()) {
			Fruit f = data.pop();
			System.out.println(f);
		}
	}

//	 23.03.07 6교시 1-2
//	15장 컬렉션 자료구조(Comparable) page.675
//	TreeMap
	private static void f8() {
		TreeMap<String, Fruit> data = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		data.put("S", new Fruit("귤", 10000));
		data.put("A", new Fruit("사과", 20000));
		data.put("B", new Fruit("오렌지", 50000));
		data.put("A", new Fruit("귤", 10000));
		data.put("B", new Fruit("귤", 30000));
		for (Entry<String, Fruit> entry : data.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("------------------------");
		}
		NavigableMap<String, Fruit> data2 = data.descendingMap();
		System.out.println("------descendingMap-----");
		for (Entry<String, Fruit> entry : data2.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("------------------------");
		}
	}

//	23.03.07 6교시 1-1
//	15장 컬렉션 자료구조(Comparable) page.675
//	HashSet
	private static void f7() {
		Set<Fruit> data = new HashSet<>();
		data.add(new Fruit("귤", 10000));
		data.add(new Fruit("사과", 20000));
		data.add(new Fruit("오렌지", 50000));
		data.add(new Fruit("귤", 10000));
		data.add(new Fruit("귤", 30000));
		for (Fruit fruit : data) {
			System.out.println(fruit);
		}
	}

//	23.03.07 5교시 2-2
//	15장 컬렉션 자료구조(TreeSet) page.666
	private static void f6() {
		Set<Board> data = new TreeSet<>();
		data.add(new Board(1, "회식", "술마셔도되나요", "jin"));
		data.add(new Board(2, "자율학습", "저녁개방", "jin"));
		data.add(new Board(3, "아침", "빨리와~", "jin"));
		data.add(new Board(4, "회식", "술마셔도되나요", "jin"));
		data.add(new Board(5, "회식", "술마셔도되나요", "jin"));

		for (Board board : data) {
			System.out.println(board);
		}
	}

//	23.03.07 5교시 1-2
//	15장 컬렉션 자료구조(TreeMap) page.668
//	동일 키 입력 시 데이터가 덮어씌워진다
//	key로 sort된다.
	private static void f5() {
		TreeMap<String, Integer> data = new TreeMap<>();
		data.put("홍길동5", 88);
		data.put("홍길동1", 99);
		data.put("홍길동4", 66);
		data.put("홍길동3", 77);
		data.put("홍길동3", 100); // 같은 키가 있으면 값을 replace

		for (String key : data.keySet()) {
			System.out.println(key + " -> " + data.get(key));
		}

		System.out.println("\nfristKey : " + data.firstKey());
		System.out.println("fristKey의 값 : " + data.get(data.firstKey()));
		System.out.println("lastEntry : " + data.lastEntry());
		System.out.println("lowerEntry : " + data.lowerEntry("홍길동3") + "\n");

		NavigableMap<String, Integer> data2 = data.descendingMap();
		for (String key : data2.keySet()) {
			System.out.println(key + " -> " + data2.get(key));
		}
	}

//	23.03.07 5교시 1-1
//	15장 컬렉션 자료구조(TreeSet) page.666
	private static void f4() {
		TreeSet<Integer> scoreSet = new TreeSet<>();
		scoreSet.add(100);
		scoreSet.add(20);
		scoreSet.add(50);
		scoreSet.add(80);
		scoreSet.add(80);

		for (int score : scoreSet) {
			System.out.println(score);
		}
		System.out.println("frist : " + scoreSet.first());
		System.out.println("last : " + scoreSet.last());
		System.out.println("higher : >" + scoreSet.higher(50)); // > 하나의 값
		System.out.println("lower : <" + scoreSet.lower(50)); // < 하나의 값
		System.out.println("ceiling : >=" + scoreSet.ceiling(50)); // >= 하나의 값
		System.out.println("floor : <=" + scoreSet.floor(50)); // <= 하나의 값

		System.out.println("------tailSet------");
		SortedSet<Integer> data = scoreSet.tailSet(50); // >= 값 전체
		for (Integer i : data) {
			System.out.println(i);
		}
		System.out.println("------headSet------");
		NavigableSet<Integer> data2 = scoreSet.headSet(50, true); // <= 값 전체
		SortedSet<Integer> data3 = scoreSet.headSet(50, true); // <= 값 전체
		for (Integer i : data2) {
			System.out.println(i);
		}
	}

//	23.03.07 4교시 1-2
//	15장 컬렉션 자료구조(tree) page.664
//	중복값 허용 X
//	제네릭 Employee
	private static void f3() {
		Set<Employee> data = new TreeSet<>();
		data.add(new Employee("김경윤", "사원", 1000));
		data.add(new Employee("김경윤", "사원", 1000));
		data.add(new Employee("정진", "대리", 2000));
		data.add(new Employee("박영선", "과장", 3000));
		data.add(new Employee("박영선", "사장", 3000));
		for (Employee s : data) {
			System.out.println(s);
		}
	}

//	23.03.07 4교시 1-2
//	15장 컬렉션 자료구조(tree) page.664
//	중복값 허용 X
//	제네릭 Account
	private static void f2() {
		Set<Account> data = new TreeSet<>();
		data.add(new Account("123", "홍5", 1000));
		data.add(new Account("124", "홍1", 1000));
		data.add(new Account("126", "홍3", 2000));
		data.add(new Account("125", "홍2", 3000));
		data.add(new Account("123", "홍5", 9000)); // 이미 존재하므로 add 안됨
		for (Account s : data) {
			System.out.println(s);
		}
	}

//	23.03.07 4교시 1-1
//	15장 컬렉션 자료구조(tree) page.664
//	중복값 허용 X
//	제네릭 String
	private static void f1() {
		Set<String> data = new TreeSet<>();
		data.add("월1");
		data.add("월5");
		data.add("월5"); // 같은 값이 있으므로 add 되지 않는다
		data.add("월2");
		data.add("월4");
		for (String s : data) {
			System.out.println(s);
		}
	}
}
