package ch12.verify.test05;

import java.util.Objects;

public class Student {
	private String studnetNum;
	
	public Student(String stdentNum) {
		this.studnetNum = studnetNum;
	}
	public String getStudentNum() {
		return studnetNum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(studnetNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studnetNum, other.studnetNum);
	}
	
}
