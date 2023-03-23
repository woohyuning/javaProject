package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
//23.03.08 4교시 2-1
//17장.3 중간 처리와 최종 처리 page.727
public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
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
	public int compareTo(Student std) {
		int result = score - std.score;
		if(result == 0) {
			return std.name.compareTo(name);
		}
		return result;
	}
}
