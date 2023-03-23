package exam;

public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[5];

		for (int i = 0; i < answer.length; i++) {
            counter[answer[i]]++;
        }

        for (int i = 1; i < counter.length; i++) {
            System.out.println(i + "의 갯수는 " + counter[i] + "개 입니다.");
        }

	}
}
