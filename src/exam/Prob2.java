package exam;

public class Prob2 {
	public static void main(String[] args) {
			System.out.println(leftPad("Samsung", 10, '#'));
			System.out.println(leftPad("SDS", 5, '*'));
			System.out.println(leftPad("Multicampus", 5, '@'));
	}

	public static String leftPad(String str, int size, char fillChar) {
		StringBuilder sb = new StringBuilder();
		try {
			if (str.length() >= size)
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			{
				return str;
			}
			
		} catch (IllegalSizeException ex) {
			System.out.println(ex.getMessage());
		}
		for (int i = 0; i < size - str.length(); i++) {
			sb.append(fillChar);
		}
		sb.append(str);

		return sb.toString();
		
	}

}

//구현하시오.
class IllegalSizeException extends Exception {
	IllegalSizeException(String message) {
		super(message);
	}
}
