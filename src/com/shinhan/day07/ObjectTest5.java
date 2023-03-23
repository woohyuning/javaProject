package com.shinhan.day07;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//23.03.02 7교시 1-1
//12장.10 문자열 클래스(정규 표현식 클래스) page.545
public class ObjectTest5 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f8();
	}

	private static void f8() {
		// TODO Auto-generated method stub

	}

//	12장.11 문자열 클래스(리소스 경로 얻기) page.552 -6
	private static void f7() throws IOException {
		InputStream is = ObjectTest5.class.getResourceAsStream("CellPhone.java");
		InputStreamReader ir = new InputStreamReader(is);
		int i;
		while ((i = ir.read()) != -1) {
			System.out.print((char) i);
		}
		is.close();

		URL url2 = ObjectTest5.class.getResource("cat.jpg");
		System.out.println(url2.getPath());
	}

//	12장.11 문자열 클래스(리소스 경로 얻기) page.552 -5
	private static void f6() throws IOException {
		FileReader fr = new FileReader("src/com/shinhan/day07/CellPhone.java");
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		fr.close();
	}

//	12장.11 문자열 클래스(리플랙션) page.547 -5
	private static void f5() throws ClassNotFoundException {
		Class cls1 = CellPhone.class;
		Class cls2 = Class.forName("com.shinhan.day07.CellPhone");
		CellPhone phone = new CellPhone("AA");
		Class cls3 = phone.getClass();

		Method[] method = cls1.getDeclaredMethods();
		for (Method m : method) {
			System.out.println(m.getName());
			System.out.println(m.getParameterCount() + "개 파라메터");
			System.out.println("------------------");
		}

//		Field[] fs = cls1.getDeclaredFields();
//		System.out.println(fs.length);
//		for(Field f : fs) {
//			System.out.println(f.getName());
//			System.out.println(f.getType().getSimpleName());
//			System.out.println();
//		}

//		Constructor[] constructors = cls1.getDeclaredConstructors();
//		for(Constructor con : constructors) {
//			System.out.println(con.getModifiers());
//		}

	}

//	12장.10 문자열 클래스(Pattern클래스로 검증) page.546 -4
	private static void f4() {
		String p1 = "([A-Za-z0-9]+)@(\\w+)\\.\\w+";
		String data = "연락처1 : wed0406@daum.net 연락처2 : aaa@naver.com 연락처3 : bbbb@google.com";
		Pattern pattern = Pattern.compile(p1);
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println("------------------");
		}
	}

//	12장.10 문자열 클래스(Pattern클래스로 검증) page.546 -3
	private static void f3() {
		String p1 = "010-([0-9]{3,4})-\\d{4}";
		String data = "010-1231-5678 이곳으로 연락바람 010-7865-6321 혹은 010-8888-7777";
		Pattern pattern = Pattern.compile(p1);
		Matcher matcher = pattern.matcher(data);
		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
			System.out.println("------------------");
		}
	}

//	12장.10 문자열 클래스(정규 표현식 클래스) page.545 -2
	private static void f2() {
		String p1 = "[A-Za-z0-9]+@\\w+\\.\\w+";
		String data = "wed0406@daum.net";
		boolean result = Pattern.matches(p1, data);
		System.out.println(result ? "OK" : "NO");
	}

//	12장.10 문자열 클래스(정규 표현식 클래스) page.545 -1
	private static void f1() {
		String p1 = "010-[0-9]{3,4}-\\d{4}";
		String data = "010-1231-5678";
		boolean result = Pattern.matches(p1, data);
		System.out.println(result ? "OK" : "NO");
	}
}
