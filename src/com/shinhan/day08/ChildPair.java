package com.shinhan.day08;

// 23.03.03 5교시 3-2
// 13장-연습문제4
public class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K key, V value) {
		super(key, value);
		System.out.println("자식 ChildPair");
	}

}
