package com.shinhan.day10.Project;

import java.util.List;

// 23.03.07 7교시 1-3
// 프로젝트 예행연습
// Service : Controller가 요청한 정보를 DAO로 전달
//           DAO에서 응답받은 내용을 Controller에게 전달
// DB 상관없는 Business logic 수행
public class DeptService {
	private DeptDAO dao = new DeptDAO();
	
	public List<DeptVO> selectAll() {
		return dao.selectAll();
	}
	public DeptVO selectById(int deptid) {
		return dao.selectById(deptid);
	}
	public void insert(DeptVO dept) {
		dao.insert(dept);
	}
}
