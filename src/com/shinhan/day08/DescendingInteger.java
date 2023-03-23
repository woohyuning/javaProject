package com.shinhan.day08;

import java.util.Comparator;

// 23.03.03 6교시 4-1
// 12장 Sort : DesendingInteger
public class DescendingInteger implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2 - o1;
	}
}
