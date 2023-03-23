package LAB;

// 12장 LAB6
public class FindCharacters {
	public static void main(String[] args) {
		FindCharacters fc = new FindCharacters();
		int count1 = fc.countChar("Boys, be ambitious", 'b');
		int count2 = fc.countChar("aaa", 'a');
		int count3 = fc.countChar("bbb BB bbb BB", 'b');
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
	}

	public int countChar(String str, char c) {
		int count = 0;
		char[] result = str.toCharArray();
		for(int i = 0; i < result.length; i++) {
			if(result[i] == c) {
				count++;
			}
		}
		
		return count;
	}
}
