package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//23.03.03 3교시 1-1
//13장-2 제네릭 타입
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"kind"})
@Getter
@Setter
public class Product<T, M> {
	T kind;
	M model;
}
