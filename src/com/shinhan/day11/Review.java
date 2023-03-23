package com.shinhan.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//23.03.08 1교시 1-1
//15장 복습
public class Review {
	public static void main(String[] args) {
		f1();
		f2();
	}

	private static void f2() {
		List<Integer> data1 = new ArrayList<>();
		Set<Integer> data2 = new HashSet<>();
		Map<String, Integer> data3 = new HashMap<>();
//		데이터 입력
		data1.add(100);
		data2.add(200);
//		data2.add(123);
		data3.put("aa", 300);
		data3.put("bb", 400);
//		데이터 출력(List)
		System.out.println(data1.get(0));
//		데이터 출력1(Set)
		for(Integer i : data2) {
			System.out.println(i);
		}
//		데이터 출력2(Set)
//		내부반복자 생성
		Iterator<Integer> it = data2.iterator();
		System.out.println(it.next());
		System.out.println(it.hasNext() ? it.next() : "not found");
		
//		Map : 키가 있으면 값을 읽을 수 있다.
		int value = data3.get("aa");
		System.out.println(value);
//		데이터 출력1(Map)
		Set<String> keys = data3.keySet();
		for(String key : keys) {
			System.out.println(key);
			int val = data3.get(key);
			System.out.println(val);
		}
//		데이터 출력2(Map)
		Set<Entry<String, Integer>> entrys = data3.entrySet();
		for(Entry<String, Integer> entry : entrys) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
//		데이터 출력3(Map)
//		내부반복자 생성
		Iterator<Entry<String, Integer>> it2 = entrys.iterator();
		while(it2.hasNext()) {
			Entry<String, Integer> en = it2.next();
			System.out.println(en.getKey() + en.getValue());
		}
	}

	private static void f1() {
//		Collection : List(순서O / 중복O), Set(순서X, 중복X)
//		Map(Entry( 키(key) - 값(value) ))
//		List구현 class : ArrayList(배열 연결), LinkedList(주소 연결), Vector(멀티쓰레드 용이)
//		Set구현 class : HashSet(중복Check : equals(), hashcode())
//		               TreeSet(data 추가 시 순서정해짐, 크기비교 - compareTo)
//		Map구현 class : HashMap, TreeMap, Properties
	}
}
