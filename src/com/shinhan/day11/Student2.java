package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//23.03.08 7교시 3-1
//17장.12 요소 수집 page. 765
public class Student2 implements Comparable<Student2>{
	private String name;
	private int score;
	private String gender;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student 정보 [name=")
		.append(name)
		.append(", score=")
		.append(score)
		.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student2 std) {
		int result = score - std.score;
		if(result == 0) {
			return std.name.compareTo(name);
		}
		return result;
	}

	public Student2(String name, int score, String gender) {
		super();
		this.name = name;
		this.score = score;
		this.gender = gender;
	}
}
