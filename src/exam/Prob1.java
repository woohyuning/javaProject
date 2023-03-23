package exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성100점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		String maxName = "";
		int maxScore = -1;
		for (String str : array) {
			String regExp = "([가-힣A-Za-z]+)([0-9]+)점";
			Pattern pat = Pattern.compile(regExp);
			Matcher mat = pat.matcher(str);
			if(mat.find()) {
				String name = mat.group(1);
				String score = mat.group(2);
				System.out.println(name + "--" +score );
				int iscore = Integer.parseInt(score);
				if(iscore > maxScore) {
					maxScore = iscore;
					maxName = name;
				}
			}
		}
		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
	}
}
	
//	private static void printMaxScore(String[] array) {
//		String name = "";
//		String score = "";
//		String maxName = "";
//		int maxScore = -1;
//
//		for (String str : array) {
//			char[] charArr = str.toCharArray();
//			for (char ch : charArr) {
//				if (Character.isDigit(ch)) {
//					score += ch;
//				} else {
//					name += ch;
//				}
//			}
//			int s = Integer.parseInt(score);
//			if(s > maxScore) {
//				maxScore = s;
//				maxName = name;
//			}
////	    	try {
////	        	String name = str.substring(0,3);
////	            int score = Integer.parseInt(str.substring(3,5));
////	            
////	            if (score > maxScore) {
////	                maxScore = score;
////	                maxName = name;
////	            }
////	    	} catch(NumberFormatException ex) {
////	    		
////	    	}
//		}
//
//		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
//	}
//}
