package com.shinhan.day08;

import lombok.EqualsAndHashCode;

//23.03.03 8교시 2-1
//12장 LAB4
public class Prob1 {
	public static void main(String[] args) {
		Prob1 p1 = new Prob1();

		String input = "everyday we have is one more than we deserve";
		
		System.out.println("암호화할 문자열 : " + input);

		System.out.println("암호화된 문자열 : " + p1.caesarCipher(input));
	}
	
	private static String caesarCipher(String s) {
		String output = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c != ' ') {
				if((int)c > 119 || (int)c < 65) {
					output += (char)(c-23);
				} else {
					output += (char)(c+3);
				}
			} else {
				output += (char)c;
			}
		}
	
		return output;
	}
}
