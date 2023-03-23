package com.shinhan.day08;

import lombok.AllArgsConstructor;

// 23.03.03 4교시 2-2
// 13장-5 와일드카드 타입 파라미터
@AllArgsConstructor
public class Applicant<T> {
	T kind;
}
