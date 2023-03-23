package verift;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// chap15-9
public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		for (Entry<String, Integer> key : map.entrySet()) {
			totalScore += key.getValue();
			if(maxScore < key.getValue()) {
				maxScore = key.getValue();
				name = key.getKey();
			}
		}
		int count = map.size();
		
		System.out.println("평균 점수 : " + totalScore/count);
		System.out.println("최고 점수 : " + maxScore );
		System.out.println("최고 점수를 받은 아이디 : " + name);
	}
}
