package ch12.verify.test09;

import java.util.StringTokenizer;

public class DecodingExample {
	public static void main(String[] args) {
		String s1 = "아이디,이름,패스워드";
		StringTokenizer st = new StringTokenizer(s1, ",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}

}
