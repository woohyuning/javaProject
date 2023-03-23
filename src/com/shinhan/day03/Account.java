package com.shinhan.day03;

public class Account {
	private String accNo;
	private int balance;
	
	Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;;
		
		System.out.println(accNo + " 계좌가 개설되었습니다.");
		System.out.println(accNo + " 계좌의 잔고는 " + balance + "원입니다.");
	}
	void save(int amount) { // 입금
		balance += amount;
		print(" 계좌에 " + amount + "원이 입금되었습니다." );
	}
	void deposit(int amount) { // 출금
		balance -= amount;
		print(" 계좌에 " + amount + "원이 출금되었습니다." );
	}
	//getter
	public int getBalance(int balance) { // 잔고
		return balance;
	}
	public String getAccNo(String accNo) { // 계좌번호
		return accNo;
	}
	private void print(String message) {
		System.out.println(accNo + message);
		System.out.println(accNo + " 계좌의 잔고는 " + balance + "원입니다.");
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}
}
