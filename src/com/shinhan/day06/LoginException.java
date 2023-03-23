package com.shinhan.day06;

// 23.02.28 7교시 -1
// 11장-6 사용자 정의 예외 page 479
// 만드는 이유 : 업무상 Exception처리 일관성 있게 처리하기 위해 만든다.
// extends Exception
// extends 상위Exception
public class LoginException extends Exception {
	
	public LoginException(String errMsg) {
		super(errMsg);
	}
	
	public void printMsg() {
		System.out.println("로그인 : " + getMessage());
	}
}
