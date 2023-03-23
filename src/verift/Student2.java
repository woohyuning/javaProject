package verift;

import java.util.TreeSet;

// chap15-10-1
public class Student2 implements Comparable<Student2>{
	public String id;
	public int score;
	
	public Student2(String id, int score) {
		super();
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Student2 std) {
		// TODO Auto-generated method stub
		return score - std.score;
	}
}
