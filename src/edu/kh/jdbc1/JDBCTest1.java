package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest1 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			String user = "kh";
			
			String pw = "kh1234";
			
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("부서 코드를 입력하세요.");
			System.out.print("부서 코드 입력 : ");
			
			String input = sc.nextLine();
			
			String sql = "SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPARTMENT WHERE DEPT_ID = '" + input + "'";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");
				
				System.out.println(deptId + " " + deptTitle + " " + locationId);
			}
						
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
		}
	}

}
