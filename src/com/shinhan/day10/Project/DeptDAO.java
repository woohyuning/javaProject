package com.shinhan.day10.Project;

import java.util.ArrayList;
import java.util.List;

// 23.03.07 7교시 1-2
// 프로젝트 예행연습
// DAO(Data Access Object)
// CRUD작업(Create, Read, Update, Delete)
public class DeptDAO {
	private List<DeptVO> data = new ArrayList<>();

	public List<DeptVO> selectAll() {
//		DB가서 data가져오기 code추가 될 예정
//		select * from departments;
		return data;
	}

//	부서의 번호를 찾아서 return하기	
	public DeptVO selectById(int deptid) {
		for (DeptVO dept : data) {
			if (dept.getDepartment_id() == deptid) {
				return dept;
			}
		}
		return null;
	}

	public void insert(DeptVO dept) {
		data.add(dept);
	}

}
