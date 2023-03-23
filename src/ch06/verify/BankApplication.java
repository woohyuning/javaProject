package ch06.verify;

import java.util.Scanner;

public class BankApplication {
	public static Account[] accArray = new Account[100];
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("------------------------------------");
			System.out.println("선택> ");
			
			int inputNo = sc.nextInt();
			
			if(inputNo == 1) {
				creatAccount();
			}else if(inputNo == 2) {
				accountList();
			}else if(inputNo == 3) {
				deposit();
			}else if(inputNo == 4) {
				withdraw();
			}else if(inputNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private static Account findAccount(String accNo) {
		Account account = null;
		for(int i=0; i<accArray.length;i++) {
			if(accArray[i] != null) {
				String dbAccNo = accArray[i].getAccNo();
				if(dbAccNo.equals(accNo)) {
					account = accArray[i];
					break;
				}
			}
		}
		return account;
	}
	
	private static void creatAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		
		System.out.println("계좌번호: ");
		String accNo = sc.next();
		
		System.out.println("계좌주: ");
		String name = sc.next();
		
		System.out.println("초기입금액: ");
		int balance = sc.nextInt();
		
		Account newAccount = new Account(accNo, name, balance);
		
		for(int i=0; i<accArray.length;i++) {
			if(accArray[i] == null) {
				accArray[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		
		for(int i=0; i<accArray.length;i++) {
			Account account = accArray[i];
			if(account!=null) {
				System.out.println(account.getAccNo());
				System.out.println("   ");
				System.out.println(account.getName());
				System.out.println("   ");
				System.out.println(account.getBalance());
				System.out.println();
			}
		}
	}
	
	private static void deposit() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.println("계좌번호 : ");
		String accNo = sc.next();
		System.out.println("예금액 : ");
		int money = sc.nextInt();
		
		Account account = findAccount(accNo);
		if(account == null) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance() + money);
		System.out.println("결과 : 입금이 성공되었습니다.");
	}
	
	private static void withdraw() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.println("계좌번호 : ");
		String accNo = sc.next();
		System.out.println("예금액 : ");
		
		int money = sc.nextInt();
		Account account = findAccount(accNo);
		
		if(account == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance() - money);
		System.out.println("결과 : 출금이 성공되었습니다.");
	}
}