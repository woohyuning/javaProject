package aProject.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import aProject.model.EmpService;
import aProject.view.EmpView;
import aProject.vo.EmpVO;

public class EmpController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpService empService = new EmpService();

		while (true) {
			System.out.println("1. 전체직원조회");
			System.out.println("2. 직원상세");
			System.out.println("3. 부서의직원");
			System.out.println("4. 부서,직책,급여로 조회");
			System.out.println("5. 부서의 평균급여 이하를 받는 직원 조회");

			System.out.println("6. 신규직원등록");
			System.out.println("7. 직원정보수정");
			System.out.println("8. 직원정보삭제");
			System.out.println("9. 직원급여조회(SP)");
			System.out.println("exit 종료");
			System.out.print("작업선택>> ");
//			nextLine(1줄 enter포함)
//			next(), nextInt() (공백분리한 단어)
			String input = sc.next();
			if (input.equals("exit"))
				break;
			switch (input) {
			case "1":
				EmpView.print(empService.selectAll());
				break;
			case "2": {
				System.out.print("조회할 직원번호>> ");
				int empid = sc.nextInt();
				EmpView.print(empService.selectById(empid));
				break;
			}
			case "3": {
				System.out.print("조회할 부서번호>> ");
				int deptid = sc.nextInt();
				EmpView.print(empService.selectByDept(deptid));
				break;
			}
			case "4": {
				System.out.print("조회할 부서번호,job, salary>> ");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				double salary = sc.nextDouble();
				EmpView.print(empService.selectByCondition(deptid, jobid, salary));
				break;
			}
			case "5": {
				List<EmpVO> empList = empService.selectLAB();
				System.out.println("[EmpService] 5번작업 : " + empList.size());
				EmpView.print(empList);
				break;
			}
			case "6": {
				EmpVO emp = makeEmp(sc);
				EmpView.print(empService.empInsert(emp));
				break;
			}
			case "7": {
				System.out.print("--수정할 직원ID >> ");
				int empid = sc.nextInt();
				EmpView.print(empService.selectById(empid));
				EmpVO emp = makeEmp2(sc, empid);
				EmpView.print(empService.empUpdate(emp));
				break;
			}
			case "8": {
				System.out.print("--삭제할 직원ID >> ");
				int empid = sc.nextInt();
				EmpView.print(empService.selectById(empid));
				System.out.print("삭제를 계속진행(Y/N)?");
				String yn = sc.next();
				if(yn.equals("Y")) {
					EmpView.print(empService.empDelete(empid));
				} else System.out.println("Delete실패");
				break;
			}
			case "9": {
				System.out.print("조회할 직원번호>> ");
				int empid = sc.nextInt();
				EmpView.print("급여는 " + empService.getSalary(empid));
				break;
			}
			case "exit":
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static EmpVO makeEmp(Scanner sc) {
		System.out.print("신규직원의 First_name >> ");
		String firstName = sc.next();
		System.out.print("신규직원의 Last_name >> ");
		String lastName = sc.next();
		System.out.print("신규직원의 email >> ");
		String email = sc.next();
		System.out.print("신규직원의 phone_number >> ");
		String phone = sc.next();
		System.out.print("신규직원의 입사일(yyyy/mm/dd) >> ");
		String sdate = sc.next();
//		String -> Date
		Date hiredate = DateUtil.convertToDate(sdate);
		System.out.print("신규직원의 jobid >> ");
		String jobid = sc.next();
		System.out.print("신규직원의 salary >> ");
		double salary = sc.nextInt();
		System.out.print("신규직원의 commmission >> ");
		double commmission = sc.nextDouble();
		System.out.print("신규직원의 manager >> ");
		int managerid = sc.nextInt();
		System.out.print("신규직원의 dept >> ");
		int deptid = sc.nextInt();

		EmpVO emp = new EmpVO();
		emp.setFirst_name(firstName);
		emp.setLast_name(lastName);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setHire_date(hiredate);
		emp.setJob_id(jobid);
		emp.setSalary(salary);
		emp.setCommission_pct(commmission);
		emp.setManager_id(managerid);
		emp.setDepartment_id(deptid);
		
		return emp;
	}
	private static EmpVO makeEmp2(Scanner sc, int empid) {
		System.out.print("1. 직원의 email >> ");
		String email = sc.next();
		System.out.print("2. 직원의 jobid >> ");
		String jobid = sc.next();
		System.out.print("3. 직원의 dept >> ");
		int deptid = sc.nextInt();
		System.out.print("4. 직원의 salary >> ");
		Double salary = sc.nextDouble();
		System.out.print("5. 직원의 입사일(yyyy/mm/dd) >> ");
		String sdate = sc.next();
//		String -> Date
		Date hiredate = DateUtil.convertToDate(sdate);
		System.out.print("6. 직원의 manager >> ");
		int managerid = sc.nextInt();
		
		EmpVO emp = new EmpVO();
		emp.setEmployee_id(empid);
		emp.setEmail(email);
		emp.setJob_id(jobid);
		emp.setDepartment_id(deptid);
		emp.setSalary(salary);
		emp.setHire_date(hiredate);
		emp.setManager_id(managerid);
		
		return emp;
	}
}
