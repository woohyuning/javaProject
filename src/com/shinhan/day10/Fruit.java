package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
//23.03.07 5교시 2-1
//15장 컬렉션 자료구조(Comparable) page.675
public class Fruit implements Comparable<Fruit> {
	String name;
	int price;
	
	@Override
	public int compareTo(Fruit obj) {
		int result = name.compareTo(obj.name);
		if(result == 0) {
			return price - obj.price;
		}
		return result;
	}
}
