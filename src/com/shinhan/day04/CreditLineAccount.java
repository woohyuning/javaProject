package com.shinhan.day04;

//<7-4>
//page 293. 메소드 재정의
public class CreditLineAccount extends Account {
	int creditLine;
	
	public CreditLineAccount(String accNo, String owner, int balance, int creditLine) {
		super(accNo, owner, balance);
		this.creditLine = creditLine;
	}

	// override(덮어쓰기, 재정의) : 시그니처가 같아야한다.
	// 이름, 매개변수, return type 모두 같아야한다. modifier는 같거나 더 넓어져야한다
	
//	@Override 생략가능
	public void deposit(int amount) {
		System.out.println("입금하다...override test");
		super.deposit(amount);
	}
	
	@Override // 생략가능
	public int withdraw(int amount) {
		int total = getBalance() + creditLine;
		
		if(amount > total) {
			System.out.println("잔액부족");
			return 0;
		}
		setBalance(getBalance() - amount);
		return amount;
	}
	
	void test() {
		System.out.println(getAccNo());
		System.out.println(getOwner());
		System.out.println(getBalance());
		
		deposit(100);
		withdraw(100);
		
	}

}
