package com.shinhan.day08;

import java.lang.reflect.Method;

//23.03.03 2교시 1-3
//12장-12 어노테이션
public class PrintAnnotationExample {
	public static void main(String[] args) throws Exception {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		for (Method method : declaredMethods) {
//			PrintAnnotation 얻기
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			System.out.println("[메서드이름]" + method.getName());

			System.out.println(printAnnotation.number());
			System.out.println(printAnnotation.value());
			System.out.println(printAnnotation.woohyun());
//			설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
//			메소드 호출
			method.invoke(new Service());
//			설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
		}
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
//			number 속성값 얻기
			int number = printAnnotation.number();
			for (int i = 0; i < number; i++) {
//				value 속성값 얻기
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
