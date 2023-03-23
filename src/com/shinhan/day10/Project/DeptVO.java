package com.shinhan.day10.Project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
// 23.03.07 7교시 1-1
// 프로젝트 예행연습
public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
}
