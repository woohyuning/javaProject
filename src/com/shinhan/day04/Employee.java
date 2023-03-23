package com.shinhan.day04;

import java.util.Objects;

// <2-1>
public class Employee implements Comparable<Employee> {
//	private String id;
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
	}

//	public Employee(String id, String name, int baseSalary) {
//		
//	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}

	private void getTotalSalary() {
		if (title.equals("부장")) {
			totalSalary = (int) (baseSalary + baseSalary * 0.25);
		} else if (title.equals("과장")) {
			totalSalary = (int) (baseSalary + baseSalary * 0.15);
		} else {
			totalSalary = (int) (baseSalary + baseSalary * 0.05);
		}
	}

	public void print() {
		getTotalSalary();
		System.out.println(title + " 직급의 " + name + "씨의 본봉은 " + baseSalary + " 원이고 총급여는 " + totalSalary + " 원입니다.");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", title=" + title + ", baseSalary=" + baseSalary + ", totalSalary="
				+ totalSalary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseSalary, name, title, totalSalary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return baseSalary == other.baseSalary && Objects.equals(name, other.name) && Objects.equals(title, other.title)
				&& totalSalary == other.totalSalary;
	}

	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		int result = name.compareTo(emp.name) * -1;
		int result2 = baseSalary - emp.baseSalary;
		if (result2 == 0) {
			return title.compareTo(emp.title);
		}
		if (result == 0) {
			return result2;
		}
		return result;
	}
}
