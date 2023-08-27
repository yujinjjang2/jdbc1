package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc1.model.vo.Employee;

public class JDBCTest7 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
					
			String user = "kh";		
		
			String pw = "kh1234";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.print("JOB_CODE 입력 : ");
			String inputJobCode = sc.next();
			
			String sql = "SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') HIRE_DATE FROM EMPLOYEE WHERE JOB_CODE = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputJobCode);
			
			rs = pstmt.executeQuery();
			
			List<Employee> list = new ArrayList<Employee>();
			
			while(rs.next()) {
				
				Employee emp = new Employee();
				
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setHireDate(rs.getString("HIRE_DATE"));
				
				list.add( emp );
			}
			
			if(list.isEmpty()) {
				System.out.println("조회 결과가 없습니다.");
			}
			
			for(Employee emp : list) {
				System.out.println(emp.toString1());
			}
			
		} catch(Exception e) {
			e.printStackTrace();

		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
