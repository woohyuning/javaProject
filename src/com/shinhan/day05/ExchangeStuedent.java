package com.shinhan.day05;

import java.util.Arrays;

//23.02.27 1교시 복습 -2
public class ExchangeStuedent extends Student {
	String[] language;
	
	public ExchangeStuedent(String stdId, String name, String[] language) {
		super(stdId, name); // 2. 명시적으로 부모생성자를 호출(o)
//		1. 부모에서 default생성자 정의 
//		this.setStdId(stdId);
//		this.name = name;
		this.language = language;
	}
	
	void display() {
		System.out.println(getClass().getSimpleName() + "에서 추가된 메서드");
	}

	@Override
	public String toString() {
		return "ExchangeStuedent [language=" + Arrays.toString(language) + ", name=" + name + ", major=" + major
				+ ", Score=" + Score + ", schoolName=" + schoolName + "]";
	}
	
}
