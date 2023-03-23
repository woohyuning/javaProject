package com.shinhan.day08;

import java.util.Arrays;

//23.03.03 8교시 1-1
//12장 LAB3
public class Median {
	public static void main(String[] args) {
		Median median = new Median();
		int[] values1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };
		System.out.println("input : " + Arrays.toString(values1));
		System.out.println("median : " + median.findMedian(values1));
		System.out.println("===============================");

		int[] values2 = { 1, 32, 53, 52, 76, 15, 98, 76, 65, 36, 10 };
		System.out.println("input : " + Arrays.toString(values2));
		System.out.println("median : " + median.findMedian(values2));
	}

	public int findMedian(int[] values) {
		int result = 0;
		Arrays.sort(values);

		System.out.println(Arrays.toString(values));

		if (values.length % 2 == 1) {
			int a = values.length / 2;
			result = Math.abs(values[a]);
		} else {
			int a = values.length / 2 - 1;
			result = values[a];
		}
		return result;
	}
}
