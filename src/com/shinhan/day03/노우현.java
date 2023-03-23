package com.shinhan.day03;

public class 노우현 {
	public static void main(String[] args) {
//		chap5Method6();
//		chap5Method7();
//		chap5Method8();
		chap5Method9();		
	}

	private static void chap5Method9() {
		// TODO Auto-generated method stub
		
	}

	private static void chap5Method8() {
		int sum = 0, count = 0;
		
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				count++;
			}
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/count);
	}

	private static void chap5Method7() {
		int[] array = {1, 5, 3, 8, 2};
		
		for( int arr : array ) {
			System.out.print(arr + ", ");
		}
//		for(int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + ", ");
//		}
	}

	private static void chap5Method6() {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		System.out.println(array.length);
		System.out.println(array[2].length);
	}
}
