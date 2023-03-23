package com.shinhan.day09;

//23.03.06 5교시 1-1
//14.6 스레드 동기화 page.612
public class Account extends Object {
	// 1.field
	private String accNo;
	private String owner;
	private int balance;
	
	// 2. 생성자
	public Account() {
	}

	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	// 3. 메서드
	public void deposit(int amount) {
		balance += amount;
	}
	
	public int withdraw(int amount) {
		if(amount > balance) {
			System.out.println("잔액부족");
			return 0;
		}
		balance -= amount;
		return amount;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
