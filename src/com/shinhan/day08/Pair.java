package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 23.03.03 5교시 3-1
// 13장-연습문제4
@AllArgsConstructor
@Getter
public class Pair<K, V> {
	private K key;
	private V value;
}
