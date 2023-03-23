package com.shinhan.day08;

// 23.03.03 2교시 2-3
// 13장-1 제네릭
public class HappyBox<T> {
	T kind;
	int price;
	
	public HappyBox(T kind, int price) {
		super();
		this.kind = kind;
		this.price = price;
	}

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Box [kind=" + kind + ", price=" + price + "]";
	}

	
}
