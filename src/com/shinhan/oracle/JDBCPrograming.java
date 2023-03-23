package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.shinhan.dbutil.OracleUtil;

// 230314 5교시 -1
public class JDBCPrograming {
	public static void main(String[] args) {
//		f1();
		f2();
	}

	private static void f2() {
		System.out.print("상사의 이름을 입력하세요>> ");
		Scanner sc = new Scanner(System.in);
		String ceo = sc.nextLine();
		Connection conn = null;
		PreparedStatement st = null;	// Statement <--- PreparedStatement
		ResultSet rs = null;
		String sql = """
				select *
				from employees
				where manager_id = any (
				        select employee_id
				        from employees
				        where last_name = ? )
				""";
		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql); // prepareStatement : ?를 지원
			st.setString(1, ceo);			 // 첫번째 ? 에 값을 setting
			rs = st.executeQuery();			 // prepared된 sql문을 실행한다.
			int count = 1;
			while (rs.next()) {
				int empid = rs.getInt(1);
				String fname = rs.getString(2);
				int sal = rs.getInt("salary");
				Date hdate = rs.getDate("hire_date");
				System.out.printf("%d\t%d\t%8s\t%d\t%s\t\n", count, empid, fname, sal, hdate);
//				System.out.println(count + "\t" + empid + "\t" + fname + "\t" + sal + "\t" + hdate);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
	}

	private static void f1() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = """
				select first_name 이름, department_id 부서번호, department_name 부서명, city 지역
				from employees join departments using(department_id)
				               join locations using(location_id)
				where job_id in (
				        select job_id
				        from jobs
				        where job_title like '%Manager%')
				""";
		try {
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String fname = rs.getString(1);
				int deptid = rs.getInt(2);
				String deptname = rs.getString(3);
				String city = rs.getString(4);
				System.out.printf("%s\t%d\t%10s\t%s\t\n", fname, deptid, deptname, city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
//		1. Driver load
//		2. DB연결
//		3. SQL문 보낼 통로 만들기
//		4. 결과받아서 이용한다
//		5. 자원반납
	}
}
