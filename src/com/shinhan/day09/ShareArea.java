package com.shinhan.day09;

//import lombok.AllArgsConstructor;

//23.03.06 5교시 1-2
//14.6 스레드 동기화 page.612
// 공유자원으로 이용 할 class
// 2개의 계좌가 있다
//@AllArgsConstructor
public class ShareArea {
	Account sung;
	Account lee;
	
	public ShareArea(Account sung, Account lee) {
		super();
		this.sung = sung;
		this.lee = lee;
	}
	void transfer() {
//		synchronized block 이용
		synchronized (this) {
//			출금한다.
			int amount = lee.withdraw(100);
			System.out.println("lee계좌에서 " + amount + "출금");
//			입금한다.
			sung.deposit(amount);
			System.out.println("sung계좌에서 " + amount + "입금");
		}
	}
	
//	메서드의 활용방법 이용 : synchronized 
	synchronized void printBalance() {
//		잔액출력
		System.out.println("잔액 : " + (lee.getBalance() + sung.getBalance()));
	}
}
