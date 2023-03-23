package com.shinhan.day03;

import java.util.Arrays;

public class ArrayLab {
	public static void main(String[] args) {
//		method1();
		
/*		배열 a    -      배열 b    	 =      배열 c
	30 30 30 30     1  2    3   4        29 28 27 26 
	40 40 40 40  -  5  6    7   8    =   35 34 33 32 
	50 50 50 50     9  10  11  12        41 40 39 38
*/
		int[][] arr1 = {{30, 30, 30, 30},{40, 40, 40, 40},{50, 50, 50, 50}};
		int[][] arr2 = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
		int[][] arr3 = new int [3][4];
		int[][] arr4 = sub(arr1, arr2, arr3);
		prn(arr1);
		System.out.println("---------------------------");
		prn(arr2);
		System.out.println("---------------------------");
		prn(arr3);
		System.out.println("---------------------------");
		prn(arr4);
	}
	
	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}
	
	public static void prn(int[][] d) {
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private static void method1() {
/*		[배열의 내용]
		3, 24, 1, 55, 17, 43, 5
		[클래스 실행결과]
		1, 3, 5, 17, 24, 43, 55 */

		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		System.out.println("원본 : " + Arrays.toString(arr));
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					// 바꾸기
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}
}
