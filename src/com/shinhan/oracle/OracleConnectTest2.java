package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 23.03.13 1교시 Oracle DB연결
// 23.03.13 2교시 Oracle DB연결
public class OracleConnectTest2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.print("조회하고자하는 직원이름>> ");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		
		String sql = "select first_name 이름, salary 급여, to_char(hire_date, 'yyyy/mm/dd') 입사일 "
				+ "from employees "
				+ "where first_name = initCap('" + inputName + "')";
//		1. driver load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. driver load 성공");
//		2. Connection
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String userId = "hr";
		String pw = "hr";
		Connection conn = DriverManager.getConnection(url, userId, pw);
		System.out.println("2. Connection 성공");
//		3. statement를 통해서 SQL전송
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getInt(2));
			System.out.println(rs.getString(3));
			System.out.println("------------------");
		}
		rs.close();
		st.close();
		conn.close();
	}
}