package com.shinhan.day08;

// 23.03.03 6교시 1-1
// 13장-연습문제4
public class Util {
	public static <K, V> V getValue(Pair<K, V> pair, String key) {
		if (pair.getKey().equals(key)) {
			return pair.getValue();
		}
		return null;
	}

	public static <P extends Pair<K, V>, K, V> V getValue2(P pair, String key) {
		if (pair.getKey().equals(key)) {
			return pair.getValue();
		}
		return null;
	}
}
