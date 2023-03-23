package com.shinhan.day06;

//23.02.28 7교시 -3
//LAB 11
class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
		try {
			int result2 = game.countSameEye(-10);
			System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	int countSameEye(int n) {
//		구현
		if (n < 0) {
			throw new IllegalArgumentException("던지는 횟수는 음수 불가");
		}

		Dice dice1 = new Dice(8);
		Dice dice2 = new Dice(8);
		int count = 0;

		for (int i = 0; i <= n; i++) {
			int a = dice1.play();
			int b = dice2.play();

			System.out.println(a + "---" + b);

			if (a == b) {
				count++;
			}
		}
		return count;
	}
}
