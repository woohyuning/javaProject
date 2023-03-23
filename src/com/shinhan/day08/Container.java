package com.shinhan.day08;

// 23.03.03 5교시 1-2
// 13장-연습문제2
public class Container<T> {
	T data;

	public Container() {}
	
	public Container(T data) {
		super();
		this.data = data;
	}

	public void set(T data) {
		this.data = data;
	}

	public T get() {
		return data;
	}
}
