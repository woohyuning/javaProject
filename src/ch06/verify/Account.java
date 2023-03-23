package ch06.verify;

import java.util.Scanner;

// ch06-20
public class Account {
	private String accNo;
	private String name;
	private int Balance;
	Account() {
		
	}
	Account(String accNo, String name, int Balance) {
		this.accNo = accNo;
		this.name = name;
		this.Balance = Balance;
	}
	
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}
//	ch06-19
//	final static int MIN_BALANCE = 0;
//	final static int MAX_BALANCE = 1000000;	
//
//	private int balance;
//
//	public int getBalance() {
//			return balance;
//	}
//
//	public void setBalance(int balance) {
//		if(balance > MIN_BALANCE && balance < MAX_BALANCE) {
//			this.balance = balance;
//		}
//	}
}	
