package com.shinhan.day08;

// 23.03.03 5교시 2-1
// 13장-연습문제3
public class Container2<K, V> {
	K key;
	V value;

	public Container2() {}
	
	public Container2(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void set(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
