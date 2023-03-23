package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
// 23.03.03 6교시 3-1
// 12장 Sort
public class Car implements Comparable<Car> {
	String model;
	int price;

	@Override
	public int compareTo(Car obj) {
		int result = price - obj.price;
		if(result == 0) {
			return obj.model.compareTo(model);
		}
		return result;
	}

}
