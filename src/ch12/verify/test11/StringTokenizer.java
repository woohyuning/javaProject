package ch12.verify.test11;

import java.io.UnsupportedEncodingException;

public class StringTokenizer {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = { -20, -107, -120, -21, -123, -107 };
		String str = new String(bytes, "UTF-8");
		System.out.println("str : " + str);
	}
}
