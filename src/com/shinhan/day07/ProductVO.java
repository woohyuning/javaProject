package com.shinhan.day07;

import java.util.Objects;

//매개변수로 들어온 배열에서 가격이 특정 금액 이상인 상품만 추출하여 새로운 배열에 담아서 리턴하는 메서드를 구현하시오. 

// 23.03.02 1교시 복습 -1
// VO(VAlue object)
//23.03.02 3교시 1-2
//12장.3 Object 클래스 page.497
public class ProductVO {
	private String name;
	private int price;
	private String maker;

	public ProductVO(String name, int price, String maker) {
		this.name = name;
		this.price = price;
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "ProductVO [name = " + name + ", price = " + price + ", maker = " + maker + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maker, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVO other = (ProductVO) obj;
		return Objects.equals(maker, other.maker) && Objects.equals(name, other.name) && price == other.price;
	}

}
