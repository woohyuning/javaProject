package com.shinhan.day08;

//23.03.03 1교시 복습 2-1
//12장 LAB8-4
public class Money implements Comparable<Money>{
	int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Money add(Money money) {
		return new Money(amount + money.amount);
	}

	public Money minus(Money money) {
		return new Money(amount - money.amount);
	}

	public Money multiply(Money money) {
		return new Money(amount * money.amount);
	}

	public Money devide(Money money) {
		return new Money(amount / money.amount);
	}

	public boolean equals(Object object) {
		if (this == object)
			return true; // 주소 같으면 같다.
		if (object == null || getClass() != object.getClass())
			return false;

		return amount == ((Money) object).amount;
	}

	@Override
	public String toString() {
//		return amount + "";
		return String.valueOf(amount) + "머니";
	}

	public static void main(String[] args) {
		Money five = new Money(5);
		Money two = new Money(2);
		Money three = new Money(3);
		Money ten = new Money(10);

		System.out.println(five);
		System.out.println(two.add(three));

		if (five.equals(two.add(three)) && three.equals(five.minus(two)) && ten.equals(five.multiply(two))
				&& two.equals(ten.devide(five))) {
			System.out.println("Money Class 구현을 완료 하였습니다.");
		}
	}
	//23.03.03 6교시 2-4
	//12장 Sort : Ascending(오름차순)
	@Override
	public int compareTo(Money obj) {
		// TODO Auto-generated method stub
		return amount - obj.amount; // -1, 0, 1
	}
}