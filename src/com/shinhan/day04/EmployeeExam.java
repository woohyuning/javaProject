package com.shinhan.day04;

// <2-2>
public class EmployeeExam {
	public static void main(String[] args) {
		Employee[] em = new Employee[4];
		em[0] = new Employee("이부장", "부장", 1500000);
		em[1] = new Employee("김과장", "과장", 1300000);
		em[2] = new Employee("최대리", "대리", 1200000);
		em[3] = new Employee("박사원", "사원", 1000000);
		
		for( Employee emp : em ) {
			emp.print();
		}
	}
}
